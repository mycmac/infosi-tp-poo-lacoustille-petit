package org.centrale.objet.WoE;

import java.util.Random;

/**
 *
 * @author timot
 */
public abstract class Entite {

    protected Point2D pos;
    private boolean bloquant;
    private final Random r = new Random();

    public Entite(Entite e) {
        this.pos = new Point2D(e.getPos());
        this.bloquant = e.isBloquant();
    }

    public Entite(Point2D pt, boolean blq) {
        this.pos = new Point2D(pt);
        this.bloquant = blq;
    }
    
    public Entite(boolean blq) {
        this.pos = new Point2D();
        this.bloquant = blq;
    }

    public Point2D getPos() {
        return pos;
    }

    public void setPos(Point2D pos) {
        this.pos = new Point2D(pos);
    }

    public void setPos(int x, int y) {
        this.pos = new Point2D(x, y);
    }

    public boolean isBloquant() {
        return this.bloquant;
    }

    public void setBloquant(boolean bloquant) {
        this.bloquant = bloquant;
    }

    /**
     * Renvoie un nombre aléatoire depuis le générateur aléatoire de la créature
     *
     * @param n Borne supérieure (non incluse)
     * @return Nombre aléatoire entre 0 et n
     */
    public int getRandom(int n) {
        return r.nextInt(n);
    }
}
