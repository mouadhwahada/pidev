/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.services.ServiceCP;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class ModifierCPController implements Initializable {

    @FXML
    private Button savebtn;
    @FXML
    private Button backbtn;
    
    private CodePromo selectedCP;
    @FXML
    private TextField valuef;
    private DatePicker localdate;
    @FXML
    private DatePicker datePicker;
    @FXML
    private TextField codef;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (selectedCP != null)
        {
            codef.setText(selectedCP.getCode());
            valuef.setText(selectedCP.getDescription());
            
            datePicker.setValue(selectedCP.getDatedexpiration().toLocalDate());

            

        }
    }    
    
    public void initData(CodePromo codepromo) {
        
        selectedCP = codepromo;
    }
    

    @FXML
    private void save(ActionEvent event) {
        if (selectedCP != null)
        {
           
            selectedCP.setCode(codef.getText());
            selectedCP.setDescription(valuef.getText());
            selectedCP.setDatedexpiration(Date.valueOf(datePicker.getValue()));     
            
            ServiceCP cp = new ServiceCP();
            cp.modifiercp(selectedCP);

        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Select A Cupon Code To Update");
        alert.showAndWait();

        }
  
        
    }

    @FXML
    private void back(ActionEvent event) {
         try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCP.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Cupon Codes List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        
    }
    
}
