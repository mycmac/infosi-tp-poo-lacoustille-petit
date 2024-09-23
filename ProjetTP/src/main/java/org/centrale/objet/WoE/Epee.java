package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author timot
 */
public class Epee extends Objet {

    // TODO : Modifier bases aléatoires
    // TODO : Méthode recuperer
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

    private int degAtt; // Dégats d'attaque
    private int ptPar; // Points de parade
    private int pageAtt; // Porcentage d'attaque
    private int pagePar; // Pourcentage de parade

    public Epee(int dA, int pPar, int paAtt, int paPar, Point2D pos) {
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
    }

    public Epee(Epee e) {
        degAtt = e.getDegAtt();
        ptPar = e.getPtPar();
        pageAtt = e.getPageAtt();
        pagePar = e.getPagePar();
        this.setPos(e.getPos());
    }

    public Epee() {
        Random r = new Random();
        degAtt = r.nextInt(degAttBaseMax - degAttBaseMin + 1) + degAttBaseMin;
        ptPar = r.nextInt(ptParBaseMax - ptParBaseMin + 1) + ptParBaseMin;
        pageAtt = r.nextInt(pageAttBaseMax - pageAttBaseMin + 1) + pageAttBaseMin;
        pagePar = r.nextInt(pageParBaseMax - pageParBaseMin + 1) + pageParBaseMin;
    }

    /**
     * Récupère les dégats d'attaque
     *
     * @return Dégats d'attaque
     */
    public int getDegAtt() {
        return degAtt;
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
        return ptPar;
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
        return pageAtt;
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
        return pagePar;
    }

    /**
     * Redéfinit le pourcentage de réussite de parade
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    @Override
    public void recuperer(Personnage p) {
        p.setArme(this);
        p.pos = null;
    }

}
