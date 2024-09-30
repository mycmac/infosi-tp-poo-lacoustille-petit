package org.centrale.objet.WoE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ulysse
 */
public class World {

    LinkedList<Creature> creatures;
    LinkedList<Objet> objets;
    Random seed;
    ArrayList<ArrayList<Boolean>> grille;
    int taille;
    
    /**
     * Monde avec personnages par défaut
     */
    public World() {
        this.creatures = new LinkedList<Creature>();
        this.objets = new LinkedList<Objet>();
        this.seed = new Random();
        this.grille = new ArrayList<ArrayList<Boolean>>(taille);
    }

    /**
     * Création d'un monde aléatoire
     */
    public void creeMondeAlea() {
        Guerrier g = new Guerrier();
        Archer a = new Archer();
        Paysan p = new Paysan();
        Lapin l = new Lapin();
        Loup lp = new Loup();
        this.creatures.add(g);
        this.creatures.add(a);
        this.creatures.add(p);
        this.creatures.add(l);
        this.creatures.add(lp);
        
        PotionSoin pot = new PotionSoin();
        Epee e = new Epee();
        this.objets.add(pot);
        this.objets.add(e);
        
        int x;
        int y;
        boolean pris;
        
        Iterator<Creature> CreaIt1 = this.creatures.iterator();
        Iterator<Creature> CreaIt2;
        Creature c1;
        Creature c2;
        while(CreaIt1.hasNext()) {
            c1 = CreaIt1.next();
            x = 0;
            y = 0;
            pris = true;
            
            while (pris) {
                pris = false;
                x = this.seed.nextInt(15);
                y = this.seed.nextInt(15);
                CreaIt2 = this.creatures.iterator();
                c2 = CreaIt2.next();
                while (c2 != c1) {
                    if (c2.getX() == x && c2.getY() == y) {
                        pris = true;
                    }
                    c2 = CreaIt2.next();
                }
            }
            c1.setPos(x, y);
            c1.affiche();
        }
        

        Iterator<Objet> ObjIt1 = this.objets.iterator();
        Iterator<Objet> ObjIt2;
        Objet o1;
        Objet o2;
        while(ObjIt1.hasNext()) {
            o1 = ObjIt1.next();
            x = 0;
            y = 0;
            pris = true;
            
            while (pris) {
                pris = false;
                x = this.seed.nextInt(15);
                y = this.seed.nextInt(15);
                ObjIt2 = this.objets.iterator();
                o2 = ObjIt2.next();
                while (o2 != o1 && !pris) {
                    if (o2.getX() == x && o2.getY() == y) {
                        pris = true;
                    }
                    o2 = ObjIt2.next();
                }
                
                CreaIt2 = this.creatures.iterator();
                while (CreaIt2.hasNext() && !pris) {
                    c2 = CreaIt2.next();
                    if (c2.getX() == x && c2.getY() == y) {
                        pris = true;
                    }
                }
            }
            o1.setPos(x, y);
            // o1.affiche(); TODO
        }

    }

    /**
     * Gestion d'un tour de jeu : on affiche le nom ou le type de la créature
     * qui joue, la déplace puis l'affiche.
     */
    public void tourDeJeu() {
        cleanEntites(creatures);
        cleanEntites(objets);
        for (Creature creature : creatures) {
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
