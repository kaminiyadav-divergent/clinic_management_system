package com.divergent.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.divergent.dto.DrugDto;
import com.divergent.jdbc.IDatabaseManager;

public class DrugCrudDao {
	IDatabaseManager databaseManager;

	public DrugCrudDao(IDatabaseManager databaseManager) {
		this.databaseManager = databaseManager;
	}

	public int delete(int a) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate("delete from labtest where labtest_id=" + a + "");
	}

	public int create(int id, String drugname, String drugdesc) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate("insert into drugtable  values ('" + id + "', '" + drugname + "','" + drugdesc + "')");
	}

	public List<DrugDto> read() throws SQLException {
		Connection con = null;
		Statement st = null;
		ResultSet rs;
		con = databaseManager.getConnection();
		st = con.createStatement();
		rs = st.executeQuery("select *from drugtable");
		List<DrugDto> list = new ArrayList<>();
		while (rs.next()) {
			DrugDto dto = new DrugDto();
			dto.setDrugid(rs.getInt(1));
			dto.setDrugname(rs.getString(2));
			dto.setDrugdesc(rs.getString(3));
			list.add(dto);
		}
		return list;

	}

	public int update(int id, String drugname, String drugdesc) throws SQLException {
		Connection con = null;
		Statement st = null;
		con = databaseManager.getConnection();
		st = con.createStatement();
		return st.executeUpdate(
				"update drugtable set drugname ='" + drugname + "', drugdesc='" + drugdesc + "' where drugid=" + id);
	}
}
