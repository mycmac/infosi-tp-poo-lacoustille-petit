/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class Lapin extends Monstre {

    public Lapin(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    public Lapin(Lapin p) {
        super(p);
    }

    public Lapin() {
        super();
    }
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("Et non, c'est un lapin.");
    }
}
