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
   private void offresaa(ActionEvent event) {
       
       
       serviceOffres soo2 = new serviceOffres();
           List<offres> offres1 = soo2.fetchoffres();
          List<String>itemoffre =new ArrayList<>();

    /*  ObservableList<String> obdervabelist = FXCollections.observableArrayList(offres1);*/
       
     
    
       
       

       
        
     
        for(offres offres : offres1) {
       String service= "Service : " + String.valueOf(offres.getService().getReference_se());
      String re1="réference de offre : " + String.valueOf(offres.getRéference());

         String prix1="prix : " + String.valueOf(offres.getPrix());
         String offresstring="destination:"+offres.getDestination()+"\n"+"début:"+offres.getDébut()+"\n" +"fin:"+offres.getFin()+"\n"+prix1+"\n"+re1+"\n"+service;

            itemoffre.add(offresstring);
        }
        ObservableList<String> obdervabelist = FXCollections.observableArrayList(itemoffre);
         listo.setItems(obdervabelist);
        
   }

   
 

   
    @FXML 
   private void Modifieroffre(ActionEvent event) {
       
      try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("modifieroffreso.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(ModifieroffresoController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
      

/*
 String selectedItem = listo.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modiffacture.fxml"));
        Parent root = loader.load();
        ModifieroffresoController modifserviceController = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        
        String[] data = selectedItem.split("\n");
       
       
for (String line : data) {
    if (line.startsWith("destination:")) {
       String destination = line.replace("destination: ", "").trim();
        modifserviceController.setDestination(destination);
  } else if (line.startsWith("début:")) {
        String datePaiement = line.replace("début: ", "").trim();
        } else if (line.startsWith("fin:")) {
        String datePaiement = line.replace("fin: ", "").trim();
        
        
    } else if (line.startsWith("prix:")) {
        int prix = Integer.parseInt(line.replace("prix: ", "").trim());
        modifserviceController.setPrix(prix);
    }
            else if (line.startsWith("réference de offre :")) {
        int réference = Integer.parseInt(line.replace("réference de offre : ", "").trim());
        modifserviceController.setRéference(réference  );
    }
    else if (line.startsWith("Service:")) {
        int services = Integer.parseInt(line.replace("Service: ", "").trim());
        modifserviceController.setService(services);
    }
    
    
}

        // Faites de même pour les autres données (montant, référence, date de paiement, etc.)

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
};

*/
   

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
            if (line.startsWith("réference de offre :")) {
                réferenceLine = line;
                break;
            }
        }

        if (réferenceLine != null) {
            
            String réference1 = réferenceLine.replace("réference de offre :", "").trim();
            
           
             int idoffrres = Integer.parseInt(réference1);

            
            sv1. supprimeroffres(idoffrres);

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



