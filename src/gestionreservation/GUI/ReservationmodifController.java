/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceReservation;
import java.net.URL;
import java.sql.Date;
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
     private TextField idreservat;
    private TextField cinclientresmodif;
    private TextField nomresmodif;
    private DatePicker datedebmodif;
    private DatePicker datefmodif;
    private TextField nbperresmodif;
    private ComboBox typeheberresmodif;
    private ComboBox typeacresmodif;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list=FXCollections.observableArrayList("Hotels","Motels","Auberges","Chambres d'hotes","Auberges de jeunesse");
        typeheberresmodif.setItems(list);
        
        ObservableList<String> list1=FXCollections.observableArrayList("Visite de musées","activités nautiques","Randonnée","safari","escalade"," Séjours dans des spas","yoga");
        typeacresmodif.setItems(list1);
    }   
    
     private void buttonSauvmodif(ActionEvent event) {
     String datereservation1 = datedebmodif.getValue().toString();
        String datereservation2 = datefmodif.getValue().toString();
        Date sqlDate11 = Date.valueOf(datereservation1);
        Date sqlDate22= Date.valueOf(datereservation2);
        String id3Text = idreservat.getText();
        int idres1 = Integer.parseInt(id3Text);
        ServiceReservation serviceReservation = new ServiceReservation();
        Reservation reservation = new Reservation();

        Date dateDebut = java.sql.Date.valueOf(datedebmodif.getValue());
        Date dateFin = java.sql.Date.valueOf(datefmodif.getValue());

        reservation.setDateDebut(dateDebut);
        reservation.setDateFin(dateFin);
        reservation.setCinClient(Integer.parseInt(cinclientresmodif.getText()));
reservation.setNomClient(nomresmodif.getText());
reservation.setNombrePersonnes(Integer.parseInt(nbperresmodif.getText()));
reservation.setTypeHebergement(typeheberresmodif.getSelectionModel().getSelectedItem().toString());
reservation.setTypeActivite(typeacresmodif.getSelectionModel().getSelectedItem().toString());
reservation.setIdReservation(idres1);

serviceReservation.modifierReservation(reservation);
       
     }
     
     
}
