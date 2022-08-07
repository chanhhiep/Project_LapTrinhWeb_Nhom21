package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerDao {
    private static CustomerDao instance=null;
    public CustomerDao(){
        //do nothing
    }
    public static CustomerDao getInstance(){
        if(instance==null){
            instance=new CustomerDao();
        }
        return instance;
    }
    public List<Customer> getAllCustomer(){
        List<Customer> result = new ArrayList<Customer>();
        String sql  = "select customer_id,customer_name,email,phone,address,create_date,update_date " +
                "FROM customer";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Customer(rs.getString("customer_id"),rs.getString("customer_name"),rs.getString("email"),rs.getString("phone"),rs.getString("address"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveCustomer(String customer_id, String customer_name,String email,String phone, String address){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
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
        return i==1;
    }
    public boolean UpdateCustomerById(String customer_id, String customer_name,String email,String phone, String address){
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
    public boolean DeleteCustomerById(String customer_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from customer where customer_id = ?")
                        .bind(0,customer_id)
                        .execute()
        );
        return i==1;
    }
}
