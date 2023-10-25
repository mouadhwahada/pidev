/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import models.TypeBonPlan;
import services.ServiceTypeBonPlan;
/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class TypeBonPlanAfficherFXMLController implements Initializable {

    @FXML
    private Button btnAfficherTypeBonPlan;
    services.ServiceTypeBonPlan stbp = new ServiceTypeBonPlan();
    /*@FXML
    private ListView<TypeBonPlan> listTypeBonPlans;*/
    private TypeBonPlan selectedTbp;
    @FXML
    private ListView<TypeBonPlan> listTypeBonPlans;
    @FXML
    private Button btnAjouterTBP;
    @FXML
    private Button btnModifierTBP;
    @FXML
    private Button btnReturnToPrevious;
    @FXML
    private Button btnDeleteTypeBP;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listTypeBonPlans.setOnMouseClicked(event->{
        selectedTbp=listTypeBonPlans.getSelectionModel().getSelectedItem();
        });
    }    

    @FXML
    private void afficherTypesBonPlan(ActionEvent event) {
        ObservableList<TypeBonPlan> items = FXCollections.observableArrayList();
        List<TypeBonPlan> typeBonPlans=stbp.getAllTypebonPlan(new TypeBonPlan());
        items.addAll(typeBonPlans);
        listTypeBonPlans.setItems(items);
        
    }

    @FXML
    private void ajouterTypeBP(ActionEvent event) {
                        try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanAddFXML.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 TypeBonPlanAddFXMLController addFXMLController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage ajouterStage = new Stage();
            ajouterStage.setScene(new Scene(root));
            ajouterStage.setTitle("Ajouter un  Type Bon Plan");
            ajouterStage.show();
            Stage currentStage = (Stage) btnAjouterTBP.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
            }
    }

    @FXML
    private void modifierTBP(ActionEvent event) {
        try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanModifierFXML.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the Modifier scene
                 TypeBonPlanModifierFXMLController typeBonPlanModifierFXMLController = loader.getController();

                // Pass the selected user to the ModifierUser scene
                typeBonPlanModifierFXMLController.initData(selectedTbp);
            
            
            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Modifier Type Bon Plan");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) btnModifierTBP.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
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

    @FXML
    private void deleteBp(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanDeleteFXML.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 TypeBonPlanDeleteFXMLController typeBonPlanDeleteFXMLController = loader.getController();

                // Pass the selected user to the ModifierUser scene
                typeBonPlanDeleteFXMLController.initData(selectedTbp);
            
            
            // Create a new stage for the ModifierUser scene
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Supprimer Type Bon Plan ");

            // Show the new stage
            modifierStage.show();

            // Close the current stage (AfficherUser)
            Stage currentStage = (Stage) btnDeleteTypeBP.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
