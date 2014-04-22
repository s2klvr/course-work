package InheritanceTest;

/************************************************************************ 
Program Name: InheritanceTest.java
Programmer: Arron Thornton
Program Description: This program utilizes inheritance and gathers
input from the user and then determines a squares area/perimeter, and
a cubes area/volume.
***********************************************************************/

import java.util.*;
import javax.swing.JOptionPane;

public class InheritanceTest {

	public static void main(String[] args) {
		
		int x = 0, y = 0, sl = 0;
		
		x = getNumber("X coordinate");
		y = getNumber("Y coordinate");
		sl = getNumber("side of Square");
			
			
		Point p = new Point(x, y);
		Square sq = new Square(sl, x, y);
		Cube cu = new Cube(sl, x, y);
		
		String outputString = sq.toString() + "\n"+ cu.toString();
		
		JOptionPane.showMessageDialog(null, outputString, "Results", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
	public static int getNumber(String msg) {
		int num = 0;
		String userInput = "";
		boolean isValid = false;
		
		while(!isValid) {
			userInput = JOptionPane.showInputDialog("Enter the " +msg);
			try {
				if (userInput != null) {
					num = Integer.parseInt(userInput);
					isValid = true;
					break;
				} else {
					JOptionPane.showMessageDialog(null, "Action Cancelled", "Cancel", JOptionPane.INFORMATION_MESSAGE);
					isValid = true;

				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Invalid number entered, try again!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return num;
	}

}
