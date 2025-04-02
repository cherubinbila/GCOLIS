package Controllers;

import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;
import Services.LivraisonService;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LivraisonController {

    LivraisonService livraisonService = new LivraisonService();

    public void Livraison(Livraison livraison, Expediteur expediteur , Destinataire destinataire, Colis colis) {

        livraisonService.NouvelleLivraison(livraison, expediteur, destinataire, colis);

    }



}
