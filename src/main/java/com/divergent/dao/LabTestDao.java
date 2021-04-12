package com.divergent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergent.dto.LabTestDto;
import com.divergent.jdbc.IDatabaseManager;

public class LabTestDao {
	IDatabaseManager databaseManager;

	public LabTestDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public int delete(String a) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate("delete from labtest where labtest_id=" + a + "");
	}

	public int create(String labtest_id, String labtest_name, String labtest_date, String labtest_time, String pname)
			throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate("insert into labtest  values (" + labtest_id + ", '" + labtest_name + "','"
				+ labtest_date + "','" + labtest_time + "','" + pname + "')");
	}

	public List<LabTestDto> read() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs;
		con = databaseManager.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("select *from labtest");
		List<LabTestDto> list = new ArrayList<>();
		while (rs.next()) {
			LabTestDto dto = new LabTestDto();
			dto.setLabtest_id(rs.getString(1));
			dto.setLabtest_name(rs.getString(2));
			dto.setLabtest_date(rs.getString(3));
			dto.setLabtest_time(rs.getString(4));
			dto.setPname(rs.getString(5));
			list.add(dto);
		}
		return list;
	}

	public int update(String id, String labtest_name, String labtest_date, String labtest_time, String pname)
			throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate("update labtest set labtest_name='" + labtest_name + "',labtest_date=" + labtest_date
				+ ", labtest_time = " + labtest_time + ",pname = " + pname + " where labtest_id=" + id);
	}
}
