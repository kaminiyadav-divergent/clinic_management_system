package com.divergent.clinicmanagementsystem;

import java.util.Scanner;
import java.util.logging.Logger;

import com.divergent.dao.AdminLoginDao;
import com.divergent.jdbc.DatabaseManager;

public class AdminLogin {
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.AdminLogin");

	private static Scanner sc;

	public static boolean adminLogin() {
		try {
			System.out.println("Admin Panel");
			sc = new Scanner(System.in);
			String user, pass;
			System.out.print("Enter your User name: ");
			user = sc.nextLine();
			System.out.print("Enter your password: ");
			pass = sc.nextLine();
			AdminLoginDao adminLoginDao = new AdminLoginDao(new DatabaseManager());

			return adminLoginDao.adminDao(user, pass);
			
		} catch (Exception e) {
			//e.printStackTrace();
			logger.fine(e.getMessage());
			logger.warning(e.getMessage());
			

		}
		return false;

	}

}
