package org.centrale.objet.WoE;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.Integer;
import java.util.Collection;
import java.util.Scanner;
import org.reflections.Reflections;

/**
 * Classe qui stocke le personnage joué par l'utilisateur avec ses attributs et actions spécifiques
 * @author Ulysse
 */
public class Joueur {
    /**
     * Attribut contenant le personnage du joueur, qui descend de l'interface Jouable
     */
    private Jouable perso;
    private Collection<Utilisable> inventaire;

    /**
     * Constructeur de Joueur avec un personnage prédéfini
     * @param p Personnage choisi
     */
    public Joueur(Jouable p) {
        perso = p;
    }
    
    /**
     * Constructeur de Joueur qui interagit avec l'utilisateur pour choisir le type de personnage et son nom notamment.
     */
    @SuppressWarnings({ "unchecked", "rawtypes" }) // Tkt, le code est correct mais sinon l'IDE fait chier
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
    
    /**
     * Récupère un input utilisateur finissant par la touche entrée
     * @return Dernière ligne entrée par l'utilisateur dans le terminal
     */
    public final String getClavier() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }
    
    /**
     * En partant du principe que l'utilisateur doit entrer un nombre entier, récupère cet entier dans la console
     * @return Entier tapé par l'utilisateur
     */
    public final Integer getClavierInt() {
        Integer res = null;
        while (res == null) {
        
            try {
                res = Integer.valueOf(getClavier());
            } catch(NumberFormatException ex) {
                res = null;
                System.out.println("Veuillez entrer un nombre entier inférieur à " + Integer.MAX_VALUE + "!");
            }
        }
        return res;
    }
    
    /** TODO
     * Déplace le personnage du joueur
     */
    public void deplacePerso() {
    }

    /** 
     * 
     * 
     * TODO : Généraliser à un non Personnage
     * 
     * @param monde
     */
    public void actionDeplacement(World monde) {
        Creature p = (Creature) perso;
        for (int i = 0; i < p.getVitesse(); i++) {
            deplacePerso(monde.getGrille_creatures());
            if (p instanceof Personnage) {
                // TODO : Pour le moment, seul un personnage humain est capable d'utiliser des objets
                Objet o = monde.getGrille_objets()[p.getX()][p.getY()];
                if (o != null && o instanceof Recuperable) {// Autorisé car Java ne test pas la 2e condition d'un && si la première est fausse
                    ((Recuperable) o).recuperer((Personnage) p);
                    monde.getGrille_objets()[p.getX()][p.getY()] = null;
                    monde.cleanEntites(monde.getObjets());
                }
            }
            monde.afficheWorld();
        }
    }

    /**
     * Déplace le personnage associé en utilsant le clavier
     * @param grille grille de déplacement
     */
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

    /**
     * Transforme une touche de clavier en un tuple correspondant au déplacement
     * correspondant sur la carte
     * @return {dX, dY}
     */
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

    /**
     *
     * @return Personnage associé au joueur
     */
    public Personnage getPerso() {
        return ((Personnage) perso);
    }

    /**
     * Modifie le personnage associé au joueur
     * @param perso
     */
    public void setPerso(Personnage perso) {
        this.perso = (Jouable) perso;
    }

}
