/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Skymil
 */
public class MyConnexion {
    String URL="jdbc:mysql://localhost:3306/pidevvoyage";
    String USER="root";
    String PWD="";
    
    private Connection cnx;
    static MyConnexion conn;
    
    private MyConnexion(){
        try {
            cnx=DriverManager.getConnection(URL, USER, PWD);
            System.out.println("Connexion etablie");
        } catch (SQLException ex) {
            Logger.getLogger(MyConnexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static MyConnexion getInstance(){
        if(conn==null){
            conn=new MyConnexion();
        }
        else{
            System.out.println("deja connecter");
        }
        return conn;
    }

    public Connection getCnx() {
        return cnx;
    }
    
}
