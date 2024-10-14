package org.centrale.objet.WoE;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.Integer;
import java.util.Scanner;
import org.reflections.Reflections;
import java.util.concurrent.TimeUnit;

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
    public void actionDeplacement(World monde) {
        for (int i = 0; i < ((Personnage) perso).getVitesse(); i++) {
            deplacePerso(monde.getGrille_creatures());
            Objet o = monde.getGrille_objets()[((Personnage) perso).getX()][((Personnage) perso).getY()];
            if (o != null) {
                o.recuperer(((Personnage) perso));
                monde.getGrille_objets()[((Personnage) perso).getX()][((Personnage) perso).getY()] = null;
                monde.cleanEntites(monde.getObjets());
            }
            monde.afficheWorld();
        }
    }

    public void deplacePerso(Creature[][] grille) {
        while (!Fenetre.isPressed()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        int[] dep = deplacement();
        ((Personnage) perso).deplace(grille, dep[0], dep[1]);
        while (Fenetre.isPressed()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    public int[] deplacement() {
        KeyEvent event = Fenetre.pressedKey();
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
        return ((Personnage) perso);
    }

    public void setPerso(Personnage perso) {
        this.perso = (Jouable) perso;
    }

}
