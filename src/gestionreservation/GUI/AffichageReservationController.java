/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;
import gestionreservation.GUI.FactureajoutController;
import gestion_reservation.entities.Facture;
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
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceReservation;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.Node;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ListCell;
import gestion_reservation.services.ServiceReservation;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextField;

import javafx.scene.image.ImageView;
import javafx.util.Callback;
import oracle.jrockit.jfr.parser.ParseException;

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
    @FXML
    private Button creerFacture;
    
private FactureajoutController factureController;
    @FXML
    private Button clires;
    @FXML
    private TextField resplus;
    @FXML
    private Button chercherres;
    @FXML
    private TextField cherres;
    @FXML
    private Button tricrres;
    @FXML
    private Button tridecrres;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Button stataffiche;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /* ServiceReservation sv = new ServiceReservation();
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
        Listereservation.setItems(itemsReservation);*/
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
        String ref = "Numéro de téléphone : " + reservation.getNumtelephone();

        String reservationString = cin1 + "\n" + nomClient + "\n" + nombrePersonnes + "\n" + dateDebut + "\n" + dateFin + "\n" + mode_paiement + "\n" + typeHbergement + "\n" + typeactivite + "\n" + ref;
          itemsReservation.add(reservationString);}
      // Set the custom cell factory
        Listereservation.setCellFactory(param -> new ReservationListCell());

        // Set the items with custom cell rendering
        Listereservation.setItems(itemsReservation);
    }

    @FXML
    private void clires(ActionEvent event) {
        int cinClientMaxReservations = trouverClientAvecPlusReservation();
resplus.setText("CIN : " + cinClientMaxReservations);
afficherStatistiquesReservations();
    }

   @FXML
private void chercherres(ActionEvent event) {
    String cinCherche = cherres.getText().trim(); // Obtenez le CIN entré dans le TextField
    ObservableList<String> resTrouvees = FXCollections.observableArrayList();

    for (String reservation : Listereservation.getItems()) {
        if (reservation.contains("CIN du client : " + cinCherche)) {
            resTrouvees.add(reservation);
        }
    }

    // Effacez le contenu précédent de Listereservation
    Listereservation.getItems().clear();

    // Ajoutez les réservations trouvées à la ListView
    Listereservation.setItems(resTrouvees);
}

   @FXML
private void tricrres(ActionEvent event) {
    ObservableList<String> items = Listereservation.getItems();
    items.sort(Comparator.comparing(this::getDateDebutFromReservation));
}

@FXML
private void tridecrres(ActionEvent event) {
    ObservableList<String> items = Listereservation.getItems();
    items.sort(Comparator.comparing(this::getDateDebutFromReservation, (s1, s2) -> s2.compareToIgnoreCase(s1)));
}

private String getDateDebutFromReservation(String reservationString) {
    int dateDebutStart = reservationString.indexOf("Date de début : ") + 16;
    int dateDebutEnd = reservationString.indexOf('\n', dateDebutStart);
    return reservationString.substring(dateDebutStart, dateDebutEnd);
}

    @FXML
    private void stataffiche(ActionEvent event) {
        
    }
    


      public class ReservationListCell extends ListCell<String> {

    private ImageView imageView = new ImageView();
     // Set the preferred width and height
    private double imageWidth = 250; // Adjust this to your desired width
    private double imageHeight = 200; // Adjust this to your desired height

    public ReservationListCell() {
        // Set the dimensions for the ImageView
        imageView.setFitWidth(imageWidth);
        imageView.setFitHeight(imageHeight);
    }


   @Override
protected void updateItem(String item, boolean empty) {
    super.updateItem(item, empty);

        if (item == null || empty) {
            setText(null);
            setGraphic(null);
        } else {
            setText(item);

            // Load different images based on the type of accommodation
            String imagePath;
            if (item.contains("Type d'hébergement : Hotels")) {
                imagePath = "Hotels.jpg";
            } else if (item.contains("Type d'hébergement : Motels")) {
                imagePath = "motels.jpg";
            } else if (item.contains("Type d'hébergement : Auberges de jeunesse")) {
                imagePath = "aubergesdejeunesse.jpg";
            } else {
                
                imagePath = "hotes.jpg";
            }

            Image icon = new Image(getClass().getResourceAsStream(imagePath));
            imageView.setImage(icon);

            setGraphic(imageView);
        }
    
    }
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
            if (line.startsWith("CIN du client :")) {
                numResLine = line;
                break;
            }
        }

        if (numResLine != null) {
            // Extrait le numéro de facture de la ligne
            String numFacture = numResLine.replace("CIN du client :", "").trim();

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
                    } else if (line.startsWith("Numéro de téléphone :")) {
                        int reference = Integer.parseInt(line.replace("Numéro de téléphone : ", "").trim());
                        modifReservationController.setNumtelephone(reference);
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
        String ref = "Numéro de téléphone : " + reservation.getNumtelephone();

        String reservationString = cin1 + "\n" + nomClient + "\n" + nombrePersonnes + "\n" + dateDebut + "\n" + dateFin + "\n" + mode_paiement + "\n" + typeHbergement + "\n" + typeactivite + "\n" + ref;
          itemsReservation.add(reservationString);}
      // Set the custom cell factory
        Listereservation.setCellFactory(param -> new ReservationListCell());

        // Set the items with custom cell rendering
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
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
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
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        }catch (IOException ex){
            Logger.getLogger(AjouterReservationFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }
  @FXML
private void creerFacture(ActionEvent event) throws IOException {
    String selectedReservation = Listereservation.getSelectionModel().getSelectedItem();
    int idReservation = 0;

    if (selectedReservation != null) {
        // Utilisez une expression régulière pour extraire l'ID de réservation
        ServiceReservation sv12 = new ServiceReservation();

        idReservation = sv12.recupererIDReservationDepuisBaseDeDonnees();

        // Enregistrez l'ID de réservation dans le champ reffacture
        if (factureController != null) {
            factureController.getReffacture().setText(String.valueOf(idReservation));
        } else {
            System.err.println("factureController est nul !");
        }

        // Ensuite, ouvrez la fenêtre Factureajout
        FXMLLoader loader = new FXMLLoader(getClass().getResource("factureajout.fxml"));

        Parent parent2 = loader.load();
        FactureajoutController factureajoutController = loader.getController();
        factureajoutController.setReservationID(idReservation);

        Scene scene = new Scene(parent2);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("AjouterFacture");
        stage.show();
         Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
    }
}
public int trouverClientAvecPlusReservation() {
    Map<Integer, Integer> reservationsParClient = new HashMap<>();

    ServiceReservation sv = new ServiceReservation();
    List<Reservation> reservations = sv.afficherReservation();

    // Comptez le nombre de réservations pour chaque client
    for (Reservation reservation : reservations) {
        int cinClient = reservation.getCinClient();
        reservationsParClient.put(cinClient, reservationsParClient.getOrDefault(cinClient, 0) + 1);
    }

    // Trouvez le client avec le plus de réservations
    int cinClientMaxReservations = -1;
    int maxReservations = -1;

    for (Map.Entry<Integer, Integer> entry : reservationsParClient.entrySet()) {
        if (entry.getValue() > maxReservations) {
            maxReservations = entry.getValue();
            cinClientMaxReservations = entry.getKey();
        }
    }

    return cinClientMaxReservations;
}

public void afficherStatistiquesReservations() {
        Map<Integer, Integer> reservationsParClient = new HashMap<>();

        // Remplacez le code suivant par votre logique de récupération de données de réservation
        ServiceReservation sv = new ServiceReservation();
        List<Reservation> reservations = sv.afficherReservation();

        for (Reservation reservation : reservations) {
            int cinClient = reservation.getCinClient();
            reservationsParClient.put(cinClient, reservationsParClient.getOrDefault(cinClient, 0) + 1);
        }

        // Créez des séries de données pour le graphique
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        for (Map.Entry<Integer, Integer> entry : reservationsParClient.entrySet()) {
            String cinClient = String.valueOf(entry.getKey());
            int nombreReservations = entry.getValue();
            series.getData().add(new XYChart.Data<>(cinClient, nombreReservations));
        }

        // Ajoutez la série de données au graphique
        barChart.getData().clear(); // Effacez les données précédentes
        barChart.getData().add(series);
    }

    // ...
}










