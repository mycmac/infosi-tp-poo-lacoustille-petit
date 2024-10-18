package org.centrale.objet.WoE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.centrale.objet.WoE.Creature.Carac;

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
    )
    ;


    private static final List<Types_Nourriture> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private String nom;
    private Modificateur bonus;
    private Modificateur[] malus;

    private Types_Nourriture(String nom, Modificateur bonus, Modificateur[] malus) {
        this.nom = nom;
        this.bonus = bonus;
        this.malus = malus;
    }

    private Types_Nourriture(String nom, Modificateur bonus) {
        this.nom = nom;
        this.bonus = bonus;
        this.malus = null;
    }

    private Types_Nourriture(String nom, Modificateur[] malus) {
        this.nom = nom;
        this.bonus = null;
        this.malus = malus;
    }

    public String getNom() {
        return this.nom;
    }

    public Modificateur getBonus() {
        return this.bonus;
    }

    public Modificateur[] getMalus() {
        return this.malus;
    }

    public static Types_Nourriture getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
