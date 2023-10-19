/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import voyages.offres.grud.serviceService;
import voyages.offres.service;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouterServiceController implements Initializable {
@FXML 
    private TextField réferenceservice ;
      
    
      @FXML 
    private TextField nomdeservice;
       @FXML 
    private TextArea texteservice;
       
        @FXML 
    private TextField prixService;
        
 

    @FXML
    private Button Ajouterservice;
    @FXML
    private void Ajouterservice(ActionEvent event){
   
    String nomdeservice1=nomdeservice.getText();
    String texteservice1=texteservice.getText();
     String prixService1=prixService.getText();
   int  prix1=Integer.parseInt(prixService1);
          
    String ref2=réferenceservice.getText();
    int réfe1=Integer.parseInt(ref2);
    serviceService soo2 = new serviceService();
    soo2.ajouterService(new service(nomdeservice1,texteservice1,prix1,réfe1));
    
        try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("serviceafficher.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(ServiceafficherController.class.getName()).log(Level.SEVERE, null, ex); 
    } ;
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
