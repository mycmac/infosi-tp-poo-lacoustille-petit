package org.centrale.objet.WoE;

/**
 * Objet de combat
 * @author timot
 */
public class Epee extends Objet implements Recuperable, Utilisable {

    // TODO : Modifier bases aléatoires
    /**
     * Dégats d'attaque : entre 1 et 10
     * Modificateur appliqué aux dgts d'atk du porteur : (dAttArme+5)/10
     */
    private final int degAttBaseMin = 1;
    /**
     * @see #degAttBaseMin
     */
    private final int degAttBaseMax = 10;
    /**
     * Points de parade : entre 1 et 10
     * Modificateur appliqué aux pts de parade du porteur : (ptParArme+5)/10
     */
    private final int ptParBaseMin = 1;
    /**
     * @see #ptParBaseMin
     */
    private final int ptParBaseMax = 10;
    /**
     * Pourcentage de chance de réussite d'une attaque : entre 1 et 100 (%)
     * Calcul du pourcentage modifié par l'arme : pAtt += (100-pAtt)*pAttArme
     */
    private final int pageAttBaseMin = 1;
    /**
     * @see #pageAttBaseMin
     */
    private final int pageAttBaseMax = 100;
    /**
     * Pourcentage de chance de réussite d'une parade : entre 1 et 100 (%)
     * Calcul du pourcentage modifié par l'arme : pPar += (100-pPar)*pParArme
     */
    private final int pageParBaseMin = 1;
    /**
     * @see #pageParBaseMin
     */
    private final int pageParBaseMax = 100;
    
    /**
     * Dégâts d'attaque
     */
    private int degAtt;
    /**
     * Points de parade
     */
    private int ptPar;
    /**
     * Pourcentage d'attaque
     */
    private int pageAtt;
    /**
     * Pourcentage de parade
     */
    private int pagePar;
    /**
     * Type de l'arme
     */
    private String type;
    
    /**
     * Copie une épée e
     * 
     * @param e Epee initiale
     */
    public Epee(Epee e) {
        this.type = e.getType();
        this.degAtt = e.getDegAtt();
        this.ptPar = e.getPtPar();
        this.pageAtt = e.getPageAtt();
        this.pagePar = e.getPagePar();
    }

    /**
     * Initialise une épée avec les attributs suivants :
     * @param type type d'épée
     * @param dA dégats d'attaque supplémentaires
     * @param pPar points d'attaque supplémentaires
     * @param paAtt pourcentage d'attaque supplémentaires
     * @param paPar pourcentage de parade supplémentaires
     * @param pos position de l'épée
     */
    public Epee(String type, int dA, int pPar, int paAtt, int paPar, Point2D pos) {
        super(pos);
        this.type = type;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
    }

    /**
     * Initialise une épée avec les attributs suivants :
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
     * @param type
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @see #Epee(int, int, int, int, org.centrale.objet.WoE.Point2D)
     */
    public Epee(String type, int dA, int pPar, int paAtt, int paPar) {
        super();
        this.type = type;
        this.degAtt = dA;
        this.ptPar = pPar;
        this.pageAtt = paAtt;
        this.pagePar = paPar;
    }
    
    /**
     * Crée une épée aléatoire au point (x, y) 
     * @param x abscisse
     * @param y ordonnée
     */
    public Epee(int x, int y) {
        super(x, y);
        this.degAtt = getRandom(degAttBaseMax - degAttBaseMin + 1) + degAttBaseMin;
        this.ptPar = getRandom(ptParBaseMax - ptParBaseMin + 1) + ptParBaseMin;
        this.pageAtt = getRandom(pageAttBaseMax - pageAttBaseMin + 1) + pageAttBaseMin;
        this.pagePar = getRandom(pageParBaseMax - pageParBaseMin + 1) + pageParBaseMin;
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

    /**
     * Récupère le type d'arme
     *
     * @return type
     */
    public String getType() {
        return this.type;
    }

    /**
     * Redéfinit le type d'arme
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }


    /**
     * Comportement d'une épée récupérée par un joueur
     * 
     * @param j Joueur
     */
    @Override
    public void recuperer(Joueur j) {
        j.addInventaire(this);
        this.pos = null;
    }

    /**
     * Comportement d'une Epee qui sera équipée au personnage du joueur
     * 
     * @param j Joueur
     */
    public void equiper(Joueur j) {
        j.getPerso().setArme(this);
        this.pos = null;
    }

    /**
     * Comportement du cast vers un String
     * 
     * @return Epee : dgts, par, %dgts, %par
     */
    @Override
    public String toString() {
        return type + "degAtt=" + degAtt + ", ptPar=" + ptPar + ", Att +" + pageAtt + "%, Par +" + pagePar + "%";
    }

    /**
     * Crée une instance d'Epee à partir d'un type d'arme
     * @return
     */
    public static Epee RandomType() {
        Types_Armes type = Types_Armes.getRandom();
        return new Epee(type.getNom(), type.getDegAtt(), type.getPtPar(), type.getPageAtt(), type.getPagePar());
    }

    /**
     * Équipe l'épée sélectionnée et renvoie (si elle existe) celle qui était équipée
     * @param j Joueur équipant l'épée
     * @return Ancienne arme du joueur
     */
    @Override
    public Recuperable utiliser(Joueur j) {
        Epee res = null;
        if (j.getPerso().getArme() != null){
            res = new Epee(j.getPerso().getArme());
            Fenetre.addMessage("Épée équipée");
        }
        equiper(j);
        return res;
    }
    
}
