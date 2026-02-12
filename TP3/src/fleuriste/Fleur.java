package fleuriste;

public enum Fleur {
    TULIPE(1.50),
    OEILLET(2.00),
    ROSE(3.50);

    private final double prixUnitaire;

    Fleur(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }
}