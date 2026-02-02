package ex2;

import java.util.Arrays;

public class EnsembleEntierBorne {
	int MAXIMUM;
	boolean[] includes;
	
	public void initIncludes() {
		this.includes = new boolean[this.MAXIMUM+1];
		for (int i = 0; i<=this.MAXIMUM; i++)
			this.includes[i] = false;
	}
	
	public EnsembleEntierBorne(int max) {
		this.MAXIMUM = max;
		this.initIncludes();
	}
	
	public EnsembleEntierBorne() {
		this.MAXIMUM = 0;
		this.initIncludes();
	}
	
	public void add(int nb) {
		this.includes[nb] = true;
	}
	
	public void remove(int nb) {
		this.includes[nb] = false;
	}
	
	public boolean doesContain(int nb) {
	    return nb >= 0 && nb <= MAXIMUM && includes[nb];
	}
	
	private java.util.stream.IntStream elements() {
	    return java.util.stream.IntStream
	            .rangeClosed(0, MAXIMUM)
	            .filter(i -> includes[i]);
	}
	
	public int countElement() {
	    return (int) elements().count();
	}
	
	public int[] toArray() {
	    return elements().toArray();
	}
	
	@Override
	public String toString() {
	    return Arrays.toString(toArray());
	}
	
	public int length() {
		return this.MAXIMUM + 1;
	}
	
	public EnsembleEntierBorne formatArray(int[] tab) {
	    if (tab == null || tab.length == 0)
	        throw new IllegalArgumentException("Array must not be null or empty");

	    EnsembleEntierBorne result =
	            new EnsembleEntierBorne(Arrays.stream(tab).max().orElseThrow() + 1);

	    for (int v : tab)
	        result.add(v);

	    return result;
	}
	
	public void formatSelfArray(int[] tab) {
		EnsembleEntierBorne result = this.formatArray(tab);
		this.MAXIMUM = result.MAXIMUM;
		this.includes = result.includes;
	}
	
	public EnsembleEntierBorne intersect(EnsembleEntierBorne e) {
	    int max = Math.min(MAXIMUM, e.MAXIMUM);
	    EnsembleEntierBorne r = new EnsembleEntierBorne(max + 1);

	    elements()
	        .filter(i -> i <= max && e.includes[i])
	        .forEach(r::add);

	    return r;
	}
}

// Override: cette méthode redéfinit une méthode de la classe parente
// java.util.stream.IntStream: une suite d’entiers sur laquelle tu peux appliquer des opérations sans écrire de boucles for
// orElseThrow: s’il y a une valeur, donne-la ; sinon, lance une exception
