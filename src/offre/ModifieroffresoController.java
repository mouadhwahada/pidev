/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import voyages.offres.grud.serviceOffres;
import voyages.offres.grud.serviceService;
import voyages.offres.offres;
import voyages.offres.service;

/**
 * FXML Controller class
 *
 * @author ASUS
 */

public class ModifieroffresoController implements Initializable {

    @FXML
    private AnchorPane début;
    @FXML
    private TextField réferencemo;
    @FXML
    private TextField destinationmo;
    @FXML
    private DatePicker debutmo;
    @FXML
    private DatePicker finmo;
    @FXML
    private Button Modifierrofres;
    @FXML
    private TextField servicemo;
    @FXML
    private TextField prixmo;

    /**
     * Initializes the controller class.
     */
      

    @FXML
    private void Modifierrofres(ActionEvent event) {
       try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("affoffres.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AffoffresController.class.getName()).log(Level.SEVERE, null, ex); 
    } ;
    }      
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  

}