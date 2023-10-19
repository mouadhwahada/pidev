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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import java.time.LocalDate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author USER
 */
public class Servicereclamation {
       private Connection conn;

      Connection cnx=DataSource.getInstance().getConnection();

      
   /* public void ajouter( reclamation r) {
        try {
            String req = "INSERT INTO reclamation '('type','nom','description',date_reclama) VALUES ('"+r.getType()+"','"+r.getNom()+"','"+r.getDescription()+"','"+r.getDate_reclama()+"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
     */
   
    
      public void addReclamation(reclamation r) {
        try {
            String req;
            req = "INSERT INTO `reclamation`( `type`, `nom`,`description`,`date_reclama`)  VALUES ('"+r.getType()+"','"+r.getNom()+"','"+r.getDescription()+"','"+r.getDate_reclama()+"')";
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
           
        } catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
        }
    }
    
    
   // public List<reclamation> fetchreclama() {
    //    List<reclamation> reclama = new ArrayList<>();
    //  try {
      //      
      //      String req = "SELECT * FROM reclamation";
      //      Statement st = cnx.createStatement();
      //      ResultSet rs = st.executeQuery(req);
      //      while (rs.next()) {                
      //          Reclamation r = new reclama();
      //          r.setId(rs.getInt(1));
       //         r.setDate_reclama(rs.getDate(2));
        //        r.setN_reservation(rs.getInt("number"));
              
                
        //        reclama.add(r);
        //    }
            
       // } catch (SQLException ex) {
       //     ex.printStackTrace();
       // }
        
       // return reclama;
    //}
 

    public void modifier_reclamation(reclamation r,int id) {
        try {
         String requete="UPDATE reclamation set type='"+r.getType()+"',nom='"+r.getNom()+"',description='"+r.getDescription()+"',date_reclama='"+r.getDate_reclama()+"' WHERE id="+id;
      
           Statement st = cnx.createStatement();
            st.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }   
        }

  
 /*   public void delete(int id) {
       String requete1 = "DELETE FROM reclamation WHERE id = " + id;;
              
            try {
            Statement ste=conn.createStatement();
            ste.executeUpdate(requete1);
          
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    */


   public void supprimer_reclamation(int id) {
       
        String req = "DELETE FROM `reclamation` WHERE `id`=?";
            try{
               
            PreparedStatement ps = cnx.prepareStatement(req);
            
            ps.setInt(1, id);
           
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
    //   @Override
    //public List<reclamation> afficherreclamation() {
    //    ArrayList<reclamation> reclamtions = new ArrayList();
        
      //  try {
      //      Statement st = cnx.createStatement();
      //      String req = "SELECT * FROM reclamation";
      //      ResultSet rs = st.executeQuery(req);
            
      //      while (rs.next()) {    
                
    //private String Nom;
     //private LocalDate date_reclama;
     //private int N_reservation;
     //private int id ;
                
    //            reclamation.add(new reclamation(rs.getDate_reclama(1 ),rs.getInt(2), rs.getString("nom"), rs.getInt(4)));
                
    //        }
            
      //  } catch (SQLException ex) {
        //  ex.printStackTrace();
      //  }
        
     // return personnes;
   // }
   //  public List<ReclamationInterface> afficher_Reclamation(){
    //   List<ReclamationInterface> reclamation = new ArrayList<>();
         //1
         //String req = "SELECT * FROM reclamation";
      //  try {
            //2
            //Statement st = cnx.createStatement();
            //3
           // ResultSet rs = st.executeQuery(req);
        //    while (rs.next()) {
              //  reclama r = new reclama();
             //   r.setId(rs.getInt("id"));
            //  r.Date(rs.getDate_reclama("date_reclama"));
              //  r.setN_reservation(rs.getInt("N_reservation"));
              //  r.setString(rs.getNom);
               // System.out.println(r);
               
            //}
          //  :   
        //} catch (SQLException ex) {
        //    System.out.println("Erreur" + ex.getMessage());
      //  }
         
    //     return reclamation ;
  //  }
    public List<reclamation> afficher(){
        List<reclamation> reclamations = new ArrayList<>();
         //1
         String req = "SELECT * FROM reclamation";
        try {
            //2
            Statement st = cnx.createStatement();
            //3
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                reclamation E = new reclamation();
                E.setType(rs.getString("type"));
                E.setNom(rs.getString("Nom"));
                E.setDescription(rs.getString("description"));
              //E.setDate_reclama(rs.getDate("date_reclama"));
                
        //    E.setDate_reclama(rs.getDate("date_reclama"));
                
         //       E.setN_reservation(rs.getInt("N_reservation"));
                
                  E.setId(rs.getInt("id"));
                reclamations.add(E);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Servicereclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return reclamations;
    }
    
    
    
 
    public void affecterReclamation(reclamation r, remboursement re) {
        try {
            String req ="UPDATE `reclamation` SET `remboursement`= ? WHERE id = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, r.getId());
            ps.setInt(2, re.getId_rembour());
            ps.executeUpdate();
            System.out.println("reclamation updated successfully!");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
}
