package vn.hcmuaf.edu.vn.project_web.Dao.MainDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class UserDao {
    private static UserDao instance=null;
    public UserDao(){
        //do nothing
    }
    public static UserDao getInstance(){
        if(instance==null){
            instance=new UserDao();
        }
        return instance;
    }
    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe
    public String generateId(){
        String result=UUID.randomUUID().toString();
        return result;
    }
    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    public static User CheckLogin(String username,String password) {

        List<User> usersList = new ArrayList<User>();
        ResultSet rs = null;
        try {
            Connection conn = DBConnect.getInstance().getConn();
            PreparedStatement statement = conn.prepareStatement("select * from user where user_name = ?");
            statement.setString(1,username);
            rs = statement.executeQuery();
            while(rs.next()){
                usersList.add(new User(rs.getString("user_id"),rs.getString("user_name"),rs.getString("password"),rs.getString("role"),rs.getString("email"),rs.getString("customer_id"),rs.getInt("active"),rs.getString("token")));
            }
            rs.close();
            System.out.println(usersList.get(0));
            if(usersList.size()!=1)return null;
            User user = usersList.get(0);
            System.out.println("success prepare");
            if(!user.getUsername().equals(username) || !user.getPassword().equals(hashPassword(password))) return null;
            System.out.println("success");
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean Register(String user_name, String password,String customer_name, String email, String phone, String address) {
        int active = 0;
        String role= "customer";
        String token = generateNewToken();
        String user_id = generateId();
        String customer_id = generateId();
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int c = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into customer(customer_id,customer_name,email,phone,address,create_date,update_date) values(?,?,?,?,?,?,?)")
                        .bind(0,customer_id)
                        .bind(1,customer_name)
                        .bind(2,email)
                        .bind(3,phone)
                        .bind(4,address)
                        .bind(5,createDate)
                        .bind(6,updateDate)
                        .execute()
        );
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into user(user_id,user_name,password,email,role,token,customer_id,active,create_date,update_date) values(?,?,?,?,?,?,?,?,?,?)")
                        .bind(0,user_id)
                        .bind(1,user_name)
                        .bind(2,hashPassword(password))
                        .bind(3,email)
                        .bind(4,role)
                        .bind(5,token)
                        .bind(6,customer_id)
                        .bind(7,active)
                        .bind(8,createDate)
                        .bind(9,updateDate)
                        .execute()
        );
        System.out.println("register success");
        return i==1 && c==1;
    }
    public static String hashPassword(String password){
        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            byte[] hash = sha256.digest(password.getBytes(StandardCharsets.UTF_8));
            BigInteger number = new BigInteger(1, hash);
            return  number.toString(16);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }
    public Boolean updateUserPassword(String user_id, String password)
    {
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update user " +
                                "set password=? " +
                                "where user_id=?")
                        .bind(0,password)
                        .bind(1,user_id)
                        .execute()
        );
        return i==1;
    }
    public Boolean checkOldPassword(String password, String dbpasword)
    {
        if(hashPassword(password).equals(dbpasword)){
            return true;
        }
        return false;
    }
    public Boolean activeUser(String token)
    {
        int active = 1;
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update user set active=? where token=?")
                        .bind(0,active)
                        .bind(1,token)
                        .execute()
        );
        return i==1;
    }
    public String getToken(String email) {

        List<String> tokenList = new ArrayList<String>();
        String sql  = "select token from user where email=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,email);
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                tokenList.add(rs.getString("token"));
            }
            rs.close();
            if (tokenList.size() != 1) return null;
            String token = tokenList.get(0);
            return token;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public Customer getCustomerById(String customer_id){
        List<Customer> customersList = new ArrayList<Customer>();
        ResultSet rs = null;
        try {
            Connection conn = DBConnect.getInstance().getConn();
            PreparedStatement statement = conn.prepareStatement("select * from customer where customer_id = ?");
            statement.setString(1,customer_id);
            rs = statement.executeQuery();
            while(rs.next()){
                customersList.add(new Customer(rs.getString("customer_id"),rs.getString("customer_name"),rs.getString("email"),rs.getString("phone"),rs.getString("address"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            rs.close();
            System.out.println(customersList.get(0));
            if(customersList.size()!=1)return null;
            Customer customer = customersList.get(0);
            System.out.println("success prepare");
            if(!customer.getCustomer_id().equals(customer_id) ) return null;
            System.out.println("success");
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean UpdateCustomer(String customer_id, String customer_name,String email,String phone, String address){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update customer " +
                                "set customer_name=?, email=?,phone=?,address=?, update_date=? " +
                                "where customer_id=?")
                        .bind(0,customer_name)
                        .bind(1,email)
                        .bind(2,phone)
                        .bind(3,address)
                        .bind(4,updateDate)
                        .bind(5,customer_id)
                        .execute()
        );
        return i==1;

    }
}
