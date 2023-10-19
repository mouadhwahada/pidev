/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.edu.esprit.entities.User;
import tn.edu.esprit.tools.DataSource;
import java.sql.PreparedStatement;


/**
 *
 * @author Maryem
 */
public class ServiceUser implements IUserService<User> {

private Connection cnx = DataSource.getInstance().getConnection();


   @Override
    public void ajouter(User t) {
        String req = "INSERT INTO `user`(`role`, `cin`, `nom`, `prenom`, `email`, `pseudo`, `mdp`) VALUES (?, ?, ?, ?, ?, ?,?)";
    
    try ( PreparedStatement pstmt = cnx.prepareStatement(req) ) {
        pstmt.setString(1, t.getRole());
        pstmt.setString(2, t.getCin());
        pstmt.setString(3, t.getNom());
        pstmt.setString(4, t.getPrenom());
        pstmt.setString(5, t.getEmail());
        pstmt.setString(6, t.getPseudo());
        pstmt.setString(7, t.getMdp());
        pstmt.executeUpdate();
        } catch (SQLException ex) {
              Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
      
        }

    }
    @Override
    public void modifier(User u) {
          String sql = "UPDATE user SET `cin`=?, `nom`=?, `prenom`=?, `email`=?, `pseudo`=?, `mdp`=? WHERE id=?";
        try {
            try (PreparedStatement ps = cnx.prepareStatement(sql)) {
                ps.setString(1, u.getNom());
                ps.setString(2, u.getPrenom());
                ps.setString(3, u.getCin());
                ps.setString(4, u.getEmail());
                ps.setString(5, u.getPseudo());
                ps.setString(6, u.getMdp());
             

                int rowsUpdated;
                rowsUpdated = ps.executeUpdate();
                if (rowsUpdated > 0) {
                    System.out.println("La modification de l'utilisateur : " + u.getNom() + " a été effectuée avec succès ");
                }
            } 
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void supprimer(User u) {
       try {
            String req = "DELETE FROM `user` WHERE `id` = ?";
            try (PreparedStatement ps = cnx.prepareStatement(req)) {
                ps.setInt(1, u.getId());
                ps.executeUpdate();
                System.out.println("Utilisateur supprimé");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public User getOne(int id) {
    String req = "SELECT * FROM `user` WHERE id = ?";
    User user = null;
    
    try ( PreparedStatement pstmt = cnx.prepareStatement(req))
         {
        pstmt.setInt(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setRole(rs.getString("role"));
            user.setNom(rs.getString("nom"));
            user.setPrenom(rs.getString("prenom"));
            user.setCin(rs.getString("cin"));
            user.setEmail(rs.getString("email"));
            user.setPseudo(rs.getString("pseudo"));
            user.setMdp(rs.getString("mdp"));
           
        }
    } catch (SQLException ex) {
        Logger.getLogger(ServiceUser.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return user;
}


   @Override
    public List<User> getAll(User u) {
      String req = "SELECT * FROM `user`";
      ArrayList<User> users = new ArrayList();
    Statement stm;
    
try {
        stm = this.cnx.createStatement();
    
    
        ResultSet rs=  stm.executeQuery(req);
    while (rs.next()){
        User t = new User();
        t.setId(rs.getInt(1));
        t.setNom(rs.getString("nom"));
        t.setPrenom(rs.getString(3));
        
        users.add(t);
    }
        
        
    } catch (SQLException ex) {
    
        System.out.println(ex.getMessage());
    
    }
    return users;
    }

    public String getUserRole(String pseudo, String mdp) {
        String role = "user"; // Default role

        // Your database query to retrieve the user's role
        String query = "SELECT role FROM users WHERE pseudo = ? AND mdp = ?";
        
        try (PreparedStatement pstmt = cnx.prepareStatement(query)) {
            pstmt.setString(1, pseudo);
            pstmt.setString(2, mdp);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                role = rs.getString("role");
            }
        } catch (SQLException ex) {
        }

        return role;
    }
    
    
}


