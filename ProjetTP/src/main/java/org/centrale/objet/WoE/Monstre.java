/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Creature de type monstre
 * @author Ulysse
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
     *
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print("C'est un monstre! ");
    }
}
