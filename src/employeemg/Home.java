package employeemg;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Home {

	 JFrame frame;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("TechnicBold", Font.PLAIN, 10));
		frame.getContentPane().setBackground(new Color(51, 102, 255));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Monospaced", Font.BOLD, 31));
		lblNewLabel.setBounds(341, 10, 173, 64);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Manage my Employee");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(0, 255, 255));
		lblNewLabel_1.setFont(new Font("Monospaced", Font.BOLD, 20));
		lblNewLabel_1.setBounds(304, 125, 223, 40);
		frame.getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Add

				Add add = new Add();
				add.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(286, 217, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Remove

			  Remove remove = new Remove();
				remove.setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(462, 217, 85, 21);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//View
				View view = new View();
				view.setVisible(true);
				
			}
		});
		btnNewButton_2.setBounds(286, 272, 85, 21);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Logout");
		btnNewButton_3.setBackground(new Color(204, 153, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Logout
				
		 frame.dispose();
			Login log = new Login();
			log.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(711, 356, 85, 21);
		frame.getContentPane().add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 404, 823, 208);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Druk Way Cooperation");
		lblNewLabel_2.setFont(new Font("Segoe UI Semibold", Font.BOLD, 13));
		lblNewLabel_2.setBackground(Color.YELLOW);
		lblNewLabel_2.setBounds(32, 24, 168, 38);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Contact");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(364, 24, 58, 21);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("drukwaybhutan@gmail.com");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(362, 70, 168, 27);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("17549030/17502685");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(364, 107, 136, 13);
		panel.add(lblNewLabel_5);
		frame.setBounds(100, 100, 837, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
