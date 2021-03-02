package THINQ;

import java.util.ArrayList;

public class user {
	
	ArrayList<lecture> upcoming_classes = new ArrayList<lecture>();
	String userName;
	String password;
	String name;
	String email;
	String number_of_classes;
	String contact;
	
	user()
	{
		
	}
	
	user(String username, String password, String name, String email, String n, String contact)
	{
		this.userName = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.number_of_classes = n;
		this.contact = contact;
	}
	
	 
}

