package oppgave3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

	public static void main(String[] args) {
		
		List<Ansatt> ansatte = Arrays.asList(
				new Ansatt("Charles", "Dickens", Kjonn.MANN, "Servitør", 360000),
				new Ansatt("Lewis", "Carroll", Kjonn.MANN, "Servitør", 350000),
				new Ansatt("Thomas", "Carlyle", Kjonn.MANN, "Kokk", 400000),
				new Ansatt("Charlotte", "Bronte", Kjonn.DAME, "Sjef", 500000),
				new Ansatt("Matthew", "Arnold", Kjonn.MANN, "Kokk", 400000)
				);
		
		//a)
		List <String> listeEtternavn = ansatte.stream()
				.map(p -> p.getEtternavn())
				.collect(Collectors.toList());
		System.out.println("Etternavn: " + listeEtternavn);
		
		//b)
		long antallDamer = ansatte.stream()
				.filter(p -> p.getKjonn().equals(Kjonn.DAME))
				.count();
		System.out.println("Antall damer: " + antallDamer);
		
		//c) 
		OptionalDouble gjennomsnittLonnDamer = ansatte.stream()
				.filter(p -> p.getKjonn().equals(Kjonn.DAME))
				.mapToInt(l -> l.getAarslonn())
				.average();
		System.out.println("Gjennomsnittslønnen til damer: " + gjennomsnittLonnDamer);
		
		//d)
		System.out.println("Sjef som får økning i lønn: \n");
		ansatte.stream()
			.filter(a -> a.getStilling().toLowerCase().contains("sjef"))
			.forEach(a -> a.setAarslonn((int) (a.getAarslonn() * 1.07)));
		System.out.println(ansatte + "\n");
		
		//e)
		boolean lonnOver = ansatte.stream()
				.mapToInt(a -> a.getAarslonn())
				.anyMatch(a -> a > 800000);
		System.out.println("Det er " + lonnOver + " som har lønn over 800,000"); //Feil print
		
		//f)
		System.out.println("Alle ansatte uten å bruke løkke: \n");
			ansatte.stream()
			.forEach(System.out::println);
		System.out.println("\n");
		
		//g)
		Ansatt minstLonn = ansatte.stream()
				.collect(Collectors.minBy(Comparator.comparingInt(Ansatt::getAarslonn)))
				.get();
		System.out.println("De med minst lønn: \n" + minstLonn);
		
		//h)
		int[] tall = IntStream.range(1, 1000).toArray();
		int deleigPaa = Arrays.stream(tall)
				.filter(t -> t % 3 == 0)
				.filter(t -> t % 5 == 0)
				.sum();
		
		int sumAv3 = Arrays.stream(tall)
				.filter(t -> t % 3 == 0)
				.sum();
		int sumAv5 = Arrays.stream(tall)
				.filter(t -> t % 5 == 0)
				.sum();
		
		System.out.print("Oppgave h svar: ");
		System.out.println(sumAv3 + sumAv5 - deleigPaa);
		
	}

}










