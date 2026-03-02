package ex2;

public class Rectangle {
	private double longueur;
	private double largeur;

	public Rectangle(double longueur, double largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
	}

	public double getLongueur() {
		return longueur;
	}

	public double getLargeur() {
		return largeur;
	}

	public void setLongueur(double longueur) {
		this.longueur = longueur;
	}

	public void setLargeur(double largeur) {
		this.largeur = largeur;
	}

	public double perimetre() {
		return 2 * (longueur + largeur);
	}

	public double surface() {
		return longueur * largeur;
	}

	@Override
	public String toString() {
		return "Rectangle [longueur=" + longueur + ", largeur=" + largeur
				+ ", périmètre=" + perimetre() + ", surface=" + surface() + "]";
	}
}
