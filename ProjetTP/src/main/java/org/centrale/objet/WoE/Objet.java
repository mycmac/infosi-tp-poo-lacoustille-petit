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
public abstract class Objet extends Entite{
   
    public Objet(){
        super(new Point2D(), false);
    }
    
    public abstract void recuperer(Personnage p);
}
