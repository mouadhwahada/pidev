/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.services;

import gestion_reservation.entities.Reservation;
import java.util.List;

/**
 *
 * @author pc
 */
public interface interface_reservation {
    public void ajouterReservation(Reservation res);
     public void modifierReservation(Reservation r);
     public void supprimerReservation(int idreservation);
   
    
}
