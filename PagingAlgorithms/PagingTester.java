package week9;

import java.util.Random;

public class PagingTester {
	public static void main(String[] args) {
		int numPageFrames = 7;
		int numPages = 300;
		int print = 0; // 1 = print, 0 = no print
		
		Random r = new Random();
		int c = 0;
		int[] pages = new int[numPages];
		while (c < numPages) {
			int rand = r.nextInt(9) + 1;
			pages[c] = rand;
			c++;
		}
		
		// For exercise 9.6
		// int[] pages = {1, 2, 3, 4, 2, 1, 5, 6, 2, 1, 2, 3, 7, 6, 3, 2, 1, 2, 3, 6};
		
		FifoPager fp = new FifoPager(numPageFrames);
		LruPager lru = new LruPager(numPageFrames);
		OptPager opt = new OptPager(numPageFrames,pages); 
		
		System.out.printf("Number of page frames\t%d\nNumber of inputs\t%d\n\n",numPageFrames,numPages);
		
		fp.addBatch(pages, print);
		System.out.printf("%d faults\n\n", fp.faults);
		
		lru.addBatch(pages, print);
		System.out.printf("%d faults\n\n", lru.faults);
		
		opt.addBatch(pages, print);
		System.out.printf("%d faults\n\n", opt.faults);
	}
}
