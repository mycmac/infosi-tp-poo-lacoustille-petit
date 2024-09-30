package org.centrale.objet.WoE;

/**
 * Test de la classe {@link org.centrale.objet.WoE.Point2D}
 * @author Ulysse
 */
public class TestPoint2D {

    public static void main(String[] args) {
        Point2D p0 = new Point2D(0, 0);
        Point2D p1 = new Point2D(1, 0);
        Point2D p2 = new Point2D();
        p2.setX(2);
        p2.setY(0);
        System.out.println("P1 : ");
        p1.affiche();
        p1.translate(-1, 1);
        System.out.println("P2 : ");
        p0.affiche();
        System.out.println("P1 translaté : ");
        p1.affiche();
        p1.translate(1, 0);
        System.out.println("P1 translaté : ");
        p1.affiche();
        p2.affiche();
        System.out.println("Distance p1 p2 (racine de 2 en théorie): ");
        System.out.println(p1.distance(p2));
        Point2D p3 = new Point2D(p1);
        System.out.println("P3 (comme p1) : ");
        p3.affiche();
        System.out.println("Distance p1 p3 (zéro en théorie) : ");
        System.out.println(p1.distance(p3));
    }
}
