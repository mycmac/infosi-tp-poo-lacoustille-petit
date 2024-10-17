package org.centrale.objet.WoE;

public interface Recuperable {
    /**
     * Comportement de l'objet lorsqu'il est récupéré par un personnage
     * 
     * @param p Personnage
     */
    public abstract void recuperer(Joueur j);
}
