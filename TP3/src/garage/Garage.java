package garage;

public class Garage {
	private String nom;
	private String adresse;
	private int nbVoitures;
	private int nbMaxVoitures;
	private Voiture[] voitures;

	public Garage(String nom, String adresse, int max) {
		this.nom = nom;
		this.adresse = adresse;
		this.nbMaxVoitures = max;
		this.nbVoitures = 0;
		this.voitures = new Voiture[max];
	}

	public void ajouterVoiture(Voiture v) {
		if (nbVoitures < nbMaxVoitures) {
			voitures[nbVoitures] = v;
			nbVoitures++;
		}
		else {
			System.out.println("On a atteint le max de voitures que l'on peut mettre dans le garage");
		}
	}

	public double valeurStock() {
		double total = 0;
		for (int i = 0; i < nbVoitures; i++) {
			total += voitures[i].prix();
		}
		return total;
	}

	public Voiture laPlusPuissante() {
		if (nbVoitures == 0) return null;
		Voiture max = voitures[0];
		for (int i = 1; i < nbVoitures; i++) {
			if (voitures[i].estPlusPuissante(max)) {
				max = voitures[i];
			}
		}
		return max;
	}

	@Override
	public String toString() {
		String s = "";
		s += "Garage " + nom + "(" + adresse + ") Capacite : " + nbMaxVoitures + "\n";
		s += "**************************************************\n";
		for (int i = 0; i < nbVoitures; i++) {
			s += "\n" + voitures[i] + "\n";
		}
		s += "\nLa voiture la plus puissante est la voiture " + laPlusPuissante().getNumId() + "\n";
		s += "La valeur totale du stock de voitures est de " + valeurStock() + "€";
		return s;
	}
}