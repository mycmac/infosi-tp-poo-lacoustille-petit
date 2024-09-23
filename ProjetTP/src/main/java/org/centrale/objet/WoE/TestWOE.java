package org.centrale.objet.WoE;

import java.util.Iterator;

/**
 *
 * @author Ulysse
 */
public class TestWOE {

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
        WoE.grosBill.setPtVie(100);
        WoE.wolfie.setDegAtt(10);
        WoE.grosBill.setPtPar(5);
        System.out.println("Attaque du loup " + WoE.wolfie.getDegAtt());
        System.out.println("Défense de GB " + WoE.grosBill.getPtPar());
        WoE.grosBill.setNom("Gros Bill");
        System.out.println("\nCombat !");
        WoE.wolfie.combattre(WoE.grosBill);
        WoE.grosBill.setPos(WoE.wolfie.getPos());
        WoE.grosBill.deplace(1,0);
        for (int i = 1; i < 11; i++) {
            WoE.grosBill.affiche();
            WoE.wolfie.combattre(WoE.grosBill);
        }
        WoE.grosBill.affiche();
        WoE.robin.setPtVie(30);
        WoE.robin.affiche();
        System.out.println("Positions objets : ");
        for (Objet o : WoE.objets) {
            System.out.println(o.getPos());
        }
        WoE.robin.setPos(WoE.objets.get(1).getPos());
        WoE.objets.get(1).recuperer(WoE.robin);
        WoE.robin.setPos(WoE.objets.get(2).getPos());
        WoE.objets.get(2).recuperer(WoE.robin);
        WoE.robin.affiche();
        System.out.println("Positions objets récupérés : ");
        System.out.println(WoE.objets.get(1).getPos());
        System.out.println(WoE.objets.get(2).getPos());
        // Parcours de la liste pour supprimer les objets récupérés.
        Iterator<Objet> listIt = WoE.objets.iterator();

        while (listIt.hasNext()) {
            Objet p = listIt.next();
            if (p.getPos() == null) {
                listIt.remove();
            }
        }
        System.out.println("Positions objets : ");
        for (Objet o : WoE.objets) {
            System.out.println(o.getPos());
        }
    }
}
