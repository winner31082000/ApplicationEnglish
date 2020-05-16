package sample;

import sample.MConnection;
import sample.Student;

import java.sql.SQLException;
import java.sql.Statement;

public class ActionDataBase {

    public String checkLogin(String user) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        var sql = "SELECT PassWord FROM dbo.Customer where UserName = "+ "'" + user + "'";
        var result = conn.prepareStatement(sql);
        var resultSet = result.executeQuery();
        String a = null;
        while (resultSet.next()) {
            a = resultSet.getString("PassWord");
        }
        return  a;
    }

    public void insertTotalData(Student student) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("update Customer set Address = '"
                + student.getAddress() + "'," + "Phone ='" + student.getPhone() +"',"
                + "FullName = '"  + student.getFullName() + "',"
                + "Email = '"  + student.getEmail() + "'," + "Facebook ='" + student.getFacebook() +"',"
                +"DateOfBirth = '"  + student.getDateOfBirth() + "'," + "Age ='" + student.getAge() +"',"
                +"Gender = '"  + student.getGender() + "'," + "Edu ='" + student.getEdu() +"'"
                + "where UserName =" + "'" + student.getUserName() + "'");
        System.out.println("Update total successful");
    }

    public void updatePass(String password,Student student) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("update Customer set PassWord = '"
                + password +"'"
                + "where UserName =" + "'" + student.getUserName() + "'");
        System.out.println("Update password successful");
    }

    public boolean haveUserName(String user) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        var sql = "SELECT UserName FROM dbo.Customer where UserName = "
                + "'" + user + "'";
        var result = conn.prepareStatement(sql);
        var resultSet = result.executeQuery();
        if(resultSet.next()){
            System.out.println(resultSet.getString("UserName") + " already exists");
            return true;
        }
        else{
            return false;
        }
    }

    public void setData(String user,Student student) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        var sql = "SELECT * FROM dbo.Customer where UserName = "+ "'" + user + "'";
        var result = conn.prepareStatement(sql);
        var resultSet = result.executeQuery();
        while (resultSet.next()) {
            student.setID(resultSet.getInt("ID"));
            student.setUserName(resultSet.getString("UserName"));
            student.setPassword(resultSet.getString("PassWord"));
            student.setFullName(resultSet.getString("FullName"));
            student.setAddress(resultSet.getString("Address"));
            student.setPhone(resultSet.getString("Phone"));
            student.setEmail(resultSet.getString("Email"));
            student.setFacebook(resultSet.getString("Facebook"));
            student.setDateOfBirth(resultSet.getDate("DateOfBirth"));
            student.setAge(resultSet.getInt("Age"));
            student.setGender(resultSet.getString("Gender"));
            student.setEdu(resultSet.getString("Edu"));
        }

    }
    public void insertData(Student student) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("insert into Customer(UserName,PassWord,FullName,Email) values ('"+
                student.getUserName()+"','"+student.getPassword()+"','"+student.getFullName()+"','"
                +student.getEmail()+ "')");
        System.out.println("Update sign up successful");
    }

    public void setSignUp(Student student,String userName,String password,String fullName,String email){
        /*this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;*/
        student.setUserName(userName);
        student.setPassword(password);
        student.setFullName(fullName);
        student.setEmail(email);
    }
}
