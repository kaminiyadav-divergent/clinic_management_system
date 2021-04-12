package com.divergent.clinicmanagementsystem;

import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Appointment {
	static Scanner sc = new Scanner(System.in);
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	Appointment appoint = new Appointment();

	public static void appointment() {

		System.out.print("Enter the appointment id: \n");
		String id = sc.nextLine();

		System.out.println("Enter the pateient id :\n");
		String p_id = sc.nextLine();
		System.out.println("Enter the doctor id :\n");
		String d_id = sc.nextLine();
		System.out.println("Enter the Problem :\n");
		String problem = sc.nextLine();
		System.out.println("Enter the Date \n");
		String date = sc.nextLine();

		System.out.println("Enter the Time \n");
		String time = sc.nextLine();

		{
			try {
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb_managementsystem", "root",
						"root");

				st = con.createStatement();

				String query = "INSERT INTO appointment_table VALUES('" + id + "','" + p_id + "','" + d_id + "','"
						+ problem + "','" + date + "','" + time + "')";
				System.out.println("Query=" + query);

				int i = st.executeUpdate(query);

				if (i > 0) {
					System.out.println(i + " Record Inserted..");
				} else {
					System.out.println("Record Insertion Failed..");
				}

				con.close();
			} catch (ClassNotFoundException e1) {
				System.out.println(e1);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}

	public static void viewBookedAppointment() {

		System.out.print("Display all booked appointment: \n");

		try {
			Class.forName("com.mysql.jdbc.Driver");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb_managementsystem", "root", "root");

			st = con.createStatement();

			String query = "select * from appointment";

			rs = st.executeQuery(query);

			while (rs.next()) {
				System.out.print(rs.getInt(1) + "\t");
				System.out.print(rs.getString(2) + "\t");
				System.out.print(rs.getString(3) + "\t");
				System.out.println(rs.getString(4) + "\t");
				System.out.println(rs.getString(6) + "\t");
				System.out.println(rs.getString(7));
			}

			con.close();
		} catch (ClassNotFoundException e1) {
			System.out.println(e1);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void addPrescription() {
		System.out.print("Enter Prescription id: \n");
		String p_id = sc.nextLine();

		System.out.println("Enter Appointment id:\n");
		String a_id = sc.nextLine();

		System.out.println("Enter Patient name:\n");
		String name = sc.nextLine();

		System.out.println("Enter the medicine name:\n");
		String medicine = sc.nextLine();

		{
			try {
				Class.forName("com.mysql.jdbc.Driver");

				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/clinicdb_managementsystem", "root",
						"root");

				st = con.createStatement();

				String query = "INSERT INTO patient VALUES('" + p_id + "','" + a_id + "','" + name + "','" + medicine
						+ "')";
				System.out.println("Query=" + query);

				int i = st.executeUpdate(query);

				if (i > 0) {
					System.out.println(i + " Prescription Added..");
				} else {
					System.out.println("Prescription Added Failed..");
				}

				con.close();
			} catch (ClassNotFoundException e1) {
				System.out.println(e1);
			} catch (SQLException e) {
				System.out.println(e);
			}
		}

	}
}
