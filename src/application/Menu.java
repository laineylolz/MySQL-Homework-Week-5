package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.SodaDao;
import entity.Soda;

public class Menu {
	
	private SodaDao sodaDao = new SodaDao();
	private Scanner scanner = new Scanner(System.in);
	
	private List<String> options = Arrays.asList(
            "Create a Soda",
            "Display All Current Sodas",
            "Display a Specific Soda",
            "Update a Soda",
            "Delete a Soda");
	
	 public void start() {
	        String selection = "";

	        do {
	            printMenu();
	            selection = scanner.nextLine();

	            try {
	            if (selection.equals("1")){
	            	createSoda();
	            } else if (selection.equals("2")) {
	            	displayTotalSodas();
	            } else if (selection.equals("3")) {
	            	displaySoda();
	            } else if (selection.equals("4")) {
	                updateSoda();
	            } else if (selection.equals("5")) {
	            	deleteSoda();
	            }
	            
	            } catch (SQLException e) {
	            	e.printStackTrace();
	            }
	            
	            System.out.println("Please Press Enter to Continue.....");     
	            scanner.nextLine();
	            
	            } while(!selection.equals("-1"));
			}
	 
	private void printMenu() {
		System.out.println("Select an Option Please :)\n---------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	private void displayTotalSodas() throws SQLException {
		List<Soda> sodas = sodaDao.getAllSoda();
		for (Soda soda : sodas) {
			System.out.println(soda.getSodaId() + ": " + soda.getSodaName());
		}
	}
	
	private void displaySoda() throws SQLException {
		System.out.println("Enter Soda Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Soda soda = sodaDao.getSodaById(id);
		System.out.println(soda.getSodaId() + ": " + soda.getSodaName());
	}
	
	private void createSoda() throws SQLException {
		System.out.println("Enter New Soda Name: ");
		String name = scanner.nextLine();
		System.out.println("Enter Soda Quantity: ");
		String quantity = scanner.nextLine();
		if (quantity.equals("") || quantity.equals("1")) quantity = "1 item";
		System.out.println("Enter Soda Price: ");
		Double price = scanner.nextDouble();
		sodaDao.createNewSoda(name, quantity, price);
		
	}
	
	private void deleteSoda() throws SQLException {
		System.out.print("Enter Soda Id You Want to Delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		sodaDao.deleteSodaById(id);
	}
	
	private void updateSoda() throws SQLException {
		System.out.println("Update Soda: ");

        Soda soda = getSodaById();

        printSoda(soda);
        System.out.println("Select what you want to update: ");
        System.out.println("1) Name: ");
        System.out.println("2) Price: ");
        System.out.println("3) Quantity: ");
        System.out.println("4) Press 4 To Cancel: ");
        
        int selection = Integer.parseInt(scanner.nextLine());

        switch (selection) {
            case 1: setSodaName(soda);
                break;
            case 2: setSodaPrice(soda);
                break;
            case 3: setSodaQuantity(soda);
                break;
            default: 
                System.out.println("Cancelling update...\n");
                break;
        }
	
	}
	
	   private Soda getSodaById() throws SQLException {
	        System.out.println("Please Enter Soda ID: ");
	        int id = Integer.parseInt(scanner.nextLine());
	        return sodaDao.getSodaById(id);	
		
	}
	   private void printSoda(Soda soda) {
	        System.out.println("#" + soda.getSodaId() + " " + soda.getSodaName() + " $" 
	        		+ soda.getSodaPrice() + " per " + soda.getSodaQuantity());
	   }
	   private void setSodaName(Soda soda) throws SQLException {
	        System.out.println("Enter the new name: ");
	        soda.setSodaName(scanner.nextLine());

	        sodaDao.updateSoda(soda);
	   }
	   private void setSodaPrice(Soda soda) throws SQLException {
	        System.out.println("Enter the new soda price: ");
	        soda.setSodaPrice(Double.parseDouble(scanner.nextLine()));

	        sodaDao.updateSoda(soda);
	   }
	   private void setSodaQuantity(Soda soda) throws SQLException {
	        System.out.println("Enter the new soda quantity: ");
	        soda.setSodaQuantity(scanner.nextLine());

	        sodaDao.updateSoda(soda);
	   }
}