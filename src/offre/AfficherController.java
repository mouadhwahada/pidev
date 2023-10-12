/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import voyages.offres.grud.serviceOffres;
import voyages.offres.offres;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AfficherController implements Initializable {
 


@FXML 
private Button Afficheoffres;
@FXML 

private Button supprimeroffres;
@FXML 
private ListView listoffres;
    /**
     * Initializes the controller class.
     */
@FXML
        private void Afficheoffres(ActionEvent event){
  serviceOffres soo1 = new serviceOffres();
        ObservableList<offres> itemsoff = FXCollections.observableArrayList();
       
        itemsoff.addAll(soo1.fetchoffres());
       listoffres.setItems(itemsoff);
        }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
