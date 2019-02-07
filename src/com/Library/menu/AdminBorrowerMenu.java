package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.service.BorrowerService;
import com.Library.service.LibraryBranchService;
import com.Library.service.PublisherService;
import com.Library.model.Borrower;
import com.Library.util.ConnectDatabase;

public class AdminBorrowerMenu {
	
	AdministratorDao adminstratorDao = new AdministratorDao();
	
	public void BorrowerMenu() {
		Connection conn = ConnectDatabase.getConnection();
		MainMenu mainMenu = new MainMenu();
		Scanner scnr = new Scanner(System.in);
		System.out.println("1) Add Borrower");
		System.out.println("2) Delete Borrower");
		System.out.println("3) Update Borrower");
		System.out.println("4) Quit to Previous");
		String response = scnr.next();
		if(response.equals("1")) {
			
			adminAddBorrower(conn);
			
		}else if(response.equals("2")) {
			
			adminDeleteBorrower(conn);
			
		}else if(response.equals("3")) {
			
			adminUpdateBorrower(conn);
			
		}else if(response.equals("4")) {
			
		 mainMenu.displayMainMenu();
		}
	}

	public void adminAddBorrower(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Borrower borrower = new Borrower();
		Scanner scnr = new Scanner(System.in);
		BorrowerService borrowerService = new BorrowerService();
		borrowerService.getAllBorrowers();
		System.out.println();
		System.out.println("Enter Borrower Name");
		String borrowerName = scnr.nextLine();
		System.out.println("Enter Borrower Address");
		String borrowerAddress = scnr.nextLine();
		System.out.println("Enter Borrower Phone");
		String borrowerPhone = scnr.nextLine();
		borrower.setBorrowerName(borrowerName);
		borrower.setBorrowerAddress(borrowerAddress);
		borrower.setBorrowerPhoneNumber(borrowerPhone);
		
		adminstratorDao.AdminAddBorrower(conn, borrowerName, borrowerAddress, borrowerPhone);
		
		System.out.println("Borrower Successfully added");

	}

	public void adminDeleteBorrower(Connection conn) {

		BorrowerService borrowerService = new BorrowerService();
		borrowerService.getAllBorrowers();
		System.out.println();
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Delete Borrower by cardNumber");
		int cardNumber = scnr.nextInt();
		adminstratorDao.AdminDeleteBorrower(conn, cardNumber);
		System.out.println("Borrower Successfully deleted");

	}

	public void adminUpdateBorrower(Connection conn) {

		conn = ConnectDatabase.getConnection();
		BorrowerService borrowerService = new BorrowerService();
		borrowerService.getAllBorrowers();
		System.out.println();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Choose a borrower to update");

		int cardNumber = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter new borrowerName");
		String borrowerName = scnr.nextLine();
		System.out.println("Enter new borrowerAddress");
		String borrowerAdrress = scnr.nextLine();
		System.out.println("Enter new borrowerPhone");
		String borrowerPhone = scnr.nextLine();
		
		adminstratorDao.AdminUpdateBorrower(conn, cardNumber, borrowerName, borrowerAdrress, borrowerPhone);
		System.out.println("Borrower Successfully updated");
	}

}
