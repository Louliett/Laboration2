package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreen implements Initializable {


    @FXML
    ImageView img1,img2;

    @FXML
    TextField buy1, buy2;



    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File file = new File("src/img/img1.jpg");
        Image image = new Image(file.toURI().toString());
        img1.setImage(image);

        File file2 = new File("src/img/img2.jpg");
        Image image2 = new Image(file2.toURI().toString());
        img2.setImage(image2);
    }

    @FXML
    public void logOutClick(ActionEvent event) throws IOException {

        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
        Parent root;
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void buy1(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes !");
        alert.setHeaderText("Thank You For Your Purchase");
        alert.showAndWait();
    }

    @FXML
    public void buy2(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Succes !");
        alert.setHeaderText(null);
        alert.setHeaderText("Thank You For Your Purchase");
        alert.showAndWait();
    }

}
