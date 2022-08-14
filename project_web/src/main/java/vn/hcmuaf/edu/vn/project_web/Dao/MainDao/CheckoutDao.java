package vn.hcmuaf.edu.vn.project_web.Dao.MainDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;
import vn.hcmuaf.edu.vn.project_web.beans.Coupon;
import vn.hcmuaf.edu.vn.project_web.beans.Customer;
import vn.hcmuaf.edu.vn.project_web.beans.PaymentMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CheckoutDao {
    private static CheckoutDao instance=null;
    public CheckoutDao(){
        //do nothing
    }
    public static CheckoutDao getInstance(){
        if(instance==null){
            instance=new CheckoutDao();
        }
        return instance;
    }
    public String generateId(){
        String result= UUID.randomUUID().toString();
        return result;
    }
    public boolean SaveReceiptNotLogin(String coupon_id, String payment_id, double value, String customer_name, String address, String phone, String email, List<CartItem> listBuy) {
        int state = 1;
        String receipt_id = generateId();
        String customer_id = generateId();
        String color_id = "c01";
        String size_id = "size01";
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());

        int c = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into customer(customer_id,customer_name,email,phone,address,create_date,update_date) values(?,?,?,?,?,?,?)")
                        .bind(0, customer_id)
                        .bind(1, customer_name)
                        .bind(2, email)
                        .bind(3, phone)
                        .bind(4, address)
                        .bind(5, createDate)
                        .bind(6, updateDate)
                        .execute()
        );

        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into receipt(receipt_id,customer_id,discountcode_id,payment_id,value,state,create_date,update_date) values(?,?,?,?,?,?,?,?)")
                        .bind(0, receipt_id)
                        .bind(1, customer_id)
                        .bind(2, coupon_id)
                        .bind(3, payment_id)
                        .bind(4, value)
                        .bind(5, state)
                        .bind(6, createDate)
                        .bind(7, updateDate)
                        .execute()
        );

        int b = 0;
        for (CartItem item : listBuy) {
            b = jdbiConnector.get().withHandle(handle ->
                    handle.createUpdate("insert into receiptdetail(receipt_id,product_id,quantity,color_id,size_id,create_date,update_date) values(?,?,?,?,?,?,?)")
                            .bind(0, receipt_id)
                            .bind(1, item.getCart_product().product_id)
                            .bind(2, item.cart_product.quantitySold)
                            .bind(3, color_id)
                            .bind(4, size_id)
                            .bind(5, createDate)
                            .bind(6, updateDate)
                            .execute()
            );
        }
        return i == 1 && c == 1 && b == 1;
    }
    public boolean SaveReceiptLogin(String coupon_id, String payment_id, double value, String customer_id, List<CartItem> listBuy){
        int state = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        String color_id = "c01";
        String size_id = "size01";
        String receipt_id = generateId();

        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into receipt(receipt_id,customer_id,discountcode_id,payment_id,value,state,create_date,update_date) values(?,?,?,?,?,?,?,?)")
                        .bind(0, receipt_id)
                        .bind(1, customer_id)
                        .bind(2, coupon_id)
                        .bind(3, payment_id)
                        .bind(4, value)
                        .bind(5, state)
                        .bind(6, createDate)
                        .bind(7, updateDate)
                        .execute()
        );
        int b = 0;
        for (CartItem item : listBuy) {
            b = jdbiConnector.get().withHandle(handle ->
                    handle.createUpdate("insert into receiptdetail(receipt_id,product_id,quantity,color_id,size_id,create_date,update_date) values(?,?,?,?,?,?,?)")
                            .bind(0, receipt_id)
                            .bind(1, item.getCart_product().product_id)
                            .bind(2, item.cart_product.quantitySold)
                            .bind(3, color_id)
                            .bind(4, size_id)
                            .bind(5, createDate)
                            .bind(6, updateDate)
                            .execute()
            );
        }
        return i==1 && b==1;
    }
    public Coupon getCoupon(String coupon_id){

        List<Coupon> listCouponId = new ArrayList<Coupon>();
        String sql = "select discountcode_id,content,rate,create_date,update_date from discountcode where discountcode_id=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,coupon_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                listCouponId.add(new Coupon(rs.getString("discountcode_id"),rs.getString("content"),rs.getDouble("rate"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            rs.close();
            if (listCouponId.size() != 1) return null;
            Coupon coupon = listCouponId.get(0);
            return coupon;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    public List<PaymentMethod> getPaymentMethod(){
        List<PaymentMethod> result = new ArrayList<PaymentMethod>();
        String sql  = "select payment_id,payment_name,create_date,update_date " +
                "FROM payment";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new PaymentMethod(rs.getString("payment_id"),rs.getString("payment_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }
    public Customer getCustomerById(String customer_id){
        List<Customer> result = new ArrayList<Customer>();
        String sql  = "select customer_id,customer_name,email,phone,address,create_date,update_date " +
                "FROM customer where customer_id=?";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1,customer_id);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Customer(rs.getString("customer_id"),rs.getString("customer_name"),rs.getString("email"),rs.getString("phone"),rs.getString("address"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            rs.close();
            if (result.size() != 1) return null;
            Customer customer = result.get(0);
            return customer;
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }
    }
}
