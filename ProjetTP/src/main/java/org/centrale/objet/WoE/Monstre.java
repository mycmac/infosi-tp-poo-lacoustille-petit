/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Creature de type monstre
 * @author hanss
 */
public class Monstre extends Creature{

    /**
     * Créé un monstre à partir de paramètres donnés (voir org.centrale.objet.WoE.Creature.Creature())
     * @param pV
     * @param dA
     * @param pPar
     * @param paAtt
     * @param paPar
     * @param p
     */
    public Monstre(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    /**
     * Recopie le monstre p
     * @param p
     */
    public Monstre(Monstre p) {
        super(p);
    }

    /**
     * Créé aléatoirement un monstre (voir Creature)
     */
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
