package com.divergent.clinicmanagementsystem;

import java.util.Scanner;
import java.util.logging.Logger;

import com.divergent.dao.DoctorLoginDao;
import com.divergent.jdbc.DatabaseManager;

public class DoctorLogin {
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.DoctorLogin");

	static Scanner sc = new Scanner(System.in);
	

	public static boolean doctorLogin() {

		try {
			logger.info("---------Admin Panel----------");
			String user, pass;
			System.out.print("Enter your User name: ");
			user = sc.nextLine();
			System.out.print("Enter your password: ");
			pass = sc.nextLine();
			DoctorLoginDao doctorLoginDao = new DoctorLoginDao(new DatabaseManager());

			return doctorLoginDao.doctorLogin(user, pass);
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.info(e.getMessage());
			
		}
		return false;
	}

}
