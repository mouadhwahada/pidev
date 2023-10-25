/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import static java.util.Collections.list;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class AfficherUserController implements Initializable {

    @FXML
    private ListView<User> list;
    @FXML
    private Button modifierButton;
    @FXML
    private Button SupprimerButton;
    
     private User selectedUser;
     
     
    @FXML
    private Button addbtn;
    @FXML
    private Button backbtn;
    @FXML
    private Button excel;
            

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         Afficher(null);
         list.setCellFactory(param -> new ListCell<User>() {
    @Override
    protected void updateItem(User item, boolean empty) {
        super.updateItem(item, empty);

        if (empty || item == null) {
            setText(null);
        } else {
           setText("Name: " + item.getNom() + " " + item.getPrenom() + "\n" +
                    "Email: " + item.getEmail() + "\n" +
                    "CIN: " + item.getCin() + "\n" +
                    "Username: " + item.getPseudo() + "\n" +
                    "Password: " + item.getMdp());
        }
    }
});

        list.setOnMouseClicked(event -> {
            selectedUser = list.getSelectionModel().getSelectedItem();
        });
    }    

    @FXML
    private void Afficher(ActionEvent event) {
        ServiceUser su = new ServiceUser();
              ObservableList<User> items = FXCollections.observableArrayList();
         
        items.addAll(su.getAll(new User()));
        list.setItems(items);
        
        
        
    }

    @FXML
    private void switchToModifierScene(ActionEvent event) {
         try {
         
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierUser.fxml"));
            Parent root = loader.load();

            
           
                ModifierUserController modifierController = loader.getController();

              
                modifierController.initData(selectedUser);
            
            
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Modifier User");

            modifierStage.show();

            Stage currentStage = (Stage) modifierButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        
    }

   
   

    @FXML
    private void switchToSupprimerScene(ActionEvent event) {
         try {
           
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SupprimerUser.fxml"));
            Parent root = loader.load();


                SupprimerUserController supprimerController = loader.getController();

              
                supprimerController.initData(selectedUser);
                
                
         
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Supprimer User");

            
            modifierStage.show();

       
            Stage currentStage = (Stage) SupprimerButton.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
        
    }

    @FXML
    private void Ajouter(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("NewUser.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Ajouter User");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) addbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Backoffice.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Espace Administration");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void btnexcel(ActionEvent event) {
          FileChooser fileChooser = new FileChooser();
        
         // Set extension filter for Excel files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Excel files (.xlsx)", ".xlsx");
        fileChooser.getExtensionFilters().add(extFilter);
        // Show save file dialog
        File file = fileChooser.showSaveDialog(excel.getScene().getWindow());
         if (file != null) {
            try {
                // Create new Excel workbook and sheet
                Workbook workbook = new XSSFWorkbook();

                Sheet sheet = workbook.createSheet("User");

                // Create header row
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("ID");
                headerRow.createCell(1).setCellValue("Nom");
                headerRow.createCell(2).setCellValue("Prenom");     
                headerRow.createCell(3).setCellValue("CIN");
                headerRow.createCell(4).setCellValue("Email"); 
                // Add data rows
                ServiceUser users = new ServiceUser();
                User userInstance = new User() ;
                List<User> User = users.getAll(userInstance);
                for (int i = 0; i < User.size(); i++) {
                  Row row = sheet.createRow(i + 1);
                   row.createCell(0).setCellValue(User.get(i).getId());
                   row.createCell(1).setCellValue(User.get(i).getNom());
                   row.createCell(2).setCellValue(User.get(i).getPrenom());
                   row.createCell(3).setCellValue(User.get(i).getCin());
                   row.createCell(4).setCellValue(User.get(i).getEmail());
                }
                   // Write to file
                FileOutputStream fileOut = new FileOutputStream(file);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                // Show success message
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Export Successful");
                alert.setHeaderText(null);
                alert.setContentText("Events exported to Excel file.");
                alert.showAndWait();
                } catch (Exception e) {
                e.printStackTrace();
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Export Failed");
                alert.setHeaderText(null);
                alert.setContentText("An error occurred while exporting events to Excel file.");
                alert.showAndWait();
            }
        }
    }
    
    
    
}
