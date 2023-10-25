/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
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
import javafx.stage.Stage;
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.services.ServiceCP;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class SupprimerCPController implements Initializable {

    @FXML
    private Button deletbtn;
    @FXML
    private Button backbtn;
        private CodePromo selectedCP; // Store the selected user


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

       public void initData(CodePromo codepromo) {
        // Receive the selected user data
        selectedCP = codepromo;
    }
    
    @FXML
    private void delete(ActionEvent event) {
        
         if (selectedCP != null) {
            ServiceCP sc = new ServiceCP();
            sc.supprimercp(selectedCP);

             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                    alert.setTitle("CONFIRMATION");
                    alert.setHeaderText("");
                    alert.setContentText("Deletion Succeeded!");
                    alert.showAndWait();
            
             try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCP.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Cupon Codes List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) deletbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
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
