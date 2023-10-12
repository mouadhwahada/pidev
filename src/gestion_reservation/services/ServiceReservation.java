/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.services;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.tools.Datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class ServiceReservation implements interface_reservation {
    //var

 Connection cnx = Datasource.getInstance().getConnection();
 

    @Override
    public void ajouterReservation(Reservation res) {
        try {
            String req = "INSERT INTO `reservations`(`dateDebut`, `dateFin`, `CinClient`, `nomClient`, `nombrePersonnes`, `typeHebergement`, `typeActivité`) VALUES ('" + res.getDateDebut() + "','" + res.getDateFin() +"','" + res.getCinClient() + "','" + res.getNomClient()+ "','"+ res.getNombrePersonnes() + "','" + res.getTypeHebergement() +"','" + res.getTypeActivite()+"')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("succes d'ajout");
            
        } catch (SQLException ex) {
            System.out.println("echec d'ajout");
        }
    }
    
     public void modifierReservation(Reservation r) {
         String req = "UPDATE `reservations` SET `dateDebut`=?,`dateFin`=?,`CinClient`=?,`nomClient`=?,`nombrePersonnes`=?,`typeHebergement`=?,`typeActivité`=? WHERE `idReservation`=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
       
        
        ps.setDate(1, java.sql.Date.valueOf(r.getDateDebut())); // Convertir LocalDate en java.sql.Date
        ps.setDate(2, java.sql.Date.valueOf(r.getDateFin()));
        ps.setInt(3, r.getCinClient());
        ps.setString(4, r.getNomClient());
         ps.setInt(5, r.getNombrePersonnes());
        ps.setString(6, r.getTypeHebergement());
        ps.setString(7, r.getTypeActivite());
      
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
       
        ps.setInt(8, r.getIdReservation());
        int res = ps.executeUpdate();

        if (res== 0) {
         System.out.println("modification echouée");
           
        } else {
        System.out.println("modification avec succès");
           
        }
    } catch (SQLException ex) {
       System.out.println("echec!");
    }
   
   
     }

    @Override
    public void supprimerReservation(int idreservation) {
       try{
            String query ="DELETE FROM `reservations` WHERE `idReservation`=?";
           PreparedStatement  pst=cnx.prepareStatement(query);
           pst.setInt(1, idreservation);
           
           int r = pst.executeUpdate();

        if (r== 0) {
         System.out.println("suppression echouée");
           
        } else {
        System.out.println("suppression avec succès");
           
        }
    } catch (SQLException ex) {
       System.out.println("echec!");
    }
    }
    public List<Reservation> afficherReservation() {
      String req = "SELECT * FROM `reservations`";
      ArrayList<Reservation> reservations = new ArrayList();
    
    try {
        Statement stm;
        stm = this.cnx.createStatement();
    
    
        ResultSet rs1=  stm.executeQuery(req);
       while (rs1.next()){
        Reservation r = new Reservation();
        
         r.setIdReservation(rs1.getInt("idReservation"));//(rs.getInt("id"));
         
         // Convertir java.sql.Date en LocalDate
        java.sql.Date dateDebutSQL = rs1.getDate("dateDebut");
        LocalDate dateDebut = dateDebutSQL.toLocalDate();
        r.setDateDebut(dateDebut);

        // Convertir java.sql.Date en LocalDate pour la date de fin
        java.sql.Date dateFinSQL = rs1.getDate("dateFin");
        LocalDate dateFin = dateFinSQL.toLocalDate();
        r.setDateFin(dateFin);
                r.setCinClient(rs1.getInt("CinClient"));
                r.setNomClient(rs1.getString("nomClient"));
                r.setNombrePersonnes(rs1.getInt("nombrePersonnes"));
                r.setTypeHebergement(rs1.getString("typeHebergement"));
                r.setTypeActivite(rs1.getString("typeActivité"));
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitezs mettre à jour
       
       
        reservations.add(r);
        System.out.println(r);
    }
        
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return reservations;
    }
 
}