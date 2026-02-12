package garage;

public class TestGarage {
	public static void main(String[] args) {
		Voiture voit1 = new Voiture(15, 10000, 17, 165, 100, 15, 165, 110);
		Voiture voit2 = new Voiture(9, 5000, 17, 155, 200, 15, 155, 220);

		System.out.println(voit1);
		System.out.println();
		System.out.println(voit2);
		System.out.println();

		System.out.println("Prix de voit1 : " + voit1.prix() + "€");
		System.out.println();

		if (voit1.estPlusPuissante(voit2)) {
			System.out.println("La voiture la plus puissante est " + voit1.getNumId());
		} else {
			System.out.println("La voiture la plus puissante est " + voit2.getNumId());
		}

		System.out.println();

		Garage paradiso = new Garage("PARADISO", "Nice", 50);
		paradiso.ajouterVoiture(voit1);
		paradiso.ajouterVoiture(voit2);

		System.out.println(paradiso);
	}
}
