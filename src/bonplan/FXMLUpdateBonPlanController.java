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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import java.sql.Date;
import javafx.scene.control.Alert;
import models.BonPlan;
import services.ServiceBonPLan;

/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class FXMLUpdateBonPlanController implements Initializable {

    @FXML
    private TextField txtFieldNameBonPlan;
    @FXML
    private TextField txtFieldRatingBonPlan;
    @FXML
    private DatePicker datePickerStartDate;
    @FXML
    private DatePicker datePickerEndingDate;
    @FXML
    private TextField txtFieldAvgPrice;
    @FXML
    private Button btnUpdate;
    private BonPlan selectedBp;

    
    ServiceBonPLan sbp= new ServiceBonPLan();
    //private TextField txtFieldIdBonPlan;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initialize the form with the selected user's data
        if (selectedBp != null) {
            txtFieldNameBonPlan.setText(selectedBp.getNameBonPlan());
            txtFieldRatingBonPlan.setText(String.valueOf(selectedBp.getRating()));
            datePickerStartDate.setValue(selectedBp.getStartDate().toLocalDate());
            datePickerEndingDate.setValue(selectedBp.getEndDate().toLocalDate());
            txtFieldAvgPrice.setText(String.valueOf(selectedBp.getAvgPrice()));
                    }

    }
    public void initData(BonPlan bp) {
        // Receive the selected user data
        selectedBp = bp;
    }

    @FXML
    private void updateBonPlan(ActionEvent event) {


        if (selectedBp!=null){

            //sleected bp 
        selectedBp.setNameBonPlan(txtFieldNameBonPlan.getText());
        selectedBp.setRating(Float.parseFloat(txtFieldRatingBonPlan.getText()));
        selectedBp.setStartDate(Date.valueOf(datePickerStartDate.getValue()));
        selectedBp.setEndDate(Date.valueOf(datePickerEndingDate.getValue()));
        selectedBp.setAvgPrice(Float.parseFloat(txtFieldAvgPrice.getText()));

        sbp.updateBonPlan(selectedBp);
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Sélectionnez un BonPlan à modifier.");
        alert.showAndWait();

        }

    }
    
}
