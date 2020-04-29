package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MConnection {
//    private final String DBNAM = "Tutorial";
    private final String USER = "sa";
<<<<<<< HEAD
    private final String PASS = "23571113";
    private final String MURL = "jdbc:sqlserver://localhost:1433;databaseName=dk";
=======
    private final String PASS = "20102000";
    private final String MURL = "jdbc:sqlserver://localhost:1433;databaseName=EnglishApp";
>>>>>>> 85261fde35d10e79f1e5192cfdbb202d8311934e

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
