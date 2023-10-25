/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.services;

import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.tools.Datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class ServiceFacture implements interface_facture {

    public static List<Reservation> getReservations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  Connection cnx = Datasource.getInstance().getConnection();
    @Override
    public void ajouterFacture(Facture f) {
         try {
            String req = "INSERT INTO `facture`(`numfacture`,`montant_facture`, `date_paiement`,`numRes`) VALUES  ('" + f.getNumfacture()+"','" + f.getMontant() +"','" + f.getDatePaiement()+ "','"+f.getReservation().getIdReservation() + "')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
           JOptionPane.showMessageDialog(null,
    "Votre facture à été ajoutée avec succès!");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,
    "Echec d'ajout!.", "Inane error",
    JOptionPane.ERROR_MESSAGE);
             ex.printStackTrace();
        }
    }

    @Override
    public void modifierFacture(Facture f) {
    String req = "UPDATE `facture` SET `montant_facture`=?, `date_paiement`=?, `numRes`=? WHERE `numfacture`=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);

        ps.setDouble(1, f.getMontant());
        ps.setString(2, f.getDatePaiement());
        ps.setInt(3, f.getReservation().getIdReservation());
        ps.setInt(4, f.getNumfacture());
        
        int res = ps.executeUpdate();

        if (res == 0) {
            JOptionPane.showMessageDialog(null, "Échec de modification!", "Erreur", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "La facture a été modifiée avec succès!");
        }
    } catch (SQLException ex) {
        ex.printStackTrace(); // Afficher l'erreur complète pour le débogage
    }
}






   
   
    
    
  public void supprimerFacture(int numfacture){
    try{
            String query ="DELETE FROM `facture` WHERE `numfacture`=?";
           PreparedStatement  pst=cnx.prepareStatement(query);
           pst.setInt(1, numfacture);
           
           int r = pst.executeUpdate();

        if (r== 0) {
              JOptionPane.showMessageDialog(null,
    "Echec!.", "Inane error",
    JOptionPane.ERROR_MESSAGE);
        } else {
      
          //JOptionPane.showMessageDialog(null, "La facture a été supprimée avec succès!");  
        }
    } catch (SQLException ex) {
       System.out.println("echec!");
    }

}
  public List<Facture> afficherFacture() {
    /*  String req = "SELECT `numfacture`, `montant_facture`, `date_paiement`,`FROM `facture` ";
      ArrayList<Facture> factures= new ArrayList();
    
    try {
        Statement stm;
        stm = this.cnx.createStatement();
    
    
        ResultSet rs1=  stm.executeQuery(req);
       while (rs1.next()){
        Facture f = new Facture();
        
         f.setIdfacture(rs1.getInt("id_facture"));
         
         f.setNumfacture(rs1.getInt("numfacture"));
        
       
                f.setMontant(rs1.getDouble("montant_facture"));
                f.setDatePaiement(rs1.getString("date_paiement"));
              Reservation r = new Reservation();
            
            // Get the associated reservation's ID
            Reservation r = new Reservation();
          int reservationref = rs1.getInt("reference");

            // Set the reservation ID in the Facture
           
            
            // Set the Reservation object in the Facture
         //   f.setReservation(r);
               
               
                
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitezs mettre à jour
       
       
        factures.add(f);
        System.out.println(f);
    }
       } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return factures;
    }*/
    String req = "SELECT * FROM facture";
    
    ArrayList<Facture> factures = new ArrayList<>();
    
    try {
        Statement stm;
        stm = this.cnx.createStatement();
    
        ResultSet rs1 = stm.executeQuery(req);
        while (rs1.next()) {
            Facture f = new Facture();
            f.setNumfacture(rs1.getInt("numfacture"));
            f.setMontant(rs1.getDouble("montant_facture"));
            f.setDatePaiement(rs1.getString("date_paiement"));
            
            Reservation r = new Reservation();
            r.setIdReservation(rs1.getInt("numRes"));
            
            // Associez la réservation à la facture
            f.setReservation(r);
       
            factures.add(f);
            System.out.println(f);
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    return factures;
}
 /*public List<Facture> afficherFacture() {
    String req = "SELECT f.*, r.idReservation FROM facture f " +
                "LEFT JOIN reservations r ON f.idres = r.idReservation"; // Utilisation d'une jointure LEFT JOIN

    List<Facture> factures = new ArrayList<>();

    try {
        Statement stm = this.cnx.createStatement();
        ResultSet rs1 = stm.executeQuery(req);

        while (rs1.next()) {
            Facture f = new Facture();
           // f.setIdfacture(rs1.getInt("id_facture"));
            f.setMontant(rs1.getDouble("montant_facture"));
            f.setDatePaiement(rs1.getString("date_paiement"));
            f.setModePaiement(rs1.getString("mode_paiement"));
            f.setRef_facture(rs1.getInt("ref_facture"));

            // Initialize the Reservation object
          //  Reservation r = new Reservation();
            
            // Get the associated reservation's ID
//            int reservationId = rs1.getInt("idReservation");

            // Set the reservation ID in the Facture
         //   r.setIdReservation(reservationId);
            
            // Set the Reservation object in the Facture
         //   f.setReservation(r);

            factures.add(f);
           
          //  System.out.println("Facture ID: " + f.getIdfacture());
            System.out.println("Montant: " + f.getMontant());
            System.out.println("Date de Paiement: " + f.getDatePaiement());
            System.out.println("Mode de Paiement: " + f.getModePaiement());
            System.out.println("Référence de Facture: " + f.getRef_facture());
           // System.out.println("Reservation ID: " + reservationId);
            System.out.println(); // Add a line break for separation
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    
    return factures;
}
*/

}