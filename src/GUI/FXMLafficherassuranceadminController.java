/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entitie.Agence;
import entitie.Assurance;
import entitie.Categorie;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
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
public class FXMLafficherassuranceadminController implements Initializable {

    @FXML
    private ListView<Assurance> listassurance;
    ServiceAssurance sa=new ServiceAssurance();
    ObservableList<Assurance> data=FXCollections.observableArrayList();
    ServiceCategorie sc=new ServiceCategorie();
    ServiceAgence saa=new ServiceAgence();
    @FXML
    private TextField tfrecherche;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        data.addAll(sa.afficher());
        listassurance.setItems(data);
        recherche_avance();
    }    

    @FXML
    private void triassurance(ActionEvent event) {
        data.clear();
        data.addAll(sa.triParDestination());
        listassurance.setItems(data);
    }

    @FXML
    private void gotoGestionAgence(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLgestionagence.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("PIDEV Voyage");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotoGestionAssurance(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLafficherassuranceadmin.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("PIDEV Voyage");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void gotoGestionCategorie(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLgestioncategorie.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("PIDEV Voyage");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void recherche_avance(){
        data.clear();
        data.addAll(sa.afficher());
        FilteredList<Assurance> filtreddata=new FilteredList<>(data,a->true);
        
        tfrecherche.textProperty().addListener((observable,oldValue,newValue)->{
            filtreddata.setPredicate(a->{
                if(newValue==null || newValue.isEmpty()){
                    return true;
                }
                if(a.getDestination().indexOf(newValue)!=-1){
                    return true;
                }
                else if((sc.getNameById(a.getIdCategorie())).indexOf(newValue)!=-1){
                    return true;
                }
                else if((saa.getNameById(a.getIdAgence())).indexOf(newValue)!=-1){
                    return true;
                }
                else if((String.valueOf(a.getDate())).indexOf(newValue)!=-1){
                    return true;
                }
                else if((String.valueOf(a.getPasseport())).indexOf(newValue)!=-1){
                    return true;
                }
                else{
                    return false;
                }
            });
            listassurance.setItems(filtreddata);
        });
    }
    
}
