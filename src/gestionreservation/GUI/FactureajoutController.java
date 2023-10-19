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
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class FactureajoutController implements Initializable {

    @FXML
    private Button conffacture;
    @FXML
    private TextField numfact;
    @FXML
    private TextField montantfact;
    @FXML
    private TextField reffacture;
    @FXML
    private DatePicker datepaiementfact;
    @FXML
    private Button acceuilres;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void conffacture(ActionEvent event) {
          String numFactureText = numfact.getText().trim();
    String montantFactureText = montantfact.getText().trim();
    String datePaiementText = datepaiementfact.getValue().toString();
    String referenceText = reffacture.getText().trim();

    // Vérifiez si les champs sont vides
    if (numFactureText.isEmpty() || montantFactureText.isEmpty() || datePaiementText.isEmpty() || referenceText.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs.", "Champ(s) vide(s)", JOptionPane.ERROR_MESSAGE);
    } else {
         ServiceFacture facture = new ServiceFacture();
         String numfact1=numfact.getText();
         int numfact2=Integer.parseInt(numfact1);
         String Montantfact=montantfact.getText();
        double Montantf=Double.parseDouble(Montantfact);
        String datepaiement=datepaiementfact.getValue().toString();
        String reference=reffacture.getText();
        
        
        int referenceValue=Integer.parseInt(reference);
        String reffacture1=reffacture.getText();
        int reff=Integer.parseInt(reffacture1);
       Reservation r =new Reservation();
       r.setReference(referenceValue);
        
         facture.ajouterFacture(new Facture(numfact2,Montantf,datepaiement,r));
         try {
        Parent parent2=FXMLLoader .load(getClass().getResource("factureaffichage.fxml"));
        Scene scene=new Scene(parent2);
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) {
        Logger.getLogger(FactureaffichageController.class.getName()).log(Level.SEVERE, null, ex);
    } ;

    
    }}

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
