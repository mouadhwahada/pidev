/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionreservation.GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import gestion_reservation.entities.Facture;
import gestion_reservation.entities.Reservation;
import gestion_reservation.services.ServiceFacture;
import gestion_reservation.services.ServiceReservation;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import gestionreservation.GUI.AjouterReservationFXMLController;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.*;
import javax.mail.internet.*;

/**
 * FXML Controller class
 *
 * @author pc
 */
public class FactureajoutController implements Initializable {

    @FXML
    private Button conffacture;
    @FXML
    private TextField numfact;
    @FXML
    private TextField montantfact;
    @FXML
    private TextField reffacture;
    @FXML
    private DatePicker datepaiementfact;
    @FXML
    private Button acceuilres;
  private int idReservation;
    private AjouterReservationFXMLController ajouterReservationController;
    @FXML
    private Button genererPDFButton;
    @FXML
    private Button envoyeremailfacture;
   
    @FXML
    private Button listfactaffiche;

    // Méthode setter pour le contrôleur AjouterReservationFXMLController
    public void setAjouterReservationController(AjouterReservationFXMLController controller) {
        this.ajouterReservationController = controller;
    }
    
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reffacture.setText(String.valueOf(idReservation));
        reffacture.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.isEmpty()) {
                try {
                    int numres = Integer.parseInt(newValue);
                    double montant = calculerMontantParReference(numres);
                    montantfact.setText(String.valueOf(montant));
                } catch (NumberFormatException e) {
                    montantfact.setText("numéro de facture non valide");
                }
            }
        });
    }

   @FXML
private void conffacture(ActionEvent event) {
    ServiceFacture sfacture=new ServiceFacture();
    String numFactureText = numfact.getText().trim();
    LocalDate datePaiement = datepaiementfact.getValue();
    String referenceText = reffacture.getText().trim();

    try {
        if (numFactureText.isEmpty() || datePaiement == null || referenceText.isEmpty()) {
            showAlert("Veuillez remplir tous les champs.", "Champ(s) vide(s)", AlertType.ERROR);
        } else if (datePaiement.isBefore(LocalDate.now())) {
            showAlert("La date de paiement ne peut pas être antérieure à aujourd'hui.", "Date incorrecte", AlertType.ERROR);
        } else {
            int referenceValue = Integer.parseInt(referenceText);

            if (referenceValue != 0) {
                double montant = calculerMontantParReference(referenceValue);

                montantfact.setText(String.valueOf(montant));

                // Spécifiez le nom du fichier de sortie
                String fileName = "facture.pdf";

                // Créez une instance de Facture avec les détails
                Facture facture = new Facture();
                int numfact1 = Integer.parseInt(numFactureText);
                facture.setNumfacture(numfact1);
                facture.setMontant(montant);
                facture.setDatePaiement(datePaiement.toString());
               // Créez une instance de Reservation et associez-la à la Facture
                Reservation reservation = new Reservation();
                reservation.setIdReservation(referenceValue);
                facture.setReservation(reservation);

                // Ajoutez la facture à la base de données
                sfacture.ajouterFacture(facture);
             

                // Affichage de la page d'affichage
                try {
                    Parent parent2 = FXMLLoader.load(getClass().getResource("factureaffichage.fxml"));
                    Scene scene = new Scene(parent2);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Liste des factures");
                    stage.show();
                   
                } catch (IOException ex) {
                    Logger.getLogger(AcceuilresController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    } catch (NumberFormatException e) {
        showAlert("Référence non valide", "Erreur", AlertType.ERROR);
    }
}

    @FXML
    private void accueilres(ActionEvent event) {
         try{
            Parent parent2=FXMLLoader .load(getClass().getResource("acceuilres.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("Acceuil");
            stage.show();
             Scene currentScene = ((Node) event.getSource()).getScene();
            Stage currentStage = (Stage) currentScene.getWindow();
            currentStage.close();
        }catch (IOException ex){
            Logger.getLogger(AcceuilresController.class.getName()).log(Level.SEVERE, null, ex);
        };

    }
    
    

 private void showAlert(String content, String title, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

 public double calculerMontantParReference(int numres) {
    ServiceReservation serviceReservation = new ServiceReservation();
    List<Reservation> reservations = serviceReservation.afficherReservation();

    // Initialisez le montant en dehors de la boucle
    double montant =0.0;

    // Parcourir la liste des réservations pour accumuler les montants correspondants à la référence
    for (Reservation reservation : reservations) {
        if (reservation.getIdReservation() == numres) {
            String typeHebergement = reservation.getTypeHebergement();
            String typeActivite = reservation.getTypeActivite();
            int nombrePersonnes = reservation.getNombrePersonnes();
            Date dateDebut = reservation.getDateDebut();
            Date dateFin = reservation.getDateFin();

            // Calculez le montant en fonction des données de la réservation
            double tarifActivite = 50.0; // Tarif fixe de l'activité
            double tarifHebergement = 0.0; // Initialisez le tarif d'hébergement

            if (typeHebergement != null) {
                if (typeHebergement.equals("Hotels")) {
                    tarifHebergement = 300.0;
                } else if (typeHebergement.equals("Motels")) {
                    tarifHebergement = 150.0;
                } else if (typeHebergement.equals("Auberges de jeunesse")) {
                    tarifHebergement = 170.0;
                } else if (typeHebergement.equals("Chambres d'hotes")) {
                    tarifHebergement = 120.0;
                }

                LocalDate localDateDebut = dateDebut.toLocalDate();
                LocalDate localDateFin = dateFin.toLocalDate();

                long nombreJours = ChronoUnit.DAYS.between(localDateDebut, localDateFin);

                // Accumulez le montant au lieu de le réinitialiser
                montant += (tarifHebergement  * nombrePersonnes * nombreJours+ tarifActivite * nombrePersonnes);
            }
        }
    }

    return montant;
}
private void genererPDFFacture(String fileName, Facture facture) {
   try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));
            document.open();

            // Titre de la facture
            Font titreFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            titreFont.setColor(0, 0, 128); // Couleur bleue
            Paragraph titre = new Paragraph("Facture", titreFont);
            titre.setAlignment(Element.ALIGN_CENTER);
            document.add(titre);

            // Informations de réservation
            Reservation reservation = facture.getReservation();

            if (reservation != null) { // Vérifiez si la réservation est nulle
                PdfPTable table = new PdfPTable(2); // 2 colonnes
                table.setWidthPercentage(100);

                // Référence de réservation
                table.addCell("Numéro de réservation:");
                table.addCell(String.valueOf(reservation.getIdReservation()));

                // Type d'hébergement
                table.addCell("Type d'hébergement:");
                table.addCell(reservation.getTypeHebergement().toString());

                // Type d'activité
                table.addCell("Type d'activité:");
                table.addCell(reservation.getTypeActivite().toString());

                table.completeRow(); // Terminez la ligne

                // Autres détails de la facture
                table.addCell("Numéro de facture:");
                table.addCell(String.valueOf(facture.getNumfacture()));

                table.addCell("Montant:");
                table.addCell(String.valueOf(facture.getMontant()));

                table.addCell("Date de paiement:");
                table.addCell(facture.getDatePaiement());

                document.add(table);
            } else {
                document.add(new Paragraph("Aucune réservation associée à cette facture."));
            }

            document.close();

            showAlert("Facture générée avec succès.", "Succès", AlertType.INFORMATION);
        } catch (Exception e) {
            showAlert("Erreur lors de la génération de la facture.", "Erreur", AlertType.ERROR);
            e.printStackTrace();
        }
    
}


    // ... (votre code existant)


        @FXML
       private void genererPDFButton(ActionEvent event) {
        Facture facture = new Facture();
        String numFactureText = numfact.getText().trim();
        LocalDate datePaiement = datepaiementfact.getValue();
        String referenceText = reffacture.getText().trim();

        try {
            if (numFactureText.isEmpty() || datePaiement == null || referenceText.isEmpty()) {
                showAlert("Veuillez remplir tous les champs.", "Champ(s) vide(s)", AlertType.ERROR);
            } else if (datePaiement.isBefore(LocalDate.now())) {
                showAlert("La date de paiement ne peut pas être antérieure à aujourd'hui.", "Date incorrecte", AlertType.ERROR);
            } else {
                int referenceValue = Integer.parseInt(referenceText);

                if (referenceValue != 0) {
                    double montant = calculerMontantParReference(referenceValue);

                    montantfact.setText(String.valueOf(montant));

                    // Préparez les détails de la facture
                    int numfact1 = Integer.parseInt(numFactureText);
                    facture.setNumfacture(numfact1);
                    facture.setMontant(montant);
                    facture.setDatePaiement(datePaiement.toString());

                    Reservation reservation = getReservationByReference(referenceValue);

                    if (reservation != null) {
                        facture.setReservation(reservation);
                    
                        // Générez le PDF
                        String fileName = "facture_" + numFactureText + ".pdf"; // Nom du fichier basé sur le numéro de facture
                        genererPDFFacture(fileName, facture);

                        // Affichage de la page d'affichage
                       

                        // Ouvrez le PDF avec le lecteur de PDF par défaut
                        try {
                            File file = new File(fileName);
                            if (file.exists()) {
                                Desktop.getDesktop().open(file);
                            } else {
                                showAlert("Fichier PDF introuvable.", "Erreur", AlertType.ERROR);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            showAlert("Erreur lors de l'ouverture du fichier PDF.", "Erreur", AlertType.ERROR);
                        }
                    } else {
                        showAlert("Référence de réservation non valide.", "Erreur", AlertType.ERROR);
                    }
                }
            }
        } catch (NumberFormatException e) {
            showAlert("Référence non valide", "Erreur", AlertType.ERROR);
        }
    }

    private Reservation getReservationByReference(int numres) {
        // Implémentez la logique pour obtenir la réservation par référence
        ServiceReservation serviceReservation = new ServiceReservation();
        List<Reservation> reservations = serviceReservation.afficherReservation();

        for (Reservation reservation : reservations) {
            if (reservation.getIdReservation() == numres) {
                return reservation;
            }
        }

        return null; // Retournez null si la référence n'a pas été trouvée
    }

    public void setReservationID(int idReservation) {
        reffacture.setText(String.valueOf(idReservation));
    }

    public TextField getReffacture() {
        return reffacture;
    }

    public void setReffacture(TextField reffacture) {
        this.reffacture = reffacture;
    }



   @FXML
private void envoyeremailfacture(ActionEvent event) {
    // Saisie de l'adresse e-mail du destinataire
    String emailDestinataire = JOptionPane.showInputDialog("Veuillez saisir l'adresse e-mail du destinataire :");
    if (emailDestinataire == null || emailDestinataire.isEmpty()) {
        showAlert("Adresse e-mail du destinataire non valide.", "Erreur", AlertType.ERROR);
        return;
    }

    // Génération du PDF et obtention du nom du fichier généré
    Facture facture = new Facture();
    String numFactureText = numfact.getText().trim();
    LocalDate datePaiement = datepaiementfact.getValue();
    String referenceText = reffacture.getText().trim();
    String fileName = "facture.pdf"; // Nom du fichier généré

    try {
        if (numFactureText.isEmpty() || datePaiement == null || referenceText.isEmpty()) {
            showAlert("Veuillez remplir tous les champs.", "Champ(s) vide(s)", AlertType.ERROR);
        } else if (datePaiement.isBefore(LocalDate.now())) {
            showAlert("La date de paiement ne peut pas être antérieure à aujourd'hui.", "Date incorrecte", AlertType.ERROR);
        } else {
            int referenceValue = Integer.parseInt(referenceText);

            if (referenceValue != 0) {
                double montant = calculerMontantParReference(referenceValue);

                montantfact.setText(String.valueOf(montant));

                // Préparez les détails de la facture
                int numfact1 = Integer.parseInt(numFactureText);
                facture.setNumfacture(numfact1);
                facture.setMontant(montant);
                facture.setDatePaiement(datePaiement.toString());

                Reservation reservation = getReservationByReference(referenceValue);

                if (reservation != null) {
                    facture.setReservation(reservation);

                    // Générez le PDF
                    fileName = "facture_" + numFactureText + ".pdf"; // Nom du fichier basé sur le numéro de facture
                    genererPDFFacture(fileName, facture);
                } else {
                    showAlert("numero de réservation non valide.", "Erreur", AlertType.ERROR);
                    return;
                }
            }
        }
    } catch (NumberFormatException e) {
        showAlert("numero  non valide", "Erreur", AlertType.ERROR);
        return;
    }

    // Envoi de l'e-mail avec le fichier PDF en pièce jointe
    try {
        String sujet = "Facture";
        String contenu = "Veuillez trouver ci-joint votre facture.";

        Properties props = new Properties();
         props.put("mail.smtp.host", "smtp.gmail.com"); // Use Gmail's SMTP server
    props.put("mail.smtp.port", "587"); // Port for TLS
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.transport.protocol", "smtp");
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("nawras.saied@esprit.tn", "223JFT1007");
            }
        });

        Message email = new MimeMessage(session);
        email.setFrom(new InternetAddress("nawrassaied5@gmail.com"));
        email.setRecipient(Message.RecipientType.TO, new InternetAddress(emailDestinataire));
        email.setSubject(sujet);
        email.setText(contenu);

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(contenu);

        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataSource source = new FileDataSource(fileName);
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName(new File(fileName).getName());

        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        multipart.addBodyPart(attachmentPart);

        email.setContent(multipart);

        Transport.send(email);

        showAlert("Facture envoyée par e-mail avec succès.", "Succès", AlertType.INFORMATION);
    } catch (MessagingException ex) {
        ex.printStackTrace();
        showAlert("Erreur lors de l'envoi de la facture par e-mail : " + ex.getMessage(), "Erreur", AlertType.ERROR);
    }
}



    @FXML
    private void listfactaffiche(ActionEvent event) {
        try{
            Parent parent2=FXMLLoader .load(getClass().getResource("factureaffichage.fxml"));
            Scene scene =new Scene(parent2);
            Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.setTitle("liste des factures");
            stage.show();
        }catch (IOException ex){
            ex.printStackTrace();
        };
    }

  
}
    