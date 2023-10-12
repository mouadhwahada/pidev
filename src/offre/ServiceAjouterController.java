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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import voyages.offres.grud.serviceService;
import voyages.offres.service;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ServiceAjouterController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML 
    private TextField nomdeservice;
       @FXML 
    private TextArea texteAs;
        @FXML 
    private TextField prixService;
        @FXML 
    private TextField  description;

       @FXML
       
private Button Ajouterservice;
@FXML 

private void Ajouterservice(ActionEvent event){
   
    String nomdeservice1= nomdeservice.getText();
             String ndescription1= description.getText();
   
     String pr1=prixService.getText();
     
    int prx=Integer.parseInt(pr1);
    
     
    serviceService s1 = new serviceService ();
    s1.ajouterService(new service ( nomdeservice1,ndescription1,prx));
  
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
