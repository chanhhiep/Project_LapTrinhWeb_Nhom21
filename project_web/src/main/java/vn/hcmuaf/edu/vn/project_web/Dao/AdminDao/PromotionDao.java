package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Promotion;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PromotionDao {
    private static PromotionDao instance=null;
    public PromotionDao(){
        //do nothing
    }
    public static PromotionDao getInstance(){
        if(instance==null){
            instance=new PromotionDao();
        }
        return instance;
    }
    public List<Promotion> getAllPromotion(){
        List<Promotion> result = new ArrayList<Promotion>();
        String sql  = "select promotion_id,promotion_name,promotion_rate,promotion_content,active,create_date,update_date " +
                "FROM promotion";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Promotion(rs.getString("promotion_id"),rs.getString("promotion_name"),rs.getDouble("promotion_rate"),rs.getString("promotion_content"),rs.getInt("active"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SavePromotion(String promotion_id, String promotion_name,double promotion_rate, String promotion_content){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into promotion(promotion_id,promotion_name,promotion_rate,promotion_content,active,create_date,update_date) values(?,?,?,?,?,?,?)")
                        .bind(0,promotion_id)
                        .bind(1,promotion_name)
                        .bind(2,promotion_rate)
                        .bind(3,promotion_content)
                        .bind(4,active)
                        .bind(5,createDate)
                        .bind(6,updateDate)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdatePromotionById(String promotion_id, String promotion_name,double promotion_rate, String promotion_content,int active){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update promotion " +
                                "set promotion_name=?, promotion_rate=?,promotion_content=?,active=?, update_date=?" +
                                "where promotion_id=?")
                        .bind(0,promotion_name)
                        .bind(1,promotion_rate)
                        .bind(2,promotion_content)
                        .bind(3,active)
                        .bind(4,updateDate)
                        .bind(5,promotion_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeletePromotionById(String promotion_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from promotion where promotion_id = ?")
                        .bind(0,promotion_id)
                        .execute()
        );
        return i==1;
    }
}
