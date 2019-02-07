package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.util.ConnectDatabase;

public class MainMenu {
	

	BorrowerMenu borrowerMenu = new BorrowerMenu();
	LibrarianMenu librarianMenu = new LibrarianMenu();
	

	public void displayMainMenu() {
		AdminMenu adminMenu = new AdminMenu();
		Connection conn = ConnectDatabase.getConnection();

		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println("Welcome to the GCIT Library Management System. Which Category of a user are you");
			System.out.println("1) Librarian");
			System.out.println("2) Administrator");
			System.out.println("3) Borrower");

			String input = scanner.nextLine();
			
			
			if (input.equals("1")) {
				
				librarianMenu.LibrarianMenu1();
				
				
			}else if(input.equals("2")){
				
			adminMenu.adminMenu(conn);
				
			}else {
				
				borrowerMenu.BorrowerMain(conn);
			}
			
		}while(true);
	}


}
