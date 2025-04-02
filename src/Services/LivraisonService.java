package Services;

import Controllers.ConnexionBD;
import Controllers.PrintController;
import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;

import javax.swing.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LivraisonService {
    ConnexionBD connexionBD = new ConnexionBD();
    PrintController printController = new PrintController();
    Livraison livraison = new Livraison();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void NouvelleLivraison(Livraison livraison, Expediteur expediteur, Destinataire destinataire, Colis colis) {
        connexionBD.Connexion();
        livraison.setDateEnvoi(new Date(System.currentTimeMillis()));
        String query ="insert into Livraison(nomExp, prenomExp, telephoneExp, numeroPieceExp, typePieceExp, villeExp, nomDes, prenomDes, telephoneDes, villeDes, typeColis, poidsColis, prixLivraison, dateExp) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setString(1, expediteur.getNom());
            pst.setString(2, expediteur.getPrenom());
            pst.setString(3, expediteur.getTelephone());
            pst.setString(4, expediteur.getNumeroPiece());
            pst.setString(5, expediteur.getTypePiece());
            pst.setString(6, expediteur.getVille());
            pst.setString(7, destinataire.getNom());
            pst.setString(8, destinataire.getPrenom());
            pst.setString(9, destinataire.getTelephone());
            pst.setString(10, destinataire.getVille());
            //pst.setDate(11, livraison.getDateEnvoi());
            pst.setString(11, colis.getType());
            pst.setDouble(12, colis.getPoids());
            pst.setDouble(13, livraison.getPrix());
            pst.setDate(14, livraison.getDateEnvoi());


            pst.execute();

            connexionBD.Deconnexion();
            printController.ImprimerRecu(livraison, expediteur, destinataire, colis);
            JOptionPane.showMessageDialog(null, "Livraison Enregistrée! " +
                    "Le recu est imprime a la racine du projet","Information",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            connexionBD.Deconnexion();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la livraison!","Echec",JOptionPane.ERROR_MESSAGE);
        }

    }

    public Livraison TrouverLivraison(int id) {
        connexionBD.Connexion();
        String query = "select * from Livraison where id_livraison = ?";

        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setInt(1, id);
            rs = pst.executeQuery();
            while (rs.next()) {

                livraison.setDateReception(rs.getDate("dateReception"));
                livraison.setPrix(rs.getDouble("prix"));
            }
            return livraison;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la recherche!","Echec",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    public Livraison ToutesLesLivraisons() {
        connexionBD.Connexion();
        String query = "select * from Livraison";

        try {
            pst = connexionBD.conn.prepareStatement(query);
            rs = pst.executeQuery();
            while (rs.next()) {;
                livraison.setDateReception(rs.getDate("dateReception"));
                livraison.setPrix(rs.getDouble("prix"));
            }
            return livraison;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement!","Echec",JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}
