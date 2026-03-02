package ex3;

public class Poly {
	public static void main(String[] args) {
		A a = new A();
		a.affiche();
		System.out.println();
		// -> Je suis un A

		B b = new B();
		a = b;
		b.affiche();
		a.affiche();
		System.out.println();
		// -> Je suis un A Je suis un A
		// B hérite de A sans redéfinir affiche(), donc c'est la méthode de A qui est appelée.
		// a référence un objet B, mais B utilise affiche() de A.

		C c = new C();
		a = c;
		c.affiche();
		a.affiche();
		System.out.println();
		// -> Je suis un C Je suis un C
		// C redéfinit affiche(). Grâce au polymorphisme, a.affiche() appelle
		// la version de C car l'objet réel est de type C.

		D d = new D();
		a = d;
		c = d;
		d.affiche();
		a.affiche();
		c.affiche();
		System.out.println();
		// -> Je suis un D Je suis un D Je suis un D
		// D redéfinit affiche(). Peu importe le type déclaré (A, C ou D),
		// c'est la méthode de D qui est appelée (liaison dynamique).

		E e = new E();
		a = e;
		b = e;
		e.affiche();
		a.affiche();
		b.affiche();
		System.out.println();
		// -> Je suis un A Je suis un A Je suis un A
		// E hérite de B qui hérite de A. Aucune redéfinition de affiche(),
		// donc c'est la méthode de A qui est utilisée.

		F f = new F();
		a = f;
		c = f;
		f.affiche();
		a.affiche();
		c.affiche();
		System.out.println();
		// -> Je suis un C Je suis un C Je suis un C
		// F hérite de C sans redéfinir affiche(). C'est la version de C qui est appelée.

		/*
		 * Résultat complet :
		 * Je suis un A
		 * Je suis un A Je suis un A
		 * Je suis un C Je suis un C
		 * Je suis un D Je suis un D Je suis un D
		 * Je suis un A Je suis un A Je suis un A
		 * Je suis un C Je suis un C Je suis un C
		 *
		 * Explication générale :
		 * Le polymorphisme en Java fait que la méthode appelée dépend du type RÉEL
		 * de l'objet (type dynamique), et non du type DÉCLARÉ de la variable
		 * (type statique). C'est la liaison dynamique (late binding).
		 */
	}
}
