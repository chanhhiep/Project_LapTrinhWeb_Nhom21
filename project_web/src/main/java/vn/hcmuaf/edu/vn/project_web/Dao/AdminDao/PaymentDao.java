package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.PaymentMethod;
import vn.hcmuaf.edu.vn.project_web.beans.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaymentDao {
    private static PaymentDao instance=null;
    public PaymentDao(){
        //do nothing
    }
    public static PaymentDao getInstance(){
        if(instance==null){
            instance=new PaymentDao();
        }
        return instance;
    }
    public List<PaymentMethod> getAllPayment(){
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

    public boolean SavePayment(String payment_id, String payment_name){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into payment(payment_id,payment_name,create_date,update_date) values(?,?,?,?)")
                        .bind(0,payment_id)
                        .bind(1,payment_name)
                        .bind(2,createDate)
                        .bind(3,updateDate)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdatePaymentById(String payment_id, String payment_name){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update payment " +
                                "set payment_name=?, update_date=?" +
                                "where payment_id=?")
                        .bind(0,payment_name)
                        .bind(1,updateDate)
                        .bind(2,payment_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeletePaymentById(String payment_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from payment where payment_id = ?")
                        .bind(0,payment_id)
                        .execute()
        );
        return i==1;
    }
}
