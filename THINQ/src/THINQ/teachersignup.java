package THINQ;


import java.sql.*;
import java.util.ArrayList;

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
	
	
	public static ArrayList<user> teacher_list=new ArrayList<user>();
	
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the frame.
	 */
	public teachersignup() {
		getContentPane().setBackground(Color.ORANGE);
		
		
		
		conn = connect.dbConnector();
		
		setBounds(100, 100, 896, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		
		
		un = new JTextField();
		un.setBounds(183, 164, 188, 49);
		getContentPane().add(un);
		un.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(49, 172, 98, 31);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(49, 231, 98, 31);
		getContentPane().add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SIGNUP");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int count = teacher_list.size();
				
				try {
					
					if(pass.getText().equals(passwordField_1.getText())) {
						
						String query = "INSERT INTO users(username,password) VALUES(?,?)";
						PreparedStatement pst= conn.prepareStatement(query);
						pst.setString(1, un.getText());
						pst.setString(2, pass.getText());
						pst.executeUpdate();
						
						thinqer obj=new thinqer();
						obj.name = textField.getText();
						obj.email = textField_2.getText();
						obj.contact = textField_1.getText();
						obj.number_of_classes = "0";
						obj.userName = un.getText();
						obj.password = pass.getText();
						teacher_list.add(count,obj);
						dispose();
						landing_page home1 = new landing_page();
						home1.setVisible(true);
					}
					else
						JOptionPane.showMessageDialog(null, "Passwords do not match");
					
					
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null, e);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.setBounds(332, 350, 175, 49);
		getContentPane().add(btnNewButton);
		
		pass = new JPasswordField();
		pass.setBounds(183, 223, 188, 49);
		getContentPane().add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("TEACHER SIGNUP");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 28));
		lblNewLabel_2.setBounds(309, 32, 336, 58);
		getContentPane().add(lblNewLabel_2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(183, 282, 188, 43);
		getContentPane().add(passwordField_1);
		
		JLabel lblNewLabel_3 = new JLabel("CONFIRM");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(49, 287, 98, 31);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_4.setBounds(520, 177, 84, 21);
		getContentPane().add(lblNewLabel_4);
		
		textField = new JTextField();
		textField.setBounds(614, 164, 202, 49);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("MOBILE");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_5.setBounds(520, 236, 84, 21);
		getContentPane().add(lblNewLabel_5);
		
		textField_1 = new JTextField();
		textField_1.setBounds(614, 223, 203, 49);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(614, 282, 203, 43);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("EMAIL");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_6.setBounds(520, 292, 84, 21);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\neinun\\Downloads\\8880b1ab-0f2a-4fb3-90a2-64c33821.png"));
		lblNewLabel_7.setBounds(27, 10, 98, 118);
		getContentPane().add(lblNewLabel_7);
		
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
