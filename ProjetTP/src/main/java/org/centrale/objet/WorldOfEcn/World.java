/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WorldOfEcn;

import java.util.Random;

/**
 *
 * @author hanss
 */
public class World {

    Archer robin;
    Paysan peon;
    Lapin bugs;
    Lapin bunny;

    public World() {
        robin = new Archer();
        peon = new Paysan();
        bugs = new Lapin();
        bunny = new Lapin();
    }

    public void creeMondeAlea() {
        Random r = new Random();
        Entite[] gens = new Entite[4];
        gens[0] = robin;
        gens[1] = peon;
        gens[2] = bugs;
        gens[3] = bunny;
        int[] coox = new int[4];
        int[] cooy = new int[4];
        for (int i = 0; i < 4;i++) {
            int x = 0;
            int y = 0;
            boolean pris = true;
            while (pris) {
                pris = false;
                x = r.nextInt(15);
                y = r.nextInt(15);
                for (int j = 0; j < i;j++) {
                    if (coox[j] == x && cooy[j] == y) {
                        pris = true;
                    }
                }
            }
            gens[i].setPos(x, y);
            gens[i].affiche();
            
        }
        
    }

}
