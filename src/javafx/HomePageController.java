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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class HomePageController implements Initializable {

    @FXML
    private Button signinbtn;
    @FXML
    private Button signupbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignIn(ActionEvent event) {
      try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Login Page");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) signinbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void SignUp(ActionEvent event) {
        
        try {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("SignUp.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Sign Up Page");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) signinbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
    
}
