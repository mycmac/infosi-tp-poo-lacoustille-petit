package org.centrale.objet.WoE;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Super-classe générique pour les créatures diverses de WoE
 *
 * @author Ulysse
 */
public abstract class Creature extends Entite implements Deplacable{

    /**
     * Limites hautes et basses (incluses) des stats de départ des créatures
     */
    /**
     * Points de vie de départ : entre 20 et 100
     */
    private static final int PT_VIE_BASE_MIN = 20;
    /**
     * @see #PT_VIE_BASE_MIN
     */
    private static final int PT_VIE_BASE_MAX = 100;
    /**
     * Dégats d'attaque : entre 1 et 10
     */
    private static final int DEG_ATT_BASE_MIN = 1;
    private static final int DEG_ATT_BASE_MAX = 10;
    /**
     * Points de parade : entre 1 et 10
     */
    private static final int PT_PAR_BASE_MIN = 1;
    private static final int PT_PAR_BASE_MAX = 10;
    /**
     * Pourcentage de chance de réussite d'une attaque : entre 1 et 100 (%)
     */
    private static final int PAGE_ATT_BASE_MIN = 1;
    private static final int PAGE_ATT_BASE_MAX = 100;
    
    /**
     * Pourcentage de chance de réussite d'une parade : entre 1 et 100 (%)
     */
    private static final int PAGE_PAR_BASE_MIN = 1;
    private static final int PAGE_PAR_BASE_MAX = 100;

    /**
     * Nomenclature du dictionnaire des caractéristiques
     */
    public enum Carac {
        PV_MAX("Points de vie max"),
        PV("Points de vie actuels"),
        DEGATS("Degats d'attaque"),
        PARADE("Points de parade"),
        POURCENTAGE_ATK("Pourcentage d'attaque"),
        POURCENTAGE_PAR("Pourcentage de parade"),
        DIST_ATK_MAX("Distance d'attaque max"),
        VITESSE("Vitesse de déplacement");

        private String nom;

        private Carac(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return this.nom;
        }
    }

    /**
     * Dictionnaire des caractéristiques d'une créature
     * Le nombre d'entrées et les clés sont fixes, mais les valeurs sont modifiables
     * @return Caractéristiques
     */
    private static final Map<String, Integer> defCaracs() {
        Map<String, Integer> modifiableMap = new HashMap<>();

        modifiableMap.put("Points de vie max", null);
        modifiableMap.put("Points de vie actuels", null);
        modifiableMap.put("Degats d'attaque", null);
        modifiableMap.put("Points de parade", null);
        modifiableMap.put("Pourcentage d'attaque", null);
        modifiableMap.put("Pourcentage de parade", null);
        modifiableMap.put("Distance d'attaque max", null);
        modifiableMap.put("Vitesse de déplacement", null);

        return modifiableMap;
    }

    private Map<String, Integer> caracs = defCaracs();

    private ArrayList<Modificateur> effets;

    /**
     * Initialise une créature en copiant les attributs d'une Creature donnée
     *
     * @param p créature à copier
     */
    public Creature(Creature p) {
        super(p.pos);
        this.caracs = new HashMap<>(p.caracs);
        this.caracs.put(Carac.PV.getNom(), this.caracs.get(Carac.PV_MAX.getNom()));
    }

    /**
     * Initialise une Creature à partir d'attributs spécifiés
     *
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param dAtkMax Distance attaque max
     * @param vitesse Vitesse perso
     * @param pt position
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, int dAtkMax, int vitesse, Point2D pt) {
        super(pt);
        this.caracs.put(Carac.PV_MAX.getNom(), pV);
        this.caracs.put(Carac.DEGATS.getNom(), dA);
        this.caracs.put(Carac.PARADE.getNom(), pPar);
        this.caracs.put(Carac.POURCENTAGE_ATK.getNom(), paAtt);
        this.caracs.put(Carac.POURCENTAGE_PAR.getNom(), paPar);
        this.caracs.put(Carac.DIST_ATK_MAX.getNom(), dAtkMax);
        this.caracs.put(Carac.VITESSE.getNom(), vitesse);
        this.caracs.put(Carac.PV.getNom(), this.caracs.get(Carac.PV_MAX.getNom()));
    }
    
    /**
     * Initialise une Creature aléatoire en un point donné
     * 
     * @param x abscisse
     * @param y ordonnée
     */
    public Creature(int x, int y) {
        super(x, y);
        this.caracs.put(Carac.PV_MAX.getNom(), getRandom(PT_VIE_BASE_MAX - PT_VIE_BASE_MIN + 1) + PT_VIE_BASE_MIN);
        this.caracs.put(Carac.DEGATS.getNom(), getRandom(DEG_ATT_BASE_MAX - DEG_ATT_BASE_MIN + 1) + DEG_ATT_BASE_MIN);
        this.caracs.put(Carac.PARADE.getNom(), getRandom(PT_PAR_BASE_MAX - PT_PAR_BASE_MIN + 1) + PT_PAR_BASE_MIN);
        this.caracs.put(Carac.POURCENTAGE_ATK.getNom(), getRandom(PAGE_ATT_BASE_MAX - PAGE_ATT_BASE_MIN + 1) + PAGE_ATT_BASE_MIN);
        this.caracs.put(Carac.POURCENTAGE_PAR.getNom(), getRandom(PAGE_PAR_BASE_MAX - PAGE_PAR_BASE_MIN + 1) + PAGE_PAR_BASE_MIN);
        this.caracs.put(Carac.DIST_ATK_MAX.getNom(), 1);
        this.caracs.put(Carac.VITESSE.getNom(), 1);
        this.caracs.put(Carac.PV.getNom(), this.caracs.get(Carac.PV_MAX.getNom()));
    }
    
    /**
     * Initialise une Creature aléatoire en un point donné
     * 
     * @param p point
     */
    public Creature(Point2D p) {
        super(p);
        this.caracs.put(Carac.PV_MAX.getNom(), getRandom(PT_VIE_BASE_MAX - PT_VIE_BASE_MIN + 1) + PT_VIE_BASE_MIN);
        this.caracs.put(Carac.DEGATS.getNom(), getRandom(DEG_ATT_BASE_MAX - DEG_ATT_BASE_MIN + 1) + DEG_ATT_BASE_MIN);
        this.caracs.put(Carac.PARADE.getNom(), getRandom(PT_PAR_BASE_MAX - PT_PAR_BASE_MIN + 1) + PT_PAR_BASE_MIN);
        this.caracs.put(Carac.POURCENTAGE_ATK.getNom(), getRandom(PAGE_ATT_BASE_MAX - PAGE_ATT_BASE_MIN + 1) + PAGE_ATT_BASE_MIN);
        this.caracs.put(Carac.POURCENTAGE_PAR.getNom(), getRandom(PAGE_PAR_BASE_MAX - PAGE_PAR_BASE_MIN + 1) + PAGE_PAR_BASE_MIN);
        this.caracs.put(Carac.DIST_ATK_MAX.getNom(), 1);
        this.caracs.put(Carac.VITESSE.getNom(), 1);
        this.caracs.put(Carac.PV.getNom(), this.caracs.get(Carac.PV_MAX.getNom()));
    }
    
    /**
     * Initialise une Créature aléatoire avec des attributs aléatoires, au sein
     * des limites fixées dans Point2D
     */
    public Creature() {
        super(new Point2D());
        this.caracs.put(Carac.PV_MAX.getNom(), getRandom(PT_VIE_BASE_MAX - PT_VIE_BASE_MIN + 1) + PT_VIE_BASE_MIN);
        this.caracs.put(Carac.DEGATS.getNom(), getRandom(DEG_ATT_BASE_MAX - DEG_ATT_BASE_MIN + 1) + DEG_ATT_BASE_MIN);
        this.caracs.put(Carac.PARADE.getNom(), getRandom(PT_PAR_BASE_MAX - PT_PAR_BASE_MIN + 1) + PT_PAR_BASE_MIN);
        this.caracs.put(Carac.POURCENTAGE_ATK.getNom(), getRandom(PAGE_ATT_BASE_MAX - PAGE_ATT_BASE_MIN + 1) + PAGE_ATT_BASE_MIN);
        this.caracs.put(Carac.POURCENTAGE_PAR.getNom(), getRandom(PAGE_PAR_BASE_MAX - PAGE_PAR_BASE_MIN + 1) + PAGE_PAR_BASE_MIN);
        this.caracs.put(Carac.DIST_ATK_MAX.getNom(), 1);
        this.caracs.put(Carac.VITESSE.getNom(), 1);
        this.caracs.put(Carac.PV.getNom(), this.caracs.get(Carac.PV_MAX.getNom()));
    }

    /**
     * Récupère le nombre maximum de points de vie
     *
     * @return Points de vie max
     */
    public int getPtVieMax() {
        return this.caracs.get(Carac.PV_MAX.getNom());
    }

    /**
     * Redéfinit le nombre maximum de points de vie
     *
     * @param ptVieMax
     */
    public void setPtVieMax(int ptVieMax) {
        this.caracs.put(Carac.PV_MAX.getNom(), ptVieMax);
    }

    /**
     * Récupère le nombre de points de vie actuel
     *
     * @return Points de vie
     */
    public int getPtVie() {
        return this.caracs.get(Carac.PV.getNom());
    }

    /**
     * Modifie le nombre de points de vie
     *
     * @param ptVie Points de vie
     */
    public void setPtVie(int ptVie) {
        this.caracs.put(Carac.PV.getNom(), ptVie);
    }

    /**
     * Récupère les dégats d'attaque
     *
     * @return Dégats d'attaque
     */
    public int getDegAtt() {
        return this.caracs.get(Carac.DEGATS.getNom());
    }

    /**
     * Redéfinit le nombre de dégats d'attaque
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.caracs.put(Carac.DEGATS.getNom(), degAtt);
    }

    /**
     * Récupère le nombre de points de parade
     *
     * @return Nombre de points de parade
     */
    public int getPtPar() {
        return this.caracs.get(Carac.PARADE.getNom());
    }

    /**
     * Redéfinit le nombre de points de parade
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.caracs.put(Carac.PARADE.getNom(), ptPar);
    }

    /**
     * Récupère le taux de réussite d'attaque
     *
     * @return Pourcentage de réussite d'attaque
     */
    public int getPageAtt() {
        return this.caracs.get(Carac.POURCENTAGE_ATK.getNom());
    }

    /**
     * Redéfinit le pourcentage de réussite d'attaque
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.caracs.put(Carac.POURCENTAGE_ATK.getNom(), pageAtt);
    }

    /**
     * Récupère le taux de parade
     *
     * @return pourcentage de parade
     */
    public int getPagePar() {
        return this.caracs.get(Carac.POURCENTAGE_PAR.getNom());
    }

    /**
     * Redéfinit le pourcentage de réussite de parade
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.caracs.put(Carac.POURCENTAGE_PAR.getNom(), pagePar);
    }

    /**
     * Renvoie la distance d'attaque maximale
     * @return Distance d'attaque maximale
     */
    public int getDistAttMax() {
        return caracs.get(Carac.DIST_ATK_MAX.getNom());
    }

    /**
     * Redéfinit la distance d'attaque maximale
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.caracs.put(Carac.DIST_ATK_MAX.getNom(), distAttMax);
    }

    /**
     * Renvoie la vitesse
     * @return Vitesse
     */
    public int getVitesse() {
        return caracs.get(Carac.VITESSE.getNom());
    }

    /**
     * Redéfinit la vitesse
     * @param vitesse
     */
    public void setVitesse(int vitesse) {
        this.caracs.put(Carac.VITESSE.getNom(), vitesse);
    }

    public Map<String,Integer> getCaracs() {
        return this.caracs;
    }

    public void setCaracs(Map<String,Integer> caracs) {
        this.caracs = caracs;
    }


    public ArrayList<Modificateur> getEffets() {
        return this.effets;
    }

    public void setEffets(ArrayList<Modificateur> effets) {
        this.effets = effets;
    }


    /**
     * Déplace la créature de manière déterminée.
     *
     * @param grille
     * @param p
     */
    public void deplace(Creature[][] grille, Point2D p) {
        if (grille[this.getX() + p.getX()][this.getY() + p.getY()] == null) {
            grille[this.getX()][this.getY()] = null;
            this.pos.translate(p);
            grille[this.getX()][this.getY()] = this;
        } else {
            System.out.println("Il y a déjà une Creature ici. Celle-ci reste donc à sa place");
        }
    }
    
    /**
     * Déplace la créature de manière déterminée.
     *
     * @param grille
     * @param dx
     * @param dy
     */
    public void deplace(Creature[][] grille, int dx, int dy) {
        try{
        if (grille[this.getX() + dx][this.getY() + dy] == null) {
            grille[this.getX()][this.getY()] = null;
            this.pos.translate(dx, dy);
            grille[this.getX()][this.getY()] = this;
        } else {
            Fenetre.addMessage("Il y a déjà une Creature ici. Celle-ci reste donc à sa place");
        }}
        catch (ArrayIndexOutOfBoundsException e ){
            Fenetre.addMessage("Il s'agit d'un mur !");
        }
    }
    
    /**
     * Déplace aléatoirement selon l'une des 8 directions, en tenant compte des
     * autres créatures présentes.
     *   7   0   1
     *    \  |  / 
     *     \ | /
     * 6---- + ----2 
     *     / | \ 
     *    /  |  \ 
     *   5   4   3
     * @param grille Grille des créatures du monde concerné
     * /!\ PAS DE MOYEN DE TESTER LA PRÉSENCE EFFECTIVE DE LA CREATURE DANS CE MONDE
     */
    public void deplace(Creature[][] grille) {
        ArrayList<Point2D> deplacementsPossibles = new ArrayList<>();
        for (int i = -1; i<2; i++) {
            for (int j = -1; j<2; j++) {
                int ix = this.getX() + i;
                int jy = this.getY() + j;
                if (ix >= 0 && jy >= 0 && ix < grille.length && jy < grille.length) {
                    if(grille[ix][jy] == null) {
                        deplacementsPossibles.add(new Point2D(i, j));
                    }
                }
            }
        }
        
        int sz = deplacementsPossibles.size();
        if (sz != 0) {
            int dir = this.getRandom(sz);
            Point2D p = deplacementsPossibles.get(dir);
            deplace(grille, p);
        } else {
            System.out.println("Cette créature n'a nulle part où aller ! Elle reste donc à sa position initiale.");
        }
    }

    /**
     * Affiche les détails de base de la créature (points de vie et position)
     */
    public void affiche() {
        System.out.print("Cette créature a " + this.getPtVie() + " points de vie sur " + this.getPtVieMax() + " et se situe en " + pos + ". ");
    }
    
    /**
     * Effectue le lancé d'un dé de 100 pour le comparer à un pourcentage de réussite
     * @param pageReussite Pourcentage de réussite
     * @return Lancé réussi ou non
     */
    public boolean lanceDe(int pageReussite){
        return (this.getRandom(100)+1) <= pageReussite;
    }
}
