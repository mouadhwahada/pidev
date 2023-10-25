/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import com.barcodelib.barcode.Linear;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 * FXML Controller class
 *
 * @author Maryem
 */
public class BarCodeController implements Initializable {

    @FXML
    private TextField br_data;
    @FXML
    private TextField br_path;
    @FXML
    private Label barcode_read;
    @FXML
    private Button writebtn;
    @FXML
    private Button readbtn;
    @FXML
    private Button backbtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void writeCode(ActionEvent event) {
    
    try {
            
            Linear barcode = new Linear();
            barcode.setType(Linear.CODE128B);
            barcode.setData(br_data.getText());
            barcode.setI(11.0f);
          
          String fname = br_data.getText();
          
            barcode.renderBarcode("D:\\" + fname +".png" );
            
            
            
            
            
        } catch (Exception e) {
           
        }

    }
    

    @FXML
    private void readCode(ActionEvent event) {
        // read bar code
        
        try {
             InputStream barInputStream = new FileInputStream(br_path.getText());
             BufferedImage barBufferedImage = ImageIO.read(barInputStream);
             LuminanceSource source = new BufferedImageLuminanceSource(barBufferedImage);
             BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
             Reader reader = new MultiFormatReader();
             Result result = reader.decode(bitmap);
             barcode_read.setText(result.getText());
            
            
            
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @FXML
    private void back(ActionEvent event) {
        try {
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficherCP.fxml"));
            Parent root = loader.load();

          
            Stage modifierStage = new Stage();
            modifierStage.setScene(new Scene(root));
            modifierStage.setTitle("Cupon Codes List");

          
            modifierStage.show();

            
            Stage currentStage = (Stage) backbtn.getScene().getWindow();
            currentStage.close();
        } catch (IOException e) {
        }
    }
    
}
