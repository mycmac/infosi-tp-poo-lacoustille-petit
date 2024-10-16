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

    /**
     * Définit un nuage toxique avec une position donnée et une toxicité donnée
     * @param toxicite Toxicité
     * @param x Position X
     * @param y Position Y
     */
    public NuageToxique(int toxicite, int x, int y) {
        super(x, y);
        this.toxicite = toxicite;
    }

    /**
     * Définit un nuage toxique avec une position donnée et une toxicité donnée
     * @param toxicite Toxicité
     * @param pos Point2D de la position
     */
    public NuageToxique(int toxicite, Point2D pos) {
        super(pos);
        this.toxicite = toxicite;
    }

    /**
     *
     * @return Toxicité du nuage
     */
    public int getToxicite() {
        return toxicite;
    }

    /**
     * Modifie la toxicité du nuage
     * @param toxicite Nouvelle toxicité
     */
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
