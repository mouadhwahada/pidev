/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

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
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
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
    private Button btnafficher;
    @FXML
    private TableColumn<User, String> nom;
    @FXML
    private TableColumn<User, String> prenom;
    @FXML
    private TableColumn<User, String> cin;
    @FXML
    private TableColumn<User, String> email;
    @FXML
    private TableColumn<User, String> pseudo;
    @FXML
    private TableColumn<User, String> mdp;
    @FXML
    private TableView<User> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
   
    
    @FXML
    private void Ajouter(ActionEvent event) {
        ServiceUser su = new ServiceUser();
        su.ajouter(new User(tfcin.getText(),tfnom.getText(), tfprenom.getText(),tfemail.getText(),tfpseudo.getText(),pf.getText()));
        
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
    
   
}
