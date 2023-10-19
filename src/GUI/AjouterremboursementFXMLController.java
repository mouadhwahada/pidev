/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import esprit.entities.remboursement;

import esprit.services.serviceremboursement;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterremboursementFXMLController implements Initializable {

   
    
    @FXML
    private TextField motif;
    @FXML
    private TextField montant;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Afficher;
    
      private void handleButtonAction(ActionEvent event) {
       System.out.println("You clicked me!");
   }


    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterAction(ActionEvent event) throws IOException {
        
         
          int montant_rem = Integer.parseInt(montant.getText());
         
            if ( motif.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Echec");
    alert.setContentText("Empty fields !!!");
    alert.show();
    
    alert.setHeaderText(null);
    String message = "";
   //  if (montant.getText().isEmpty()) {
   //     message += "Le champ montant est vide\n";
  //  }
     if (motif.getText().isEmpty()) {
        message += "Le champ motif est vide\n";
    }
    
   
    alert.setContentText(message);
    alert.show();
   

} else {
                LocalDateTime myDate = LocalDateTime.now();
                serviceremboursement sre = new serviceremboursement();
                
                sre.addRemboursement(new remboursement (montant_rem ,myDate ,motif.getText()));
                //Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //alert.setContentText(Nom.getText()+type.getText()+Description.getText());
                //alert.show();
            }
    }
    /*
    
            try {
                // Load the FXML file for the new stage
                Parent root = FXMLLoader.load(getClass().getResource("AfficherreclamationFXML.fxml"));
                // Create the new stage
                Stage newStage = new Stage();
                // Set the title of the new stage
                newStage.setTitle("Afficher Reclamations");
                // Create the scene for the new stage
                Scene scene = new Scene(root);
                newStage.setScene(scene);
                // Show the new stage
                newStage.show();

            } catch (IOException ex) {
                Logger.getLogger(AfficherreclamationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
           }; */
    @FXML
    private void AfficherAction(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AfficherremboursementFXML.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle(("Afficher Remboursement"));
            Scene scene = new Scene(root);
            newStage.setScene(scene);
            newStage.show();
        } catch (IOException ex) {
            Logger.getLogger(AjouterremboursementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
}}
    


   

