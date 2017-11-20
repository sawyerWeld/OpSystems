package week10;

import java.util.ArrayList;
import java.util.Arrays;

/*
 * Your program will service a disk with 5,000 cylinders numbered 0 to
 * 4,999. The program will generate a random series of 1,000 cylinder
 * requests and service them according to each of the algorithms listed
 * above. The program will be passed the initial position of the disk head
 * (as a parameter on the command line) and report the total amount of
 * head movement required by each algorithm.
 */
public class DiskSchduleTester {

	public static void main(String[] args) {
		// init pos = args[0];
		
		ArrayList<Cylinder> cylinders = new ArrayList<Cylinder>();
		for (int i = 0; i < 1000; i++) {
			int n = (int) (Math.random()*5000);
			cylinders.add(new Cylinder(n));
		}
		
		int init = 2150;
		
		cylinders.clear();
		int[] bookexample = {2069, 1212, 2296, 2800, 544, 1618, 356, 1523, 4965, 3681};
		for (int i = 0; i < bookexample.length; i++) {
			Cylinder c = new Cylinder(bookexample[i]);
			cylinders.add(c);
		}
		
		FCFSscheduler fcfs = new FCFSscheduler(cylinders, init);
		System.out.println("fcfs\t"+fcfs.totaldist);
		
		SSTFscheduler sstf = new SSTFscheduler(cylinders, init);
		System.out.println("sstf\t"+sstf.totaldist);
		
		SCANscheduler scan = new SCANscheduler(cylinders, init);
		System.out.println("scan\t"+scan.totaldist);
		
		CSCANscheduler cscan = new CSCANscheduler(cylinders, init);
		System.out.println("cscan\t"+cscan.totaldist);	
		
		LOOKscheduler look = new LOOKscheduler(cylinders, init);
		System.out.println("look\t"+look.totaldist);
		
		CLOOKscheduler clook = new CLOOKscheduler(cylinders, init);
		System.out.println("clook\t"+clook.totaldist);
	}

}
