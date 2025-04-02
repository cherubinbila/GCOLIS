package Controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ConnexionBD {

    private String driver = "com.mysql.jdbc.Driver";
    private String dblink = "jdbc:mysql://localhost:3306/mydatabase";
    private String username = "root";
    private String password = "root";
    public Connection conn;
    public ResultSet rs;

    //connexion a la BD
    public boolean Connexion() {
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(dblink, username, password);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur de connexion a la base de donner!" + e.getMessage(), "Echec d'authentification", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    //retourner le statut de la BD
    public boolean Status() {
        if (Connexion() == true) {
            System.out.println("Base de donnees connectee!");
            return true;
        } else {
            System.err.println("Base de donnees deconnectee!");
            return false;
        }
    }

    //deconnexion a la BD
    public boolean Deconnexion() {
        try {
            conn.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erreur lors de la deconnexion!" + ex.getMessage(), "Echec de la deconnexion", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
