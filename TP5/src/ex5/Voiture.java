package ex5;

public class Voiture extends Vehicule {
	private double cylindree;
	private int nbPortes;
	private double puissance;
	private double kilometrage;

	public Voiture(String marque, int dateAchat, double prixAchat,
			double cylindree, int nbPortes, double puissance, double kilometrage) {
		super(marque, dateAchat, prixAchat);
		this.cylindree = cylindree;
		this.nbPortes = nbPortes;
		this.puissance = puissance;
		this.kilometrage = kilometrage;
	}

	@Override
	public void calculePrix(int anneeActuelle) {
		double prix = getPrixAchat();

		// -2% par année depuis l'achat
		int nbAnnees = anneeActuelle - getDateAchat();
		prix -= getPrixAchat() * 0.02 * nbAnnees;

		// -5% par tranche de 10000 kms (arrondi à la tranche la plus proche)
		int tranchesKm = (int) Math.round(kilometrage / 10000.0);
		prix -= getPrixAchat() * 0.05 * tranchesKm;

		// -10% si Renault ou Fiat
		String marque = getMarque();
		if (marque.equalsIgnoreCase("Renault") || marque.equalsIgnoreCase("Fiat")) {
			prix -= getPrixAchat() * 0.10;
		}

		// +20% si Ferrari ou Porsche
		if (marque.equalsIgnoreCase("Ferrari") || marque.equalsIgnoreCase("Porsche")) {
			prix += getPrixAchat() * 0.20;
		}

		if (prix < 0) prix = 0;
		if (prix > getPrixAchat()) prix = getPrixAchat();
		setPrixCourant(prix);
	}

	@Override
	public String toString() {
		return "Voiture [marque=" + getMarque() + ", dateAchat=" + getDateAchat()
				+ ", prixAchat=" + getPrixAchat() + ", prixCourant=" + getPrixCourant()
				+ ", cylindree=" + cylindree + ", nbPortes=" + nbPortes
				+ ", puissance=" + puissance + ", kilometrage=" + kilometrage + "]";
	}

	// Getters et Setters
	public double getCylindree() {
		return cylindree;
	}

	public void setCylindree(double cylindree) {
		this.cylindree = cylindree;
	}

	public int getNbPortes() {
		return nbPortes;
	}

	public void setNbPortes(int nbPortes) {
		this.nbPortes = nbPortes;
	}

	public double getPuissance() {
		return puissance;
	}

	public void setPuissance(double puissance) {
		this.puissance = puissance;
	}

	public double getKilometrage() {
		return kilometrage;
	}

	public void setKilometrage(double kilometrage) {
		this.kilometrage = kilometrage;
	}
}
