package org.centrale.objet.WoE;

/**
 * Super-classe générique pour les créatures diverses de WoE
 *
 * @author Ulysse
 */
public class Creature extends Entite {

    /**
     * Limites hautes et basses (incluses) des stats de départ des créatures
     */
    /**
     * Points de vie de départ : entre 20 et 99
     */
    private final int ptVieBaseMin = 20;
    /**
     * @see #ptVieBaseMin
     */
    private final int ptVieBaseMax = 99;
    /**
     * Dégats d'attaque : entre 1 et 10
     */
    private final int degAttBaseMin = 1;
    private final int degAttBaseMax = 10;
    /**
     * Points de parade : entre 1 et 10
     */
    private final int ptParBaseMin = 1;
    private final int ptParBaseMax = 10;
    /**
     * Pourcentage de chance de réussite d'une attaque : entre 1 et 99 (%)
     */
    private final int pageAttBaseMin = 1;
    private final int pageAttBaseMax = 99;
    /**
     * Pourcentage de chance de réussite d'une parade : entre 1 et 99 (%)
     */
    private final int pageParBaseMin = 1;
    private final int pageParBaseMax = 99;

    private int ptVie; // Points de vie
    private int ptVieMax; // Maximum de points de vie
    private int degAtt; // Dégats d'attaque
    private int ptPar; // Points de parade
    private int pageAtt; // Porcentage d'attaque
    private int pagePar; // Pourcentage de parade
    
    /**
     * Initialise une créature en copiant les attributs d'une Creature donnée
     *
     * @param p créature à copier
     */
    public Creature(Creature p) {
        super(p.pos, true);
        this.ptVieMax = p.getPtVie();
        this.ptVie = this.ptVieMax;
        this.degAtt = p.getDegAtt();
        this.ptPar = p.getPtPar();
        this.pageAtt = p.getPageAtt();
        this.pagePar = p.getPagePar();
    }

    /**
     * Initialise une Creature à partir d'attributs spécifiés
     *
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param p position
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(p, true);
        this.ptVieMax = pV;
        this.ptVie = this.ptVieMax;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
    }

    /**
     * Initialise une Créature aléatoire avec des attributs aléatoires, au sein
     * des limites fixées
     */
    public Creature() {
        super(new Point2D(), true);
        this.ptVieMax = getRandom(ptVieBaseMax - ptVieBaseMin + 1) + ptVieBaseMin;
        this.ptVie = this.ptVieMax;
        this.degAtt = getRandom(degAttBaseMax - degAttBaseMin + 1) + degAttBaseMin;
        this.ptPar = getRandom(ptParBaseMax - ptParBaseMin + 1) + ptParBaseMin;
        this.pageAtt = getRandom(pageAttBaseMax - pageAttBaseMin + 1) + pageAttBaseMin;
        this.pagePar = getRandom(pageParBaseMax - pageParBaseMin + 1) + pageParBaseMin;
    }

    /**
     * Récupère le nombre maximum de points de vie
     *
     * @return Points de vie max
     */
    public int getPtVieMax() {
        return this.ptVieMax;
    }

    /**
     * Redéfinit le nombre maximum de points de vie
     *
     * @param ptVieMax
     */
    public void setPtVieMax(int ptVieMax) {
        this.ptVieMax = ptVieMax;
    }

    /**
     * Récupère le nombre de points de vie actuel
     *
     * @return Points de vie
     */
    public int getPtVie() {
        return this.ptVie;
    }

    /**
     * Modifie le nombre de points de vie
     *
     * @param ptVie Points de vie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     * Récupère les dégats d'attaque
     *
     * @return Dégats d'attaque
     */
    public int getDegAtt() {
        return this.degAtt;
    }

    /**
     * Redéfinit le nombre de dégats d'attaque
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     * Récupère le nombre de points de parade
     *
     * @return Nombre de points de parade
     */
    public int getPtPar() {
        return this.ptPar;
    }

    /**
     * Redéfinit le nombre de points de parade
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     * Récupère le taux de réussite d'attaque
     *
     * @return Pourcentage de réussite d'attaque
     */
    public int getPageAtt() {
        return this.pageAtt;
    }

    /**
     * Redéfinit le pourcentage de réussite d'attaque
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     * Récupère le taux de parade
     *
     * @return pourcentage de parade
     */
    public int getPagePar() {
        return this.pagePar;
    }

    /**
     * Redéfinit le pourcentage de réussite de parade
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }
    
    /**
     *
     * Déplace aléatoirement selon l'une des 8 directions
     *   7   0   1
     *    \  |  / 
     *     \ | / 
     * 6---- + ----2 
     *     / | \ 
     *    /  |  \ 
     *   5   4   3
     */
    public void deplace() {
        int dir = getRandom(8);
        switch (dir) {
            case 0:
                this.pos.translate(0, 1);
                break;
            case 1:
                this.pos.translate(1, 1);
                break;
            case 2:
                this.pos.translate(1, 0);
                break;
            case 3:
                this.pos.translate(1, -1);
                break;
            case 4:
                this.pos.translate(0, -1);
                break;
            case 5:
                this.pos.translate(-1, -1);
                break;
            case 6:
                this.pos.translate(-1, 0);
                break;
            case 7:
                this.pos.translate(-1, 1);
                break;
        }
    }

    /**
     * Affiche les détails de base de la créature (points de vie et position)
     */
    public void affiche() {
        System.out.print("\nCette créature a " + ptVie + " points de vie et se situe en " + pos + ". ");
    }
}
