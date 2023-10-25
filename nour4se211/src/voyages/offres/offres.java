/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres;

 import voyages.offres.service;
import java.sql.Date;
import java.time.LocalDate;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author ASUS
 */
public class offres {
    private int id_offres;


   
    private String destination;
    private Date début;
    private Date fin;
    private int prix;
    private int ss;
  private service Service ;
 
   
  

      public offres() {
    } 

 
    public offres(String destination, Date début, Date fin, int prix ,service Service) {
       
        this.destination = destination;
        this.début = début;
        this.fin = fin;
        this.prix = prix;
        
       this.Service=Service;
      
    }
    
     public offres(int id_offres, String destination, Date début, Date fin, int prix,service Service) {
        this.id_offres = id_offres;
        
        this.destination = destination;
        this.début = début;
        this.fin = fin;
        this.prix = prix;
        
         this.Service= Service;
    }

   

    public void setService(service Service) {
        this.Service = Service;
    }
    
    


    public service getService() {
        return Service;
    }

  
  
   

    public int getId_offres() {
        return id_offres;
    }

    public String getDestination() {
        return destination;
    }

    
    public Date getFin() {
        return fin;
    }
     
    public Date getDébut() {
        return début;
    }

    public int getPrix() {
        return prix;
    }
    

    public void setId_offres(int id_offres) {
        this.id_offres = id_offres;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDébut(Date début) {
        this.début = début;
    }

    public void setFin( Date fin) {
        this.fin = fin;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
      
    

    @Override
    public String toString() {
        return "offres{" + "id_offres=" + id_offres  + ", destination=" + destination + ", début=" + début + ", fin=" + fin + ", prix=" + prix +",Service=" + Service.getId_service() + '}';
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

