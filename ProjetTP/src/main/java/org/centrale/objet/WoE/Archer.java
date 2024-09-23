/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe archer : personnage disposant de flèches
 * @author Ulysse
 */
public class Archer extends Personnage implements Combatif{

    private int nbFleches;

    /**
     * Initialise un archer
     * @param n nom
     * @param pV points de vie
     * @param dA distance d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussir une attaque
     * @param paPar probabilité de réussir une parade
     * @param dMax distance d'attaque maximale
     * @param p position (Point2D)
     * @param nbFl nombre de flèches
     */
    public Archer(String n, int pV, int dA, int pPar, int paAtt, int paPar, int dMax, Point2D p, int nbFl) {
        super(n, pV, dA, pPar, paAtt, paPar, dMax, p);
        nbFleches = nbFl;
    }

    /**
     * Crée un archer identique à l'archer a
     * @param a Archer à copier
     */
    public Archer(Archer a) {
        super(a);
        nbFleches = a.getNbFleches();
    }

    /**
     * Génère un archer aléatoire
     */
    public Archer() {
        super();
        nbFleches = getRandom(17);
    }
    
    /**
     * 
     * @return nombre de flèches
     */
    public int getNbFleches() {
        return nbFleches;
    }

    /**
     * Modifie le nombre de flèches d'un archer
     * @param nbFleches nombre de fleches
     */
    public void setNbFleches(int nbFleches) {
        this.nbFleches = nbFleches;
    }

    /**
     * Affiche des informations sur l'archer
     */
    @Override
    public void affiche() {
        super.affiche();
        System.out.print(this.getNom()+" maîtrise l'archerie et a " + getNbFleches() + " flèches. ");
    }
    
    /**
     * Combattre une créature désignée
     * @param c 
     */
    public void combattre(Creature c) {
        System.out.println("Piew");
    }
    
}
