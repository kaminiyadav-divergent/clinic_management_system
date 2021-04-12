package com.divergent.clinicmanagementsystem;


import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

import com.divergent.dao.DrugCrudDao;
import com.divergent.dto.DrugDto;
import com.divergent.jdbc.DatabaseManager;

public class Drug {
	
	private static final Logger logger = Logger.getLogger("com.divergent.clinicmanagementsystem.Drug");
	static Scanner sc = new Scanner(System.in);
	Drug drug = new Drug();

	public static void drugs() {

		while (true) {
			logger.info("-----\nDrug CRUD operations\n-------");
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
				logger.warning("Wrong Input: \n");
			}

		}

	}

	private static void readDrug() {
		DrugCrudDao dao = new DrugCrudDao(new DatabaseManager());
		try {
			List<DrugDto> drugsDtos = dao.read();
			System.out.printf("DrugID \t DrugName \t DrugDiscription\n");
			for (DrugDto drugsDto : drugsDtos) {
				System.out.printf("%5d\t|  %15s\t|  %15s ", drugsDto.getDrugid(), drugsDto.getDrugname(),
						drugsDto.getDrugdesc());
				System.out.println("");
			}
		} catch (SQLException e) {
			//e.printStackTrace();
			logger.info(e.getMessage());
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
		System.out.print("Enter drug name");
		String name = sc.nextLine();
		sc.nextLine();
		System.out.print("Enter drug description");
		String desc = sc.nextLine();
		sc.nextLine();
		try {
			dao.update(id, name, desc);
			logger.info("\n------- Drugs Details Updated-------");
		} catch (Exception e) {
			logger.info("\n------Drugs Details has Not Updated-------");
		}
	}

	private static void insertDrug() {
		DrugCrudDao dao = new DrugCrudDao(new DatabaseManager());

		System.out.println("Enter Drug id: ");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Enter Drug Name:");
		String name = sc.nextLine();
		

		System.out.println("Enter Drug Description:");
		String desc = sc.nextLine();

		try {
			dao.create(id, name, desc);
			logger.info("\n-------Details Has Inserted-------");
		} catch (Exception e) {
			logger.info("\n-------Deatils Has Not Inserted-------");
		}

	}

}
