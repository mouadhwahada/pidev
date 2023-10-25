/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class Facture {
     private int idfacture;
     private int numfacture;
    private double montant;
    private String datePaiement;
    
    private Reservation Reservation;

    public Facture() {
    }

    public Facture(int idfacture, int numfacture, double montant, String datePaiement, Reservation Reservation) {
        this.idfacture = idfacture;
        this.numfacture = numfacture;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.Reservation = Reservation;
    }

    public Facture(int numfacture, double montant, String datePaiement, Reservation Reservation) {
        this.numfacture = numfacture;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.Reservation = Reservation;
    }

    public int getIdfacture() {
        return idfacture;
    }

    public int getNumfacture() {
        return numfacture;
    }

    public double getMontant() {
        return montant;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public Reservation getReservation() {
        return Reservation;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    public void setNumfacture(int numfacture) {
        this.numfacture = numfacture;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public void setReservation(Reservation Reservation) {
        this.Reservation = Reservation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idfacture;
        hash = 17 * hash + this.numfacture;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.montant) ^ (Double.doubleToLongBits(this.montant) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.datePaiement);
        hash = 17 * hash + Objects.hashCode(this.Reservation);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        if (this.idfacture != other.idfacture) {
            return false;
        }
        if (this.numfacture != other.numfacture) {
            return false;
        }
        if (Double.doubleToLongBits(this.montant) != Double.doubleToLongBits(other.montant)) {
            return false;
        }
        if (!Objects.equals(this.datePaiement, other.datePaiement)) {
            return false;
        }
        if (!Objects.equals(this.Reservation, other.Reservation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "idfacture=" + idfacture + ", numfacture=" + numfacture + ", montant=" + montant + ", datePaiement=" + datePaiement + ", Reservation=" + Reservation + '}';
    }

    public Facture(int numfacture, String datePaiement, Reservation Reservation) {
        this.numfacture = numfacture;
        this.datePaiement = datePaiement;
        this.Reservation = Reservation;
    }

   

   

   
    
}
