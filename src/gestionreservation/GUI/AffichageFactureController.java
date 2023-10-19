/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceFacture;
import java.awt.event.MouseEvent;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AffichageFactureController implements Initializable {

    /**
     * Initializes the controller class.
     */@FXML 
     private Button afficherfacture;
     @FXML 
     private Button suppfacture;
     @FXML 
     private ListView<String> listfactures;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML 
    private void afficherfacture(ActionEvent event){
     

       
       // ServiceFacture sv = new ServiceFacture();
       // ObservableList<Facture> itemsfacture = FXCollections.observableArrayList();
       
        //itemsfacture.addAll(sv. afficherFacture() );
        //listfactures.setItems(itemsfacture);
        ServiceFacture sv = new ServiceFacture();
        ObservableList<String> itemsfacture = FXCollections.observableArrayList();

        // Convertissez les données Facture en chaînes
        List<Facture> factures = sv.afficherFacture();
        for (Facture facture : factures) {
             String montantStr = "Montant : " + String.valueOf(facture.getMontant());
        String refStr = "Référence facture : " + String.valueOf(facture.getRef_facture());
        String factureString = montantStr + ", Date de paiement : " + facture.getDatePaiement() +
            ", Mode de paiement : " + facture.getModePaiement() + ", " + refStr;


            itemsfacture.add(factureString);
        }
       listfactures.setItems(itemsfacture);
        
    }
     @FXML
    private void suppfacture(ActionEvent event) {
            /* int selectedIndex = listfactures.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            ServiceFacture serviceFacture = new ServiceFacture();
            Facture facture = serviceFacture.afficherFacture().get(selectedIndex);
            serviceFacture.supprimerFacture(facture.getIdfacture());
       
       
    }*/
    }
    @FXML
    private void choisirfacture(MouseEvent event) {
        int selectedIndex = listfactures.getSelectionModel().getSelectedIndex();

    if (selectedIndex >= 0) {
        listfactures.getItems().remove(selectedIndex);
    }
       
   
    }
}
    

