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
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class SupprimerUserController implements Initializable {

    @FXML
    private Button supprimerButton;
    
    private User selectedUser; // Store the selected user
    @FXML
    private Button backbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

      public void initData(User user) {
        // Receive the selected user data
        selectedUser = user;
    }
      
    @FXML
    private void SupprimerUser(ActionEvent event) {
        if (selectedUser != null) {
            ServiceUser su = new ServiceUser();
            su.supprimer(selectedUser);

            //supprimerButton.getScene().getWindow().hide();
            
            
            
            
             try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherUser.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Users List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) supprimerButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        }
    }

    @FXML
    private void Back(ActionEvent event) {
         try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherUser.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Users List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
    
    
}
