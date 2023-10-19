/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.services.ServiceCP;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AjouterCPController implements Initializable {

    @FXML
    private TextField tfcode;
    @FXML
    private TextField tfdescription;
    private TextField tfused;
    @FXML
    private DatePicker datePicker;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }    

    @FXML
    private void datePicker(ActionEvent event) {
        LocalDate localdate = datePicker.getValue();
    }
    
   @FXML
private void ajoutercp(ActionEvent event) {
    ServiceCP su = new ServiceCP();
    // Get the selected LocalDate from the DatePicker
LocalDate localDate = datePicker.getValue();

// Convert LocalDate to java.util.Date
Date date = java.sql.Date.valueOf(localDate);
    su.ajoutercp(new CodePromo(tfcode.getText(), tfdescription.getText(), date));
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
