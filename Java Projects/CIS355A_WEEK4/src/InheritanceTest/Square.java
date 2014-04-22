package InheritanceTest;

public class Square extends Point {

	private int sideLength;
	
	public int getSideLength() {return sideLength;}
	public void setSideLength(int sq) {this.sideLength = sq;}
	
	public Square() {
		super ();
		setSideLength(0);;
	}
	
	public Square(int sl, int x, int y) {
		super (x, y);
		setSideLength(sl);
	}

	public int area() {
		return (int)Math.pow((int)getSideLength(), 2);
	}
	
	public int perimeter() {
		return getSideLength() *4;
	}
	
	public String toString() {
		return super.toString() +
				"\nThe square's side length is "+getSideLength()
			   +"\nThe Square's perimeter is "+perimeter()
			   +"\nThe square's area is "+area();
	}
}