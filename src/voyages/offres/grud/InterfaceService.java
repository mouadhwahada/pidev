/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres.grud;

import java.util.List;

import voyages.offres.service;

/**
 *
 * @author ASUS
 */
public interface InterfaceService {
     public void ajouterService(service  s);
    public void modifier(service s);
    public void  ajouterService2(service s);
    public void supprimer(int  id_service);
    
    public List<service> fetchservice();
}
