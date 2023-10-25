/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres;

/**
 *
 * @author ASUS
 */
public class service {
        private int id_service;

    
    private String nom_service;
    private String description_service;
    private int prix_service;
  
  
    
      public service() {
    }

    public service(int id_service, String nom_service, String description_service, int prix_service) {
        this.id_service = id_service;
        this.nom_service = nom_service;
        this.description_service = description_service;
        this.prix_service = prix_service;
        
    }
      

    public service(String nom_service, String description_service, int prix_service) {
        this.nom_service = nom_service;
        this.description_service = description_service;
        this.prix_service = prix_service;
         
    }

  
   
   

    public int getId_service() {
        return id_service;
    }

    public String getNom_service() {
        return nom_service;
    }

    public String getDescription_service() {
        return description_service;
    }

    public int getPrix_service() {
        return prix_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

    public void setNom_service(String nom_service) {
        this.nom_service = nom_service;
    }

    public void setDescription_service(String description_service) {
        this.description_service = description_service;
    }

    public void setPrix_service(int prix_service) {
        this.prix_service = prix_service;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final service other = (service) obj;
        if (this.id_service != other.id_service) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "service{" + "id_service=" + id_service + ", nom_service=" + nom_service + ", description_service=" + description_service + ", prix_service=" + prix_service +  '}';
    }
    
    
}
