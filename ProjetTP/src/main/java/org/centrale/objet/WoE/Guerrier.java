package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse, timot
 */
public class Guerrier extends Personnage implements Combatif {

    
    /**
     * Crée un guerrier identique au guerrier p
     *
     * @param p Guerrier à copier
     */
    public Guerrier(Guerrier p) {
        super(p);
    }
    
    /**
     * Initialise un guerrier
     *
     * @param n nom
     * @param pV points de vie
     * @param dA distance d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussir une attaque
     * @param paPar probabilité de réussir une parade
     * @param dMax distance d'attaque maximale
     * @param p position (Point2D)
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }
    
    /**
     * Génère un guerrier aléatoire
     */
    public Guerrier() {
        super();
    }

    /**
     * Combattre une créature désignée
     *
     * @param c
 */
    @Override
    public void combattre(Creature c) {
        System.out.println("Aiyah");
    }
    
}
