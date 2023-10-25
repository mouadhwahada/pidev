/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class StatController implements Initializable {

    /**
     * Initializes the controller class.
     * 
     * 
     */

       

   
    @FXML
    private PieChart voy_stat;
     ObservableList<PieChart.Data>data=FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         stat();
// TODO
    }    
   
    public Connection getConnection() {
        Connection conn;
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/gsetion_offres","root","");
            return conn;
            //System.out.println("Connexion établie");
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
            return null;
        }
    }
   
     private void stat() {
          try{
         
           Connection conn = getConnection();
           String query ="select COUNT(*),`destination` from offres GROUP BY `destination`;";
Statement st;
        ResultSet rs;
           //PreparedStatement PreparedStatement = cnx.prepareStatement(query);
            // rs = PreparedStatement.executeQuery();
             st = conn.createStatement();
            rs = st.executeQuery(query);
             while (rs.next()){              
               data.add(new PieChart.Data(rs.getString("destination"),rs.getInt("COUNT(*)")));
            }  
             
        } catch (SQLException ex) {
              System.out.println(ex.getMessage());
        }        
         voy_stat.setTitle("**Statistiques Des destinations courant **");
        voy_stat.setLegendSide(Side.LEFT);
        voy_stat.setData(data);
    }
     
     @FXML
    private void retour(ActionEvent event) throws IOException {
       
       
        Parent root = FXMLLoader.load(getClass().getResource("affoffres.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
