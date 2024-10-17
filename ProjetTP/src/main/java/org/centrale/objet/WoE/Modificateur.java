package org.centrale.objet.WoE;

public class Modificateur {
    private int duree;
    private String caracModif; // TODO : Liste des caracs pour spécifier l'index
    private int bonusFixe;
    private double bonusPourcent;

    public Modificateur() {
    }

    public Modificateur(int duree, String caracModif, int bonusFixe, double bonusPourcent) {
        this.duree = duree;
        this.caracModif = caracModif;
        this.bonusFixe = bonusFixe;
        this.bonusPourcent = bonusPourcent;
    }

    public Modificateur(int duree, String caracModif, int bonusFixe) {
        this.duree = duree;
        this.caracModif = caracModif;
        this.bonusFixe = bonusFixe;
        this.bonusPourcent = 0;
    }

    public Modificateur(int duree, String caracModif, double bonusPourcent) {
        this.duree = duree;
        this.caracModif = caracModif;
        this.bonusFixe = 0;
        this.bonusPourcent = bonusPourcent;
    }

    public int getDuree() {
        return this.duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getCaracModif() {
        return this.caracModif;
    }

    public void setCaracModif(String caracModif) {
        this.caracModif = caracModif;
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
