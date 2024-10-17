/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public interface Jouable {

    /**
     * Déplace de manière donnée une créature jouable
     * @param grille grille de déplacement
     * @param dx déplacement X
     * @param dy déplacement Y
     */
    public void deplace(Creature[][] grille, int dx, int dy);
    
}
