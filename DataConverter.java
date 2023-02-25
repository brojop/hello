package com.fmt;

import java.io.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//import org.json.JSONOBJECT;




/**
 * This is the main driver program that parses the customer, store and items
 * data file and produces a sales report.
 *
 */

public class DataConverter {
	
	
	
	
	public static List<Persons> parseDataFile1() {
		List<Persons> result = new ArrayList<Persons>();
		File P = new File("data/Persons.csv");
		System.out.println("wow");
		try(Scanner p = new Scanner(P)){
			p.nextLine();
			while(p.hasNext()) {
				String line = p.nextLine();
				System.out.println("wow1");
				if(!line.trim().isEmpty()) {
					System.out.println("wow2");
					Persons customer = null;
					String tokens[] = line.split(",");
					//String nameTokens[] = tokens[1].split(",");
					String lastName = tokens[1];
					String firstName = tokens[2];
					String id = tokens[0];
					//String addyTokens[] = tokens[3].split(",");
					String street = tokens[3];
					String city = tokens[4];
					String state = tokens[5];
					String zipCode = tokens[6];
					String country = tokens[7];
	//				String emailTokens[] = tokens[8].split(",");
					String email = "";
					if(tokens.length == 8) {
						 email = "";
					} else if(tokens.length == 9) {
						 email = tokens[8];
					}
					
					Address address = new Address(street, city, state, zipCode, country);
					Name name = new Name(lastName, firstName);
					customer = new Persons(id, name, address, email);
					result.add(customer);
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
			s.nextLine();
			while(s.hasNext()) {
				String line = s.nextLine();
				if(!line.trim().isEmpty()) {
					Store store = null;
					String tokens[] = line.split(",");
					String storeCode = tokens[0];
					//String nameTokens[] = tokens[1].split(",");
				//	String lastName = nameTokens[0];
					//String firstName = nameTokens[1];
					String managerCode = tokens[1];
					//String addyTokens[] = tokens[2].split(",");
					String street = tokens[2];
					String city = tokens[3];
					String state = tokens[4];
					String zipCode = tokens[5];
					String country = tokens[6];
				
					Address address = new Address(street, city, state, zipCode, country);
					store = new Store(storeCode, managerCode, address);
					result.add(store);
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
			i.nextLine();
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
//			System.out.println("Select Which File to Run");
	//		System.out.println("1 = Person");
		//	System.out.println("2 = Store");
//			System.out.println("3 = Invoice");
//			String x = main.nextLine();
			
			System.out.println("+----------------------------------------------------------------------------------------+");
			System.out.println("| Summary Report - By Total                                                              |");
			System.out.println("+----------------------------------------------------------------------------------------+");
			System.out.println("Invoice #  Store      Customer                       Num Items          Tax       Total");
			
//			ObjectMapper objectMapper = new ObjectMapper();
			
			
//			if(x == "Persons") {
				parseDataFile1();
				//get the people from the data file
				List<Persons> people = parseDataFile1();

				StringBuilder sb1 = new StringBuilder();
				
				sb1.append(String.format("%-30s %-30s %-30s %-30s\n", 
						"Code", "Name", "Address", "Email"));

				//for each person
				for(Persons p : people) {
					//format their information
					sb1.append(String.format("%-30s %-30s %-30s %-30s\n", 
							p.getCode(), p.getName(), p.getAddress(), p.getEmail())); //TODO: replace these
				}
				
				System.out.println(sb1);
				
	//		} else if(x == "Store") {
				parseDataFile2();
				//get the employees from the data file
				List<Store> store = parseDataFile2();

				StringBuilder sb2 = new StringBuilder();
				
				sb2.append(String.format("%-8s %-20s %-10s\n", 
						"Store", "Manager", "Address"));

				//for each employee
				for(Store s : store) {
					//format the stores information
					sb2.append(String.format("%-30s %-30s %-30s\n", 
							s.getStoreCode(), s.getManagerCode(), s.getAddress())); //TODO: replace these
				}
				
				System.out.println(sb2);
				
//			} else if(x == "Invoice"){
//				parseDataFile3();
				//get the employees from the data file
//				List<Invoice> inv = parseDataFile3();

//				StringBuilder sb3 = new StringBuilder();
				
//				sb3.append(String.format("%-8s %-20s %-10s %-30s %9s %9s %9s\n", 
//						"ID", "Name", "Type", "Title", "Gross", "Taxes", "Net"));

				//for each employee
//				for(Invoice i : inv) {
					//format their information
//					sb3.append(String.format("%-8s %-20s %-10s %-30s $%8.2f $%8.2f $%8.2f\n", 
//							i.getId(), i.getFirstName(), i.getType(), e.getTitle(), e.getGrossPay(), e.getTaxes(), e.getNetPay())); //TODO: replace these
				}
				
//				System.out.println(sb3);
			}
		}
	//}
//}