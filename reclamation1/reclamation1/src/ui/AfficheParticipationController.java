/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class AfficheParticipationController implements Initializable {

    @FXML
    private VBox VBoxShowReservations;
    @FXML
    private ListView<?> lvReservation;
    @FXML
    private TextField filterField;
    @FXML
    private ComboBox<?> txtTri;
    @FXML
    private Button btnExcel;
    @FXML
    private Button btnPDF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void search_service(MouseEvent event) {
    }

    @FXML
    private void excelfile(ActionEvent event) {
    }

    @FXML
    private void PDFGeneration(ActionEvent event) {
    }
    
}
