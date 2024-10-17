/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Objects;

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
