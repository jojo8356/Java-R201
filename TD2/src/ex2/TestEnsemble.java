package ex2;

public class TestEnsemble {
	// chercher nombres entier (algo euclide)
	static public void premiers(int maxim) {
		EnsembleEntierBorne premiers = new EnsembleEntierBorne(maxim);
		
		for (int i=2; i<=maxim; i++) {
			premiers.add(i);
		}

	    for (int i = 2; i <= maxim; i++) {
	        if (premiers.doesContain(i))
	            for (int j = 2 * i; j <= maxim; j += i)
	                premiers.remove(j);
	    }
	    System.out.println(premiers.toString());
	}

	
	public static void main(String[] args) {
		EnsembleEntierBorne ensemble1 = new EnsembleEntierBorne(7);
		ensemble1.add(1);
		ensemble1.add(5);
		ensemble1.add(4);
		
		EnsembleEntierBorne ensemble2 = new EnsembleEntierBorne(10);
		ensemble2.add(1);
		ensemble2.add(5);
		ensemble2.add(10);
		
		// true
		if (ensemble1.doesContain(1) && ensemble2.doesContain(1)) {
			System.out.println("l'ensemble 1 et 2 ont l'élément 1");
		}
		else
			System.out.println("l'ensemble 1 et 2 n'ont pas l'élément 1");
		
		// false
		if (ensemble1.doesContain(10) && ensemble2.doesContain(10)) {
			System.out.println("l'ensemble 1 et 2 ont l'élément 10");
		}
		else
			System.out.println("l'ensemble 1 et 2 n'ont pas l'élément 10");
		
		ensemble1.remove(1);
		
		// false
		if (ensemble1.doesContain(1) && ensemble2.doesContain(1)) {
			System.out.println("l'ensemble 1 et 2 ont l'élément 1");
		}
		else
			System.out.println("l'ensemble 1 et 2 n'ont pas l'élément 1");
	
		System.out.println("len elements (0 && 1) in ensemble1: " + ensemble1.length());
		System.out.println("len elements (just 1) in ensemble1: " + ensemble1.countElement());
		System.out.println("elements of ensemble1: " + ensemble1.toString());
		
		int[] test = {1, 5, 8, 9, 15};
		EnsembleEntierBorne ensembleTest = new EnsembleEntierBorne();
		ensembleTest.formatSelfArray(test);
		System.out.println("elements of test: " + ensembleTest.toString());
		
		ensemble1.add(1);
		System.out.println("same elements in ensemble 1 and 2: " + ensemble1.intersect(ensemble2).toString());
	
	    int max = 20;
	    TestEnsemble.premiers(max);
	    
	    int[] tests = {10, 15, 30, 50};
	    for (int t : tests) {
	        TestEnsemble.premiers(t);
	    }
	}
}
