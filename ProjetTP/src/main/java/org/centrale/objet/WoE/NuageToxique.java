/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.ArrayList;

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
        ArrayList<Point2D> deplacementsPossibles = new ArrayList<>();
        for (int i = -1; i<2; i++) {
            for (int j = -1; j<2; j++) {
                int ix = this.getX() + i;
                int jy = this.getY() + j;
                if (ix >= 0 && jy >= 0 && ix < grille.length && jy < grille.length) {
                    if(grille[ix][jy] == null) {
                        deplacementsPossibles.add(new Point2D(i, j));
                    }
                }
            }
        }
        
        int sz = deplacementsPossibles.size();
        if (sz != 0) {
            int dir = this.getRandom(sz);
            Point2D p = deplacementsPossibles.get(dir);
            deplace(grille, p);
        } else {
            System.out.println("Il n'y a pas de vent, ce nuage ne bouge pas");
        }}

    @Override
    public void deplace(Creature[][] grille, Point2D p) {
        this.setPos(p);
    }

    @Override
    public void combattre(Creature c) {
        c.setPtVie(c.getPtVie()-toxicite);
    }
    
}
