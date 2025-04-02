package Models;


import java.sql.Date;


public class Livraison {


    private int id_livraison;
    private double prix;
    private Date dateEnvoi;
    private Date dateReception;

    public Date getDateReception() {
        return dateReception;
    }

    public void setDateReception(Date dateReception) {
        this.dateReception = dateReception;
    }

    public void setDateEnvoi(Date dateEnvoi) {
        this.dateEnvoi = dateEnvoi;
    }

    public int getId_livraison() {
        return id_livraison;
    }

    public void setId_livraison(int id_livraison) {
        this.id_livraison = id_livraison;
    }

    public Date getDateEnvoi() {
        return dateEnvoi;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


}
