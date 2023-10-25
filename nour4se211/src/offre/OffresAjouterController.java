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
import java.net.PasswordAuthentication;
import java.net.URL;
import static java.rmi.Naming.list;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.mail.Authenticator;


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

    private TextField destination;

@FXML

    private TextField prix;
@FXML
    private DatePicker debut;
@FXML
    private DatePicker fin;


@FXML 
private Button Ajouteroffres;

@FXML 
private Button retourdeAjouter;
   
@FXML
private ComboBox<String> servicess;
@FXML
private ObservableList<String> servicesss;

// Vous avez besoin de la liste des services disponibles avec leurs ID
  private List<service> serviceList = new ArrayList<>();

private service findServiceByName(String serviceName, List<service> serviceList) {
    for (service s : serviceList) {
        if (s.getNom_service().equals(serviceName)) {
            return s; // Retourne le service correspondant
        }
    }
    return null; 
}


@FXML
private void Ajouteroffres(ActionEvent event) {
    // Extrait les valeurs des champs
    String Date1 = debut.getValue() != null ? debut.getValue().toString() : null;
    String Date2 = fin.getValue() != null ? fin.getValue().toString() : null;
    String destination1 = destination.getText();
    String pr = prix.getText();
    String selectedServiceName = servicess.getValue();

    // Vérifie si des champs obligatoires sont vides
    if (Date1 == null || Date2 == null || destination1.isEmpty() || pr.isEmpty() || selectedServiceName == null) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    }

    // Convertit les valeurs
    Date dèbut = Date.valueOf(Date1);
    Date fin = Date.valueOf(Date2);
    int prix = Integer.parseInt(pr);

    service selectedService = findServiceByName(selectedServiceName, serviceList);
        if (selectedService != null) {
        // Get the service details
        String description = selectedService.getDescription_service();
     int prix1 = selectedService.getPrix_service();
        }
    if (validateDates(dèbut, fin)) {
        // Si les dates sont valides, ajoute l'offre
        serviceOffres soo = new serviceOffres();
        soo.ajouter(new offres(destination1, dèbut, fin, prix, selectedService));
        envoyerCourrierElectronique(destination1, dèbut, fin, prix, selectedService);

        // Redirige vers une autre vue
        try {
            Parent parent3 = FXMLLoader.load(getClass().getResource("Affoffres.fxml"));
            Scene scene = new Scene(parent3);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("offres");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AffoffresController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } else {
        // Affiche un message d'erreur si les dates ne sont pas valides
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Date incorrecte");
        alert.showAndWait();
    }
}


private void envoyerCourrierElectronique(String destination, Date début, Date fin, int prix, service selectedService) {
    // Configuration des paramètres de messagerie
    final String emailUsername = "lassoued.nour@esprit.tn";
    final String emailPassword = "223JFT1127";
    /*
    Properties props = new Properties();
    
    props.put("mail.smtp.host", "votre-serveur-smtp.com");
    props.put("mail.smtp.port", "Votre-port-SMTP");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
     /* props.put("mail.smtp.port", "587");*/
     Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com"); // Use Gmail's SMTP server
    props.put("mail.smtp.port", "587"); // Port for TLS
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.transport.protocol", "smtp");

      
   
    Session session = Session.getInstance(props, new MyAuthenticator(emailUsername, emailPassword));
       
     
      
       try {
       
        Message email = new MimeMessage(session);
        email.setFrom(new InternetAddress("lassoued.nour@esprit.tn"));
        email.setRecipient(Message.RecipientType.TO, new InternetAddress("lassoued.nour@esprit.tn"));
        email.setSubject("Nouvelle offre ajoutée : " + destination);
        email.setText("Nouvelle offre ajoutée à destination de " + destination +
                    "\nDate de début : " + début +
                    "\nDate de fin : " + fin +
                    "\nPrix : " + prix +
                    "\nService : " + selectedService.getNom_service());
        Transport.send(email);

        System.out.println("Courrier électronique envoyé avec succès.");
    } catch (MessagingException ex) {
        ex.printStackTrace();
        System.err.println("Erreur lors de l'envoi du courrier électronique : " + ex.getMessage());
    }
    

}

@FXML
private void retourdeAjouter(ActionEvent event) {
     try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("Admineoffreespace.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AdmineoffreespaceController.class.getName()).log(Level.SEVERE, null, ex); 
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
       
 
        
 
     serviceList.add(new service(1, "kids", "Service for kids", 50));
        serviceList.add(new service(2, "couple", "Service for couples", 100));
               serviceList.add(new service(3, "groupe", "Service for groupe", 200));
                serviceList.add(new service(4, "Visites Guidées", "Découvrez Florence, Pise, Sienne et San Gimignano avec nos guides experts.", 100));
        // Remplissez la ComboBox avec les éléments de la liste
                serviceList.add(new service(5, "Assistance 24/7", "Un guide local veillera à votre confort et répondra à vos besoins en permanence.", 200));
         servicesss = FXCollections.observableArrayList("kids", "couple","groupe","Visites Guidées","Assistance 24/7");
         
       servicess.getItems().addAll("kids", "couple","groupe", "Visites Guidées","Assistance 24/7");
  
    
         
;
}
}
