package vn.hcmuaf.edu.vn.project_web.Dao;

import vn.hcmuaf.edu.vn.project_web.Database.DBConnect;

import java.sql.Connection;
import java.sql.SQLException;

public class test {
    public static void testDBConnect() throws SQLException {
        Connection conn = DBConnect.getInstance().getConn();
        if(conn.isClosed()){
            System.out.println("contion faile");
        }
        else {
            System.out.println("Connection Success");
        }
    }
    public static void main(String[] args) throws SQLException {
        testDBConnect();
    }
}
