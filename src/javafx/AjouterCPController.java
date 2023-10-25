/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
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
public class AjouterCPController implements Initializable {

    @FXML
    private TextField tfcode;
    @FXML
    private TextField tfdescription;
    private TextField tfused;
    @FXML
    private DatePicker datePicker;
    @FXML
    private Button Ajouter;
    @FXML
    private Button backbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void datePicker(ActionEvent event) {
        LocalDate localdate = datePicker.getValue();
    }
    
   @FXML
private void ajoutercp(ActionEvent event) {
    ServiceCP su = new ServiceCP();
    // Get the selected LocalDate from the DatePicker
LocalDate localDate = datePicker.getValue();

// Convert LocalDate to java.util.Date
Date date = java.sql.Date.valueOf(localDate);
  
    
    if (tfcode.getText().isEmpty() || tfdescription.getText().isEmpty() || date == null ) {
        Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("Missing Information");
            alert.setContentText("All the Information is required!");
            alert.showAndWait();
    }
    else 
    {   if (su.CodeExists(tfcode.getText()))
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("Code");
            alert.setContentText("Coupon Code Already exists");
            alert.showAndWait();
            }
        else 
        {
            su.ajoutercp(new CodePromo(tfcode.getText(),tfdescription.getText(),date));
             
            
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
             alert.setTitle("Confirmation");
           //  alert.setHeaderText("Confirmed");
             alert.setContentText("Coupon Code Added succesfully!");
             alert.showAndWait();
            
            // Emptying the Text Fields
                    tfcode.setText("");
                    tfdescription.setText("");
                    datePicker.setValue(null);
        }
    }
    
    }


    
    
    public Connection getConnection()
    {
    Connection conn ;
  
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eplorex","root","");
            System.out.println("Connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
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
