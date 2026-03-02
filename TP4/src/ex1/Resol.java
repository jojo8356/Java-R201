package ex1;

public class Resol {
	private static int k;

	public static void main(String[] args) {
		try {
			setK(1 / Integer.parseInt(args[0]));
		} catch (RuntimeException e) { // classe parente des 2 autres exceptions, faut passer avant les 2 autres, afin que ça marche, spé -> global et pas l'inverse
			System.err.println("Runtime "+e);
		}
		/*
		catch (IndexOutOfBoundsException e) { // Il est déjà géré par le bloc catch pour RuntimeException
			System.out.println("Index "+e);
		} catch (ArithmeticException e) { // Il est déjà géré par le bloc catch pour RuntimeException
			System.out.println("Arithmetic "+e);
		}
		*/
	}

	public static int getK() {
		return k;
	}

	public static void setK(int k) {
		Resol.k = k;
	}
}
