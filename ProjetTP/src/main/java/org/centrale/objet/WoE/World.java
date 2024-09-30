package org.centrale.objet.WoE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ulysse
 */
public class World {

    LinkedList<Creature> creatures;
    LinkedList<Objet> objets;
    Random seed;

    /**
     * Monde avec personnages par défaut
     */
    public World() {
        this.creatures = new LinkedList<Creature>();
        this.objets = new LinkedList<Objet>();
        this.seed = new Random();

    }

    /**
     * Création d'un monde aléatoire
     */
    public void creeMondeAlea() {
        int n;
        int i;
        int j;
        int x;
        int y;
        boolean pris;

        n = this.creatures.size();
        for (i = 0; i < n; i++) {
            x = 0;
            y = 0;
            pris = true;
            while (pris) {
                pris = false;
                x = this.seed.nextInt(15);
                y = this.seed.nextInt(15);
                for (j = 0; j < i; j++) {
                    if (this.creatures.get(j).getX() == x && this.creatures.get(j).getY() == y) {
                        pris = true;
                    }
                }
            }
            this.creatures.get(i).setPos(x, y);
            this.creatures.get(i).affiche();
        }

        n = this.objets.size();
        for (i = 0; i < n; i++) {
            x = 0;
            y = 0;
            pris = true;
            while (pris) {
                pris = false;
                x = this.seed.nextInt(15);
                y = this.seed.nextInt(15);
                for (j = 0; j < i; j++) {
                    if (this.objets.get(j).getX() == x && this.objets.get(j).getY() == y) {
                        pris = true;
                    }
                }
            }
            this.objets.get(i).setPos(x, y);
            // this.objets.get(i).affiche(); TODO
        }

    }

    /**
     * Gestion d'un tour de jeu : on affiche le nom ou le type de la créature
     * qui joue, la déplace puis l'affiche.
     */
    public void tourDeJeu() {
        cleanEntites(creatures);
        cleanEntites(objets);
        Iterator<Creature> tourIt = creatures.iterator();
        while (tourIt.hasNext()){
            Creature creature = tourIt.next();
            System.out.println("C'est au tour de "+creature+" de jouer.");
            creature.deplace();
            creature.affiche();
        }
        System.out.println("Fin du tour de jeu");
    }

    /**
     * Affichage du monde
     */
    public void afficheWorld() {

    }

    /**
     * Retire les objets utilisés (sans position)
     * @param Liste
     */
    public void cleanEntites(LinkedList Liste) {
        Iterator<Entite> listIt = Liste.iterator();

        while (listIt.hasNext()) {
            Entite p = listIt.next();
            if (p.getPos() == null) {
                listIt.remove();
            }
        }
    }
}
