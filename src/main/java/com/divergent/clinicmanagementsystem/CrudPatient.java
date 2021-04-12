package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.divergent.dao.PatientCrudDao;
import com.divergent.dto.PatientDto;
import com.divergent.jdbc.DatabaseManager;
import com.sun.org.slf4j.internal.LoggerFactory;

public class CrudPatient {
	static Scanner sc = new Scanner(System.in);
	CrudPatient crudpatient = new CrudPatient();

	public static void crud() {

		while (true) {
			System.out.println("\nAdmin CRUD operations\n");
			System.out.println("press 1 for patient record insertion: \n");
			System.out.println("press 2 for update patient record: \n");
			System.out.println("press 3 for delete patient record: \n");
			System.out.println("press 4 for read patient record: \n");
			System.out.println("press 5 for exit:");
			System.out.print("Enter the choice");
			int choice = sc.nextInt();

			switch (choice) {

			case 1:

				CrudPatient.insertPatient();

				break;
			case 2:
				CrudPatient.updatePatient();
				break;
			case 3:
				CrudPatient.deletePatient();
				break;
			case 4:
				CrudPatient.readPatient();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.print("Wrong Input: \n");
			}

		}

	}

	public static void insertPatient() {
		System.out.println("Enter Patient id: ");
		String patient_id = sc.next();

		System.out.println("Enter Patient Name:\n");
		String patient_name = sc.next();

		System.out.println("Enter Patient contact number:\n");
		String patient_contactnumber = sc.next();

		System.out.println("Enter the Patient age:\n");
		String patient_age = sc.next();

		System.out.println("Enter the Patient adress: \n");
		String patient_adress = sc.next();

		{
			PatientCrudDao dao = new PatientCrudDao(new DatabaseManager());
			try {
				dao.create(patient_adress, patient_name, patient_age, patient_contactnumber, patient_adress);
				System.out.println("\n-------Value Has Inserted-------");
			} catch (SQLException e) {
				System.err.println(e);
				System.out.println("\n-------Value Has  Not Inserted-------");
			}
		}

	}

	public static void deletePatient() {

		try {
			System.out.println("Enter Patient ID  To Delete Patient ----");
			int a = sc.nextInt();
			PatientCrudDao dao = new PatientCrudDao(new DatabaseManager());
			dao.delete(a);
			System.out.println("\n-------Patient--------");
		} catch (Exception e) {
			System.err.println(e);
		}

	}

	public static void updatePatient() {
		try {

			readPatient();
			System.out.print("Enter the patient id which you want to update");
			sc.nextLine();
			System.out.print("Enter the patient name which you want to update");
			String name = sc.next();
			System.out.print("Enter the patient contact number which you want to update");
			String contact = sc.next();
			System.out.print("Enter the patient age which you want to update");
			String age = sc.next();
			System.out.print("Enter the patient adress which you want to update");
			String adress = sc.next();
			PatientCrudDao dao = new PatientCrudDao(new DatabaseManager());

			dao.update(adress, name, age, contact, adress);

			System.out.println("deatils has updated-------");

		} catch (Exception e) {
			System.err.println(e);
			System.out.println("\n-------Value NOT Updated-------");
		}

	}

	public static void readPatient() {

		PatientCrudDao dao = new PatientCrudDao(new DatabaseManager());

		try {
			List<PatientDto> list = dao.read();
			System.out.printf(
					"patient Id \t Patient Name \t Patient Contact \t Patient Age \t  Patient Address \n\n");
			for (PatientDto patientDto : list) {
				System.out.printf("%5s %15s %15s %15s %15s  ", patientDto.getPid(), patientDto.getPname(),
						patientDto.getPcontact(), patientDto.getPage(), patientDto.getPadress());
				System.out.println("\n");
			}

		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
