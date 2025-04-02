package Services;

import Controllers.ConnexionBD;
import Models.Employe;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    ConnexionBD connexionBD = new ConnexionBD();
    PreparedStatement pst = null;
    ResultSet rs = null;

    public void ajouterUser(Employe employe) {
        connexionBD.Connexion();
        String query = "INSERT INTO User (nom, password) VALUES (?, ?)";
        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setString(1, employe.getNom());
            pst.setString(2, employe.getMotDePasse());
            pst.executeUpdate();
            connexionBD.Deconnexion();

            JOptionPane.showMessageDialog(null, "Utilisateur Enregistré!","Information",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'enregistrement!","Echec",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void modifierUser(Employe employe) {
        connexionBD.Connexion();
        String query = "UPDATE User SET nom = ?, password = ? WHERE id = ?";
        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setString(1, employe.getNom());
            pst.setString(2, employe.getMotDePasse());
            pst.setInt(3, employe.getId_employer());
            pst.executeUpdate();
            connexionBD.Deconnexion();

            JOptionPane.showMessageDialog(null, "Utilisateur Modifiée!","Information",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la modification!","Echec",JOptionPane.ERROR_MESSAGE);
        }
    }

    public void supprimerUser(Employe employe) {
        connexionBD.Connexion();
        String query = "DELETE FROM User WHERE id = ?";
        try {
            pst = connexionBD.conn.prepareStatement(query);
            pst.setInt(1, employe.getId_employer());
            pst.executeUpdate();
            connexionBD.Deconnexion();

            JOptionPane.showMessageDialog(null, "Utilisateur Supprimée!","Information",JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la suppression!","Echec",JOptionPane.ERROR_MESSAGE);
        }
    }
}
