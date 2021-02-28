package THINQ;


import java.sql.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;


import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Frame;

public class studentlogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					studentlogin frame = new studentlogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Create the frame.
	 */
	public studentlogin() {
		
		conn = connect.dbConnector();
		
		setBounds(100, 100, 896, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setBounds(446, 170, 188, 49);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(250, 178, 98, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(250, 241, 98, 31);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "select * from users where username=? and password=?";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, textField.getText());
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
						learner temp = new learner();
						for(int i=0;i<studentsignup.students_list.size();i++)
						{
							temp = studentsignup.students_list.get(i);
							if(temp.userName.equals(textField.getText()))
							{
								break;
							}
						}
						dispose();
						
						afterLoginStudent s_login1 = new afterLoginStudent();
						s_login1.fun(temp);
						s_login1.setVisible(true);
					}
					else if(count>1)
						JOptionPane.showMessageDialog(null, "Duplicate username and password");
					else {
						JOptionPane.showMessageDialog(null, "Username and Password is not Correct. Try Again.");	
					}											
					rs.close();
					pst.close();
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(335, 335, 175, 49);
		getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(446, 233, 188, 49);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("STUDENT LOGIN");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(298, 24, 336, 58);
		getContentPane().add(lblNewLabel_2);
		
		
	
	}
}
