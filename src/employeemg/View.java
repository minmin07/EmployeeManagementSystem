/*Author Loday T Gyeltshen
*College of Science and Technology*/
package employeemg;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.Color;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class View extends JFrame {

	private JPanel contentPane;
	private JTable tblData;


	public View() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 620);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("My Employee Details");
		lbTitle.setForeground(new Color(255, 255, 255));
		lbTitle.setFont(new Font("Monospaced", Font.BOLD, 20));
		lbTitle.setBounds(401, 10, 245, 53);
		contentPane.add(lbTitle);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(114, 73, 829, 411);
		contentPane.add(scrollPane);
		
		tblData = new JTable();
		scrollPane.setViewportView(tblData);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Close
				dispose();
				
			}
		});
		btnClose.setBounds(706, 517, 85, 21);
		contentPane.add(btnClose);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Display
				//COnnect to database
				try {
					Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");
                         System.out.println("Connected");

                   

                    String q =  "SELECT * FROM employeedb";
                    Statement s = cc.createStatement();
                   ResultSet rs = s.executeQuery(q);
                   
                   /*ResultSetMetaData helps to retrieve information of the table
                    * from database*/
                   java.sql.ResultSetMetaData rsmd = rs.getMetaData();
                   DefaultTableModel model =(DefaultTableModel)tblData.getModel();
                   
                   int cols = rsmd.getColumnCount();
                   //creating array to get column names
                   String[] colName = new String[cols];
                   for(int i=0;i<cols;i++)
                	   //store column names in array below
                	   colName[i]=rsmd.getColumnName(i+1);//our columns starts from 1 not zero so i+1 is used
                   model.setColumnIdentifiers(colName);//Displaying columns
                   
                   while(rs.next()) {
                	   String id,fn,ln,em,c,a,r;
                	   id=rs.getString(1);/* assigning this variables to Strings that we get from the database*/
                	   fn=rs.getString(2);/* Ex. what we get from index 0 of database is assigned to variable id */
                	   ln=rs.getString(3);/*this variables are later used to display */
                	   em=rs.getString(4);
                	   c=rs.getString(5);
                	   a=rs.getString(6);
                	   r=rs.getString(7);
                	   
                	   String[] row = {id,fn,ln,em,c,a,r};
                	   model.addRow(row);/*Adding data passed from the above string to the table*/
                	   
                   }
                   s.close();
                   cc.close();
                    

				} catch (Exception ew) {
				System.out.print(ew.getMessage());
				}
		    }

		});
		btnDisplay.setBounds(865, 517, 85, 21);
		contentPane.add(btnDisplay);
	}
}
