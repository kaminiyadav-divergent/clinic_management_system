package com.divergent.clinicmanagementsystem;

import java.util.Scanner;
import java.util.logging.Logger;

public class Doctor {
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.Doctor");
	static Scanner sc = new Scanner(System.in);
	public static boolean doctoroperation() {

		while (true) {
			System.out.println("press 1 for  List of Patient:\n ");
			System.out.println("press 2 for Add Prescription:\n ");
			System.out.println("press 3 for View booked appointment : \n");
			System.out.println("press 4 for Checked Patient history: \n");
			System.out.println("press 5for exit:");
			System.out.print("Enter the choice : ");
			

			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				PatientList.list();
				break;
			case 2:
				 Appointment.addPrescription();

				break;
			case 3:
				Appointment.viewBookedAppointment();

				break;
			case 4:
				 LabTest.labTest();
			case 5:
				 Appointment.appointment();

			case 6:
				System.exit(0);
				break;
			default:
				logger.warning("Wrong Input:----- \n");
			}
		}
	}
}
