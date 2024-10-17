/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 *
 * @author hanss
 */
public class Nourriture extends Objet implements Utilisable, Recuperable {

    private String nom;
    private Modificateur bonus;
    private Modificateur[] malus;


    public Nourriture() {
        this.nom = "Nourriture inutile";
        this.bonus = new Modificateur(0,0,0,0);
    }

    public Nourriture(String nom, Modificateur bonus, Modificateur[] malus) {
        this.nom = nom;
        this.bonus = bonus;
        this.malus = malus;
    }

    public Nourriture(String nom, Modificateur bonus) {
        this.nom = nom;
        this.bonus = bonus;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Modificateur getBonus() {
        return this.bonus;
    }

    public void setBonus(Modificateur bonus) {
        this.bonus = bonus;
    }

    public Modificateur[] getMalus() {
        return this.malus;
    }

    public void setMalus(Modificateur[] malus) {
        this.malus = malus;
    }
    
    public static Nourriture RandomType() {
        return Types_Nourriture.getRandom().getNourriture();
    }

    /**
     * Récupérer de la nourriture
     * @param p Le personnage ramassant
     */
    @Override
    public void recuperer(Personnage p) {
        // p.ajoutInventaire();
        this.pos = null;
    }
}
