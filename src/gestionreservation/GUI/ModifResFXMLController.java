/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.Stage;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ModifResFXMLController implements Initializable {

    @FXML
    private TextField cinclientresmodif;
    @FXML
    private DatePicker datedebmodif;
    @FXML
    private DatePicker datefmodif;
    @FXML
    private TextField nomresmodif;
    @FXML
    private ComboBox typeheberresmodif;
    @FXML
    private ComboBox typeacresmodif;
    @FXML
    private TextField nbprresmodif;
    @FXML
    private Button buttonsauvmodif;
    @FXML
    private ComboBox modepmodif;
    @FXML
    private TextField referenceresmodif;
    @FXML
    private Button returnaffiche;
    @FXML
    private Button acceuilres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
// TODO  // TODO
        ObservableList<String> list=FXCollections.observableArrayList("Hotels","Motels","Auberges","Chambres d'hotes","Auberges de jeunesse");
        typeheberresmodif.setItems(list);
        
        ObservableList<String> list1=FXCollections.observableArrayList("Visite de musées","activités nautiques","Randonnée","safari","escalade"," Séjours dans des spas","yoga");
        typeacresmodif.setItems(list1);
         ObservableList<String> list2=FXCollections.observableArrayList("Carte de Crédit / Débit","Virement Bancaire ","Chèque","espèces");
        modepmodif.setItems(list2);
         TextFormatter<Integer> cinFormatter = new TextFormatter<>(new IntegerStringConverter(), null, change -> {
        if (change.isContentChange()) {
            String newText = change.getControlNewText();
            if (newText.length() <= 8) {
                return change;
            }
        }
        return null;
    });
    
    cinclientresmodif.setTextFormatter(cinFormatter);
  Pattern pattern = Pattern.compile("^[A-Za-z]*$"); // L'expression régulière pour les lettres
    TextFormatter<String> nomFormatter = new TextFormatter<>(new DefaultStringConverter(), null, change -> {
        if (change.isContentChange()) {
            String newText = change.getControlNewText();
            if (newText.isEmpty() || pattern.matcher(newText).matches()) {
                return change;
            }
        }
        return null;
    });

    nomresmodif.setTextFormatter(nomFormatter);
        
        
    }    

    @FXML
    private void buttonsauvmodif(ActionEvent event) {
        
        
        ServiceReservation serviceReservation = new ServiceReservation();
        Reservation reservation = new Reservation();

        Date dateDebut = java.sql.Date.valueOf(datedebmodif.getValue());
        Date dateFin = java.sql.Date.valueOf(datefmodif.getValue());
        reservation.setCinClient(Integer.parseInt(cinclientresmodif.getText()));
        reservation.setNomClient(nomresmodif.getText());
        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);
         reservation.setMode_paiement(modepmodif.getSelectionModel().getSelectedItem().toString());

        reservation.setNombrePersonnes(Integer.parseInt(nbprresmodif.getText()));
          reservation.setTypeHebergement(typeheberresmodif.getSelectionModel().getSelectedItem().toString());
       reservation.setTypeActivite(typeacresmodif.getSelectionModel().getSelectedItem().toString());
      

           reservation.setNumtelephone(Integer.parseInt(referenceresmodif.getText()));
             if (validateDates(dateDebut, dateFin)) {
           serviceReservation.modifierReservation(reservation);
             }else{
                 JOptionPane.showMessageDialog(null,
    "Date incorrecte", "Inane error",
    JOptionPane.ERROR_MESSAGE);
             }
    }
     private boolean validateDates(Date d1,Date d2) {
        try {
                    return !d1.after(d2);
         
            
        } catch (Exception e) {
            return false;
        }
     }

    public void setCinClient(int cinClient) {
        cinclientresmodif.setText(String.valueOf(cinClient));
    }

    public void setNomClient(String nomClient) {
        nomresmodif.setText(nomClient);
    }

    public void setNombrePersonnes(int nombrePersonnes) {
        nbprresmodif.setText(String.valueOf(nombrePersonnes));
    }

   public void setDateDebut(String dateDebut) {
       try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateDebut, formatter);
        datedebmodif.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    }
    }

public void setDateFin(String dateFin) {
    try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(dateFin, formatter);
        datefmodif.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    } 
}


    public void setModePaiement(String modePaiement) {
        modepmodif.setValue(modePaiement);
    }

    public void setTypeHebergement(String typeHebergement) {
        typeheberresmodif.setValue(typeHebergement);
    }

    public void setTypeActivite(String typeActivite) {
        typeacresmodif.setValue(typeActivite);
    }

    public void setNumtelephone(int numtel) {
        referenceresmodif.setText(String.valueOf(numtel));
    }

    // Méthode pour gérer la sauvegarde des modifications

    @FXML
    private void returnaffiche(ActionEvent event) {
          try{
            Parent parent2=FXMLLoader .load(getClass().getResource("affichageReservation.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("La liste des réservations");
            stage.show();
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        }catch (IOException ex){
            Logger.getLogger(AffichageReservationController.class.getName()).log(Level.SEVERE, null, ex);
        };

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
   
}
