package ex6;

public class Bibliotheque {
	private Ouvrage[] ouvrages;
	private int nbOuvrages;

	public Bibliotheque(int capacite) {
		this.ouvrages = new Ouvrage[capacite];
		this.nbOuvrages = 0;
	}

	public void ajouter(Ouvrage o) {
		if (nbOuvrages >= ouvrages.length) {
			System.out.println("Bibliothèque pleine, impossible d'ajouter l'ouvrage.");
			return;
		}
		ouvrages[nbOuvrages] = o;
		nbOuvrages++;
	}

	public void supprimer(int cote) {
		for (int i = 0; i < nbOuvrages; i++) {
			if (ouvrages[i].getCote() == cote) {
				// Décalage des éléments suivants
				for (int j = i; j < nbOuvrages - 1; j++) {
					ouvrages[j] = ouvrages[j + 1];
				}
				ouvrages[nbOuvrages - 1] = null;
				nbOuvrages--;
				System.out.println("Ouvrage de cote " + cote + " supprimé.");
				return;
			}
		}
		System.out.println("Ouvrage de cote " + cote + " non trouvé.");
	}

	public int getNbOuvrages() {
		return nbOuvrages;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Bibliothèque : ").append(nbOuvrages).append(" ouvrage(s)\n");
		for (int i = 0; i < nbOuvrages; i++) {
			sb.append("  ").append(ouvrages[i].toString()).append("\n");
		}
		return sb.toString();
	}
}
