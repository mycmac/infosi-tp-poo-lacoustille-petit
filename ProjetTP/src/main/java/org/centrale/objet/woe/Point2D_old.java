/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class Point2D {
    int x;
    int y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point2D() {
    }
    public Point2D(Point2D p){
        this.x = p.getX();
        this.y = p.getY();
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }
    public void affiche(){
        System.out.println("["+x+" ; "+y+"]");
    }
    public double distance(Point2D p2){
        int dx = Math.abs(this.x - p2.getX());
        int dy = Math.abs(this.y - p2.getY());
        int dz2 = dx*dx + dy*dy;
        return Math.sqrt(dz2);
    }
    
    @Override
    public String toString(){
        return "["+x+" ; "+y+"]";
    }
}
