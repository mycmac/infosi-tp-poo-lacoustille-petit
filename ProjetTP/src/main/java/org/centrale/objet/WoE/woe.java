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
        int taille;
        try{
            taille = Integer.parseInt(args[0]);
        }catch (NullPointerException | NumberFormatException e){
            taille = 20;
        }
        World WoE;
        WoE = new World(taille);
        WoE.creeMondeAlea();
        Fenetre.Initialize(WoE.getTaille());
        Fenetre.addMessage("Bienvenue dans World Of ECN !");
        while (true) {
            WoE.tourDeJeu();
            WoE.afficheWorld();
        }

    }
}
