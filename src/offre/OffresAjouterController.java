/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.Instant;
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
import java.time.ZoneId;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;



import voyages.offres.grud.serviceOffres;
import voyages.offres.offres;
import voyages.offres.service;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class OffresAjouterController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     */
    @FXML 
    private TextField réference;
@FXML

    private TextField destination;

@FXML

    private TextField prix;
@FXML
    private DatePicker debut;
@FXML
    private DatePicker fin;
@FXML
    private TextField serv1;
@FXML 
private Button Ajouteroffres;


@FXML 

private void Ajouteroffres(ActionEvent event) {  
    
    String ref=réference.getText();
    int réfe=Integer.parseInt(ref);
   
         String Date1=debut.getValue().toString();
         String Date2=fin.getValue().toString();
         Date Datedebut =Date.valueOf(Date1);
          Date Datefin =Date.valueOf(Date2);
         String destination1=destination.getText();  
        
     String pr=prix.getText();
    int prx=Integer.parseInt(pr);
     String srv = serv1.getText();
    int ss =Integer.parseInt(srv);
    service s = new service();
    s.setReference_se(ss);
    serviceOffres soo = new serviceOffres();
    if(validateDates(Datedebut,Datefin)){
        
    }else{
        JOptionPane.showMessageDialog(null,
    "Date incorrecte", "Inane error",
    JOptionPane.ERROR_MESSAGE);
    }
    soo.ajouter(new offres(destination1,Datedebut,Datefin,prx,réfe,s));


    try { 
        Parent parent3=FXMLLoader.load(getClass().getResource("Affoffres.fxml"));
        Scene scene=new Scene(parent3); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("offres"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AffoffresController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
    
    
}

     private boolean validateDates(Date d1,Date d2) {
        try {
                    return !d1.after(d2);
         
           
        } catch (Exception e) {
            return false;
        }
     }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
