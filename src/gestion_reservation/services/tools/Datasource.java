/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.services.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Datasource {
     private Connection cnx;
    private static Datasource instance;
    
    private String url = "jdbc:mysql://localhost:3306/gestion_reservations";
    private String user = "root";
    private String password = "";
    
    private Datasource(){
        try {
            cnx = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to DB !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static Datasource getInstance(){
        if(instance == null){
            instance = new Datasource();
        }
        return instance;
    }
    
    public Connection getConnection(){
        return this.cnx;
}
}