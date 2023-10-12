/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.services;

import gestion_reservation.entities.Facture;
import gestion_reservation.services.tools.Datasource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class ServiceFacture implements interface_facture {
  Connection cnx = Datasource.getInstance().getConnection();
    @Override
    public void ajouterFacture(Facture f) {
         try {
            String req = "INSERT INTO `facture`(`id_facture`, `montant_facture`, `date_paiement`, `mode_paiement`, `ref_facture`, `idres`) VALUES  ('" + f.getIdfacture() + "','" + f.getMontant() +"','" + f.getDatePaiement() + "','" + f.getModePaiement()+ "','" + f.getRef_facture()+"','" +f.getIdReservation() + "')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
            System.out.println("succes d'ajout");
            
        } catch (SQLException ex) {
            System.out.println("echec d'ajout");
        }
    }

    @Override
    public void modifierFacture(Facture f) {
        String req = "UPDATE `facture` SET `montant_facture`=?,`date_paiement`=?,`mode_paiement`=? , `ref_facture`=?, `idres`=? WHERE `id_facture`=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
       
       
        ps.setDouble(1, f.getMontant());
        ps.setString(2, f.getDatePaiement());
        
        ps.setString(3, f.getModePaiement());
       ps.setInt(4, f.getRef_facture());
      ps.setInt(5, f.getIdReservation());
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
       
        ps.setInt(6, f.getIdfacture());
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
    
  public void supprimerFacture(int idFacture){
    try{
            String query ="DELETE FROM `facture` WHERE `id_facture`=?";
           PreparedStatement  pst=cnx.prepareStatement(query);
           pst.setInt(1, idFacture);
           
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
  public List<Facture> afficherFacture() {
      String req = "SELECT * FROM `facture`";
      ArrayList<Facture> factures= new ArrayList();
    
    try {
        Statement stm;
        stm = this.cnx.createStatement();
    
    
        ResultSet rs1=  stm.executeQuery(req);
       while (rs1.next()){
        Facture f = new Facture();
        
         f.setIdfacture(rs1.getInt("id_facture"));
         
         
        
       
                f.setMontant(rs1.getDouble("montant_facture"));
                f.setDatePaiement(rs1.getString("date_paiement"));
               
                f.setModePaiement(rs1.getString("mode_paiement"));
                f.setRef_facture(rs1.getInt("ref_facture"));
                
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitezs mettre à jour
       
       
        factures.add(f);
        System.out.println(f);
    }
       } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return factures;
    }
}