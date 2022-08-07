package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Product;
import vn.hcmuaf.edu.vn.project_web.beans.Receipt;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReceiptDao {
    private static ReceiptDao instance=null;
    public ReceiptDao(){
        //do nothing
    }
    public static ReceiptDao getInstance(){
        if(instance==null){
            instance=new ReceiptDao();
        }
        return instance;
    }
    public List<Receipt> getAllReceipt(){
        List<Receipt> result = new ArrayList<Receipt>();
        String sql  = "select a.receipt_id,a.customer_id,b.customer_name,a.discountcode_id,d.rate,a.payment_id" +
                ",a.value,a.state,a.create_date,a.update_date " +
                "FROM customer b JOIN receipt a on b.customer_id = a.customer_id " +
                "JOIN discountcode d on a.discountcode_id=d.discountcode_id ";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Receipt(rs.getString("receipt_id"), rs.getString("customer_id")
                          ,rs.getString("customer_name"),rs.getString("discountcode_id")
                          ,rs.getDouble("rate"),rs.getString("payment_id")
                          ,rs.getDouble("value")
                          ,rs.getInt("state"),rs.getTimestamp("create_date")
                          ,rs.getTimestamp("update_date")
                ));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveReceipt(String receipt_id,String customer_id,String discountcode_id,String payment_id,double value){
        int state = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into receipt(receipt_id,customer_id,discountcode_id,payment_id,value,state,create_date,update_date) values(?,?,?,?,?,?,?,?)")
                        .bind(0,receipt_id)
                        .bind(1,customer_id)
                        .bind(2,discountcode_id)
                        .bind(3,payment_id)
                        .bind(4,value)
                        .bind(5,state)
                        .bind(6,createDate)
                        .bind(7,updateDate)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdateReceiptById(String receipt_id,String customer_id,String discountcode_id,String payment_id,double value,int state){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update receipt " +
                                "set customer_id=?,discountcode_id=?,payment_id=?,value=?,state=?,update_date=? " +
                                "where receipt_id=?")
                        .bind(0,customer_id)
                        .bind(1,discountcode_id)
                        .bind(2,payment_id)
                        .bind(3,value)
                        .bind(4,state)
                        .bind(5,updateDate)
                        .bind(6,receipt_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteReceiptById(String receipt_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from receipt where receipt_id = ?")
                        .bind(0,receipt_id)
                        .execute()
        );
        return i==1;
    }
}
