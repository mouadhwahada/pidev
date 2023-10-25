/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import gestion_reservation.entities.Facture;
import gestion_reservation.services.ServiceFacture;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class FactureaffichageController implements Initializable {

    @FXML
    private Button actualiserfacture;
    @FXML
    private Button suppfacture;
    @FXML
    private ListView<String> listfactures;
    @FXML
    private Button modifierfacture;
    @FXML
    private Button acceuilres;
    @FXML
    private Button returnajout;
    @FXML
    private Button tricrfacture;
    @FXML
    private Button tridecfacture;
    @FXML
    private Button chercherfact;
    @FXML
    private TextField chercherfacture;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ServiceFacture sv = new ServiceFacture();
       List<Facture> factures = sv.afficherFacture();

    // Convertissez les données Facture en chaînes
    List<String> itemsfacture = new ArrayList<>();
    for (Facture facture : factures) {
        String montantStr = "Montant : " + String.valueOf(facture.getMontant());
        String numStr = "Numéro de facture : " + String.valueOf(facture.getNumfacture());
        String referenceStr = "numéro de la réservation associée : " + facture.getReservation().getIdReservation();
        String dateStr = "Date de paiement : " + facture.getDatePaiement();
        
        String factureString = montantStr + "\n" + numStr + "\n" + referenceStr + "\n" + dateStr;
        
        itemsfacture.add(factureString);
    }

    ObservableList<String> observableList = FXCollections.observableArrayList(itemsfacture);
    listfactures.setItems(observableList);
    }    

    @FXML
    private void suppfacture(ActionEvent event) {
        
   ServiceFacture sv = new ServiceFacture();
    int selectedIndex = listfactures.getSelectionModel().getSelectedIndex();
    if (selectedIndex >= 0) {
        // Obtenez la chaîne sélectionnée de la ListView
        String selectedFacture = listfactures.getItems().get(selectedIndex);

        // Trouvez la ligne qui contient le numéro de facture
        String[] lines = selectedFacture.split("\n");
        String numFactureLine = null;
        for (String line : lines) {
            if (line.startsWith("Numéro de facture :")) {
                numFactureLine = line;
                break;
            }
        }

        if (numFactureLine != null) {
            // Extrait le numéro de facture de la ligne
            String numFacture = numFactureLine.replace("Numéro de facture :", "").trim();

            // Convertissez le numéro de facture en int
            int idFacture = Integer.parseInt(numFacture);

            // Supprimez la facture de la base de données
            sv.supprimerFacture(idFacture);

            // Supprimez l'élément de la ListView
            listfactures.getItems().remove(selectedIndex);
        }
    }
    }

    @FXML
    private void modifierfacture(ActionEvent event) {
      /*   ServiceFacture sv = new ServiceFacture();
       List<Facture> factures = sv.afficherFacture();

    // Convertissez les données Facture en chaînes
    List<String> itemsfacture = new ArrayList<>();
    for (Facture facture : factures) {
        String montantStr = "Montant : " + String.valueOf(facture.getMontant());
        String numStr = "Numéro de facture : " + String.valueOf(facture.getNumfacture());
        String referenceStr = "Référence de la réservation associée : " + facture.getReservation().getReference();
        String dateStr = "Date de paiement : " + facture.getDatePaiement();
        
        String factureString = montantStr + "\n" + numStr + "\n" + referenceStr + "\n" + dateStr;
        
        itemsfacture.add(factureString);
    }

    ObservableList<String> observableList = FXCollections.observableArrayList(itemsfacture);
    listfactures.setItems(observableList);*/
      String selectedItem = listfactures.getSelectionModel().getSelectedItem();
       if (selectedItem != null) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("modiffacture.fxml"));
        Parent root = loader.load();
        ModiffactureController modifFactureController = loader.getController(); // Obtenez le contrôleur de l'interface de modification
        Stage stage = new Stage();
        stage.setScene(new Scene(root));

        // Obtenez les données de la ligne sélectionnée et remplissez les champs de l'interface de modification
        // Vous devrez peut-être analyser la chaîne pour extraire les données
        String[] data = selectedItem.split("\n");
        // Exemple : numFactureLine doit être de la forme "Numéro de facture : 123"
       
for (String line : data) {
    if (line.startsWith("Numéro de facture :")) {
        int numFacture = Integer.parseInt(line.replace("Numéro de facture : ", "").trim());
        modifFactureController.setNumFacture(numFacture);
    } else if (line.startsWith("Montant :")) {
        double montant = Double.parseDouble(line.replace("Montant : ", "").trim());
        modifFactureController.setMontant(montant);
    } else if (line.startsWith("numéro de la réservation associée :")) {
        int reference = Integer.parseInt(line.replace("numéro de la réservation associée : ", "").trim());
        modifFactureController.setReference(reference);
    } else if (line.startsWith("Date de paiement :")) {
        String datePaiement = line.replace("Date de paiement : ", "").trim();
        
    }
}

        // Faites de même pour les autres données (montant, référence, date de paiement, etc.)

        stage.show();
         Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    }

    @FXML
    private void actualiserfacture(ActionEvent event) {
     ServiceFacture sv = new ServiceFacture();
       List<Facture> factures = sv.afficherFacture();

    // Convertissez les données Facture en chaînes
    List<String> itemsfacture = new ArrayList<>();
    for (Facture facture : factures) {
        String montantStr = "Montant : " + String.valueOf(facture.getMontant());
        String numStr = "Numéro de facture : " + String.valueOf(facture.getNumfacture());
        String referenceStr = "Numéro de la réservation associée : " + facture.getReservation().getIdReservation();
        String dateStr = "Date de paiement : " + facture.getDatePaiement();
        
        String factureString = montantStr + "\n" + numStr + "\n" + referenceStr + "\n" + dateStr;
        
        itemsfacture.add(factureString);
    }

    ObservableList<String> observableList = FXCollections.observableArrayList(itemsfacture);
    listfactures.setItems(observableList);   
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
            Parent parent2=FXMLLoader .load(getClass().getResource("AjoutFacture.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Ajout des factures");
            stage.show();
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        }catch (IOException ex){
            Logger.getLogger(AcceuilresController.class.getName()).log(Level.SEVERE, null, ex);
        };
    }

@FXML
private void tricrfacture(ActionEvent event) {
    ObservableList<String> items = listfactures.getItems();
    
    Collections.sort(items, new Comparator<String>() {
        @Override
        public int compare(String facture1, String facture2) {
            // Extrayez le montant de chaque facture
            double montant1 = extractMontant(facture1);
            double montant2 = extractMontant(facture2);
            
            // Comparez les montants
            return Double.compare(montant1, montant2);
        }
    });
}

// Méthode pour extraire le montant de la chaîne factureString
private double extractMontant(String factureString) {
    int start = factureString.indexOf("Montant : ");
    
    if (start != -1) {
        int end = factureString.indexOf('\n', start);
        if (end != -1) {
            // Extrait le montant
            String montantStr = factureString.substring(start + 9, end);
            return Double.parseDouble(montantStr);
        }
    }
    
    return 0.0; // Retourne 0.0 si le montant n'est pas trouvé
}
@FXML
private void tridecfacture(ActionEvent event) {
    ObservableList<String> items = listfactures.getItems();
    
    Collections.sort(items, new Comparator<String>() {
        @Override
        public int compare(String facture1, String facture2) {
            double montant1 = extractMontant(facture1);
            double montant2 = extractMontant(facture2);
            
            // Inversez l'ordre en changeant l'ordre des comparaisons
            return Double.compare(montant2, montant1);
        }
    });
}



 
    

    @FXML
    private void chercherfact(ActionEvent event) {
      String  cherfacture1= chercherfacture.getText().trim(); // Obtenez le CIN entré dans le TextField
    ObservableList<String> resTrouvees1 = FXCollections.observableArrayList();

    for (String facture : listfactures.getItems()) {
        if (facture.contains("Numéro de facture : " + cherfacture1)) {
            resTrouvees1.add(facture);
        }
    }

    // Effacez le contenu précédent de Listereservation
    listfactures.getItems().clear();

    // Ajoutez les réservations trouvées à la ListView
    listfactures.setItems(resTrouvees1);   
    }
}

   


    
      
  

    
    

