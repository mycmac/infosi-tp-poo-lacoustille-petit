package org.centrale.objet.WoE;

/**
 * Super-classe pour les objets de WoE
 *
 * @author timot
 */
public abstract class Objet extends Entite {
    
    /**
     * Initialise un Objet comme copie d'un autre
     * 
     * @param o 
     */
    public Objet(Objet o) {
        super(o.getPos());
    }
    
    /**
     * Génère un Objet au point (x, y)
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public Objet(int x, int y) {
        super(x, y);
    }
    
    /**
     * Génère un Objet au point pos
     * 
     * @param pos point
     */
    public Objet(Point2D pos) {
        super(pos);
    }
    
    /**
     * Génère un Objet aléatoire
     */
    public Objet() {
        super(new Point2D());
    }

    /**
     * Comportement de l'objet lorsqu'il est récupéré par un personnage
     * 
     * @param p Personnage
     */
    public abstract void recuperer(Personnage p);
}
