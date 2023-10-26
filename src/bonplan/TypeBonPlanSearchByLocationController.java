/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bonplan;

import java.net.URL;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.TypeBonPlan;
import services.ServiceTypeBonPlan;
/**
 * FXML Controller class
 *
 * @author MSADDAK
 */
public class TypeBonPlanSearchByLocationController implements Initializable {

    @FXML
    private TextField txtFieldLocation;
    @FXML
    private Button btnSearchLocation;
    @FXML
    private Button btnReturnToHome;
    services.ServiceTypeBonPlan stbp=new ServiceTypeBonPlan();
    @FXML
    private ListView<TypeBonPlan> resultList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        btnSearchLocation.setOnAction(e->seachLocation());
    }    

    @FXML
    private void seachLocation() {
        String location=txtFieldLocation.getText();
        List<TypeBonPlan> typebonplans=stbp.searchBonPlanByAvgPrice(location);
        ObservableList<TypeBonPlan> items = FXCollections.observableArrayList(typebonplans);
        resultList.setItems(items);
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
