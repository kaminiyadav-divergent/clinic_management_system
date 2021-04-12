package com.divergent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.divergent.jdbc.IDatabaseManager;

public class AdminLoginDao {
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.AdminLoginDao");
	IDatabaseManager databaseManager;

	public AdminLoginDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public boolean adminDao(String user, String pass) {
		try {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			con = databaseManager.getConnection();
			st = con.createStatement();
			if (con != null) {
				rs = st.executeQuery("select * from admin where username ='" + user + "' && "
						+ " password = '" + pass + "'");
			}
			if (rs.next()) {
				logger.info("---Login successfull---");
				return true;
			}

			else {
				System.out.println("\npassword is incorrect: \n");
				return false;
			}

		} catch (SQLException e) {
			//System.out.print(e);
			logger.info(e.getMessage());
		}
		return false;

	}
}
