/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.io.IOException;
import java.net.URL;
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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import voyages.offres.grud.serviceOffres;
import voyages.offres.offres;
import voyages.offres.service;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AffoffresController implements Initializable {

    /**
     * Initializes the controller class.
     */
       
    @FXML 
private ListView<String>listo;
    @FXML 
private Button offresaa;
       @FXML 
private Button Modifieroffre;
        @FXML 
private Button Supprimeroffre;
        
          @FXML 
private Button retourlistoffres;
          
          @FXML 
private Button stat;
        
           
   @FXML 
   private void offresaa(ActionEvent event) {
       
       
       serviceOffres soo2 = new serviceOffres();
           List<offres>offres1 = soo2.fetchoffres();
          List<String>itemoffre =new ArrayList<>();

    
        for(offres offress : offres1) {
      
String serviceInfo = "Service:" + String.valueOf(offress.getService().getNom_service()); // Récupérez le nom du service
         String prix1="prix:" + String.valueOf(offress.getPrix());
         String offresstring="destination:"+offress.getDestination()+"\n"+"début:"+offress.getDébut()+"\n" +"fin:"+offress.getFin()+"\n"+prix1+"\n"+serviceInfo;

            itemoffre.add(offresstring);
        }
        ObservableList<String> obdervabelist = FXCollections.observableArrayList(itemoffre);
         listo.setItems(obdervabelist);
        
   }

     @FXML 
   private void retourlistoffres(ActionEvent event) {
           try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("Admineoffreespace.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AdmineoffreespaceController.class.getName()).log(Level.SEVERE, null, ex); 
    }
    
       
       
   }
 

   
    @FXML 
   private void Modifieroffre(ActionEvent event) {
        String selectedItem = listo.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
      try { 
          FXMLLoader loader = new FXMLLoader(getClass().getResource("modifieroffreso.fxml"));
         
        
        Parent root = loader.load();
        ModifieroffresoController modifserviceController = loader.getController();
         Stage stage = new Stage();
        stage.setScene(new Scene(root));
    
        

        
        String[] data = selectedItem.split("\n");
       
       
for (String line : data) {
    if (line.startsWith("destination:")) {
       String destination = line.replace("destination:", "").trim();
        modifserviceController.setDestination(destination);
  } else if (line.startsWith("début:")) {
        String datedebut = line.replace("début:", "").trim();
           modifserviceController.setDeatedebut(datedebut);
        } else if (line.startsWith("fin:")) {
        String datefin = line.replace("fin:", "").trim();
        modifserviceController.setdatefin(datefin);
        
        
    } else if (line.startsWith("prix:")) {
        int prix = Integer.parseInt(line.replace("prix:", "").trim());
        modifserviceController.setPrix(prix);
    
    }
    else if (line.startsWith("Service:")) {
        String services = line.replace("Service:", "").trim();
        modifserviceController.setServices(services);
    }
    
    
}

        // Faites de même pour les autres données (montant, référence, date de paiement, etc.)

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
};


   

   }  
   @FXML
    private void stat(ActionEvent event) throws IOException {
       
       
        Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));


        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML 
   private void Supprimeroffre(ActionEvent event) {
      
   serviceOffres sv1 = new serviceOffres();
    int selectedIndex = listo.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        // Obtenez la chaîne sélectionnée de la ListView
        String selectedreference =listo.getItems().get(selectedIndex);

        // Trouvez la ligne qui contient le numéro de facture
        String[] lines = selectedreference.split("\n");
        String réferenceLine = null;
        for (String line : lines) {
            if (line.startsWith("destination:")) {
                réferenceLine = line;
                break;
            }
        }

        if (réferenceLine != null) {
            
            String destination = réferenceLine.replace("destination:", "").trim();
            
           
         

            
            sv1. supprimeroffres(destination);

            // Supprimez l'élément de la ListView
            listo.getItems().remove(selectedIndex);
        }
    }
       
       
       
   
       
   }
   
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
        
   }


        // Convertissez les données Facture en chaînes
        
    }



