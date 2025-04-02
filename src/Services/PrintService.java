package Services;

import Controllers.ConnexionBD;
import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;
import Print.TemplateImpression;

import javax.swing.*;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrintService {
    TemplateImpression templateImpression = new TemplateImpression();
    ConnexionBD connexionBD = new ConnexionBD();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void ImprimerRecu(Livraison livraison, Expediteur expediteur, Destinataire destinataire, Colis colis) throws IOException {

        connexionBD.Connexion();
        String query = "SELECT * FROM Livraison WHERE nomExp = ? AND prenomExp = ? AND nomDes = ? AND dateExp = CURDATE()";

        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setString(1, expediteur.getNom());
            pst.setString(2, expediteur.getPrenom());
            pst.setString(3, destinataire.getNom());
            rs = pst.executeQuery();

            while (rs.next()){
                livraison.setId_livraison(rs.getInt("id"));
                livraison.setPrix(rs.getDouble("prixLivraison"));
                colis.setPoids(rs.getDouble("poidsColis"));
                livraison.setDateEnvoi(rs.getDate("dateExp"));
                colis.setType(rs.getString("typeColis"));
                expediteur.setNom(rs.getString("nomExp"));
                expediteur.setPrenom(rs.getString("prenomExp"));
                expediteur.setTelephone(rs.getString("telephoneExp"));
                expediteur.setVille(rs.getString("villeExp"));
                destinataire.setNom(rs.getString("nomDes"));
                destinataire.setPrenom(rs.getString("prenomDes"));
                destinataire.setTelephone(rs.getString("telephoneDes"));
                destinataire.setVille(rs.getString("villeDes"));
            }
            rs.close();
            pst.close();
            templateImpression.RecuColisTemplate(livraison,expediteur,destinataire,colis);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la requête SQL : " + e.getMessage());
            connexionBD.Deconnexion();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                connexionBD.Deconnexion();
            } catch (SQLException e) {
                System.out.println("Erreur lors de la fermeture des ressources : " + e.getMessage());
            }
        }
    }

    public void ImprimerListeLivraisons(String periode) throws IOException {
        connexionBD.Connexion();
        String query = "SELECT * FROM Livraison";
        switch (periode.toLowerCase()) {
            case "jour":
                query += " WHERE dateExp = CURDATE()";
                break;
            case "semaine":
                query += " WHERE YEARWEEK(dateExp, 1) = YEARWEEK(CURDATE(), 1)";
                break;
            case "mois":
                query += " WHERE MONTH(dateExp) = MONTH(CURDATE()) AND YEAR(dateExp) = YEAR(CURDATE())";
                break;
            case "annee":
                query += " WHERE YEAR(dateExp) = YEAR(CURDATE())";
                break;
            // Par défaut, pas de filtre (toutes les données)
        }

        List<Livraison> livraisons = new ArrayList<>();
        List<Expediteur> expediteurs = new ArrayList<>();
        List<Destinataire> destinataires = new ArrayList<>();
        List<Colis> coliss = new ArrayList<>();

        try {
            pst = connexionBD.conn.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Livraison livraison = new Livraison();
                Expediteur expediteur = new Expediteur();
                Destinataire destinataire = new Destinataire();
                Colis colis = new Colis();
                livraison.setId_livraison(rs.getInt("id"));
                expediteur.setNom(rs.getString("nomExp"));
                expediteur.setPrenom(rs.getString("prenomExp"));
                expediteur.setTelephone(rs.getString("telephoneExp"));
                expediteur.setVille(rs.getString("villeExp"));
                destinataire.setNom(rs.getString("nomDes"));
                destinataire.setPrenom(rs.getString("prenomDes"));
                destinataire.setTelephone(rs.getString("telephoneDes"));
                destinataire.setVille(rs.getString("villeDes"));
                colis.setPoids(rs.getDouble("poidsColis"));
                colis.setType(rs.getString("typeColis"));
                livraison.setDateEnvoi(rs.getDate("dateExp"));
                livraison.setPrix(rs.getDouble("prixLivraison"));
                livraison.setDateReception(rs.getDate("dateRec"));
                // Ajoutez les autres champs de la table Livraison si nécessaire
                livraisons.add(livraison);
                coliss.add(colis);
                expediteurs.add(expediteur);
                destinataires.add(destinataire);
            }
            templateImpression.ListeLivraisonTemplate(livraisons,expediteurs,destinataires,coliss);

            JOptionPane.showMessageDialog(null, "Liste des livraisons imprimee avec succée !", "Impression de la liste des livraisons effectuée", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException | IOException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'impression de la liste des livraisons!","Echec",JOptionPane.ERROR_MESSAGE);
        }

    }
}
