/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


/**
 *
 * @author USER
 */
public class reclamation {
    
    private int id;
    private String type;
    private String nom;
    private String description;
    private LocalDateTime date_reclama;

    

    public LocalDateTime getDate_reclama() {
        return date_reclama;
    }

    public void setDate_reclama(LocalDateTime date_reclama) {
        this.date_reclama = date_reclama;
    }
   
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


  

    public reclamation() {
    }

    public reclamation(int id, String type, String nom, String description, LocalDateTime date_reclama) {
        this.id = id;
        this.type = type;
        this.nom = nom;
        this.description = description;
        this.date_reclama = date_reclama;
    }

    public reclamation(String type, String nom, String description, LocalDateTime date_reclama) {
        this.type = type;
        this.nom = nom;
        this.description = description;
        this.date_reclama = date_reclama;
    }
    
    public reclamation(String type, String nom, String description) {
        this.type = type;
        this.nom = nom;
        this.description = description;
    }

 
    
 

     /*   public static reclamation getReclamationById(List<reclamation> reclamations, int id) {
    for (reclamation r : reclamations) {
        if (r.getId() == id) {
            return r;
        }
    }
    return null;
}*/

    @Override
    public String toString() {
        return "reclamation{" + "id=" + id + ", type=" + type + ", nom=" + nom + ", description=" + description + ", date_reclama=" + date_reclama + '}';
    }

 

    
}



