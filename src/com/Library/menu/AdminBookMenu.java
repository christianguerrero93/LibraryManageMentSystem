package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Publisher;
import com.Library.service.BookService;
import com.Library.util.ConnectDatabase;

public class AdminBookMenu {

	AdministratorDao adminstratorDao = new AdministratorDao();
	

	public void BookMenu(){
		MainMenu mainMenu = new MainMenu();
		Connection conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("1) Add Book");
		System.out.println("2) Update Book");
		System.out.println("3) Delete Book");
		System.out.println("4) Quit to Previous");
		String response = scnr.nextLine();
		
		do {
			
			if(response.equals("1")) {
				
				adminAddBook(conn);
				
			}else if(response.equals("2")) {
				
				adminDeleteBook(conn);
				
			}else if(response.equals("3")) {
				
				adminDeleteBook(conn);
				
			}else if(response.equals("4")) {
				
				mainMenu.displayMainMenu();
			}
		}while(true);
	}

	public void adminAddBook(Connection conn) {

		Book book = new Book();
		Author author = new Author();
		Publisher publisher = new Publisher();
        conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		BookService bookService = new BookService();
		bookService.getAllBooks();
		System.out.println();
		System.out.println("Enter the title");
		String title = scnr.nextLine();
		System.out.println("Enter authorId");
		int authorId = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter publisherId");
		int publisherId = Integer.parseInt(scnr.nextLine());
		book.setTitle(title);
		author.setAuthorId(authorId);
		publisher.setPublisherId(publisherId);
		adminstratorDao.AdminAddBook(conn, title ,authorId, publisherId);
		System.out.println("Book Successfully added");

	}
	
	public void adminDeleteBook(Connection conn) {
		
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		BookService bookService = new BookService();
		bookService.getAllBooks();
		System.out.println();
		System.out.println("Delete book by id");
		int bookId = scnr.nextInt();
		adminstratorDao.AdminDeleteBook(conn, bookId);
		System.out.println("Book Successfully deleted");
		
	}

	public void adminUpdateBook(Connection conn) {
		
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		Book book = new Book();
		Author author = new Author();
		Publisher publisher = new Publisher();
		BookService bookService = new BookService();
		bookService.getAllBooks();
		System.out.println();
		System.out.println("Choose a book to update");
		int bookId = Integer.parseInt(scnr.nextLine());
				
		System.out.println("Enter new title");
		String title = scnr.nextLine();
	    System.out.println("Book Successfully updated");
		adminstratorDao.AdminUpdateBook(conn, title, bookId);
	}

}
