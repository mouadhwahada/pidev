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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.TypeBonPlan;
import services.ServiceTypeBonPlan;

/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class TypeBonPlanAddFXMLController implements Initializable {

    @FXML
    private TextField txtFieldLocationTypeBonPlan;
    @FXML
    private TextField txtFieldTraveStyleTypeBonPlan;
    @FXML
    private Button btnAjouterTypeBonPlan;
    services.ServiceTypeBonPlan stbp = new ServiceTypeBonPlan();
    @FXML
    private Button btnReturnToPrevPage;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterTypeBonPlan(ActionEvent event) {
        String locationTypeBonPlan= txtFieldLocationTypeBonPlan.getText();
        String travelStyle=txtFieldTraveStyleTypeBonPlan.getText();
        stbp.createTypeBonPlan(new TypeBonPlan(locationTypeBonPlan, travelStyle));
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

            
                Stage currentStage = (Stage) btnReturnToPrevPage.getScene().getWindow();
                currentStage.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}
