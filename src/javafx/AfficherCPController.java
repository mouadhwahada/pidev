/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceCP;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AfficherCPController implements Initializable {

    @FXML
    private ListView<CodePromo> list;
    @FXML
    private Button showbtn;
    @FXML
    private Button backbtn;
    @FXML
    private Button addbtn;

    
         private CodePromo selectedCP;
    @FXML
    private Button modifierbtn;
    @FXML
    private Button deletebtn;
    @FXML
    private Button qrcodebtn;

    /**
     * Initializes the controller class.
     */
   @Override
public void initialize(URL url, ResourceBundle rb) {
        
        show(null);

    list.setOnMouseClicked(event -> {
        selectedCP = list.getSelectionModel().getSelectedItem();
    });

        //
    list.setCellFactory(param -> new ListCell<CodePromo>() {
     private final SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    protected void updateItem(CodePromo item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
             Date expirationDate = item.getDatedexpiration();
            String formattedDate = dateFormat.format(expirationDate);
           setText("Code: " + item.getCode()  + "\n" +
                    "Value: " + item.getDescription() + "\n" +
                    "Date d'expiration: " + formattedDate);
        }
    }
});

    
}


    @FXML
    private void show(ActionEvent event) {
       
        ServiceCP cp = new ServiceCP();
        ObservableList<CodePromo> items = FXCollections.observableArrayList();
         
        items.addAll(cp.getAlluti(new CodePromo()));
        list.setItems(items);
        
        
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Backoffice.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Espace Administration");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void Add(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AjouterCP.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Ajouter Code Promo");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) addbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void modifiercp(ActionEvent event) {
       try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierCP.fxml"));
            Parent root = loader.load();

            
           
                ModifierCPController modifierController = loader.getController();

              
                modifierController.initData(selectedCP);
            
            
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Cupon Code Update");

            modifierStage.show();

            Stage currentStage = (Stage) modifierbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        
    }

    @FXML
    private void delete(ActionEvent event) {
  try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerCP.fxml"));
            Parent root = loader.load();

            
           
                SupprimerCPController supprimerController = loader.getController();

              
                supprimerController.initData(selectedCP);
            
            
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Are you sure ?");

            modifierStage.show();

            Stage currentStage = (Stage) deletebtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    
}

    @FXML
    private void qrCode(ActionEvent event) {
         try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BarCode.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Qr Codes");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) qrcodebtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
}
