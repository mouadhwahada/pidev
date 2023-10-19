/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation;

import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceFacture;
import gestion_reservation.services.ServiceReservation;
import gestion_reservation.services.tools.Datasource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author pc
 */
public class Gestion_reservation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
         Datasource.getInstance();
             
          
        
        /*  java.sql.Date dateDebut = java.sql.Date.valueOf("2023-10-17");
           java.sql.Date dateFin = java.sql.Date.valueOf("2023-10-25");
           Reservation res = new Reservation(1,14587936, "Lassoued",2 ,dateDebut, dateFin,"chèques", "motel", "visite musée",54684);*/
         /*  ServiceReservation res1=new ServiceReservation();
            res1.ajouterReservation(res);*/
           
           Reservation res = new Reservation(1564687,"saied", 1,java.sql.Date.valueOf("2023-10-16"), java.sql.Date.valueOf("2023-10-24"),"virement bancaire", "hotel", "excursion",54684);

          /* ServiceReservation serviceres=new ServiceReservation();
          serviceres.modifierReservation(res);*/
          // Reservation res2 = new Reservation(1,LocalDate.of(2023, 10,3 ),LocalDate.of(2023, 10, 5) , 1578, "lara", 2, "hotel", "excursion");
           /* ServiceReservation serviceres=new ServiceReservation();
          serviceres.supprimerReservation(1); 
            List<Reservation> lresrrvation = new ArrayList<>();
        ServiceReservation s2 = new ServiceReservation();
          s2.afficherReservation();*/
         
           
     /*Facture facture = new Facture(25,500.25,"2/10/2023",res);
           ServiceFacture f1=new ServiceFacture();
            f1.ajouterFacture(facture);*/
    /* Facture facture1 = new Facture(25,495.5,"5 octobre 2023",res);
            ServiceFacture f2=new ServiceFacture();
            f2.modifierFacture(facture1);*/
    //  Facture fact = new Facture(356.25,"17/10/2023","especes",845621,res);
      //   ServiceFacture f3=new ServiceFacture();
       //     f3.modifierFacture(fact);
     /*ServiceFacture service=new ServiceFacture();
          service.supprimerFacture(3); */
     
 ServiceFacture f4=new ServiceFacture();
          f4.afficherFacture();
           

            // Utilisez res comme vous le souhaitez
      
        
         
    }
    
}
