/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DataSource {
    private Connection cnx;
    private static DataSource data;

    
 
    
    private DataSource(){
        try {
            cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/eplorex","root","");
            System.out.println("Connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
   
    
    
    public Connection getConnection(){
        return this.cnx;
    }
    
     public static DataSource getInstance() {
        if (data == null) {
            data = new DataSource();
        }
        return data;
    }

    
    
}
