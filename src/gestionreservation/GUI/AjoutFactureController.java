/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Facture;
import gestion_reservation.services.ServiceFacture;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AjoutFactureController implements Initializable {

    /**
     * Initializes the controller class.
     */ @FXML
    private TextField montantfact;
  
    @FXML
    private DatePicker datepaiementres;
    
    @FXML
    private TextField modepfact;
     @FXML
    private TextField reffact;
     
     @FXML
    private Button conffacture;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void conffacture(ActionEvent event) {
       /* ServiceFacture facture = new ServiceFacture();
         String Montantfact=montantfact.getText();
        double Montantf=Double.parseDouble(Montantfact);
        String datepaiement=datepaiementres.getValue().toString();
        String reference=reffact.getText();
        
        int referenceValue=Integer.parseInt(reference);
        //String idres=idresfact.getText();
       // int id_res=Integer.parseInt(idres);
        
         facture.ajouterFacture(new Facture(Montantf,datepaiement,modepfact.getText(),referenceValue));*/
        //private void conffacture(ActionEvent event) {
        ServiceFacture facture = new ServiceFacture();
         String Montantfact=montantfact.getText();
        double Montantf=Double.parseDouble(Montantfact);
        String datepaiement=datepaiementres.getValue().toString();
        String reference=reffact.getText();
        
        int referenceValue=Integer.parseInt(reference);
        //String idres=idresfact.getText();
       // int id_res=Integer.parseInt(idres);
        
         facture.ajouterFacture(new Facture(Montantf,datepaiement,modepfact.getText(),referenceValue));
    }
    }
    

