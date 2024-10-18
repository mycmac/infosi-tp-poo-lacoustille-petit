package org.centrale.objet.WoE;

/**
 * Interface régissant le comportement des elements de jeu qui peuvent se déplacer
 * @author Ulysse
 */
public interface Deplacable {

    /**
     * Déplace la créature aléatoirement
     * @param grille Grille sur laquelle elle se déplace
     */
    public void deplace(Creature[][] grille);

    /**
     * Déplace la créature à un endroit donné
     * @param grille Grille sur laquelle elle se déplace
     * @param p Endroit où elle va
     */
    public void deplace(Creature[][] grille, Point2D p);
}
