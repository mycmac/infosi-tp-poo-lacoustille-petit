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

    public void deplacePerso(Creature[][] grille) {
        while (!Clavier.isPressed()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int[] dep = deplacement();
        perso.deplace(grille, dep[0], dep[1]);
        while (Clavier.isPressed()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int[] deplacement() {
        KeyEvent event = Clavier.pressedKey();
        switch (event.getKeyCode()) {
            case KeyEvent.VK_UP:
                return (new int[]{-1, 0});
            case KeyEvent.VK_DOWN:
                return (new int[]{1, 0});
            case KeyEvent.VK_RIGHT:
                return (new int[]{0, 1});
            case KeyEvent.VK_LEFT:
                return (new int[]{0, -1});
            default:
                return (new int[]{0, 0});
        }
    }

    public Personnage getPerso() {
        return perso;
    }

    public void setPerso(Personnage perso) {
        this.perso = perso;
    }

}
