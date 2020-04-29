package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ControllerChangePass implements Initializable {
    @FXML
    private TextField changeName;
    @FXML
    private PasswordField changePass,newPass,confirmPass;
    @FXML
    private Text baoLoi;

    public boolean check(Student a){
        if(!(changePass.getText()).equals(a.getPassword())){
            baoLoi.setFill(Color.RED);
            baoLoi.setText("Password is not incorrect.");
            return false;
        }
        else if(!(newPass.getText()).equals(confirmPass.getText())){
            baoLoi.setFill(Color.RED);
            baoLoi.setText("Password does not match.");
            return false;
        }
        else {
            return true;
        }
    }
    public void setChangePass(ActionEvent event) throws SQLException, IOException {
        Student a = Main.students[Main.dem];
        if(check(a)){
            a.updatePass(newPass.getText());
            Alert hi = new Alert(Alert.AlertType.INFORMATION);
            hi.setTitle("Update password");
            hi.setHeaderText("Log out");
            hi.setContentText("Update password successfully !");
            hi.showAndWait();
            logout(event);
        }
    }
    public void setSceneLogin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage primaryStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        primaryStage.setTitle("Hust English App");
        Scene scene = new Scene(root, 400, 600);
        scene.getStylesheets().add(Main.class.getResource("application.css").toExternalForm());

        Image image = new Image(getClass().getResourceAsStream("book.png"));
        primaryStage.getIcons().add(image);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void logout(ActionEvent event) throws IOException {
        setSceneLogin(event);
        Main.students[Main.dem] = null;
        Main.dem++;
    }

    public void BackAccounts(ActionEvent event) throws IOException{
        setSceneHome(event);
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        changeName.setText(Main.students[Main.dem].getUserName());
    }
}
