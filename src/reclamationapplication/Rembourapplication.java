/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reclamationapplication;

import esprit.entities.remboursement;
import esprit.services.serviceremboursement;
import esprit.tools.DataSource;
import java.time.LocalDate;

/**
 *
 * @author USER
 */
public class Rembourapplication {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
                DataSource.getInstance();

        
        
        // LocalDate date2 = LocalDate.of(2020,10,9);
      
        //remboursement re = new remboursement (123,date2);
        //serviceremboursement re1= new serviceremboursement();
 
          //       re1.addRemboursement(re);
                 
              //   remboursement re =new remboursement();
             //re.setId_rembour(1);
             //re.setMontant_rembour(111);
              //re.setDate_rembour(LocalDate.now());
                   
     //serviceremboursement re4= new serviceremboursement();
     //re4.modifier_remboursement (re);
      serviceremboursement r2= new serviceremboursement();
      r2.supprimer_remboursement(1);
    
    
    }
    
}
