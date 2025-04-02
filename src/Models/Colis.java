package Models;

public class Colis {


    private int id_colis;
    private String type;
    private double poids;
    private double prixAuKilo;

    public double getPrixAuKilo() {
        return prixAuKilo;
    }

    public void setPrixAuKilo(double prixAuKilo) {
        this.prixAuKilo = prixAuKilo;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public int getId_colis() {
        return id_colis;
    }

    public void setId_colis(int id_colis) {
        this.id_colis = id_colis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
