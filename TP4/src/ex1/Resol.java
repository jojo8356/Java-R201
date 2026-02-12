package ex1;

public class Resol {
	public static void main(String[] args) {
		int k;
		
		try {
			k = 1 / Integer.parseInt(args[0]);
		} catch (RuntimeException e) { // classe parente des 2 autres exceptions
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
}
