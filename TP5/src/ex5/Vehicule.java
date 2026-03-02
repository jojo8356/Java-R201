package ex5;

public class Vehicule {
	private String marque;
	private int dateAchat;
	private double prixAchat;
	private double prixCourant;

	public Vehicule(String marque, int dateAchat, double prixAchat) {
		this.marque = marque;
		this.dateAchat = dateAchat;
		this.prixAchat = prixAchat;
		this.prixCourant = prixAchat;
	}

	public void calculePrix(int anneeActuelle) {
		int nbAnnees = anneeActuelle - dateAchat;
		prixCourant = prixAchat * (1 - 0.01 * nbAnnees);
		if (prixCourant < 0) prixCourant = 0;
		if (prixCourant > prixAchat) prixCourant = prixAchat;
	}

	public void affiche() {
		System.out.println(this);
	}

	@Override
	public String toString() {
		return "Vehicule [marque=" + marque + ", dateAchat=" + dateAchat
				+ ", prixAchat=" + prixAchat + ", prixCourant=" + prixCourant + "]";
	}

	// Getters et Setters
	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public int getDateAchat() {
		return dateAchat;
	}

	public void setDateAchat(int dateAchat) {
		this.dateAchat = dateAchat;
	}

	public double getPrixAchat() {
		return prixAchat;
	}

	public void setPrixAchat(double prixAchat) {
		this.prixAchat = prixAchat;
	}

	public double getPrixCourant() {
		return prixCourant;
	}

	public void setPrixCourant(double prixCourant) {
		this.prixCourant = prixCourant;
	}
}
