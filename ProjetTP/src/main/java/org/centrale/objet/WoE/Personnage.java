package org.centrale.objet.WoE;

/**
 * Classe générique pour les personnages humains
 * @author Ulysse
 */
public abstract class Personnage extends Creature {

    private String nom;
    private final static String[] noms = new String[]{"Alphonse", "Clovis", "Aude", "Hubert", "Bertille", "Paulin", "Rainier", "Isaure", "Enguerrand", "Neven"};
    private Epee arme;

    /**
     * Initialise un Personnage comme copie d'un autre Personnage
     *
     * @param p personnage initial
     */
    public Personnage(Personnage p) {
        super(p);
        this.nom = p.getNom();
        this.arme = p.getArme();
    }

    /**
     * Initialise un Personnage en spécifiant tous ses attributs
     *
     * @param n nom
     * @param pV points de vie
     * @param dA dégâts d'attaque
     * @param pPar points de parade
     * @param paAtt pourcentage d'attaque
     * @param paPar pourcentage de parade
     * @param dMax distance d'attaque maximale
     * @param vitesse vitesse de déplacement
     * @param pt point
     */
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, int vitesse, Point2D pt) {
        super(pV, dA, pPar, paAtt, paPar, dMax, vitesse,  pt);
        this.nom = n;
    }

    /**
     * Initialise un Personnage aléatoire en spécifiant simplement son nom
     *
     * @param n nom
     */
    public Personnage(String n) {
        super();
        this.nom = n;
    }

    /**
     * Initialise un Personnage aléatoire en un point donné
     *
     * @param x abscisse
     * @param y ordonnée
     */
    public Personnage(int x, int y) {
        super(x, y);
        this.nom = noms[getRandom(9)];
    }

    /**
     * Initialise un Personnage aléatoire en un point donné
     *
     * @param p
     */
    public Personnage(Point2D p) {
        super(p);
        this.nom = noms[getRandom(9)];
    }

    /**
     * Initialise un Personnage aléatoire
     */
    public Personnage() {
        super();
        this.nom = noms[getRandom(9)];
    }

    /**
     * Récupère le nom du personnage
     *
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Redéfinit le nom du personnage
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Déplace le personnage de manière déterminée.
     *
     * @param dx décalage abscisse
     * @param dy décalage ordonnée
     */
    public void deplace(int dx, int dy) {
        this.pos.translate(dx, dy);
    }

    /**
     * Affiche le nom
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("Il s'agit de " + nom + ". ");
    }

    /**
     * Récupère l'arme tenue par le personnage
     *
     * @return
     */
    public Epee getArme() {
        return arme;
    }

    /**
     * Définit l'arme portée par le personnage
     *
     * @param arme
     */
    public void setArme(Epee arme) {
        this.arme = new Epee(arme);
    }

    /**
     * Convertit le personnage en son nom en tant que String, pour l'affichage
     * en console
     *
     * @return nom
     */
    @Override
    public String toString() {
        return this.getNom();
    }
}
