package ex2015.a01b.e1;

import java.util.*;

public class ProgressiveAcceptorImpl<X> implements ProgressiveAcceptor<X> {

	private Optional<Integer> size;
	private Optional<ProgressiveFilter<X>> filter;
	private Optional<Aggregator<X>> aggregator;
	private List<X> accepted;

	public ProgressiveAcceptorImpl() {
		this.size = Optional.empty();
		this.filter = Optional.empty();
		this.aggregator = Optional.empty();
		this.accepted = new ArrayList<>();
	}

	@Override
	public void setProgressiveFilter(final ProgressiveFilter<X> filter) {
		Objects.requireNonNull(filter);
		this.filter = Optional.of(filter);
	}

	@Override
	public void setAggregator(final Aggregator<X> aggregator) {
		Objects.requireNonNull(aggregator);
		this.aggregator = Optional.of(aggregator);
	}

	@Override
	public void setSize(final int size) {
		if (size < 0) {
			throw new IllegalArgumentException();
		}
		this.size = Optional.of(size);
	}

	@Override
	public boolean accept(final int pos, final X elem) {

		if (!this.aggregator.isPresent() || !this.filter.isPresent()
				|| !this.size.isPresent()) {
			throw new IllegalStateException();
		}

		if (pos == 0) {
			this.accepted.clear();
			this.accepted.add(elem);
			return true;
		} else if (this.accepted.size() >= pos
				&& filter.get().isNextOK(this.accepted.get(pos - 1), elem)) {
			this.accepted = this.accepted.subList(0, pos);
			this.accepted.add(elem);
			return true;

		}
		return false;
	}

	@Override
	public X aggregateAll() {
		X tmp = this.accepted.get(0);
		for (int i = 1; i < this.accepted.size(); i++) {
			tmp = this.aggregator.get().aggregate(tmp, this.accepted.get(i));
		}
		return tmp;
	}

}
