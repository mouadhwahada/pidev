/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceReservation;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.ArrayList;
import java.util.List;
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
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AjouterReservationFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField cinclientres;
   @FXML
    private TextField nomreservation;
    @FXML
    private DatePicker dateres1;
    @FXML
    private DatePicker dateres2;
    @FXML
    private ComboBox modep;
    @FXML
    private TextField nbperres;
    @FXML
    private ComboBox typeheberres;
    @FXML
    private ComboBox typeacres;
    @FXML
    private TextField referenceres;
     @FXML
    private Button buttajoutres;
    @FXML
    private Button acceuilres;
    private FactureajoutController factureController;
    @FXML
    private TextField emailres;
  
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  // TODO
        
// Fournir l'instance du contrôleur actuel
        ObservableList<String> list=FXCollections.observableArrayList("Hotels","Motels","Chambres d'hotes","Auberges de jeunesse");
        typeheberres.setItems(list);
        
        ObservableList<String> list1=FXCollections.observableArrayList("Visite de musées","activités nautiques","Randonnée","safari","escalade"," Séjours dans des spas","yoga");
        typeacres.setItems(list1);
         ObservableList<String> list2=FXCollections.observableArrayList("Carte de Crédit / Débit","Virement Bancaire ","Chèque","espèces");
        modep.setItems(list2);
      
        Pattern pattern = Pattern.compile("^[A-Za-z]*$"); // L'expression régulière pour les lettres
        TextFormatter<String> nomFormatter = new TextFormatter<>(new DefaultStringConverter(), null, change -> {
            if (change.isContentChange()) {
                String newText = change.getControlNewText();
                if (newText.isEmpty() || pattern.matcher(newText).matches()) {
                    return change;
                }
                return null;
            }
            return change;
        });

      TextFormatter<String> cinFormatter = new TextFormatter<>(new DefaultStringConverter(), null, change -> {
    if (change.isContentChange()) {
        String newText = change.getControlNewText();
        // Utilisez une expression régulière pour vérifier si le CIN commence par "0" ou "1" et contient uniquement des chiffres
        if (newText.matches("^[01]\\d*") && newText.length() <= 8) {
            return change;
        } else if (newText.isEmpty()) {
            // Permettre la suppression du texte
            return change;
        }
        return null;
    }
    return change;
});

cinclientres.setTextFormatter(cinFormatter);
    
      
 

    

    
    }

     @FXML
    private void buttajoutres(ActionEvent event) {

    // Obtenez les valeurs des champs
   /* String Cinclientres = cinclientres.getText().trim();
    String nomRes = nomreservation.getText().trim();
    String nbPerRes = nbperres.getText().trim();
    String referenceRes = referenceres.getText().trim();

    // Vérifiez si les champs sont vides
    if (Cinclientres.isEmpty() || nomRes.isEmpty() || nbPerRes.isEmpty() || referenceRes.isEmpty()
            || dateres1.getValue() == null || dateres2.getValue() == null
            || modep.getSelectionModel().isEmpty() || typeheberres.getSelectionModel().isEmpty() || typeacres.getSelectionModel().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
    } else {
        LocalDate startDate = dateres1.getValue();
        LocalDate endDate = dateres2.getValue();

        if (startDate.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(null, "La date de début ne peut pas être antérieure à aujourd'hui.", "Date incorrecte", JOptionPane.ERROR_MESSAGE);
        } else if (endDate.isBefore(startDate)) {
            JOptionPane.showMessageDialog(null, "La date de fin ne peut pas être antérieure à la date de début.", "Date incorrecte", JOptionPane.ERROR_MESSAGE);
        }
       
    

         ServiceReservation res1 = new ServiceReservation();
        String datereservation1 = dateres1.getValue().toString();
        String datereservation2 = dateres2.getValue().toString();
        Date sqlDate1 = Date.valueOf(datereservation1);
        Date sqlDate2 = Date.valueOf(datereservation2);
         
        
        int Cinclientres1=Integer.parseInt(Cinclientres);
        
        String nombreperso=nbperres.getText();
        int nbperresValue=Integer.parseInt(nombreperso);
         String refreservation=referenceres.getText();
        int refreservation1=Integer.parseInt(refreservation);
        if (validateDates(sqlDate1, sqlDate2)) {
         res1.ajouterReservation(new Reservation(Cinclientres1,nomreservation.getText(),nbperresValue,sqlDate1,sqlDate2,modep.getSelectionModel().getSelectedItem().toString(),typeheberres.getSelectionModel().getSelectedItem().toString(),typeacres.getSelectionModel().getSelectedItem().toString(),refreservation1));
        try {
        Parent parent2=FXMLLoader .load(getClass().getResource("affichageReservation.fxml"));
        Scene scene=new Scene(parent2);
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) {
        Logger.getLogger(AffichageReservationController.class.getName()).log(Level.SEVERE, null, ex);
    } 
        }else{
             JOptionPane.showMessageDialog(null,
    "Date incorrecte", "Inane error",
    JOptionPane.ERROR_MESSAGE);
        
                }

    }*/  // Obtenez les valeurs des champs
    String Cinclientres = cinclientres.getText().trim();
    String nomRes = nomreservation.getText().trim();
    String nbPerRes = nbperres.getText().trim();
    String referenceRes = referenceres.getText().trim();

    // Vérifiez si les champs sont vides
    if (Cinclientres.isEmpty() || nomRes.isEmpty() || nbPerRes.isEmpty() || referenceRes.isEmpty()
            || dateres1.getValue() == null || dateres2.getValue() == null
            || modep.getSelectionModel().isEmpty() || typeheberres.getSelectionModel().isEmpty() || typeacres.getSelectionModel().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
        return; // Sortez de la méthode si les champs sont vides
    }

    LocalDate startDate = dateres1.getValue();
    LocalDate endDate = dateres2.getValue();

    if (startDate.isBefore(LocalDate.now())) {
        JOptionPane.showMessageDialog(null, "La date de début ne peut pas être antérieure à aujourd'hui.", "Date incorrecte", JOptionPane.ERROR_MESSAGE);
        return; // Sortez de la méthode si la date de début est incorrecte
    } else if (endDate.isBefore(startDate)) {
        JOptionPane.showMessageDialog(null, "La date de fin ne peut pas être antérieure à la date de début.", "Date incorrecte", JOptionPane.ERROR_MESSAGE);
        return; // Sortez de la méthode si la date de fin est incorrecte
    }

    // Si toutes les vérifications passent, ajoutez la réservation
    ServiceReservation res1 = new ServiceReservation();
    String datereservation1 = dateres1.getValue().toString();
    String datereservation2 = dateres2.getValue().toString();
    Date sqlDate1 = Date.valueOf(datereservation1);
    Date sqlDate2 = Date.valueOf(datereservation2);
    int Cinclientres1 = Integer.parseInt(Cinclientres);
    String nombreperso = nbperres.getText();
    int nbperresValue = Integer.parseInt(nombreperso);
    String refreservation = referenceres.getText();
    int refreservation1 = Integer.parseInt(refreservation);

    // Essayez d'ajouter la réservation
    if (ajouterReservationAReussi(res1, Cinclientres1, nomRes, nbperresValue, sqlDate1, sqlDate2, modep.getSelectionModel().getSelectedItem().toString(), typeheberres.getSelectionModel().getSelectedItem().toString(), typeacres.getSelectionModel().getSelectedItem().toString(), refreservation1)) {
        // L'ajout est réussi, redirigez l'utilisateur vers l'interface d'affichage
        try {
            Parent parent2 = FXMLLoader.load(getClass().getResource("affichageReservation.fxml"));
            Scene scene = new Scene(parent2);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Affichage");
            stage.show();
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        } catch (IOException ex) {
            Logger.getLogger(AffichageReservationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        JOptionPane.showMessageDialog(null, "L'ajout a échoué. Veuillez réessayer.", "Erreur", JOptionPane.ERROR_MESSAGE);
    }
}

// Fonction pour ajouter la réservation et vérifier si l'ajout a réussi
private boolean ajouterReservationAReussi(ServiceReservation service, int Cinclientres, String nomRes, int nbPerRes, Date dateDebut, Date dateFin, String modep, String typeheberres, String typeacres, int refreservation) {
    try {
        service.ajouterReservation(new Reservation(Cinclientres, nomRes, nbPerRes, dateDebut, dateFin, modep, typeheberres, typeacres, refreservation));
        return true; // L'ajout a réussi
    } catch (Exception e) {
        return false; // L'ajout a échoué
    }
}
    /* private boolean validateDates(Date d1,Date d2) {
        try {
                    return !d1.after(d2);
         
            
        } catch (Exception e) {
            return false;
        }
     }*/

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

    public String getEmailres() {
        return emailres.toString();
    }

   
    
}
