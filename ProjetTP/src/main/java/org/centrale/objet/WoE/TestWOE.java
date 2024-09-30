package org.centrale.objet.WoE;

import java.util.Iterator;

/**
 *
 * @author Ulysse
 */
public class TestWOE {

    public static void main(String[] args) {
        World WoE;
        WoE = new World(2000);
        long debut = System.nanoTime();
        WoE.creeMondeAlea();
        long fin = System.nanoTime();
        System.out.println("Temps de création : "+(fin-debut)+" ns");
        //Creature[][] creature = new Creature[12][12];
        //System.out.println(creature[5][5]);
        //creature[6][3].affiche();
        
        WoE.afficheWorld();
        */
        
        WoE = new World(5);
        WoE.addCreature(new Archer(), 0, 0);
        WoE.addCreature(new Guerrier(), 0, 1);
        WoE.addCreature(new Paysan(), 0, 2);
        WoE.addCreature(new Lapin(), 0, 3);
        WoE.addCreature(new Loup(), 0, 4);
        WoE.afficheWorld();
        
        // Test de la génération aléatoire d'entites
        Iterator<Creature> creatureP = WoE.getCreatures().iterator();
        int[] crea_crees = {0, 0, 0, 0, 0};
        Creature c;
        while (creatureP.hasNext()){
            c = creatureP.next();
            if (c instanceof Archer) {
                crea_crees[0] ++;
            } else if (c instanceof Guerrier) {
                crea_crees[1] ++;
            } else if (c instanceof Paysan) {
                crea_crees[2] ++;
            } else if (c instanceof Lapin) {
                crea_crees[3] ++;
            } else {
                crea_crees[4] ++;
            }
        }
        System.out.print("Le monde aléatoire a été créé avec "
                +crea_crees[0]+" Archers, "
                +crea_crees[1]+" Guerriers, "
                +crea_crees[2]+" Paysans, "
                +crea_crees[3]+" Lapins et "
                +crea_crees[4]+" Loups !\n");
        
        Iterator<Objet> objetP = WoE.getObjets().iterator();
        int[] obj_crees = {0, 0};
        Objet o;
        while (objetP.hasNext()){
            o = objetP.next();
            if (o instanceof Epee) {
                obj_crees[0] ++;
            } else {
                obj_crees[1] ++;
            }
        }
        System.out.print("Il contient aussi "
                +obj_crees[0]+" Epees et "
                +obj_crees[1]+" PotionSoins !\n");
        
        
        
        System.out.println("Nombre de créatures : "+WoE.getCreatures().size());
        
        // Parcours par itérateurs
        int totalPV2 = 0;
        long debutIt = System.nanoTime();
        creatureP = WoE.getCreatures().iterator();
        while (creatureP.hasNext()){
            totalPV2 += creatureP.next().getPtVie();
        }
        long finIt = System.nanoTime();
        System.out.println("Total de PV "+totalPV2+" en "+(finIt-debutIt)+" nanosecondes par itérateur");
        // Parcours de la liste de creatures par index
        int totalPV = 0;
        long debutIn = System.nanoTime();
        for (int i = 0;i<WoE.getCreatures().size();i++){
            totalPV += WoE.getCreatures().get(i).getPtVie();
        }
        long finIn = System.nanoTime();
        System.out.println("Total de PV "+totalPV+" en "+(finIn-debutIn)+" nanosecondes par index");
    }
}
