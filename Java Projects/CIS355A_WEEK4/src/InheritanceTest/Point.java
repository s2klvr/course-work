package InheritanceTest;

public class Point {

	private int xCoord;
	private int yCoord;
	
	public int getXCoord () {return xCoord;}
	public int getyCoord () {return yCoord;}
	public void setXCoord (int x) {xCoord = x;}
	public void setYCoord (int y) {yCoord = y;}
	
	public Point () {
		setXCoord(0);	
		setYCoord(0);
	}
	
	public Point (int x, int y) {
		setXCoord(x);	
		setYCoord(y);
	}
	
	public String toString() {
		return "\nThe coordinates are ("+getXCoord()+", "+getyCoord()+")";
	}
}
