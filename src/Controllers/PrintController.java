package Controllers;

import Models.Colis;
import Models.Destinataire;
import Models.Expediteur;
import Models.Livraison;
import Services.PrintService;

import java.io.IOException;

public class PrintController {
    PrintService printService = new PrintService();

    public void ImprimerRecu(Livraison livraison, Expediteur expediteur, Destinataire destinataire, Colis colis) throws IOException {
        printService.ImprimerRecu(livraison,expediteur,destinataire,colis);
    }

    public void ImprimerListeLivraisons(String query) throws IOException {
        printService.ImprimerListeLivraisons(query);
    }
}
