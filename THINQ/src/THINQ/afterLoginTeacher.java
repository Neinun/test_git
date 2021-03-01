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

public class afterLoginTeacher extends JFrame {

	private JPanel contentPane;
	JTextArea textArea = new JTextArea();
	TextArea textArea_2 = new TextArea();
	private final TextArea textArea_1 = new TextArea();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					afterLoginTeacher frame = new afterLoginTeacher();
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
	public afterLoginTeacher() {
		textField_3.setBounds(420, 433, 96, 19);
		textField_3.setColumns(10);
		textField_2.setBounds(303, 433, 96, 19);
		textField_2.setColumns(10);
		textField_1.setBounds(197, 433, 96, 19);
		textField_1.setColumns(10);
		textField.setBounds(91, 433, 96, 19);
		textField.setColumns(10);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea.setBounds(91, 81, 355, 134);
		contentPane.add(textArea);
		
		
		textArea_2.setBounds(159, 252, 602, 107);
		contentPane.add(textArea_2);
		textArea_1.setBounds(495, 81, 348, 134);
		
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("Add Class");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					lecture l1 = new lecture();
					l1.ID = String.valueOf(landing_page.all_lectures.size());
					l1.teacherName= textField.getText();
					l1.specialization = textField_1.getText();
					l1.duration = textField_2.getText();
					l1.cost = textField_3.getText();
					
					System.out.println(landing_page.all_lectures.size());
					landing_page.all_lectures.add(l1);
					System.out.println(landing_page.all_lectures.size());
					String s = details(landing_page.all_lectures);
					textArea_2.setText(s);
					
					
					
				}catch(Exception e1){
					
				}
				
			}
		});
		btnNewButton.setBounds(496, 461, 85, 21);
		contentPane.add(btnNewButton);
		
		contentPane.add(textField);
		
		contentPane.add(textField_1);
		
		contentPane.add(textField_2);
		
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("username");
		lblNewLabel.setBounds(111, 410, 45, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("specialization");
		lblNewLabel_1.setBounds(216, 410, 45, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("duration");
		lblNewLabel_2.setBounds(322, 410, 45, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("cost");
		lblNewLabel_3.setBounds(445, 410, 45, 13);
		contentPane.add(lblNewLabel_3);
		
		
		
	}
	thinqer gobject = new thinqer();
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	
	
	public void fun(thinqer obj)
	{
		gobject = obj;
		String temp,temp2,temp3;
		temp = details(obj);
		temp2 = details(obj.upcoming_classes);
		temp3 = details(landing_page.all_lectures);
		textArea.setText(temp);
		textArea_1.setText(temp2);
		textArea_2.setText(temp3);
	}
	
	public String details(thinqer l)
	{
		String x;
		x = "Name :"+l.userName+"\n"+"email :"+l.email+"\n"+"Contact :"+l.contact+"\n"+"number of classes :"+l.number_of_classes+"\n" +"---------------------------------------------------------";
		return x;
	}
	public String details(ArrayList<lecture> l)
	{
		String x="";
		String t="";
		lecture temp=new lecture();
		
		for(int i=0; i<l.size();i++)
		{
			temp = l.get(i);
			x = temp.ID +"\t"+ temp.specialization +"\t"+ temp.teacherName +"\t"+ temp.duration +"\t"+ temp.cost;
			t = t +"\n"+ x ;
		}
		return t;
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
}
