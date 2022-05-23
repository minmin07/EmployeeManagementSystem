package employeemg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Remove extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;


	/* Creating Remove frame
             Enter Employee Id and just remove the employee from the database 
                 */
	public Remove() {
		setTitle("Remove ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 361);
		contentPane = new JPanel();
		contentPane.setBackground(Color.CYAN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbemployeeId = new JLabel("Employee ID :");
		lbemployeeId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbemployeeId.setBounds(107, 134, 109, 29);
		contentPane.add(lbemployeeId);
		
		txtId = new JTextField();
		txtId.setBounds(249, 133, 265, 29);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Remove Employee");
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(212, 30, 236, 29);
		contentPane.add(lblNewLabel_1);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cancel
				dispose();
			}
		});
		btnCancel.setBounds(404, 253, 85, 21);
		contentPane.add(btnCancel);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Remove
				String employeeID = txtId.getText();
				
				//COnnect to database
				try {
					Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
                         System.out.println("Connected");

                   

                    String q =  "DELETE FROM employeedb WHERE employeeID = '"+employeeID+"'"; /*delete whole column data of the matching 
                                                                                                       employee id from the database*/
                    Statement s = cc.createStatement();
                     s.executeUpdate(q);//passing q to be executed 
                    
                    	JOptionPane.showMessageDialog(btnRemove, "Removed successfully");
                    
	                        dispose();
   					

				} catch (Exception ew) {
				JOptionPane.showMessageDialog(btnRemove,ew.getMessage());
				}
		    }
				
			
		});
		
		btnRemove.setBounds(533, 253, 85, 21);
		contentPane.add(btnRemove);
	}
}
