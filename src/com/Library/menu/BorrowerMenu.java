package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.BorrowerDao;
import com.Library.dao.LibraryBranchDao;
import com.Library.service.BookLoanService;
import com.Library.service.BookService;
import com.Library.service.BorrowerService;
import com.Library.service.LibraryBranchService;
import com.Library.util.ConnectDatabase;

public class BorrowerMenu {

	BorrowerService borrowerService = new BorrowerService();
	LibraryBranchService libraryBranchService = new LibraryBranchService();
	BookLoanService bookLoanService = new BookLoanService();
	BorrowerDao borrowerDao = new BorrowerDao();
	LibraryBranchDao libraryBranchDao = new LibraryBranchDao();
	BookService bookService = new BookService();

	int cardNumberEntered;
	int bookId;
	int branchId;
	int retrieveCardNumber;
	int branchIdRetrieved;
	int bookIdRetrieved;
	int branchIdRetrievedReturn;
	int branchIdReturn;
	int bookIdReturn;
	int bookIdRetrievedReturn;
	
	public void BorrowerMain(Connection conn) {

		MainMenu mainMenu = new MainMenu();
		conn = ConnectDatabase.getConnection();
        boolean flag = true;
		Scanner scnr = new Scanner(System.in);

		System.out.println("Enter your card number:");

		do {
			int cardNo = scnr.nextInt();

			cardNumberEntered = borrowerService.getNumber(cardNo);

			if (cardNo == cardNumberEntered) {

				BorrowerOption1(conn);

			} else {

				System.out.println("Incorrect card number entered try again");

			}
			
			if(flag == false) {
				
				mainMenu.displayMainMenu();
			}

		} while (flag);

	}

	public void BorrowerOption1(Connection conn) {

		conn = ConnectDatabase.getConnection();
        MainMenu mainMenu = new MainMenu();
		System.out.println("1) Check out a book");
		System.out.println("2) Return a book");
		System.out.println("3) Quit to Previous");

		Scanner scnr = new Scanner(System.in);

		do {
			String response = scnr.next();

			if (response.equals("1")) {

				checkOutBook(conn);

			} else if (response.equals("2")) {

				returnBook(conn);

			} else if (response.equals("3")) {

				BorrowerMain(conn);
			}
		} while (true);

	}

	public void checkOutBook(Connection conn) {

		conn = ConnectDatabase.getConnection();
		boolean flag = true;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Choose branch id associated with your location and branchName");
		libraryBranchService.getAllBranches();
		
		do {

			int branchChosen = scnr.nextInt();

			branchId = libraryBranchService.retrieveBranchId(branchChosen);

			if (branchChosen == branchId) {

				branchIdRetrieved = libraryBranchService.retrieveBranchId(branchId);
			}else {
				
				System.out.println("Incorrect branch Id entered try again");
				System.out.println();
				checkOutBook(conn);
			}

			System.out.println("Choose book you would like to checkOut by entering bookId");
			borrowerService.printBooks();

			int bookIdChosen = scnr.nextInt();

			bookId = bookService.getBook(bookIdChosen);

			if (bookIdChosen == bookId) {

				bookIdRetrieved = bookService.getBook(bookId);
			}
			bookLoanService.insertIntoBookLoan(bookIdRetrieved, branchIdRetrieved, cardNumberEntered);

			System.out.println("Successfully Borrowed");
			
			bookLoanService.updateCopiesWhenCheckingOut(bookIdRetrieved);
			
			flag = false;

			if (flag == false) {

				BorrowerOption1(conn);
			}

		} while (flag);

	}

	public void returnBook(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		boolean flag = true;

		libraryBranchService.getAllBranches();

		do {
			
			int branchChosenReturn = scnr.nextInt();

			branchIdRetrievedReturn = libraryBranchService.retrieveBranchId(branchChosenReturn);

			if (branchChosenReturn == branchIdRetrievedReturn) {

				branchIdReturn = libraryBranchService.retrieveBranchId(branchIdRetrievedReturn);

			}else {
				
				System.out.println("Branch Id entered incorrecly try again");
				System.out.println();
				returnBook(conn);
			}

			System.out.println("Choose book you would like to return by entering bookId");
			borrowerService.printBooks();

			int bookIdChosenReturn = scnr.nextInt();

			branchIdReturn = bookService.getBook(bookIdChosenReturn);

			if (bookIdChosenReturn == branchIdReturn) {

				bookIdRetrievedReturn = bookService.getBook(branchIdReturn);
			}

			bookLoanService.returnBook(bookIdRetrievedReturn);
			
			System.out.println("Successfully returned");
			
			bookLoanService.updateCopiesWhenReturn(bookIdRetrievedReturn);
			
			flag = false;

			if (flag == false) {

				BorrowerOption1(conn);
			}
			
		} while (flag);
	}
}
