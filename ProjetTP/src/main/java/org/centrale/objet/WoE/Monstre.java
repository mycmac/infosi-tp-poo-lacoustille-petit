package org.centrale.objet.WoE;

/**
 * Creature de type monstre
 *
 * @author Ulysse
 */
public class Monstre extends Creature {

    /**
     * Créé un monstre à partir de paramètres donnés (voir
     * org.centrale.objet.WoE.Creature.Creature())
     *
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param p
     */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    /**
     * Initialise un Monstre comme copie d'un autre
     *
     * @param m
     */
    public Monstre(Monstre m) {
        super(m);
    }
    
    /**
     * Génère un Monstre au point (x, y)
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public Monstre(int x, int y) {
        super(x, y);
    }
    
    /**
     * Génère un Monstre au point pt
     * 
     * @param pt point
     */
    public Monstre(Point2D pt) {
        super(pt);
    }
    
    /**
     * Génère aléatoirement un monstre (voir Creature)
     * 
     */
    public Monstre() {
        super();
    }
    
    
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("C'est un monstre! ");
    }
}
