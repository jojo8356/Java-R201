package ex5;

public class Avion extends Vehicule {
	private String moteur;
	private int heuresVol;

	public Avion(String marque, int dateAchat, double prixAchat,
			String moteur, int heuresVol) {
		super(marque, dateAchat, prixAchat);
		this.moteur = moteur;
		this.heuresVol = heuresVol;
	}

	@Override
	public void calculePrix(int anneeActuelle) {
		double prix = getPrixAchat();

		if (moteur.equalsIgnoreCase("helices") || moteur.equalsIgnoreCase("hélices")) {
			// -10% par tranche de 100 heures de vol
			int tranches = heuresVol / 100;
			prix -= getPrixAchat() * 0.10 * tranches;
		} else {
			// -10% par tranche de 1000 heures de vol
			int tranches = heuresVol / 1000;
			prix -= getPrixAchat() * 0.10 * tranches;
		}

		if (prix < 0) prix = 0;
		if (prix > getPrixAchat()) prix = getPrixAchat();
		setPrixCourant(prix);
	}

	@Override
	public String toString() {
		return "Avion [marque=" + getMarque() + ", dateAchat=" + getDateAchat()
				+ ", prixAchat=" + getPrixAchat() + ", prixCourant=" + getPrixCourant()
				+ ", moteur=" + moteur + ", heuresVol=" + heuresVol + "]";
	}

	// Getters et Setters
	public String getMoteur() {
		return moteur;
	}

	public void setMoteur(String moteur) {
		this.moteur = moteur;
	}

	public int getHeuresVol() {
		return heuresVol;
	}

	public void setHeuresVol(int heuresVol) {
		this.heuresVol = heuresVol;
	}
}
