/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres.JBDC;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS
 */
public class dataSource {
     private Connection cnx;
    private static dataSource instance;
     private String url = "jdbc:mysql://localhost:3306/offres_ges";
    private String user = "root";
    private String password = "";
    
     private dataSource(){
        try {
            cnx = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
      public static dataSource getInstance(){
        if(instance == null){
            instance = new dataSource();
        }
        return instance;
    }
    
       public java.sql.Connection getConnection(){
        return this.cnx;
    }
    
}
