package com.divergent.clinicmanagementsystem;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class AdminLogin {

	private static Scanner sc;

	public static boolean adminLogin() {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			sc = new Scanner(System.in);
			String user, pass;
			System.out.print("Enter your User name: ");
			user = sc.nextLine();
			System.out.print("Enter your password: ");
			pass = sc.nextLine();
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb_managementsystem", "root", "root");
			
			st = con.createStatement();
			String query = "select * from admin where username ='" + user + "' &&  password = '" + pass + "'";
			rs = st.executeQuery(query);
			if (rs.next() == true) {
				System.out.println("................................Welcome to Home Page : ..........................\n");
				return true;
			} else {
				System.out.println("\npassword is incorrect: \n");
				return false;
			}

		} catch (Exception e) {
			System.out.print(e);
		}return false;

	}
	
		

	
}


