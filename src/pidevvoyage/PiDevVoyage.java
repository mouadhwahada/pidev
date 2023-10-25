/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pidevvoyage;

import entitie.Agence;
import entitie.Assurance;
import entitie.Categorie;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServiceAgence;
import service.ServiceAssurance;
import service.ServiceCategorie;
import util.FilterBadWord;
import util.MyConnexion;

/**
 *
 * @author Skymil
 */
public class PiDevVoyage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ServiceCategorie sc=new ServiceCategorie();
        ServiceAgence sag=new ServiceAgence();
        ServiceAssurance sa=new ServiceAssurance();
        Categorie c=new Categorie("test2");
        //sc.ajouter(c);
        //sc.modifier(c, 1);
        //sc.supprimer(1);
        Agence ag=new Agence("ctama", "menzah6", 11111111, "ctama6@gmail.com");
        //sag.ajouter(ag);
        //sag.modifier(ag, 1);
        //sag.supprimer(1);
        Date d=new Date(2020-1900, 9, 15);
        Assurance a=new Assurance(1, 2, 2, 13245688, "destination35", d);
        
    }
    
}
