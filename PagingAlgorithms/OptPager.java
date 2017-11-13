package week9;

public class OptPager extends Pager {
	int frameSize;
	int faults = 0;
	int[] frames;
	int numIndex = 0; // where in nums we are
	int[] nums; // the entire string we're going to add

	int[] getFrames() {
		return frames;
	}

	OptPager(int size, int[] _nums) {
		frameSize = size;
		frames = new int[frameSize];
		nums = _nums;
	}

	boolean add(int in) {
		int loc = findSpace(in, frames);
		if (loc == -1) {
			// already in array
			numIndex++;
			return false;
		}
		if (loc == -2) {
			// add to end, shift up
			frames[findReplacement()] = in;
		} else {
			// found an empty space
			frames[loc] = in;
		}
		faults++;
		numIndex++;
		return true;
	}

	int findReplacement() {
		int[] distances = new int[frameSize]; // distance to use
		for (int i = 0; i < frameSize; i++) {
			distances[i] = findDist(frames[i]);
		}
		// return max in distance
		int max = -1;
		int maxIndex = 0;
		for (int i = 0; i < frameSize; i++) {
			int cur = distances[i];
			if (cur == -1)// will never be used
				return i;
			if (cur > max) {
				max = cur;
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	int findDist(int in) {
		for (int i = numIndex; i < nums.length; i++)
			if (nums[i] == in)
				return i;
		return -1;
	}
}
