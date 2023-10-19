/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.entities.reclamation;
import esprit.services.Servicereclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterreclamationFXMLController implements Initializable {
    
      

    @FXML
    private TextField Description;
    @FXML
    private TextField Nom;
    
    @FXML
    private Button Ajouter;
    @FXML
    private TextField type;
    @FXML
    private Label Showlabel;

      

    /**
     * Initializes the controller class.
     */
      
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
        
            if (Nom.getText().isEmpty() || Description.getText().isEmpty() || type.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Echec");
    alert.setContentText("Empty fields !!!");
    alert.show();
    
    alert.setHeaderText(null);
    String message = "";
     if (Nom.getText().isEmpty()) {
        message += "Le champ Nom est vide\n";
    }
    else if (type.getText().isEmpty()) {
        message += "Le champ Type est vide\n";
    }
    else if (Description.getText().isEmpty()) {
        message += "Le champ Description est vide\n";
    }
   
    alert.setContentText(message);
    alert.show();
   

} else {
                LocalDateTime myDate = LocalDateTime.now();
                Servicereclamation sr = new Servicereclamation();
                sr.addReclamation(new reclamation (type.getText(),Nom.getText(), Description.getText(),myDate));
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Reclamation added successfully!");
                alert.setHeaderText(null);
                alert.setTitle("Succes");
                alert.show();                
//Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //alert.setContentText(Nom.getText()+type.getText()+Description.getText());
                //alert.show();
            }
    }

    @FXML
    private void AfficherAction(ActionEvent event) {
        
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
                Logger.getLogger(AjouterreclamationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
           }
    }

   
 
    

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * FXML Controller class
 *
 * @author USER
 */

      

  

    
    
    
