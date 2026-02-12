package garage;

public class Roue {
	private double diametre;
	private double largeur;
	private double prix;
	
	public Roue(double diametre, double largeur, double prix) {
		this.diametre = diametre;
		this.largeur = largeur;
		this.prix = prix;
	}

	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return diametre + " x " + largeur;
	}
}
