package week10;

public class Cylinder {
	
	int loc;
		
	public Cylinder(int loc_) {
		loc = loc_;
	}
	
	public int loc() {
		return loc;
	}

	public int dist(Cylinder c) {
		return Math.abs(c.loc - loc);
	}
	
	@Override
	public boolean equals(Object o) {
		Cylinder c = (Cylinder) o;
		return (loc == c.loc);
	}
}
