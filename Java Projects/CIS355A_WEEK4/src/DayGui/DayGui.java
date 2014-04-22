 package DayGui;
 /************************************************************************ 
 Program Name: DayGui.java
 Programmer: Arron Thornton
 Program Description: This GUI gives the user two buttons to click and
 each button works differently.
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
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;


public class DayGui extends JPanel
{
	
	public DayGui() {
		JFrame mainframe = new JFrame("Messages");
		
		mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainframe.setSize(300, 200);
		mainframe.setVisible(true);
		
		Container c = mainframe.getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.RED);
		
		mainframe.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		
		}); 
		
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
		
		c.add(cmdGood);
		c.add(cmdBad);
		cmdGood.setMnemonic(KeyEvent.VK_G);
		cmdBad.setMnemonic(KeyEvent.VK_B);
		
	}

	
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		
		DayGui dg = new DayGui();
		
	}
}


