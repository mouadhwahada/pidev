/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


import esprit.entities.remboursement;
import esprit.entities.reclamation;

import esprit.services.serviceremboursement;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AjouterremboursementFXMLController implements Initializable {

   serviceremboursement of = new serviceremboursement();
    
    @FXML
    private TextField motif;
    @FXML
    private TextField montant;
    @FXML
    private Button Ajouter;
    @FXML
    private Button Afficher;
    @FXML
    private Button Reclamation;
    
    @FXML
    private ComboBox<String> Allrec;
    
    
    
    
    
    
    
    
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
       
        Allrec.setItems(FXCollections.observableArrayList(of.getAll()));
    
        // TODO
    }    
//getid recl
    
    //fingetid recl
    @FXML
    private void AjouterAction(ActionEvent event) throws IOException, SQLException {
         String montantr = montant.getText();
             String userName = motif.getText();
         String rec = Allrec.getValue();




   
   
   
        
         
         
           if (motif.getText().isEmpty() || montantr.isEmpty()) {
        // Show an error message if any field is empty
        Alert alert = new Alert(AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }
         
         
         
        //  int montant_rem = Integer.parseInt(montant.getText());  
   /*if ( motif.getText().isEmpty()) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Echec");
    alert.setContentText("Empty fields !!!");
    alert.show();
    
    alert.setHeaderText(null);
    String message = "";
   // if (montant.getText().isEmpty()) {
   //     message += "Le champ montant est vide\n";
  //  }
     if (motif.getText().isEmpty()) {
        message += "Le champ motif est vide\n";
    }
    alert.setContentText(message);
    alert.show();*/
    
       //Controle de saisie pour numeroTel
   /* String regex = "[0-9]";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(montantr);
    if (!matcher.matches()) {
        JOptionPane.showMessageDialog(null, "montant doit contenir des chiffres et seulement des chiffres");
        return;
    } 
    String regex2 = "^[a-zA-Z]+$";
    Pattern pattern2 = Pattern.compile(regex2);
    Matcher matcher2 = pattern2.matcher(userName);
    if (!matcher2.matches()) {
        JOptionPane.showMessageDialog(null, "motif ne doit contenir que des lettres.");
        return;
    }*/
//} else 
{
                LocalDateTime myDate = LocalDateTime.now();
                serviceremboursement sre = new serviceremboursement();
                  int numeroTels = Integer.parseUnsignedInt(montantr);
                
                  sre.addRemboursement(new remboursement ( numeroTels,myDate ,motif.getText()));
                   
               // sre.addRemboursement(new remboursement (Integer.parseInt(montant.getText()) ,myDate ,motif.getText()));
               //
                 
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
    private void gotoreclamation(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("AjouterreclamationFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
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
            Logger.getLogger(AfficherremboursementFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
  
}}
    


   

