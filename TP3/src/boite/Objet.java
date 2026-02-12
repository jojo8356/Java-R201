package boite;

import java.awt.*;

public class Objet {
	Color couleur;
	
	public Objet() {
		couleur = Color.white;
	}
	
	public Objet(Color c) {
		couleur = c;
	}
	
	public void changeCouleur(Color c) throws Exception {
		if (couleur.equals(c))
			throw new Exception("Erreur: C'est la même couleur que celle déjà présente");
		couleur = c;
	}
	
	public boolean equals(Object o) {
		Objet currentO = (Objet) o;
		return (currentO.couleur.equals(couleur));
	}
	
	@Override
	public String toString() {
		return "Objet "+couleur;
	}

}