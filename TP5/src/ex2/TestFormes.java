package ex2;

public class TestFormes {
	public static void main(String[] args) {
		// Test Rectangle
		Rectangle r = new Rectangle(5.0, 3.0);
		System.out.println("--- Rectangle ---");
		System.out.println(r);
		System.out.println("Périmètre : " + r.perimetre());
		System.out.println("Surface : " + r.surface());

		r.setLongueur(10.0);
		System.out.println("Après setLongueur(10) : " + r);

		System.out.println();

		// Test Carré
		Carre c = new Carre(4.0);
		System.out.println("--- Carré ---");
		System.out.println(c);
		System.out.println("Périmètre : " + c.perimetre());
		System.out.println("Surface : " + c.surface());

		c.setLongueur(7.0);
		System.out.println("Après setLongueur(7) : " + c);
		System.out.println("Largeur (doit aussi valoir 7) : " + c.getLargeur());

		System.out.println();

		// Polymorphisme Rectangle / Carré
		Rectangle r2 = new Carre(5.0);
		System.out.println("--- Rectangle r2 = new Carre(5) ---");
		System.out.println(r2);
		r2.setLargeur(8.0);
		System.out.println("Après setLargeur(8) : " + r2);
		System.out.println("Longueur (doit aussi valoir 8) : " + r2.getLongueur());
	}
}
