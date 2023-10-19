/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.entities.reclamation;
import esprit.entities.remboursement;
import esprit.services.Servicereclamation;
import esprit.services.serviceremboursement;
import java.net.URL;
import java.time.LocalDateTime;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherremboursementFXMLController implements Initializable {

    @FXML
    private TextField motif;
    @FXML
    private TextField montant;

    @FXML
    private ListView<remboursement> list;

     serviceremboursement sre = new serviceremboursement();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        getRemboursements();
        // TODO
    }    
    
       public void getRemboursements(){
        serviceremboursement sre = new serviceremboursement();
              ObservableList<remboursement> items = FXCollections.observableArrayList();
         
        items.addAll(sre.afficher());
        list.setItems(items);
    }

    @FXML
    private void ChoisirEvent(MouseEvent event) {
        
         remboursement re = list.getItems().get(list.getSelectionModel().getSelectedIndex());   
        montant.setText(String.valueOf(re.getMontant_rembour()));
        motif.setText(String.valueOf(re.getMotif_rembour()));
        
          
    }

    @FXML
    private void ModifierAction(ActionEvent event) {
        
             serviceremboursement sre = new serviceremboursement();
        remboursement rE = list.getItems().get(list.getSelectionModel().getSelectedIndex());
        int id = rE.getId_rembour();
          remboursement re = new remboursement();
          Integer montant_rem = Integer.parseInt(montant.getText());
       
        re.setMotif_rembour(motif.getText());
        re.setMontant_rembour(montant_rem);
      //  re.setMontant_rembour(Integer.parseInt(montant.getText())); 
        LocalDateTime myDate = LocalDateTime.now();
        re.setDate_rembour(myDate);
       
        
           sre.modifier_remboursement(re,id);
       
        getRemboursements(); 
    }

    @FXML
    private void SupprimerAction(ActionEvent event) {
              remboursement re = list.getItems().get(list.getSelectionModel().getSelectedIndex());
             
           
             sre.supprimer_remboursement(re.getId_rembour());
             
            motif.setText("");
          
           //  typeR.setText("");
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("remboursement supprimé");
        alert.setContentText("remboursement deleted successfully!");
        alert.showAndWait();   
        getRemboursements();
    }
    
}
