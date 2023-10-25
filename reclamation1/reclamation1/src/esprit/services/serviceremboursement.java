/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.services;


//import esprit.entities.reclamation;
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
      private Connection conn;
   Connection cnx=DataSource.getInstance().getConnection();
   ///////////
    public List<String> getAll() {
        List<String> list = new ArrayList<String>();
        try {
            String requetee = "SELECT nom FROM reclamation";
            PreparedStatement pst = cnx.prepareStatement(requetee);
            ResultSet rs = pst.executeQuery();
            System.out.println(rs.toString());

            while (rs.next()) {
                list.add(rs.getString("nom"));
            }

            return list;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }
   ///////////////
   
   public List<reclamation> getAllReclamations() {
        List<reclamation> reclamations = new ArrayList<>();

        try (Connection cnx=DataSource.getInstance().getConnection()) {
            String query = "SELECT id, description FROM reclamation"; // Remplacez par votre requête SQL
            PreparedStatement statement = cnx.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String description = resultSet.getString("description");
                reclamations.add(new reclamation(id, description));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer les erreurs de connexion à la base de données
        }

        return reclamations;
    }
   //////////////////////////
   
     
       public void addRemboursement(remboursement re) throws SQLException {
     
        try {
            String req ;
            req= "INSERT INTO `remboursement`( `montant_rembour`, `date_rembour` , `Motif_rembour`,`id_rec`) VALUES ('"+re.getMontant_rembour()+"','"+re.getDate_rembour()+"','"+re.getMotif_rembour()+"','"+re.getId_rec()+"')";
            
           
           
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
          
            
            //////////////////
            //System.out.println("remboursement Added successfully!");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
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
         String requete="UPDATE remboursement set montant_rembour='"+re.getMontant_rembour()+"',date_rembour='"+re.getDate_rembour()+"',Motif_rembour='"+re.getMotif_rembour()+"' WHERE id_rembour="+id_rembour;
      
           Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(serviceremboursement.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }
           
           public int chercherIdR(String nom) throws SQLException {
        int id = 0;
        String requetee = "SELECT id FROM reclamation where nom='" + nom + "';";
        PreparedStatement pst = cnx.prepareStatement(requetee);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            id = rs.getInt("id");
        }
        return id;
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
                   E.setId_rec(rs.getInt("id_rec"));
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


 