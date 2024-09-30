package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class Loup extends Monstre implements Combatif {

    /**
     * Créé un loup
     *
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param p position
     */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, 1, p);
    }

    /**
     * Initialise un Loup comme copie d'un autre
     * 
     * @param p Loup initial
     */
    public Loup(Monstre p) {
        super(p);
    }
    
    /**
     * Génère un Loup au point (x, y)
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public Loup(int x, int y) {
        super(x, y);
    }
    
    /**
     * Génère un Loup au point pt
     * 
     * @param pt point
     */
    public Loup(Point2D pt) {
        super(pt);
    }

    /**
     * Créé un loup aléatoire
     */
    public Loup() {
        super();
    }

    @Override
    public void combattre(Creature c) {
        if (distance(c) <= this.getDistAttMax()) {
            if (lanceDe(this.getPageAtt())) {
                if (c.lanceDe(c.getPagePar())) {
                    int pertes = Math.max(0, this.getDegAtt() - c.getPtPar());
                    c.setPtVie(c.getPtVie() - pertes);
                    System.out.println("Le loup attaque "+c+" qui pare son attaque!");
                } else {
                    c.setPtVie(c.getPtVie() - this.getDegAtt());
                    System.out.println("Le loup attaque "+c+" qui ne parvient pas à parer !");
                }
                if (c.getPtVie() <= 0) {
                    c.setPtVie(0);
                    System.out.println(c + " est mort!");
                }
            } else {
                System.out.println("Grrr ! Le Loup s'éloigne.");
            }
        } else {
            System.out.println("Un Loup grogne dans le lointain.");
        }
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.print("C'est un loup terrifiant !\n");
    }

    @Override
    public String toString() {
        return "Loup";
    }
}
