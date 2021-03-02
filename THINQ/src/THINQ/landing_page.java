package THINQ;
import java.util.*;
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
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class landing_page extends JFrame {	
	private JPanel contentPane;
	
	
	public static ArrayList<lecture> all_lectures = new ArrayList<lecture>();

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
		getContentPane().setBackground(Color.ORANGE);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	private void initialize() {
		
		
		
		lecture l1=new lecture("101","teacher1","physics","1021","1");
		lecture l2=new lecture("102","qwerty1","physic2s","1301","2");
		lecture l3=new lecture("103","qwerty21","phy3sics","1011","2");
		lecture l4=new lecture("104","qwerty12","phy1sics","1301","3");
		lecture l5=new lecture("105","qwert3y","physi3cs","1031","3");
		lecture l6=new lecture("106","qwerty3","physi1cs","1301","1");
		lecture l7=new lecture("107","qwert2y","physi3cs","1101","1");
		lecture l8=new lecture("108","qwer1ty","phys1ics","1011","2");
		lecture l9=new lecture("109","qwe1rty","phys3ics","1031","1");
		lecture l10=new lecture("1010","qw3erty","phy1sics","1101","2");
		lecture l11=new lecture("1011","qwe1rty","phy3sics","1011","1");
		
		all_lectures.add(l1);
		all_lectures.add(l2);
		all_lectures.add(l3);
		all_lectures.add(l4);
		all_lectures.add(l5);
		all_lectures.add(l6);
		all_lectures.add(l10);
		all_lectures.add(l7);
		all_lectures.add(l8);
		all_lectures.add(l9);
		all_lectures.add(l11);
		
		
		thinqer t1=new thinqer("teacher1","1","paul","paul@gmail.com","0","9108358068");
		teachersignup.teacher_list.add(t1);
		
		
		
		
		setBounds(100, 100, 896, 470);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JButton teacher_login = new JButton("TEACHER LOGIN");
		teacher_login.setForeground(Color.BLACK);
		teacher_login.setBackground(Color.WHITE);
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
		teacher_signup.setBackground(Color.WHITE);
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
		students_login.setBackground(Color.WHITE);
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
		students_signup.setBackground(Color.WHITE);
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\neinun\\Downloads\\8880b1ab-0f2a-4fb3-90a2-64c33821efea_200x200.png"));
		lblNewLabel.setBounds(324, 27, 198, 214);
		getContentPane().add(lblNewLabel);
	}
}


