package fleuriste;

import java.util.HashMap;
import java.util.Map;

public class Bouquet {
    private final Map<Fleur, Integer> fleurs; // type -> quantite

    public Bouquet() {
        this.fleurs = new HashMap<>();
    }

    public void ajouter(Fleur fleur, int quantite) {
        fleurs.merge(fleur, quantite, Integer::sum);
    }

    public Map<Fleur, Integer> getFleurs() {
        return fleurs;
    }

    public int getQuantite(Fleur fleur) {
        return fleurs.getOrDefault(fleur, 0);
    }

    /** Prix du bouquet = somme des prix des fleurs + majoration de 15% */
    public double prix() {
        double total = 0;
        for (Map.Entry<Fleur, Integer> entry : fleurs.entrySet()) {
            total += entry.getKey().getPrixUnitaire() * entry.getValue();
        }
        return total * 1.15;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bouquet [");
        for (Map.Entry<Fleur, Integer> entry : fleurs.entrySet()) {
            sb.append(entry.getValue()).append(" ").append(entry.getKey()).append(", ");
        }
        if (!fleurs.isEmpty()) {
            sb.setLength(sb.length() - 2);
        }
        sb.append("] -> ").append(String.format("%.2f", prix())).append(" euros");
        return sb.toString();
    }
}
