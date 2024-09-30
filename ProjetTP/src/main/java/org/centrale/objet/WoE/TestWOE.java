package org.centrale.objet.WoE;

import java.util.Iterator;

/**
 *
 * @author Ulysse
 */
public class TestWOE {

    public static void main(String[] args) {
        World WoE;
        WoE = new World(50);
        long debut = System.nanoTime();
        WoE.creeMondeAlea();
        long fin = System.nanoTime();
        System.out.println("Temps de création : "+(fin-debut)+" ns");
        //Creature[][] creature = new Creature[12][12];
        //System.out.println(creature[5][5]);
        //creature[6][3].affiche();
        System.out.println("Nombre de créatures : "+WoE.getCreatures().size());
        // Parcours de la liste de creatures par index
        int totalPV = 0;
        long debutIn = System.nanoTime();
        for (int i = 0;i<WoE.getCreatures().size();i++){
            totalPV += WoE.getCreatures().get(i).getPtVie();
        }
        long finIn = System.nanoTime();
        System.out.println("Total de PV "+totalPV+" en "+(finIn-debutIn)+" nanosecondes par index");
        // Parcours par itérateurs
        int totalPV2 = 0;
        long debutIt = System.nanoTime();
        Iterator<Creature> creatureP = WoE.getCreatures().iterator();
        while (creatureP.hasNext()){
            totalPV2 += creatureP.next().getPtVie();
        }
        long finIt = System.nanoTime();
        System.out.println("Total de PV "+totalPV2+" en "+(finIt-debutIt)+" nanosecondes par itérateur");
    }
}