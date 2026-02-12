package boite;

import java.awt.Color;

public class Boite {
	// Constante : ne peut pas changer
	private static final int MAX_BOITE = 5;
	private static int nbBoites;

	// Attributs
	private Color couleur;
	private Objet objet; // le contenu "objet"
	private Boite[] boites; // le tableau de boites

	Boite(Color c) {
		couleur = c;
		setObjet(null);
		setBoites(new Boite[MAX_BOITE]);
	}

	Boite(Color c, Objet obj) {
		couleur = c;
		setObjet(null);
		setBoites(new Boite[MAX_BOITE]);
		objet = obj;
	}

	Boite(Color c, Boite b) {
		couleur = c;
		setObjet(null);
		setBoites(new Boite[MAX_BOITE]);
		boites[nbBoites++] = b;
	}

	Boite(Color c, Objet obj, Boite b) {
		couleur = c;
		setObjet(null);
		setBoites(new Boite[MAX_BOITE]);
		objet = obj;
		boites[nbBoites++] = b;
	}

	public static int getMaxBoite() {
		return MAX_BOITE;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getNbBoites() {
		return nbBoites;
	}

	public Boite[] getBoites() {
		return boites;
	}

	public void setBoites(Boite[] boites) {
		this.boites = boites;
	}

	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}

	boolean contientObjet(Objet o) {
		return objet.couleur.equals(o.couleur);
	}

	boolean estVide() {
		return objet == null && nbBoites == 0;
	}

	void ajouteBoite(Boite b) {
		boites[nbBoites++] = b;
	}

	public String getColorName(Color color) {
		try {
			return CouleurNom.depuisRGB(color.getRed(), color.getGreen(), color.getBlue());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String toString() {
		String r = "";
		r += "Boite de couleur " + getColorName(couleur) + "\n";
		if (objet != null)
			r += "Objet de couleur " + getColorName(objet.couleur) + "\n";
		for (int i = 0; i < MAX_BOITE; i++) {
			if (boites[i] != null)
				r += boites[i].toString();
		}
		return r;
	}

	public static void main(String[] args) {
		Objet obj = new Objet(Color.red);
		Boite b1 = new Boite(Color.green);
		System.out.println(b1);
		Boite b2 = new Boite(Color.blue, obj);
		System.out.println(b2);
		Boite b3 = new Boite(Color.red, b1);
		System.out.println(b3);
		Boite b4 = new Boite(Color.yellow, b3);
		b4.ajouteBoite(b2);
		System.out.println(b4);
		Boite b5 = new Boite(Color.white, obj, b1);
		System.out.println(b5);
	}
}
