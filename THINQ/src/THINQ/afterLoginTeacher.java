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
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class afterLoginTeacher extends JFrame implements afterloginuser{

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
		textField_3.setBounds(486, 433, 96, 19);
		textField_3.setColumns(10);
		textField_2.setBounds(362, 433, 96, 19);
		textField_2.setColumns(10);
		textField_1.setBounds(224, 433, 96, 19);
		textField_1.setColumns(10);
		textField.setBounds(91, 433, 96, 19);
		textField.setColumns(10);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 529);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textArea.setBounds(91, 112, 355, 134);
		contentPane.add(textArea);
		
		
		textArea_2.setBounds(159, 252, 602, 107);
		contentPane.add(textArea_2);
		textArea_1.setBounds(452, 112, 348, 134);
		
		contentPane.add(textArea_1);
		
		JButton btnNewButton = new JButton("ADD CLASS");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int flag1=0,flag2=0;;
					lecture l1 = new lecture();
					l1.ID = String.valueOf(landing_page.all_lectures.size());
					l1.teacherName= textField.getText();
					l1.specialization = textField_1.getText();
					l1.duration = textField_2.getText();
					l1.cost = textField_3.getText();
					for(int i=0;i<l1.cost.length();i++)
					{
						char c=l1.cost.charAt(i);
						//System.out.println(c);
						if(c=='0'|| c=='1'|| c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
							flag1 = 0;
						else {
							flag1=1;
							break;
						}	
					}
					
					for(int i=0;i<l1.duration.length();i++)
					{
						char c=l1.duration.charAt(i);
						//System.out.println(c);
						if(c=='0'|| c=='1'|| c=='2'||c=='3'||c=='4'||c=='5'||c=='6'||c=='7'||c=='8'||c=='9')
							flag2 = 0;
						else {
							flag2=1;
							break;
						}	
					}
					
					if(flag1 == 1 && flag2==0)
						JOptionPane.showMessageDialog(null, "Enter valid Cost of lecture");
					if(flag2 == 1 && flag1==0)
						JOptionPane.showMessageDialog(null, "Enter valid Duration of lecture");
					if(flag1==1 && flag2==1)
						JOptionPane.showMessageDialog(null, "Enter valid Duration and Cost of lecture");
					
					else if(flag1==0 && flag2 == 0)
					{
						System.out.println(landing_page.all_lectures.size());
						landing_page.all_lectures.add(l1);
						System.out.println(landing_page.all_lectures.size());
						String s = details1(landing_page.all_lectures,l1.teacherName);
						textArea_2.setText(s);
					}
					
					
					
					
				}catch(Exception e1){
					
				}
				
			}
		});
		btnNewButton.setBounds(634, 410, 127, 42);
		contentPane.add(btnNewButton);
		
		contentPane.add(textField);
		
		contentPane.add(textField_1);
		
		contentPane.add(textField_2);
		
		contentPane.add(textField_3);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel.setBounds(91, 410, 96, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SPECIALIZATION");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(208, 410, 134, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("DURATION");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(362, 410, 96, 13);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("COST");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(511, 410, 45, 13);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\neinun\\Downloads\\8880b1ab-0f2a-4fb3-90a2-64c33821.png"));
		lblNewLabel_4.setBounds(407, 10, 87, 92);
		
		contentPane.add(lblNewLabel_4);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
				landing_page obj=new landing_page();
				obj.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBounds(10, 10, 110, 21);
		contentPane.add(btnNewButton_1);
		
		
		
	}
	factory f=new factory();
	user gobject = f.getUser("thinqer");
	private final JTextField textField = new JTextField();
	private final JTextField textField_1 = new JTextField();
	private final JTextField textField_2 = new JTextField();
	private final JTextField textField_3 = new JTextField();
	private final JLabel lblNewLabel_4 = new JLabel("New label");
	
	
	public void fun(user obj)
	{
		gobject = obj;
		String temp,temp2,temp3;
		temp = details(obj);
		temp2 = details(obj.upcoming_classes);
		temp3 = details1(landing_page.all_lectures,obj.userName);
		textArea.setText(temp);
		textArea_1.setText(temp2);
		textArea_2.setText(temp3);
	}
	
	public String details(user l)
	{
		String x;
		x=" Your Details are : \n---------------------------------------------------------------\n";
		x = x+ "Name :"+l.userName+"\n"+"email :"+l.email+"\n"+"Contact :"+l.contact+"\n"+"number of classes :"+l.number_of_classes+"\n";
		return x;
	}
	public String details(ArrayList<lecture> l)
	{
		String x="";
		String t="Upcoming Lectures: \n-----------------------------------------------------\n";
		lecture temp=new lecture();
		
		for(int i=0; i<l.size();i++)
		{
			temp = l.get(i);
			x = temp.ID +"\t"+ temp.specialization +"\t"+ temp.teacherName +"\t"+ temp.duration +"\t"+ temp.cost+"\t";
			t = t +"\n"+ x ;
		}
		return t;
	}
	
	public String details1(ArrayList<lecture> l,String username)
	{
		String x="";
		String t="Your lectures: \n-----------------------------------------------------\n";
		lecture temp=new lecture();
		
		for(int i=0; i<l.size();i++)
		{
			temp = l.get(i);
			if(temp.teacherName.equalsIgnoreCase(username))
			{
				x = temp.ID +"\t"+ temp.specialization +"\t"+ temp.teacherName +"\t"+ temp.duration +"\t"+ temp.cost+"\t";
				t = t +"\n"+ x ;
			}
			
		}
		return t;
	}
	public String details1(ArrayList<lecture> l)
	{
		return null;
	}
	void update_classes(user l)
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
