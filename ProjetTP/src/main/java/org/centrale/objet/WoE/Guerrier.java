package org.centrale.objet.WoE;

/**
 * Un Personnage belliqueux
 * 
 * @author Ulysse, timot
 */
public class Guerrier extends Personnage implements Combatif, Jouable {

    
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
     * Génère un guerrier au point (x, y)
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public Guerrier(int x, int y) {
        super(x, y);
    }
    
    /**
     * Génère un guerrier au point p
     * 
     * @param p point
     */
    public Guerrier(Point2D p) {
        super(p);
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
     * @param c Créature désignée
     */
    @Override
    public void combattre(Creature c) {
        String msg;
        int dgts;
        if (this.distance(c) <= 1) {
            int pAtt = this.getDegAtt();
            Epee arme = this.getArme();
            
            if (arme != null) {
                pAtt += (int) (100-pAtt)*arme.getPageAtt(); // Calcul des stats d'attaque avec arme
            }
            
            if (this.lanceDe(pAtt)) {
                int dAtt = this.getDegAtt();
                
                if (arme != null) {
                    dAtt *= (5+arme.getDegAtt())/10.;
                }
                
                int pPar = c.getPagePar();
                boolean cIsPerso = c instanceof Personnage;
                if (cIsPerso) {
                    Epee cArme = ((Personnage) c).getArme();
                    if (cArme != null) {
                        pPar += (int) (100-pAtt)*this.getArme().getPagePar();
                    }
                }
                
                if (c.lanceDe(pPar)) {
                    int dPar = c.getPtPar();
                    if (cIsPerso) {
                        Epee cArme = ((Personnage) c).getArme();
                        if (cArme != null) {
                            dPar *= (5+cArme.getPtPar())/10.;
                        }
                    }
                    dgts = Math.max(0, dAtt-dPar);
                    if (dgts == 0) {
                        msg = "Le coup atteint sa cible mais est complètement bloqué.";
                    } else {
                        msg = "Le coup est bloqué mais inflige tout de même " + dgts + " dégats !";
                        c.setPtVie(Math.max(0, c.getPtVie()-dgts));
                    }
                } else {
                    dgts = dAtt;
                    msg = "Le coup touche et inflige " + dgts + " dégats !";
                    c.setPtVie(Math.max(0, c.getPtVie()-dgts));
                }
            } else {
                msg = "Le coup a raté.";
            }
        } else {
            msg = "La cible est trop loin !";
        }
        System.out.println(msg);
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.print("\n");
    }   
}
