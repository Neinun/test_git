package THINQ;

import java.util.*;

public class thinqer {
	
	ArrayList<lecture> upcoming_classes = new ArrayList<lecture>();
	String userName;
	String password;
	String name;
	String email;
	String number_of_classes;
	String contact;
	thinqer()
	{
		
	}
	thinqer(String username, String password, String name, String email, String n, String contact)
	{
		this.userName = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.number_of_classes = n;
		this.contact = contact;
	}
	
	
	
	public static void main(String[] args)
	{
		
	}

}
