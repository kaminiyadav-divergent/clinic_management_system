package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.divergent.dao.DoctorCrudDao;
import com.divergent.dto.DoctorDto;
import com.divergent.jdbc.DatabaseManager;

public class CrudDoctor {
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);
	CrudDoctor doctor = new CrudDoctor();
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.CrudDoctor");
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
		System.out.println("Display all patient records: \n");

		try {
			DoctorCrudDao dao = new DoctorCrudDao(new DatabaseManager());
			List<DoctorDto> dtos = dao.read();
			System.out.printf(
					"docid          docname \t       d_speaciality \t      degree \t       fees \n\n");
			for (DoctorDto doctorDto : dtos) {
				System.out.printf("%5s %15s %15s  %15s %15s  ", doctorDto.getDid(), doctorDto.getDname(),
						doctorDto.getDspeciality(), doctorDto.getDegree(), doctorDto.getDfees());
				System.out.println("\n");
			}
		} catch (SQLException e) {
			System.out.println(e);
			logger.info(e.getLocalizedMessage());
			logger.warning(e.getMessage());
		}

	}

	private static void updateDoctor() {
		System.out.println("Enter the doctor id which you want to update");
		int id = sc.nextInt();
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
			logger.info("\n-------Value  Updated-------");
		} catch (SQLException e) {
			logger.info("\n-------Value Not Updated-------");

		}
	}

	private static void deleteDoctor() {
		try {
			DoctorCrudDao dao = new DoctorCrudDao(new DatabaseManager());
			System.out.println("Enter  the Doctor id  to delete --");
			String a = sc.nextLine();
			sc.next();
			dao.delete(a);
			logger.info("\n----Doctor  Deleted --");
		} catch (SQLException e) {
			System.err.println(e);
			logger.info("\n----Doctor Not Deleted --");
			logger.warning(e.getMessage());
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
