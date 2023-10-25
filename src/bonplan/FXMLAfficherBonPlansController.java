/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

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
import models.BonPlan;
import services.ServiceBonPLan;
import java.util.List;



/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class FXMLAfficherBonPlansController implements Initializable {

    @FXML
    private Button btnAfficher;
    @FXML
    private Button btnModifierBonPlan;
    @FXML
    private ListView<BonPlan> listBonPlans;
    private BonPlan selectedBp;
    ServiceBonPLan sbp= new ServiceBonPLan();
    @FXML
    private Button btnDeleteBonPlan;
    @FXML
    private Button btnAjouter;
    @FXML
    private Button btnReturnToPrevious;

    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listBonPlans.setOnMouseClicked(event->{
        selectedBp=listBonPlans.getSelectionModel().getSelectedItem();
        });
    }    

    @FXML
    private void afficherbonPlans(ActionEvent event) {
        ObservableList<BonPlan> items = FXCollections.observableArrayList();
        List<BonPlan> bonPlans = sbp.getAll(new BonPlan());
        items.addAll(bonPlans);
        listBonPlans.setItems(items);
        
    }

        @FXML
    private void modifierBonPlan(ActionEvent event) {
        try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLUpdateBonPlan.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 FXMLUpdateBonPlanController fXMLUpdateBonPlanController = loader.getController();

                // Pass the selected user to the ModifierUser scene
                fXMLUpdateBonPlanController.initData(selectedBp);
            
            
            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Modifier BonPlan");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) btnModifierBonPlan.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void deleteBonPlan(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDeletionVerification.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 FXMLDeletionVerificationController deletionVerificationController = loader.getController();

                // Pass the selected user to the ModifierUser scene
                deletionVerificationController.initData(selectedBp);
            
            
            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Supprimer Bon Plan ");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) btnDeleteBonPlan.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
    }

    @FXML
    private void ajouterBonPlan(ActionEvent event) {
                try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLBonPlan.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 FXMLBonPlanController bonPlanController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage ajouterStage = new Stage();
            ajouterStage.setScene(new Scene(root));
            ajouterStage.setTitle("Ajouter un Bon Plan");
            ajouterStage.show();
            Stage currentStage = (Stage) btnAjouter.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
            }
     }

    @FXML
    private void returnToPrevious(ActionEvent event) {
        try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageGestionBonPlans.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 HomePageGestionBonPlansController homePageGestionBonPlansController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.setTitle("Home Entity BonPlan");
            homeStage.show();
            Stage currentStage = (Stage) btnReturnToPrevious.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
            }
    }
    
}
