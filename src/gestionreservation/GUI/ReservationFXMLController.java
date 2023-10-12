/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

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
import gestion_reservation.services.ServiceFacture;
import gestion_reservation.services.ServiceReservation;
import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;
import java.time.LocalDate;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ReservationFXMLController implements Initializable {
   @FXML
    private TextField cinclientres;
   @FXML
    private TextField nomreservation;
    @FXML
    private DatePicker dateres1;
    @FXML
    private DatePicker dateres2;
    @FXML
    private TextField nbperres;
    @FXML
    private ComboBox typeheberres;
    @FXML
    private ComboBox typeacres;
     @FXML
    private Button buttajoutres;
   
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
        ObservableList<String> list=FXCollections.observableArrayList("Hotels","Motels","Auberges","Chambres d'hotes","Auberges de jeunesse");
        typeheberres.setItems(list);
        
        ObservableList<String> list1=FXCollections.observableArrayList("Visite de musées","activités nautiques","Randonnée","safari","escalade"," Séjours dans des spas","yoga");
        typeacres.setItems(list1);
        
    }    
    @FXML
    private void buttajoutres(ActionEvent event) {
        ServiceReservation res1 = new ServiceReservation();
         LocalDate localDate1 = LocalDate.parse(dateres1.getValue().toString());
         LocalDate localDate2 = LocalDate.parse(dateres2.getValue().toString());
         String Cinclientres=cinclientres.getText();
        int Cinclientres1=Integer.parseInt(Cinclientres);
        String nombreperso=nbperres.getText();
        int nbperresValue=Integer.parseInt(nombreperso);
        
         res1.ajouterReservation(new Reservation(localDate1,localDate2,Cinclientres1,nomreservation.getText(),nbperresValue,typeheberres.getSelectionModel().getSelectedItem().toString(),typeacres.getSelectionModel().getSelectedItem().toString()));
    }
     
     

    
}
