package com.divergent.dto;

public class DrugDto {
	int drugid;
	private String drugname, drugdesc;

	public int getDrugid() {
		return drugid;
	}

	public void setDrugid(int drugid) {
		this.drugid = drugid;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getDrugdesc() {
		return drugdesc;
	}

	public void setDrugdesc(String drugdesc) {
		this.drugdesc = drugdesc;
	}
}
