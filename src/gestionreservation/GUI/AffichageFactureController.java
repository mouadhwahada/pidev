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
import gestion_reservation.services.ServiceFacture;
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
     private ListView listfactures;
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML 
    private void afficherfacture(ActionEvent event){
        ServiceFacture sv = new ServiceFacture();
        ObservableList<Facture> itemsfacture = FXCollections.observableArrayList();
       
        itemsfacture.addAll(sv.afficherFacture());
        listfactures.setItems(itemsfacture);

    }
    
}
