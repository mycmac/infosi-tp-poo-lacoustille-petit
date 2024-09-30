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
     * Décrit si l'Entite empêche un déplacement sur sa position <br>
     * Permet d'éviter la présence de 2 créatures sur la même case
     */
    private boolean bloquant;
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
        this.bloquant = e.isBloquant();
    }
    
    /**
     * Initialise une Entite à partir d'attributs donnés
     * @param pt Position
     * @param blq Bloquant ou non
     */
    public Entite(Point2D pt, boolean blq) {
        this.pos = new Point2D(pt);
        this.bloquant = blq;
    }
    
    /**
     * Initialise une Entite à une position aléatoire, sachant seulement si elle est bloquante ou non
     * @param blq Bloquant ou non
     */
    public Entite(boolean blq) {
        this.pos = new Point2D();
        this.bloquant = blq;
    }
    
    /**
     * Récupère la position de l'Entite
     * @return 
     */
    public Point2D getPos() {
        return this.pos;
    }

    public int getX() {
        return this.pos.getX();
    }

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

    public void setX(int x) {
        this.pos.setX(x);
    }

    public void setY(int y) {
        this.pos.setY(y);
    }
    
    /**
     * Vérifie si l'Entite est bloquante
     * @return 
     */
    public boolean isBloquant() {
        return this.bloquant;
    }
    
    /**
     * Redéfinit si l'Entite est bloquante
     * @param bloquant 
     */
    public void setBloquant(boolean bloquant) {
        this.bloquant = bloquant;
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