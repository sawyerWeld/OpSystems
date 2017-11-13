package week9;

// When fault occurs, evict whichever element has been present longest
public class FifoPager extends Pager {
	int frameSize;
	int faults = 0;
	int[] frames;

	int[] getFrames() {
		return frames;
	}
	
	FifoPager(int size) {
		frameSize = size;
		frames = new int[frameSize];
	}

	boolean add(int in) {
		int loc = findSpace(in, frames);
		if (loc == -1)
			// already in array
			return false;
		if (loc == -2) {
			// add to end, shift up
			shift(in);
		} else {
			// found an empty space
			frames[loc] = in;
		}
		faults++;
		return true;
	}

	void shift(int in) {
		for (int i = 0; i < frameSize - 1; i++) {
			frames[i] = frames[i + 1];
		}
		frames[frameSize - 1] = in;
	}
}
