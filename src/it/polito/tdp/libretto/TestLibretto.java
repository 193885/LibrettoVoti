package it.polito.tdp.libretto;

import java.util.Collections;
import java.util.Comparator;

public class TestLibretto {

	public static void main(String[] args) {
	
		Libretto l = new Libretto();
		
		l.addVoto(new Voto("Analisi",30));
		l.addVoto(new Voto("Tongoleria",18));
		l.addVoto(new Voto("Chimica",22));
		l.addVoto(new Voto("Chimica2",25));
	
	//	l.stampa();
		System.out.println(l.toString());
		
		System.out.println("voti pari a 25");
		
		l.stampa25();
		
		System.out.println(l.getMarkFromClass("analisi"));
		
		l.addVoto(new Voto("Chimica2",24));
		
		System.out.println(l.getMarkFromClass("Chimica2"));

		l.addVoto(new Voto("Analisi",30));
		System.out.println(l.toString());
		System.out.println("---------------------------------------");

		Libretto re = new Libretto(l.getVoti());
		
		re.alzaVoti();
		
		System.out.println(re.toString());
		System.out.println(l.toString());
		
		Collections.sort(re.getVoti());
		System.out.println(re.toString());
		
		Collections.sort(re.getVoti(), new ComparatoreDecVoto());
		System.out.println(re.toString());
		
		re.remove();
		System.out.println(re.toString());
	}
	
	
}
