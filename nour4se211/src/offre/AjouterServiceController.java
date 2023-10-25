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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    private Button retourrajoutse;
    @FXML
    private void Ajouterservice(ActionEvent event){
   /*
    String nomdeservice1=nomdeservice.getText();
    String texteservice1=texteservice.getText();
     String prixService1=prixService.getText();
   int  prix1=Integer.parseInt(prixService1);
    // Vérifie si des champs obligatoires sont vides
    if ( nomdeservice1.isEmpty() || texteservice1.isEmpty() || prixService1.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    } 
  
    serviceService soo2 = new serviceService();
    soo2.ajouterService(new service(nomdeservice1,texteservice1,prix1));
    
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
    */
   String nomdeservice1 = nomdeservice.getText();
    String texteservice1 = texteservice.getText();
    String prixService1 = prixService.getText();

    // Vérifie si des champs obligatoires sont vides
    if (nomdeservice1.isEmpty() || texteservice1.isEmpty() || prixService1.isEmpty()) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Veuillez remplir tous les champs.");
        alert.showAndWait();
        return;
    }

    // Vérifie si le champ de prix n'est pas vide et s'il contient un nombre valide
    int prix1;
    try {
        prix1 = Integer.parseInt(prixService1);
    } catch (NumberFormatException e) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erreur");
        alert.setHeaderText(null);
        alert.setContentText("Le champ de prix doit contenir un nombre valide.");
        alert.showAndWait();
        return;
    }

    serviceService soo2 = new serviceService();
    soo2.ajouterService(new service(nomdeservice1, texteservice1, prix1));

    try {
        Parent parent2 = FXMLLoader.load(getClass().getResource("serviceafficher.fxml"));
        Scene scene = new Scene(parent2);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Affichage");
        stage.show();
    } catch (IOException ex) {
        Logger.getLogger(ServiceafficherController.class.getName()).log(Level.SEVERE, null, ex);
    }






}
    @FXML
    private void retourrajoutse(ActionEvent event){
         try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("Admineoffreespace.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AdmineoffreespaceController.class.getName()).log(Level.SEVERE, null, ex); 
    }
    
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 

    
}