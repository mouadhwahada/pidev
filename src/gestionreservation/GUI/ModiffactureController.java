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
           String numfact= numfactmodif.getText();
        int numf =Integer.parseInt(numfact);
         String montantfact= montantfactmodif.getText();
        double Montantf=Double.parseDouble(montantfact);
        ServiceFacture sf = new ServiceFacture();
        String reffacturemodif1= reffacturemodif.getText();
        int reffact =Integer.parseInt(reffacturemodif1);
        Reservation reserv=new Reservation();
        reserv.setReference(reffact);
      String datepaiement=datepmodiffacture.getValue().toString();
        Facture f = new Facture(numf,Montantf,datepaiement,reserv);
        sf.modifierFacture(f);
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
        }catch (IOException ex){
            Logger.getLogger(FactureaffichageController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
}

    

