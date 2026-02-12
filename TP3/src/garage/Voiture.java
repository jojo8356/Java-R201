package garage;

public class Voiture {
	private String numId;
	private static Integer nbVoitures;
	private Moteur moteur;
	private Roue roueNormale;
	private Roue roueSport;

	public Voiture(int puissance, double prixM,
			double diamN, double largN, double prixN,
			double diamS, double largS, double prixS) {
		if (nbVoitures == null)
			nbVoitures = 0;
		this.numId = "V" + nbVoitures;
		this.moteur = new Moteur(puissance, prixM);
		this.roueNormale = new Roue(diamN, largN, prixN);
		this.roueSport = new Roue(diamS, largS, prixS);
		nbVoitures++;
	}

	public double prix() {
		return moteur.getPrix() + 4 * roueNormale.getPrix() + 4 * roueSport.getPrix();
	}

	public boolean estPlusPuissante(Voiture v) {
		return this.moteur.getPuissance() > v.moteur.getPuissance();
	}

	public String getNumId() {
		return numId;
	}

	@Override
	public String toString() {
		return "Voiture " + numId + " Prix : " + prix() + "€\n"
			 + moteur + "\n"
			 + "Roues normales : " + roueNormale + "\n"
			 + "Roue de secours : " + roueSport;
	}
}
