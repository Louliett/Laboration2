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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {


    @FXML TextField emailField, passField;
    String email, pass;

    DBConnection dbc = new DBConnection();


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    public void logInClick(ActionEvent event) throws IOException {

        email = emailField.getText();
        pass = passField.getText();



        if(dbc.login(email, pass)) {

            Node node = (Node)event.getSource();
            Stage stage = (Stage)node.getScene().getWindow();

            FXMLLoader loader = new FXMLLoader(getClass().getResource("mainscreen.fxml"));
            Parent root;
            root = loader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Succes Not !");
            alert.setHeaderText("Thank You for trying to not type incorrectly");
            alert.showAndWait();
        }
    }

}
