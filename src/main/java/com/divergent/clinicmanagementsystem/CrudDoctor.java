package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.divergent.dao.DoctorCrudDao;
import com.divergent.dto.DoctorDto;
import com.divergent.jdbc.DatabaseManager;

public class CrudDoctor {
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);
	CrudDoctor doctor = new CrudDoctor();

	public static void cruddoctor() {
		System.out.print("Enter the choice");
		do {
			System.out.println("\nDoctor CRUD operations\n");
			System.out.println("press 1 for insert Doctor record: \n");
			System.out.println("press 2 for update Doctor record: \n");
			System.out.println("press 3 for delete Doctor record: \n");
			System.out.println("press 4 for read Doctor record: \n");
			System.out.println("press 5 for exit:");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:

				CrudDoctor.insertDoctor();

				break;
			case 2:
				CrudDoctor.updateDoctor();
				break;
			case 3:
				CrudDoctor.deleteDoctor();
				break;
			case 4:
				CrudDoctor.readDoctor();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.print("Wrong Input: \n");
			}

		} while (true);

	}

	private static void readDoctor() {
		System.out.print("Display all patient records: \n");

		try {
			DoctorCrudDao dao = new DoctorCrudDao(new DatabaseManager());
			List<DoctorDto> dtos = dao.read();
			System.out.printf(
					"d_id          d_name \t       d_speaciality \t   d_degree \t        d_fees \n\n");
			for (DoctorDto doctorDto : dtos) {
				System.out.printf("%s %30s %15s  %20s %20s  ", doctorDto.getDid(), doctorDto.getDname(),
						doctorDto.getDspeciality(), doctorDto.getDegree(), doctorDto.getDfees());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	private static void updateDoctor() {
		System.out.println("Enter the doctor id which you want to update");
		String id = sc.nextLine();
		System.out.print("Enter doctor name which you want to update");
		String name = sc.next();
		System.out.print("Enter the doctor specialization which you want to update");
		String specialization = sc.next();
		System.out.print("Enter the doctor degree which you want to update");
		String degree = sc.next();
		System.out.print("Enter the doctor fees which you want to update");
		String fees = sc.next();
		try {
			DoctorCrudDao dao = new DoctorCrudDao(new DatabaseManager());
			dao.update(fees, name, specialization, degree, fees);
			System.out.println("\n-------Value  Updated-------");
		} catch (SQLException e) {
			System.out.println("\n-------Value Not Updated-------");

		}
	}

	private static void deleteDoctor() {
		try {
			DoctorCrudDao dao = new DoctorCrudDao(new DatabaseManager());
			System.out.println("Enter  the Doctor id  to delete --");
			String a = sc.nextLine();
			dao.delete(a);
			System.out.print("\n----Doctor  Deleted --");
		} catch (SQLException e) {
			System.err.println(e);
			System.out.print("\n----Doctor Not Deleted --");
		}
	}

	private static void insertDoctor() {
		System.out.print("Enter doctor id: \n");
		int id = sc.nextInt();

		System.out.println("Enter Doctor Name:\n");
		String name = sc.next();

		System.out.println("Enter doctor specialization:\n");
		String specialization = sc.next();

		System.out.println("Enter the Doctor Degree :\n");
		String degree = sc.next();

		System.out.println("Enter the Doctor fees: \n");
		String fees = sc.next();

		{
			DoctorCrudDao dao = new DoctorCrudDao(new DatabaseManager());
			try {
				dao.create(fees, name, specialization, degree, fees);
				System.out.println("\n-------Value Has Inserted-------");
			} catch (SQLException e) {
				System.err.println(e);
				System.out.println("\n-------Value Has  Not Inserted-------");
			}
		}

	}

}
