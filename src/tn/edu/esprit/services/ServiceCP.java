/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.CodePromo;

/**
 *
 * @author Maryem
 */
public class ServiceCP implements ICPService<CodePromo>{
Connection cnx ;
    @Override
    public void ajoutercp(CodePromo cp) {
        try {
            String req = "INSERT INTO CodePromo(code, description,datedexpiration, used) VALUES ('"
                    + cp.getCode() + "','" + cp.getDescription()+ "','" + cp.getDatedexpiration() + "','" + cp.isUsed() +"')";
            Statement stm = cnx.createStatement();
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void modifiercp(CodePromo cp) {
        String req = "UPDATE Utilisateur SET code = '" + cp.getCode() + "',Description = '" + cp.getDescription()+ "',Date d'expiration = '"
                + cp.getDatedexpiration()+ "', le code est valable ou non = '" + cp.isUsed() + "' WHERE id_codepromo= " + cp.getId_codepromo();
        try (Statement stm = cnx.createStatement()) {
            stm.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimercp(int id) {
          String req = "DELETE FROM CodePromo WHERE id_codepromo = " + id;
        try (Statement stm = cnx.createStatement()) {
            stm.executeUpdate(req);
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
                  codepromo.setUsed(rs.getString("Used"));
                  codepromo.setDatedexpiration (rs.getDate("Date d'expiration"));
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
         String req = "SELECT * FROM `CodePromo`";
        ArrayList<CodePromo> codepromos = new ArrayList<>();
        try (Statement stm = this.cnx.createStatement()) {
            ResultSet rs = stm.executeQuery(req);
            while (rs.next()) {
               CodePromo codepromo= new CodePromo();
             codepromo.setId_codepromo(rs.getInt("Id_codepromo"));
                  codepromo.setCode(rs.getString("code"));
                  codepromo.setDescription(rs.getString("description"));
                  codepromo.setUsed(rs.getString("Used"));
                  codepromo.setDatedexpiration (rs.getDate("Date d'expiration"));

                   
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
}
