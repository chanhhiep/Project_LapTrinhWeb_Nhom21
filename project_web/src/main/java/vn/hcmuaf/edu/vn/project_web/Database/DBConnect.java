package vn.hcmuaf.edu.vn.project_web.Database;

import java.sql.*;

public class DBConnect {
    private static Connection connection;
    private static DBConnect instance = null;
    private static String DB_URL = "jdbc:mysql://localhost:3306/project_web1";
    private static String username = "root";
    private static String password ="";
    private DBConnect(){
        //do nothing
    }
    public static DBConnect getInstance(){
        if(instance==null){
            instance = new DBConnect();
        }
        return instance;
    }
    public static void connect() throws ClassNotFoundException {
        //
        try {
            if(connection==null || connection.isClosed()){
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL,username,password);
                System.out.println("connection success");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("connection fail");
        }
    }
    public Statement get() throws SQLException {
        try {
            connect();
            return connection.createStatement();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public Connection getConn(){
        Connection conn = null;
        try {
            connect();
            conn=connection;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}