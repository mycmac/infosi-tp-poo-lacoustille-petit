package org.centrale.objet.WoE;

/**
 * Objet permettant de soigner des points de vie
 * @author timot
 */
public class PotionSoin extends Objet implements Recuperable, Utilisable {

    /**
     * Points de vie de départ : entre 1 et 99
     */
    private final int ptVieBaseMin = 1;
    /**
     * @see #ptVieBaseMin
     */
    private final int ptVieBaseMax = 99;
    
    /**
     * Points de vie rendus par la PotionSoin
     */
    private final int ptVie;
    
    /**
     * Initialise une PotionSoin comme copie d'une autre
     * 
     * @param p PotionSoin initiale
     */
    public PotionSoin(PotionSoin p) {
        super(p);
        ptVie = p.getPtVie();
    }
    
    /**
     * Initialise une PotionSoin avec tous ses attributs
     * 
     * @param pv points de vie rendus
     * @param pos position
     */
    public PotionSoin(int pv, Point2D pos) {
        super(pos);
        ptVie = pv;
    }
    
    /**
     * Génère une PotionSoin au point (x, y)
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public PotionSoin(int x, int y) {
        super(x, y);
        ptVie = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
    }
    
    /**
     * Génère une PotionSoin au point pos
     * 
     * @param pos point
     */
    public PotionSoin(Point2D pos) {
        super(pos);
        ptVie = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
    }
    
    /**
     * Initialise une PotionSoin à une position aléatoire
     * 
     * @param pv points de vie rendus
     */
    public PotionSoin(int pv) {
        super();
        ptVie = pv;
    }
    
    /**
     * Génère une PotionSoin aléatoire
     */
    public PotionSoin() {
        super();
        ptVie = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
    }
    
    /**
     * Récupère les points de vie rendus de la PotionSoin
     * @return ptVie
     */
    public int getPtVie() {
        return ptVie;
    }
    
    /**
     * Comportement d'une PotionSoin lorsqu'elle est récupérée par le personnage
     * 
     * @param p Personnage
     */
    @Override
    public void recuperer(Personnage p) {
        p.setPtVie(Math.min(p.getPtVieMax(), p.getPtVie() + ptVie));
        this.pos = null;
    }
}
