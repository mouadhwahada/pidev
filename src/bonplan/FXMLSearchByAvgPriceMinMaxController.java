/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import models.BonPlan;
import services.ServiceBonPLan;


/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class FXMLSearchByAvgPriceMinMaxController implements Initializable {

    @FXML
    private TextField minPriceField;
    @FXML
    private TextField maxPriceField;
    @FXML
    private Button searchButton;
    @FXML
    private ListView<BonPlan> resultsListView;
    ServiceBonPLan sbp = new ServiceBonPLan();
    @FXML
    private Button btnReturnToHome;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    searchButton.setOnAction(e -> performSearch());
    }    

    @FXML
    private void performSearch() {
        float minPrice = Float.parseFloat(minPriceField.getText());
        float maxPrice = Float.parseFloat(maxPriceField.getText());
        List<BonPlan> bonPlans = sbp.searchBonPlanByAvgPrice(minPrice, maxPrice);
    ObservableList<BonPlan> items = FXCollections.observableArrayList(bonPlans);

    // Set the items to the ListView to display the results
    resultsListView.setItems(items);
    }

    @FXML
    private void returnToHome(ActionEvent event) {
        try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("HomePageGestionBonPlans.fxml"));
                Parent root = loader.load();

          
                Stage modifierStage = new Stage();
                modifierStage.setScene(new Scene(root));
                modifierStage.setTitle(" Type Bons Plans List");

          
                modifierStage.show();

            
                Stage currentStage = (Stage) btnReturnToHome.getScene().getWindow();
                currentStage.close();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
        
}
    
