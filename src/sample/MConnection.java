package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MConnection {
//    private final String DBNAM = "Tutorial";
    private final String USER = "sa";

    private final String PASS = "123";
    private final String MURL = "jdbc:sqlserver://localhost:1433;databaseName=EnglishApp";
   /* private final String PASS = "23571113";
    private final String MURL = "jdbc:sqlserver://localhost:1433;databaseName=EnglishApp";*/



    private static MConnection instance = new MConnection();
    public MConnection(){}

    public static MConnection getInstance(){
        return instance;
    }

    public Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(MURL,USER,PASS);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
}
