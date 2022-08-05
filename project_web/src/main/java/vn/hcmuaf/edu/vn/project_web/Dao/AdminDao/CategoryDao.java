package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Category;
import vn.hcmuaf.edu.vn.project_web.beans.PaymentMethod;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryDao {
    private static CategoryDao instance=null;
    public CategoryDao(){
        //do nothing
    }
    public static CategoryDao getInstance(){
        if(instance==null){
            instance=new CategoryDao();
        }
        return instance;
    }
    public List<Category> getAllCategoryDao(){
        List<Category> result = new ArrayList<Category>();
        String sql  = "select category_id,category_name,create_date,update_date " +
                "FROM category";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Category(rs.getString("category_id"),rs.getString("category_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveCategory(String category_id, String category_name){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into category(category_id,category_name,create_date,update_date) values(?,?,?,?)")
                        .bind(0,category_id)
                        .bind(1,category_name)
                        .bind(2,createDate)
                        .bind(3,updateDate)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdateCategoryById(String category_id, String category_name){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update category " +
                                "set category_name=?, update_date=?" +
                                "where category_id=?")
                        .bind(0,category_name)
                        .bind(1,updateDate)
                        .bind(2,category_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteCategoryById(String category_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from category where category_id = ?")
                        .bind(0,category_id)
                        .execute()
        );
        return i==1;
    }
}
