package ex4;

import point.Point;

public class ColoredPoint extends Point {
	private String couleur;

	public ColoredPoint(double x, double y, String couleur) {
		super(x, y);
		this.couleur = couleur;
	}

	public String getCouleur() {
		return couleur;
	}

	public boolean memeCouleur(ColoredPoint p) {
		return this.couleur.equals(p.couleur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof ColoredPoint)) return false;
		ColoredPoint other = (ColoredPoint) obj;
		return super.equals(other) && this.memeCouleur(other);
	}

	@Override
	public String toString() {
		return super.toString() + " couleur=" + couleur;
	}

	@Override
	public ColoredPoint projX() {
		return new ColoredPoint(getX(), 0, this.couleur);
	}

	@Override
	public ColoredPoint projY() {
		return new ColoredPoint(0, getY(), this.couleur);
	}

	// Surcharge : projection X avec nouvelle couleur
	public ColoredPoint projX(String nouvelleCouleur) {
		return new ColoredPoint(getX(), 0, nouvelleCouleur);
	}

	// Surcharge : projection Y avec nouvelle couleur
	public ColoredPoint projY(String nouvelleCouleur) {
		return new ColoredPoint(0, getY(), nouvelleCouleur);
	}
}
