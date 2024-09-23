/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class Loup extends Monstre implements Combatif{
    
    /**
     * Créé un loup
     *
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param p position
     */
    public Loup(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    public Loup(Monstre p) {
        super(p);
    }

    public Loup() {
    }
    
    /**
     * Combattre une créature désignée
     * @param c 
     */
    public void combattre(Creature c) {
        System.out.println("Grrr");
    }
    
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("C'est un loup terrifiant !");
    }
}
