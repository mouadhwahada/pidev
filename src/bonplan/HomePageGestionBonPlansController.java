/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

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
 * @author MSADDAK
 */
public class HomePageGestionBonPlansController implements Initializable {

    @FXML
    private Button btnGotToTypeBP;
    @FXML
    private Button btnGoToBP;
    @FXML
    private Button btnSearchByAvgPrice;
    @FXML
    private Button btnSearchByLocation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToTypeBP(ActionEvent event) {
                              try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanAfficherFXML.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 TypeBonPlanAfficherFXMLController typeBonPlanAfficherFXMLController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.setTitle("Home Entity Type BonPlan");
            homeStage.show();
            Stage currentStage = (Stage) btnGotToTypeBP.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
        }
    
    }

    @FXML
    private void goToBP(ActionEvent event) {
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAfficherBonPlans.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 FXMLAfficherBonPlansController afficherBonPlansController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.setTitle("Home Entity BonPlan");
            homeStage.show();
            Stage currentStage = (Stage) btnGoToBP.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
        }
    
    }

    @FXML
    private void RedirectToSearchByAvgPrice(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSearchByAvgPriceMinMax.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 FXMLSearchByAvgPriceMinMaxController fXMLSearchByAvgPriceMinMaxController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.setTitle("Search By Avg Price Bon Plan");
            homeStage.show();
            Stage currentStage = (Stage) btnSearchByAvgPrice.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
        }
    
    }

    @FXML
    private void redirectToSearchByLocation(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanSearchByLocation.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 TypeBonPlanSearchByLocationController typeBonPlanSearchByLocationController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.setTitle("Search By Avg Price Bon Plan");
            homeStage.show();
            Stage currentStage = (Stage) btnSearchByLocation.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
        }
    }
    
}
