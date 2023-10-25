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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class LoginController implements Initializable {

    @FXML
    private TextField pseudoField;
   
    @FXML
    private Button loginButton;
    @FXML
    private Button backbtn;
   
    @FXML
    private CheckBox selectshowPassword;
    @FXML
    private PasswordField mp;
    @FXML
    private AnchorPane mdpField;
    @FXML
    private TextField showpass;
   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    @FXML
 private void handleLogin(ActionEvent event) {
    String pseudo = pseudoField.getText();
    String mdp = mp.getText();
    ServiceUser su = new ServiceUser();

    String userRole = su.getUserRole(pseudo, mdp);

    if (userRole != null && checkPassword(pseudo, mdp)) {
        // Both username and password are correct
        try {
            FXMLLoader loader;
            if ("Admin".equals(userRole)) {
                loader = new FXMLLoader(getClass().getResource("Backoffice.fxml"));
            } else {
                loader = new FXMLLoader(getClass().getResource("UserDasboard.fxml"));
            }

            Parent root = loader.load();

            Stage stage = (Stage) loginButton.getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
          
        }
    } else {
        // Incorrect username or password
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Something is wrong with your credentials");
        alert.setContentText("Please verify your username and password.");
        alert.showAndWait();
    }
}

    @FXML
        public void showPassword()
        {
            if (selectshowPassword.isSelected())
            {
                showpass.setText(mp.getText());
                mp.setVisible(false);
                showpass.setVisible(true);
            }
            else
            {
                showpass.setText(mp.getText());
                mp.setVisible(true);
                showpass.setVisible(false);
            }
        }
 


private boolean checkPassword(String pseudo, String mdp) {
    try {
        // Connect to your database
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/explorex","root","");

        // Query the database to retrieve the stored password for the provided username (pseudo)
        String query = "SELECT mdp FROM user WHERE pseudo = ?";
        PreparedStatement pstmt = connection.prepareStatement(query);
        pstmt.setString(1, pseudo);
        ResultSet rs = pstmt.executeQuery();

       if (rs.next()) {
    String storedPassword = rs.getString("mdp").trim(); // Trim stored password
    String providedPassword = mdp.trim(); // Trim provided password
    return storedPassword.equals(providedPassword);
}


        // No user with the provided username (pseudo) found in the database
        return false;
    } catch (SQLException e) {
       
        return false; // You may want to handle this more gracefully in a real application
    }
}


    

    @FXML
    private void back(ActionEvent event) {
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
    
}
