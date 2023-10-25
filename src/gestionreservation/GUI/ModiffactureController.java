/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceFacture;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ModiffactureController implements Initializable {

    @FXML
    private Button buttsauvmodiffact;
    @FXML
    private TextField numfactmodif;
    @FXML
    private TextField montantfactmodif;
    @FXML
    private TextField reffacturemodif;
    @FXML
    private DatePicker datepmodiffacture;
    @FXML
    private Button acceuilres;
    @FXML
    private Button returnaffiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

 @FXML
private void buttsauvmodiffact(ActionEvent event) {
    try {
        // Récupérez les valeurs des champs depuis les composants graphiques
        int numFacture = Integer.parseInt(numfactmodif.getText());
        double montant = Double.parseDouble(montantfactmodif.getText());
        int reference = Integer.parseInt(reffacturemodif.getText());
        LocalDate datePaiement = datepmodiffacture.getValue();

        // Créez une instance de Facture avec les modifications
        Facture facture = new Facture();
        
        facture.setMontant(montant);
        facture.setDatePaiement(datePaiement.toString());

        // Créez une instance de Reservation associée à la Facture
        Reservation reservation = new Reservation();
        reservation.setIdReservation(reference);
        facture.setReservation(reservation);
        facture.setNumfacture(numFacture);

        // Enregistrez la modification dans la base de données
        ServiceFacture sf = new ServiceFacture();
        sf.modifierFacture(facture);

        // Redirigez vers la page de liste des factures
        Parent parent2 = FXMLLoader.load(getClass().getResource("factureaffichage.fxml"));
        Scene scene = new Scene(parent2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Liste des factures");
        stage.show();

        // Fermez la fenêtre de modification

    } catch (NumberFormatException e) {
        showAlert("Données non valides.", "Erreur", AlertType.ERROR);
    } catch (IOException ex) {
        Logger.getLogger(ModiffactureController.class.getName()).log(Level.SEVERE, null, ex);
    }
}

 public void setNumFacture(int numFacture) {
        numfactmodif.setText(String.valueOf(numFacture));
    }
  public void setMontant(double montant) {
        montantfactmodif.setText(String.valueOf(montant));
    }

    public void setReference(int reference) {
        reffacturemodif.setText(String.valueOf(reference));
    }

    public void setDatePaiement(String datePaiement) {
   
 
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(datePaiement, formatter);
        datepmodiffacture.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    }
}

    @FXML
    private void accueilres(ActionEvent event) {
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("acceuilres.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.show();
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        }catch (IOException ex){
            Logger.getLogger(AcceuilresController.class.getName()).log(Level.SEVERE, null, ex);
        };

    }

    @FXML
    private void returnaffiche(ActionEvent event) {
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("factureaffichage.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Liste des factures");
            stage.show();
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        }catch (IOException ex){
            Logger.getLogger(FactureaffichageController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

    private void showAlert(String message, String title, AlertType alertType) {
    Alert alert = new Alert(alertType);
    alert.setTitle(title);
    alert.setHeaderText(null); // Vous pouvez spécifier un en-tête si vous le souhaitez
    alert.setContentText(message);
    alert.showAndWait();
}
    
}

    

