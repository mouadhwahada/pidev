/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
public class SignUpController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tfpseudo;
    @FXML
    private Button signupbtn;
    @FXML
    private Button backbtn;
   
    @FXML
    private PasswordField pf;
    @FXML
    private TextField tfcin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SignUp(ActionEvent event) {
        
        ServiceUser su = new ServiceUser();
        String role = "User";
   

    if (tfcin.getText().isEmpty() || tfnom.getText().isEmpty() || tfprenom.getText().isEmpty() || tfemail.getText().isEmpty() || tfpseudo.getText().isEmpty() || pf.getText().isEmpty()) {
       
        Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("All the Information is required!");
            alert.showAndWait();
    } else {
        String cin = tfcin.getText();
        
        if (!cin.matches("\\d{8}")) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("CIN must be 8 digits.");
            alert.showAndWait();
        } else {
            if (!isValidEmail(tfemail.getText())) {
                  Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error");
                    alert.setHeaderText("");
                    alert.setContentText("Invalid email format.");
                    alert.showAndWait();
            } else {
                if (su.isCinExists(cin)) {
                   
                    Alert alert = new Alert(Alert.AlertType.ERROR);

                    alert.setTitle("Error");
                    alert.setHeaderText("");
                    alert.setContentText("CIN already exists. Please use a different one.");
                    alert.showAndWait();
                } else if (su.isUsernameExists(tfpseudo.getText())) {
            // Handle the case when the username is not unique
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("Username already exists. Please choose a different one.");
            alert.showAndWait();
        }
                else if (pf.getText().length() < 8) {
            // Handle the case when the password is less than 8 characters
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("Password is too weak.");
            alert.showAndWait();
        }
                else if (su.isEmailExists(tfemail.getText())) {
            // Handle the case when the email already exists
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("Email already exists. Please use a different one.");
            alert.showAndWait();
        }
                
                else {
                    su.ajouter(new User(cin, role, tfnom.getText(), tfprenom.getText(), tfemail.getText(), tfpseudo.getText(), pf.getText()));
                    
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                    alert.setTitle("CONFIRMED");
                    alert.setHeaderText("");
                    alert.setContentText("Sign Up Succeeded!");
                    alert.showAndWait();

                     try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Sign in Page");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        } 
                }
            }
        }
    }
        

    
    }

    @FXML
    private void Back(ActionEvent event) {
        
       try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Home Page");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        } 
        
    }
    public Connection getConnection()
    {
    Connection conn ;
  
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/eplorex","root","");
            System.out.println("Connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    
    private boolean isValidEmail(String email) {
    // Define pattern for a simple email format check
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return email.matches(regex);
}    
    
    
}
