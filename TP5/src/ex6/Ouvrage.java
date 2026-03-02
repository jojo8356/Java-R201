package ex6;

public class Ouvrage {
	private static int compteur = 0;
	private int cote;
	private String dateEmprunt;

	public Ouvrage() {
		compteur++;
		this.cote = compteur;
		this.dateEmprunt = null;
	}

	public int getCote() {
		return cote;
	}

	public String getDateEmprunt() {
		return dateEmprunt;
	}

	public void setDateEmprunt(String dateEmprunt) {
		this.dateEmprunt = dateEmprunt;
	}

	@Override
	public String toString() {
		String emprunt = (dateEmprunt == null) ? "non emprunté" : "emprunté le " + dateEmprunt;
		return "Ouvrage [cote=" + cote + ", " + emprunt + "]";
	}
}
