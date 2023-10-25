/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package offre;

import voyages.offres.offres;

/**
 *
 * @author ASUS
 */
public class offreAvecImage {
   
    private offres offre;
    private String imagePath; // Chemin d'accès à l'image

    public offreAvecImage(offres offre, String imagePath) {
        this.offre = offre;
        this.imagePath = imagePath;
    }

    public offres getOffre() {
        return offre;
    }

    public String getImagePath() {
        return imagePath;
    }
}

    

