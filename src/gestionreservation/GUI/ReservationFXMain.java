/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pc
 */
public class ReservationFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
     try {
     /*    Parent root = FXMLLoader.load(getClass().getResource("acceuilres.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Acceuil");

            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
           
   /*Parent root = FXMLLoader.load(getClass().getResource("affichageReservation.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Ajout Facture");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
  Parent root = FXMLLoader.load(getClass().getResource("factureaffichage.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Liste des factures");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}
   /*Parent root = FXMLLoader.load(getClass().getResource("modifresFXML.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("modification");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }*/
  /* Parent root = FXMLLoader.load(getClass().getResource("telechagerfacture.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("pdf");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());

    }*/
    /*Parent root = FXMLLoader.load(getClass().getResource("modiffacture.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Mise à jour des factures");
            primaryStage.show();
        
        } catch (IOException ex) {
            System.out.println(ex.getMessage());}
*/
    
      }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
