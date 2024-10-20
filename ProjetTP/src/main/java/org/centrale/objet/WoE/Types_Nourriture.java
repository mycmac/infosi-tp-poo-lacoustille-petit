package org.centrale.objet.WoE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.centrale.objet.WoE.Creature.Carac;

/**
 * Enumeration des types de nourriture prédéterminés au format nom, bonus, [liste de malus]
 */
public enum Types_Nourriture {

    EPINARD(
            "épinard",
            new Modificateur(2, Carac.DEGATS.getNom(), 3)
    ),
    LAIT(
            "lait",
            new Modificateur(10, Carac.PARADE.getNom(), 2),
            new Modificateur[]{
                new Modificateur(10, Carac.VITESSE.getNom(), -1),
                new Modificateur(10, Carac.POURCENTAGE_PAR.getNom(), -.2),
                new Modificateur(10, Carac.POURCENTAGE_ATK.getNom(), -.2)
            }
    ),
    CAFE(
            "café",
            new Modificateur(5, Carac.VITESSE.getNom(), 1, .2)
    );

    /**
     * Liste non modifiable des types d'arme
     */
    private static final List<Types_Nourriture> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    /**
     * Taille de la liste des types d'arme
     */
    private static final int SIZE = VALUES.size();
    /**
     * Générateur de nombres aléatoires
     */
    private static final Random RANDOM = new Random();

    /**
     * Nom de la nourriture
     */
    private String nom;
    /**
     * Bonus associé à la nourriture
     */
    private Modificateur bonus;
    /**
     * Malus associés à la nourriture
     */
    private Modificateur[] malus;

    /**
     * Constructeur de Types_Nourriture avec tous les attributs
     *
     * @param nom
     * @param bonus
     * @param malus
     */
    private Types_Nourriture(String nom, Modificateur bonus, Modificateur[] malus) {
        this.nom = nom;
        this.bonus = bonus;
        this.malus = malus;
    }

    /**
     * Constructeur de Types_Nourriture
     *
     * @param nom
     * @param bonus
     */
    private Types_Nourriture(String nom, Modificateur bonus) {
        this.nom = nom;
        this.bonus = bonus;
        this.malus = null;
    }

    /**
     * Constructeur de Types_Nourriture
     *
     * @param nom
     * @param malus
     */
    private Types_Nourriture(String nom, Modificateur[] malus) {
        this.nom = nom;
        this.bonus = null;
        this.malus = malus;
    }

    /**
     * Renvoie le nom d'un type de nourriture
     *
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Renvoie le bonus associé au type de nourriture
     *
     * @return bonus
     */
    public Modificateur getBonus() {
        return this.bonus;
    }

    /**
     * Renvoie les malus associés au type de nourriture
     *
     * @return malus
     */
    public Modificateur[] getMalus() {
        return this.malus;
    }

    /**
     * Donne un type de nourriture aléatoire
     *
     * @return Type de nourriture aléatoire
     */
    public static Types_Nourriture getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
