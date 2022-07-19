package vn.hcmuaf.edu.vn.project_web.Database;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;

public class jdbiConnector {
    private static Jdbi jdbi;

    private static void makeConnect(){
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://"+DBProperties.getDbHost()+":"+DBProperties.getDbPort()+"/"+DBProperties.getDbDatabaseName());
        dataSource.setUser(DBProperties.getDbUsername());
        dataSource.setPassword(DBProperties.getDbPassword());
        try {
            dataSource.setUseCompression(true);
            dataSource.setAutoReconnect(true);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        jdbi= Jdbi.create(dataSource);
    }

    public static Jdbi get(){
        if(jdbi==null) makeConnect();
        return jdbi;
    }
}

