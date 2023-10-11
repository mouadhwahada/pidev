/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_transport;

import DB_transport.Connexion_transport;
import entities_transport.Location_vehicule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import entities_transport.Location_vehicule;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Service_location implements IService_location{
    Connection cnx = Connexion_transport.getInstance().getCnx();

    @Override
    public void ajouter_transport(Location_vehicule lv) {
        String req = "INSERT INTO `location_vehicule`(`cin_client_vehicule`, `Duree_loc_vehicule`, `pickup_vehicule`, `return_vehicule`, `id_vehicule`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, lv.getCin_client_vehicule());
            ps.setString(2, lv.getDuree_loc_vehicule());
            ps.setString(3, lv.getPickup_vehicule());
            ps.setString(4, lv.getReturn_vehicule());
            ps.setInt(5, lv.getId_vehicle());

            ps.executeUpdate();
            System.out.println("Location ajoutée avec succes!");
        } catch (SQLException ex) {
            System.out.println("Ajout echoué!");
        } 
    }

    @Override
    public void modifier_transport(Location_vehicule lv) {
         String req = "UPDATE `location_vehicule` SET `cin_client_vehicule`=?,`Duree_loc_vehicule`=?,`pickup_vehicule`=?,`return_vehicule`=?, `id_vehicule`=? WHERE `id_loc_vehicule`=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setInt(1, lv.getCin_client_vehicule());
        ps.setString(2, lv.getDuree_loc_vehicule());
        ps.setString(3, lv.getPickup_vehicule());
        ps.setString(4, lv.getReturn_vehicule());
        ps.setInt(5, lv.getId_vehicle());

       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
        ps.setInt(6, lv.getId_loc_vehicule());
       
        int res = ps.executeUpdate();

        if (res== 0) {
        System.out.println("Location avec ID " + lv.getId_loc_vehicule() + " n'existe pas");
           
        } else {
       System.out.println("Location avec ID " + lv.getId_loc_vehicule() + " est modifiée avec succès!");
           
        }
    } catch (SQLException ex) {
        System.out.println("Modification echouée");
    }

    }
    public void supprimer_transport(int id_location) {
        
        String req = "DELETE FROM `location_vehicule` WHERE `id_loc_vehicule`=?";
            try{
                
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id_location);
            
           int res =ps.executeUpdate();
           if(res==0){
                System.out.println("Suppression echouée");
           }
           else{System.out.println("Supprimé avec succès");
           }        
        }catch(Exception ex){
                System.out.println("Echec");
        }
    }
    
     public List<Location_vehicule> afficher_Location(){
        List<Location_vehicule> locations = new ArrayList<>();
         //1
         String req = "SELECT * FROM location_vehicule";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Location_vehicule lv = new Location_vehicule();
                lv.setId_loc_vehicule(rs.getInt("id_loc_vehicule"));
                lv.setCin_client_vehicule(rs.getInt("cin_client_vehicule"));
                lv.setDuree_loc_vehicule(rs.getString("duree_loc_vehicule"));
                lv.setPickup_vehicule(rs.getString("pickup_vehicule"));
                lv.setReturn_vehicule(rs.getString("return_vehicule"));
                lv.setId_vehicle(rs.getInt("id_vehicule"));

                locations.add(lv);
                System.out.println(lv);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_location.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return locations;
    }
    
    

        
}

   
   
    
   
    
    


    

   



