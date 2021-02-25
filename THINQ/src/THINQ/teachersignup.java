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

public class teachersignup extends JFrame {
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
	private JTextField un;
	private JPasswordField pass;
	private JPasswordField passwordField_1;

	/**
	 * Create the frame.
	 */
	public teachersignup() {
		
		conn = connect.dbConnector();
		
		setBounds(100, 100, 896, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		un = new JTextField();
		un.setBounds(446, 137, 188, 49);
		getContentPane().add(un);
		un.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(250, 145, 98, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(250, 212, 98, 31);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("signup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String query = "INSERT INTO users(username,password) VALUES(?,?)";
					PreparedStatement pst= conn.prepareStatement(query);
					pst.setString(1, un.getText());
					pst.setString(2, pass.getText());
					pst.executeUpdate();
					
					dispose();
					landing_page home1 = new landing_page();
					home1.setVisible(true);
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(332, 350, 175, 49);
		getContentPane().add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(446, 204, 188, 49);
		getContentPane().add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("TEACHER SIGNUP");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 24));
		lblNewLabel_2.setBounds(298, 24, 336, 58);
		getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(446, 282, 188, 43);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("CONFIRM");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(250, 287, 98, 31);
		getContentPane().add(lblNewLabel_3);
		
		
	
	}
}
