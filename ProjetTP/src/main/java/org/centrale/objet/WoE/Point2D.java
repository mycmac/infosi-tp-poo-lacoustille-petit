package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Implémente un point sur une grille en 2 dimensions
 * 
 * Exemple : P(x = 3, y = 5)
 * 
 *     y
 *     0 1 2 3 4 5 6 ...
 * x 0
 *   1
 *   2
 *   3           P
 *   4
 *   .
 *   .
 *   .
 * 
 * @author Ulysse
 */
public class Point2D {

    /**
     * Limites (incluses) de positions initiales aléatoires
     *
     * /!\ Ces valeurs ne sont pas (encore) testées comme conditions de
     * création
     */
    private static final int XMAX = 25;
    private static final int YMAX = 25;

    /**
     * Abscisse
     */
    int x;
    /**
     * Ordonnée
     */
    int y;
    
    /**
     * Initialise un Point2D en copiant les coordonnées d'un Point2D donné
     *
     * @param p
     */
    public Point2D(Point2D p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    /**
     * Initialise un Point2D en spécifiant son abscisse et son ordonnée
     *
     * @param x Abscisse souhaitée
     * @param y Ordonnée souhaitée
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Initialise un Point2D aléatoire entre {0,0} et {t-1,t-1}
     * @param t
     */
    public Point2D(int t) {
        Random r = new Random();
        this.x = r.nextInt(t);
        this.y = r.nextInt(t);
    }

    /**
     * Initialise un Point2D vide
     */
    public Point2D() {
    }

    /**
     * Initialise un point2D aléatoire 
     */
    public void randomPoint2D() {
        Random r = new Random();
        this.x = r.nextInt(XMAX);
        this.y = r.nextInt(YMAX);
    }

    /**
     * Récupère l'abscisse du Point2D
     *
     * @return x : Abscisse
     */
    public int getX() {
        return x;
    }

    /**
     * Récupère l'ordonnée du Point2D
     *
     * @return y : Ordonnée
     */
    public int getY() {
        return y;
    }

    /**
     * Redéfinit l'abscisse du Point2D
     *
     * @param x : Abscisse cible
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Redéfinit l'ordonnée du Point2D
     *
     * @param y : Ordonnée cible
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Modifie le Point2D
     *
     * @param x
     * @param y
     */
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }

    /**
     * Effectue la translation du Point2D
     *
     * @param dx Déplacement en x
     * @param dy Déplacement en y
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    /**
     * Effectue la translation du Point2D de vecteur de déplacement p
     *
     * @param p Point2D vecteur de déplacement
     */
    public void translate(Point2D p) {
        this.x += p.getX();
        this.y += p.getY();
    }

    /**
     * Transcrit le Point2D en une chaîne de caractères
     *
     * @return [x ; y]
     */
    @Override
    public String toString() {
        return "[" + this.x + " ; " + this.y + "]";
    }

    /**
     * Affiche le Point2D dans la console
     */
    public void affiche() {
        System.out.println(this.toString());
    }

    /**
     * Calcule la distance entre le Point2D et un autre Point2D
     *
     * @param p2 Point à comparer
     * @return d = sqrt(x^2 + y^2)
     */
    public double distance(Point2D p2) {
        int dx = this.x - p2.getX();
        int dy = this.y - p2.getY();
        int dz2 = dx * dx + dy * dy;
        return Math.sqrt(dz2);
    }

    @Override
    public boolean equals(Object p2) {
        if (p2 == this) {
            return true;
        } else if (p2 == null) {
            return false;
        } else if (!(p2 instanceof Point2D)) {
            return false;
        } else if (((Point2D) p2).getX() == this.getX() && ((Point2D) p2).getY() == this.getY()) {
            return true;
        } else {
            return false;
        }
    }
}
