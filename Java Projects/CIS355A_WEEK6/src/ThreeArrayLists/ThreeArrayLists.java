/***********************************************************************
Program Name: ThreeArrayLists.java
Programmer's Name: Arron Thornton
Program Description: This program takes information from two double
arrays and transfers them into their own ArrayList object.  From there
The matching indices are calculated and stored in a third ArrayList.
***********************************************************************/

package ThreeArrayLists;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ThreeArrayLists {

	public static void main(String[] args) {
		
		double[] PRICE_ARRAY = { 10.62, 14.89, 13.21, 16.55, 18.62, 9.47, 6.58, 18.32, 12.15, 3.98 };
		double[] QUANTITY_ARRAY = { 4.0, 8.5, 6.0, 7.35, 9.0, 15.3, 3.0, 5.4, 2.9, 4.8 };
		
		ArrayList<Double> priceList = new ArrayList<Double>(10);
		ArrayList<Double> quantityList = new ArrayList<Double>(10);
		ArrayList<Double> amountList = new ArrayList<Double>(10);
		
		for (int i = 0; i < PRICE_ARRAY.length; i++) {
			priceList.add(PRICE_ARRAY[i]);
			quantityList.add(QUANTITY_ARRAY[i]);
		}
		extend(priceList, quantityList, amountList);
		display(priceList, quantityList, amountList);
		
	}
	
	public static void extend(ArrayList<Double> priceList, ArrayList<Double> quantityList, ArrayList<Double> amountList) {
		for (int i = 0; i < priceList.size(); i++) {
			amountList.add(priceList.get(i) * quantityList.get(i));
		}
	}
	
	public static void display(ArrayList<Double> priceList, ArrayList<Double> quantityList, ArrayList<Double> amountList) {
		DecimalFormat num = new DecimalFormat(",###.##");
		
		for (int i = 0; i < priceList.size(); i++) {
			System.out.println((i+1) + ")  "+ priceList.get(i) + " * "+quantityList.get(i) + " = " + num.format(amountList.get(i)));
		}
	}

}
