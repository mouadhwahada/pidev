/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service_transport;

import DB_transport.Connexion_transport;
import entities_transport.Location_vehicule;
import entities_transport.Vehicule;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author HP
 */
public class Service_vehicule implements IService_vehicule {
    Connection cnx = Connexion_transport.getInstance().getCnx();

    @Override
    public void ajouter_vehicule(Vehicule v) {
         String req = "INSERT INTO `vehicule`(`type_vehicule`, `marque_vehicule`, `matriculeV`)VALUES (?,?,?)";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setString(1, v.getType_vehicule());
            ps.setString(2, v.getMarque());
            ps.setInt(3, v.getMatriculeV());
            
            ps.executeUpdate();
            System.out.println("Vehicule ajoutée avec succes!");
        } catch (SQLException ex) {
            System.out.println("Ajout echoué!");
        } 
        
    }

    @Override
    public void modifier_vehicule(Vehicule v) {
         String req = "UPDATE `vehicule` SET `type_vehicule`=?,`marque_vehicule`=?,`matriculeV`=? WHERE `id_vehicule`= ?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
       
        ps.setString(1, v.getType_vehicule());
        ps.setString(2, v.getMarque());
        ps.setInt(3, v.getMatriculeV());
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
        ps.setInt(4, v.getId_vehicle());
        
       
        int res = ps.executeUpdate();

        if (res== 0) {
        System.out.println("Véhicule avec ID " + v.getId_vehicle() + " n'existe pas");
           
        } else {
       System.out.println("Véhicule avec ID " + v.getId_vehicle() + " est modifiée avec succès!");
           
        }
    } catch (SQLException ex) {
        System.out.println("Modification echouée");
    }
    }
    public void supprimer_vehicule(int id_v) {
        
        String req = "DELETE FROM `vehicule` WHERE `id_vehicule`=?";
            try{
                
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, id_v);
            
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
     public List<Vehicule> afficher_vehicule(){
        List<Vehicule> vehicules = new ArrayList<>();
         //1
         String req = "SELECT * FROM vehicule";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Vehicule v = new Vehicule();
                v.setId_vehicle(rs.getInt("id_vehicule"));
                v.setType_vehicule(rs.getString("type_vehicule"));
                v.setMarque(rs.getString("marque_vehicule"));
                v.setMatriculeV(rs.getInt("matriculeV"));

                vehicules.add(v);
                System.out.println(v);
                
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Service_location.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return vehicules;
    }

    
}
