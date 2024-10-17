package org.centrale.objet.WoE;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.centrale.objet.WoE.Creature.Carac;

public enum Types_Nourriture {
    EPINARD(new Nourriture("épinard", new Modificateur(2, Carac.DEGATS.getNom(), 3)));

    private static final List<Types_Nourriture> VALUES = Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    private Nourriture nourriture;

    private Types_Nourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }

    public Nourriture getNourriture() {
        return this.nourriture;
    }

    public static Types_Nourriture getRandom() {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
