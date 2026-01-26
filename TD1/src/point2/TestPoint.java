package point2;

import point.Point;

public class TestPoint {
    public static void main(String[] args) {
        Point p1 = new Point();
        Point p2 = new Point(1, 2);
        p1.afficher();
        p2.afficher();
        System.out.println("Test point (p2) dans main, x: "+ p2.getX() + ", y: " + p2.getY());
        System.out.println("Test projection point (p2) dans main, x: "+ p2.projX().toString() + ", y: " + p2.projY().toString());
        System.out.println("La distance entre les 2 points: "+p1.getDistance(p2));
    }
}
