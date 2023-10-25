/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class ModifierUserController implements Initializable {

    @FXML
    private TextField nomField;
    @FXML
    private TextField prenomField;
    @FXML
    private TextField emailField;
    @FXML
    private TextField pseudoField;
    @FXML
    private PasswordField mdpField;
    @FXML
    private Button modifierButton;
    
        private User selectedUser; // Store the selected user
    @FXML
    private TextField cinfield;
    @FXML
    private Button backbtn;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       // Initialize the form with the selected user's data
        if (selectedUser != null) {
            
            cinfield.setText(selectedUser.getCin());
            nomField.setText(selectedUser.getNom());
            prenomField.setText(selectedUser.getPrenom());
            emailField.setText(selectedUser.getEmail());
            pseudoField.setText(selectedUser.getPseudo());
            mdpField.setText(selectedUser.getMdp());
        }
    }    

    public void initData(User user) {
        // Receive the selected user data
        selectedUser = user;
    }
    
    @FXML
    private void modifierUser(ActionEvent event) {
        if (selectedUser != null) {
            

            selectedUser.setCin(cinfield.getText());
            selectedUser.setNom(nomField.getText());
            selectedUser.setPrenom(prenomField.getText());
            selectedUser.setEmail(emailField.getText());
            selectedUser.setPseudo(pseudoField.getText());
            selectedUser.setMdp(mdpField.getText());
                    
           
            ServiceUser su = new ServiceUser();
            su.modifier(selectedUser);

                   
            
            
            modifierButton.getScene().getWindow().hide();
             try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherUser.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Users List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        }
         else {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setContentText("Sélectionnez un utilisateur à modifier.");
        alert.showAndWait();
    }
    }

    @FXML
    private void Back(ActionEvent event) {
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
        
    }
    

