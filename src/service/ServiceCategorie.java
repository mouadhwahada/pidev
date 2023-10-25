/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entitie.Assurance;
import entitie.Categorie;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import util.MyConnexion;

/**
 *
 * @author Skymil
 */
public class ServiceCategorie implements Iservice<Categorie>{
    Connection cnx;
    public ServiceCategorie(){
        cnx=MyConnexion.getInstance().getCnx();
    }
    @Override
    public void ajouter(Categorie t) {
        try {
            String query="INSERT INTO `categorie`( `nomCategorie`) VALUES ('"+t.getNomCategorie()+"')";
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Categorie t, int id) {
        try {
            String query="UPDATE `categorie` SET "
                    + "`nomCategorie`='"+t.getNomCategorie()+"' WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String query="DELETE FROM `categorie` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Categorie> afficher() {
        List<Categorie> lc=new ArrayList<>();
        try {
            String query="SELECT * FROM `categorie`";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Categorie c=new Categorie(rs.getInt("id"), rs.getString("nomCategorie"));
                lc.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lc;
    }
    public List<Categorie> triParNom(){
        return afficher()
                .stream()
                .sorted((c1,c2)->c1.getNomCategorie().compareTo(c2.getNomCategorie()))
                .collect(Collectors.toList());
    }
    public List<String> getAllCategorieName(){
        return afficher().stream().map(c->c.getNomCategorie()).collect(Collectors.toList());
    }
    public int getIdByName(String name){
        return afficher().stream().filter(c->c.getNomCategorie().equals(name)).findAny().orElse(null).getId();
    }
    public String getNameById(int id){
        return afficher().stream().filter(c->c.getId()==id).findAny().orElse(null).getNomCategorie();
    }
    
}
