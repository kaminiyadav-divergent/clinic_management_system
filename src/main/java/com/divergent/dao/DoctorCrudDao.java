package com.divergent.dao;

import com.divergent.jdbc.IDatabaseManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergent.dto.DoctorDto;

public class DoctorCrudDao {
	IDatabaseManager databaseManager;

	/**
	 * this is a constructor this will accept connection
	 * 
	 * @param connectionInterface
	 */
	public DoctorCrudDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public List<DoctorDto> read() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		con = databaseManager.getConnection();
		st = con.createStatement();

		rs = st.executeQuery("select * from doctor");
		List<DoctorDto> doctorDtos = new ArrayList<>();
		while (rs.next()) {

			DoctorDto doctorDto = new DoctorDto();
			doctorDto.setDid(rs.getString(1));
			doctorDto.setDname(rs.getString(2));
			doctorDto.setDspeciality(rs.getString(3));
			doctorDto.setDegree(rs.getString(4));
			doctorDto.setDfees(rs.getString(5));
			doctorDtos.add(doctorDto);
		}
		return doctorDtos;
	}

	public int create(String did, String dname, String dspeciality, String degree, String dfees) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		int x = st.executeUpdate("insert into doctordetails values (" + did + ", '" + dname + "','" + dspeciality
				+ "', '" + degree + "', '" + dfees + "')");
		return x;
	}

	public int update(String did, String dname, String dspeciality, String degree, String dfees) throws SQLException {
		Connection con = null;
		Statement st = null;

		con = databaseManager.getConnection();
		st = con.createStatement();
		int y = st.executeUpdate("update doctordetails set dname = '" + dname + "' ,dspeciality = '" + dspeciality
				+ "', degree = '" + degree + "', dfees = '" + dfees + "', where did = " + did);
		return y;

	}

	public int delete(String y) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		int z = st.executeUpdate("delete from doctor where doc_id=" + y + "");
		return z;
	}
}
