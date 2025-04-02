package Controllers;

import Models.Destinataire;
import Models.Livraison;
import Models.Recepteur;
import Services.ReceptionService;



public class ReceptionController {

    ReceptionService receptionService = new ReceptionService();

    public void Reception(Livraison livraison, Destinataire destinataire, Recepteur recepteur) {
        receptionService.Reception(livraison, destinataire, recepteur);
    }
}
