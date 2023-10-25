/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

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
import models.TypeBonPlan;
import services.ServiceTypeBonPlan;

/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class TypeBonPlanDeleteFXMLController implements Initializable {

    @FXML
    private Button btnDeleteTypeBP;
    @FXML
    private Button btnReturnToPrvPage;

    /**
     * Initializes the controller class.
     */
    TypeBonPlan selectedTbp= new TypeBonPlan();
    ServiceTypeBonPlan stbp=new ServiceTypeBonPlan();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public void initData(TypeBonPlan tbp){
    selectedTbp = tbp;
    }

    @FXML
    private void deleteTypeBp(ActionEvent event) {
        if (selectedTbp != null){
        stbp.deleteTypeBonPlan(selectedTbp);
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanAfficherFXML.fxml"));
                Parent root = loader.load();

          
                Stage modifierStage = new Stage();
                modifierStage.setScene(new Scene(root));
                modifierStage.setTitle("Type Bons Plans List");

          
                modifierStage.show();

            
                Stage currentStage = (Stage) btnDeleteTypeBP.getScene().getWindow();
                currentStage.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void btnReturnToPrevPage(ActionEvent event) {
                    try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("TypeBonPlanAfficherFXML.fxml"));
                Parent root = loader.load();

          
                Stage modifierStage = new Stage();
                modifierStage.setScene(new Scene(root));
                modifierStage.setTitle(" Type Bons Plans List");

          
                modifierStage.show();

            
                Stage currentStage = (Stage) btnReturnToPrvPage.getScene().getWindow();
                currentStage.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}
