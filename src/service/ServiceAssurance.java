/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entitie.Agence;
import entitie.Assurance;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import util.FilterBadWord;
import util.MyConnexion;

/**
 *
 * @author Skymil
 */
public class ServiceAssurance implements Iservice<Assurance>{
    Connection cnx;
    public ServiceAssurance(){
        cnx=MyConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Assurance t) {
        try {
            String query="INSERT INTO `assurance`"
                    + "(`idUser`, `idCategorie`, `idAgence`,"
                    + " `passeport`, `destination`, `date`) "
                    + "VALUES ('"+t.getIdUser()+"','"+t.getIdCategorie()+"',"
                    + "'"+t.getIdAgence()+"','"+t.getPasseport()+"',"
                    + "'"+FilterBadWord.filter(t.getDestination())+"','"+t.getDate()+"')";
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void modifier(Assurance t, int id) {
        try {
            String query="UPDATE `assurance` SET `idUser`='"+t.getIdUser()+"',"
                    + "`idCategorie`='"+t.getIdCategorie()+"',"
                    + "`idAgence`='"+t.getIdAgence()+"',"
                    + "`passeport`='"+t.getPasseport()+"',"
                    + "`destination`='"+t.getDestination()+"',"
                    + "`date`='"+t.getDate()+"' WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void supprimer(int id) {
        try {
            String query="DELETE FROM `assurance` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Assurance> afficher() {
        List<Assurance> la=new ArrayList<>();
        try {
            String query="SELECT * FROM `assurance`";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Assurance a=new Assurance();
                a.setId(rs.getInt("id"));
                a.setIdUser(rs.getInt("idUser"));
                a.setIdAgence(rs.getInt("idAgence"));
                a.setIdCategorie(rs.getInt("idCategorie"));
                a.setPasseport(rs.getInt("passeport"));
                a.setDestination(rs.getString("destination"));
                a.setDate(rs.getDate("date"));
                la.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return la;

    }
    public List<Assurance> triParDestination(){
        return afficher()
                .stream()
                .sorted((a1,a2)->a1.getDestination().compareTo(a2.getDestination()))
                .collect(Collectors.toList());
    }
    public List<Assurance> afficherParIdUser(int idUser){
        /*return afficher()
                .stream()
                .filter(a->a.getIdUser()==idUser)
                .collect(Collectors.toList());*/
        List<Assurance> la=new ArrayList<>();
        for(Assurance a:afficher()){
            if(a.getIdUser()==idUser){
                la.add(a);
            }
        }
        return la;
    }
    public Assurance getAssuranceById(int id){
        return afficher().stream().filter(a->a.getId()==id).findAny().orElse(null);
    }
    
}
