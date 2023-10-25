/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitie;

import java.sql.Date;
import service.ServiceAgence;
import service.ServiceCategorie;

/**
 *
 * @author Skymil
 */
public class Assurance {
    private int id;
    private int idUser;
    private int idCategorie;
    private int idAgence;
    private int passeport;
    private String destination;
    private Date date;

    public Assurance() {
    }

    public Assurance(int idUser, int idCategorie, int idAgence, int passeport, String destination, Date date) {
        this.idUser = idUser;
        this.idCategorie = idCategorie;
        this.idAgence = idAgence;
        this.passeport = passeport;
        this.destination = destination;
        this.date = date;
    }

    public Assurance(int id, int idUser, int idCategorie, int idAgence, int passeport, String destination, Date date) {
        this.id = id;
        this.idUser = idUser;
        this.idCategorie = idCategorie;
        this.idAgence = idAgence;
        this.passeport = passeport;
        this.destination = destination;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    public int getPasseport() {
        return passeport;
    }

    public void setPasseport(int passeport) {
        this.passeport = passeport;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    ServiceCategorie sc=new ServiceCategorie();
    ServiceAgence saa=new ServiceAgence();
    @Override
    public String toString() {
        return "Categorie: "+sc.getNameById(this.getIdCategorie())+ " Agence: "+saa.getNameById(this.getIdAgence())
                    +" Passeport:"+this.getPasseport()+" Destination: "+this.getDestination()+" Date:"+this.getDate()+"\n";
    }
    
    
    
    
}
