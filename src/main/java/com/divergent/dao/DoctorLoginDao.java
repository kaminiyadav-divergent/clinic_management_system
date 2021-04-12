package com.divergent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import com.divergent.jdbc.IDatabaseManager;

public class DoctorLoginDao {
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.DoctorLoginDao");
	IDatabaseManager databaseManager;

	public DoctorLoginDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public boolean doctorLogin(String user, String pass) {
		try {
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;
			con = databaseManager.getConnection();
			st = con.createStatement();
			if (con != null) {
				if (con != null) {
					rs = st.executeQuery(
							"select * from admin where username ='" + user + "' && " + " password = '" + pass + "'");
				}
				if (rs.next()) {
					logger.info("---Login successfull---");
					return true;
				}

				else {
					logger.info("\npassword is incorrect: \n");
					return false;
				}

			}
		} catch (SQLException e) {
			//System.out.print(e);
			logger.warning(e.getMessage());
			

		}
		return false;
	}
}
