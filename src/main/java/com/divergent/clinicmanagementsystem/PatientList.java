package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PatientList {
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);

	public static void list() {
		System.out.print("Display all patient records: \n");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb_managementsystem", "root", "root");

			st = con.createStatement();

			String query = "select * from appointment_table at left join doctor d on d.doctor_id = at.doctor_id";

			rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.print(rs.getString(4) + "\t");
				System.out.print(rs.getString(5) + "\t");
				System.out.print(rs.getString(6) + "\t");
				System.out.print(rs.getString(7) + "\t");
				System.out.print(rs.getString(8));
				System.out.println();

			}

			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
