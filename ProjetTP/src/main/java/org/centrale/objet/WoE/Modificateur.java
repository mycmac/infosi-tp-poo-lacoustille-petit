package org.centrale.objet.WoE;

public class Modificateur {
    private int duree;
    private int indexBonus; // TODO : Liste des caracs pour spécifier l'index
    private int bonusFixe;
    private double bonusPourcent;

    public Modificateur() {
    }

    public Modificateur(int duree, int indexBonus, int bonusFixe, double bonusPourcent) {
        this.duree = duree;
        this.indexBonus = indexBonus;
        this.bonusFixe = bonusFixe;
        this.bonusPourcent = bonusPourcent;
    }

    public Modificateur(int duree, int indexBonus, int bonusFixe) {
        this.duree = duree;
        this.indexBonus = indexBonus;
        this.bonusFixe = bonusFixe;
        this.bonusPourcent = 0;
    }

    public Modificateur(int duree, int indexBonus, double bonusPourcent) {
        this.duree = duree;
        this.indexBonus = indexBonus;
        this.bonusFixe = 0;
        this.bonusPourcent = bonusPourcent;
    }


    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public int getIndexBonus() {
        return this.indexBonus;
    }

    public void setIndexBonus(int indexBonus) {
        this.indexBonus = indexBonus;
    }

    public int getBonusFixe() {
        return this.bonusFixe;
    }

    public void setBonusFixe(int bonusFixe) {
        this.bonusFixe = bonusFixe;
    }

    public double getBonusPourcent() {
        return this.bonusPourcent;
    }

    public void setBonusPourcent(double bonusPourcent) {
        this.bonusPourcent = bonusPourcent;
    }    

}
