/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entities;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author USER
 */
public class remboursement {

   

    public remboursement() {
       
    }

 
   
    @Override
    public String toString() {
        return "remboursement{" + "id_rembour=" + id_rembour + ", montant_rembour=" + montant_rembour + ", date_rembour=" + date_rembour + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + this.id_rembour;
        return hash;
    }

   
    
    private int id_rembour;
    public int montant_rembour;

    public remboursement(int id_rembour, int montant_rembour, LocalDate date_rembour) {
        this.id_rembour = id_rembour;
        this.montant_rembour = montant_rembour;
        this.date_rembour = date_rembour;
    }
      public remboursement( int montant_rembour, LocalDate date_rembour) {
        
        this.montant_rembour = montant_rembour;
        this.date_rembour = date_rembour;
    }
    private LocalDate date_rembour;
    

    public void setId_rembour(int id_rembour) {
        this.id_rembour = id_rembour;
    }

    public void setMontant_rembour(int montant_rembour) {
        this.montant_rembour = montant_rembour;
    }

    public void setDate_rembour(LocalDate date_rembour) {
        this.date_rembour = date_rembour;
    }
    

    
    public int getId_rembour() {
        return id_rembour;
    }

    public int getMontant_rembour() {
        return montant_rembour;
    }

    public LocalDate getDate_rembour() {
        return date_rembour;
    }
   
}
