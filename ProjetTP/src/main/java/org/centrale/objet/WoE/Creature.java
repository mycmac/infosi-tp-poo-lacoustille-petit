/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;

import java.util.Random;

/**
 * Super-classe générique pour les créatures diverses de WoE
 *
 * @author hanss
 */
public class Creature {

    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    protected Point2D pos;
    private final Random r;

    /**
     * Génère une créature à partir de paramètres donnés
     *
     * @param pV points de vie
     * @param dA dégats d'attaque
     * @param pPar points de parade
     * @param paAtt probabilité de réussite d'une attaque
     * @param paPar probabilité de parer une attaque
     * @param p position
     */
    public Creature(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p) {
        ptVie = pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        pos = new Point2D(p);
        r = new Random();
    }

    /**
     * Recopie une créature
     *
     * @param p créature à copier
     */
    public Creature(Creature p) {
        ptVie = p.getPtVie();
        degAtt = p.getDegAtt();
        ptPar = p.getPtPar();
        pageAtt = p.getPageAtt();
        pagePar = p.getPagePar();
        pos = new Point2D(p.getPos());
        r = new Random();
    }

    /**
     * Créé une créature aléatoire sans type précisé avec les paramètres
     * aléatoires suivants : Points de vie entre 20 et 100 Dégats d'attaque
     * entre 1 et 10 Points de parade entre 1 et 10 Pourcentage de réussite
     * d'attaque entre 1 et 100 Pourcentage de réussite de parade entre 1 et 100
     */
    public Creature() {
        r = new Random();
        ptVie = r.nextInt(80) + 21;
        degAtt = r.nextInt(10) + 1;
        ptPar = r.nextInt(10) + 1;
        pageAtt = r.nextInt(99) + 1;
        pagePar = r.nextInt(99) + 1;
    }

    /**
     *
     * @return Points de vie
     */
    public int getPtVie() {
        return ptVie;
    }

    /**
     * Modifie le nombre de points de vie
     *
     * @param ptVie
     */
    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    /**
     *
     * @return Dégats d'attaque
     */
    public int getDegAtt() {
        return degAtt;
    }

    /**
     * Modifie le nombre de dégats d'attaque
     *
     * @param degAtt
     */
    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    /**
     *
     * @return Nombre de points de parade
     */
    public int getPtPar() {
        return ptPar;
    }

    /**
     * Modifie le nombre de points de parade
     *
     * @param ptPar
     */
    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    /**
     *
     * @return Pourcentage de réussite d'attaque
     */
    public int getPageAtt() {
        return pageAtt;
    }

    /**
     * Modifie le pourcentage de réussite d'attaque
     *
     * @param pageAtt
     */
    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    /**
     *
     * @return pourcentage de parade
     */
    public int getPagePar() {
        return pagePar;
    }

    /**
     * Renvoie le pourcentage de réussite de parade
     *
     * @param pagePar
     */
    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
    }

    /**
     *
     * @return position
     */
    public Point2D getPos() {
        return pos;
    }

    /**
     * Définit la position
     *
     * @param pos Point2D
     */
    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    /**
     * Définit la position
     *
     * @param x coordonnée x
     * @param y coordonnée y
     */
    public void setPos(int x, int y) {
        this.pos = new Point2D(x, y);
    }

    /**
     * Déplace aléatoirement sur une case adjacente
     */
    public void deplace() {
        pos.translate(r.nextInt(2) - 1, r.nextInt(2) - 1);
    }

    /**
     * Affiche les détails de base de la créature (points de vie et position)
     */
    public void affiche() {
        System.out.print("\nCette entité a " + ptVie + " points de vie et se situe en " + pos + ". ");
    }

    /**
     * Renvoie un nombre aléatoire depuis le générateur aléatoire du personnage
     *
     * @param n Borne supérieure (non incluse)
     * @return Nombre aléatoire entre 0 et n
     */
    public int getRandom(int n) {
        return r.nextInt(n);
    }
}
