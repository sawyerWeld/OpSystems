package week9;

import java.util.Arrays;

public abstract class Pager {

	// OVERRIDE THIS
	int[] getFrames() {
		assert (true == false);
		return null;
	}

	void print() {
		System.out.print(Arrays.toString(getFrames()));
	}

	// return true if there was a page fault
	// OVERRIDE THIS
	boolean add(int in) {
		assert (true == false);
		return false;
	}

	/*
	 * Finds index page should be added -1 if the page is present -2 if the page
	 * is full and its not present
	 */
	int findSpace(int in, int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				return i;
			} else if (arr[i] == in) {
				return -1;
			}
		}
		return -2;
	}

	void addBatch(int[] pages, int print) {
		String className = this.getClass().getSimpleName();
		System.out.println(className);
		for (int i : pages) {
			boolean b = add(i);
			if (print == 1) {
				System.out.printf("%d: ", i);

				String fault = (b) ? " ++ \n" : "\n";
				print();
				System.out.printf("%s", fault);
			}
		}
	}
}
