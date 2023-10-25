/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres.grud;
import java.sql.Connection;
import java.sql.Date;
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
import voyages.offres.JBDC.dataSource;
import voyages.offres.offres;
import voyages.offres.service;

/**
 *
 * @author ASUS
 */
 public  class serviceOffres implements InterfaceOffres {
    Connection cnx ;
    
    
    public serviceOffres (){
    this.cnx= dataSource.getInstance().getConnection();
}
    @Override
    public void ajouter( offres t) {
        try {
            String req = "INSERT INTO `offres`( `destination`, `début`, `fin`, `prix`,`service`)  VALUES ('" + t.getDestination() + "','" + t.getDébut()  + "','" +  t.getFin()+ "','" + t.getPrix()+"','"+ t.getService().getId_service()+"')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    @Override
    public void modifierOffres(offres t) {
       
          String req="UPDATE `offres` SET `début`=?,`fin`=?,`prix`=? ,`service`=? WHERE `destination`=?";

    try {

        PreparedStatement ps= cnx.prepareStatement(req);
     
     
        ps.setDate(1,t.getDébut()); 
        ps.setDate(2, t.getFin());
         ps.setInt(3, t.getPrix());
       ps.setInt(4, t.getService().getId_service());
         
    

     
            ps.setString(5, t.getDestination());
       int res = ps.executeUpdate();
      

     
        if (res== 0) {
         /*System.out.println("modification echouée");*/
          JOptionPane.showMessageDialog(null,"modification echouée");
           
        } else {
       /* System.out.println("modification avec succès");*/
            JOptionPane.showMessageDialog(null,"modification avec succès");
        }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(null,"Echec");
    }
   
   
     }
 
         

              @Override
           
    public List<offres> fetchoffres() {
        
      /*  String req = "SELECT * FROM `offres`";*/
        
        String req = "SELECT o.*, s.nom_service " +
                 "FROM offres o " +
                 "INNER JOIN service s ON o.service = s.id_service";
      
        List<offres> Offres = new ArrayList<>();
        try {
            
           
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            
            while (rs.next()) {                
                offres t  = new offres();
               
                t.setDestination (rs.getString("destination"));
               t.setDébut(rs.getDate("début"));
                t.setFin(rs.getDate("fin"));

        
        
       
          
                t.setPrix(rs.getInt("prix"));
              service s=new service();
            s.setId_service(rs.getInt("service"));
          s.setNom_service(rs.getString("nom_service"));
         
            t.setService(s);
                Offres.add(t);
          
                 
         
              
           
               
                   System.out.println(t);
            }
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
        return Offres;
        
    
       

        // Print details for each offer in the list
       
    
    }
    
   public List<offres> filterOffres(String destination, int maxPrice) {
    List<offres> filteredOffres = new ArrayList<>();
    serviceOffres soo2 = new serviceOffres();
      List<offres>offres1 = soo2.fetchoffres();
    for (offres offre : offres1) {
        if (offre.getDestination().equalsIgnoreCase(destination) && offre.getPrix() <= maxPrice) {
            filteredOffres.add(offre);
        }
    }
    return filteredOffres;
}
   private boolean isOfferMatching(offres offre, String destination, int maxPrice) {
    boolean isDestinationMatch = offre.getDestination().equalsIgnoreCase(destination);
    boolean isPriceMatch = offre.getPrix() <= maxPrice;
    return isDestinationMatch && isPriceMatch;
}

       public void supprimeroffres(String  destination ) {
          
               try {
   
     String req = "DELETE FROM `offres` WHERE `destination`= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        
       
        ps.setString(1,destination );
        
       
      
        int res=ps.executeUpdate();
        if(res==0){
            JOptionPane.showMessageDialog(null,"Suppression echouée");
        }
        else{
               JOptionPane.showMessageDialog(null,"Suppression avec succés");
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(null,"Echec");
    }
}

   
   
 public void affecterService(offres  t, service  s ) {
        try {
            String req ="UPDATE `offres` SET `service`= ? WHERE id_ = ?";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, t.getId_offres());
            ps.setInt(2, s.getId_service());
            ps.executeUpdate();
            System.out.println("Offre updated successfully!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
          }

    @Override
    public void ajouteroffres2(offres t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id_offres) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setDeatedebut(Date datedebut) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setdatefin(Date datefin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
  

   


  }
 
       
       
       
       
      

        
          
      
   

   
 


      






    