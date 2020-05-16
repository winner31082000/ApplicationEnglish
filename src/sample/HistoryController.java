package sample;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;


public class HistoryController implements Initializable {
    @FXML
    StackPane stackPane;
    @FXML
    private Text name;

    @FXML
    LineChart<String, Number> lineChart;

    @FXML
    private TableView<History> table;

    @FXML
    private TableColumn<History, Integer> roundColumn;

    @FXML
    private TableColumn<History, Integer> scoreColumn;

    private Student test = Main.students[Main.dem];

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        name.setText(Main.students[Main.dem].getFullName());
        /*try {
            test.setPoint();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    }

    public void setLevel1(){
        XYChart.Series<String, Number> series = getSeries(test, 1);
        lineChart.getData().clear();
        lineChart.getData().add(series);


        ObservableList<History> data = FXCollections.observableArrayList();
        for (int i = 0; i<test.getNow()[0]; i++){
            data.add(test.getHistories()[0][i]);
        }

        roundColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("vong"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("diem"));
        table.setItems(data);
    }

    public void setLevel2(){
        XYChart.Series<String, Number> series = getSeries(test, 2);
        lineChart.getData().clear();
        lineChart.getData().add(series);


        ObservableList<History> data = FXCollections.observableArrayList();
        for (int i = 0; i<test.getNow()[1]; i++){
            data.add(test.getHistories()[1][i]);
        }

        roundColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("vong"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("diem"));
        table.setItems(data);
    }

    public void setLevel3(){
        XYChart.Series<String, Number> series = getSeries(test, 3);
        lineChart.getData().clear();
        lineChart.getData().add(series);


        ObservableList<History> data = FXCollections.observableArrayList();
        for (int i = 0; i<test.getNow()[2]; i++){
            data.add(test.getHistories()[2][i]);
        }

        roundColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("vong"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<History, Integer>("diem"));
        table.setItems(data);
    }


    public XYChart.Series<String, Number> getSeries(Student test, int level){
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for(int i = 0; i<test.getNow()[level-1]; i++){
            series.getData().add(new XYChart.Data<>("Vong "+test.getHistories()[level-1][i].getVong(), test.getHistories()[level-1][i].getDiem()));
        }
        series.setName("Diem tung vong");
        return series;
    }

    public void logout(ActionEvent event) throws IOException {
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

    public void changToTable(){
        ObservableList<Node> list = this.stackPane.getChildren();
        Node bang = list.get(list.size()-1);
        Node bieudo = list.get(list.size()-2);
        bieudo.setVisible(false);
        bang.setVisible(true);
    }

    public void changeToChart(){
        ObservableList<Node> list = this.stackPane.getChildren();
        Node bang = list.get(list.size()-1);
        Node bieudo = list.get(list.size()-2);
        bang.setVisible(false);
        bieudo.setVisible(true);
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
}
