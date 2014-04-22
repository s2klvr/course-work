/***********************************************************************
Program Name: Index2.java
Programmer's Name: Arron Thornton
Program Description: This program takes a string input into the first
field and then counts the occurrences of each letter within the entered
string.  The program then displays the data in the final output area.
***********************************************************************/

package Index2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Index2 {
	
	private JFrame mainFrame;
	private JButton countOccur;
	private JButton clearBtn;
	private JButton exitBtn;
	private JTextArea enterArea;
	private JTextArea outputArea;
	private JLabel enterLabel;
	private JPanel center;
	private JPanel bottom;
	
	public Index2() {
		mainFrame = new JFrame("Character Counter");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setSize(250, 650);
		
		enterLabel = new JLabel("Enter some text:");
		
		enterArea = new JTextArea();
		enterArea.setColumns(20);
		enterArea.setEditable(true);
		enterArea.setRows(5);
		enterArea.setBorder(new LineBorder(Color.black));
		enterArea.setLineWrap(true);
		enterArea.setWrapStyleWord(true);
		
		outputArea = new JTextArea();
		outputArea.setColumns(10);
		outputArea.setEditable(true);
		outputArea.setRows(25);
		outputArea.setBorder(new LineBorder(Color.black));
		
		countOccur = new JButton("Count Occurences of Each Letter");
		CountButtonHandler cohandler = new CountButtonHandler();
		countOccur.addActionListener(cohandler);
		countOccur.setMnemonic(KeyEvent.VK_C);
		
		clearBtn = new JButton("Clear");
		ClearButtonHandler chandler = new ClearButtonHandler();
		clearBtn.addActionListener(chandler);
		clearBtn.setMnemonic(KeyEvent.VK_L);
		
		exitBtn = new JButton("Exit");
		ExitButtonHandler ehandler = new ExitButtonHandler();
		exitBtn.addActionListener(ehandler);
		exitBtn.setMnemonic(KeyEvent.VK_X);
		
		Container c = mainFrame.getContentPane();
		c.setLayout(new BorderLayout());
		
		center = new JPanel();
		center.setVisible(true);
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		bottom = new JPanel();
		bottom.setVisible(true);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		center.add(enterLabel);
		center.add(enterArea);
		center.add(countOccur);
		center.add(outputArea);
		bottom.add(clearBtn);
		bottom.add(exitBtn);
		
		c.add(center, BorderLayout.CENTER);
		c.add(bottom, BorderLayout.SOUTH);
		
	}
	
	//count button handler
	class CountButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			char[] alphabetArray = {'a', 'b', 'c','d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
			for (int i = 0; i < alphabetArray.length; i++) {
				outputArea.append(alphabetArray[i]+":\t"+charOccurCount(alphabetArray[i])+"\n");
			}		
		}
	}
	
	private int charOccurCount(char check) {
		int count = 0;
		char[] charArray = enterArea.getText().toLowerCase().toCharArray(); 
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == check ) {
				count++;
				
			}
		}
		return count;
	}
	
	//clear button handler
	class ClearButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent arg0) {
				enterArea.setText(null);
				outputArea.setText(null);
			
			}
		}
		
	//exit button handler
	class ExitButtonHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		}

	public static void main(String[] args) {
		new Index2();
		
//		Write a Java GUI application Index2.java based on the program in project1 that input several lines of text and uses String method indexOf to determine...

	}

}
