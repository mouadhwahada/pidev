/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entitie.Assurance;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
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
public class FXMLafficherassuranceuserController implements Initializable {

    @FXML
    private ListView<Assurance> listassurance;
    ServiceAssurance sa=new ServiceAssurance();
    ServiceCategorie sc=new ServiceCategorie();
    ServiceAgence saa=new ServiceAgence();
    ObservableList<Assurance> data=FXCollections.observableArrayList();
    public static int idAssurance;
    /**
     * Initializes the controller class.
     */
    int idUser=1;
    @FXML
    private TextField tfrecherche;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        data.addAll(sa.afficherParIdUser(idUser));
        listassurance.setItems(data);
        recherche_avance();
    }    

    @FXML
    private void triassurance(ActionEvent event) {
        data.clear();
        data.addAll(sa.afficherParIdUser(idUser).stream()
                .sorted((a1,a2)->a1.getDestination().compareTo(a2.getDestination()))
                .collect(Collectors.toList()));
        
        listassurance.setItems(data);
    }

    @FXML
    private void retour(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLajoutassuranceuser.fxml"));
            
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
    private void gotoviewassurance(ActionEvent event) {
        if(listassurance.getSelectionModel().getSelectedItem()!=null){
            idAssurance=listassurance.getSelectionModel().getSelectedItem().getId();
            
            try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLviewassuranceuser.fxml"));
            
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
        public void recherche_avance(){
        data.clear();
        data.addAll(sa.afficherParIdUser(idUser));
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
