/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.centrale.objet.WoE;
import java.util.Random;

/**
 *
 * @author hanss
 */
public class Entite {
    private int ptVie;
    private int degAtt;
    private int ptPar;
    private int pageAtt;
    private int pagePar;
    protected Point2D pos;
    private Random r;
    
    public Entite(int pV, int dA, int pPar, int paAtt, int paPar, Point2D p){
        ptVie = pV;
        degAtt = dA;
        ptPar = pPar;
        pageAtt = paAtt;
        pagePar = paPar;
        pos = new Point2D(p);
        r = new Random();
    }
    public Entite(Entite p){
        ptVie = p.getPtVie();
        degAtt = p.getDegAtt();
        ptPar = p.getPtPar();
        pageAtt = p.getPageAtt();
        pagePar = p.getPagePar();
        pos = new Point2D(p.getPos());
        r = new Random();
    }
    
    public Entite(){
        r = new Random();
        ptVie = r.nextInt(80)+21;
        degAtt = r.nextInt(10)+1;
        ptPar = r.nextInt(20);
        pageAtt = r.nextInt(99)+1;
        pagePar = r.nextInt(99)+1;
    }
    
    public int getPtVie() {
        return ptVie;
    }

    public void setPtVie(int ptVie) {
        this.ptVie = ptVie;
    }

    public int getDegAtt() {
        return degAtt;
    }

    public void setDegAtt(int degAtt) {
        this.degAtt = degAtt;
    }

    public int getPtPar() {
        return ptPar;
    }

    public void setPtPar(int ptPar) {
        this.ptPar = ptPar;
    }

    public int getPageAtt() {
        return pageAtt;
    }

    public void setPageAtt(int pageAtt) {
        this.pageAtt = pageAtt;
    }

    public int getPagePar() {
        return pagePar;
    }

    public void setPagePar(int pagePar) {
        this.pagePar = pagePar;
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
    
    public void deplace() {
        pos.translate(r.nextInt(2)-1, r.nextInt(2)-1);
    }
    public void affiche() {
    System.out.print("\nCette entité a "+ptVie+" points de vie et se situe en "+pos+". ");
    }
    public int getRandom(int n){
        return r.nextInt(n);
    }
}
