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
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO  // TODO
        ObservableList<String> list=FXCollections.observableArrayList("Hotels","Motels","Auberges","Chambres d'hotes","Auberges de jeunesse");
        typeheberres.setItems(list);
        
        ObservableList<String> list1=FXCollections.observableArrayList("Visite de musées","activités nautiques","Randonnée","safari","escalade"," Séjours dans des spas","yoga");
        typeacres.setItems(list1);
         ObservableList<String> list2=FXCollections.observableArrayList("Carte de Crédit / Débit","Virement Bancaire ","Chèque","espèces");
        modep.setItems(list2);
         TextFormatter<Integer> cinFormatter = new TextFormatter<>(new IntegerStringConverter(), null, change -> {
        if (change.isContentChange()) {
            String newText = change.getControlNewText();
            if (newText.length() <= 8) {
                return change;
            }
        }
        return null;
    });
    
    cinclientres.setTextFormatter(cinFormatter);
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

    nomreservation.setTextFormatter(nomFormatter);
        

   
    }    
     @FXML
    private void buttajoutres(ActionEvent event) {
       
    // Obtenez les valeurs des champs
    String Cinclientres = cinclientres.getText().trim();
    String nomRes = nomreservation.getText().trim();
    String nbPerRes = nbperres.getText().trim();
    String referenceRes = referenceres.getText().trim();

    // Vérifiez si les champs sont vides
    if (Cinclientres.isEmpty() || nomRes.isEmpty() || nbPerRes.isEmpty() || referenceRes.isEmpty()
            || dateres1.getValue() == null || dateres2.getValue() == null
            || modep.getSelectionModel().isEmpty() || typeheberres.getSelectionModel().isEmpty() || typeacres.getSelectionModel().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
    } else {
       
    

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
        Parent parent2=FXMLLoader .load(getClass().getResource("affichagereservation.fxml"));
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

    }}
     private boolean validateDates(Date d1,Date d2) {
        try {
                    return !d1.after(d2);
         
            
        } catch (Exception e) {
            return false;
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
        }catch (IOException ex){
            Logger.getLogger(AcceuilresController.class.getName()).log(Level.SEVERE, null, ex);
        };

    }

    
    
}
