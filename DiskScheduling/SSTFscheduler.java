package week10;

import java.util.ArrayList;

public class SSTFscheduler {
	ArrayList<Cylinder> cylinders = new ArrayList<Cylinder>();
	int totaldist;
	
	Cylinder findNext(Cylinder cur) {
		int mindist = Integer.MAX_VALUE;
		Cylinder minCyl = null;
		for (int i = 0; i < cylinders.size(); i++) {
			Cylinder c = cylinders.get(i);
			int dist = cur.dist(c); 
			if (dist < mindist) {
				mindist = dist;
				minCyl = c;
			}
		}
		return minCyl;
	}
	
	public SSTFscheduler(ArrayList<Cylinder> cylinders_, int init) {
		for (Cylinder c : cylinders_) {
			cylinders.add(c);
		}
		Cylinder cur = new Cylinder(init);
		while(cylinders.size() > 0) {
			Cylinder c = findNext(cur);
			//System.out.println(c.loc);
			totaldist += cur.dist(c);
			cur = c;
			cylinders.remove(c);
		}
	}

}
