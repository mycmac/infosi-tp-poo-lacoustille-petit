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
        this.bonus = new Modificateur(0, null, 0, 0);
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
        Types_Nourriture type = Types_Nourriture.getRandom();
        return new Nourriture(type.getNom(), type.getBonus(), type.getMalus());
    }

    /**
     * Récupérer de la nourriture
     * @param j Le joueur ramassant
     */
    @Override
    public void recuperer(Joueur j) {
        j.addInventaire(this);
        this.pos = null;
    }

    @Override
    public Recuperable utiliser(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String toString() {
        String n = nom + ": bonus : +" + bonus.getBonusPourcent() +"% de"+ bonus.getCaracModif() + ", malus :";
        for (Modificateur modif : malus){
        n += " -"+modif.getBonusPourcent() +"% de"+ modif.getCaracModif()+" ";
        }
        return n;
    }

    
}
