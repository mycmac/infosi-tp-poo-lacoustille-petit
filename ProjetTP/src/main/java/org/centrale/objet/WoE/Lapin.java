package org.centrale.objet.WoE;

/**
 * Un Lapin (Monstre)
 *
 * @author Ulysse
 */
public class Lapin extends Monstre {

    /**
     * Créé un lapin
     *
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param vitesse vitesse de déplacement
     * @param p position
     */
    public Lapin(int pV, int dA, int pPar, int paAtt, int paPar, int vitesse, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, 1, vitesse, p);
    }

    /**
     * Copie un lapin
     *
     * @param p
     */
    public Lapin(Lapin p) {
        super(p);
    }
    
    /**
     * Génère un Lapin au point (x, y)
     * 
     * @param x
     * @param y 
     */
    public Lapin(int x, int y) {
        super(x, y);
    }
    
    /**
     * Génère un Lapin au point pt
     * 
     * @param pt 
     */
    public Lapin(Point2D pt) {
        super(pt);
    }

    /**
     * Génère un lapin aléatoire (voir
     * {@link org.centrale.objet.WoE.Creature#Creature()} )
     */
    public Lapin() {
        super();
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.print("Et non, c'est un lapin.\n");
    }
    
    /**
     *
     * @return "Lapin"
     */
    @Override
    public final String toString() {
        return "Lapin";
    }
}
