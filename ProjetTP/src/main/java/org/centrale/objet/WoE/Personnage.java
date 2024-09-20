/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class Personnage extends Creature {

    private String nom;
    private int distAttMax;
    private static String[] noms = new String[] {"Alphonse", "Clovis", "Aude", "Hubert", "Bertille", "Paulin", "Rainier", "Isaure", "Enguerrand", "Neven"};

    /**
     *
     * @param n
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param dMax
     * @param pt
     */
    public Personnage(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D pt) {
        super(pV, dA, pPar, paAtt, paPar, pt);
        nom = n;
        distAttMax = dMax;
    }

    /**
     *
     * @param p
     */
    public Personnage(Personnage p) {
        super(p);
        nom = p.getNom();
        distAttMax = p.getDistAttMax();
    }

    /**
     * Initialise un personnage aléatoire
     */
    public Personnage() {
        super();
        nom = noms[getRandom(9)];
        distAttMax = getRandom(8);
    }
    
    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return distance maximale d'attaque
     */
    public int getDistAttMax() {
        return distAttMax;
    }

    /**
     * Définit la distance d'attaque maximale
     * @param distAttMax
     */
    public void setDistAttMax(int distAttMax) {
        this.distAttMax = distAttMax;
    }

    /**
     * 
     * Déplace le personnage de manière déterminée.
     * @param dx
     * @param dy
     */
    public void deplace(int dx, int dy) {
        this.pos.translate(dx, dy);
    }

    /**
     * 
     * Déplace aléatoirement le personnage selon l'une des 8 directions 
     *    7   0   1
     *     \  |  /
     *      \ | /
     *  6---- + ----2
     *      / | \
     *     /  |  \
     *    5   4   3
     */
    @Override
    public void deplace() {
        int dir = getRandom(8);
        switch (dir) {
            case 0:
                this.pos.translate(0, 1);
                break;
            case 1:
                this.pos.translate(1, 1);
                break;
            case 2:
                this.pos.translate(1, 0);
                break;
            case 3:
                this.pos.translate(1, -1);
                break;
            case 4:
                this.pos.translate(0, -1);
                break;
            case 5:
                this.pos.translate(-1, -1);
                break;
            case 6:
                this.pos.translate(-1, 0);
                break;
            case 7:
                this.pos.translate(-1, 1);
                break;

        }

    }

    /**
     * Affiche le nom
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("Il s'agit de "+nom+". ");
    }
}
