package com.Library.menu;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.model.BookLoan;
import com.Library.util.ConnectDatabase;

public class AdminBookLoansMenu {
	
  AdministratorDao administratorDao = new AdministratorDao();
  
	public void bookLoan() {
		
		MainMenu mainMenu = new MainMenu();
		Connection conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("1) Over-ride Due Date for a Book Loan");
		System.out.println("2) Quit to Previous");
		String response = scnr.next();
		
		if(response.equals("1")) {
			
			overrideDueDate(conn);
			
		}else if(response.equals("2")) {
			
			mainMenu.displayMainMenu();
		}
	}
	
	public void overrideDueDate(Connection conn) {
		
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		conn = ConnectDatabase.getConnection();
		System.out.println("Enter CardNo");
		int cardNo = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter branch id");
		int branchId = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter bookId");
		int bookId = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter new Date to OverRide in this format year-month-day");
		String newDueDate = scnr.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");
		LocalDate date = LocalDate.parse(newDueDate, formatter);
		administratorDao.AdminOverrideDueDate(conn, date, bookId, branchId, cardNo);
		System.out.println("Successfully Overriding");
		
		
		
	}
}
