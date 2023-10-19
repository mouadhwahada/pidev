/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
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

}
