package fleuriste;

public class Fleuriste {
    public static void main(String[] args) {
        // Creation du stock (arriere-boutique)
        Stock stock = new Stock();
        stock.ajouter(Fleur.ROSE, 20);
        stock.ajouter(Fleur.TULIPE, 30);
        stock.ajouter(Fleur.OEILLET, 15);
        System.out.println(stock);

        // Bouquet 1 : 5 roses + 3 tulipes
        Bouquet b1 = new Bouquet();
        b1.ajouter(Fleur.ROSE, 5);
        b1.ajouter(Fleur.TULIPE, 3);
        System.out.println(b1);
        System.out.println("Faisable ? " + stock.bouquetFaisable(b1));

        // Bouquet 2 : 10 roses + 20 oeillets (trop d'oeillets)
        Bouquet b2 = new Bouquet();
        b2.ajouter(Fleur.ROSE, 10);
        b2.ajouter(Fleur.OEILLET, 20);
        System.out.println(b2);
        System.out.println("Faisable ? " + stock.bouquetFaisable(b2));
    }
}
