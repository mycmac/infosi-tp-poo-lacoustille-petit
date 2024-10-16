/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class Nourriture extends Objet implements Utilisable, Recuperable {
    @Override
    public void recuperer(Personnage p) {
        // p.ajoutInventaire();
        this.pos = null;
    }
}
