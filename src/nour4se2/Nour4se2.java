/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nour4se2;

import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import voyages.offres.JBDC.dataSource;
import voyages.offres.grud.serviceOffres;
import voyages.offres.grud.serviceService;
import voyages.offres.offres;
import voyages.offres.service;

/**
 *
 * @author ASUS
 */
public class Nour4se2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        dataSource.getInstance();

        // TODO code application logic here
   
        
       
       //teste pour ajouter 
       /*
       
        LocalDate début = LocalDate.of(2024, 6, 1); // Exemple de date de début
               LocalDate fin = LocalDate.of(2024, 6, 14);   // Exemple de date de fin
       
            offres u = new offres("Tunis",début,fin,250.0,6,7);
       
        
         offres offre = new offres();
         
           
           serviceOffres so = new serviceOffres();
  
      so. ajouter(u);

**/
       //TESTE MODIFER 
       /*
         serviceOffres so = new serviceOffres();
      
 offres res2 = new offres(9,"France ", LocalDate.of(2023, 10,3 ),LocalDate.of(2023, 10, 5), 1578.0,5,2);
          
          so.modifierOffres(res2);
          
       //teste delete
       */
       /*
         
            int id_offres= 9;
             serviceOffres so = new serviceOffres();
            so.supprimer(id_offres);
            */
            //service teste ajouter
            /*
               service s1 = new service("Couple","pour 5 jours de plus",1000);
       
        
         service services  = new service();
         
           
           serviceService se1 = new serviceService();
  
    se1.ajouterService(s1);
            */
    /*
    serviceService so3 = new serviceService();
      
 service res1 = new service(1,"kids ", "kids",1578.0);
          
          so3. modifier(res1 );
    
    */
    
    
    
    //teste fecht
    /*
            serviceOffres so1 = new serviceOffres();
            so1.fetchoffres();
     //teste service fetch 
             serviceService so2 = new serviceService();
            so2.fetchservice();
            
           */
    //delete service 
    /*
    int id_service= 1;
            serviceService so3 = new serviceService();
            so3. supprimerService(id_service);
   */
}


  
}
 
    


