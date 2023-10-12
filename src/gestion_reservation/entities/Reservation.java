/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion_reservation.entities;

import java.time.LocalDate;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author pc
 */
public class Reservation {
     private int idReservation;
    private  LocalDate dateDebut;
    private  LocalDate dateFin;
    private int CinClient;
    private String nomClient;
    private int nombrePersonnes;
    private String typeHebergement;
    private String typeActivite;

    public Reservation() {
    }

    public Reservation( LocalDate dateDebut, LocalDate dateFin, int CinClient, String nomClient, int nombrePersonnes, String typeHebergement, String typeActivite) {
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.CinClient = CinClient;
        this.nomClient = nomClient;
        this.nombrePersonnes = nombrePersonnes;
        this.typeHebergement = typeHebergement;
        this.typeActivite = typeActivite;
    }
   
    public Reservation(int idReservation,  LocalDate dateDebut,  LocalDate dateFin, int CinClient, String nomClient, int nombrePersonnes, String typeHebergement, String typeActivite) {
        this.idReservation = idReservation;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.CinClient = CinClient;
        this.nomClient = nomClient;
        this.nombrePersonnes = nombrePersonnes;
        this.typeHebergement = typeHebergement;
        this.typeActivite = typeActivite;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public  LocalDate getDateDebut() {
        return dateDebut;
    }

    public  LocalDate getDateFin() {
        return dateFin;
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

    public String getTypeHebergement() {
        return typeHebergement;
    }

    public String getTypeActivite() {
        return typeActivite;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public void setDateDebut( LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin( LocalDate dateFin) {
        this.dateFin = dateFin;
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

    public void setTypeHebergement(String typeHebergement) {
        this.typeHebergement = typeHebergement;
    }

    public void setTypeActivite(String typeActivite) {
        this.typeActivite = typeActivite;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.idReservation;
        hash = 37 * hash + Objects.hashCode(this.dateDebut);
        hash = 37 * hash + Objects.hashCode(this.dateFin);
        hash = 37 * hash + this.CinClient;
        hash = 37 * hash + Objects.hashCode(this.nomClient);
        hash = 37 * hash + this.nombrePersonnes;
        hash = 37 * hash + Objects.hashCode(this.typeHebergement);
        hash = 37 * hash + Objects.hashCode(this.typeActivite);
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
        if (!Objects.equals(this.nomClient, other.nomClient)) {
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
    
    public String toString() {
    return "Reservation{" +
           "idReservation=" + idReservation +
           ", dateDebut=" + dateDebut +
           ", dateFin=" + dateFin +
           ", cinClient=" + CinClient +
           ", nomClient='" + nomClient + '\'' +
           ", nombrePersonnes=" + nombrePersonnes +
           ", typeHebergement='" + typeHebergement + '\'' +
           ", typeActivite='" + typeActivite + '\'' +
           '}';
}

    
}
