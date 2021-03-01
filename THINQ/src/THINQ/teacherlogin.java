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

public class teacherlogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					teacherlogin frame = new teacherlogin();
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
	public teacherlogin() {
		getContentPane().setBackground(Color.ORANGE);
		
		conn = connect.dbConnector();
		
		setBounds(100, 100, 896, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField.setBounds(556, 169, 188, 49);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(365, 178, 98, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(365, 241, 98, 31);
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
						
						thinqer temp = new thinqer();
						for(int i=0;i<teachersignup.teacher_list.size();i++)
						{
							temp = teachersignup.teacher_list.get(i);
							if(temp.userName.equals(textField.getText()))
							{
								break;
							}
						}
						
						afterLoginTeacher t_login1 = new afterLoginTeacher();
						t_login1.fun(temp);
						t_login1.setVisible(true);
						dispose();
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
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBounds(556, 232, 188, 49);
		getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("TEACHER LOGIN");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		lblNewLabel_2.setBounds(311, 35, 336, 58);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\neinun\\Downloads\\8880b1ab-0f2a-4fb3-90a2-64c33821efea_200x200.png"));
		lblNewLabel_3.setBounds(39, 143, 195, 178);
		getContentPane().add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				landing_page obj=new landing_page();
				obj.setVisible(true);
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		btnNewButton_1.setBounds(787, 402, 85, 21);
		getContentPane().add(btnNewButton_1);
		
		
	
	}
}
