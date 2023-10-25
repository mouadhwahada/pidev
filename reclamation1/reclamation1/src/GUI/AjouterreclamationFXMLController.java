/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.github.plushaze.traynotification.notification.TrayNotification;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import javafx.util.Duration;
import javax.swing.JOptionPane;

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
    @FXML
    private Button Remboursement;

      private void handleButtonAction(ActionEvent event) {
       System.out.println("You clicked me!");
   }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
       
        // TODO
    }    

    @FXML
    private void AjouterAction(ActionEvent event) throws IOException {
        
        String nomrecla = Nom.getText();
          String Descriptionrecla = Description.getText();
            String typerecla = type.getText();
           /* if (Nom.getText().isEmpty() || Description.getText().isEmpty() || type.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Echec");
    alert.setHeaderText(null);
    String message = "";
    if (Nom.getText().isEmpty()) {
        message += "Le champ Nom est vide\n";
    }
    if (type.getText().isEmpty()) {
        message += "Le champ Type est vide\n";
    }
    if (Description.getText().isEmpty()) {
        message += "Le champ Description est vide\n";
    }
   
    alert.setContentText(message);
    alert.show();*/
            if (nomrecla.isEmpty() || Descriptionrecla.isEmpty() || typerecla.isEmpty()) {
              Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs");
        alert.showAndWait();
        return;
    }
         
      String regex2 = "^[a-zA-Z]+$";
    Pattern pattern2 = Pattern.compile(regex2);
    Matcher matcher2 = pattern2.matcher(nomrecla);
     
    if (!matcher2.matches()) {
        JOptionPane.showMessageDialog(null, "nom ne doit contenir que des lettres.");
        return;
    }
    

                LocalDateTime myDate = LocalDateTime.now();
                Servicereclamation sr = new Servicereclamation();
                sr.addReclamation(new reclamation (type.getText(),Nom.getText(), Description.getText(),myDate));
                //Alert alert = new Alert(Alert.AlertType.INFORMATION);
                //alert.setContentText(Nom.getText()+type.getText()+Description.getText());
                //alert.show();
                notiff();
            }
    @FXML
    private void gotoremboursement(ActionEvent event) throws IOException {
        
        
        Parent root = FXMLLoader.load(getClass().getResource("AjouterremboursementFXML.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    private void notiff()
    {
        //Service sv = new ServiceVoyage();
        //ReserverVoyage RV = new ReserverVoyage();
        Servicereclamation sr = new Servicereclamation();
         String TextField = Nom.getText();
        //int y=sv.calculnb((Destination.getText()));
        TrayNotification tray = new TrayNotification();
        //AnimationType type = AnimationType.POPUP;
        //tray.setAnimationType(type);
        tray.setTitle(" Notification : ajout avec succes");
        tray.setMessage("La reclamation  Du titre"+ Nom+ " a ete effectuer avec Success");
        //tray.setNotificationType(NotificationType.INFORMATION);
        tray.showAndDismiss(Duration.millis(2000));
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
                Logger.getLogger(AfficherreclamationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
}}
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

      

  

    
    
    
