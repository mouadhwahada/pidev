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
import javax.swing.JOptionPane;

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
            String req = "INSERT INTO `reservations`(`CinClient`, `nomClient`, `nombrePersonnes`, `dateDebut`, `dateFin`, `mode_paiement`, `typeHebergement`, `typeActivite`, `numtel`) VALUES ('" +res.getCinClient() + "','" + res.getNomClient()+"','" + res.getNombrePersonnes()+ "','" + res.getDateDebut()+ "','"+ res.getDateFin() + "','" + res.getMode_paiement() +"','" + res.getTypeHebergement()+"','" + res.getTypeActivite()+"','" + res.getNumtelephone()+"')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            JOptionPane.showMessageDialog(null,
    "Votre réservation à été ajoutée avec succès!");
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null,
    "Echec d'ajout!.", "Inane error",
    JOptionPane.ERROR_MESSAGE);
        }
    }
    
     public void modifierReservation(Reservation r) {
         String req = "UPDATE `reservations` SET `nomclient`=?,`nombrePersonnes`=?,`dateDebut`=?,`dateFin`=?,`mode_paiement`=?,`typeHebergement`=?,`typeActivite`=?,`numtel`=? WHERE `CinClient`=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
       
        
       
        
        ps.setString(1, r.getNomClient());
         ps.setInt(2, r.getNombrePersonnes());
          ps.setDate(3, r.getDateDebut()); 
        ps.setDate(4, r.getDateFin());
        ps.setString(5, r.getMode_paiement());
        ps.setString(6, r.getTypeHebergement());
        ps.setString(7, r.getTypeActivite());
        ps.setInt(8, r.getNumtelephone());
      
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
       
        ps.setInt(9, r.getCinClient());
        int res = ps.executeUpdate();

        if (res== 0) {
        JOptionPane.showMessageDialog(null,
    "modification echouée!.", "Inane error",
    JOptionPane.ERROR_MESSAGE);
           
        } else {
         JOptionPane.showMessageDialog(null,
    "Votre réservation à été modifiée avec succès!");
            
           
        }
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null,
    "Echec!.", "Inane error",
    JOptionPane.ERROR_MESSAGE);
    }
   
   
     }

    @Override
    public void supprimerReservation(int CinClient) {
       try{
            String query ="DELETE FROM `reservations` WHERE `CinClient`=?";
           PreparedStatement  pst=cnx.prepareStatement(query);
           pst.setInt(1, CinClient);
           
           int r = pst.executeUpdate();

        if (r== 0) {
          JOptionPane.showMessageDialog(null,
    "Echec!.", "Inane error",
    JOptionPane.ERROR_MESSAGE);
           
        } else {
       JOptionPane.showMessageDialog(null,
    "Votre réservation à été supprimée avec succès!");
           
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
         
          r.setCinClient(rs1.getInt("CinClient"));
                r.setNomClient(rs1.getString("nomClient"));
                r.setNombrePersonnes(rs1.getInt("nombrePersonnes"));

     
        r.setDateDebut(rs1.getDate("dateDebut"));

       
         r.setDateFin(rs1.getDate("dateFin"));
         r.setMode_paiement("mode_paiement");
                               r.setTypeHebergement(rs1.getString("typeHebergement"));
                r.setTypeActivite(rs1.getString("typeActivite"));
       r.setNumtelephone(rs1.getInt("numtel"));
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitezs mettre à jour
       
       
        reservations.add(r);
        System.out.println(r);
    }
        
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return reservations;
    }
 public int recupererIDReservationDepuisBaseDeDonnees() {
    int idReservation = 0; // Initialisez l'ID à 0 (ou à une valeur par défaut)

    // Code JDBC pour se connecter à votre base de données et exécuter une requête
    try {
        // Chargez le pilote JDBC (assurez-vous d'avoir la bibliothèque JDBC correspondante dans votre projet)

        // Établissez une connexion à la base de données (remplacez les détails de connexion par les vôtres)
        Connection cnx = Datasource.getInstance().getConnection();

        // Créez une déclaration SQL
        Statement statement = cnx.createStatement();

        // Exécutez une requête SQL pour récupérer un ID existant (remplacez la requête par la vôtre)
        String sqlQuery = "SELECT idReservation FROM `reservations` LIMIT 1"; // Exemple : récupère le premier ID de la table "reservations"
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        // Vérifiez s'il y a un résultat
        if (resultSet.next()) {
            idReservation = resultSet.getInt("idReservation");
        }

        // Fermez les ressources JDBC
     
    } catch (Exception e) {
        e.printStackTrace();
    }

    return idReservation;
}

}