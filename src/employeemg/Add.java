package employeemg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtfName;
	private JTextField txtlName;
	private JTextField txtEmail;
	private JTextField txtContact;
	private JTextField txtAddress;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtRemarks;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add frame = new Add();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Add() {
		setTitle("Add new Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 531, 664);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Employee ID:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(63, 88, 101, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(63, 139, 101, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Last Name:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(63, 194, 101, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(63, 253, 101, 24);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contact:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(63, 315, 101, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(62, 378, 93, 21);
		contentPane.add(lblNewLabel_5);
		
		txtID = new JTextField();
		txtID.setBounds(187, 90, 236, 27);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		txtfName = new JTextField();
		txtfName.setBounds(187, 141, 236, 25);
		contentPane.add(txtfName);
		txtfName.setColumns(10);
		
		txtlName = new JTextField();
		txtlName.setBounds(187, 194, 237, 29);
		contentPane.add(txtlName);
		txtlName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(188, 251, 236, 29);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtContact = new JTextField();
		txtContact.setBounds(188, 314, 236, 28);
		contentPane.add(txtContact);
		txtContact.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(189, 373, 236, 32);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		lblNewLabel_6 = new JLabel("Add new employee");
		lblNewLabel_6.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(174, 24, 200, 24);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Remarks:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_7.setBounds(63, 448, 66, 21);
		contentPane.add(lblNewLabel_7);
		
		txtRemarks = new JTextField();
		txtRemarks.setBounds(187, 450, 236, 27);
		contentPane.add(txtRemarks);
		txtRemarks.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cancel
				dispose();
			}
		});
		btnCancel.setBounds(289, 557, 85, 21);
		contentPane.add(btnCancel);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Submit button
				String employeeID = txtID.getText();
				String firstName = txtfName.getText();
				String lastName = txtlName.getText();
				String email = txtEmail.getText();
				String contactNumber = txtContact.getText();
				String address = txtAddress.getText();
				String remarks =txtRemarks.getText();
				
				//COnnect to database
				try {
					Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
                         System.out.println("Connected");//just for my own sake

                   

                    String q =  "INSERT INTO employeedb VALUES ('"+employeeID+"','"+firstName+"','"+lastName+"','"+email+"','"+contactNumber+"','"+address+"','"+remarks+"')";
                    Statement s = cc.createStatement();
                    s.executeUpdate(q); //Executing update passing q 
                    
                    	JOptionPane.showMessageDialog(btnSubmit, "Added successfully");//message dialogue
                    
	dispose();//close frame
					

				} catch (Exception ew) {
					JOptionPane.showMessageDialog(btnSubmit,ew.getMessage());
				}
		    }
			
		});
		btnSubmit.setBounds(404, 557, 85, 21);
		contentPane.add(btnSubmit);
	}
}
