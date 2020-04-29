package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ControllerAccount implements Initializable {
    @FXML
    TextField name,address,phone,email,facebook,age,edu;
    @FXML
    DatePicker dob;
    @FXML
    RadioButton btMale,btFemale;
    public void ChangePassword(ActionEvent event) throws IOException{
        Parent root  = FXMLLoader.load(getClass().getResource("ChangesPassWord.fxml"));
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        window.setTitle("Change Password");
        window.setScene(scene);
        window.show();
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
    public void undo(ActionEvent event) throws IOException {
        setSceneHome(event);
    }
    public void selectGender1(ActionEvent event){
        btFemale.setVisible(false);
        Main.students[Main.dem].setGender("Male");
    }
    public void selectGender2(ActionEvent event){
        btMale.setVisible(false);
        Main.students[Main.dem].setGender("Female");
    }
    public void update(ActionEvent event) throws SQLException {
        Student a = Main.students[Main.dem];
        a.setFullName(name.getText());
        a.setAddress(address.getText());
        a.setPhone(phone.getText());
        a.setFacebook(facebook.getText());
        //set date
        String str = String.valueOf(dob.getValue());
        a.setDateOfBirth(Date.valueOf(str));
        a.setAge(Integer.valueOf(age.getText()));
        a.setEmail(email.getText());
        a.setEdu(edu.getText());
        a.insertTotalData();
        Alert hi = new Alert(Alert.AlertType.INFORMATION);
        hi.setTitle("Update data");
        hi.setHeaderText(null);
        hi.setContentText("Update to the database successfully !");
        hi.showAndWait();
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Student a = Main.students[Main.dem];
        name.setText(a.getFullName());
        address.setText(a.getAddress());
        phone.setText(a.getPhone());
        email.setText(a.getEmail());
        facebook.setText(a.getFacebook());
        if(a.getDateOfBirth()!=null){
            String b = String.valueOf(a.getDateOfBirth());
            String[] c = b.split("-");
            dob.setValue(LocalDate.of(Integer.valueOf(c[0]),
                    Integer.valueOf(c[1]),Integer.valueOf(c[2])));
        }
        age.setText(String.valueOf(a.getAge()));
        edu.setText(a.getEdu());
        if(a.getGender() ==null){
            btMale.setSelected(true);
        }
        else if(a.getGender().equals("Male")){
            btMale.setSelected(true);
        }
        else{
            btFemale.setSelected(true);
        }
    }
}
