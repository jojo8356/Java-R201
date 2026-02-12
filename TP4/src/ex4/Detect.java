package ex4;

public class Detect {
	private final int MAX = 99;
	private int[] tab = new int[MAX];
	
	public Detect(int n) {
		for (int i=0; i<n; i++) {
			tab[i] = n;
		}
	}
	
	public int sommeDesNPremiers(int n) {
		int res = 0;
		for (int i=1; i<=n; i++) {
			res += tab[i-1];
		}
		return res;
	}
	
	public static void main(String[] args) {
		Detect d = new Detect(10);
		try {
			String first = args[0];
			try {
				int n = Integer.parseInt(first);
				int r = d.sommeDesNPremiers(n);
				System.out.println("La somme des "+args[0]+" premiers ");
				System.out.println("est: "+r);	
			} catch (NumberFormatException e) {
				System.out.println("Erreur: "+args[0]+" n'est pas un int");
			}
		} catch (IndexOutOfBoundsException e) {
			System.out.println("Erreur: il n'y a pas d'args donnés");
		}
	}
}
