/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class Guerrier extends Personnage {

    /**
     * Créé un guerrier
     * @param n nom
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar dégats parés
     * @param paAtt pourcentage de réussite d'attaque
     * @param paPar pourcentage de réussite de parade
     * @param dMax distance attaque maximale
     * @param p Position
     */
    public Guerrier(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
    }

    /**
     * Copie le guerrier p
     * @param p
     */
    public Guerrier(Personnage p) {
        super(p);
    }

    /**
     * Guerrier aléatoire
     */
    public Guerrier() {
    }
    
    public void combattre(Creature c) {
        System.out.println("Paf !");
    }
}
