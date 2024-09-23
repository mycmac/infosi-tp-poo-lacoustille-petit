package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author Ulysse
 */
public class World {

    Archer robin;
    Paysan peon;
    Lapin bugs;
    Lapin bunny;
    Archer guillaumeT;
    Guerrier grosBill;
    Loup wolfie;

    /**
     * Monde avec personnages par défaut
     */
    public World() {
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
        bunny = new Lapin();
        grosBill = new Guerrier();
        wolfie = new Loup();
    }

    /**
     * Création d'un monde aléatoire
     */
    public void creeMondeAlea() {
        Random r = new Random();
        Creature[] gens = new Creature[6];
        gens[0] = robin;
        gens[1] = peon;
        gens[2] = bugs;
        gens[3] = bunny;
        gens[4] = grosBill;
        gens[5] = wolfie;
        for (int i = 0; i < 6; i++) {
            int x = 0;
            int y = 0;
            boolean pris = true;
            while (pris) {
                pris = false;
                x = r.nextInt(15);
                y = r.nextInt(15);
                for (int j = 0; j < i; j++) {
                    if (gens[j].getPos().getX() == x && gens[j].getPos().getY() == y) {
                        pris = true;
                    }
                }
            }
            gens[i].setPos(x, y);
            gens[i].affiche();

        }

    }

    /**
     * Gestion d'un tour de jeu
     */
    public void tourDeJeu() {

    }

    /**
     * Affichage du monde
     */
    public void afficheWorld() {

    }
}
