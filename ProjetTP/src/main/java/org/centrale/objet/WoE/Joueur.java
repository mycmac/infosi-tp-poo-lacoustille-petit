package org.centrale.objet.WoE;

//import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ulysse
 */
public class Joueur {
    //private final Reflections reflections = new Reflections("org.centrale.objet.WoE");
    //private final Set<Class<?>> classesJouables = ;
    private Personnage perso;

    public void Joueur(Personnage p) {
        perso = p;
    }
    
    public void Joueur() {
        System.out.println("Quelle type de personnage veux-tu jouer ?");
        //for (int i = 1; i<classesJouables.size(); i++) {
        //    System.out.println(" • " + i + " - " + classesJouables[i-1].getc);
        //}
    }
        
    public void deplacePerso() {
        while (!Clavier.isPressed()) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int[] dep = deplacement(Clavier.pressedKey());
        perso.deplace(dep[0], dep[1]);
    }

    public int[] deplacement(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            return (new int[]{0, 1});
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            return (new int[]{0, -1});
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            return (new int[]{1, 0});
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            return (new int[]{-1, 0});
        } else {
            return (new int[]{0, 0});
        }
    }
}
