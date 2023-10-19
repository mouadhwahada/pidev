/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import esprit.entities.reclamation;
import esprit.services.Servicereclamation;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Date;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.swing.SwingUtilities;
   import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author USER
 */
public class reclamaMain extends Application {
   
    //  private Stage stage;
    //private Parent parent;
   // private Button AjouterAction;
    //private DatePicker datePicker;
    //private TextField N_reservation, Nom;

    
   

      /*  this.stage=primaryStage;
        parent=FXMLLoader.load(getClass().getResource("/GUI/AfficherreclamationFXML.fxml"));
        Scene scene=new Scene(parent);
        stage.setScene(scene);
     
                stage.setTitle("Afficher");
       

        stage.show(); */
 @Override
    public void start(Stage stage) throws Exception {
           
        Parent root = FXMLLoader.load(getClass().getResource("AjouterreclamationFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
  /*   @Override
    public void start(Stage stage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("AjouterreclamationFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }catch(IOException ex){
        System.out.println(ex.getMessage());
    */
        
    /*      @Override
    public void start(Stage stage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("ModifierreclamationFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }catch(IOException ex){
        System.out.println(ex.getMessage());
    }
       */ 
    
     /*      @Override
    public void start(Stage stage) throws Exception {
        try{
        Parent root = FXMLLoader.load(getClass().getResource("SupprimerreclamationFXML.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }catch(IOException ex){
        System.out.println(ex.getMessage());
    }
       */ 
   // }}
    
    
    



//public class AjoutReclamationInterface extends Application {
   
   /* @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ajout de réclamation");

        AjouterAction = new Button("Ajouter");
        datePicker = new DatePicker();
        N_reservation = new TextField();
        Nom = new TextField();

        AjouterAction.setOnAction(event -> {
            // Récupérer les données entrées par l'utilisateur
            String Nom1 = Nom.getText();
            String pr = N_reservation.getText();

            // Utiliser la valeur du DatePicker pour obtenir la date
            java.util.Date date = java.sql.Date.valueOf(datePicker.getValue());

            // Créer un objet de réclamation avec les données
            Servicereclamation sc = new Servicereclamation();

            // Appeler la fonction addReclamation pour ajouter la réclamation
           // sc.addReclamation(new reclamation(date, Integer.parseInt(pr), Nom1));

            // Réinitialiser les champs après ajout
            N_reservation.clear();
            Nom.clear();
        });

        VBox root = new VBox(10);
        root.getChildren().addAll(AjouterAction, datePicker, N_reservation, Nom);

        Scene scene = new Scene(root, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }}*/

          /**
           *
           * @param args
           */

}

    
