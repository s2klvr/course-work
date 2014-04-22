package TabbedPane;
/************************************************************************ 
Program Name: TabbedPane.java
Programmer: Arron Thornton
Program Description: This GUI combines the 2 previous GUI programs 
DayGui.java and OfficeAreaCalculator.java.
***********************************************************************/

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.UIManager;



public class TabbedPane extends JFrame 
{

	public TabbedPane() {
		
		JTabbedPane jtp = new JTabbedPane();
		
		
		jtp.addTab("Day GUI", new DayGui());
		jtp.addTab("Office Area Calculator", new OfficeAreaCalculator());
		
		getContentPane().add(jtp);
		
	}
	
	public class DayGui extends JPanel
	{
		
		public DayGui() {
			setBackground(Color.red);
			
			JButton cmdGood = new JButton("Good");
			cmdGood.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "It's a Good Day!", "Good", JOptionPane.INFORMATION_MESSAGE);
				}
			});
		
			JButton cmdBad = new JButton("Bad");
			cmdBad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "It's a Bad Day!", "Bad", JOptionPane.INFORMATION_MESSAGE);
				}
			});
			
			add(cmdGood);
			add(cmdBad);
			cmdGood.setMnemonic(KeyEvent.VK_G);
			cmdBad.setMnemonic(KeyEvent.VK_B);
			
		}
	}
	
	public class OfficeAreaCalculator extends JPanel{
		
		
		private JButton calculateButton;
		private JButton exitButton;
		private JTextField lengthField;
		private JTextField widthField;
		private JTextField areaField;
		private JLabel lengthLabel;
		private JLabel widthLabel;
		private JLabel areaLabel;
		
		public OfficeAreaCalculator() {
			
			
			lengthLabel = new JLabel("Enter the length of the office:");
			lengthField = new JTextField(5);
			widthLabel = new JLabel("Enter the width of the office:");
			areaLabel = new JLabel("Office area:");
			
			widthField = new JTextField(5);
			areaField = new JTextField(5);
			areaField.setEditable(false);
			
			
			
			
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
			
			
			
			setLayout(new FlowLayout());
			setBackground(Color.yellow);
			
			add(lengthLabel);
			add(lengthField);
			add(widthLabel);
			add(widthField);
			add(areaLabel);
			add(areaField);
			add(calculateButton);
			add(exitButton);
			
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
	}


	public static void main(String[] args) {
		TabbedPane test = new TabbedPane();
		test.setVisible(true);
		test.setSize(300, 200);
	}

}
