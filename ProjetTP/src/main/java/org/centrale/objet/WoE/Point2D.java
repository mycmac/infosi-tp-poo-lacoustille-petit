/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;
/**
 *
 * @author Ulysse
 */
public class Point2D {
    /**
     * Limites (incluses) de positions initiales aléatoires
     * 
     * /!\ Ces valeurs ne sont pas (encore) testées comme conditions de création
     */
    private final int xmin = -20;
    private final int xmax = 20;
    private final int ymin = -20;
    private final int ymax = 20;
    
    /**
     * Abscisse
     */
    int x;
    /**
     * Ordonnée
     */
    int y;
    
    /**
     * Initialise un Point2D en spécifiant son abscisse et son ordonnée
     * @param x Abscisse souhaitée
     * @param y Ordonnée souhaitée
     */
    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Initialise un Point2D en copiant les coordonnées d'un Point2D donné
     * @param p 
     */
    public Point2D(Point2D p){
        this.x = p.getX();
        this.y = p.getY();
    }
    
    /**
     * Initialise un Point2D de manière aléatoire, au sein des limites fixées
     */
    public Point2D() {
        Random r = new Random();
        this.x = r.nextInt(xmax - xmin + 1) + xmin;
        this.y = r.nextInt(ymax - ymin + 1) + ymin;
    }
    
    /**
     * Récupère l'abscisse du Point2D
     * @return x : Abscisse
     */
    public int getX() {
        return x;
    }
    
    /**
     * Récupère l'ordonnée du Point2D
     * @return y : Ordonnée
     */
    public int getY() {
        return y;
    }
    
    /**
     * Redéfinit l'abscisse du Point2D
     * @param x : Abscisse cible
     */
    public void setX(int x) {
        this.x = x;
    }
    
    /**
     * Redéfinit l'ordonnée du Point2D
     * @param y  : Ordonnée cible
     */
    public void setY(int y) {
        this.y = y;
    }
    
    /**
     * Modifie le Point2D
     * @param x
     * @param y 
     */
    public void setPosition(int x, int y) {
        setX(x);
        setY(y);
    }
    
    /**
     * Effectue la translation du Point2D
     * @param dx Déplacement en x
     * @param dy Déplacement en y
     */
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    
    /**
     * Transcrit le Point2D en une chaîne de caractères
     * @return [x ; y]
     */
    @Override
    public String toString(){
        return "["+x+" ; "+y+"]";
    }
    
    /**
     * Affiche le Point2D dans la console
     */
    public void affiche(){
        System.out.println(this.toString());
    }
    
    /**
     * Calcule la distance entre le Point2D et un autre Point2D
     * @param p2 Point à comparer
     * @return d = sqrt(x^2 + y^2)
     */
    public double distance(Point2D p2){
        int dx = this.x - p2.getX();
        int dy = this.y - p2.getY();
        int dz2 = dx*dx + dy*dy;
        return Math.sqrt(dz2);
    }
}
