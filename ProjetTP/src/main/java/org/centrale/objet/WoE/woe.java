package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class woe {

    /**
     * Fonction principale du jeu
     *
     * @param args
     */
    public static void main(String[] args) {
        int taille;
        try {
            taille = Integer.parseInt(args[0]);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            taille = 20;
        }
        World WoE;
        WoE = new World(taille);
        WoE.creeMondeAlea();
        Fenetre.Initialize(WoE.getTaille());
        Fenetre.addMessage("Bienvenue dans World Of ECN !");
        boolean vivant = true;
        while (vivant) {
            vivant = WoE.tourDeJeu();
            WoE.afficheWorld();
        }
        Fenetre.addMessage("\n\n\nVous êtes mort!\n");

    }
}
