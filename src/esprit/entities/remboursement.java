/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import javafx.scene.control.TextField;

/**
 *
 * @author USER
 */
public class remboursement {

    private int id_rembour;
    public int montant_rembour;
    private LocalDateTime date_rembour;
    private String Motif_rembour ;

    public remboursement(TextField montant, LocalDateTime myDate, String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_rembour() {
        return id_rembour;
    }

    public void setId_rembour(int id_rembour) {
        this.id_rembour = id_rembour;
    }

    public int getMontant_rembour() {
        return montant_rembour;
    }

    public void setMontant_rembour(int montant_rembour) {
        this.montant_rembour = montant_rembour;
    }

    public LocalDateTime getDate_rembour() {
        return date_rembour;
    }

    public void setDate_rembour(LocalDateTime date_rembour) {
        this.date_rembour = date_rembour;
    }

    public String getMotif_rembour() {
        return Motif_rembour;
    }

    public void setMotif_rembour(String Motif_rembour) {
        this.Motif_rembour = Motif_rembour;
    }

    public remboursement() {
    }

    public remboursement(int id_rembour, int montant_rembour, LocalDateTime date_rembour, String Motif_rembour) {
        this.id_rembour = id_rembour;
        this.montant_rembour = montant_rembour;
        this.date_rembour = date_rembour;
        this.Motif_rembour = Motif_rembour;
    }

    public remboursement(int montant_rembour, LocalDateTime date_rembour, String Motif_rembour) {
        this.montant_rembour = montant_rembour;
        this.date_rembour = date_rembour;
        this.Motif_rembour = Motif_rembour;
    }

    @Override
    public String toString() {
        return "remboursement{" + "id_rembour=" + id_rembour + ", montant_rembour=" + montant_rembour + ", date_rembour=" + date_rembour + ", Motif_rembour=" + Motif_rembour + '}';
    }

    
  
  
   
}
