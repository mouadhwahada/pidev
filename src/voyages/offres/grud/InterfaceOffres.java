/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voyages.offres.grud;

import java.util.List;
import voyages.offres.offres;


/**
 *
 * @author ASUS
 */
public interface InterfaceOffres {
    public void ajouter(offres t);
    public void modifierOffres(offres t);
    public void  ajouteroffres2(offres t);
    public void  supprimer(int id_offres);
     public List<offres> fetchoffres();
  
}
