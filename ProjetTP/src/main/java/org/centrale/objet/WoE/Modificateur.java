package org.centrale.objet.WoE;

/**
 * Class des modificateurs appliqués aux caractéristiques des créatures
 */
public class Modificateur {
    /**
     * Durée de la modification
     */
    private int duree = 0;
    /**
     * Carac modifiée
     */
    private String caracModif;
    /**
     * Bonus fixe appliqué à la caractéristique
     * Peut être négatif - c'est alors un malus ;)
     */
    private int bonusFixe = 0;
    /**
     * Bonus en pourcentage appliqué à la caractéristique
     * Peut être négatif - c'est alors un malus
     */
    private double bonusPourcent = 0;

    /**
     * Constructeur vide de Modificateur, qui crée un modificateur vide
     */
    public Modificateur() {
    }

    /**
     * Constructeur de Modificateur comme copie d'un autre
     * @param mod
     */
    public Modificateur(Modificateur mod) {
        this.duree = mod.getDuree();
        this.caracModif = mod.getCaracModif();
        this.bonusFixe = mod.getBonusFixe();
        this.bonusPourcent = mod.getBonusPourcent();
    }

    /**
     * Constructeur de Modificateur avec tous les arguments
     * @param duree
     * @param caracModif
     * @param bonusFixe
     * @param bonusPourcent
     */
    public Modificateur(int duree, String caracModif, int bonusFixe, double bonusPourcent) {
        this.duree = duree;
        this.caracModif = caracModif;
        this.bonusFixe = bonusFixe;
        this.bonusPourcent = bonusPourcent;
    }

    /**
     * Constructeur de Modificateur fixe
     * @param duree
     * @param caracModif
     * @param bonusFixe
     */
    public Modificateur(int duree, String caracModif, int bonusFixe) {
        this.duree = duree;
        this.caracModif = caracModif;
        this.bonusFixe = bonusFixe;
        this.bonusPourcent = 0;
    }

    /**
     * Constructeur de Modificateur en pourcentage
     * @param duree
     * @param caracModif
     * @param bonusPourcent
     */
    public Modificateur(int duree, String caracModif, double bonusPourcent) {
        this.duree = duree;
        this.caracModif = caracModif;
        this.bonusFixe = 0;
        this.bonusPourcent = bonusPourcent;
    }

    
    /** 
     * Getter de la durée d'une modification
     * @return duree
     */
    public int getDuree() {
        return this.duree;
    }

    
    /** 
     * Setter de la durée d'une modification
     * @param duree
     */
    public void setDuree(int duree) {
        this.duree = duree;
    }

    /**
     * Getter de la caractéristique associée à un modificateur
     * @return caracModif
     */
    public String getCaracModif() {
        return this.caracModif;
    }

    /**
     * Setter de la caractéristique associée à un modificateur
     * @param caracModif
     */
    public void setCaracModif(String caracModif) {
        this.caracModif = caracModif;
    }

    /**
     * Getter du bonus fixe associée à un modificateur
     * @return bonusFixe
     */
    public int getBonusFixe() {
        return this.bonusFixe;
    }

    /**
     * Setter du bonus fixe associée à un modificateur
     * @param bonusFixe
     */
    public void setBonusFixe(int bonusFixe) {
        this.bonusFixe = bonusFixe;
    }

    /**
     * Getter du bonus en pourcentage associée à un modificateur
     * @return bonusPourcent
     */
    public double getBonusPourcent() {
        return this.bonusPourcent;
    }

    /**
     * Setter du bonus fixe associée à un modificateur
     * @param bonusPourcent
     */
    public void setBonusPourcent(double bonusPourcent) {
        this.bonusPourcent = bonusPourcent;
    }
}
