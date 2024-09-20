/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class TestWOE{

    public static void main(String[] args) {
        World WoE;
        WoE = new World();
        WoE.creeMondeAlea();
        WoE.robin.setNom("Robin des bois");
        WoE.robin.affiche();
        WoE.robin.deplace();
        WoE.robin.affiche();
        WoE.peon.setNom("Peon");
        WoE.peon.affiche();
        WoE.peon.deplace();
        WoE.peon.affiche();
        WoE.bugs.affiche();
        WoE.bugs.deplace();
        WoE.bugs.affiche();
        WoE.guillaumeT = new Archer(WoE.robin);
        WoE.guillaumeT.setNom("Guillaume Tell");
        WoE.guillaumeT.affiche();
        WoE.robin.affiche();
        WoE.robin.deplace();
        WoE.guillaumeT.affiche();
        WoE.robin.affiche();
    }
}
