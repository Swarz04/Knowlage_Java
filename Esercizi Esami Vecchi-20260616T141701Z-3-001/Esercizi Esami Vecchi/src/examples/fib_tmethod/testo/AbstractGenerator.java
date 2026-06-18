package examples.fib_tmethod.testo;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGenerator implements Generator {

	private int last1;
	private int last2;
	private int numOut;

	public AbstractGenerator(final int first, final int second) {
		this.last1 = first;
		this.last2 = second;
	}

	@Override
	public int getNext() {
		if (numOut == 0) {
			numOut++;
			return last1;
		} else if (numOut == 1) {
			numOut++;
			return last2;
		} else {
			final int result = this.getNextFromThose(last1, last2);
			last1 = last2;
			last2 = result;
			return result;
		}
	}

	@Override
	public void skip(final int n) {
		for (int i = 0; i < n; i++) {
			this.getNext();
		}
	}

	@Override
	public int[] getNextArray(final int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = this.getNext();
		}
		return array;
	}

	@Override
	public List<Integer> getNextList(final int size) {
		final List<Integer> result = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			result.add(this.getNext());
		}
		return result;
	}

	protected abstract int getNextFromThose(int x, int y);

}
