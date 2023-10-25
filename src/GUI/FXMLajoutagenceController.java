/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entitie.Agence;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pidevvoyage.FXMain;
import service.ServiceAgence;

/**
 * FXML Controller class
 *
 * @author Skymil
 */
public class FXMLajoutagenceController implements Initializable {

    @FXML
    private TextField tfnomagence;
    @FXML
    private TextField tfadresse;
    @FXML
    private TextField tfemail;
    @FXML
    private TextField tftelephone;
    @FXML
    private TextField tfid;
    ServiceAgence sa=new ServiceAgence();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void ajouterAgence(ActionEvent event) {
        if(controleDeSaisie().length()>0){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setTitle("invalide");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Agence a=new Agence();
            a.setAdresse(tfadresse.getText());
            a.setEmail(tfemail.getText());
            a.setNomAgence(tfnomagence.getText());
            a.setTelephone(Integer.valueOf(tftelephone.getText()));
            sa.ajouter(a);
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
    }

    @FXML
    private void modifierAgence(ActionEvent event) {
        if(controleDeSaisie().length()>0 || tfid.getText().trim().isEmpty() || !tfid.getText().matches("\\d+")  ){
            Alert alert =new Alert(Alert.AlertType.WARNING);
            alert.setTitle("invalide");
            alert.setContentText(controleDeSaisie());
            alert.showAndWait();
        }
        else{
            Agence a=new Agence();
            a.setAdresse(tfadresse.getText());
            a.setEmail(tfemail.getText());
            a.setNomAgence(tfnomagence.getText());
            a.setTelephone(Integer.valueOf(tftelephone.getText()));
            sa.modifier(a, Integer.valueOf(tfid.getText()));
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
    }
    public String controleDeSaisie(){
        Pattern pattern=Pattern.compile("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",Pattern.CASE_INSENSITIVE);
        Matcher matcher=pattern.matcher(tfemail.getText());
        Pattern phonePattern=Pattern.compile("^\\d{8}$");
        Matcher phoneMatcher=phonePattern.matcher(tftelephone.getText());
        String erreur="";
        
        if(tfnomagence.getText().trim().isEmpty()){
            erreur+="-nom agence vide\n";
        }
        if(tfemail.getText().trim().isEmpty()){
            erreur+="-Email vide\n";
        }
        if(tftelephone.getText().trim().isEmpty()){
            erreur+="-Telephone vide\n";
        }
        if(tfadresse.getText().trim().isEmpty()){
            erreur+="-Adresse vide\n";
        }
        if(!matcher.find()){
            erreur+="-Email invalide\n";
        }
        if(phoneMatcher.matches()==false){
            erreur+="-Telephone invalide\n";
        }
        return erreur;
    }
    
}
