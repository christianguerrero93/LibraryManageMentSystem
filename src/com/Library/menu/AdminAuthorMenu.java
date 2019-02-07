package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.model.Author;
import com.Library.service.AuthorService;
import com.Library.util.ConnectDatabase;

public class AdminAuthorMenu {

	AdministratorDao adminstratorDao = new AdministratorDao();
	AuthorService authorService = new AuthorService();
    
	public void AuthorMenu() {
		MainMenu mainMenu = new MainMenu();
		Connection conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("1) Add Author");
		System.out.println("2) Delete Author");
		System.out.println("3) Update Author");
		System.out.println("4) Quit to Previous");
		String response = scnr.nextLine();

		do {

			if (response.equals("1")) {

				adminAddAuthor(conn);

			} else if (response.equals("2")) {

				adminDeleteAuthor(conn);

			} else if (response.equals("3")) {

				adminUpdateAuthor(conn);

			} else if (response.equals("4")) {

				mainMenu.displayMainMenu();
			}
		} while (true);
	}

	public void adminAddAuthor(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Author author = new Author();
		AuthorService authorService = new AuthorService();
		authorService.printAuthors();
		System.out.println();
		Scanner scnr = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter authorName");
		String authorName = scnr.nextLine();
		author.setAuthorName(authorName);
		adminstratorDao.AdminAddAuthor(conn, authorName);
		System.out.println("Author Successfully added");

	}

	public void adminDeleteAuthor(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Author author = new Author();
		AuthorService authorService = new AuthorService();
		authorService.printAuthors();
		System.out.println();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Delete author by id");
		int authorId = scnr.nextInt();
		adminstratorDao.AdminDeleteAuthor(conn, authorId);
		System.out.println("Author Successfully deleted");

	}

	public void adminUpdateAuthor(Connection conn) {

		conn = ConnectDatabase.getConnection();
		Author author = new Author();
		AuthorService authorService = new AuthorService();
		authorService.printAuthors();
		System.out.println();
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Choose a Author to update");

		System.out.println("Enter author id");
		int authorId = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter new author name");
		String authorName = scnr.nextLine();
		adminstratorDao.AdminUpdateAuthor(conn, authorName, authorId);
		System.out.println("Author Successfully updated");
	}

}
