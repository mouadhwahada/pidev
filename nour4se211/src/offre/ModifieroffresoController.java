/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    private TextField prixmo;
    private CharSequence datepick;
@FXML
private ComboBox<String> servicemodif;
@FXML
private ObservableList<String> servicesss;

// Vous avez besoin de la liste des services disponibles avec leurs ID
  private List<service> serviceList = new ArrayList<>();
    /**
     * Initializes the controller class.
     */
  private service findServiceByName(String serviceName, List<service> serviceList) {
    for (service s : serviceList) {
        if (s.getNom_service().equals(serviceName)) {
            return s; // Retourne le service correspondant
        }
    }
    return null; // Retourne null si aucun service correspondant n'a été trouvé
}

      

    @FXML
    private void Modifierrofres(ActionEvent event) {
         serviceOffres sv = new serviceOffres();
          /*
         String prix= prixmo.getText();
        int prix1=Integer.parseInt(prix);
        String destination=destinationmo.getText();*/
           String selectedServiceName = servicemodif.getValue();
           

   
    service selectedService = findServiceByName(selectedServiceName, serviceList);
   
   
       
          
          String Date1=debutmo.getValue().toString();
         String Date2=finmo.getValue().toString();
         /*
         Date dèbut =Date.valueOf(Date1);
          Date fin1 =Date.valueOf(Date2);*/
         Date datedebut = java.sql.Date.valueOf(debutmo.getValue());
        Date dateFin = java.sql.Date.valueOf(finmo.getValue());
        /*
       offres v = new offres(destination ,dateDebut,dateFin,prix1,selectedService);
        sv.modifierOffres(v);
        */
        offres v =new offres();
      v.setDébut(datedebut);
v.setFin(dateFin);
v.setPrix(Integer.parseInt(prixmo.getText()));
v.setDestination(destinationmo.getText());
 sv.modifierOffres(v);

         
        
      
        
        
       try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("affoffres.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AffoffresController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
       
       
       
    }      
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceList.add(new service(1, "kids", "Service for kids", 50));
        serviceList.add(new service(2, "couple", "Service for couples", 100));
               serviceList.add(new service(3, "groupe", "Service for groupe", 200));
        // Remplissez la ComboBox avec les éléments de la liste
         servicesss = FXCollections.observableArrayList("kids", "couple","groupe");
       servicemodif.getItems().addAll("kids", "couple","groupe");
        // TODO
    }  

    void setDestination(String destination) {
        destinationmo.setText(destination);
       
    }

    void setPrix(int prix) {
       prixmo.setText(String.valueOf(prix));
    }

   

    void setDeatedebut(String datedebut) {
       try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(datedebut, formatter);
        debutmo.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    }
    }

    void setdatefin(String datefin) {
        try {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate localDate = LocalDate.parse(datefin, formatter);
        finmo.setValue(localDate);
    } catch (Exception e) {
        // Gérer l'erreur en cas d'échec de la conversion
        e.printStackTrace();
    }
    }

    
    

    void setServices(String services) {
     servicemodif.setValue(services); 
        
}
}