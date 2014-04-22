/***********************************************************************
Program Name: CourseProject.java
Programmer's Name: Arron Thornton
Program Description: This GUI program is used as a specifications
calculator  for pools and spas.  The current functioning tabs are the
pool volume calculator and the spa volume calculator.  Currently under
construction are the calculator tab, customers tab, and cust info tab.
Customers tab is nearing completion using a database instead of files.
***********************************************************************/


package CourseProject;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.ButtonGroup;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;




public class CourseProject extends JFrame{

	DecimalFormat num = new DecimalFormat(",###.##");
	static final String url = "jdbc:odbc:CustomerList";
	static int customerID = 0;
	Connection cnn = null;
	Statement stmt;
	ResultSet rs;
	
	public CourseProject() {
		
		setSize(300, 300);
		setResizable(false);
		JTabbedPane jtp = new JTabbedPane();

		jtp.addTab("Pool", new poolTab());
		jtp.addTab("Spa", new spaTab());
		jtp.addTab("Calculator", new lengthCalcTab());
		jtp.addTab("Customers", new customerTab());
		jtp.addTab("Cust Info", new customerInfoTab());
		
		getContentPane().add(jtp);
	}
	
	public class poolTab extends JPanel{
		
		private JRadioButton newRadioButton;
		private JRadioButton existingRadioButton;
		private JLabel poolLenLbl;
		private JLabel poolWidLbl;
		private JLabel poolDepLbl;
		private JLabel poolVolLbl;
		private JTextField lengthInput;
		private JTextField widthInput;
		private JTextField depthInput;
		private JTextField volumeField;
		private JButton calculateBtn;
		private JButton saveBtn;
		private JButton exitBtn;
		
		public poolTab () {
			
			
			newRadioButton = new JRadioButton("New");
			newRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					lengthInput.setEnabled(true);
					widthInput.setEnabled(true);
					depthInput.setEnabled(true);
					
				}
			});
			newRadioButton.setVisible(true);
			newRadioButton.setActionCommand("New");
			
			existingRadioButton = new JRadioButton("Existing");
			existingRadioButton.setVisible(true);
			existingRadioButton.setEnabled(false);

			ButtonGroup group = new ButtonGroup();
			group.add(newRadioButton);
			group.add(existingRadioButton);
			
			poolLenLbl = new JLabel("Enter the pool's length (ft):");
			poolWidLbl = new JLabel("Enter the pool's width (ft):");
			poolDepLbl = new JLabel("Enter the pool's Depth (ft):");
			poolVolLbl = new JLabel("Enter the pool's volume is (ft^3):");
			
			lengthInput = new JTextField(5);
			lengthInput.setEnabled(false);
			widthInput = new JTextField(5);
			widthInput.setEnabled(false);
			depthInput = new JTextField(5);
			depthInput.setEnabled(false);
			volumeField = new JTextField(5);
			volumeField.setEnabled(false);
			volumeField.setEditable(false);
			
			calculateBtn = new JButton("Calculate");
			calculateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (lengthInput.getText().isEmpty()) {
						lengthInput.setText("0");
					}
					if (widthInput.getText().isEmpty()) {
						widthInput.setText("0");
					}
					if (depthInput.getText().isEmpty()) {
						depthInput.setText("0");
					}
				
					double length = Double.parseDouble(lengthInput.getText());
					double width = Double.parseDouble(widthInput.getText());
					double depth = Double.parseDouble(depthInput.getText());
					double volume = length * width * depth;
					volumeField.setEnabled(true);
					volumeField.setText(num.format(volume));
				}
			});
			calculateBtn.setMnemonic(KeyEvent.VK_C);
			
			saveBtn = new JButton("Save");
			saveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			saveBtn.setMnemonic(KeyEvent.VK_S);
			saveBtn.setEnabled(false);
			
			exitBtn = new JButton("Exit");
			ExitButtonHandler ehandler = new ExitButtonHandler();
			exitBtn.addActionListener(ehandler);
			exitBtn.setMnemonic(KeyEvent.VK_X);
			
			setLayout(new BorderLayout());
			
			Container top = new Container();
			top.setLayout(new FlowLayout());
			top.add(newRadioButton);
			top.add(existingRadioButton);
			
			add(top, BorderLayout.NORTH);
			
			Container center = new Container();
			center.setLayout(new FlowLayout());
			center.add(poolLenLbl);
			center.add(lengthInput);
			center.add(poolWidLbl);
			center.add(widthInput);
			center.add(poolDepLbl);
			center.add(depthInput);
			center.add(poolVolLbl);
			center.add(volumeField);
			
			add(center, BorderLayout.CENTER);

			Container bottom = new Container();
			bottom.setLayout(new FlowLayout());
			bottom.add(calculateBtn);
			bottom.add(saveBtn);
			bottom.add(exitBtn);
			
			add(bottom, BorderLayout.SOUTH);

			
		}
		
	}
	
	public class spaTab extends JPanel{
		private JRadioButton roundRadioButton;
		private JRadioButton ovalRadioButton;
		private JRadioButton squareRadioButton;
		private JLabel lengthLabel;
		private JLabel widthLabel;
		private JLabel depthLabel;
		private JLabel volumeLabel;
		private JTextField tubLength;
		private JTextField tubWidth;
		private JTextField tubDepth;
		private JTextField tubVolume;
		private JButton calculateBtn;
		private JButton saveBtn;
		private JButton exitBtn;
		
		public spaTab() {
			roundRadioButton = new JRadioButton("Round", true);
			roundRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tubWidth.setEnabled(false);
					tubLength.setText("");
					tubWidth.setText("");
					tubDepth.setText("");
					tubVolume.setText("");
				}
			});
			roundRadioButton.setActionCommand("round");
			
			ovalRadioButton = new JRadioButton("Oval");
			ovalRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tubWidth.setEnabled(true);
					tubLength.setText("");
					tubWidth.setText("");
					tubDepth.setText("");
					tubVolume.setText("");
				}
			});
			ovalRadioButton.setActionCommand("oval");
			
			squareRadioButton = new JRadioButton("Square/Rectangle");
			squareRadioButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					tubWidth.setEnabled(true);
					tubLength.setText("");
					tubWidth.setText("");
					tubDepth.setText("");
					tubVolume.setText("");
				}
			});
			squareRadioButton.setActionCommand("square");
			
			ButtonGroup group = new ButtonGroup();
			group.add(roundRadioButton);
			group.add(ovalRadioButton);
			group.add(squareRadioButton);
			
			lengthLabel = new JLabel("Enter the tub's length (ft):");
			widthLabel = new JLabel("Enter the tub's width (ft):");
			depthLabel = new JLabel("Enter the tub's depth (ft):");
			volumeLabel = new JLabel("The tub's volume is (ft^3):");
			
			tubLength = new JTextField(5);
			tubWidth = new JTextField(5);
			tubWidth.setEnabled(false);
			tubDepth = new JTextField(5);
			tubVolume = new JTextField(5);
			tubVolume.setEnabled(false);
			tubVolume.setEditable(false);
			
			calculateBtn = new JButton("Calculate");
			calculateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if (tubLength.getText().isEmpty()) {
						tubLength.setText("0");
					}
					if (tubWidth.getText().isEmpty()) {
						tubWidth.setText("0");
					}
					if (tubDepth.getText().isEmpty()) {
						tubDepth.setText("0");
					}
				
					double length = Double.parseDouble(tubLength.getText());
					double width = Double.parseDouble(tubWidth.getText());
					double depth = Double.parseDouble(tubDepth.getText());
					double volume = 0;
					if (roundRadioButton.isSelected()) {
						volume = Math.PI*Math.pow((length/2), 2)*depth;
					}
					if (ovalRadioButton.isSelected()) {
						volume = Math.PI*length*width*depth /4;
					}
					if (squareRadioButton.isSelected()) {
						volume = length*width*depth;
					}
					
					tubVolume.setEnabled(true);
					tubVolume.setText(num.format(volume));
				}
			});
			calculateBtn.setMnemonic(KeyEvent.VK_C);
			
			saveBtn = new JButton("Save");
			saveBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			saveBtn.setMnemonic(KeyEvent.VK_S);
			saveBtn.setEnabled(false);
			
			exitBtn = new JButton("Exit");
			ExitButtonHandler ehandler = new ExitButtonHandler();
			exitBtn.addActionListener(ehandler);
			exitBtn.setMnemonic(KeyEvent.VK_X);
			
			setLayout(new BorderLayout());
			
			Container top = new Container();
			top.setLayout(new FlowLayout());
			top.add(roundRadioButton);
			top.add(ovalRadioButton);
			top.add(squareRadioButton);
			
			add(top, BorderLayout.NORTH);
			
			Container center = new Container();
			center.setLayout(new FlowLayout());
			center.add(lengthLabel);
			center.add(tubLength);
			center.add(widthLabel);
			center.add(tubWidth);
			center.add(depthLabel);
			center.add(tubDepth);
			center.add(volumeLabel);
			center.add(tubVolume);
			
			add(center, BorderLayout.CENTER);

			Container bottom = new Container();
			bottom.setLayout(new FlowLayout());
			bottom.add(calculateBtn);
			bottom.add(saveBtn);
			bottom.add(exitBtn);
			
			add(bottom, BorderLayout.SOUTH);
			
		}
	}
	
	public class customerTab extends JPanel{
		private JList customerList;
		private DefaultListModel listModel;
		private JButton exitBtn;
		private JButton addCustomerBtn;
		private JButton refreshBtn;
		private JButton loadBtn;
		private JTextArea errorArea;
		
		public customerTab() {
			listModel = new DefaultListModel();
			
			
			customerList = new JList(listModel);
			customerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			customerList.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
										
				}
			});
			customerList.setVisibleRowCount(5);
			customerList.setBorder(new LineBorder(Color.black));
			customerList.setPreferredSize(new Dimension(275, 100));;

			
			errorArea = new JTextArea();
			errorArea.setColumns(25);
			errorArea.setRows(2);
			errorArea.setEnabled(false);
			errorArea.setLineWrap(true);
			errorArea.setWrapStyleWord(true);
			
			addCustomerBtn = new JButton("Add Customer");
			addCustomerBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
										
				}
			});
			addCustomerBtn.setMnemonic(KeyEvent.VK_A);
			
			refreshBtn = new JButton("Refresh List");
			refreshBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {				
					listModel.clear();
					createConnection();
					ArrayList<String> customerList = new ArrayList<String>();						
					customerList.addAll(loadCustomerNameToArray());
					Collections.sort(customerList);
	
					for (String s : customerList) {
						listModel.addElement(s);
					}
					errorArea.setText("Connecting to database....");

					closeResources();
				}
			});
			refreshBtn.setMnemonic(KeyEvent.VK_R);
			
			loadBtn = new JButton("Load");
			loadBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			loadBtn.setMnemonic(KeyEvent.VK_L);
			
			exitBtn = new JButton("Exit");
			ExitButtonHandler ehandler = new ExitButtonHandler();
			exitBtn.addActionListener(ehandler);
			exitBtn.setMnemonic(KeyEvent.VK_X);
			
			setLayout(new BorderLayout());
			
			Container top = new Container();
			top.setLayout(new FlowLayout());
			top.add(customerList);
		
			add(top, BorderLayout.NORTH);
			
			Container center = new Container();
			center.setLayout(new FlowLayout());
			center.add(loadBtn);
			center.add(addCustomerBtn);
			center.add(errorArea);
			
			add(center, BorderLayout.CENTER);

			Container bottom = new Container();
			bottom.setLayout(new FlowLayout());
			bottom.add(refreshBtn);
			bottom.add(exitBtn);
			
			add(bottom, BorderLayout.SOUTH);
			
		}
	}
	
	public class lengthCalcTab extends JPanel{
		private JButton convertBtn;
		private JButton exitBtn;
		private JLabel milliLabel;
		private JLabel meterLabel;
		private JLabel yardLabel;
		private JLabel feetLabel;
		private JLabel inchLabel;
		private JTextField milliField;
		private JTextField meterField;
		private JTextField yardField;
		private JTextField feetField;
		private JTextField inchField;
		
		public lengthCalcTab() {
			
		}
	}
	
	public class newCustomer{
		private JLabel nameLabel;
		private JLabel addressLabel;
		private JLabel cityLabel;
		private JLabel stateLabel;
		private JLabel zipLabel;
		private JLabel phoneLabel;
		private JLabel existingPoolLabel;
		private JLabel existingSpaLabel;
		private JRadioButton poolButton;
		private JRadioButton spaButton;
		private Checkbox pool;
		private Checkbox spa;
		private JTextField nameField;
		private JTextField addressField;
		private JTextField cityField;
		private JTextField stateField;
		private JTextField zipField;
		private JTextField phoneField;
		private JButton saveBtn;
		private JButton exitBtn;
		private JButton clearBtn;
		
		public newCustomer(){
			
		}
		
	}
	
	public class customerInfoTab extends JPanel{
		
	}
	
	public void customerInfoToFile() {
		String fileOutput;
		
	}
	
	public class Customer{
		
		private String firstName, lastName, address, city, state, zip, phone;
		private boolean hasPool, hasSpa;
		private Pool pool;
		private Spa spa;
		private int customerID;
		
		public String getFirstName() {return firstName;}
		public String getLastName() {return lastName;}
		public String getAddress() {return address;}
		public String getCity() {return city;}
		public String getState() {return state;}
		public String getZip() {return zip;}
		public String getPhone() {return phone;}
		public boolean getHasPool() {return hasPool;}
		public boolean getHasSpa() {return hasSpa;}
		public Pool getPool() {return pool;}
		public Spa getSpa() {return spa;}
		
		
		public void setFirstName(String fn) {firstName = fn;}
		public void setLastName(String ln) {lastName = ln;}
		public void setAddress(String a) {address = a;}
		public void setCity(String c) {city = c;}
		public void setState(String s) {state = s;}
		public void setZip(String z) {zip = z;}
		public void setPhone(String p) {phone = p;}
		public void setHasPool(boolean p) {hasPool = p;}
		public void setHasSpa(boolean s) {hasSpa = s;}
		public void setPool(Pool p) {pool = p;}
		public void setSpa(Spa s) {spa = s;}
		
		
		public Customer(String name, String address, String city, String state, String zip, String phone, boolean pool, boolean spa) {
			setName(name);
			setAddress(address);
			setCity(city);
			setState(state);
			setZip(zip);
			setPhone(phone);
			setHasPool(pool);
			setHasSpa(spa);
			this.customerID = CourseProject.customerID;
		}
		
		public String toString() {
			return getName() + "," + getAddress()+","+ getCity()+","+getState()+","+getZip()+","+getPhone()+","+getHasPool()+","+getHasSpa()+"\n";
		}
		
	}
	
	public class Pool{
		private double length, width, depth, volume;
		
		public double getLength() {return length;}
		public double getWidth() {return width;}
		public double getDepth() {return depth;}
		public double getVolume() {return volume;}
		
		public void setLength(double l) {length = l;}
		public void setWidth(double w) {width = w;}
		public void setDepth(double d) {depth = d;}
		
		public Pool(double len, double wid, double dep) {
			setLength(len);
			setWidth(wid);
			setDepth(dep);
			volume = length*width*depth;
		
		}
	}
	
	public class Spa{
		private double length, width, depth, volume;
		private String shape;
		
		public double getLength() {return length;}
		public double getWidth() {return width;}
		public double getDepth() {return depth;}
		public double getVolume() {return volume;}
		public String getShape() {return shape;}
		
		public void setLength(double l) {length = l;}
		public void setWidth(double w) {width = w;}
		public void setDepth(double d) {depth = d;}
		public void setShape(String sh) {
			if (sh.toLowerCase() == "round") {
				shape = sh.toLowerCase();
			}
			else if (sh.toLowerCase() == "oval") {
				shape = sh.toLowerCase();
			}
			else if (sh.toLowerCase() == "square") {
				shape = sh.toLowerCase();
			}
			else {
				shape = "round";
			}
			
		}

		public Spa(double len, double wid, double dep) {
			setLength(len);
			setWidth(wid);
			setDepth(dep);
			calculateVolume();
		}
			
		public void calculateVolume() {
			if (shape == "round") {
				volume = Math.PI*Math.pow((length/2), 2)*depth;
			}
			if (shape == "oval") {
				volume = Math.PI*length*width*depth /4;
			}
			if (shape == "square") {
				volume = length*width*depth;
			}
		}
		
	}
	
	class ExitButtonHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
	}
	
	private void loadDriver() {
		
			try {
				Class.forName("JDBCDriverClass");
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Failed to initialize driver...", "Error", JOptionPane.ERROR_MESSAGE);
			}
	}
	
	private void createConnection() {	

		try {
			cnn = DriverManager.getConnection(url);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to connect...", "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private ArrayList<String> loadCustomerNameToArray() {
		ArrayList<String> customerList = new ArrayList<String>();
		String sqlString = "SELECT FirstName, Lastname FROM CustomerInfo";
		String firstName;
		String lastName;
		
		try {
			stmt = cnn.createStatement();
			rs = stmt.executeQuery(sqlString);
		
			while (rs.next()) {
				firstName = rs.getString("FirstName");
				lastName = rs.getString("LastName");
				customerList.add(lastName + ", " +firstName);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed to process SQL statement...", "Error", JOptionPane.ERROR_MESSAGE);
			System.out.println(e);
		}
		return customerList;
	}
//	private String createStatement(String sqlString) {
//		
//		try {
//			rs = stmt.executeQuery(sqlString);
//		} catch (SQLException e) {
//			JOptionPane.showMessageDialog(null, "Failed to process SQL statement...", "Error", JOptionPane.ERROR_MESSAGE);
//		}
//		
//		System.out.println("Retrieving results...");
//		
//		while (rs.next()) {
//			
//			firstName = rs.getString("FirstName");
//			lastName = rs.getString("LastName");
//			address = rs.getString("Address");
//			
//			System.out.println(firstName);
//			System.out.println(lastName);
//			System.out.println(address);
//		}
//	}
	
	private void insertRecords(Customer customer) {
		Statement stmnt;
		String sqlString = "Insert INTO CustomerInfo VALUES ("+customerID+", "+customer.getFirstName()+", "+customer.getLastName()+", "+customer.getAddress()+", "+customer.getCity()+", "+customer.getState()+", "+customer.getZip()+", "+customer.getPhone()+", "+customer.getHasPool()+", "+customer.getHasSpa()+")";
		
		
		try {
			stmnt = cnn.createStatement();
			stmnt.executeUpdate(sqlString);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Insertion Failure...", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	private void closeResources() {
		try {
			rs.close();
			stmt.close();
			cnn.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Failed to close resources...", "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public static void main(String[] args) {
		CourseProject test = new CourseProject();
		test.setTitle("Engineering Spec Calculator");
		test.setVisible(true);
//		test.setSize(500, 400);
	}

}
