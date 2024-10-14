package org.centrale.objet.WoE;

//import java.util.ArrayList;

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
}
