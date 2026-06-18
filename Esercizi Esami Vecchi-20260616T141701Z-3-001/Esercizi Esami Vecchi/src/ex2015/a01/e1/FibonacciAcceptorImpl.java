package ex2015.a01.e1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class FibonacciAcceptorImpl implements FibonacciAcceptor {

	private Optional<String> currentName = Optional.empty();
	private final Map<String, List<Long>> story = new HashMap<>();

	@Override
	public void reset(final String sequenceName) {
		Objects.requireNonNull(sequenceName);
		if (this.story.containsKey(sequenceName)) {
			throw new IllegalArgumentException();
		}
		this.currentName = Optional.of(sequenceName);
		this.story.put(sequenceName, new ArrayList<>());
	}

	@Override
	public boolean consumeNext(final long l) {
		if (!this.currentName.isPresent()) {
			throw new IllegalStateException();
		}
		final List<Long> tmp = this.story.get(currentName.get());
		if (tmp.size() < 2) {
			tmp.add(l);
			return true;
		} else {
			if (tmp.get(tmp.size() - 1) + tmp.get(tmp.size() - 2) == l) {
				tmp.add(l);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Long> getCurrentSequence() {
		if (!this.currentName.isPresent()) {
			throw new IllegalStateException();
		}
		return new ArrayList<>(this.story.get(currentName.get()));
	}

	@Override
	public Map<String, List<Long>> getAllSequences() {
		return this.story.entrySet().stream().collect(Collectors.toMap(e->e.getKey(), v->new ArrayList<>(v.getValue())));
	}

}
