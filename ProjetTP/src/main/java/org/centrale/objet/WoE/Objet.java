/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Super-classe pour les objets de WoE
 * 
 * @author timot
 */
public abstract class Objet {
   
    private Point2D pos;
    
    public Objet() {
        
    }
    
    public abstract void recuperer(Personnage p);

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = pos;
    }
    
}