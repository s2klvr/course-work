/***********************************************************************
Program Name: Index.java
Programmer's Name: Arron Thornton
Program Description: This program takes a string input and then allows
the user to enter and search for the number of occurrences of a specified
letter.
***********************************************************************/

package Index;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class Index {

	private JFrame mainFrame;
	private JLabel searchLabel;
	private JLabel charLabel;
	private JTextArea searchArea;
	private JTextField charField;
	private JButton searchBtn;
	private JButton clearBtn;
	private JButton exitBtn;
	private JPanel center;
	private JPanel bottom;
	
	public Index() {
		
		mainFrame = new JFrame("Character Finder");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setSize(400, 200);
		
		searchLabel = new JLabel("Enter text to be searched");
		charLabel = new JLabel("Enter a character");
		
		searchArea = new JTextArea();
		searchArea.setColumns(20);
		searchArea.setLineWrap(true);
		searchArea.setRows(4);
		searchArea.setEditable(true);
		searchArea.setBorder(new LineBorder(Color.black));
		
		charField = new JTextField(5);
		charField.setPreferredSize(new Dimension(30, 20));
		
		searchBtn = new JButton("Search");
		SearchButtonHandler shandler = new SearchButtonHandler();
		searchBtn.addActionListener(shandler);
		searchBtn.setMnemonic(KeyEvent.VK_S);
		
		clearBtn = new JButton("Clear");
		ClearButtonHandler chandler = new ClearButtonHandler();
		clearBtn.addActionListener(chandler);
		clearBtn.setMnemonic(KeyEvent.VK_C);
		
		exitBtn = new JButton("Exit");
		ExitButtonHandler ehandler = new ExitButtonHandler();
		exitBtn.addActionListener(ehandler);
		exitBtn.setMnemonic(KeyEvent.VK_X);
		
		Container c = mainFrame.getContentPane();
		
		center = new JPanel();
		center.setVisible(true);
		center.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		bottom = new JPanel();
		bottom.setVisible(true);
		bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		c.setLayout(new BorderLayout());
		
		center.add(searchLabel);
		center.add(searchArea);
		center.add(charLabel);
		center.add(charField);
		
		bottom.add(searchBtn);
		bottom.add(clearBtn);
		bottom.add(exitBtn);
		
		c.add(center, BorderLayout.CENTER);
		c.add(bottom, BorderLayout.SOUTH);
		
		
		
	}
	
	//search button handler
	class SearchButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent arg0) {
			int charOccur = 0;
			char[] input = searchArea.getText().toLowerCase().toCharArray();
			for (int i = 0; i < input.length; i++) {
				if(input[i] == charField.getText().toLowerCase().charAt(0)) {
					charOccur++;
				}
			}
			JOptionPane.showMessageDialog(null, "Number of "+ charField.getText().toUpperCase()+"'s: "+charOccur);
			
		}
	}
	
	//clear button handler
	class ClearButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			searchArea.setText(null);
			charField.setText(null);
		
		}
	}
	
	//exit button handler
	class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Index();

	}

}
