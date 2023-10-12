/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceReservation;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class ReservationmodifController implements Initializable {

    /**
     * Initializes the controller class.
     */
      @FXML 
     private TextField idreservat;
     @FXML
    private TextField cinclientresmodif;
      @FXML
    private TextField nomresmodif;
    @FXML
    private DatePicker datedmodif;
    @FXML
    private DatePicker datefmodif;
    @FXML
    private TextField nbperresmodif;
    @FXML
    private ComboBox typeheberresmodif;
    @FXML
    private ComboBox typeacresmodif;
     @FXML
    private Button buttonsauvmodif;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list=FXCollections.observableArrayList("Hotels","Motels","Auberges","Chambres d'hotes","Auberges de jeunesse");
        typeheberresmodif.setItems(list);
        
        ObservableList<String> list1=FXCollections.observableArrayList("Visite de musées","activités nautiques","Randonnée","safari","escalade"," Séjours dans des spas","yoga");
        typeacresmodif.setItems(list1);
    }   
    
    
     
}
