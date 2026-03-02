package ex1;

public class TestInit {
	public static void main(String[] args) {
		System.out.println("=== Création de A a = new A(5) ===");
		A a = new A(5);
		System.out.println();
		System.out.println("=== Création de A b = new B(5, 3) ===");
		A b = new B(5, 3);

		/*
		 * Résultat attendu :
		 *
		 * === Création de A a = new A(5) ===
		 * Entrée Constr. A : n=0 p=10
		 * Sortie Constr. A : n=5 p=10
		 *
		 * === Création de A b = new B(5, 3) ===
		 * Entrée Constr. A : n=0 p=10
		 * Sortie Constr. A : n=5 p=10
		 * Entrée Constr. B : n=5 p=10 q=25
		 * Sortie Constr. B : n=5 p=3 q=10
		 *
		 * Explication :
		 * - Pour new A(5) : les champs sont d'abord initialisés (n=0 par défaut, p=10),
		 *   puis le constructeur s'exécute et affecte n=5.
		 * - Pour new B(5,3) : super(5) est appelé en premier, ce qui initialise les
		 *   champs de A (n=0, p=10) puis exécute le constructeur de A (n=5).
		 *   Ensuite les champs de B sont initialisés (q=25), puis le corps du
		 *   constructeur de B s'exécute (p=3, q=2*5=10).
		 *   Note : dans B, le paramètre "n" masque le champ "n" hérité.
		 */
	}
}
