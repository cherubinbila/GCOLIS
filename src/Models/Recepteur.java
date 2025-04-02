package Models;


public class Recepteur {

    private int id_recepteur;

    public int getId_recepteur() {
        return id_recepteur;
    }

    public void setId_recepteur(int id_recepteur) {
        this.id_recepteur = id_recepteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNumeroPiece() {
        return numeroPiece;
    }

    public void setNumeroPiece(String numeroPiece) {
        this.numeroPiece = numeroPiece;
    }

    public String getTypePiece() {
        return typePiece;
    }

    public void setTypePiece(String typePiece) {
        this.typePiece = typePiece;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    private String nom;
    private String prenom;
    private String telephone;
    private String numeroPiece;
    private String typePiece;
    private String ville;
}
