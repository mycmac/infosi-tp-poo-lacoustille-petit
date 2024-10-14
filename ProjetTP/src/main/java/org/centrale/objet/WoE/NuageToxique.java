/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class NuageToxique extends Objet implements Deplacable, Combatif {
    private int toxicite;

    public NuageToxique(int toxicite, int x, int y) {
        super(x, y);
        this.toxicite = toxicite;
    }

    public NuageToxique(int toxicite, Point2D pos) {
        super(pos);
        this.toxicite = toxicite;
    }

    public int getToxicite() {
        return toxicite;
    }

    public void setToxicite(int toxicite) {
        this.toxicite = toxicite;
    }

    @Override
    public void deplace(Creature[][] grille) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deplace(Creature[][] grille, Point2D p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void combattre(Creature c) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
