/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import interfaces.IServiceBonPlan;
import models.BonPlan;
import utils.MaConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author MSADDAK
 */
public class ServiceBonPLan implements IServiceBonPlan {
    MaConnexion instance= MaConnexion.getInstance();
    Connection cnx= instance.getCnx();

    @Override
    public void createBonPlan(BonPlan bp) {
        String req="INSERT INTO `bonplan`(`nameBonPlan`, `rating`, `startDate`, `endDate`, `avgPrice`) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement st=cnx.prepareStatement(req);
            st.setString(1, bp.getNameBonPlan());
            st.setFloat(2, bp.getRating());
            st.setDate(3, bp.getStartDate());
            st.setDate(4, bp.getEndDate());
            st.setFloat(5,bp.getAvgPrice());
            st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void updateBonPlan(BonPlan bp) {
        String req="UPDATE `bonplan` SET `nameBonPlan`=?,`rating`=?,`startDate`=?,`endDate`=?,`avgPrice`=? WHERE `idBonPlan`=?";
        try {
            PreparedStatement st= cnx.prepareStatement(req);
            st.setString(1, bp.getNameBonPlan());
            st.setFloat(2, bp.getRating());
            st.setDate(3, bp.getStartDate());
            st.setDate(4, bp.getEndDate());
            st.setFloat(5, bp.getAvgPrice());
            st.setInt(6, bp.getIdBonPlan());
            //st.executeUpdate();
            int rowsUpdated;
            rowsUpdated=st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteBonPlan(BonPlan bp) {
         String req = "DELETE FROM `bonplan` WHERE `idBonPlan`=?";
        try {
            PreparedStatement st = cnx.prepareStatement(req);
            st.setInt(1, bp.getIdBonPlan());
            st.executeUpdate();
            System.out.println("deleted successfully");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    
    //from chatgpt: 
    @Override
public List<BonPlan> getAll(BonPlan bp) {
    String req = "SELECT * FROM bonplan";
    ArrayList<BonPlan> bps = new ArrayList<>();
    Statement stm;

    try {
        stm = this.cnx.createStatement();
        ResultSet rs = stm.executeQuery(req);
        while (rs.next()) {
            BonPlan bpt = new BonPlan();
            bpt.setIdBonPlan(rs.getInt("idBonPlan"));
            bpt.setNameBonPlan(rs.getString("nameBonPlan"));
            bpt.setRating(rs.getFloat("rating"));
            bpt.setStartDate(rs.getDate("startDate"));
            bpt.setEndDate(rs.getDate("endDate"));
            bpt.setAvgPrice(rs.getFloat("avgPrice"));
            bps.add(bpt); // Add the filled BonPlan object, not the empty one (bp)
            System.out.println("LoadedBonPlan" + bpt.toString());
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
    return bps;
    }
    @Override
    public List<BonPlan>searchBonPlanByAvgPrice(float minPrice, float maxPrice){
        List<BonPlan> bps=new ArrayList<>();   
        String req=("SELECT * FROM bonplan WHERE avgPrice >= ? AND avgPrice <= ?");

        try {
            PreparedStatement ps=cnx.prepareStatement(req);
            ps.setFloat(1, minPrice);
            ps.setFloat(2, maxPrice);
            ResultSet rs= ps.executeQuery();
            while (rs.next()){
                BonPlan bpt = new BonPlan();
            bpt.setIdBonPlan(rs.getInt("idBonPlan"));
            bpt.setNameBonPlan(rs.getString("nameBonPlan"));
            bpt.setRating(rs.getFloat("rating"));
            bpt.setStartDate(rs.getDate("startDate"));
            bpt.setEndDate(rs.getDate("endDate"));
            bpt.setAvgPrice(rs.getFloat("avgPrice"));
            bps.add(bpt);
                
            
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return bps;
    
    }
}
