package week10;

import java.util.ArrayList;
public class FCFSscheduler {
	int totaldist;
	public FCFSscheduler(ArrayList<Cylinder> cylinders, int init) {
		Cylinder cur = new Cylinder(init);
		for (Cylinder c : cylinders) {
			totaldist+=cur.dist(c);
			cur = c;
		}
	}
	
}
