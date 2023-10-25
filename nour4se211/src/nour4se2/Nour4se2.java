/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nour4se2;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
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
        
        
        
      

        // TODO code application logic here
   
        
       
       //teste pour ajouter 
       
       /*
          java.sql.Date fin= java.sql.Date.valueOf("2023-11-18");
        java.sql.Date début = java.sql.Date.valueOf("2023-11-10");
       
        service sv = new service (6,"kids","kids",50);
        
       
         offres u = new offres("Italy",début,fin,1547,sv);
         serviceOffres soo = new serviceOffres();
         soo.ajouter(u);
         */
     
        
        
         
           
          


       //TESTE MODIFER 
       
       /*
         serviceOffres so = new serviceOffres();
         java.sql.Date début = java.sql.Date.valueOf("2023-12-15");
         java.sql.Date fin = java.sql.Date.valueOf("2024-02-25");  
         service sv = new service (1,"kids ","kids",50);
         offres res2 = new offres(1,"France",début,fin,2500,sv);
         so.modifierOffres(res2);
 */
 // Remplacez cette ligne par la nouvelle date de début souhaitée
        
          
        
       //teste delete
       
      /*
         
            int id_offres= 1;
             serviceOffres so = new serviceOffres();
            so.supprimeroffres(id_offres);
           */
            //service teste ajouter
            /*
               service s1 = new service("couple","plus 10 jour free",20);
       
        
         service services  = new service();
         
           
           serviceService se1 = new serviceService();
  
    se1.ajouterService(s1);
       */
        
    
    serviceService so3 = new serviceService();
      
 service res1 = new service(11,"family","family",60);
          
          so3.modifierservice(res1);
    
   
    
    
    
    //teste fecht
    
    /*
            serviceOffres so1 = new serviceOffres();
            so1.fetchoffres();*/
    
     //teste service fetch 
     /*
             serviceService so2 = new serviceService();
            so2.fetchservice();
        */    
           
    //delete service 
    /*
    int id_service= 5;
            serviceService so3 = new serviceService();
            so3. supprimerService(id_service);

   */
}


  
}
 
    


