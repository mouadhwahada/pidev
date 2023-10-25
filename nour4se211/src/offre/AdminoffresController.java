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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import voyages.offres.grud.serviceOffres;
import voyages.offres.offres;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdminoffresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML 
private ListView<String>listclientoffres;
    
    @FXML 
private Button Réserver;

@FXML
private TextField prixMaxTextField;
@FXML
private TextField destinationTextField;
   @FXML
private Button filterButton ;
  @FXML
private Button menuh1 ;
  @FXML
private Button Statistique ;

  
  
    
    public class ImageListCell extends ListCell<String> {
    private ImageView imageView = new ImageView();
    // Set the preferred width and height
    private double imageWidth = 250; // Adjust this to your desired width
    private double imageHeight = 200; // Adjust this to your desired height

    public ImageListCell() {
        // Set the dimensions for the ImageView
        imageView.setFitWidth(imageWidth);
        imageView.setFitHeight(imageHeight);
    }
   
     protected void updateItem(String item, boolean empty) {
            super.updateItem(item, empty);

            if (item == null || empty) {
                setText(null);
                setGraphic(null);
            } else {
                setText(item);

                String imagePath = getImagePathForDestination(item);

                Image icon = new Image(getClass().getResourceAsStream(imagePath));
                imageView.setImage(icon);

                setGraphic(imageView);
            }
        }
    }

    private String getImagePathForDestination(String destination) {
        if (destination.contains("destination:Rome")) {
            return "Italie.jpg";
        } else if (destination.contains("destination:Dubai")) {
            return "dubai.jpg";
        } else if (destination.contains("destination:Hammamet")) {
            return "hammet.jpeg";
        } else if (destination.contains("destination:Turquie")) {
            return "turki.jpeg";
        } else if (destination.contains("destination:France")) {
            return "9c.jpg";
        } else if (destination.contains("destination:Berlin")) {
            return "R.jpeg";
        } else {
            return "r1.png";
        }
    }
    
     
    @FXML 
   private void Réserver(ActionEvent event) {
   }
    
    
    
    @FXML 
   private void Statistique(ActionEvent event) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("Stat.fxml"));


        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
   }
  @FXML 
   private void menuh1(ActionEvent event) {
   }

  
   @FXML
private void filterButton(ActionEvent event) {
}


@FXML
private void filterOffres(ActionEvent event) {
   
String selectedDestination = destinationTextField.getText();
        int maxPrice = Integer.parseInt(prixMaxTextField.getText());

        serviceOffres so = new serviceOffres();
        List<offres> filteredOffres = so.filterOffres(selectedDestination, maxPrice);

        if (filteredOffres.isEmpty()) {
            // Aucun résultat trouvé, afficher une alerte
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Aucun résultat trouvé");
            alert.setHeaderText(null);
            alert.setContentText("Aucune offre ne correspond à la destination et au prix spécifiés.");
            alert.showAndWait();
            
        } else {
            List<String> filteredItems = new ArrayList<>();
           
        
            
            for (offres offre : filteredOffres) {
                String serviceInfo = "Service: " + offre.getService().getNom_service();
                String prix1 = "Prix: " + offre.getPrix();
                String offresString = "Destination: " + offre.getDestination() + "\n" +
                        "Début: " + offre.getDébut() + "\n" +
                        "Fin: " + offre.getFin() + "\n" +
                        prix1 + "\n" + serviceInfo;
                
                filteredItems.add(offresString);
            }
            ObservableList<String> observableFilteredItems = FXCollections.observableArrayList(filteredItems);
            listclientoffres.setItems(observableFilteredItems);
              
        
        }
}




   
    @Override
 public void initialize(URL url, ResourceBundle rb) {
            serviceOffres soo2 = new serviceOffres();
           List<offres>offres1 = soo2.fetchoffres();
          List<String>itemoffre =new ArrayList<>();

    
        for(offres offress : offres1) {
      
     String serviceInfo = "Service:" + String.valueOf(offress.getService().getNom_service());
         String prix1="prix:" + String.valueOf(offress.getPrix());
         String offresstring="destination:"+offress.getDestination()+"\n"+"début:"+offress.getDébut()+"\n" +"fin:"+offress.getFin()+"\n"+prix1+"\n"+serviceInfo;

            itemoffre.add(offresstring);
        }
          ObservableList<String> obdervabelist = FXCollections.observableArrayList(itemoffre);
        listclientoffres.setCellFactory(param  -> new ImageListCell());
         listclientoffres.setItems(obdervabelist);
         
      filterButton.setOnAction(this::filterOffres);

    

}


}
