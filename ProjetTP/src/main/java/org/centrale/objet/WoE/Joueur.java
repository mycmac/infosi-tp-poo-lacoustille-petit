package org.centrale.objet.WoE;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.Integer;
import java.util.Scanner;
import org.reflections.Reflections;

/**
 *
 * @author Ulysse
 */
public class Joueur {
    private Jouable perso;

    public Joueur(Jouable p) {
        perso = p;
    }
    
    public Joueur() {
        try {
            int numClasseJoueur;
            Class<? extends Jouable> classeJoueur = null;

            Boolean satisfait = false;

            Reflections reflections = new Reflections("org.centrale.objet.WoE");
            Object[] classesJouables = reflections.getSubTypesOf(Jouable.class).toArray();
            while (!satisfait) {
                System.out.println("Quelle type de personnage veux-tu jouer ?");
                for (int i = 0; i<classesJouables.length; i++) {
                    System.out.println(" - " + ((int) i+1) + " - " + ((Class) classesJouables[i]).getSimpleName());
                }

                numClasseJoueur = getClavierInt();
                while (numClasseJoueur <= 0 || numClasseJoueur > classesJouables.length) {
                    System.out.println("Choisis un type de personnage valide !");
                    numClasseJoueur = getClavierInt();
                }
                classeJoueur = (Class<? extends Jouable>) classesJouables[numClasseJoueur - 1];

                System.out.println("Tu veux donc jouer un " + classeJoueur.getSimpleName() + " ? Si oui, tape \"Y\".");
                
                if (getClavier().equals("Y")) {
                    satisfait = true;
                }
            }
            perso = (classeJoueur.getDeclaredConstructor().newInstance());
            
        } catch (NoSuchMethodException|
                InstantiationException|
                IllegalAccessException|
                IllegalArgumentException|
                InvocationTargetException e) {
        } 
    }
    
    public final String getClavier() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }
    
    public final Integer getClavierInt() {
        Integer res = null;
        while (res == null) {
        
            try {
                res = Integer.valueOf(getClavier());  // Read user input
            } catch(NumberFormatException ex) {
                res = null;
                System.out.println("Veuillez entrer un nombre entier inférieur à " + Integer.MAX_VALUE + "!");
            }
        }
        return res;
    }
    
    public void deplacePerso() {
        
    }

    public int[] keyTyped(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.VK_UP) {
            return(new int[] {0,1});
        }
        if (event.getKeyCode() == KeyEvent.VK_DOWN) {
            return(new int[] {0,-1});
        }
        if (event.getKeyCode() == KeyEvent.VK_RIGHT) {
            return(new int[] {1,0});
        }
        if (event.getKeyCode() == KeyEvent.VK_LEFT) {
            return(new int[] {-1,0});
        }
        else{
            return(new int[] {0,0});
        }
    }
}
