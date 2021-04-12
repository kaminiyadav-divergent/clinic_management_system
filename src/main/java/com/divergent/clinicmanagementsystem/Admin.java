package com.divergent.clinicmanagementsystem;

import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Admin {
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.Admin");
	static Scanner sc = new Scanner(System.in);
	public static boolean adminPanel() {
		
		while (true) {
			System.out.println("press 1 for CRUD operations of patient:\n ");
			System.out.println("press 2 for CRUD operations of doctor:\n ");
			System.out.println("press 3 for CRUD operations of Drugs: \n");
			System.out.println("press 4 for CRUD operations of Labtest: \n");
			System.out.println("press 5 for appointments: \n");
			System.out.println("press 6 for exit:");
			System.out.print("Enter the choice : ");
			
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				CrudPatient.crud();

				break;

			case 2:
				CrudDoctor.cruddoctor();

				break;

			case 3:
				Drug.drugs();

				break;

			case 4:
				LabTest.labTest();

				break;

			case 5:
				Appointment.appointment();

				break;

			case 6:
				System.exit(0);

				break;

			default:
				logger.warning("Wrong Input: \n");
			}
		}

	}
}
