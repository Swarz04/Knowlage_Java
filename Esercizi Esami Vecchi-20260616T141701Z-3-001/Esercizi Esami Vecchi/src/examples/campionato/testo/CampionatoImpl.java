package examples.campionato.testo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CampionatoImpl implements Campionato {

	private final Map<String, Pair<String, Integer>> map = new HashMap<>();
	private boolean championsStarted;

	@Override
	public void addSquadra(final String shortName, final String longName)
			throws IllegalArgumentException, UnsupportedOperationException {
		if (championsStarted) {
			throw new UnsupportedOperationException();
		}

		if (shortName.length() != 3 || map.containsKey(shortName)) {
			throw new IllegalArgumentException();
		} else {
			map.put(shortName, new Pair<>(longName, 0));
		}
	}

	@Override
	public void iniziaCampionato() {
		this.championsStarted = true;

	}

	@Override
	public void addRisultato(final String squadra1, final String squadra2,
			final String risultato) throws IllegalArgumentException,
			UnsupportedOperationException {
		if (!championsStarted) {
			throw new UnsupportedOperationException();
		}

		if (map.containsKey(squadra1) && map.containsKey(squadra2)
				&& risultato.matches("^[12X]$")) {
			
			if (risultato.equals("1")) {
				map.compute(squadra1, (k, v) -> {
					return new Pair<>(v.getFirst(), v.getSecond() + 3);
				});
			} else if (risultato.equals("2")) {
				map.compute(squadra2, (k, v) -> {
					return new Pair<>(v.getFirst(), v.getSecond() + 3);
				});
			} else {
				map.compute(squadra1, (k, v) -> {
					return new Pair<>(v.getFirst(), v.getSecond() + 1);
				});
				map.compute(squadra2, (k, v) -> {
					return new Pair<>(v.getFirst(), v.getSecond() + 1);
				});
			}

		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public List<Pair<String, Integer>> getClassifica() {
		final List<Pair<String, Integer>> result = new ArrayList<>(map.values());
		Collections.sort(result, (x1, x2) -> x2.getSecond() - x1.getSecond());
		return result;
	}

}
