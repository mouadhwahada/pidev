/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres.grud;
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
            String req = "INSERT INTO `offres`( `destination`, `début`, `fin`, `prix`, `réference`,`referenceService`)  VALUES ('" + t.getDestination() + "','" + t.getDébut()  + "','" +  t.getFin()+ "','" + t.getPrix()+"','"+t.getRéference()+ "','" +t.getService().getReference_se()+ "')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
    
    @Override
    public void modifierOffres(offres t) {
       
          String req="UPDATE `offres` SET `destination`=?,`début`=?,`fin`=?,`prix`=?,`referenceService`=? WHERE `réference`=?";

    try {

        PreparedStatement ps= cnx.prepareStatement(req);
     
       ps.setString(1, t.getDestination());
        ps.setDate(2,t.getDébut()); 
        ps.setDate(3, t.getFin());
         ps.setInt(4, t.getPrix());
       
         
    

       ps.setInt(6, t.getRéference());
           ps.setInt(5,t.getService().getReference_se());
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
           
    public List<offres> fetchoffres() {
        List<offres> Offres = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM `offres`";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {                
                offres t  = new offres();
               
                t.setDestination (rs.getString("destination"));
               t.setDébut(rs.getDate("début"));
                t.setFin(rs.getDate("fin"));

        
        
       
          
                t.setPrix(rs.getInt("prix"));
                t.setRéference(rs.getInt("réference"));
              service s=new service();
              
            s.setReference_se(rs.getInt("referenceService"));
            t.setService(s);
                Offres.add(t);
                   System.out.println(t);
            }
            
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
        return Offres;
    }
 
       public void supprimeroffres(int  réference ) {
          
               try {
   
     String req = "DELETE FROM `offres` WHERE `réference`= ?";
        PreparedStatement ps = cnx.prepareStatement(req);
        
       
        ps.setInt(1,réference );
        
       
      
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

    
  

   


  }
 
       
       
       
       
      

        
          
      
   

   
 


      






    