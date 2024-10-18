/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class woe {

    public static void main(String[] args) {
        World WoE;
        WoE = new World(20);
        WoE.creeMondeAlea();
        while (true) {
            WoE.tourDeJeu();
            WoE.afficheWorld();
        }

    }
}
