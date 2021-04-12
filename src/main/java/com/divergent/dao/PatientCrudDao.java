package com.divergent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergent.dto.PatientDto;
import com.divergent.jdbc.IDatabaseManager;
public class PatientCrudDao {
	IDatabaseManager databaseManager;

	public PatientCrudDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public int create(String pid, String pname, String page, String pcontact, String padress) throws SQLException {

		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		int x = st.executeUpdate("insert into patient values ('" + pid + "', '" + pname + "','" + page + "', '" + pcontact
				+ "', '" + padress + "')");
		return x;
	}

	public int delete(int x) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		int y = st.executeUpdate("delete from patient where pid=" + x + "");
		return y;
	}

	public List<PatientDto> read() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("select * from patient");

		List<PatientDto> list = new ArrayList<PatientDto>();

		while (rs.next()) {
			PatientDto dto = new PatientDto();
			dto.setPid(rs.getString(1));
			dto.setPname(rs.getString(2));
			dto.setPage(rs.getString(3));
			dto.setPcontact(rs.getString(4));
			dto.setPadress(rs.getString(5));
			list.add(dto);
		}
		return list;
	}

	public int update(String pid, String pname, String page, String pcontact, String padress) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		int z = st.executeUpdate("update patient set pname='" + pname + "', page=" + page + "'" + ",pcontact='"
				+ pcontact + "',paddress='" + padress + "' where pid=" + pid);
		return z;
	}

}
