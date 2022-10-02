package oppgave2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Main {
	
	private static void lonnsoppgjor(List<Ansatt> ansatte, Function<Ansatt, Integer> lonn) {
		ansatte.forEach(ansatt -> ansatt.setAarslonn(lonn.apply(ansatt)));
	}

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Charles", "Dickens", Kjonn.MANN, "Servitør", 350000),
				new Ansatt("Lewis", "Carroll", Kjonn.MANN, "Servitør", 350000),
				new Ansatt("Thomas", "Carlyle", Kjonn.MANN, "Kokk", 400000),
				new Ansatt("Charlotte", "Bronte", Kjonn.DAME, "Sjef", 500000),
				new Ansatt("Matthew", "Arnold", Kjonn.MANN, "Kokk", 400000)
				);
		
		//1) Fast kronetillegg
		Function<Ansatt, Integer> fastTillegg = a -> a.getAarslonn() + 10000;
		
		//2) Fast prosentillegg
		Function<Ansatt, Integer> fastPros = a -> a.getAarslonn() + ((a.getAarslonn()/100) * 5);
		
		//3) Fast kronetillegg om lite lønn
		Function<Ansatt, Integer> liteLonn = a -> a.getAarslonn() <= 360000 ? a.getAarslonn() + 30000 : a.getAarslonn() //bruker ? og : som if/else utrykk
//			{ //det samme
//				if (a.getAarslonn() <= 360000) {
//					return a + 30000;
//				} else {
//					return a;
//				}
//			}
		;
		
		//4) Prosent tillegg om mann
		Function<Ansatt, Integer> mannLonn = a -> a.erMann() ? (a.getAarslonn() + (a.getAarslonn()/100)*20) : a.getAarslonn(); 
		
		System.out.println("Før lønnsendringer: " + "\n" + ansatte + "\n");
		
		lonnsoppgjor(ansatte, fastTillegg);
		System.out.println("Etter fasttillegg: " + "\n" + ansatte + "\n");
		
		lonnsoppgjor(ansatte, fastPros);
		System.out.println("Etter prosenttillegg: " + "\n" + ansatte + "\n");
		
		lonnsoppgjor(ansatte, liteLonn);
		System.out.println("De som tjener lite: " + "\n" + ansatte + "\n");
		
		lonnsoppgjor(ansatte, mannLonn);
		System.out.println("De som er menn: " + "\n" + ansatte + "\n");

	}

}















