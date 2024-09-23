package org.centrale.objet.WoE;

import java.util.Random;

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

    private final int ptVie;
    
    public PotionSoin(PotionSoin p) {
        super(p);
        ptVie = p.getPtVie();
    }

    public PotionSoin(int pv, Point2D pos) {
        super(pos);
        ptVie = pv;
    }
    
    public PotionSoin(Point2D pos) {
        super(pos);
        ptVie = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
    }
    
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
