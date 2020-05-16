package sample;

public class signup {
    private String usename;
    private String password;
    private int age;
    private String email;
    private String university;

    public signup(){

    }

    public signup(String usename,String password,int age,String email,String university){
        this.usename=usename;
        this.password=password;
        this.age=age;
        this.email=email;
        this.university=university;
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }
}
