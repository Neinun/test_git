package THINQ;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Frame;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.ScrollPane;
import java.awt.TextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class afterLoginStudent extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();
	TextArea textArea_2 = new TextArea();
	private final TextArea textArea_1 = new TextArea();
	private final JTextField choice = new JTextField();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterLoginStudent frame = new afterLoginStudent();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public afterLoginStudent() {
		choice.setBounds(356, 365, 211, 53);
		choice.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea.setBounds(86, 112, 355, 134);
		contentPane.add(textArea);
		
		
		textArea_2.setBounds(159, 252, 602, 107);
		contentPane.add(textArea_2);
		textArea_1.setBounds(447, 112, 348, 134);
		
		contentPane.add(textArea_1);
		
		contentPane.add(choice);
		
		JButton btnNewButton = new JButton("BOOK CLASS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ch = choice.getText();
				lecture temp=new lecture();
				thinqer temp1 = new thinqer();
				
				for(int i=0;i<landing_page.all_lectures.size();i++)
				{
					temp=landing_page.all_lectures.get(i);
					if(temp.ID.equals(ch))
					{
						gobject.upcoming_classes.add(temp);
						update_classes(gobject);
						break;
					}
				}
				
				for(int i=0;i<teachersignup.teacher_list.size();i++)
				{
					temp1 = teachersignup.teacher_list.get(i);
					if(temp1.userName.equals(temp.teacherName))
					{
						temp1.upcoming_classes.add(temp);
						temp1.number_of_classes +=1;
						teachersignup.teacher_list.add(i,temp1);
						break;
						
					}
					
					
				}
				
				
			}
		});
		btnNewButton.setBounds(577, 381, 124, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				landing_page obj=new landing_page();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(10, 10, 124, 21);
		contentPane.add(btnNewButton_1);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\neinun\\Downloads\\8880b1ab-0f2a-4fb3-90a2-64c33821.png"));
		lblNewLabel.setBounds(387, 10, 103, 92);
		
		contentPane.add(lblNewLabel);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(266, 382, 80, 17);
		
		contentPane.add(lblNewLabel_1);
		
		
		
	}
	
	learner gobject = new learner();
	private final JLabel lblNewLabel = new JLabel("New label");
	private final JLabel lblNewLabel_1 = new JLabel("Lecture ID");
	public void fun(learner obj)
	{
		gobject = obj;
		String temp,temp2,temp3;
		temp = details(obj);
		temp2 = details(obj.upcoming_classes);
		temp3 = details1(landing_page.all_lectures);
		textArea.setText(temp);
		textArea_1.setText(temp2);
		textArea_2.setText(temp3);
	}
	
	public String details(learner l)
	{
		String x;
		x=" Your Details are : \n---------------------------------------------------------------\n";
		x = x + "Name :"+l.name+"\n"+"email :"+l.email+"\n"+"Contact :"+l.contact+"\n"+"number of classes :"+l.number_of_classes+"\n" +"---------------------------------------------------------";
		return x;
	}
	public String details(ArrayList<lecture> l)
	{
		String x="";
		String t="Bought Classes: \n-----------------------------------------------------\n";
		lecture temp=new lecture();
		
		for(int i=0; i<l.size();i++)
		{
			temp = l.get(i);
			x = temp.ID +"\t"+ temp.specialization +"\t"+ temp.teacherName +"\t"+ temp.duration +"\t"+ temp.cost;
			t = t +"\n"+ x ;
		}
		return t;
	}
	public String details1(ArrayList<lecture> l)
	{
		String x="";
		String t="All Lectures Available: \n-----------------------------------------------------\n";
		lecture temp=new lecture();
		
		for(int i=0; i<l.size();i++)
		{
			temp = l.get(i);
			x = temp.ID +"\t"+ temp.specialization +"\t"+ temp.teacherName +"\t"+ temp.duration +"\t"+ temp.cost;
			t = t +"\n"+ x ;
		}
		return t;
	}
	
	void update_classes(learner l)
	{
		String s,s1;
		int temp = Integer.valueOf(l.number_of_classes);
		temp += 1;
		l.number_of_classes = String.valueOf(temp);
		s = details(l.upcoming_classes);
		s1 = details(l);
		textArea.setText(s1);
		textArea_1.setText(s);
	}
	
	void update_classes(thinqer l)
	{
		String s,s1;
		int temp = Integer.valueOf(l.number_of_classes);
		temp += 1;
		l.number_of_classes = String.valueOf(temp);
		s = details(l.upcoming_classes);
		s1 = details(l);
		textArea.setText(s1);
		textArea_1.setText(s);
	}
	
	public String details(thinqer l)
	{
		String x;
		x=" Your Details are : \n---------------------------------------------------------------\n";
		x = x + "Name :"+l.name+"\n"+"email :"+l.email+"\n"+"Contact :"+l.contact+"\n"+"number of classes :"+l.number_of_classes+"\n" +"---------------------------------------------------------";
		return x;
	}
}
