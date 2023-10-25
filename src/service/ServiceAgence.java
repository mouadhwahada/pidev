/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import entitie.Agence;
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
public class ServiceAgence implements Iservice<Agence> {
    Connection cnx;
    public ServiceAgence(){
        cnx=MyConnexion.getInstance().getCnx();
    }

    @Override
    public void ajouter(Agence t) {
        try {
            String query="INSERT INTO `agence`"
                    + "(`nomAgence`, `adresse`, `telephone`, `email`) "
                    + "VALUES ('"+t.getNomAgence()+"',"
                    + "'"+t.getAdresse()+"','"+t.getTelephone()+"','"+t.getEmail()+"')";
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Agence t, int id) {
        try {
            String query="UPDATE `agence` SET "
                    + "`nomAgence`='"+t.getNomAgence()+"',"
                    + "`adresse`='"+t.getAdresse()+"',"
                    + "`telephone`='"+t.getTelephone()+"',"
                    + "`email`='"+t.getEmail()+"' WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            String query="DELETE FROM `agence` WHERE id="+id;
            Statement st=cnx.createStatement();
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Agence> afficher() {
        List<Agence> la=new ArrayList<>();
        try {
            String query="SELECT * FROM `agence`";
            Statement st=cnx.createStatement();
            ResultSet rs=st.executeQuery(query);
            while(rs.next()){
                Agence a =new Agence();
                a.setId(rs.getInt("id"));
                a.setAdresse(rs.getString("adresse"));
                a.setEmail(rs.getString("email"));
                a.setNomAgence(rs.getString("nomAgence"));
                a.setTelephone(rs.getInt("telephone"));
                la.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceAssurance.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return la;
    }
    public List<Agence> triParNom(){
        return afficher()
                .stream()
                .sorted((a1,a2)->a1.getNomAgence().compareTo(a2.getNomAgence()))
                .collect(Collectors.toList());
    }
    public List<String> getAllAgenceName(){
        return afficher().stream().map(a->a.getNomAgence()).collect(Collectors.toList());
    }
    public int getIdByName(String name){
        return afficher().stream().filter(a->a.getNomAgence().equals(name)).findAny().orElse(null).getId();
    }
    public String getNameById(int id){
        return afficher().stream().filter(a->a.getId()==id).findAny().orElse(null).getNomAgence();
    }
    public Agence getAgenceById(int id){
        return afficher().stream().filter(a->a.getId()==id).findAny().orElse(null);
    }
    
}
