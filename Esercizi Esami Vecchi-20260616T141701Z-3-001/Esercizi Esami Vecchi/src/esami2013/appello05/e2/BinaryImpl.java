package esami2013.appello05.e2;

import java.util.ArrayList;
import java.util.List;

public class BinaryImpl implements Binary {

	private final List<Boolean> bitList = new ArrayList<>();

	@Override
	public int getInt() {
		int positionValue = 1;
		int result = 0;
		for (final boolean bit : bitList) {
			if (bit) {
				result += positionValue;
			}
			positionValue *= 2;
			if (positionValue < 0) {
				throw new IllegalStateException(
						"Il numero binario fornito supera il limite degli interi");
			}
		}
		return result;
	}

	@Override
	public void addBit(final int bit) {
		if (bit == 0 || bit == 1) {
			bitList.add(0, bit == 0 ? false : true);
		} else {
			throw new IllegalArgumentException();
		}
	}

	@Override
	public void reset() {
		bitList.clear();
	}

}
