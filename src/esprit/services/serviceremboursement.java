/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;


import esprit.entities.reclamation;
import esprit.entities.remboursement;
import esprit.tools.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author USER
 */
public class serviceremboursement {
    
   Connection cnx=DataSource.getInstance().getConnection();
   
        public void addRemboursement(remboursement re) {
     
        try {
            String req = "INSERT INTO `remboursement`( `montant_rembour`, `date_rembour` , `Motif_rembour`) VALUES ('"+re.getMontant_rembour()+"','"+re.getDate_rembour()+"',,'"+re.getMotif_rembour()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("remboursement Added successfully!");
        } catch (SQLException ex) {
           System.out.println("failed!"); 
        }
    }

          public void supprimer_remboursement(int id_rembour) {
       
        String req = "DELETE FROM `remboursement` WHERE `id_rembour`=?";
            try{
               
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setInt(1, id_rembour);
           
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
    
 /*public void modifier_remboursement (remboursement re) {

         String req = "UPDATE `remboursement` SET `montant_rembour`=?,`date_rembour`=? WHERE `id_rembour`=?";
    try {
        PreparedStatement ps = cnx.prepareStatement(req);
        Date daterembour = Date.valueOf(re.getDate_rembour()); //Date.valueOf(re.getDate_rembour())

         ps.setInt(1, re.getMontant_rembour());
         ps.setDate(2, daterembour);

       
       
        // Assurez-vous d'obtenir l'ID de l'événement que vous souhaitez mettre à jour
        ps.setInt(3, re.getId_rembour());
       
        int res = ps.executeUpdate();

        if (res== 0) {
        System.out.println("remboursement avec ID " + re.getId_rembour() + " n'existe pas");
           
        } else {
       System.out.println("remboursemenet avec ID " + re.getId_rembour() + " est modifiée avec succès!");
           
        }
    } catch (SQLException ex) {
        System.out.println("Modification echouée");
    }

 }*/
          
           public void modifier_remboursement(remboursement re,int id_rembour) {
        try {
         String requete="UPDATE remboursement set montant_rembour='"+re.getMontant_rembour()+"',date_rembour='"+re.getDate_rembour()+"',Motif_rembour='"+re.getMotif_rembour()+"' WHERE id="+id_rembour;
      
           Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(serviceremboursement.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
           
     public List<remboursement> afficher(){
        List<remboursement> rembour = new ArrayList<>();
         //1
         String req = "SELECT * FROM remboursement";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                remboursement E = new remboursement();
              
                   E.setId_rembour(rs.getInt("id_rembour"));
                   E.setMontant_rembour(rs.getInt("montant_rembour"));
                   E.setMotif_rembour(rs.getString("Motif_rembour"));
                //   E.setDate(java.sql.Date.valueOf(rs.getDate_rembour()));
        
        
            //  E.setDate_reclama(rs.getDate_reclama("date_reclama"));
                
         //       E.setN_reservation(rs.getInt("N_reservation"));
                
               
                rembour.add(E);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(serviceremboursement.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return rembour;
    }
    
}


 