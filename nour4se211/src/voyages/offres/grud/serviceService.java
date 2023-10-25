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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import voyages.offres.JBDC.dataSource;

import voyages.offres.service;

/**
 *
 * @author ASUS
 */
public class serviceService  implements InterfaceService {
        Connection cnx ;
    
    public serviceService(){
    this.cnx= dataSource.getInstance().getConnection();
    
}
        @Override
     public void ajouterService( service s) {
        try {
            String req = "INSERT INTO `service`( `nom_service`, `description_service`,`prix_service`) VALUES ('" + s. getNom_service() + "','" + s.getDescription_service() + "','" +s.getPrix_service()+ "')";
            
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  
        @Override
         public  List<service> fetchservice() {
       List<service> service = new ArrayList<>();
        try {
            
            String req = "SELECT * FROM service";
            Statement stm = cnx.createStatement();
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {                
                service s  = new service();
                
                
                s.setNom_service(rs.getString("nom_service"));
                s.setDescription_service(rs.getString("description_service"));
             
                s. setPrix_service(rs.getInt("prix_service"));
               
                
                service.add(s);
                System.out.println(s);
            }
            
         
        } catch (SQLException ex) {
             System.out.println(ex.getMessage());
        }
        
        return service;
    }

 

    public void supprimerService(String nom_service) {
       
      
       
               try {
   
        String req = "DELETE FROM `service` WHERE `nom_service`= ?";
        
        PreparedStatement ps = cnx.prepareStatement(req);
        
       
        ps.setString(1,nom_service);
        
       
    
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

 
      
       
   

    public void modifierservice(service s) {
        String req="UPDATE `service` SET `description_service`=?,`prix_service`=? WHERE `nom_service`=?";

    try {
        PreparedStatement ps= cnx.prepareStatement(req);
     
   
        ps.setString(1, s.getDescription_service());
         ps.setInt(2, s.getPrix_service());
         ps.setString(3, s.getNom_service());
       
    
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
    public void ajouterService2(service s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void supprimer(int id_service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modifier(service s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

  

}

    

   

   
    

  

    

   

    
        
