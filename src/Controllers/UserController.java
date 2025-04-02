package Controllers;

import Models.Employe;
import Services.UserService;

public class UserController {

    UserService userService = new UserService();

    public void ajouterUser(Employe employe) {
        userService.ajouterUser(employe);
    }

    public void modifierUser(Employe employe) {
        userService.modifierUser(employe);
    }

    public void supprimerUser(Employe employe) {
        userService.supprimerUser(employe);
    }
}
