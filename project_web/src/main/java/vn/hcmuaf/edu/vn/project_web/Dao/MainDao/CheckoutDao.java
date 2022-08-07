package vn.hcmuaf.edu.vn.project_web.Dao.MainDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.CartItem;
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
        int b = 0;
        for (CartItem item : listBuy) {
            b = jdbiConnector.get().withHandle(handle ->
                    handle.createUpdate("insert into receiptdetail(receipt_id,product_id,quantity,color_id,size_id,create_date,update_date) values(?,?,?,?,?,?,?)")
                            .bind(0, receipt_id)
                            .bind(1, item.getCart_product().product_id)
                            .bind(2, item.cart_product.quantitySold)
                            .bind(3, item.cart_product.color_id)
                            .bind(4, item.cart_product.size_id)
                            .bind(5, createDate)
                            .bind(6, updateDate)
                            .execute()
            );
        }
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
        return i == 1 && c == 1 && b == 1;
    }
    public boolean SaveReceiptLogin(String coupon_id, String payment_id, double value, String customer_id, List<CartItem> listBuy){
        int state = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        String receipt_id = generateId();
        int b = 0;
        for (CartItem item : listBuy) {
            b = jdbiConnector.get().withHandle(handle ->
                    handle.createUpdate("insert into receiptdetail(receipt_id,product_id,quantity,color_id,size_id,create_date,update_date) values(?,?,?,?,?,?,?)")
                            .bind(0, receipt_id)
                            .bind(1, item.getCart_product().product_id)
                            .bind(2, item.cart_product.quantitySold)
                            .bind(3, item.cart_product.color_id)
                            .bind(4, item.cart_product.size_id)
                            .bind(5, createDate)
                            .bind(6, updateDate)
                            .execute()
            );
        }
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
        return i==1 && b==1;
    }
    public String getCoupon(String coupon_id){
        /*
        * List<string> listCouponId = new List<string>();
            string sql = "select id_magg from magiamgia where id_magg=@id_magg";
            MySqlCommand command = new MySqlCommand();
            MySqlConnection connect = KetNoi.GetDBConnection();
            connect.Open();
            command.Connection = connect;
            command.CommandText = sql;
            command.Prepare();
            command.Parameters.AddWithValue("@id_magg", couponId);
            using (DbDataReader reader = command.ExecuteReader())
            {
                while (reader.Read())
                {
                    listCouponId.Add(reader.GetString(0));
                }
                reader.Close();
                //Console.WriteLine(usersList[0]);
                if (listCouponId.Count != 1) return null;
                string coupon = listCouponId[0];

                //if (!user.userName.Equals(username) || verify(user.password, password) == false) return null;
                return coupon;
            }
            * */
         return "";
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
}
