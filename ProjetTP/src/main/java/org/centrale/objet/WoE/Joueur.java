package org.centrale.objet.WoE;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.Integer;
import java.util.ArrayList;
import java.util.Scanner;
import org.reflections.Reflections;

/**
 * Classe qui stocke le personnage joué par l'utilisateur avec ses attributs et
 * actions spécifiques
 *
 * @author Ulysse
 */
public class Joueur {

    /**
     * Attribut contenant le personnage du joueur, qui descend de l'interface
     * Jouable
     */
    private Jouable perso;
    /**
     * Inventaire du joueur, qui contient tous les éléments récupérables par le
     * joueur et les stocke dans un tableau
     */
    private ArrayList<Recuperable> inventaire = new ArrayList<>();

    /**
     * Constructeur de Joueur avec un personnage prédéfini
     *
     * @param p Personnage choisi
     */
    public Joueur(Jouable p) {
        perso = p;
    }

    /**
     * Constructeur de Joueur qui interagit avec l'utilisateur pour choisir le
     * type de personnage et son nom notamment.
     */
    //@SuppressWarnings({"unchecked", "rawtypes"}) // Tkt, le code est correct mais sinon l'IDE fait chier
    public Joueur() {
        try {
            int numClasseJoueur;
            Class<? extends Jouable> classeJoueur = null;

            Boolean satisfait = false;

            Reflections reflections = new Reflections("org.centrale.objet.WoE");
            Object[] classesJouables = reflections.getSubTypesOf(Jouable.class).toArray();
            while (!satisfait) {
                System.out.println("Quelle type de personnage veux-tu jouer ?");
                for (int i = 0; i < classesJouables.length; i++) {
                    System.out.println(" - " + ((int) i + 1) + " - " + ((Class) classesJouables[i]).getSimpleName());
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
            ((Creature) perso).setPos(0, 0);
            System.out.println("Personnage créé !");

        } catch (NoSuchMethodException
                | InstantiationException
                | IllegalAccessException
                | IllegalArgumentException
                | InvocationTargetException e) {
            System.out.println("Non" + e + "\n" + e.getLocalizedMessage() + "\n");
            e.printStackTrace();
        }
    }

    /**
     * Récupère un input utilisateur finissant par la touche entrée TODO : Bug
     * lorsque l'on ferme le Scanner, mais il faudrait trouver un moyen
     *
     * @return Dernière ligne entrée par l'utilisateur dans le terminal
     */
    public final String getClavier() {
        Scanner myObj = new Scanner(System.in);
        return myObj.nextLine();
    }

    /**
     * En partant du principe que l'utilisateur doit entrer un nombre entier,
     * récupère cet entier dans la console
     *
     * @return Entier tapé par l'utilisateur
     */
    public final Integer getClavierInt() {
        Integer res = null;
        while (res == null) {

            try {
                res = Integer.valueOf(getClavier());
            } catch (NumberFormatException ex) {
                res = null;
                System.out.println("Veuillez entrer un nombre entier inférieur à " + Integer.MAX_VALUE + "!");
            }
        }
        return res;
    }

    /**
     * Déplace le personnage du joueur dans le monde Gère le ramassage d'objets
     * en passant dessus TODO : Diviser la fonction
     *
     * @param monde
     */
    public void actionDeplacement(World monde) {
        Creature p = (Creature) this.getPerso();
        for (int i = 0; i < p.getVitesse(); i++) {
            deplacePerso(monde);
            Objet o = monde.getGrille_objets()[p.getX()][p.getY()];

            // Autorisé car Java ne test pas la 2e condition d'un && si la première est fausse
            if (o != null && o instanceof Recuperable) {
                ((Recuperable) o).recuperer(this);
                monde.getGrille_objets()[p.getX()][p.getY()] = null;
                monde.cleanEntites(monde.getObjets());
            }

            monde.afficheWorld();
        }
    }

    /**
     * Déplace le personnage associé au joueur en utilisant le clavier TODO:
     * Diviser la fonction
     *
     * @param monde monde de déplacement
     */
    public void deplacePerso(World monde) {
        Creature[][] grille = monde.getGrille_creatures();
        while (!Fenetre.isPressed()) {
            this.wait(100);
        }
        KeyEvent event = Fenetre.pressedKey();
        if (event.getKeyCode() == KeyEvent.VK_SHIFT && this.getPerso().getDistAttMax() > 1.40) {
            Fenetre.addMessage("Choisissez votre cible.");
            monde.setCible(new Point2D(this.getPerso().getPos()));
            deplaceCible(monde);
            if (grille[monde.getCible().getX()][monde.getCible().getY()] != null && grille[monde.getCible().getX()][monde.getCible().getY()] != this.getPerso()) {
                ((Combatif) this.getPerso()).combattre(grille[monde.getCible().getX()][monde.getCible().getY()]);
            }
            Fenetre.addMessage("Combat effectué");
            monde.setCible(null);
            monde.afficheWorld();
        } else if (event.getKeyChar() == KeyEvent.CHAR_UNDEFINED) {

            int[] dep = deplacement(event);
            if ((this.getPerso().getX() + dep[0]) < monde.taille && (this.getPerso().getY() + dep[1]) < monde.taille && grille[this.getPerso().getX() + dep[0]][this.getPerso().getY() + dep[1]] != null && grille[this.getPerso().getX() + dep[0]][this.getPerso().getY() + dep[1]] != this.getPerso()) {
                ((Combatif) this.getPerso()).combattre(grille[this.getPerso().getX() + dep[0]][this.getPerso().getY() + dep[1]]);
                Fenetre.addMessage("Combat rapproché");
            } else {
                (perso).deplace(grille, dep[0], dep[1]);
                Fenetre.addMessage("On se déplace");
            }
        } else if (estChiffre(event.getKeyChar())) {
            int i = Character.getNumericValue(event.getKeyChar());
            Recuperable r = inventaire.get(i);
            if (r instanceof Utilisable) {
                Utilisable u = (Utilisable) r;
                Recuperable result = u.utiliser(this);
                if (result != null) {
                    this.addInventaire(result);
                }
                inventaire.remove(i);
            }
        }
        while (Fenetre.isPressed()) {
            this.wait(100);
        }
    }

    /**
     * Déplace une cible sur l'écran pour viser avec les attaques à distance
     * TODO: Diviser la fonction
     *
     * @param monde
     */
    public void deplaceCible(World monde) {
        boolean shot = false;
        Fenetre.addMessage("Appuyez sur les fleches.");
        while (!shot) {
            while (!Fenetre.isPressed()) {
                this.wait(100);
            }
            KeyEvent event = Fenetre.pressedKey();
            if (event.getKeyCode() == KeyEvent.VK_SPACE && (this.getPerso().getPos().distance(new Point2D(monde.getCible().getX(), monde.getCible().getY()))) <= this.getPerso().getDistAttMax() + 0.01) {
                shot = true;
                Fenetre.addMessage("Pfiouu.");
            } else if (event.getKeyCode() == KeyEvent.VK_SPACE) {
                Fenetre.addMessage("Hors de portée : " + this.getPerso().getPos().distance(new Point2D(monde.getCible().getX(), monde.getCible().getY())));
            } else if (event.getKeyCode() == KeyEvent.VK_SHIFT) {
                monde.setCible(new Point2D(this.getPerso().getPos()));
                Fenetre.addMessage("Reset cible.");
            } else {
                int[] dep = deplacement(event);
                monde.getCible().translate(dep[0], dep[1]);
            }
            monde.afficheWorld();
            this.wait(100);
        }

        while (Fenetre.isPressed()) {
            this.wait(100);
        }

    }

    /**
     * Transforme une touche de clavier en un tuple correspondant au déplacement
     * correspondant sur la carte
     *
     * @param event événement clavier à analyser
     * @return {dX, dY} déplacament X, Y
     */
    public int[] deplacement(KeyEvent event) {

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
     * Renvoie le personnage du joueur
     *
     * @return Personnage associé au joueur
     */
    public Personnage getPerso() {
        return ((Personnage) perso);
    }

    /**
     * Modifie le personnage associé au joueur TODO: C'est pas propre comme
     * copie ca (:
     *
     * @param perso
     */
    public void setPerso(Personnage perso) {
        this.perso = (Jouable) perso;
    }

    /**
     * Vide l'inventaire du joueur
     */
    public void clearInventaire() {
        this.inventaire = null;
    }

    /**
     * Ajoute un objet à l'inventaire du joueur
     *
     * @param objet
     */
    public void addInventaire(Recuperable objet) {
        inventaire.add(objet);
    }

    /**
     * Affiche l'inventaire du joueur
     */
    public void afficheInventaire() {
        String inv = "";
        inv += "PV= " + getPerso().getPtVie();
        inv += "\nDistAttMax = " + getPerso().getDistAttMax();
        inv += "\n";
        for (int i = 0; i < inventaire.size(); i++) {
            inv += i;
            inv += inventaire.get(i);
            inv += "\n";
        }
        Fenetre.afficheInventaire(inv);
    }

    public void wait(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static boolean estChiffre(char chr) {
        return Character.getNumericValue(chr) > 0;
    }
}
