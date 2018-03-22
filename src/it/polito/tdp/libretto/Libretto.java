package it.polito.tdp.libretto;

import java.util.ArrayList;
import java.util.List;

public class Libretto {
	
	private List <Voto> voti;


	public Libretto() {
		
		voti= new ArrayList<>(); //come se tra <> avessi scrito voto, se cambio tipo cambia da se
	}
	
	public Libretto(List <Voto> marks){
		
	//	voti=new ArrayList<>(marks); così creo copia di lista ma copio il riferimento all'oggetto non l'oggetto in se
		
		voti= new ArrayList<>();
		
		for(Voto v : marks)
			voti.add(new Voto(v.getEsame(),v.getVoto()));
	}
		
	public List<Voto> getVoti() {
		return voti;
	}

	public void addVoto(Voto v){    //versione del metodo implementata con contains e quindi equals() meglio fare così che un ciclofor
		
		if(voti.contains(v)){
		
			System.out.println("voto già esistente");
			return;
		}
			for(Voto v1 : voti){
		
				if(v.getEsame().equals(v1.getEsame())){
					
					System.out.println("Trovato stesso esame (aggiorno voto)");
					
					v1.setVoto(v.getVoto());
					return;
				}
			}
		if(!voti.contains(v))
				
				voti.add(v);
	}
	
	public void stampa(){
		
		System.out.println("ci sono "+voti.size()+" voti");
		
		for(int i=0; i < voti.size();i++)
			
			System.out.println(voti.get(i));

	}
		
	public void alzaVoti(){
			
		for(int i=0; i < voti.size();i++){
			
			if(voti.get(i).getVoto()>=18 && voti.get(i).getVoto()<24)
				
				voti.get(i).setVoto(voti.get(i).getVoto()+1);
		
			else if(voti.get(i).getVoto()>= 24)
				
				voti.get(i).setVoto(voti.get(i).getVoto()+2);
		}

	}

	@Override
	public String toString() { //versione alternativa al metodo stampa(), migliore perchè uso ereditarietà 
		
		StringBuilder sb= new StringBuilder(); //meglio che fare +=, la stringa è statica e ne verrebbe creata nuovamente una nuova
		
		sb.append("ci sono "+voti.size()+" voti\n");
		
		for(int i=0; i < voti.size();i++){
			
			sb.append(voti.get(i).toString());  //anche senza scrivere toString questo verrebbe richiamato
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public String getMarkFromClass(String nomeCorso){
		
		for(Voto v : voti){
			
			if(v.getEsame().toLowerCase().compareTo(nomeCorso.toLowerCase())==0)
				
					return String.valueOf(v.getVoto());   //""+v.getVoto() è identico		
		}
			return "Nome corso non trovato";
	}

	public void stampa25() {
			
		for (Voto v : voti){
			
			if(v.getVoto()==25)
			
			System.out.println(v);	
			
		}
	}

	public void remove(){
		
		for(Voto v : voti){
			
			if(v.getVoto()<24)
				
				voti.remove(v);
		}
	}
}