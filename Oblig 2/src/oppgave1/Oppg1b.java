package oppgave1;

import java.util.function.BiFunction;

public class Oppg1b {
	
	public static int beregn(int a, int b, BiFunction<Integer, Integer, Integer> bifu) {
		 return bifu.apply(a, b);
		}


	public static void main(String[] args) {
		
		System.out.println(beregn(12, 13, (a, b) -> a + b));
		
		System.out.println(beregn(-5, 3, (a, b) -> a > b ? a : b //bruker ? og : som if/else utrykk
//		{
//			if (a > b) {
//				return a;
//			} else {
//				return b;
//			}
//		}
		));
		
		System.out.println(beregn(54, 45, (a, b) -> a - b //fikk samme svar
//		{
//			int forskjell = a - b;
//			if (forskjell < 0) {
//				return forskjell * (-1);
//			} else {
//				return forskjell;
//			}
//		}
		));

	}

}
