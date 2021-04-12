package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.List;

import com.divergent.dao.DoctorCrudDao;
import com.divergent.dao.LabTestDao;
import com.divergent.dto.LabTestDto;
import com.divergent.jdbc.DatabaseManager;

public class LabTest {
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);

	public static void labTest() {

		while (true) {
			System.out.println("\nLabTest CRUD operations\n");
			System.out.println("press 1 for insert LabTest record: \n");
			System.out.println("press 2 for update LabTest record: \n");
			System.out.println("press 3 for delete LabTest record: \n");
			System.out.println("press 4 for read LabTest record: \n");
			System.out.println("press 5 for exit:");
			System.out.print("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				LabTest.insertLabTest();
				break;
			case 2:
				LabTest.updateLabTest();
				break;
			case 3:
				LabTest.deleteLabTest();
				break;
			case 4:
				LabTest.readLabTest();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.print("Wrong Input: \n");
			}

		}

	}

	private static void readLabTest() {

		System.out.print("Display all labtest records: \n");

		LabTestDao dao = new LabTestDao(new DatabaseManager());
		try {
			List<LabTestDto> list = dao.read();
			System.out.printf(" LabTest Id\t  LabTest Name \t LabTest Date \t LabTest Time \t Patient Name \n");
			for (LabTestDto labTestDto : list) {
				System.out.printf("%5s %20s %15s, %15s, %15s", labTestDto.getLabtest_id(), labTestDto.getLabtest_name(),
						labTestDto.getLabtest_date(), labTestDto.getLabtest_time(), labTestDto.getPname());
				System.out.println("\n");
			}
		} catch (Exception e) {
			System.err.println(e);
		}
	}

	private static void deleteLabTest() {
		try {
			LabTestDao dao = new LabTestDao(new DatabaseManager());

			System.out.println("Enter  the LabTest id  to delete --");
			String a = sc.nextLine();
			dao.delete(a);
			System.out.println("----Doctor  Deleted --");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.print("\n----Doctor Not Deleted --");
		}
	}

	private static void updateLabTest() {
		// TODO Auto-generated method stub

		System.out.print("Enter the labtest id which you want to update");
		int id = sc.nextInt();
		System.out.print("Enter labtest name which you want to update");
		String name = sc.next();
		System.out.print("Enter labtest date which you want to update");
		String date = sc.next();
		System.out.print("Enter labtest time which you want to update");
		String time = sc.next();
		System.out.print("Enter labtest patientname which you want to update");
		String p_name = sc.next();
		LabTestDao dao = new LabTestDao(new DatabaseManager());
		try {
			dao.update(name, p_name, date, time, p_name);
			System.out.println("\n-------Value Has Updated-------");
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private static void insertLabTest() {

		System.out.print("Enter the labtest id");
		int id = sc.nextInt();
		System.out.print("Enter labtest name ");
		String name = sc.next();
		System.out.print("Enter labtest date ");
		String date = sc.next();
		System.out.print("Enter labtest time ");
		String time = sc.next();
		System.out.print("Enter labtest patientname");
		String p_name = sc.next();
		{
			LabTestDao dao = new LabTestDao(new DatabaseManager());

			try {
				dao.create(name, p_name, date, time, p_name);
				System.out.println("\n-------Value Has Inserted-------");
			} catch (Exception e) {
				System.out.println("\n-------Value Has Not Inserted-------");
			}

		}
	}
}
