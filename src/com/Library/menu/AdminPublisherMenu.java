package com.Library.menu;

import java.sql.Connection;
import java.util.Scanner;

import com.Library.dao.AdministratorDao;
import com.Library.model.Author;
import com.Library.service.AuthorService;
import com.Library.service.PublisherService;
import com.Library.util.ConnectDatabase;

public class AdminPublisherMenu {

	AdministratorDao adminstratorDao = new AdministratorDao();
	

	public void PublisherMenu() {
		MainMenu mainMenu = new MainMenu();
		Connection conn =  ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("1) Add Publisher");
		System.out.println("2) Delete Publisher");
		System.out.println("3) Update Publisher");
		System.out.println("4) Quit to Previous");
		String response = scnr.next();

		do {

			if (response.equals("1")) {

				adminAddPublisher(conn);

			} else if (response.equals("2")) {

				adminDeletePublisher(conn);

			} else if (response.equals("3")) {

				adminUpdatePublisher(conn);

			} else if (response.equalsIgnoreCase("4")) {

				mainMenu.displayMainMenu();;
			}
		} while (true);
	}

	public void adminAddPublisher(Connection conn) {

		conn = ConnectDatabase.getConnection();
		PublisherService publisherService = new PublisherService();
		publisherService.getAllPublisher();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Enter Publisher Name");
		String publisherName = scnr.nextLine();
		System.out.println("Enter Publisher Address");
		String publisherAddress = scnr.nextLine();
		System.out.println("Enter Publisher Phone");
		String publisherPhone = scnr.nextLine();

		adminstratorDao.AdminAddPublisher(conn, publisherName, publisherAddress, publisherPhone);
		System.out.println("Publisher Successfully added");

	}

	public void adminDeletePublisher(Connection conn) {

		PublisherService publisherService = new PublisherService();
		publisherService.getAllPublisher();
		conn = ConnectDatabase.getConnection();
		Scanner scnr = new Scanner(System.in);
		System.out.println("Delete publisher by id");
		int publisherId = scnr.nextInt();
		adminstratorDao.AdminDeletePublisher(conn, publisherId);
		System.out.println("Publisher Successfully deleted");

	}

	public void adminUpdatePublisher(Connection conn) {

		conn = ConnectDatabase.getConnection();
		PublisherService publisherService = new PublisherService();
		publisherService.getAllPublisher();

		Scanner scnr = new Scanner(System.in);
		System.out.println("Choose a Publisher to update");

		System.out.println("Enter Publisher id");
		int publisherId = Integer.parseInt(scnr.nextLine());
		System.out.println("Enter new Publisher name");
		String publisherName = scnr.nextLine();
		System.out.println("Enter new Publisher address");
		String publisherAddress = scnr.nextLine();
		System.out.println("Enter new Publisher phone");
		String publisherPhone = scnr.nextLine();

		adminstratorDao.AdminUpdatePublisher(conn, publisherName, publisherAddress, publisherPhone, publisherId);
		System.out.println("Publisher Successfully updated");
	}

}
