package com.FMT.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




/**
 * This is the main driver program that parses the payroll
 * data file and produces a payroll report.
 *
 */

public class DataConverter {
	
	
	
	
	public static List<Persons> parseDataFile1() {
		List<Persons> result = new ArrayList<Persons>();
		File P = new File("data/Persons.csv");
		System.out.println("wow");
		try(Scanner p = new Scanner(P)){
			while(p.hasNext()) {
				String line = p.nextLine();
				System.out.println("wow1");
				if(!line.trim().isEmpty()) {
					System.out.println("wow2");
					Persons pep = null;
					String tokens[] = line.split(",");
					String nameTokens[] = tokens[1].split(",");
					String lastName = nameTokens[0];
					String firstName = nameTokens[1];
					String id = tokens[2];
					String addyTokens[] = tokens[3].split(",");
					String street = addyTokens[0];
					String city = addyTokens[1];
					String state = addyTokens[2];
					String zipCode = addyTokens[3];
					String country = addyTokens[4];
					String email = tokens[4];
				}
			}
			System.out.println("wow3");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("wow4");
		};
		return result;
}
	
	
	
	
	
	public static List<Store> parseDataFile2() {
		List<Store> result = new ArrayList<Store>();
		File S = new File("data/Stores.csv");
		try(Scanner s = new Scanner(S)){
			while(s.hasNext()) {
				String line = s.nextLine();
				if(!line.trim().isEmpty()) {
					Store str = null;
					String tokens[] = line.split(",");
					String store = tokens[0];
					String nameTokens[] = tokens[1].split(",");
					String lastName = nameTokens[0];
					String firstName = nameTokens[1];
					String addyTokens[] = tokens[2].split(",");
					String street = addyTokens[0];
					String city = addyTokens[1];
					String state = addyTokens[2];
					String zipCode = addyTokens[3];
					String country = addyTokens[4];
					String email = tokens[4];
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return result;
}
	
	
	
	
	
	public static List<Invoice> parseDataFile3() {
		List<Invoice> result = new ArrayList<Invoice>();
		File I = new File("data/Items.csv");
		try(Scanner i = new Scanner(I)){
			while(i.hasNext()) {
				String line = i.nextLine();
				if(!line.trim().isEmpty()) {
					Invoice inv = null;
					String tokens[] = line.split(",");
					String equipmentTokens[] = tokens[0].split(",");
					String equipCode = equipmentTokens[0];
					String equipName = equipmentTokens[1];
					String model = equipmentTokens[2];
					String type = tokens[1];
					String productsTokens[] = tokens[2].split(",");
					String productCode = productsTokens[0];
					String productName = productsTokens[1];
					String unit = productsTokens[2];
					double unitPrice = Double.parseDouble(productsTokens[3]);
					String serviceTokens[] = tokens[1].split(",");
					String serviceCode = serviceTokens[0];
					String serviceName = serviceTokens[1];
					double hourlyRate = Double.parseDouble(serviceTokens[2]);
					
					if(tokens[1].equals("E")) {
						inv = new Equipment(equipCode, type, equipName, model); //TODO: modify this
					} else if(tokens[1].equals("P")) {
						inv = new Products(productCode, type, productName, unit, unitPrice); //TODO: modify this
					} else if(tokens[1].equals("S")) {
						inv = new Services(serviceCode, type, serviceName, hourlyRate); //TODO: modify this
					}
					
					result.add(inv);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		return result;
}
	public static void main(String args[]) {
		try (Scanner main = new Scanner(System.in)) {
			System.out.println("Select Which File to Run");
			System.out.println("1 = Person");
			System.out.println("2 = Store");
			System.out.println("3 = Invoice");
			String x = main.nextLine();
			
			if(x == "Persons") {
				parseDataFile1();
				//get the people from the data file
				List<Persons> people = parseDataFile1();

				StringBuilder sb1 = new StringBuilder();
				
				sb1.append(String.format("%-30s %-30s %-30s %-30s\n", 
						"Name", "Code", "Address", "Email"));

				//for each employee
				for(Persons p : people) {
					//format their information
					sb1.append(String.format("%-8s %-20s %-10s %-30s\n", 
							p.getName(), p.getCode(), p.getAddress(), p.getEmail())); //TODO: replace these
				}
				
				System.out.println(sb1);
				
			} else if(x == "Store") {
				parseDataFile2();
				//get the employees from the data file
				List<Store> store = parseDataFile2();

				StringBuilder sb2 = new StringBuilder();
				
				sb2.append(String.format("%-8s %-20s %-10s\n", 
						"Store", "Manager", "Address"));

				//for each employee
				for(Store s : store) {
					//format their information
					sb2.append(String.format("%-30s %-30s %-30s\n", 
							s.getStore(), s.getManager(), s.getStoreAddress())); //TODO: replace these
				}
				
				System.out.println(sb2);
			} else if(x == "Invoice"){
				parseDataFile3();
				//get the employees from the data file
				List<Invoice> payroll = parseDataFile3();

				StringBuilder sb3 = new StringBuilder();
				
				sb3.append(String.format("%-8s %-20s %-10s %-30s %9s %9s %9s\n", 
						"ID", "Name", "Type", "Title", "Gross", "Taxes", "Net"));

				//for each employee
//				for(Invoice i : payroll) {
//					//format their information
//					sb3.append(String.format("%-8s %-20s %-10s %-30s $%8.2f $%8.2f $%8.2f\n", 
//							i.getId(), i.getFirstName(), i.getType(), e.getTitle(), e.getGrossPay(), e.getTaxes(), e.getNetPay())); //TODO: replace these
//				}
//				
//				System.out.println(sb3);
			}
		}
	}
}