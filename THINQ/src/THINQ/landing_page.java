package THINQ;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class landing_page extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					landing_page frame = new landing_page();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public landing_page() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		setBounds(100, 100, 896, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton teacher_login = new JButton("TEACHER LOGIN");
		teacher_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				teacherlogin t_login = new teacherlogin();
				t_login.setVisible(true);
			}
		});
		teacher_login.setFont(new Font("Times New Roman", Font.BOLD, 16));
		teacher_login.setBounds(201, 248, 216, 58);
		getContentPane().add(teacher_login);
		
		JButton teacher_signup = new JButton("TEACHER SIGNUP");
		teacher_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				teachersignup t_signup = new teachersignup();
				t_signup.setVisible(true);
			}
		});
		teacher_signup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		teacher_signup.setBounds(427, 248, 216, 58);
		getContentPane().add(teacher_signup);
		
		JButton students_login = new JButton("STUDENTS LOGIN");
		students_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				studentlogin s_login = new studentlogin();
				s_login.setVisible(true);
			}
		});
		students_login.setFont(new Font("Times New Roman", Font.BOLD, 16));
		students_login.setBounds(203, 316, 214, 58);
		getContentPane().add(students_login);
		
		JButton students_signup = new JButton("STUDENTS SIGNUP");
		students_signup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				studentsignup s_signup = new studentsignup();
				s_signup.setVisible(true);
				
			}
		});
		students_signup.setFont(new Font("Times New Roman", Font.BOLD, 16));
		students_signup.setBounds(427, 316, 216, 58);
		getContentPane().add(students_signup);
	}

}
