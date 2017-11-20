package week10;

import java.util.ArrayList;

public class CLOOKscheduler {
	ArrayList<Cylinder> cylinders = new ArrayList<Cylinder>();
	int totaldist;
	Boolean[] disk = new Boolean[5000];
	
	public CLOOKscheduler(ArrayList<Cylinder> cylinders_, int init) {
		for (Cylinder c : cylinders_) {
			cylinders.add(c);
		}
		// populate disk
		for (int i = 0; i < disk.length; i++) {
			disk[i] = false;
		}
		for (Cylinder c : cylinders) {
			disk[c.loc] = true;
		}
		int prev = init; // previous thing we found
		int dx = 1; // direction of head
		int head = init; // head location
		int changes = 0; // num of changes in dx
		while(!(changes == 1 && head == init)) {
			//System.out.println(head);
			if (disk[head] == true) {
				disk[head] = false;
				totaldist += Math.abs(prev - head);
				prev = head;
			}
			if (head == 4999) {
				prev = 0; // circle around
				head = 0;
				changes++;
			}
			head+=dx;
		}
	}
}
