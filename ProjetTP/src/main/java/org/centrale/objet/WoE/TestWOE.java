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
        long debut = System.nanoTime();
        WoE.creeMondeAlea();
        long fin = System.nanoTime();
    }
}