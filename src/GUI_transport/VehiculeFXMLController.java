/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI_transport;

import entities_transport.Vehicule;
import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.ConditionalFeature.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import service_transport.Service_vehicule;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class VehiculeFXMLController implements Initializable {

    @FXML
    private TextField TxtMatV;
    @FXML
    private ComboBox cmbTypeV;
    @FXML
    private ComboBox cmbMrqV;
    @FXML
    private Button btnEngV;
    @FXML
    private void btnEngV(ActionEvent event) {
        String MATv=TxtMatV.getText();
        int matriV=Integer.parseInt(MATv);
        Service_vehicule sv = new Service_vehicule();
        sv.ajouter_vehicule(new Vehicule(cmbTypeV.getSelectionModel().getSelectedItem().toString(),cmbMrqV.getSelectionModel().getSelectedItem().toString(),matriV));
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<String> LisTypev = FXCollections.observableArrayList("Voiture","Sprinter","4x4","Minibus","Camping-car");
        cmbTypeV.setItems(LisTypev);
        ObservableList<String> ListMarquev = FXCollections.observableArrayList("Mercedes","Audi","BM","Peugeot","Hyundai","Volkswagen");
        cmbMrqV.setItems(ListMarquev);
        
    }   
    
}
