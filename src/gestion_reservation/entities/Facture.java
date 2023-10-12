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
    private double montant;
    private String datePaiement;
    private String modePaiement;
    private int ref_facture;
    private int idReservation;

    public Facture() {
    }

    public Facture(int idfacture, double montant, String datePaiement, String modePaiement, int ref_facture, int idReservation) {
        this.idfacture = idfacture;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.modePaiement = modePaiement;
        this.ref_facture = ref_facture;
        this.idReservation = idReservation;
    }

    public Facture(double montant, String datePaiement, String modePaiement, int ref_facture, int idReservation) {
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.modePaiement = modePaiement;
        this.ref_facture = ref_facture;
        this.idReservation = idReservation;
    }
    
   
   
     
    

    public int getIdfacture() {
        return idfacture;
    }
    public int getRef_facture() {
        return ref_facture;
    }
    public double getMontant() {
        return montant;
    }

    public String getDatePaiement() {
        return datePaiement;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public int getIdReservation() {
        return idReservation;
    }
    

   

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setDatePaiement(String datePaiement) {
        this.datePaiement = datePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }
    public void setRef_facture(int ref_facture) {
        this.ref_facture = ref_facture;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.idfacture;
        hash = 59 * hash + (int) (Double.doubleToLongBits(this.montant) ^ (Double.doubleToLongBits(this.montant) >>> 32));
        hash = 59 * hash + Objects.hashCode(this.datePaiement);
        hash = 59 * hash + Objects.hashCode(this.modePaiement);
        hash = 59 * hash + Objects.hashCode(this.idReservation);
        hash = 59 * hash + this.ref_facture;
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
        if (Double.doubleToLongBits(this.montant) != Double.doubleToLongBits(other.montant)) {
            return false;
        }
        if (this.ref_facture != other.ref_facture) {
            return false;
        }
        if (!Objects.equals(this.datePaiement, other.datePaiement)) {
            return false;
        }
        if (!Objects.equals(this.modePaiement, other.modePaiement)) {
            return false;
        }
        if (!Objects.equals(this.idReservation, other.idReservation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Facture{" + "idfacture=" + idfacture + ", montant=" + montant + ", datePaiement=" + datePaiement + ", modePaiement=" + modePaiement + ", ref_facture=" + ref_facture + ", idReservation=" + idReservation + '}';
    }

   
    
}
