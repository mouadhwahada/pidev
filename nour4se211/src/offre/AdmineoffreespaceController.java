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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AdmineoffreespaceController implements Initializable {

    @FXML
    private Button admineservice;
    @FXML
    private Button admineoffre;
    @FXML
    private Button adminelistoff;
    @FXML
    private Button adminelist;
 @FXML
    private Button menuHome;

    /**
     * Initializes the controller class.
     */
     

    @FXML
    private void admineservice(ActionEvent event) {
          try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("AjouterService.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AjouterServiceController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
       
       
       
    }  
    
    @FXML
    private void menuHome(ActionEvent event) {
        
    }
        
      @FXML
    private void admineoffre(ActionEvent event) {
           try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("offresAjouter.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(OffresAjouterController.class.getName()).log(Level.SEVERE, null, ex); 
    }
    }
    

    @FXML
    private void adminelistoff(ActionEvent event) {
           try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("affoffres.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(AffoffresController.class.getName()).log(Level.SEVERE, null, ex); 
    }
    }
    

    @FXML
    private void adminelist(ActionEvent event) {
         try { 
        Parent parent2=FXMLLoader .load(getClass().getResource("serviceafficher.fxml"));
        Scene scene=new Scene(parent2); 
        Stage stage=(Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setScene(scene); stage.setTitle("Affichage"); stage.show();
    } catch (IOException ex) { 
        Logger.getLogger(ServiceafficherController.class.getName()).log(Level.SEVERE, null, ex); 
    } 
    
    }
      @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    
    
}}
