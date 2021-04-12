package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DoctorLogin {

	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;

	public static boolean doctorLogin() {

		try {

			String user, pass;
			System.out.print("Enter your User name: ");
			user = sc.nextLine();
			System.out.print("Enter your password: ");
			pass = sc.nextLine();
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb_managementsystem", "root", "root");

			st = con.createStatement();
			String query = "select * from doctor where username ='" + user + "' &&  password = '" + pass + "'";
			rs = st.executeQuery(query);
			if (rs.next() == true) {
				System.out.println("Welcome");
				return true;
			} else {
				System.out.println("\npassword is incorrect: \n");
				return false;
			}

		} catch (Exception e) {
			System.out.print(e);
		}
		return false;
	}

}
