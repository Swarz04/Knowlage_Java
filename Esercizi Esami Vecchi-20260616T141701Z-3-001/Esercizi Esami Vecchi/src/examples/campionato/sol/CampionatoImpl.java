package examples.campionato.sol;

import java.util.*;

public class CampionatoImpl implements Campionato {
	
	private static final String[] RES = new String[]{"1","X","2"}; 
	private Map<String,Pair<String,Integer>> map = new HashMap<>();
	private boolean started = false;

	public CampionatoImpl() {
		super();
	}

	@Override
	public void addSquadra(String shortName, String longName)
			throws IllegalArgumentException, UnsupportedOperationException {
		if (this.started){
			throw new UnsupportedOperationException();
		}
		if (shortName.length()!=3 || this.map.put(shortName,new Pair<>(longName,0))!=null){
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void iniziaCampionato() {
		this.started = true;
	}

	@Override
	public void addRisultato(String squadra1, String squadra2, String risultato)
			throws IllegalArgumentException, UnsupportedOperationException {
		if (!this.started){
			throw new UnsupportedOperationException();
		}
		if (this.map.get(squadra1)==null || this.map.get(squadra2)==null){
			throw new IllegalArgumentException();
		}
		Pair<String,Integer> s1 = this.map.get(squadra1);
		Pair<String,Integer> s2 = this.map.get(squadra2);
		if (risultato.equals(RES[0])){ // "1" 
			s1.setSecond(s1.getSecond()+3);
		} else if (risultato.equals(RES[1])){ // "X"
			s1.setSecond(s1.getSecond()+1);
			s2.setSecond(s2.getSecond()+1);
		} else if (risultato.equals(RES[2])){ // "2"
			s2.setSecond(s2.getSecond()+3);
		}  else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public List<Pair<String, Integer>> getClassifica() {
		List<Pair<String,Integer>> list = new ArrayList<>(this.map.values());
		Collections.sort(list,new Comparator<Pair<String,Integer>>(){

			@Override
			public int compare(Pair<String, Integer> o1,
					Pair<String, Integer> o2) {
				return o2.getSecond() - o1.getSecond();
			}
			
		});
		return list;
	}
	
	

}
