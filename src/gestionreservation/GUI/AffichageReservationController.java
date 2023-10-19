/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import gestionreservation.GUI.ModifResFXMLController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.Node;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class AffichageReservationController implements Initializable {

    @FXML
    private Button suppreservation;
    @FXML
    private ListView<String> Listereservation;
    @FXML
    private Button modifierreservation;
    @FXML
    private Button actualiserres;
    @FXML
    private Button acceuilres;
    @FXML
    private Button returnajout;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceReservation sv = new ServiceReservation();
    List<Reservation> reservations = sv.afficherReservation();

    ObservableList<String> itemsReservation = FXCollections.observableArrayList();

    for (Reservation reservation : reservations) {
        String cin1 = "CIN du client : " + reservation.getCinClient();
        String nomClient = "Nom du client : " + reservation.getNomClient();
        String nombrePersonnes = "Nombre de personnes : " + reservation.getNombrePersonnes();
        String dateDebut = (reservation.getDateDebut() != null) ? "Date de début : " + reservation.getDateDebut().toString() : "Date de fin :";
        String dateFin = (reservation.getDateFin() != null) ? "Date de fin : " + reservation.getDateFin().toString() : "Date de fin :";
        String mode_paiement = "Mode de paiement : " + reservation.getMode_paiement();
        String typeHbergement = "Type d'hébergement : " + reservation.getTypeHebergement();
        String typeactivite = "Type d'activité : " + reservation.getTypeActivite();
        String ref = "Référence : " + reservation.getReference();

        String reservationString = cin1 + "\n" + nomClient + "\n" + nombrePersonnes + "\n" + dateDebut + "\n" + dateFin + "\n" + mode_paiement + "\n" + typeHbergement + "\n" + typeactivite + "\n" + ref;

        itemsReservation.add(reservationString);
    }

    Listereservation.setItems(itemsReservation);
    }    


    

    @FXML
    private void suppreservation(ActionEvent event) {
        ServiceReservation sv = new ServiceReservation();
    int selectedIndex = Listereservation.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        // Obtenez la chaîne sélectionnée de la ListView
        String selectedres = Listereservation.getItems().get(selectedIndex);

        // Trouvez la ligne qui contient le numéro de facture
        String[] lines = selectedres.split("\n");
        String numResLine = null;
        for (String line : lines) {
            if (line.startsWith("Référence :")) {
                numResLine = line;
                break;
            }
        }

        if (numResLine != null) {
            // Extrait le numéro de facture de la ligne
            String numFacture = numResLine.replace("Référence :", "").trim();

            // Convertissez le numéro de facture en int
            int refres = Integer.parseInt(numFacture);

            // Supprimez la facture de la base de données
            sv.supprimerReservation(refres);

            // Supprimez l'élément de la ListView
            Listereservation.getItems().remove(selectedIndex);
        }
    }
    }

    @FXML
    private void modifierreservation(ActionEvent event) {
        String selectedItem = Listereservation.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("modifResFXML.fxml"));
                Parent root = loader.load();
                ModifResFXMLController modifReservationController = loader.getController(); // Obtenez le contrôleur de l'interface de modification
                Stage stage = new Stage();
                stage.setScene(new Scene(root));

                // Obtenez les données de la ligne sélectionnée et remplissez les champs de l'interface de modification
                // Vous devrez analyser la chaîne pour extraire les données

                String[] data = selectedItem.split("\n");

                for (String line : data) {
                    if (line.startsWith("CIN du client :")) {
                        int cinClient = Integer.parseInt(line.replaceAll("\\D", ""));
                        modifReservationController.setCinClient(cinClient);
                    } else if (line.startsWith("Nom du client :")) {
                        String nomClient = line.replace("Nom du client : ", "").trim();
                        modifReservationController.setNomClient(nomClient);
                    } else if (line.startsWith("Nombre de personnes :")) {
                        int nombrePersonnes = Integer.parseInt(line.replace("Nombre de personnes : ", "").trim());
                        modifReservationController.setNombrePersonnes(nombrePersonnes);
                    } else if (line.startsWith("Date de début :")) {
                        String dateDebut = line.replace("Date de début : ", "").trim();
                        modifReservationController.setDateDebut(dateDebut);
                    } else if (line.startsWith("Date de fin :")) {
                        String dateFin = line.replace("Date de fin : ", "").trim();
                        modifReservationController.setDateFin(dateFin);
                    } else if (line.startsWith("Mode de paiement :")) {
                        String modePaiement = line.replace("Mode de paiement : ", "").trim();
                        modifReservationController.setModePaiement(modePaiement);
                    } else if (line.startsWith("Type d'hébergement :")) {
                        String typeHebergement = line.replace("Type d'hébergement : ", "").trim();
                        modifReservationController.setTypeHebergement(typeHebergement);
                    } else if (line.startsWith("Type d'activité :")) {
                        String typeActivite = line.replace("Type d'activité : ", "").trim();
                        modifReservationController.setTypeActivite(typeActivite);
                    } else if (line.startsWith("Référence :")) {
                        int reference = Integer.parseInt(line.replace("Référence : ", "").trim());
                        modifReservationController.setReference(reference);
                    }
                }

                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void actualiserres(ActionEvent event) {
        ServiceReservation sv = new ServiceReservation();
        
    List<Reservation> reservations = sv.afficherReservation();

    ObservableList<String> itemsReservation = FXCollections.observableArrayList();

    for (Reservation reservation : reservations) {
        String cin1 = "CIN du client : " + reservation.getCinClient();
        String nomClient = "Nom du client : " + reservation.getNomClient();
        String nombrePersonnes = "Nombre de personnes : " + reservation.getNombrePersonnes();
        String dateDebut = (reservation.getDateDebut() != null) ? "Date de début : " + reservation.getDateDebut().toString() : "Date de fin :";
        String dateFin = (reservation.getDateFin() != null) ? "Date de fin : " + reservation.getDateFin().toString() : "Date de fin :";
        String mode_paiement = "Mode de paiement : " + reservation.getMode_paiement();
        String typeHbergement = "Type d'hébergement : " + reservation.getTypeHebergement();
        String typeactivite = "Type d'activité : " + reservation.getTypeActivite();
        String ref = "Référence : " + reservation.getReference();

        String reservationString = cin1 + "\n" + nomClient + "\n" + nombrePersonnes + "\n" + dateDebut + "\n" + dateFin + "\n" + mode_paiement + "\n" + typeHbergement + "\n" + typeactivite + "\n" + ref;

        itemsReservation.add(reservationString);
    }

    Listereservation.setItems(itemsReservation);
    }

    @FXML
    private void accueilres(ActionEvent event) {
       try{
            Parent parent2=FXMLLoader .load(getClass().getResource("acceuilres.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AcceuilresController.class.getName()).log(Level.SEVERE, null, ex);
        };

    }

    @FXML
    private void returnajout(ActionEvent event) {
     try{
            Parent parent2=FXMLLoader .load(getClass().getResource("ajouterReservation.FXML.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Ajouter une réservation");
            stage.show();
        }catch (IOException ex){
            Logger.getLogger(AjouterReservationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };

    }}
