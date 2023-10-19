/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AcceuilresController implements Initializable {

    @FXML
    private Button gestionres;
    @FXML
    private Button gestionfact;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void gestionres(ActionEvent event) {
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("ajouterReservation.FXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Ajouter une réservation");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AjouterReservationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };

    }

    @FXML
    private void gestionfact(ActionEvent event) {
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("factureajout.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Ajouter une facture");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(FactureajoutController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
    
}
