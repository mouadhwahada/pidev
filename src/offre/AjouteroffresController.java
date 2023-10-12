/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import javafx.scene.control.Button;



import voyages.offres.grud.serviceOffres;
import voyages.offres.offres;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AjouteroffresController implements Initializable {
    @FXML 
    private TextField réference;
@FXML

    private TextField destination;

@FXML

    private TextField prix;
@FXML
    private DatePicker debut;
@FXML
    private DatePicker fin;
@FXML
    private TextField service;


@FXML 
private Button Ajouteroffres;
@FXML 

private void Ajouteroffres(ActionEvent event){
    String ref=réference.getText();
    int réfe=Integer.parseInt(ref);
    String destination1=destination.getText();
    LocalDate localDate11=LocalDate.parse(debut.getValue().toString());
     LocalDate localDate12=LocalDate.parse(fin.getValue().toString());
     String pr=prix.getText();
    int prx=Integer.parseInt(pr);
     String srv = service.getText();
    int sr =Integer.parseInt(srv);
    serviceOffres soo = new serviceOffres();
    soo.ajouter(new offres (destination1,localDate11,localDate12,prx,réfe,sr));
    
}

    
    


 
    /**@FXML 
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
