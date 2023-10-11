/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities_transport;

import java.util.Objects;
import service_transport.IService_location;
import service_transport.Service_location;

/**
 *
 * @author HP
 */
public class Location_vehicule {
    private int id_loc_vehicule;
    private int cin_client_vehicule;
    private String duree_loc_vehicule;
    private String pickup_vehicule;
    private String return_vehicule;
    private int id_vehicle;

    public Location_vehicule() {
    }

    public Location_vehicule(int id_loc_vehicule, int cin_client_vehicule, String duree_loc_vehicule, String pickup_vehicule, String return_vehicule, int id_vehicle) {
        this.id_loc_vehicule = id_loc_vehicule;
        this.cin_client_vehicule = cin_client_vehicule;
        this.duree_loc_vehicule = duree_loc_vehicule;
        this.pickup_vehicule = pickup_vehicule;
        this.return_vehicule = return_vehicule;
        this.id_vehicle = id_vehicle;
    }

    public Location_vehicule(int cin_client_vehicule, String duree_loc_vehicule, String pickup_vehicule, String return_vehicule, int id_vehicle) {
        this.cin_client_vehicule = cin_client_vehicule;
        this.duree_loc_vehicule = duree_loc_vehicule;
        this.pickup_vehicule = pickup_vehicule;
        this.return_vehicule = return_vehicule;
        this.id_vehicle = id_vehicle;
    }

    
  

    public Location_vehicule(int cin_client_vehicule, String duree_loc_vehicule, String pickup_vehicule, String return_vehicule) {
        this.cin_client_vehicule = cin_client_vehicule;
        this.duree_loc_vehicule = duree_loc_vehicule;
        this.pickup_vehicule = pickup_vehicule;
        this.return_vehicule = return_vehicule;
    }

    public Location_vehicule(int id_loc_vehicule, int cin_client_vehicule, String duree_loc_vehicule, String pickup_vehicule, String return_vehicule) {
        this.id_loc_vehicule = id_loc_vehicule;
        this.cin_client_vehicule = cin_client_vehicule;
        this.duree_loc_vehicule = duree_loc_vehicule;
        this.pickup_vehicule = pickup_vehicule;
        this.return_vehicule = return_vehicule;
    }
   


    public int getId_loc_vehicule() {
        return id_loc_vehicule;
    }

    public int getCin_client_vehicule() {
        return cin_client_vehicule;
    }

    public String getDuree_loc_vehicule() {
        return duree_loc_vehicule;
    }

    public String getPickup_vehicule() {
        return pickup_vehicule;
    }

    public String getReturn_vehicule() {
        return return_vehicule;
    }
     public int getId_vehicle() {
        return id_vehicle;
    }
  

    public void setId_loc_vehicule(int id_loc_vehicule) {
        this.id_loc_vehicule = id_loc_vehicule;
    }

    public void setCin_client_vehicule(int cin_client_vehicule) {
        this.cin_client_vehicule = cin_client_vehicule;
    }

    public void setDuree_loc_vehicule(String duree_loc_vehicule) {
        this.duree_loc_vehicule = duree_loc_vehicule;
    }

    public void setPickup_vehicule(String pickup_vehicule) {
        this.pickup_vehicule = pickup_vehicule;
    }

    public void setReturn_vehicule(String return_vehicule) {
        this.return_vehicule = return_vehicule;
    }
    public void setId_vehicle(int id_vehicle) {
        this.id_vehicle = id_vehicle;
    }


    @Override
    public String toString() {
        return "Location_vehicule{" + "id_loc_vehicule=" + id_loc_vehicule + ", cin_client_vehicule=" + cin_client_vehicule + ", duree_loc_vehicule=" + duree_loc_vehicule + ", pickup_vehicule=" + pickup_vehicule + ", return_vehicule=" + return_vehicule + ", id_vehicle=" + id_vehicle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id_loc_vehicule;
        hash = 41 * hash + this.cin_client_vehicule;
        hash = 41 * hash + Objects.hashCode(this.duree_loc_vehicule);
        hash = 41 * hash + Objects.hashCode(this.pickup_vehicule);
        hash = 41 * hash + Objects.hashCode(this.return_vehicule);
        hash = 41 * hash + this.id_vehicle;
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
        final Location_vehicule other = (Location_vehicule) obj;
        if (this.id_loc_vehicule != other.id_loc_vehicule) {
            return false;
        }
        if (this.cin_client_vehicule != other.cin_client_vehicule) {
            return false;
        }
        if (this.id_vehicle != other.id_vehicle) {
            return false;
        }
        if (!Objects.equals(this.duree_loc_vehicule, other.duree_loc_vehicule)) {
            return false;
        }
        if (!Objects.equals(this.pickup_vehicule, other.pickup_vehicule)) {
            return false;
        }
        if (!Objects.equals(this.return_vehicule, other.return_vehicule)) {
            return false;
        }
        return true;
    }

 

   
}
