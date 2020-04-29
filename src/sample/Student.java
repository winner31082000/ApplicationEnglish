package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;

public class Student {
    private int ID;
    private String userName;
    private String password;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String facebook;
    private Date dateOfBirth = Date.valueOf("2000-01-01");
    private int age;
    private String gender;
    private String edu;
    private History[] histories = new History[100];
    private int now = 0;

    public Student(){
        histories = new History[100];
        now = 0;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public History[] getHistories() {
        return histories;
    }

    public void setHistories(History[] histories) {
        this.histories = histories;
    }

    public int getNow() {
        return now;
    }

    public void setNow(int now) {
        this.now = now;
    }

    public void addHistory(int diem){
        histories[now] = new History(now+1, diem);
        now++;
    }

    public void editHistory(int vong, int diem){

        histories[vong-1].setDiem(diem);
    }
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
    public void setSignUp(String userName,String password,String fullName,String email){
        this.userName = userName;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }
    public void insertData() throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("insert into Customer(UserName,PassWord,FullName,Email) values ('"+getUserName()+"','"+getPassword()+"','"+getFullName()+"','"
                +getEmail()+ "')");
        System.out.println("Update sign up successful");
    }
    public void insertTotalData() throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("update Customer set Address = '"
                + getAddress() + "'," + "Phone ='" + getPhone() +"',"
                + "FullName = '"  + getFullName() + "',"
                + "Email = '"  + getEmail() + "'," + "Facebook ='" + getFacebook() +"',"
                +"DateOfBirth = '"  + getDateOfBirth() + "'," + "Age ='" + getAge() +"',"
                +"Gender = '"  + getGender() + "'," + "Edu ='" + getEdu() +"'"
                + "where UserName =" + "'" + getUserName() + "'");
        System.out.println("Update total successful");
    }
    public void updatePass(String password) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        Statement stm = conn.createStatement();
        stm.executeUpdate("update Customer set PassWord = '"
                + password +"'"
                + "where UserName =" + "'" + getUserName() + "'");
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

    public void setData(String user) throws SQLException {
        var conn = MConnection.getInstance().getConnection();
        var sql = "SELECT * FROM dbo.Customer where UserName = "+ "'" + user + "'";
        var result = conn.prepareStatement(sql);
        var resultSet = result.executeQuery();
        while (resultSet.next()) {
            ID = resultSet.getInt("ID");
            userName = resultSet.getString("UserName");
            password = resultSet.getString("PassWord");
            fullName = resultSet.getString("FullName");
            address = resultSet.getString("Address");
            phone = resultSet.getString("Phone");
            email = resultSet.getString("Email");
            facebook = resultSet.getString("Facebook");
            dateOfBirth = resultSet.getDate("DateOfBirth");
            age = resultSet.getInt("Age");
            gender = resultSet.getString("Gender");
            edu = resultSet.getString("Edu");
        }
    }
}

