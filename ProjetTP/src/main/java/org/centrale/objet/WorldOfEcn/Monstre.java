/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WorldOfEcn;

/**
 *
 * @author hanss
 */
public class Monstre extends Entite{

    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    public Monstre(Monstre p) {
        super(p);
    }

    public Monstre() {
        super();
    }
    
    @Override
    public void deplace() {
        
    }
    
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("C'est un monstre! ");
    }
}
