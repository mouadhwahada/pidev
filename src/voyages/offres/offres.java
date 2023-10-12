/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres;

 import voyages.offres.service;
import java.sql.Date;
import java.time.LocalDate;


/**
 *
 * @author ASUS
 */
public class offres {
    private int id_offres;


    private int réference;
    private String destination;
    private LocalDate début;
    private LocalDate fin;
    private double prix;
  private int id_service ;

   
  

      public offres() {
    } 


    public offres(String destination, LocalDate début, LocalDate fin, double prix,int réference ,int id_service ) {
       
        this.destination = destination;
        this.début = début;
        this.fin = fin;
        this.prix = prix;
         this.réference=réference;
        this.id_service= id_service ;

    }
     public offres(int id_offres, String destination, LocalDate début, LocalDate fin, double prix, int réference,int id_service ) {
        this.id_offres = id_offres;
        
        this.destination = destination;
        this.début = début;
        this.fin = fin;
        this.prix = prix;
         this.réference=réference;
         this.id_service= id_service;
    }
    
    
 public int getId_service() {
        return id_service;
    }

    public void setId_service(int id_service) {
        this.id_service = id_service;
    }

  
   

    public int getId_offres() {
        return id_offres;
    }

    public String getDestination() {
        return destination;
    }

    
    public LocalDate getFin() {
        return fin;
    }
     
    public LocalDate getDébut() {
        return fin;
    }

    public double getPrix() {
        return prix;
    }
    

    public void setId_offres(int id_offres) {
        this.id_offres = id_offres;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDébut(LocalDate début) {
        this.début = début;
    }

    public void setFin( LocalDate fin) {
        this.fin = fin;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
        public int getRéference() {
        return réference;
    }

    public void setRéference(int réference) {
        this.réference = réference;
    }
    

    @Override
    public String toString() {
        return "offres{" + "id_offres=" + id_offres  + "réference=" + réference + ", destination=" + destination + ", début=" + début + ", fin=" + fin + ", prix=" + prix +",id_service="+id_service+ '}';
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
        final offres other = (offres) obj;
        if (this.id_offres != other.id_offres) {
            return false;
        }
        return true;
    }

   
    
}

