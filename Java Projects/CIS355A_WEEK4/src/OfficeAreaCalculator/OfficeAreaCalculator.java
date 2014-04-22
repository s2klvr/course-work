package OfficeAreaCalculator;

/************************************************************************ 
Program Name: OfficeAreaCalculator.java
Programmer: Arron Thornton
Program Description: This GUI takes input from the user and calculates
the area of a room.
***********************************************************************/


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.GridLayout;
import java.text.DecimalFormat;

import javax.swing.JLabel;




public class OfficeAreaCalculator extends JPanel{
	
	private JFrame mainFrame;
	private JButton calculateButton;
	private JButton exitButton;
	private JTextField lengthField;
	private JTextField widthField;
	private JTextField areaField;
	private JLabel lengthLabel;
	private JLabel widthLabel;
	private JLabel areaLabel;
	
	public OfficeAreaCalculator() {
		mainFrame = new JFrame("Office Area Calculator");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setSize(260, 150);
		
		lengthLabel = new JLabel("Enter the length of the office:");
		lengthField = new JTextField(5);
		widthLabel = new JLabel("Enter the width of the office:");
		areaLabel = new JLabel("Office area:");
		
		widthField = new JTextField(5);
		areaField = new JTextField(5);
		areaField.setEditable(false);
		
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		}); 
		
		
		calculateButton = new JButton("Calculate");
		CalculateButtonHandler chandler = new CalculateButtonHandler();
		calculateButton.addActionListener(chandler);
		
		exitButton = new JButton("Exit");
		ExitButtonHandler ehandler = new ExitButtonHandler();
		exitButton.addActionListener(ehandler);
		
		FocusHandler fhandler = new FocusHandler();
		lengthField.addFocusListener(fhandler);
		widthField.addFocusListener(fhandler);
		areaField.addFocusListener(fhandler);
		
		
		Container c = mainFrame.getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.yellow);
		
		c.add(lengthLabel);
		c.add(lengthField);
		c.add(widthLabel);
		c.add(widthField);
		c.add(areaLabel);
		c.add(areaField);
		c.add(calculateButton);
		c.add(exitButton);
		
		calculateButton.setMnemonic(KeyEvent.VK_C);
		exitButton.setMnemonic(KeyEvent.VK_X);
		
		
	}
	
	class CalculateButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			DecimalFormat num = new DecimalFormat(",###.##");
			double width, length, area;
			String userInput;
			
			userInput = lengthField.getText();
			if (userInput.equals("")) {
				userInput = ("0");
				lengthField.setText("0");
			}
			length = Double.parseDouble(userInput);
			
			userInput = widthField.getText();
			if (userInput.equals("")) {
				userInput = ("0");
				widthField.setText("0");
			}
			width = Double.parseDouble(userInput);
			
			area = length * width;
			areaField.setText(num.format(area));
		}
	}
		
	class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
	}
	
	class FocusHandler implements FocusListener{
		public void focusGained(FocusEvent e) {
			if (e.getSource() == lengthField || e.getSource() == widthField) {
				areaField.setText("");
			} else if(e.getSource() == areaField){
				calculateButton.requestFocus();
			}
		
		}
		
		public void focusLost(FocusEvent e) {
			if (e.getSource() == widthField) {
				calculateButton.requestFocus();
			}
		}
	}

	public static void main(String[] args) {
		
		new OfficeAreaCalculator();
			
	}

}
	
