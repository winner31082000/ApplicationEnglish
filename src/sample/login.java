package sample;

public class login {
    private String usename;
    private String password;

    public login(){

    }

    public login(String usename,String password){
        this.usename = usename;
        this.password=password;
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
}
