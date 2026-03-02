package ex5;

public class GestionVehicules {
	public static void main(String[] args) {
		int anneeActuelle = 2026;

		// Création de véhicules
		Voiture v1 = new Voiture("Renault", 2020, 25000, 1.5, 5, 110, 45000);
		Voiture v2 = new Voiture("Ferrari", 2022, 250000, 3.9, 3, 620, 12000);
		Voiture v3 = new Voiture("Fiat", 2018, 15000, 1.2, 5, 70, 85000);
		Voiture v4 = new Voiture("Porsche", 2021, 120000, 3.0, 3, 450, 30000);

		Avion a1 = new Avion("Cessna", 2015, 300000, "hélices", 450);
		Avion a2 = new Avion("Boeing", 2019, 5000000, "réaction", 8500);

		// Utilisation du polymorphisme : tableau de Vehicule
		Vehicule[] flotte = { v1, v2, v3, v4, a1, a2 };

		System.out.println("=== Flotte AVANT calcul du prix courant ===");
		for (Vehicule v : flotte) {
			v.affiche();
		}

		System.out.println();

		// Calcul des prix courants
		for (Vehicule v : flotte) {
			v.calculePrix(anneeActuelle);
		}

		System.out.println("=== Flotte APRÈS calcul du prix courant (année " + anneeActuelle + ") ===");
		for (Vehicule v : flotte) {
			v.affiche();
		}
	}
}
