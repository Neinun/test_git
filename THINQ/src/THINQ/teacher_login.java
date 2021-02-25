package THINQ;

import java.awt.EventQueue;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
public class teacher_login {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacher_login window = new teacher_login();
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
	Connection conn = null;
	private JTextField un;
	private JPasswordField passwordField;
	
	
	
	
	public teacher_login() {
		initialize();
		conn = connect.dbConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(191, 78, 68, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("password");
		lblNewLabel_1.setBounds(191, 142, 68, 27);
		frame.getContentPane().add(lblNewLabel_1);
		
		un = new JTextField();
		un.setBounds(307, 82, 96, 19);
		frame.getContentPane().add(un);
		un.setColumns(10);
		
		JButton btnlogin = new JButton("LOGIN");
		btnlogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from users where username=? and password=?";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, un.getText());
					pst.setString(2, passwordField.getText());
					
					ResultSet rs= pst.executeQuery();
					int count = 0;
					while(rs.next())
					{
						count = count + 1;
					}
					if(count == 1)
					{
						JOptionPane.showMessageDialog(null, "username and password is correct");
						frame.dispose();
					}
					else if(count>1)
						JOptionPane.showMessageDialog(null, "Duplicate username and password");
					else
						JOptionPane.showMessageDialog(null, "Username and Password is not Correct. Try Again.");
					
					rs.close();
					pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
				
				
			}
		});
		btnlogin.setBounds(174, 211, 143, 21);
		frame.getContentPane().add(btnlogin);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(307, 146, 96, 19);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 45, 143, 187);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Teacher Login");
		lblNewLabel_3.setFont(new Font("Tw Cen MT", Font.BOLD, 28));
		lblNewLabel_3.setBounds(120, 10, 167, 46);
		frame.getContentPane().add(lblNewLabel_3);
	}

}
