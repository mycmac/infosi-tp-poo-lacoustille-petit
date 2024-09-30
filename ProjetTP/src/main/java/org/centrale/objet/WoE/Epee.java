package org.centrale.objet.WoE;

/**
 *
 * @author timot
 */
public class Epee extends Objet {

    // TODO : Modifier bases aléatoires
    /**
     * Dégats d'attaque : entre 1 et 10
     * Modificateur appliqué aux dgts d'atk du porteur : (dAttArme+5)/10
     */
    private final int degAttBaseMin = 1;
    private final int degAttBaseMax = 10;
    /**
     * Points de parade : entre 1 et 10
     * Modificateur appliqué aux pts de parade du porteur : (ptParArme+5)/10
     */
    private final int ptParBaseMin = 1;
    private final int ptParBaseMax = 10;
    /**
     * Pourcentage de chance de réussite d'une attaque : entre 1 et 100 (%)
     * Calcul du pourcentage modifié par l'arme : pAtt += (100-pAtt)*pAttArme
     */
    private final int pageAttBaseMin = 1;
    private final int pageAttBaseMax = 100;
    /**
     * Pourcentage de chance de réussite d'une parade : entre 1 et 100 (%)
     * Calcul du pourcentage modifié par l'arme : pPar += (100-pPar)*pParArme
     */
    private final int pageParBaseMin = 1;
    private final int pageParBaseMax = 100;

    private int degAtt; // Dégats d'attaque
    private int ptPar; // Points de parade
    private int pageAtt; // Porcentage d'attaque
    private int pagePar; // Pourcentage de parade
    
    /**
     * Copie une épée e
     * @param e
     */
    public Epee(Epee e) {
        super(e);
        this.degAtt = e.getDegAtt();
        this.ptPar = e.getPtPar();
        this.pageAtt = e.getPageAtt();
        this.pagePar = e.getPagePar();
    }

    /**
     * Initialise une épée avec les paramètres suivants :
     * @param dA dégats d'attaque supplémentaires
     * @param pPar points d'attaque supplémentaires
     * @param paAtt pourcentage d'attaque supplémentaires
     * @param paPar pourcentage de parade supplémentaires
     * @param pos position de l'épée
     */
    public Epee(int dA, int pPar, int paAtt, int paPar, Point2D pos) {
        super(pos);
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
    }
    
    /**
     * Créé une épée donnée à un endroit aléatoire
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @see #Epee(int, int, int, int, org.centrale.objet.WoE.Point2D)
     */
    public Epee(int dA, int pPar, int paAtt, int paPar) {
        super();
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
    }
    
    /**
     * Créé une épée aléatoire à un endroit donné
     * @param pos position de l'épée
     * @see #Epee(int, int, int, int, org.centrale.objet.WoE.Point2D) 
     */
    public Epee(Point2D pos) {
        super(pos);
        this.degAtt = getRandom(degAttBaseMax - degAttBaseMin + 1) + degAttBaseMin;
        this.ptPar = getRandom(ptParBaseMax - ptParBaseMin + 1) + ptParBaseMin;
        this.pageAtt = getRandom(pageAttBaseMax - pageAttBaseMin + 1) + pageAttBaseMin;
        this.pagePar = getRandom(pageParBaseMax - pageParBaseMin + 1) + pageParBaseMin;
    }

    /**
     * Créé une épée entièrement aléatoire
     * @see #Epee(int, int, int, int, org.centrale.objet.WoE.Point2D)
     */
    public Epee() {
        super();
        this.degAtt = getRandom(degAttBaseMax - degAttBaseMin + 1) + degAttBaseMin;
        this.ptPar = getRandom(ptParBaseMax - ptParBaseMin + 1) + ptParBaseMin;
        this.pageAtt = getRandom(pageAttBaseMax - pageAttBaseMin + 1) + pageAttBaseMin;
        this.pagePar = getRandom(pageParBaseMax - pageParBaseMin + 1) + pageParBaseMin;
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

    @Override
    public void recuperer(Personnage p) {
        p.setArme(this);
        p.pos = null;
    }

}
