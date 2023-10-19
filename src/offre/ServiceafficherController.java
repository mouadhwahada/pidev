/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.io.IOException;
import java.net.URL;
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
import voyages.offres.grud.serviceService;
import voyages.offres.service;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ServiceafficherController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
private Button affichservice;
@FXML 
private Button modifierservice;
@FXML 
private Button supprimerservice;
 
    @FXML 
private ListView<String> servicelist;
    
    @FXML 
    private void affichservice(ActionEvent event) {
    
     serviceService soo1 = new serviceService();

      ObservableList<String> itemsoff = FXCollections.observableArrayList();
        List<service> service1 = soo1.fetchservice();
        for (service service : service1) {
      
      
String referen="réference:"+String.valueOf(service.getReference_se());
         String prix2="prix_service:" + String.valueOf(service.getPrix_service());
        String servicesstring="nom_service:"+service.getNom_service()+"\n"+"description_service:"+service.getDescription_service()+"\n"+prix2+" \n"+referen;

                       itemsoff.add(servicesstring);

        }
         servicelist.setItems(itemsoff);
        
    
      
    }
    @FXML 

private void modifierservice(ActionEvent event) {
    
     try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("servicemodifier.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Modifier"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(ServicemodifierController.class.getName()).log(Level.SEVERE, null, ex); 
    } ;

    String selectedItem = servicelist.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("servicemodifier.fxml"));
        Parent root = loader.load();
        ServicemodifierController modifserviceController = loader.getController();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        
        String[] data = selectedItem.split("\n");
       
       
for (String line : data) {
    if (line.startsWith("nom_service:")) {
                        String nomservice = line.replace("nom_service:", "").trim();
        modifserviceController.setnomservice(nomservice);
  } else if (line.startsWith("description_service:")) {
        String description = line.replace("description_service: ","").trim();
         modifserviceController.setdespription(description);
       
        
        
    } else if (line.startsWith("prix_service:")) {
        int prix1 = Integer.parseInt(line.replace("prix_service:", "").trim());
        modifserviceController.setPrix(prix1);
    }
            else if (line.startsWith("réference:")) {
        int réferencese = Integer.parseInt(line.replace("réference:", "").trim());
        modifserviceController.setRéference(réferencese);
    }
  
    
    
}

       

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
};


   

    

    
}
@FXML 

    private void supprimerservice(ActionEvent event){
           
   serviceService sv = new serviceService();
    int selectedIndex = servicelist.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        // Obtenez la chaîne sélectionnée de la ListView
        String selectedreference =servicelist.getItems().get(selectedIndex);

        // Trouvez la ligne qui contient le numéro de facture
        String[] lines = selectedreference.split("\n");
        String réferenceLine = null;
        for (String line : lines) {
            if (line.startsWith("réference:")) {
                réferenceLine = line;
                break;
            }
        }

        if (réferenceLine != null) {
            // Extrait le numéro de facture de la ligne
            String réference1 = réferenceLine.replace("réference:", "").trim();
            
             // Convertissez le numéro de facture en int
            int idservice = Integer.parseInt(réference1);

            // Supprimez la facture de la base de données
            sv.supprimerService(idservice);

            // Supprimez l'élément de la ListView
            servicelist.getItems().remove(selectedIndex);
        }
       
        
    }
    }


@FXML 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          

       
    }    
    
}
