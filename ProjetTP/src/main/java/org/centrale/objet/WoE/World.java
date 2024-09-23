package org.centrale.objet.WoE;

import java.util.Iterator;
import java.util.LinkedList;
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
    LinkedList<Objet> objets;

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
        PotionSoin potion = new PotionSoin(12);
        PotionSoin potion2 = new PotionSoin(8);
        PotionSoin potion3 = new PotionSoin(11);
        Epee epee = new Epee(7,7,7,7);
        objets = new LinkedList<>();
        objets.add(potion);
        objets.add(potion2);
        objets.add(potion3);
        objets.add(epee);
    }

    /**
     * Création d'un monde aléatoire
     */
    public void creeMondeAlea() {
        Random r = new Random();
        Creature[] gens = new Creature[6];
        gens[0] = this.robin;
        gens[1] = this.peon;
        gens[2] = this.bugs;
        gens[3] = this.bunny;
        gens[4] = this.grosBill;
        gens[5] = this.wolfie;
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
        cleanObjets();
    }

    /**
     * Affichage du monde
     */
    public void afficheWorld() {

    }

    /**
     * Retire les objets utilisés
     */
    public void cleanObjets() {
        Iterator<Objet> listIt = objets.iterator();

        while (listIt.hasNext()) {
            Objet p = listIt.next();
            if (p.getPos() == null) {
                listIt.remove();
            }
        }
    }
}
