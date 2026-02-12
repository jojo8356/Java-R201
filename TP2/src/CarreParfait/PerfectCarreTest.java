package CarreParfait;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PerfectCarreTest {

    @Test
    void constructeur_tailleImpaire_ok() {
        assertDoesNotThrow(() -> new PerfectCarre(3));
    }

    @Test
    void constructeur_taillePaire_exception() {
        Exception exception = assertThrows(Exception.class, () -> new PerfectCarre(4));
        assertEquals("Size pair is not possible for generate perfect square", exception.getMessage());
    }

    @Test
    void generate_carreMagique_ordre3_sommeCorrecte() throws Exception {
        PerfectCarre carre = new PerfectCarre(3);
        int[][] matrix = carre.generate();
        
        int sommeMagique = 3 * (3 * 3 + 1) / 2; // = 15

        // Vérifier les lignes
        for (int[] row : matrix) {
            int somme = 0;
            for (int val : row) somme += val;
            assertEquals(sommeMagique, somme);
        }

        // Vérifier les colonnes
        for (int j = 0; j < 3; j++) {
            int somme = 0;
            for (int i = 0; i < 3; i++) somme += matrix[i][j];
            assertEquals(sommeMagique, somme);
        }

        // Vérifier diagonale principale
        assertEquals(sommeMagique, matrix[0][0] + matrix[1][1] + matrix[2][2]);

        // Vérifier diagonale secondaire
        assertEquals(sommeMagique, matrix[0][2] + matrix[1][1] + matrix[2][0]);
    }
}   