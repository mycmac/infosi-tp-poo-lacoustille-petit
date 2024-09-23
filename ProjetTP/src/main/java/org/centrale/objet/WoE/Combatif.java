package org.centrale.objet.WoE;

/**
 * Créature disposant d'un moyen d'attaquer les autres
 *
 * @author hanss
 */
public interface Combatif {

    /**
     * Attaque une autre créature
     * @param c Créature à attaquer
     */
    public void combattre(Creature c);
}
