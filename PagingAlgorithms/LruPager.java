package week9;

// When fault occurs, evict whichever element was least recently used
// Front of array is most recently used
public class LruPager extends Pager {
	int frameSize;
	int faults = 0;
	int[] frames;

	int[] getFrames() {
		return frames;
	}

	LruPager(int size) {
		frameSize = size;
		frames = new int[frameSize];
	}

	boolean add(int in) {
		int loc = findSpace(in, frames);
		if (loc == -1) {
			// already in array, need to move to front
			int at = indexOf(in);
			if (at == 0) // already at front
				return false;
			shiftDown(in, at);
			frames[0] = in;
			return false;
		} else {
			// not in the array
			// shift all 1 to the right and insert at front
			shiftDown(in, 0);
			frames[0] = in;
		}
		faults++;
		return true;
	}

	int indexOf(int in) {
		for (int i = 0; i < frameSize; i++)
			if (frames[i] == in)
				return i;
		return -1;
	}

	void shiftDown(int in, int rightBound) {
		int bound = frameSize - 1;
		if (rightBound != 0)
			bound = rightBound;
		for (int i = bound; i > 0; i--) {
			frames[i] = frames[i - 1];
		}
	}
}
