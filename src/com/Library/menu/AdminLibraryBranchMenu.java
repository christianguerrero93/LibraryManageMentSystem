package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.service.LibraryBranchService;
import com.Library.service.PublisherService;
import com.Library.util.ConnectDatabase;

public class AdminLibraryBranchMenu {

	AdministratorDao adminstratorDao = new AdministratorDao();

	public void LibraryBranchMenu() {
	    MainMenu mainMenu = new MainMenu();
		Connection conn = ConnectDatabase.getConnection();
		System.out.println("1) Add LibraryBranch");
		System.out.println("2) Delete LibraryBranch");
		System.out.println("3) Update LibraryBranch");
		System.out.println("4) Quit to Previous");

		Scanner scnr = new Scanner(System.in);
		String response = scnr.next();
		do {

			if (response.equals("1")) {

				adminAddLibraryBranch(conn);

			} else if (response.equals("2")) {

				adminDeleteLibraryBranch(conn);

			} else if (response.equals("3")) {

				adminAddLibraryBranch(conn);

			} else if (response.equals("4")) {

				mainMenu.displayMainMenu();
			}
		} while (true);
	}

	public void adminAddLibraryBranch(Connection conn) {

		conn = ConnectDatabase.getConnection();
		LibraryBranchService libraryBranchService = new LibraryBranchService();
		libraryBranchService.getAllBranches();
		System.out.println();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter LibraryBranch Name");
		String LibraryBranchName = scnr.nextLine();
		System.out.println("Enter LibraryBranch Address");
		String LibraryBranchAddress = scnr.nextLine();

		adminstratorDao.AdminAddLibraryBranch(conn, LibraryBranchName, LibraryBranchAddress);

		System.out.println("LibraryBranch Successfully added");

	}

	public void adminDeleteLibraryBranch(Connection conn) {

		LibraryBranchService libraryBranchService = new LibraryBranchService();
		libraryBranchService.getAllBranches();
		System.out.println();
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Delete LibraryBranch by id");
		int LibraryBranchId = scnr.nextInt();
		adminstratorDao.AdminDeleteLibraryBranch(conn, LibraryBranchId);
		System.out.println("LibraryBranch Successfully deleted");

	}

	public void adminUpdateLibraryBranch(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		LibraryBranchService libraryBranchService = new LibraryBranchService();
		libraryBranchService.getAllBranches();
		System.out.println();
		System.out.println("Enter LibraryBranch Id");
		int branchId = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter new LibraryBranch Name");
		String branchName = scnr.nextLine();
		System.out.println("Enter new LibraryBranch Address");
		String branchAddress = scnr.nextLine();
		
        adminstratorDao.AdminUpdateLibraryBranch(conn, branchName, branchAddress, branchId);
	
		System.out.println("LibraryBranch Successfully updated");
	}

}
