package THINQ;

import java.util.*;

public class thinqer extends user {
	
	
	thinqer()
	{
		
	}
	
	
	
	
	public static void main(String[] args)
	{
		
	}
	
String printdetails() {
		
		String x;
		x=" Your Details are : \n---------------------------------------------------------------\n";
		x = x + "Name :"+this.name+"\n"+"email :"+this.email+"\n"+"Contact :"+this.contact+"\n"+"number of classes :"+this.number_of_classes+"\n" +"---------------------------------------------------------";
		return x;
	}


}
