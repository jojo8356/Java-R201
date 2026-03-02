package ex6;

public class Main {
	public static void main(String[] args) {
		Bibliotheque biblio = new Bibliotheque(20);

		// Ajout de livres
		Livre l1 = new Livre("Victor Hugo", "Les Misérables", "Gallimard");
		Livre l2 = new Livre("Albert Camus", "L'Étranger", "Folio");
		Livre l3 = new Livre("Émile Zola", "Germinal", "Le Livre de Poche");

		// Ajout de périodiques
		Periodique p1 = new Periodique("Le Monde", 25000, "quotidien");
		Periodique p2 = new Periodique("Science & Vie", 1250, "mensuel");

		// Ajout de CDs
		CD cd1 = new CD("Abbey Road", "The Beatles");
		CD cd2 = new CD("Thriller", "Michael Jackson");

		// Insertion dans la bibliothèque
		biblio.ajouter(l1);
		biblio.ajouter(l2);
		biblio.ajouter(l3);
		biblio.ajouter(p1);
		biblio.ajouter(p2);
		biblio.ajouter(cd1);
		biblio.ajouter(cd2);

		System.out.println("=== Bibliothèque après ajouts ===");
		System.out.println(biblio);

		// Emprunt d'un livre
		l1.setDateEmprunt("02/03/2026");
		System.out.println("=== Après emprunt de l1 ===");
		System.out.println(l1);
		System.out.println();

		// Suppression par cote
		int coteASupprimer = l2.getCote();
		System.out.println("Suppression de l'ouvrage de cote " + coteASupprimer + " :");
		biblio.supprimer(coteASupprimer);
		System.out.println();

		System.out.println("=== Bibliothèque après suppression ===");
		System.out.println(biblio);

		// Tentative de suppression d'un ouvrage inexistant
		biblio.supprimer(999);
	}
}
