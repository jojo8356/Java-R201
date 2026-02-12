package ex2;

public class SumArgs {
	public static void main(String[] args) {
		int sum = 0;
		for (String arg : args) {
			try {
				int num = Integer.parseInt(arg);
				sum += num;
			} catch (NumberFormatException e) {
				System.out.println("Erreur: "+arg+" n'est pas un int");
			}
		}
		System.out.println("Résultat: "+sum);
	}
}
