/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
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
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceCP;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class CodePromoController implements Initializable {

    @FXML
    private ListView<CodePromo> list;
    @FXML
    private Button afficherbtn;
    @FXML
    private Button modifierbtn;
    @FXML
    private Button Supprimerbtn;
    @FXML
    private Button backbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void afficher(ActionEvent event) {
        ServiceCP cp = new ServiceCP();
              ObservableList<CodePromo> items = FXCollections.observableArrayList();
         
        items.addAll(cp.getAlluti(new CodePromo()));
        list.setItems(items);
    }

    @FXML
    private void SwitchToModifier(ActionEvent event) {
         try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCP.fxml"));
            Parent root = loader.load();

            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Modifier Code Promo");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) modifierbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void SwitchToSupprimer(ActionEvent event) {
          try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerCP.fxml"));
            Parent root = loader.load();

            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Supprimer Code Promo");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) Supprimerbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void SwitchToBackoffice(ActionEvent event) {
          try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Backoffice.fxml"));
            Parent root = loader.load();

            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("BackOffice");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
    
}
