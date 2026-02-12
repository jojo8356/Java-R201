package fleuriste;

import java.util.HashMap;
import java.util.Map;

public class Stock {
    private final Map<Fleur, Integer> stock; // type -> quantite en stock

    public Stock() {
        this.stock = new HashMap<>();
    }

    public void ajouter(Fleur fleur, int quantite) {
        stock.merge(fleur, quantite, Integer::sum);
    }

    public int getQuantite(Fleur fleur) {
        return stock.getOrDefault(fleur, 0);
    }

    /** Valeur totale du stock (sans majoration) */
    public double valeurStock() {
        double total = 0;
        for (Map.Entry<Fleur, Integer> entry : stock.entrySet()) {
            total += entry.getKey().getPrixUnitaire() * entry.getValue();
        }
        return total;
    }

    /** Verifie si le stock permet de confectionner le bouquet */
    public boolean bouquetFaisable(Bouquet b) {
        for (Map.Entry<Fleur, Integer> entry : b.getFleurs().entrySet()) {
            if (getQuantite(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Stock: ");
        for (Map.Entry<Fleur, Integer> entry : stock.entrySet()) {
            sb.append(entry.getKey()).append("=").append(entry.getValue()).append(" ");
        }
        sb.append("-> valeur: ").append(String.format("%.2f", valeurStock())).append(" euros");
        return sb.toString();
    }
}
