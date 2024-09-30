package org.centrale.objet.WoE;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

/**
 * Un monde WoE
 * @author Ulysse
 */
public class World {
    
    /**
     * Taille de monde par défaut
     */
    private final int tailleBase = 100;
    /**
     * Nombre de créature par défaut à la génération d'un monde
     */
    private final int nbCreaturesBase = tailleBase*tailleBase/5;
    /**
     * Nombre d'objets par défaut à la génération d'un monde
     */
    private final int nbObjetsBase = nbCreaturesBase;
    
    
    /**
     * Générateur de nombres aléatoires associé au monde
     */
    Random seed;
    /**
     * Taille du monde
     */
    int taille;
    /**
     * Liste des créatures du monde
     */
    LinkedList<Creature> creatures = new LinkedList<>();
    /**
     * Liste des objets du monde
     */
    LinkedList<Objet> objets = new LinkedList<>();
    /**
     * Tableau donnant les positions des créatures du monde, et null en l'absence de créature
     */
    Creature[][] grille_creatures;
    /**
     * Tableau donnant les positions des objets du monde, et null en l'absence d'objet
     */
    Objet[][] grille_objets;

    /**
     * Initialisation d'un monde vide de taille prédéfinie
     *
     * @param t taille du monde
     */
    public World(int t) {
        this.seed = new Random();
        this.taille = t;
        this.grille_creatures = new Creature[t][t];
        this.grille_objets = new Objet[t][t];
    }
    
    /**
     * Initialisation d'un monde vide à la taille de base définie
     * 
     */
    public World() {
        this.seed = new Random();
        this.taille = this.tailleBase;
        this.grille_creatures = new Creature[this.taille][this.taille];
        this.grille_objets = new Objet[this.taille][this.taille];
    }

    /**
     * Remplissage aléatoire d'un monde
     *
     */
    public void creeMondeAlea() {
        int t = this.taille;
        Point2D p;
        boolean pris;
        
        // Création de nbCreaturesBase créatures dans le monde, réparties
        // aléatoirement entre les différents types existants
        for (int i=0;i<this.nbCreaturesBase;i++){
            switch (seed.nextInt(5)) {
                case 0:
                    this.creatures.add(new Archer());
                    break;
                case 1:
                    this.creatures.add(new Guerrier());
                    break;
                case 2:
                    this.creatures.add(new Paysan());
                    break;
                case 3:
                    this.creatures.add(new Lapin());
                    break;
                case 4:
                    this.creatures.add(new Loup());
                    break;
            }
        }
        
        // Assignation des positions initiales de chaque créature, 
        // pour assurer leur unicité
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
        
        
        // Création de nbObjetsBase objets dans le monde, répartis
        // aléatoirement entre les différents types existants
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
        
        // Assignation des positions de chaque objet,
        // pour assurer qu'aucun objet n'est intialement sous une créature ou
        // avec un autre objet
        Iterator<Objet> ObjIt1 = this.objets.iterator();
        Objet o1;
        while (ObjIt1.hasNext()) {
            o1 = ObjIt1.next();
            pris = true;
            p = new Point2D(t);
            while (pris) {
                p = new Point2D(t);
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
     * qui joue, la déplace puis l'affiche à nouveau.
     */
    public void tourDeJeu() {
        cleanEntites(creatures);
        cleanEntites(objets);
        for (Creature creature : creatures) {
            System.out.println("C'est au tour de " + creature + " de jouer.");
            creature.deplace(this.grille_creatures);
            creature.affiche();
        }
        System.out.println("Fin du tour de jeu");
    }

    /**
     * Affichage du monde : TODO
     * ===========
     * | . O . M |
     * | M . . O |
     * | . . . . |
     * | . P . . |
     * ===========
     */
    public void afficheWorld() {
        String carte = new String();
        int i;
        int j;
        Creature c;
        Objet o;
        
        for (i = 0; i < 1+2*this.taille+2; i++) {
            carte += "=";
        }
        carte += "\n";
        
        for (i = 0; i < this.taille; i++) {
            carte += "|";
            for (j = 0; j < this.taille; j++) {
                carte += " ";
                c = this.grille_creatures[i][j];
                o = this.grille_objets[i][j];
                if (c != null) {
                    if (c instanceof Archer) {
                        carte += "A";
                    } else if (c instanceof Guerrier) {
                        carte += "G";
                    } else if (c instanceof Paysan) {
                        carte += "p";
                    } else if (c instanceof Lapin) {
                        carte += "l";
                    } else if (c instanceof Loup) {
                        carte += "L";
                    } 
                } else if (o != null) {
                    if (o instanceof Epee) {
                        carte += "E";
                    } else if (o instanceof PotionSoin) {
                        carte += "S";
                    }
                } else {
                    carte += ".";
                }
            }
            carte += " |\n";
        }
        
        for (i = 0; i < 1+2*this.taille+2; i++) {
            carte += "=";
        }
        carte += "\n";
        
        System.out.print(carte);
    }

    /**
     * Retire les entites à détruire : objets utilisés et créatures mortes
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
    
    /**
     * Getter de grille_creatures
     * @return 
     */
    public Creature[][] getGrille_creatures() {
        return grille_creatures;
    }
    
    /**
     * Getter de grille_objets
     * @return 
     */
    public Objet[][] getGrille_objets() {
        return grille_objets;
    }
    
    /**
     * Getter de creatures 
     * @return 
     */
    public LinkedList<Creature> getCreatures() {
        return creatures;
    }
        
        // Assignation des positions de chaque objet,
        // pour assurer qu'aucun objet n'est intialement sous une créature ou
        // avec un autre objet
    /**
     * Getter de objets
     * @return 
     */
    public LinkedList<Objet> getObjets() {
        return objets;
    }
    
    private void addCreature_aux(Creature c, int x, int y) {
        Objet o = this.grille_objets[x][y];
        if (this.grille_creatures[x][y] != null) {
            System.out.println("Une créature se trouve déjà ici. Tu n'as pas le droit d'apparaître !");
        } else if (o != null && c instanceof Personnage) {
            o.recuperer((Personnage) c);
            System.out.println("Oh ! Quel bel objet que voilà !");
    
            this.objets.remove(o);
            this.grille_objets[x][y] = null;
            this.grille_creatures[x][y] = c;
            this.creatures.add(c);
        } else {
            this.grille_creatures[x][y] = c;
            this.creatures.add(c);
}
    }
    
    public void addCreature(Creature c, int x, int y) {
        c.setPos(x, y);
        addCreature_aux(c, x, y);
    }
    
    public void addCreature(Creature c) {
        int x = c.getX();
        int y = c.getY();
        addCreature_aux(c, x, y);
    }
    
    private void addObjet_aux(Objet o, int x, int y) {
        Creature c = this.grille_creatures[x][y];
        if (this.grille_objets[x][y] != null) {
            System.out.println("Un objet se trouve déjà ici. Tu n'as pas le droit d'apparaître !");
        } else if (c != null && c instanceof Personnage) {
            o.recuperer((Personnage) c);
            System.out.println("Oh ! Quel bel objet que voilà !");
            this.grille_objets[x][y] = o;
            this.objets.add(o);
        } else {
            this.grille_objets[x][y] = o;
            this.objets.add(o);
        }
    }
    
    public void addObjet(Objet o, int x, int y) {
        o.setPos(x, y);
        addObjet_aux(o, x, y);
    }
    
    public void addObjet(Objet o) {
        int x = o.getX();
        int y = o.getY();
        addObjet_aux(o, x, y);
    }
}
