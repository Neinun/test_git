package THINQ;

import java.sql.*;
import javax.swing.*;


public class connect {
	
	Connection conn = null;
	
	public static Connection dbConnector()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:thinq_user_details.db");
			return conn;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
