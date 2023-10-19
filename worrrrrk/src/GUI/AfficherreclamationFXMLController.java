/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import static com.sun.webkit.perf.WCFontPerfLogger.reset;
import esprit.entities.reclamation;
import esprit.services.Servicereclamation;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficherreclamationFXMLController implements Initializable {

    @FXML
    private ListView<reclamation> list;
    @FXML
    private Button Modifier;
    @FXML
    private Button Supprimer;
    @FXML
    private TextField nomR;
    @FXML
    private TextField descR;
    @FXML
    private TextField typeR;
 Servicereclamation sr = new Servicereclamation();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
           getReclamations();
         
         
        
         
        
    }  
    
    public void getReclamations(){
        Servicereclamation sr = new Servicereclamation();
              ObservableList<reclamation> items = FXCollections.observableArrayList();
         
        items.addAll(sr.afficher());
        list.setItems(items);
    }


    @FXML
    private void ModifierAction(ActionEvent event) {
        Servicereclamation sr = new Servicereclamation();
        reclamation rA = list.getItems().get(list.getSelectionModel().getSelectedIndex());
        int id = rA.getId();
          reclamation r = new reclamation();
          
       
        r.setType(typeR.getText());
        r.setDescription(descR.getText());
        r.setNom(nomR.getText());
        LocalDateTime myDate = LocalDateTime.now();
        r.setDate_reclama(myDate);
       
        
            
        sr.modifier_reclamation(r,id);
        getReclamations(); 
    }

    
    @FXML
    private void SupprimerAction(ActionEvent event) {
             reclamation r = list.getItems().get(list.getSelectionModel().getSelectedIndex());
             
           
             sr.supprimer_reclamation(r.getId());
             
            nomR.setText("");
             descR.setText("");
             typeR.setText("");
         
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information ");
        alert.setHeaderText("reclamation supprimé");
        alert.setContentText("reclamation deleted successfully!");
        alert.showAndWait();   
        getReclamations();
        
        
    }

    @FXML
    private void choisirEvent(MouseEvent event) {
          reclamation r = list.getItems().get(list.getSelectionModel().getSelectedIndex());   
        //idLabel.setText(String.valueOf(e.getId_event()));
        nomR.setText(String.valueOf(r.getNom()));
        descR.setText(r.getDescription());
        typeR.setText(r.getType());
          
        
   
    }
    
}
