/*
package sample;

import sample.Student;

import java.sql.*;

public class ConnectDatabase {
    private String url;
    private String use;
    private String pass;
    private Connection connection;
    public ConnectDatabase() throws ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.url="jdbc:sqlserver://localhost:1433;databaseName=UserApp";//Database: UserApp
        this.use="sa";
        this.pass="23571113";
        try {
            connection= DriverManager.getConnection(url,use,pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void addAccount(String id, String password,String firstName,String lastName,String email) throws SQLException {
        String sql="Select * from dbo.account"; //add account into table account
        var temp="INSERT INTO dbo.account\n" +
                "(\n" +
                "    id,\n" +
                "    password,\n" +
                "    firstName,\n" +
                "    lastName,\n" +
                "    email\n" +
                ")\n" +
                "VALUES\n" +
                "(   ?, -- id - varchar(20)\n" +
                "    ?, -- password - varchar(20)\n" +
                "    ?, -- firstName - varchar(20)\n" +
                "    ?, -- lastName - varchar(20)\n" +
                "    ?  -- email - varchar(30)\n" +
                "    )";
        PreparedStatement preparedStatement =connection.prepareStatement(temp);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,password);
        preparedStatement.setString(3,firstName);
        preparedStatement.setString(4,lastName);
        preparedStatement.setString(5,email);
        preparedStatement.executeUpdate();
    }

    public Student inforStudent(String id) throws SQLException {
        String temp="Select * from dbo.account where id=?";
        PreparedStatement preparedStatement=connection.prepareStatement(temp);
        preparedStatement.setString(1,id);
        var result=preparedStatement.executeQuery();
        if(result.next()){
            String idUser=result.getString("id");
            String password=result.getString("password");
            String firstName=result.getString("firstname");
            String lastName=result.getString("lastname");
            String email=result.getString("email");
            Student stu=new Student(idUser,password,firstName,lastName,email);
            return stu;
        }
        return null;
    }

}
*/
