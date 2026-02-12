package CarreParfait;

import java.util.Arrays;

public class PerfectCarre {
	int size;
	int[][] matrix;
	
	public PerfectCarre(int size) throws Exception{
		if (size % 2 == 0)
			throw new Exception("Size pair is not possible for generate perfect square");
		this.size = size;
		this.matrix = new int[this.size][this.size];
		for (int i = 0; i < matrix.length; i++) {
		    Arrays.fill(matrix[i], 0);
		}
	}
	
	public String toString() {
	    StringBuilder result = new StringBuilder();
	    for (int[] row : this.matrix) {
	        result.append(String.valueOf(row)).append("\n");
	    }
	    return result.toString().trim();
	}
	
	public int[][] generate() {
	    int i = 0;
	    int j = size / 2;
	    matrix[i][j] = 1;

	    for (int k = 2; k <= size * size; k++) {
	        int newRow = (i - 1 + size) % size;  // haut (modulo pour boucler)
	        int newCol = (j + 1) % size;         // droite

	        if (matrix[newRow][newCol] == 0) {
	            i = newRow;
	            j = newCol;
	        } else {
	            i = (i + 1) % size;  // descendre d'une ligne
	            // j reste le même
	        }
	        matrix[i][j] = k;
	    }

	    // Affichage
	    System.out.println("Carré magique d'ordre " + this.size + ":");
	    System.out.print(this.toString());

	    return matrix; 
	}
}