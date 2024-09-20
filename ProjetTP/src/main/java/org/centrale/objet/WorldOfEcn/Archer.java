/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WorldOfEcn;

/**
 *
 * @author hanss
 */
public class Archer extends Personnage {

    private int nbFleches;

    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFl) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        nbFleches = nbFl;
    }

    public Archer(Archer a) {
        super(a);
        nbFleches = a.getNbFleches();
    }

    public Archer() {
        super();
        nbFleches = getRandom(17);
    }

    public int getNbFleches() {
        return nbFleches;
    }

    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.print(this.getNom()+" maîtrise l'archerie et a " + getNbFleches() + " flèches. ");
    }
}
