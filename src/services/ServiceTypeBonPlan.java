/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceTypeBonPlan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import models.TypeBonPlan;
import utils.MaConnexion;

/**
 *
 * @author MSADDAK
 */
public class ServiceTypeBonPlan implements IServiceTypeBonPlan {
        MaConnexion instance= MaConnexion.getInstance();
        Connection cnx= instance.getCnx();

    @Override
    public void createTypeBonPlan(TypeBonPlan tbp) {
       String req = "INSERT INTO `typebonplan`(`locationBonPlan`, `travelStyle`) VALUES (?,?)";
    try {
        PreparedStatement st = cnx.prepareStatement(req);
        st.setString(1, tbp.getLocationBonPlan());
        st.setString(2, tbp.getTravelStyle());
        st.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }

    }

    /*@Override
    public List<TypeBonPlan> getAllTypeBonPlans() {
    String req = "SELECT * FROM `typebonplan`";
    List<TypeBonPlan> listTypeBonPlan = new ArrayList<>();
    try {
        PreparedStatement st = cnx.prepareStatement(req);
        ResultSet rs = st.executeQuery();
        while (rs.next()) {
            TypeBonPlan tbp = new TypeBonPlan();
            tbp.setIdTypeBonPlan(rs.getInt("idTypeBonPlan"));
            tbp.setLocationBonPlan(rs.getString("locationBonPlan"));
            tbp.setTravelStyle(rs.getString("travelStyle"));
            listTypeBonPlan.add(tbp);
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return listTypeBonPlan;
    }*/
    
    public List<TypeBonPlan> getAllTypebonPlan(TypeBonPlan typeBonPlan){
        String req ="SELECT * FROM  typebonplan";
        ArrayList<TypeBonPlan> tbps=new ArrayList<>();
        Statement stm;
        try {
            stm=this.cnx.createStatement();
            ResultSet rs=stm.executeQuery(req);
            while (rs.next()){
                TypeBonPlan tbpt = new TypeBonPlan();
                tbpt.setIdTypeBonPlan(rs.getInt("idTypeBonPlan"));
                tbpt.setLocationBonPlan(rs.getString("locationBonPlan"));
                tbpt.setTravelStyle(rs.getString("travelStyle"));
                tbps.add(tbpt);
                System.out.println("LoadedBonPlan"+tbpt.toString());
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbps;
    }
    

    @Override
    public void deleteTypeBonPlan(TypeBonPlan tbp) {
    String req = "DELETE FROM `typebonplan` WHERE `idTypeBonPlan`=?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, tbp.getIdTypeBonPlan());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void updateTypeBonPlan(TypeBonPlan tbp) {
    String req = "UPDATE `typebonplan` SET `locationBonPlan`=?, `travelStyle`=? WHERE `idTypeBonPlan`=?";
    try {
        PreparedStatement st = cnx.prepareStatement(req);
        st.setString(1, tbp.getLocationBonPlan());
        st.setString(2, tbp.getTravelStyle());
        st.setInt(3, tbp.getIdTypeBonPlan());
        st.executeUpdate();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    }

    @Override
    public List<TypeBonPlan> searchBonPlanByAvgPrice(String location) {
        List<TypeBonPlan> tbps=new ArrayList<>();   
        String req=("SELECT * FROM typebonplan WHERE locationBonPlan=?");

        try {
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setString(1, location);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                TypeBonPlan tbpt = new TypeBonPlan();
            tbpt.setIdTypeBonPlan(rs.getInt("idTypeBonPlan"));
            tbpt.setLocationBonPlan(rs.getString("locationBonPlan"));
            tbpt.setTravelStyle(rs.getString("travelStyle"));
            tbps.add(tbpt);
                
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tbps;
    }
    
    
}
