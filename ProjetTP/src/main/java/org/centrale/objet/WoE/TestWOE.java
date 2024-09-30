package org.centrale.objet.WoE;

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
    }
}