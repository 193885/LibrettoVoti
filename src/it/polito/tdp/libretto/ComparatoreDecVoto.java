package it.polito.tdp.libretto;

import java.util.Comparator;

public class ComparatoreDecVoto implements Comparator<Voto>{

		@Override
		public int compare(Voto o1, Voto o2) {
		
			if(o1.getVoto()> o2.getVoto())
			
				return -1 ;
			
			else if(o1.getVoto() == o2.getVoto())
				
				return 0;
			
			else
				
				return 1;
		}
}
