package InheritanceTest;

public class Cube extends Point {

	private int depth;
	
	public int getDepth() {return depth;}
	public void setDepth(int depth) {this.depth = depth;}
	
	public Cube() {
		super();
		
	}
	
	public Cube(int dep, int x, int y) {
		super(x, y);
		setDepth(dep);
	}
	
	public int area () {
		return (int)(6*(Math.pow((int)getDepth(), 2)));
	}
	
	public int volume() {
		return ((int)Math.pow((int)getDepth(), 3));
	}
	
	public String toString() {
		return super.toString()
				+"\nThe cube's side depth is "+getDepth()
				+"\nThe cube's volume is "+volume()
				+"\nThe cube's area is "+area();
	}

}
