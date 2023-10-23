/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.BonPlan;
import services.ServiceBonPLan;

/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class FXMLBonPlanController implements Initializable {

    @FXML
    private TextField txtFieldNameBonPlan;
    @FXML
    private TextField txtFieldRatingBonPlan;
    @FXML
    private DatePicker datePickerStartDate;
    @FXML
    private DatePicker datePickerEndingDate;
    @FXML
    private TextField textFieldAvgPrice;
    @FXML
    private ChoiceBox<?> choiceBxTypeBonPlan;
    @FXML
    private Button btnAddBonPlan;
    
    ServiceBonPLan sbp=new ServiceBonPLan();
    @FXML
    private Button btnReturnToHome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addBonPlan(ActionEvent event) {
        {
        String nameBonPlan=txtFieldNameBonPlan.getText();
        Float rating= Float.parseFloat(txtFieldRatingBonPlan.getText());
        Date startDate = Date.valueOf(datePickerStartDate.getValue().toString());
        Date endingDate= Date.valueOf(datePickerEndingDate.getValue().toString());
        Float avgPrice= Float.parseFloat(textFieldAvgPrice.getText());
        sbp.createBonPlan(new BonPlan(nameBonPlan,rating,startDate,endingDate,avgPrice));
    }
        

    }

    @FXML
    private void returnToHome(ActionEvent event) {
                        try {
            // Load the ModifierUser.fxml file
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLAfficherBonPlans.fxml"));
            Parent root = loader.load();

            
            // Get the controller of the ModifierUser scene
                 FXMLAfficherBonPlansController afficherBonPlansController = loader.getController();            
            
            // Create a new stage for the ModifierUser scene
            Stage homeStage = new Stage();
            homeStage.setScene(new Scene(root));
            homeStage.setTitle("Home Entity BonPlan");
            homeStage.show();
            Stage currentStage = (Stage) btnReturnToHome.getScene().getWindow();
            currentStage.close();
            
            }catch(IOException ex){
                ex.printStackTrace();
        
            }
        
    }

}
