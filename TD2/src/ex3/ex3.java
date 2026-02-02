package ex3;

import java.util.Arrays;

public class ex3 {

	public static void main(String[] args) {
		int[] T1 = new int[10] ;
		Arrays.fill(T1, 5);
		String[] T2 = new String[7] ;
		T2[1] = "bleu";
		T2[2] = "bleu";
		int[] T3 = {0, 6, 2, 4, 3} ;
		Arrays.sort(T3);
		String[] T4={"bleu»","rouge","blanc","vert","mauve","indigo"};
		Arrays.sort(T4);
		if (Arrays.equals(T1, T3))
			System.out.println("T1 et T3 sont égaux");
		else
			System.out.println("T1 et T3 sont différents");
		String[] T5 = Arrays.copyOf(T4, 5);
		String[] T6 = Arrays.copyOf(T4, T4.length);   
		System.out.println(Arrays.toString(T1));
		System.out.println(Arrays.toString(T2));
		System.out.println(Arrays.toString(T3));
		System.out.println(Arrays.toString(T4));
		System.out.println(Arrays.toString(T5));
		System.out.println(Arrays.toString(T6));
	}
}
