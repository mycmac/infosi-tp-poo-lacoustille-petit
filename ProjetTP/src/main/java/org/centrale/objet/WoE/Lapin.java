/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Un Lapin (Monstre)
 *
 * @author hanss
 */
public class Lapin extends Monstre {

    /**
     * Créé un lapin
     *
     * @param n nom
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param p position
     */
    public Lapin(String n, int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        super(pV, dA, pPar, paAtt, paPar, p);
    }

    /**
     * Copie un lapin
     *
     * @param p
     */
    public Lapin(Lapin p) {
        super(p);
    }

    /**
     * Génère un lapin aléatoire (voir {@link org.centrale.objet.WoE.Creature#Creature()}
     */
    public Lapin() {
        super();
    }

    @Override
    public void affiche() {
        super.affiche();
        System.out.print("Et non, c'est un lapin.");
    }
}
