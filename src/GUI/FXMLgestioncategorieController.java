/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entitie.Agence;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidevvoyage.FXMain;
import service.ServiceCategorie;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class FXMLgestioncategorieController implements Initializable {

    private TextField tfnomcategorie;
    @FXML
    private ListView<Categorie> listcategorie;
    @FXML
    private TextField recherche;
    ServiceCategorie sc=new ServiceCategorie();
    ObservableList<Categorie> data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        refresh();
    }    

    private void ajouterCategorie(ActionEvent event) {
        if(tfnomcategorie.getText().trim().isEmpty()){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setTitle("invalide");
            alert.setContentText("Nom categorie vide!");
            alert.showAndWait();
        }
        else{
            Categorie c=new Categorie(tfnomcategorie.getText().trim());
            sc.ajouter(c);
            refresh();
        }
        
    }

    @FXML
    private void supprimerCategorie(ActionEvent event) {
        
        sc.supprimer(listcategorie.getSelectionModel().getSelectedItem().getId());
        refresh();
        
        
    }

    private void modifierCategorie(ActionEvent event) {
        if(tfnomcategorie.getText().trim().isEmpty()){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setTitle("invalide");
            alert.setContentText("Nom categorie vide!");
            alert.showAndWait();
        }
        else{
            Categorie c=new Categorie(tfnomcategorie.getText().trim());
            sc.modifier(c, listcategorie.getSelectionModel().getSelectedItem().getId());
            refresh();
        }
    }

    @FXML
    private void triCategorie(ActionEvent event) {
        data.clear();
        data.setAll(sc.triParNom());
        listcategorie.setItems(data);
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
    public void refresh(){
        data.clear();
        data.addAll(sc.afficher());
        listcategorie.setItems(data);
        recherche_avance();
    }

    @FXML
    private void gotoGestionCategorie(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLajoutcategorie.fxml"));
            
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
    private void gotoajouterCategorie(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLajoutcategorie.fxml"));
            
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
    private void gotoModifierCategorie(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLajoutcategorie.fxml"));
            
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
        data.addAll(sc.afficher());
        FilteredList<Categorie> filtreddata=new FilteredList<>(data,a->true);
        
        recherche.textProperty().addListener((observable,oldValue,newValue)->{
            filtreddata.setPredicate(a->{
                if(newValue==null || newValue.isEmpty()){
                    return true;
                }
                if(a.getNomCategorie().indexOf(newValue)!=-1){
                    return true;
                }
                
                else{
                    return false;
                }
            });
            listcategorie.setItems(filtreddata);
        });
    }
    
}
