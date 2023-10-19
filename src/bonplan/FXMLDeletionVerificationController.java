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
import models.BonPlan;

/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class FXMLDeletionVerificationController implements Initializable {
    

    /**
     * Initializes the controller class.
     */
    BonPlan selectedBp=new BonPlan();
    @FXML
    private Button btnDelete;
    
    services.ServiceBonPLan sbp;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       sbp=new services.ServiceBonPLan();
    }  
    
        public void initData(BonPlan bp) {
        // Receive the selected user data
        selectedBp = bp;
    }
        

    
        

    @FXML
    private void verifDeleteBonPlan(ActionEvent event) {
         if (selectedBp!=null){
         sbp.deleteBonPlan(selectedBp);
        
         try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAfficherBonPlans.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Bons Plans List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) btnDelete.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        }
         
        
    }
    
}

