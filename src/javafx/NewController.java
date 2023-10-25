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
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class NewController implements Initializable {

    @FXML
    private TextField tfnom;
    @FXML
    private TextField tfprenom;
    @FXML
    private TextField tfcin;
    @FXML
    private TextField tfemail;
    private TextField tfmdp;
    @FXML
    private Button btnajouter;
    @FXML
    private TextField tfpseudo;
    @FXML
    private PasswordField pf;
    @FXML
    private ComboBox roleComboBox;
    @FXML
    private Label successLabel;
    @FXML
    private Button backbtn;
   

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private void Select(ActionEvent event) {
        String selectedRole = (String) roleComboBox.getValue();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<String> list = FXCollections.observableArrayList("Admin","User");
        roleComboBox.setItems(list);
        
    }
    
   
   @FXML
private void Ajouter(ActionEvent event) {
    ServiceUser su = new ServiceUser();
    String selectedRole = (String) roleComboBox.getValue();

    if (selectedRole == null || tfcin.getText().isEmpty() || tfnom.getText().isEmpty() || tfprenom.getText().isEmpty() || tfemail.getText().isEmpty() || tfpseudo.getText().isEmpty() || pf.getText().isEmpty()) {
        { Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setTitle("Error");
            alert.setHeaderText("");
            alert.setContentText("All the Information is required!");
            alert.showAndWait();}
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
                } else {
                    su.ajouter(new User( selectedRole,cin, tfnom.getText(), tfprenom.getText(), tfemail.getText(), tfpseudo.getText(), pf.getText()));
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

                    alert.setTitle("CONFIRMED");
                    alert.setHeaderText("");
                    alert.setContentText("Sign Up Succeeded!");
                    alert.showAndWait();
                    // Emptying the Text Fields
                    tfcin.setText("");
                    roleComboBox.getSelectionModel().clearSelection();
                    tfnom.setText("");
                    tfprenom.setText("");
                    tfemail.setText("");
                    tfpseudo.setText("");
                    pf.setText("");
                }
            }
        }
    }
}

private boolean isValidEmail(String email) {
    // Define pattern for a simple email format check
    String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
    return email.matches(regex);
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

    
    
   
}
