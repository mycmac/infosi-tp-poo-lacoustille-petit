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
        System.out.println("\n Combat !");
        WoE.grosBill.combattre(WoE.wolfie);
        WoE.wolfie.combattre(WoE.robin);
        WoE.robin.setPtVie(30);
        WoE.robin.affiche();
        System.out.println("Positions objets : ");
        for (Objet o : WoE.objets){
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
        
        while(listIt.hasNext()){
            Objet p = listIt.next();
            if (p.getPos()==null){
               listIt.remove();
            }
        }
        System.out.println("Positions objets : ");
        for (Objet o : WoE.objets){
        System.out.println(o.getPos());
        }
    }
}
