/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AfficherUserController implements Initializable {

    @FXML
    private ListView<User> list;
    @FXML
    private Button modifierButton;
    @FXML
    private Button SupprimerButton;
    
     private User selectedUser;
    @FXML
    private Button addbtn;
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        list.setOnMouseClicked(event -> {
            selectedUser = list.getSelectionModel().getSelectedItem();
        });
    }    

    @FXML
    private void Afficher(ActionEvent event) {
        ServiceUser su = new ServiceUser();
              ObservableList<User> items = FXCollections.observableArrayList();
         
        items.addAll(su.getAll(new User()));
        list.setItems(items);
        
    }

    @FXML
    private void switchToModifierScene(ActionEvent event) {
         try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                ModifierUserController modifierController = loader.getController();

                // Pass the selected user to the ModifierUser scene
                modifierController.initData(selectedUser);
            
            
            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Modifier User");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) modifierButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        
    }

    @FXML
    private void circleback(ActionEvent event) {
    }

    @FXML
    private void switchToSupprimerScene(ActionEvent event) {
         try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerUser.fxml"));
            Parent root = loader.load();

            // Get the controller of the SupprimerUser scene
                SupprimerUserController supprimerController = loader.getController();

                // Pass the selected user to the SupprimerUser scene
                supprimerController.initData(selectedUser);
                
                
            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Supprimer User");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) SupprimerButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Ajouter User");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) addbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
    
    
    
}
