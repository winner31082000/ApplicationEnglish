package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControllerLogin {
    @FXML
    private TextField signEmail,signName,signID;
    @FXML
    private PasswordField signPass,signCPass;
    @FXML
    private TextField loginID,loginPass;

    @FXML
    private Text target,baoLoi;
    @FXML
    private StackPane stackPane;
    private boolean verifyLogin,success = false;

    public boolean isVerifyLogin() {
        return verifyLogin;
    }

    public void setVerifyLogin(boolean verifyLogin) {
        this.verifyLogin = verifyLogin;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void Summit(ActionEvent event) throws IOException {
        changeTop();
    }
    //public static Connect connect = new Connect();
    public void changeTop(){
        ObservableList<Node> list = this.stackPane.getChildren();
        if(list.size() > 0){
            Node topNode = list.get(list.size() -1);
            Node newNode = list.get(list.size()-2);
            topNode.setVisible(false);
            topNode.toBack();
            newNode.setVisible(true);
        }
    }
    public boolean signUp() throws SQLException {
        if(!signPass.getText().equals(signCPass.getText())){
            baoLoi.setFill(Color.RED);
            baoLoi.setText("Password does not match.");
            return false;
        }
        else if(Main.students[Main.dem].haveUserName(signID.getText())){
            baoLoi.setFill(Color.RED);
            baoLoi.setText("Username " + signID.getText() + " is not available.");
            return false;
        }
        else {
            // insert data
            Main.students[Main.dem].setSignUp(signID.getText(),signPass.getText(),
                    signName.getText(),signEmail.getText());
            Main.students[Main.dem].insertData();
            return true;
        }
    }
    // vào màn hình chính
    public void enter(ActionEvent event) throws IOException, SQLException {
        if(signUp() == true){
            setSceneHome(event);
        }
    }
    public void checkLogin() throws SQLException {
       String pass = Main.students[Main.dem].checkLogin(loginID.getText());
       System.out.println(pass);
        if(loginPass.getText().equals(pass)){
            verifyLogin = true;
        }
        else {
            verifyLogin = false;
        }
    }
    public void click(ActionEvent event) throws SQLException {
        checkLogin();
        try{
            if(verifyLogin == false){
                Error();
            }
            if(verifyLogin == true){
               // Main.student.setUserName(loginID.getText());
                Main.students[Main.dem].setData(loginID.getText());
                System.out.println(Main.students[Main.dem].getFullName());
                setSceneHome(event);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setSceneHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage window = (Stage)((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root,1083,690);
        window.getIcons().add(new Image(getClass().getResourceAsStream("book.png")));
        window.setTitle("Hust English App");
        window.setScene(scene);
        window.show();
    }
    //error login
    public void Error(){
        this.target.setFill(Color.RED);
        this.target.setText("User account or password is incorrect.");
    }
}
