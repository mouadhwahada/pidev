/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import entitie.Agence;
import entitie.Assurance;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import pidevvoyage.FXMain;
import service.ServiceAgence;
import service.ServiceAssurance;
import service.ServiceCategorie;
import util.QrCodeGenerator;

/**
 * FXML Controller class
 *
 * @author rayen
 */
public class FXMLviewassuranceuserController implements Initializable {

    @FXML
    private ImageView qrcodeimg;
    @FXML
    private Label lcategorie;
    @FXML
    private Label lnomagence;
    @FXML
    private Label ladresseagence;
    @FXML
    private Label ltelagence;
    @FXML
    private Label lemailagence;
    @FXML
    private Label lpasseport;
    @FXML
    private Label ldestination;
    @FXML
    private Label ldate;
    
    ServiceAssurance sa=new ServiceAssurance();
    ServiceCategorie sc=new ServiceCategorie();
    ServiceAgence saa=new ServiceAgence();
    Assurance a=new Assurance();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        a=sa.getAssuranceById(FXMLafficherassuranceuserController.idAssurance);
        System.out.println("****************");
        System.out.println(a);
        System.out.println(a.getIdAgence());
        lcategorie.setText(sc.getNameById(a.getIdCategorie()));
        lpasseport.setText(a.getPasseport()+"");
        ldestination.setText(a.getDestination());
        ldate.setText(a.getDate()+"");
        Agence aa =saa.getAgenceById(a.getIdAgence());
        System.out.println(aa);
        ladresseagence.setText(aa.getAdresse());
        lemailagence.setText(aa.getEmail());
        ltelagence.setText(aa.getTelephone()+"");
        lnomagence.setText(aa.getNomAgence());
        QrCodeGenerator.GenerateQrCode(a.toString(),a.getId());
        File file=new File("C:\\Users\\rayen\\Desktop\\PiDevVoyage\\src\\qrcode\\Assurance"+a.getId()+".png");
        Image img=new Image(file.toURI().toString());
        qrcodeimg.setImage(img);
    }    

    @FXML
    private void retour(ActionEvent event) {
        try {
            Stage stageclose= (Stage)((Node)event.getSource()).getScene().getWindow();
            stageclose.close();
            Parent root=FXMLLoader.load(getClass().getResource("/GUI/FXMLafficherassuranceuser.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage=new Stage();
            primaryStage.setTitle("PIDEV Voyage");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(FXMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
