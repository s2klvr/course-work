/***********************************************************************
Program Name: TextFileIO.java
Programmer's Name: Arron Thornton
Program Description: This program writes a sequence of numbers to a
file and then displays the first set.  Then, it appends another
sequence of numbers and displays the new file
***********************************************************************/

package TextFileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.Scanner;

public class TextFileIO {

	public static void main(String[] args)  {
		
		// OutputStream to write the first batch of info to the file
		try {
			OutputStream outputStream = new FileOutputStream("\\numbers.dat");
			Writer writer = new OutputStreamWriter(outputStream);
			
			for (int i = 2; i <= 100; i+=2) {
			writer.write(i +"\n");
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		// The Scanner to read and display the info from the first batch
		// of info on the file
		try {
			Scanner fileIn = new Scanner(new File("\\numbers.dat"));
			while (fileIn.hasNext()) {
				System.out.print(fileIn.next()+",");
			}
			fileIn.close();
		} catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		System.out.println();
		
		// OutputStream to append the second batch of info to the file
		try {
			OutputStream outputStream = new FileOutputStream("\\numbers.dat", true);
			Writer writer = new OutputStreamWriter(outputStream);
			
			for (int i = 1; i <= 100; i+=2) {
			writer.write(i +"\n");
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
		// The Scanner to read and display the new information contained in the file
		try {
			Scanner fileIn = new Scanner(new File("\\numbers.dat"));
			while (fileIn.hasNext()) {
				System.out.print(fileIn.next()+",");		
			}
			fileIn.close();
		} catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		}
		
	}
}
