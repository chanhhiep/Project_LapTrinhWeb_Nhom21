package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Color;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ColorDao {
    private static ColorDao instance=null;
    public ColorDao(){
        //do nothing
    }
    public static ColorDao getInstance(){
        if(instance==null){
            instance=new ColorDao();
        }
        return instance;
    }
    public List<Color> getAllColor(){
        List<Color> result = new ArrayList<Color>();
        String sql  = "select color_id,color_name,create_date,update_date " +
                "FROM color";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Color(rs.getString("color_id"),rs.getString("color_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveColor(String color_id, String color_name){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into color(color_id,color_name,create_date,update_date) values(?,?,?,?)")
                        .bind(0,color_id)
                        .bind(1,color_name)
                        .bind(2,createDate)
                        .bind(3,updateDate)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdateColorById(String color_id, String color_name){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update color " +
                                "set color_name=?, update_date=?" +
                                "where color_id=?")
                        .bind(0,color_name)
                        .bind(1,updateDate)
                        .bind(2,color_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteColorById(String color_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from color where color_id = ?")
                        .bind(0,color_id)
                        .execute()
        );
        return i==1;
    }
}
