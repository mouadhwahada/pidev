/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.services;

import java.util.List;
import tn.edu.esprit.entities.CodePromo;

/**
 *
 * @author Maryem
 * 
 */
public interface ICPService<CP> {
    public void ajoutercp(CP cp);
    public void modifiercp(CP cp);
    public void supprimercp(CP cp);
    public CodePromo recherchercp(int id);
    public List<CP> getAlluti(CP cp);
    boolean verifiercp(String code);
    
}
