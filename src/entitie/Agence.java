/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

/**
 *
 * @author Skymil
 */
public class Agence {
    private int id;
    private String nomAgence;
    private String adresse;
    private int telephone;
    private String email;

    public Agence() {
    }

    public Agence(String nomAgence, String adresse, int telephone, String email) {
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public Agence(int id, String nomAgence, String adresse, int telephone, String email) {
        this.id = id;
        this.nomAgence = nomAgence;
        this.adresse = adresse;
        this.telephone = telephone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomAgence() {
        return nomAgence;
    }

    public void setNomAgence(String nomAgence) {
        this.nomAgence = nomAgence;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    @Override
    public String toString() {
        return "Agence{" + "id=" + id + ", nomAgence=" + nomAgence + ", adresse=" + adresse + ", telephone=" + telephone + ", email=" + email  + '}';
    }
    
}
