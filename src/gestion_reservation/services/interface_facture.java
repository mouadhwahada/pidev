/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.services;

import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;

/**
 *
 * @author pc
 */
public interface interface_facture {
    public void ajouterFacture(Facture f); 
    public void modifierFacture(Facture f);
 
}
