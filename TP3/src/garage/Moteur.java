package garage;

public class Moteur {
	private static Integer nbMoteurs;
	private int num;
	private int puissance;
	private double prix;

	public Moteur(int puissance, double prix) {
		if (nbMoteurs == null)
			nbMoteurs = 0;
		this.setNum(nbMoteurs++);
		this.puissance = puissance;
		this.prix = prix;
	}

	public int getPuissance() {
		return puissance;
	}

	public double getPrix() {
		return prix;
	}

	@Override
	public String toString() {
		return "Moteur de puissance " + puissance + " cv";
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
