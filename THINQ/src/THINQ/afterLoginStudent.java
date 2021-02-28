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
		choice.setBounds(235, 429, 211, 53);
		choice.setColumns(10);
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
		
		contentPane.add(choice);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String ch = choice.getText();
				lecture temp=new lecture();
				
				for(int i=0;i<landing_page.all_lectures.size();i++)
				{
					temp=landing_page.all_lectures.get(i);
					if(temp.ID.equals(ch))
					{
						gobject.upcoming_classes.add(temp);
						update_classes(gobject);
					}
				}
				
				
			}
		});
		btnNewButton.setBounds(495, 445, 85, 21);
		contentPane.add(btnNewButton);
		
		
		
	}
	learner gobject = new learner();
	public void fun(learner obj)
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
	
	public String details(learner l)
	{
		String x;
		x = l.userName +"\n" + l.name+"\n" +l.email+"\n" +l.contact+"\n" +l.number_of_classes+"\n" +"---------------------------------------------------------";
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
	
	void update_classes(learner l)
	{
		String s;
		s = details(l.upcoming_classes);
		textArea_1.setText(s);
	}
}
