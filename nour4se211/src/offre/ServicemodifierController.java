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
public class ServicemodifierController implements Initializable {

    /**
     * Initializes the controller class.
     */
   
       @FXML 
    private TextField nonservicemodf;
       @FXML 
    private TextArea textemodif;
       
        @FXML 
    private TextField prixservicemofi;
        
 

 @FXML
       
private Button modifierservice;
@FXML 
private Button retour1;
@FXML 

private void modifierservice(ActionEvent event){
   
   
     
         String prix= prixservicemofi.getText();
        int prix1=Integer.parseInt(prix);
        String  nonservice=nonservicemodf.getText();
        String descriptionservice=textemodif.getText();
       serviceService sv = new  serviceService();
       
        service v = new service(nonservice,descriptionservice,prix1);
        sv.modifierservice(v);
        
        try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("serviceafficher.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(ServiceafficherController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
       
       
       
    }   
@FXML 
    private void retour1(ActionEvent event){
         try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("serviceafficher.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(ServiceafficherController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
       
    
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void setPrix(int prix1) {
           prixservicemofi.setText(String.valueOf(prix1));
    }

   

    void setnomservice(String  nomservice) {
           nonservicemodf.setText(nomservice);
    }

    void setdespription(String description) {
       textemodif.setText(description);
    }
    
}
