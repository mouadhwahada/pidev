/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.edu.esprit.entities.explorex;

import tn.edu.esprit.entities.User;
import tn.edu.esprit.services.ServiceUser;
import tn.edu.esprit.entities.CodePromo;
import tn.edu.esprit.services.ServiceCP;
import java.sql.Date ;
import java.text.SimpleDateFormat;

 
/**
 *
 * @author Maryem
 */
public class ExploreX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         // Créer une instance de ServiceUtilisateur
      ServiceUser serviceUser = new ServiceUser();

        // Créer un utilisateur à ajouter
    User user1 = new User();
        user1.setCin("12345678");
        user1.setNom("derbali");
        user1.setPrenom("maryem");
        user1.setEmail("maryem.derbali@esprit.tn");
        user1.setPseudo("maryem1708");
        user1.setMdp("4552258963");
        serviceUser.ajouter(user1);
        System.out.println("L'utilisateur a été ajouté avec succès");
        
        
            User user2 = new User();

        user2.setCin("12345678");
        user2.setNom("abd");
        user2.setPrenom("yassmine");
        user2.setEmail("yassmi,e.abd@esprit.tn");
        user2.setPseudo("yassmine");
        user2.setMdp("4552258963");
        serviceUser.ajouter(user2);
        System.out.println("L'utilisateur a été ajouté avec succès");

    }
        
    
        
        

        
       /*

    // Supposons que vous ayez déjà l'identifiant de l'utilisateur que vous souhaitez modifier
     // Remplacez par l'ID réel de l'utilisateur

    // Obtenez l'utilisateur que vous souhaitez modifier
    User userAModifier = serviceUser.getOne(3);

    if (userAModifier != null) {
        // Modifiez les attributs de l'utilisateur
        userAModifier.setCin("Nouveau cin");
        userAModifier.setNom("Nouveau nom");
        userAModifier.setPrenom("Nouveau prénom");
        userAModifier.setEmail("nouveau.email@example.com");
        userAModifier.setPseudo("pseudo");
        userAModifier.setMdp("mdp");

        
        // Appelez la méthode de mise à jour de l'utilisateur
        serviceUser.modifier(userAModifier);
    } else {
        System.out.println("L'utilisateur avec l'ID " + 5 + " n'a pas été trouvé.");
    }
        
    
        User userASupprimer = serviceUser.getOne(2);
        
    if (userASupprimer != null) {

                serviceUser.supprimer(userASupprimer);
                System.out.println("L'utilisateur est supprimé avec succès.");

    }
    else
    {           System.out.println("L'utilisateur à supprimer n'a pas été trouvé.");

    }
      

    /* ServiceCP ServiceCP = new ServiceCP();

        // Créer un utilisateur à ajouter
      CodePromo codePromo = new CodePromo();
        codePromo.setCode("55525542L");
        codePromo.setDescription("abc");
        
       
// Define the date string
String dateString = "04/10/2023";

// Create a SimpleDateFormat for the input date format
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

try {
    // Parse the date string into a java.util.Date
    java.util.Date parsedDate = sdf.parse(dateString);

    // Convert the java.util.Date to java.sql.Date
    Date sqlDate = new Date(parsedDate.getTime());

    // Set the java.sql.Date in your codePromo object
    codePromo.setDatedexpiration(sqlDate);
} catch (Exception ex) {
    System.out.println("Error: " + ex.getMessage());
}

       
        ServiceCP.ajoutercp(codePromo);


    }
     
    
    }*/

}