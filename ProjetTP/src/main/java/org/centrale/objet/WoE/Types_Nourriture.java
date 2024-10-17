package org.centrale.objet.WoE;

public enum Types_Nourriture {
    EPINARD(new Nourriture("épinard", new Modificateur(2, 1, 3)));

    private Nourriture nourriture;

    private Types_Nourriture(Nourriture nourriture) {
        this.nourriture = nourriture;
    }

    public Nourriture getNourriture() {
        return this.nourriture;
    }
}
