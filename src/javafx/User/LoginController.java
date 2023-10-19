/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class LoginController implements Initializable {

    @FXML
    private TextField pseudoField;
    @FXML
    private TextField mdpField;
    @FXML
    private Button loginButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleLogin(ActionEvent event) {
        String pseudo = pseudoField.getText();
    String mdp = mdpField.getText();
    
    ServiceUser su = new ServiceUser();

    String userRole = su.getUserRole(pseudo, mdp);

    try {
        FXMLLoader loader;
        if ("admin".equals(userRole)) {
            loader = new FXMLLoader(getClass().getResource("Backoffice.fxml"));
        } else {
            loader = new FXMLLoader(getClass().getResource("UserDashboard.fxml"));
        }

        Parent root = loader.load();

        Stage stage = (Stage) loginButton.getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (IOException e) {
    }
    }
    
}
