package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Publisher;
import com.Library.service.BookService;
import com.Library.util.ConnectDatabase;

public class AdminMenu {
	
	AdministratorDao adminDao = new AdministratorDao();
	AdminBookMenu adminBookMenu = new AdminBookMenu();
	AdminBorrowerMenu adminBorrowerMenu = new AdminBorrowerMenu();
	AdminLibraryBranchMenu adminLibraryBranchMenu = new AdminLibraryBranchMenu();
	AdminPublisherMenu adminPublisherMenu = new AdminPublisherMenu();
	AdminAuthorMenu adminAuthorMenu = new AdminAuthorMenu();
	AdminBookLoansMenu adminBookLoansMenu = new AdminBookLoansMenu();
	MainMenu mainMenu = new MainMenu();
	
	public void adminMenu(Connection conn) {
		
	 conn = ConnectDatabase.getConnection();
		
		System.out.println("1) Add/Update/Delete Book");
		System.out.println("2) Add/Update/Delete Author");
		System.out.println("3) Add/Update/Delete Publishers");
		System.out.println("4) Add/Update/Delete Library Branches");
		System.out.println("5) Add/Update/Delete Borrowers");
		System.out.println("6) Over-ride Due Date for a Book Loan");
		System.out.println("7) Quit to previous");
		
		do {
		Scanner scnr = new Scanner(System.in);
		String response = scnr.next();
		
		if(response.equals("1")) {
			
			adminBookMenu.BookMenu();
		}else if(response.equals("2")) {
			
			adminAuthorMenu.AuthorMenu();
		}else if(response.equals("3")) {
			
			adminPublisherMenu.PublisherMenu();
		}else if(response.equals("4")) {
			
			adminLibraryBranchMenu.LibraryBranchMenu();
		}else if(response.equals("5")) {
			
			adminBorrowerMenu.BorrowerMenu();
		}else if(response.equalsIgnoreCase("6")) {
			
			adminBookLoansMenu.overrideDueDate(conn);
		}else if(response.equalsIgnoreCase("7")) {
			
			return;
		}
		
		}while(true);
	
	}
	
}
