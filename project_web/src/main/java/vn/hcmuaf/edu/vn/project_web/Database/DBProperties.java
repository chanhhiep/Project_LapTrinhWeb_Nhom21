package vn.hcmuaf.edu.vn.project_web.Database;

import java.io.IOException;
import java.util.Properties;

public class DBProperties {
    private static Properties prop = new Properties();
    static {
        try {
            prop.load(DBProperties.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getDbHost(){
        return prop.getProperty("db.host").toString();
    }
    public static String getDbPort(){
        return prop.getProperty("db.port").toString();
    }
    public static String getDbUsername(){
        return prop.getProperty("db.username").toString();
    }
    public static String getDbPassword(){
        return prop.getProperty("db.password").toString();
    }
    public static String getDbDatabaseName(){
        return prop.getProperty("db.databaseName").toString();
    }
}

