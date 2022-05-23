/*Author Loday T Gyeltshen*/
package employeemg;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtuser;
	private JPasswordField txtpsw;

	/*
	 Creating the login frame .
	 */
	public Login() {
		setTitle("Sign in");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lwarn = new JLabel(" ");
		lwarn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lwarn.setForeground(Color.RED);
		lwarn.setBounds(167, 69, 245, 13);
		contentPane.add(lwarn);
	
		
		JLabel luser = new JLabel("User");
		luser.setForeground(new Color(255, 255, 255));
		luser.setFont(new Font("Monospaced", Font.BOLD, 17));
		luser.setBounds(62, 85, 45, 13);
		contentPane.add(luser);
		
		JLabel lpsw = new JLabel("Password");
		lpsw.setForeground(new Color(255, 255, 255));
		lpsw.setFont(new Font("Monospaced", Font.BOLD, 17));
		lpsw.setBounds(62, 158, 86, 13);
		contentPane.add(lpsw);
		
		txtuser = new JTextField();
		txtuser.setBounds(167, 84, 245, 26);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		JButton btnreset = new JButton("Reset");
		btnreset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//reset button Action
				
				txtuser.setText("");
				txtpsw.setText("");
				
			}
		});
		btnreset.setBounds(286, 264, 70, 21);
		contentPane.add(btnreset);
		
		JButton btnlogin = new JButton("Login");
		btnlogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				//LOGIN
				try {
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "");

					// Assigning variable username and password to input text
					String username = txtuser.getText();
					String password = txtpsw.getText();

                    Statement stm = con.createStatement();
 
                    // verify 
					String sql = "SELECT * FROM login where username = '"+username+"' and password = '"+password+"'";
					ResultSet rs = stm.executeQuery(sql);

					//if successful
					if(rs.next()){
						dispose();//close the login page
						Home home = new Home();   //display home
				   home.frame.setVisible(true);
				   System.out.print("Jump to home");
				        

					}else{
						//if not
                        txtuser.setText("");
						txtpsw.setText("");
						lwarn.setText("Invalid user or password");//label Displays the statement
					}

					con.close();//close connection
				} catch (Exception ew) {
				System.out.print(ew.getMessage());
				}
			}
		});
		btnlogin.setBounds(393, 264, 73, 21);
		contentPane.add(btnlogin);
		
		JLabel lwelcome = new JLabel("Welcome");
		lwelcome.setForeground(new Color(255, 255, 255));
		lwelcome.setFont(new Font("Franklin Gothic Demi", Font.PLAIN, 22));
		lwelcome.setBounds(194, 10, 108, 34);
		contentPane.add(lwelcome);
		
		txtpsw = new JPasswordField();
		txtpsw.setBounds(167, 157, 245, 26);
		contentPane.add(txtpsw);
		
		
}
}
