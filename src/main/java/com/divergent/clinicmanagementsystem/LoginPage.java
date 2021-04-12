package com.divergent.clinicmanagementsystem;

import java.util.Scanner;
import java.util.logging.Logger;


public class LoginPage {
	static Scanner sc = new Scanner(System.in);
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.LoginPage");
	public static void main(String[] args) {

		LoginPage.funtionalities();
		
	}

	public static boolean funtionalities() {

		while (true) {
			logger.info("\n-----Welcome To Clinic  Management System\n----");
			System.out.println("press 1 for admin login:\n ");
			System.out.println("press 2 for doctor login:\n ");
			System.out.println("press 3 for exit:");
			System.out.print("Enter the choice : ");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				if (AdminLogin.adminLogin())
					Admin.adminPanel();
				else
					return false;
				break;
			case 2:
				if (DoctorLogin.doctorLogin())
					Doctor.doctoroperation();
				else
					return false;
				break;
			case 3:
				System.exit(0);
				break;
			default:
				logger.info("----Wrong Input: ----\n");
			}
		}

	}

}
