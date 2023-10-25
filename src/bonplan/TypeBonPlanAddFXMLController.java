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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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
    
}
