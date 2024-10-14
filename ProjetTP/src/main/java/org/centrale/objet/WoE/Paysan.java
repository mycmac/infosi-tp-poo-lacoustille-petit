package org.centrale.objet.WoE;

/**
 * Un personnage paisible
 * @author Ulysse
 */
public class Paysan extends Personnage {
    
    /**
     * Initialise un Paysan à partir de tous ses attributs
     * 
     * @param n nom
     * @param pV points de vie
     * @param dA dégâts d'attaque
     * @param pPar points de parade
     * @param paAtt pourcentage d'attaque
     * @param paPar pourcentage de parade
     * @param dMax distance d'attaque maximale
     * @param pt point
     */
    public Paysan(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, int vitesse, Point2D pt) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, vitesse, pt);
    }
    
    /**
     * Initialise un Paysan comme copie d'un autre paysan
     * 
     * @param p Paysan initial
     */
    public Paysan(Paysan p) {
        super(p);
    }
    
    /**
     * Génère un Paysan au point (x, y)
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public Paysan(int x, int y) {
        super(x, y);
    }
    
    /**
     * Génère un Paysan au point pt
     * 
     * @param pt point
     */
    public Paysan(Point2D pt) {
        super(pt);
    }
    
    /**
     * Génère un Paysan aléatoire
     */
    public Paysan() {
        super();
    }
    
    /**
     * Affiche le Paysan en console
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print(this.getNom() + " travaille dans sa ferme.\n");
    }
}
