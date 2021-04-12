package com.divergent.clinicmanagementsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

import com.divergent.dao.DrugCrudDao;
import com.divergent.dto.DrugDto;
import com.divergent.jdbc.DatabaseManager;

public class Drug {
	static Connection con = null;
	static Statement st = null;
	static ResultSet rs = null;
	static Scanner sc = new Scanner(System.in);
	Drug drug = new Drug();

	public static void drugs() {

		while (true) {
			System.out.println("\nDrug CRUD operations\n");
			System.out.println("press 1 for insert Drug record: \n");
			System.out.println("press 2 for update Drug record: \n");
			System.out.println("press 3 for delete Drug record: \n");
			System.out.println("press 4 for read Drug record: \n");
			System.out.println("press 5 for exit:");

			System.out.print("Enter the choice");
			int choice = sc.nextInt();
			switch (choice) {

			case 1:
				Drug.insertDrug();
				break;
			case 2:
				Drug.updateDrug();
				break;
			case 3:
				Drug.deleteDrug();
				break;
			case 4:
				Drug.readDrug();
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.out.print("Wrong Input: \n");
			}

		}

	}

	private static void readDrug() {
		DrugCrudDao dao = new DrugCrudDao(new DatabaseManager());
		try {
			List<DrugDto> drugsDtos = dao.read();
			System.out.printf("DrugID \t DrugName \t DrugDiscription\n");
			for (DrugDto drugsDto : drugsDtos) {
				System.out.printf("%10d\t|| %10s\t|| %10s ", drugsDto.getDrugid(), drugsDto.getDrugname(),
						drugsDto.getDrugdesc());
				System.out.println("");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void deleteDrug() {
		DrugCrudDao dao = new DrugCrudDao(new DatabaseManager());
		System.out.print("Enter the drug id those you want to delete");
		int id = sc.nextInt();
		try {
			System.out.print("\n----Enter Drug ID  To Delete Drug --");
			int a = sc.nextInt();
			dao.delete(a);
			System.out.println("\n---- Drug Delete----\n");
		} catch (Exception e) {
			// System.err.println(e);
			System.out.println("\n---- Drug Not Delete----\n");
		}
	}

	private static void updateDrug() {
		DrugCrudDao dao = new DrugCrudDao(new DatabaseManager());
		System.out.print("Enter the drug id which you want to update");
		int id = sc.nextInt();
		System.out.print("Enter drug name which you want to update");
		String name = sc.next();
		try {
			dao.update(name, name, name);
			System.out.println("\n-------Value Has Updated-------");
		} catch (Exception e) {
			System.out.println("\n-------Value Has Not Updated-------");
		}
	}

	private static void insertDrug() {
		DrugCrudDao dao = new DrugCrudDao(new DatabaseManager());

		System.out.print("Enter Drug id: \n");
		int id = sc.nextInt();

		System.out.println("Enter Drug Name:\n");
		String name = sc.next();
		{
			try {
				dao.create(name, name, name);
				System.out.println("\n-------Value Has Inserted-------");
			} catch (Exception e) {
				System.out.println("\n-------Value Has Not Inserted-------");
			}
		}
	}

}
