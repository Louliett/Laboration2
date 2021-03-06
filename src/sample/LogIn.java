package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LogIn implements Initializable {

    @FXML Button logInButton, createAccountButton;
    @FXML TextField emailField, passField;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void logInClick(ActionEvent event) throws IOException {

        Node node = (Node)event.getSource();
        Stage stage = (Stage)node.getScene().getWindow();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscreen.fxml"));
        Parent root;
        root = loader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
