package ex2;

public class Carre extends Rectangle {

	public Carre(double cote) {
		super(cote, cote);
	}

	// Redéfinition : on force longueur et largeur à rester égales
	@Override
	public void setLongueur(double cote) {
		super.setLongueur(cote);
		super.setLargeur(cote);
	}

	@Override
	public void setLargeur(double cote) {
		super.setLongueur(cote);
		super.setLargeur(cote);
	}

	@Override
	public String toString() {
		return "Carré [côté=" + getLongueur()
				+ ", périmètre=" + perimetre() + ", surface=" + surface() + "]";
	}
}
