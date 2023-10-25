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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.TypeBonPlan;
import services.ServiceTypeBonPlan;

/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class TypeBonPlanModifierFXMLController implements Initializable {

    @FXML
    private TextField txtFieldLocation;
    @FXML
    private TextField txtFieldTravelStyle;
    @FXML
    private Button btnModifierTBP;
    //instantiation de l'entité et du service
    private TypeBonPlan selectedTypeBonPlan;
    ServiceTypeBonPlan stbp=new ServiceTypeBonPlan();
    @FXML
    private Button btnReturnToPrvPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (selectedTypeBonPlan!=null){
        txtFieldLocation.setText(selectedTypeBonPlan.getLocationBonPlan());
        txtFieldTravelStyle.setText(selectedTypeBonPlan.getTravelStyle());
        }
        
    }
    public void initData(TypeBonPlan tbp){
        selectedTypeBonPlan = tbp;
    }
        
    @FXML
    private void modifierTBP(ActionEvent event) {
        if (selectedTypeBonPlan!=null){
        selectedTypeBonPlan.setLocationBonPlan(txtFieldLocation.getText());
        selectedTypeBonPlan.setTravelStyle(txtFieldTravelStyle.getText());
        
        stbp.updateTypeBonPlan(selectedTypeBonPlan);
        }else{
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Veuillez selectionner un type bon plan a modifier s'il vous plait");
        alert.showAndWait();
       
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
