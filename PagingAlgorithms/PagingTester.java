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
