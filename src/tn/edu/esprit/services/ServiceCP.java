/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date ;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.tools.DataSource;

/**
 *
 * @author Maryem
 */
public class ServiceCP implements ICPService<CodePromo>{
private Connection cnx = DataSource.getInstance().getConnection();


    @Override
    public void ajoutercp(CodePromo cp) {
       try {
    String req = "INSERT INTO CodePromo(code, description, datedexpiration) VALUES (?, ?, ?)";
    PreparedStatement ps = cnx.prepareStatement(req);
    ps.setString(1, cp.getCode());
    ps.setString(2, cp.getDescription());
    ps.setDate(3, cp.getDatedexpiration());
 

    
    ps.executeUpdate();
} catch (SQLException ex) {
    System.out.println(ex.getMessage());
}

    }

    @Override
    public void modifiercp(CodePromo cp) {
       String sql = "UPDATE codepromo SET code = ?, description = ?, `datedexpiration` = ? WHERE id_codepromo = ?";

    
    
try {
            try (PreparedStatement ps = cnx.prepareStatement(sql)) {
               ps.setString(1, cp.getCode());
               ps.setString(2, cp.getDescription());
               ps.setDate(3, cp.getDatedexpiration());
               ps.setInt(4, cp.getId_codepromo());

                int rowsUpdated;
                rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("La modification a été effectuée avec succès ");
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public void supprimercp(CodePromo cp) {
        
         try {
            String req = "DELETE FROM `codepromo` WHERE `id_codepromo` = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setInt(1, cp.getId_codepromo());
                ps.executeUpdate();
                System.out.println("CodePromo supprimé");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public CodePromo recherchercp(int id) {
        try {
            String req = "SELECT * FROM CodePromo WHERE idUtilisateur = " + id;
            try (Statement stm = cnx.createStatement()) {
                ResultSet rs = stm.executeQuery(req);
                if (rs.next()) {
                    CodePromo  codepromo = new CodePromo ();
                  codepromo.setId_codepromo(rs.getInt("Id_codepromo"));
                  codepromo.setCode(rs.getString("code"));
                  codepromo.setDescription(rs.getString("description"));
                  codepromo.setDatedexpiration(rs.getDate("datedexpiration"));
            

                    return codepromo;
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<CodePromo> getAlluti(CodePromo cp) {
         String req = "SELECT * FROM `codepromo`";
        ArrayList<CodePromo> codepromos = new ArrayList<>();
           Statement stm;
    
try {
        stm = this.cnx.createStatement();
        ResultSet rs = stm.executeQuery(req);
        while (rs.next()) {
            CodePromo codepromo = new CodePromo();
            codepromo.setId_codepromo(rs.getInt("Id_codepromo"));
            codepromo.setCode(rs.getString("code"));
            codepromo.setDescription(rs.getString("description"));
            codepromo.setDatedexpiration(rs.getDate("datedexpiration"));

            codepromos.add(codepromo);
        }
        } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        }
       
                    return codepromos;
    }

    @Override
    public boolean verifiercp(String code) {
         try {
        String req = "SELECT COUNT(*) AS count FROM CodePromo WHERE code = '" + code + "'";
        try (Statement stm = cnx.createStatement()) {
            ResultSet rs = stm.executeQuery(req);
            if (rs.next()) {
                int count = rs.getInt("count");
                return count > 0;
            }
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    }
    return false;
        }
    
    
     public boolean CodeExists(String code) {
    String query = "SELECT * FROM codepromo WHERE code = ?";

    try (PreparedStatement pstmt = cnx.prepareStatement(query)) {
        pstmt.setString(1, code);
        ResultSet rs = pstmt.executeQuery();

        return rs.next(); // Returns true if a record is found (cin exists), otherwise false
    } catch (SQLException ex) {
        ex.printStackTrace();
        return false; // An error occurred, return false to be safe
    }
}
    
    
}
