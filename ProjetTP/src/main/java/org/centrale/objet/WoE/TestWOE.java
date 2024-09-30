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
        System.out.println("Positions objets : ");
        for (Objet o : WoE.objets) {
            System.out.println(o.getPos());
        }
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