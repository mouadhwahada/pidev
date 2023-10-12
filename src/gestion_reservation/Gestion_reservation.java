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
import java.util.Date;
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
        
         /*Datasource.getInstance();
             
            LocalDate dateDebut = LocalDate.of(2023, 10, 8); // Exemple de date de début
               LocalDate dateFin = LocalDate.of(2023, 10, 11);   // Exemple de date de fin
        
            Reservation res = new Reservation(dateDebut, dateFin, 1458456, "nawras", 2, "hotel", "excursion");
            ServiceReservation res1=new ServiceReservation();
            res1.ajouterReservation(res);*/
            
           /* Reservation res2 = new Reservation(1,LocalDate.of(2023, 10,3 ),LocalDate.of(2023, 10, 5) , 1578, "lara", 2, "hotel", "excursion");
           ServiceReservation serviceres=new ServiceReservation();
          serviceres.modifierReservation(res2);*/
          // Reservation res2 = new Reservation(1,LocalDate.of(2023, 10,3 ),LocalDate.of(2023, 10, 5) , 1578, "lara", 2, "hotel", "excursion");
           /* ServiceReservation serviceres=new ServiceReservation();
          serviceres.supprimerReservation(1); 
            List<Reservation> lresrrvation = new ArrayList<>();
        ServiceReservation s2 = new ServiceReservation();
          s2.afficherReservation();*/
           
     Facture facture = new Facture(200.50,"3 octobre 2023","en ligne",8946,1);
            ServiceFacture f1=new ServiceFacture();
            f1.ajouterFacture(facture);
     /* Facture facture1 = new Facture(500,"5 octobre 2023","en ligne",3);
            ServiceFacture f2=new ServiceFacture();
            f2.ajouterFacture(facture1);*/
      /*Facture fact = new Facture(1,356,"15/10/2023","especes",79);
         ServiceFacture f3=new ServiceFacture();
            f3.modifierFacture(fact);*/
     /*ServiceFacture service=new ServiceFacture();
          service.supprimerFacture(3); */
     
 /*ServiceFacture f4=new ServiceFacture();
            f4.afficherFacture();*/
           

            // Utilisez res comme vous le souhaitez
      
        
         
    }
    
}
