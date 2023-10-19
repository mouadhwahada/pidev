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
public class BackofficeController implements Initializable {

    @FXML
    private Button userlistbutton;
    @FXML
    private Button codepromo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SwitchToAfficherUser(ActionEvent event) {
        try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Afficheruser.fxml"));
            Parent root = loader.load();

            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("User List");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) userlistbutton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void SwitchToCodePromo(ActionEvent event) {
          try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CodePromo.fxml"));
            Parent root = loader.load();

            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Code Promo List");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) codepromo.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
    
}
