/***********************************************************************
 Program Name: GuessGame.java
 Programmer's Name: Arron Thornton
 Program Description: This program creates a GUI guessing game.  It
 creates a random number between 1 and 1000, counts the amount of guesses
 and displays if each guess is too high or too low.
 ***********************************************************************/ 


package GuessGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.KeyEvent;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.IllegalFormatCodePointException;
import java.util.Random;

public class GuessGame extends JFrame{
	static Random rnd = new Random();
	private static int randomNumber = rnd.nextInt(1000);
	private static int counter = 0;
	
	private JFrame mainFrame;
	private JTextField inputField;
	private JButton guessBtn;
	private JButton newBtn;
	private JButton exitBtn;
	private JLabel guessDisplay;
	private JLabel mainDisplay;
	private JLabel guessCounter;
	private JLabel highLow;
	private JPanel top;
	private JPanel center;
	private JPanel bottom;

	
	
	
	public GuessGame() {
				
		mainFrame = new JFrame("Guessing Game");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		mainFrame.setSize(425, 200);
		
		inputField = new JTextField(5);
		
		
		guessDisplay = new JLabel("Please enter your guess: ");
		mainDisplay = new JLabel("I have a number between 1 and 1000 -- can you guess my number?");
		guessCounter = new JLabel("Current amount of guesses: " + counter);
		highLow = new JLabel();
		
		guessBtn = new JButton("Guess!");
		GuessButtonHandler ghandler = new GuessButtonHandler();	
		guessBtn.addActionListener(ghandler);
		guessBtn.setMnemonic(KeyEvent.VK_G);
		
		newBtn = new JButton("New Game");
		NewButtonHandler nhandler = new NewButtonHandler();
		newBtn.addActionListener(nhandler);
		newBtn.setMnemonic(KeyEvent.VK_N);
		
		exitBtn = new JButton("Exit");
		ExitButtonHandler ehandler = new ExitButtonHandler();
		exitBtn.addActionListener(ehandler);
		exitBtn.setMnemonic(KeyEvent.VK_X);
		
		Container c = mainFrame.getContentPane();
		
		c.setLayout(new BorderLayout());
		
		top = new JPanel();
		top.setVisible(true);
		top.setBackground(Color.yellow);
		top.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		top.add(mainDisplay);
		c.add(top, BorderLayout.PAGE_START);
		
		center = new JPanel();
		center.setVisible(true);
		center.setBackground(Color.yellow);
		center.setLayout(new FlowLayout(10, 10, 10));
		
		center.add(guessDisplay);
		center.add(inputField);
		center.add(guessCounter);
		center.add(highLow);
		c.add(center, BorderLayout.CENTER);
		
		bottom = new JPanel();
		bottom.setVisible(true);
		bottom.setBackground(Color.yellow);
		bottom.setLayout(new FlowLayout());
		
		bottom.add(guessBtn);
		bottom.add(newBtn);
		bottom.add(exitBtn);
		c.add(bottom, BorderLayout.PAGE_END);

		
	}
	
	class GuessButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			
			int userGuess = 0;
			String userInput = inputField.getText();
			
			if (userInput.equals("")) {
				userInput = ("0");
				inputField.setText("0");
			}
			userGuess = Integer.parseInt(userInput);
			
			if (userGuess != randomNumber) {
				if (userGuess > randomNumber) {
					highLow.setText("Too High!");
					if (userGuess > ((1000-randomNumber)/2)+randomNumber) {
						center.setBackground(Color.blue);
					} else {
						center.setBackground(Color.red);
					}
					inputField.setText("");
				} else {
					highLow.setText("Too Low!");
					
					if (userGuess < randomNumber-(randomNumber/2)) {
						center.setBackground(Color.blue);
					} else {
						center.setBackground(Color.red);
					}
					inputField.setText("");
				}
			} else {
				center.setBackground(Color.green);
				highLow.setText("YOU GOT IT!!!!");
				inputField.setText("");
				inputField.setEditable(false);
				guessBtn.setEnabled(false);
				
				
			}
			
			counter++;
			guessCounter.setText("Current amount of guesses: " + counter);
		}
	}
	
	class NewButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			randomNumber = rnd.nextInt(1000);
			highLow.setText("New Game");
			inputField.setEditable(true);
			guessBtn.setEnabled(true);
			center.setBackground(Color.yellow);
			counter = 0;
			
		}
	}
	class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		
		new GuessGame();

	}

}
