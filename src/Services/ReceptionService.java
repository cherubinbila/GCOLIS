package Services;

import Controllers.ConnexionBD;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;
import Models.Recepteur;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

public class ReceptionService {

    ConnexionBD connexionBD = new ConnexionBD();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void Reception(Livraison livraison, Destinataire destinataire, Recepteur recepteur) {

        connexionBD.Connexion();
        livraison.setDateReception(new Date(System.currentTimeMillis()));
        String query = "update Livraison set dateRec = ?, typePieceDes = ?, numeroPieceDes = ?, nomRec = ?, prenomRec = ?, telephoneRec = ?, typePieceRec = ?, numeroPieceRec = ?, isRec = 1 WHERE id = ?";

        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setDate(1, livraison.getDateReception());
            pst.setString(2, destinataire.getTypePiece());
            pst.setString(3, destinataire.getNumeroPiece());
            pst.setString(4, recepteur.getNom());
            pst.setString(5, recepteur.getPrenom());
            pst.setString(6, recepteur.getTelephone());
            pst.setString(7, recepteur.getTypePiece());
            pst.setString(8, recepteur.getNumeroPiece());
            pst.setInt(9, livraison.getId_livraison());

            pst.executeUpdate();

            connexionBD.Deconnexion();
            JOptionPane.showMessageDialog(null, "Reception faite!","Information",JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            connexionBD.Deconnexion();
            JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement de la reception!","Echec",JOptionPane.ERROR_MESSAGE);
        }
    }
}
