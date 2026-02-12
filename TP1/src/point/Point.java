package point;

/**
 * Classe qui permet de modéliser des points dans un plan 2D
 * @author POLSINELLI JOHAN
 * 
 */
public class Point {
    /**
     * attrs
     */
    private Double x;
    private Double y;
    
    /**
     * builder sans params
     */
    public Point(){
        this.x = 0.0;
        this.y = 0.0;
    }

    /**
     * builder avec params
     *
     * @param x coordonnée X
     * @param y coordonnée Y
     */
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * get dist entre 2 pts
     *
     * @param p le point cible
     * @return double
     */
    public double getDistance(Point p){
        return Math.sqrt( Math.pow(p.x - this.x, 2) + Math.pow(p.y - this.y, 2));
    }

    /**
     * default str method
     * @return str
     */
    public String toString(){
        return "[" + this.x + ", " + this.y + "]";
    }

    /**
     * default print method
     */
    public void afficher(){
        System.out.println(this.toString());
    }

    /**
     * getter X
     * @return int
     */
    public double getX(){
        return this.x;
    }

    /**
     * getter Y
     * @return int
     */
    public double getY(){
        return this.y;
    }

    /**
     * projeter X -> (X, 0)
     * @return Point
     */
    public Point projX(){
        return new Point(this.x, 0);
    }

    /**
     * projeter Y -> (0, Y)
     * @return Point
     */
    public Point projY(){
        return new Point(0, this.y);
    }

    /**
     * Getter location (Copy point)
     * @return Point
     */
    public Point getLocation(){
        return new Point(this.x, this.y);
    }

    /**
     * (Re)setter point
     * @param p le nouveau point
     */
    public void setLocation​(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * (Re)setter point
     * @param x nouvelle coordonnée X
     * @param y nouvelle coordonnée Y
     */
    public void setLocation(double x, double y){
        this.x = x;
        this.y = y;
    }

    /**
     * translate point (additionnal)
     * @param dx déplacement en X
     * @param dy déplacement en Y
     */
    public void translate(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }
    
    public double getDistanceOrigine() {
    	return Math.sqrt( Math.pow(x, 2) + Math.pow(y, 2));
    }

    // public static void main(String[] args) {
    //     Point p1 = new Point();
    //     Point p2 = new Point(1, 2);
    //     p1.afficher();
    //     p2.afficher();
    //     System.out.println("La distance entre les 2 points: "+p1.getDistance(p2));
    // }
}