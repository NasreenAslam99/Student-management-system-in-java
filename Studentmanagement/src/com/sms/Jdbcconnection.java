package com.sms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Jdbcconnection {
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/student_management","root","Nasisumi@99");
			
		}catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
