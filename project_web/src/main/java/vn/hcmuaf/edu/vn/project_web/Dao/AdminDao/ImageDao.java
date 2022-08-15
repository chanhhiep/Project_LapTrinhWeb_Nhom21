package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Image;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ImageDao {
    private static ImageDao instance=null;
    public ImageDao(){
        //do nothing
    }
    public static ImageDao getInstance(){
        if(instance==null){
            instance=new ImageDao();
        }
        return instance;
    }
    public List<Image> getAllImage(){
        List<Image> result = new ArrayList<Image>();
        String sql  = "select image_id,image_link,create_date,update_date " +
                "FROM image";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Image(rs.getString("image_id"),rs.getString("image_link"),rs.getTimestamp("create_date"),rs.getInt("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveImage(String image_id, String image_link){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        int update_date =1;
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into image(image_id,image_link,create_date,update_date) values(?,?,?,?)")
                        .bind(0,image_id)
                        .bind(1,image_link)
                        .bind(2,createDate)
                        .bind(3,update_date)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdateImageById(String image_id, String image_link){
        int updateDate = 1;
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update image " +
                                "set image_link=?, update_date=?" +
                                "where image_id=?")
                        .bind(0,image_link)
                        .bind(1,updateDate)
                        .bind(2,image_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteImageById(String image_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from image where image_id = ?")
                        .bind(0,image_id)
                        .execute()
        );
        return i==1;
    }
}
