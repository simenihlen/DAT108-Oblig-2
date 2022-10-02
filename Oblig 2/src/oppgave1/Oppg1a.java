package oppgave1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Oppg1a {
	
	public static void main(String[] args) {
		
		List<String> listen = Arrays.asList("10", "1", "20", "110", "21", "12");
		
		Collections.sort(listen, (String a, String b) -> {
			Integer verdi1 = Integer.parseInt(a);
			Integer verdi2 = Integer.parseInt(b);
			return verdi1.compareTo(verdi2);
		});
		
		System.out.println(listen);
		
	
	}

}
