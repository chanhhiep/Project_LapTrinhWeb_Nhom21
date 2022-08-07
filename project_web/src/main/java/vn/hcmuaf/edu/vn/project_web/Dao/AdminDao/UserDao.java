package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.User;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.*;
import java.util.*;
import java.util.Date;

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

    public static String generateNewToken() {
        byte[] randomBytes = new byte[24];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
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
    public List<User> getAllUser(){
        List<User> result = new ArrayList<User>();
        String sql  = "select user_id,user_name,password,role,email,customer_id,active,token " +
                "FROM user";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new User(rs.getString("user_id"),rs.getString("user_name"),rs.getString("password"),rs.getString("role"),rs.getString("email"),rs.getString("customer_id"),rs.getInt("active"),rs.getString("token")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveUser(String user_name,String password,String email,String customer_id){
        int active = 1;
        String role= "admin";
        String token = generateNewToken();
        String user_id = UUID.randomUUID().toString();
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
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
        return i==1;
    }
    public boolean UpdateUserById(String user_id,String user_name,String password,String role,String email,String customer_id,int active){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update user " +
                                "set user_name=?, password=?, email=?,role=?,customer_id=?,active=?, update_date=? " +
                                "where user_id=?")
                        .bind(0,user_name)
                        .bind(1,password)
                        .bind(2,email)
                        .bind(3,role)
                        .bind(4,customer_id)
                        .bind(5,active)
                        .bind(6,updateDate)
                        .bind(7,user_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteUserById(String user_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from user where user_id = ?")
                        .bind(0,user_id)
                        .execute()
        );
        return i==1;
    }
}
