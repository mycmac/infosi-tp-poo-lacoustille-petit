package org.centrale.objet.WoE;

/**
 *
 * @author timot
 */
public class PotionSoin extends Objet {

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
     * Génère une PotionSoin au point pos
     * 
     * @param pos point
     */
    public PotionSoin(Point2D pos) {
        super(pos);
        ptVie = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
    }
    
    /**
     * 
     * 
     * @param pv 
     */
    public PotionSoin(int pv) {
        super();
        ptVie = pv;
    }

    public PotionSoin() {
        super();
        ptVie = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
    }

    public int getPtVie() {
        return ptVie;
    }

    @Override
    public void recuperer(Personnage p) {
        p.setPtVie(Math.min(p.getPtVieMax(), p.getPtVie() + ptVie));
        this.pos = null;
    }
}
