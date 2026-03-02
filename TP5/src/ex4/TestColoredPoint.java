package ex4;

import point.Point;

public class TestColoredPoint {
	public static void main(String[] args) {
		// --- Test des méthodes de base ---
		System.out.println("=== Test ColoredPoint ===");
		ColoredPoint cp1 = new ColoredPoint(1.0, 2.0, "rouge");
		ColoredPoint cp2 = new ColoredPoint(1.0, 2.0, "rouge");
		ColoredPoint cp3 = new ColoredPoint(1.0, 2.0, "bleu");

		System.out.println("cp1 : " + cp1);
		System.out.println("cp2 : " + cp2);
		System.out.println("cp3 : " + cp3);
		System.out.println("cp1.equals(cp2) : " + cp1.equals(cp2)); // true
		System.out.println("cp1.equals(cp3) : " + cp1.equals(cp3)); // false (couleur différente)
		System.out.println("cp1.memeCouleur(cp3) : " + cp1.memeCouleur(cp3)); // false
		System.out.println();

		// --- Test projections ---
		System.out.println("=== Test projections ===");
		System.out.println("cp1.projX() : " + cp1.projX());
		System.out.println("cp1.projY() : " + cp1.projY());
		System.out.println("cp1.projX(\"vert\") : " + cp1.projX("vert"));
		System.out.println("cp1.projY(\"noir\") : " + cp1.projY("noir"));
		System.out.println();

		// --- Tableau polymorphe de Points ---
		System.out.println("=== Tableau polymorphe Point[] ===");
		Point[] tab = new Point[10];

		// 5 points simples
		tab[0] = new Point(0.0, 5.0);
		tab[1] = new Point(1.0, 4.0);
		tab[2] = new Point(2.0, 3.0);
		tab[3] = new Point(3.0, 2.0);
		tab[4] = new Point(4.0, 1.0);

		// 5 points colorés
		tab[5] = new ColoredPoint(1.0, 1.0, "rouge");
		tab[6] = new ColoredPoint(2.0, 2.0, "bleu");
		tab[7] = new ColoredPoint(3.0, 3.0, "vert");
		tab[8] = new ColoredPoint(4.0, 4.0, "noir");
		tab[9] = new ColoredPoint(5.0, 5.0, "blanc");

		// 1. Appel des méthodes sur le tableau
		System.out.println("--- toString, getDistance, projX, projY ---");
		for (int i = 0; i < tab.length; i++) {
			System.out.println("tab[" + i + "] : " + tab[i]);
			System.out.println("  distance à l'origine : " + tab[i].getDistance(new Point(0, 0)));
			System.out.println("  projX : " + tab[i].projX());
			System.out.println("  projY : " + tab[i].projY());
		}
		System.out.println();

		// Test equals
		System.out.println("--- equals ---");
		System.out.println("tab[0].equals(tab[1]) : " + tab[0].equals(tab[1])); // false
		Point test = new Point(0.0, 5.0);
		System.out.println("tab[0].equals(new Point(0,5)) : " + tab[0].equals(test)); // true
		System.out.println();

		// 2. instanceof et getClass().getName()
		System.out.println("--- instanceof et getClass().getName() ---");
		for (int i = 0; i < tab.length; i++) {
			System.out.print("tab[" + i + "] : ");
			System.out.print("instanceof Point=" + (tab[i] instanceof Point));
			System.out.print(", instanceof ColoredPoint=" + (tab[i] instanceof ColoredPoint));
			System.out.println(", classe=" + tab[i].getClass().getName());
		}
		System.out.println();

		// --- Recherche du point bleu dans le tableau ---
		System.out.println("=== Recherche du point bleu ===");
		ColoredPoint pointBleu = null;
		for (int i = 0; i < tab.length; i++) {
			// On vérifie d'abord que c'est un ColoredPoint avec instanceof
			if (tab[i] instanceof ColoredPoint) {
				// Cast nécessaire car tab[i] est déclaré comme Point
				ColoredPoint cp = (ColoredPoint) tab[i];
				if (cp.getCouleur().equals("bleu")) {
					pointBleu = cp;
					break;
				}
			}
		}
		if (pointBleu != null) {
			System.out.println("Point bleu trouvé : " + pointBleu);
		}
		/*
		 * On doit faire un cast (ColoredPoint) car le tableau est de type Point[].
		 * Le compilateur ne sait pas que l'élément est un ColoredPoint,
		 * il faut donc vérifier avec instanceof avant de caster.
		 * Sans le cast, on ne peut pas accéder à getCouleur().
		 */
	}
}
