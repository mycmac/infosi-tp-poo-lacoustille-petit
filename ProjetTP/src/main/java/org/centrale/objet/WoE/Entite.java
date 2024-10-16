package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Super classe dans le monde de WoE pour gérer toutes les entités (créatures et objets)
 * @author timot
 */
public abstract class Entite {
    
    /**
     * Position de l'Entite
     */
    protected Point2D pos;
    /**
     * Générateur aléatoire liée à l'Entite
     */
    private final Random r = new Random();
    
    /**
     * Crée une copie de l'Entite e
     * @param e Entite
     */
    public Entite(Entite e) {
        this.pos = new Point2D(e.getPos());
    }
    
    /**
     * Initialise une Entite à partir d'attributs donnés
     * @param pt Position
     */
    public Entite(Point2D pt) {
        this.pos = new Point2D(pt);
    }
    
    /**
     * Initialise une Entite à partir d'attributs donnés
     * @param x abscisse
     * @param y ordonnée
     */
    public Entite(int x, int y) {
        this.pos = new Point2D(x, y);
    }
    
    /**
     * Initialise une Entite à une position aléatoire
     */
    public Entite() {
        this.pos = new Point2D();
    }
    
    /**
     * Récupère la position de l'Entite
     * @return 
     */
    public Point2D getPos() {
        return this.pos;
    }

    /**
     *
     * @return Coordonée X
     */
    public int getX() {
        return this.pos.getX();
    }

    /**
     *
     * @return Coordonnée Y
     */
    public int getY() {
        return this.pos.getY();
    }
    
    /**
     * Redéfinit la position de l'Entite
     * @param pos Position souhaitée
     */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    /**
     * Redéfinit la position de l'Entite
     * @param x Abscisse souhaitée
     * @param y Ordonnée souhaitée
     */
    public void setPos(int x, int y) {
        this.pos = new Point2D(x, y);
    }

    /**
     *
     * @param x Coordonnée X
     */
    public void setX(int x) {
        this.pos.setX(x);
    }

    /**
     *
     * @param y Coordonnée Y
     */
    public void setY(int y) {
        this.pos.setY(y);
    }

    /**
     * Renvoie un nombre aléatoire depuis le générateur aléatoire de la créature
     *
     * @param n Borne supérieure (non incluse)
     * @return Nombre aléatoire entre 0 et n
     */
    public int getRandom(int n) {
        return r.nextInt(n);
    }
    
    /**
     * Calcule la distance à un endroit
     * @param pt Point sur la carte
     * @return Distance entre l'entité et le point pt
     */
    public double distance(Point2D pt) {
        return this.pos.distance(pt);
    }
    
    /**
     * Calcule la distance à une autre entité
     * @param e entité
     * @return Distance avec l'entité e
     */
    public double distance(Entite e) {
        return this.pos.distance(e.pos);
    }
}