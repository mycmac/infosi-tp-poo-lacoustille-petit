/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

/**
 * Classe Nourriture, qui représente les objets offrant un bonus et/ou des malus
 * au Joueur qui les consomme
 * 
 * @author hanss
 */
public class Nourriture extends Objet implements Utilisable, Recuperable {

    /**
     * Nom de la nourriture, notamment si elle est d'un type spécifique
     * 
     * @see Types_Nourriture
     */
    private String nom;
    /**
     * Bonus associé à la nourriture
     * 
     * @see Modificateur
     */
    private Modificateur bonus;
    /**
     * Liste des malus associés à la nourriture
     * 
     * @see Modificateur
     */
    private Modificateur[] malus;

    /**
     * Constructeur vide, qui génère une nourriture de bonus et malus de durée = 0
     */
    public Nourriture() {
        this.nom = "Nourriture inutile";
        this.bonus = new Modificateur(0, null, 0, 0);
    }

    /**
     * Constructeur avec tous les attributs
     * 
     * @param nom
     * @param bonus
     * @param malus
     */
    public Nourriture(String nom, Modificateur bonus, Modificateur[] malus) {
        this.nom = nom;
        this.bonus = bonus;
        this.malus = malus;
    }

    /**
     * Constructeur sans malus
     * 
     * @param nom
     * @param bonus
     */
    public Nourriture(String nom, Modificateur bonus) {
        this.nom = nom;
        this.bonus = bonus;
    }

    /**
     * Getter du nom de la nourriture
     * 
     * @return nom
     */
    public String getNom() {
        return this.nom;
    }

    /**
     * Setter du nom de la nourriture
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter du bonus de la nourriture
     * 
     * @return bonus
     */
    public Modificateur getBonus() {
        return this.bonus;
    }

    /**
     * Setter du bonus de la nourriture
     * 
     * @param bonus
     */
    public void setBonus(Modificateur bonus) {
        this.bonus = bonus;
    }

    /**
     * Getter de la liste des malus de la nourriture
     * 
     * @return malus
     */
    public Modificateur[] getMalus() {
        return this.malus;
    }

    /**
     * Setter de la liste des malus de la nourriture
     * 
     * @param malus
     */
    public void setMalus(Modificateur[] malus) {
        this.malus = malus;
    }

    /**
     * Renvoie un type de nourriture aléatoire parmi les types prédéterminés
     * 
     * @see Types_Nourriture
     * @return Nourriture de type aléatoire
     */
    public static Nourriture RandomType() {
        Types_Nourriture type = Types_Nourriture.getRandom();
        return new Nourriture(type.getNom(), type.getBonus(), type.getMalus());
    }

    /**
     * Récupérer de la nourriture
     *
     * @param j Le joueur ramassant
     */
    @Override
    public void recuperer(Joueur j) {
        j.addInventaire(this);
        this.pos = null;
    }

    /**
     * Utiliser de la nourriture
     * 
     * @param j Le joueur qui utilise la nourriture
     */
    @Override
    public Recuperable utiliser(Joueur j) {
        Creature c = (Creature) j.getPerso();
        c.addEffets(this.getBonus());
        if (this.getMalus() != null) {
            for (Modificateur mal : this.getMalus()) {
                c.addEffets(mal);
            }
        }
        return null;
    }

    /**
     * Représentation en String d'une instance de Nourriture
     * 
     * @return Représentation String
     */
    @Override
    public String toString() {
        String n = nom + ": bonus : " + bonus.getBonusPourcent() + "% de" + bonus.getCaracModif();
        if (malus != null) {
            n += ", malus :";
            for (Modificateur modif : malus) {
                n += " " + modif.getBonusPourcent() + "% de" + modif.getCaracModif() + " ";
            }
        }
        return n;
    }
}
