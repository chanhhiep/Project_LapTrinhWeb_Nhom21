package vn.hcmuaf.edu.vn.project_web.Dao.AdminDao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;
import vn.hcmuaf.edu.vn.project_web.Database.jdbiConnector;
import vn.hcmuaf.edu.vn.project_web.beans.Size;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SizeDao {
    private static SizeDao instance=null;
    public SizeDao(){
        //do nothing
    }
    public static SizeDao getInstance(){
        if(instance==null){
            instance=new SizeDao();
        }
        return instance;
    }
    public List<Size> getAllSize(){
        List<Size> result = new ArrayList<Size>();
        String sql  = "select size_id,size_name,create_date,update_date " +
                "FROM size";
        try {
            Connection conn = DBConnect.getInstance().getConn();
            System.out.println("success");
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                result.add(new Size(rs.getString("size_id"),rs.getString("size_name"),rs.getTimestamp("create_date"),rs.getTimestamp("update_date")));
            }
            System.out.println("et o et");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    public boolean SaveSize(String size_id, String size_name){
        int active = 1;
        Timestamp createDate = new Timestamp(new java.util.Date().getTime());
        Timestamp updateDate = new Timestamp(new java.util.Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("insert into size(size_id,size_name,create_date,update_date) values(?,?,?,?)")
                        .bind(0,size_id)
                        .bind(1,size_name)
                        .bind(2,createDate)
                        .bind(3,updateDate)
                        .execute()
        );
        return i==1;
    }
    public boolean UpdateSizeById(String size_id, String size_name){
        Timestamp updateDate = new Timestamp(new Date().getTime());
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("update size " +
                                "set size_name=?, update_date=?" +
                                "where size_id=?")
                        .bind(0,size_name)
                        .bind(1,updateDate)
                        .bind(2,size_id)
                        .execute()
        );
        return i==1;

    }
    public boolean DeleteSizeById(String size_id){
        int i = jdbiConnector.get().withHandle(handle ->
                handle.createUpdate("delete from Size where size_id = ?")
                        .bind(0,size_id)
                        .execute()
        );
        return i==1;
    }
}
