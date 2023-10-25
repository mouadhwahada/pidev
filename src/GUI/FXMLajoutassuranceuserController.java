/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entitie.Assurance;
import java.io.IOException;
import java.net.URL;
import java.time.ZoneId;
import java.sql.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidevvoyage.FXMain;
import service.ServiceAgence;
import service.ServiceAssurance;
import service.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class FXMLajoutassuranceuserController implements Initializable {

    @FXML
    private ComboBox<String> cbcategorie;
    @FXML
    private ComboBox<String> cbagence;
    @FXML
    private TextField tfpassport;
    @FXML
    private TextField tfdestination;
    @FXML
    private DatePicker date;
    ServiceAgence sa=new ServiceAgence();
    ServiceCategorie sc=new ServiceCategorie();
    ServiceAssurance saa=new ServiceAssurance();
    ObservableList<String> dataagence=FXCollections.observableArrayList();
    ObservableList<String> datacategorie=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dataagence.addAll(sa.getAllAgenceName());
        cbagence.setItems(dataagence);
        datacategorie.addAll(sc.getAllCategorieName());
        cbcategorie.setItems(datacategorie);
    }    

    @FXML
    private void ajouterAssurance(ActionEvent event) {
        Assurance a=new Assurance();
        

        a.setDate(Date.valueOf(date.getValue()));
        a.setIdAgence(sa.getIdByName(cbagence.getSelectionModel().getSelectedItem()));
        a.setIdCategorie(sc.getIdByName(cbcategorie.getSelectionModel().getSelectedItem()));
        a.setPasseport(Integer.valueOf(tfpassport.getText()));
        a.setDestination(tfdestination.getText());
        a.setIdUser(1);
        saa.ajouter(a);
    }

    @FXML
    private void voireMesAssurance(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLafficherassuranceuser.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("PIDEV Voyage");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
