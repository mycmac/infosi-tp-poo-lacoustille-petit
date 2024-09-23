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

    public Loup(Monstre p) {
        super(p);
    }

    public Loup() {
    }

    /**
     * Combattre une créature désignée
     *
     * @param c
     */
    public void combattre(Creature c) {
        if (distance(c)<=1){
        if (lanceDe(this.getPageAtt())){
            if (c.lanceDe(c.getPagePar())){
                int pertes = Math.max(0, this.getDegAtt()-c.getPtPar());
                c.setPtVie(c.getPtVie()-pertes);}
            else{c.setPtVie(c.getPtVie()-this.getDegAtt());}
            if (c.getPtVie()<0){c.setPtVie(0);}
        }else{
        System.out.print("Grrr ! Le Loup s'éloigne.");
        }
        }else{System.out.print("Un Loup grogne dans le lointain.");}
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.print("C'est un loup terrifiant !");
    }
}
