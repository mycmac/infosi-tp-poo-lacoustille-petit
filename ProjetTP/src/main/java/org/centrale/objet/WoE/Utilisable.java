package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public interface Utilisable {

    /**
     * Comportement de l'objet quand il est utilisé
     *
     * @param j Joueur utilisant l'objet
     * @return Potentiel objet ajouté à l'inventaire du joueur
     */
    public Recuperable utiliser(Joueur j);
}
