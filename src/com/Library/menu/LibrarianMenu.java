package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.service.BookCopiesService;
import com.Library.service.BookService;
import com.Library.service.LibraryBranchService;
import com.Library.util.ConnectDatabase;

public class LibrarianMenu {

	LibraryBranchService libraryBranchService = new LibraryBranchService();
	int branchId;
	int branchIdRetrieved;

	public void LibrarianMenu1() {
		
		MainMenu mainMenu = new MainMenu();

		Connection conn = ConnectDatabase.getConnection();
		System.out.println("1) Enter Branch you manage");
		System.out.println("2) Quit to previous");

		Scanner scnr = new Scanner(System.in);

		do {

			String input = scnr.next();

			if (input.equals("1")) {

				LibrarianMenu2(conn);

			} else if (input.equals("2")) {

				mainMenu.displayMainMenu();
			}

		} while (true);
	}

	public void LibrarianMenu2(Connection conn) {

		conn = ConnectDatabase.getConnection();
		boolean flag = true;
		System.out.println("Choose branch you are in charge of by its associated branch id and branch name/location");
		libraryBranchService.getAllBranches();
		Scanner scnr = new Scanner(System.in);

		do {

			int branchChosen = scnr.nextInt();

			branchId = libraryBranchService.retrieveBranchId(branchChosen);

			if (branchChosen == branchId) {

				branchIdRetrieved = libraryBranchService.retrieveBranchId(branchId);
				
			}else if (branchChosen != branchId){
				
				System.out.println("BranchId not correct try again");
				System.out.println();
				
			}
			
			flag = false;

			if (flag == false) {

				LibrarianMenu3(conn);
			}

		} while (flag);
	}

	public void LibrarianMenu3(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("1) Update the details of the of the library");
		System.out.println("2) Add copies of Book to the Branch");
		System.out.println("3) Quit to previous");

		do {

			String input = scnr.next();

			if (input.equals("1")) {

				LibrarinMenuOption1();

			} else if (input.equals("2")) {

				LibrarianMenuOption2(conn);
			} else if (input.equals("3")) {

				LibrarianMenu2(conn);
			}

		} while (true);
	}

	public void LibrarinMenuOption1() {

		LibraryBranchService librarianBranchService = new LibraryBranchService();
		Connection conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		boolean flag = true;
		String branchAddress;
		String branchName;

		do {

			System.out.println("You have chosen to update the branch with branch id: " + branchIdRetrieved
					+ " and branch name " + librarianBranchService.getBranchName(branchIdRetrieved)
					+ " and branch address " + librarianBranchService.getBranchAddress(branchIdRetrieved));

			System.out.println("Please enter new branch name or enter N/A for no change:");
			branchName = scnr.nextLine();

			System.out.println("Please enter new branch address or enter N/A for no change:");
			branchAddress = scnr.nextLine();

			if (!branchName.equalsIgnoreCase("N/A")) {

				librarianBranchService.updateLibraryBranchName(branchIdRetrieved, branchName);
			}

			if (!branchAddress.equalsIgnoreCase("N/A")) {

				librarianBranchService.getBranchAddress(branchIdRetrieved, branchAddress);

			}

			flag = false;

			if (flag == false) {

				LibrarianMenu3(conn);
			}

		} while (flag);

	}

	public void LibrarianMenuOption2(Connection conn) {

		BookService bookService = new BookService();
		BookCopiesService bookCopiesService = new BookCopiesService();
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		int bookId;
		int bookIdEntered;
		int bookIdRetrieved = 0;
		boolean flag = true;
		System.out.println("Pick the book you want to add copies of to your branch by bookId:");
		bookService.showBooksToAddCopies();

		do {

			bookId = scnr.nextInt();
			
			bookIdEntered = bookCopiesService.getBranchId(bookId);
			
			if(bookId == bookIdEntered) {
				
				bookIdRetrieved = bookCopiesService.getBranchId(bookIdEntered);	
				
			}else {
				
				System.out.println("BookId incorrect try again");
				LibrarianMenuOption2(conn);
				
			}
			
			int noOfCopies = bookCopiesService.getNumberOfCopies(bookIdRetrieved);
			
			System.out.print("Existing number of copies:" + noOfCopies);
			int newNumOfCopies;
			System.out.println();
			System.out.print("Enter new number of copies:");
			newNumOfCopies = scnr.nextInt();
			
			bookCopiesService.UpdateBranchByNewNumberOfCopies(newNumOfCopies, bookIdRetrieved);
			
			System.out.println("Number of copies successfully updated");
			System.out.println();
			
			flag = false;
			
			if(flag == false) {
				
				LibrarianMenu3(conn);
			}

		} while (flag);

	}
}
