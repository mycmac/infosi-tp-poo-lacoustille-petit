package org.centrale.objet.WoE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Ulysse
 */
public class World {
    
    int nbCreaturesBase = 1000;
    int nbObjetsBase = 1000;
    
    Random seed;
    int taille;
    LinkedList<Creature> creatures = new LinkedList<Creature>();
    LinkedList<Objet> objets = new LinkedList<Objet>();
    Creature[][] grille_creatures;
    Objet[][] grille_objets;

    /**
     * Monde avec personnages par défaut
     */
    public World(int t) {
        this.seed = new Random();
        this.taille = t;
        this.grille_creatures = new Creature[t][t];
        this.grille_objets = new Objet[t][t];
    }

    /**
     * Création d'un monde aléatoire
     *
     * @param taille Taille du monde
     */
    public void creeMondeAlea() {
        int t = this.taille;
        Point2D p;
        boolean pris;
        
        for (int i=0;i<this.nbCreaturesBase;i++){
            switch (seed.nextInt(3)) {
                case 0:
                    this.creatures.add(new Archer());
                    break;
                case 1:
                    this.creatures.add(new Guerrier());
                    break;
                case 2:
                    this.creatures.add(new Paysan());
                    break;
            }
        }
        Iterator<Creature> CreaIt1 = this.creatures.iterator();
        Creature c1;
        while (CreaIt1.hasNext()) {
            c1 = CreaIt1.next();
            pris = true;
            p = new Point2D(t);
            while (pris) {
                p = new Point2D(t);
                pris = (this.grille_creatures[p.getX()][p.getY()] != null);
            }
            c1.setPos(p);
            this.grille_creatures[p.getX()][p.getY()] = c1;
            //c1.affiche();
        }
        
        for (int i=0;i<this.nbObjetsBase;i++){
            switch (seed.nextInt(2)) {
                case 0:
                    this.objets.add(new Epee());
                    break;
                case 1:
                    this.objets.add(new PotionSoin());
                    break;
            }
        }
        
        Iterator<Objet> ObjIt1 = this.objets.iterator();
        Objet o1;
        while (ObjIt1.hasNext()) {
            o1 = ObjIt1.next();
            pris = true;
            p = new Point2D();
            while (pris) {
                p = new Point2D();
                pris = (this.grille_creatures[p.getX()][p.getY()] != null
                        && this.grille_objets[p.getX()][p.getY()] != null);
            }
            o1.setPos(p);
            this.grille_objets[p.getX()][p.getY()] = o1;
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
            System.out.println("C'est au tour de " + creature + " de jouer.");
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
     *
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

    public Creature[][] getGrille_creatures() {
        return grille_creatures;
    }

    public Objet[][] getGrille_objets() {
        return grille_objets;
    }

    public LinkedList<Creature> getCreatures() {
        return creatures;
    }
    
}
