package org.centrale.objet.WoE;

/**
 *
 * @author Ulysse
 */
public class TestWOE {

    public static void main(String[] args) {
        World WoE;
        WoE = new World();
        long debut = System.nanoTime();
        WoE.creeMondeAlea(50);
        long fin = System.nanoTime();
        System.out.print("Temps de création : "+(fin-debut)+" ns");
    }
}