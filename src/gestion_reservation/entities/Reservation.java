/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.entities;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.sql.Date;
import java.util.Objects;
import javafx.scene.control.DatePicker;

/**
 *
 * @author pc
 */
public class Reservation {
    private int idReservation;
    private int CinClient;
    private String nomClient;
    private int nombrePersonnes;
    private  Date dateDebut;
    private  Date dateFin;
    private String mode_paiement;
    private String typeHebergement;
    private String typeActivite;
    private int numtelephone;

    public Reservation() {
    }

    public Reservation(int idReservation, int CinClient, String nomClient, int nombrePersonnes, Date dateDebut, Date dateFin, String mode_paiement, String typeHebergement, String typeActivite, int numtelephone) {
        this.idReservation = idReservation;
        this.CinClient = CinClient;
        this.nomClient = nomClient;
        this.nombrePersonnes = nombrePersonnes;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.mode_paiement = mode_paiement;
        this.typeHebergement = typeHebergement;
        this.typeActivite = typeActivite;
        this.numtelephone = numtelephone;
    }

    public Reservation(int CinClient, String nomClient, int nombrePersonnes, Date dateDebut, Date dateFin, String mode_paiement, String typeHebergement, String typeActivite, int numtelephone) {
        this.CinClient = CinClient;
        this.nomClient = nomClient;
        this.nombrePersonnes = nombrePersonnes;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.mode_paiement = mode_paiement;
        this.typeHebergement = typeHebergement;
        this.typeActivite = typeActivite;
        this.numtelephone = numtelephone;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public int getCinClient() {
        return CinClient;
    }

    public String getNomClient() {
        return nomClient;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public String getMode_paiement() {
        return mode_paiement;
    }

    public String getTypeHebergement() {
        return typeHebergement;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public int getNumtelephone() {
        return numtelephone;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setCinClient(int CinClient) {
        this.CinClient = CinClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public void setNombrePersonnes(int nombrePersonnes) {
        this.nombrePersonnes = nombrePersonnes;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public void setMode_paiement(String mode_paiement) {
        this.mode_paiement = mode_paiement;
    }

    public void setTypeHebergement(String typeHebergement) {
        this.typeHebergement = typeHebergement;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    public void setNumtelephone(int numtelephone) {
        this.numtelephone = numtelephone;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.idReservation;
        hash = 41 * hash + this.CinClient;
        hash = 41 * hash + Objects.hashCode(this.nomClient);
        hash = 41 * hash + this.nombrePersonnes;
        hash = 41 * hash + Objects.hashCode(this.dateDebut);
        hash = 41 * hash + Objects.hashCode(this.dateFin);
        hash = 41 * hash + Objects.hashCode(this.mode_paiement);
        hash = 41 * hash + Objects.hashCode(this.typeHebergement);
        hash = 41 * hash + Objects.hashCode(this.typeActivite);
        hash = 41 * hash + this.numtelephone;
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
        final Reservation other = (Reservation) obj;
        if (this.idReservation != other.idReservation) {
            return false;
        }
        if (this.CinClient != other.CinClient) {
            return false;
        }
        if (this.nombrePersonnes != other.nombrePersonnes) {
            return false;
        }
        if (this.numtelephone != other.numtelephone) {
            return false;
        }
        if (!Objects.equals(this.nomClient, other.nomClient)) {
            return false;
        }
        if (!Objects.equals(this.mode_paiement, other.mode_paiement)) {
            return false;
        }
        if (!Objects.equals(this.typeHebergement, other.typeHebergement)) {
            return false;
        }
        if (!Objects.equals(this.typeActivite, other.typeActivite)) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.dateFin, other.dateFin)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Reservation{" + "idReservation=" + idReservation + ", CinClient=" + CinClient + ", nomClient=" + nomClient + ", nombrePersonnes=" + nombrePersonnes + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin + ", mode_paiement=" + mode_paiement + ", typeHebergement=" + typeHebergement + ", typeActivite=" + typeActivite + ", numtelephone=" + numtelephone + '}';
    }

}