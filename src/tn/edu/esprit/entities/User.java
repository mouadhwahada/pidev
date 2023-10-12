/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities;

/**
 *
 * @author Maryem
 */
public class User {
    
    private int id;
    private String nom,prenom,email; 
    private String pseudo,cin ;
    private String mdp; 

    public User(String nom, String prenom, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        
    }
    public User(String cin,String nom, String prenom, String email,String pseudo, String mdp) {
        this.cin = cin; 
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.pseudo = pseudo;
        this.mdp = mdp;
    }
    
    public User (String pseudo, String mdp) // s'authentifier 
    {
        this.pseudo = pseudo;
        this.mdp = mdp;
    }

    
     public User(int id, String cin, String nom, String prenom, String email ) {
        this.id = id; 
        this.cin = cin;
         this.nom = nom;
        this.prenom = prenom;
        this.email = email;
    }

    public User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    
     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
     public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    
    
    @Override
    public String toString() {
        return  "User{" + "id=" + id  + ", cin =" + cin   + ", nom=" + nom  + ", prenom=" + prenom  + "' email =" + email + ",pseudo=" + pseudo + ", mdp = " + mdp + "}" ;
        
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
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
        final User other = (User) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
    
    
}
