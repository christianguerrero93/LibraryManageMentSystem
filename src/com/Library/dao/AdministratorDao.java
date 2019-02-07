package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.BookLoan;
import com.Library.model.Borrower;
import com.Library.model.LibraryBranch;
import com.Library.model.Publisher;

public class AdministratorDao {
	
	public void AdminAddBook(Connection conn, String title, int authorId, int publisherId) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "INSERT INTO library.tbl_book (title, authId, pubId) VALUES (?, ?, ?)";
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, title);
			prepareStatement.setInt(2, authorId);
			prepareStatement.setInt(3, publisherId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminDeleteBook(Connection conn, int bookId) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "DELETE FROM library.tbl_book where bookId=?";
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminUpdateBook(Connection conn, String title, int bookId) {

		PreparedStatement prepareStatement = null;
		Book book = null;
		Author author = null;
		Publisher publisher = null;
		String sqlQuery = "UPDATE library.tbl_book SET title=? WHERE bookId=?";
		try {
			 book = new Book();
			 author = new Author();
			 publisher = new Publisher();
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, title);
			prepareStatement.setInt(2, bookId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminAddAuthor(Connection conn, String authorName) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "INSERT INTO library.tbl_author (authorName) VALUES (?)";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, authorName);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminDeleteAuthor(Connection conn, int authorId) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "DELETE FROM library.tbl_author where authorId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, authorId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminUpdateAuthor(Connection conn, String authorName, int authorId ) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_author SET authorName=? WHERE authorId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, authorName);
			prepareStatement.setInt(2, authorId);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminAddPublisher(Connection conn, String publisherName, String publisherAddress, String publisherPhone) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "INSERT INTO library.tbl_publisher (publisherName, publisherAddress, publisherPhone) VALUES (?, ?, ?)";
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, publisherName);
			prepareStatement.setString(2, publisherAddress);
			prepareStatement.setString(3, publisherPhone);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminDeletePublisher(Connection conn, int publisherId) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "DELETE FROM library.tbl_publisher where publisherId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, publisherId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminUpdatePublisher(Connection conn, String publisherName, String publisherAddress, String publisherPhone, int publisherId) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_publisher SET publisherName=?, publisherAddress=?,publisherPhone=? WHERE publisherId=?";
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, publisherName);
			prepareStatement.setString(2, publisherAddress);
			prepareStatement.setString(3, publisherPhone);
			prepareStatement.setInt(4, publisherId);

			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminAddLibraryBranch(Connection conn, String branchName, String branchAddress) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "Insert INTO library.tbl_library_branch (branchName, branchAddress) VALUES (?,?)";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, branchName);
			prepareStatement.setString(2, branchAddress);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminDeleteLibraryBranch(Connection conn, int branchId) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "DELETE FROM library.tbl_library_branch where branchId=?";
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, branchId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminUpdateLibraryBranch(Connection conn, String branchName, String branchAddress, int branchId) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_library_branch SET branchName=?, branchAddress=? WHERE branchId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, branchName);
			prepareStatement.setString(2, branchAddress);
			prepareStatement.setInt(3, branchId);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminAddBorrower(Connection conn, String name, String address, String phone) {
		PreparedStatement prepareStatement = null;
		Borrower borrower = null;
		String sqlQuery = "INSERT INTO library.tbl_borrower (name, address, phone) VALUES (?, ?, ?)";
		try {
			borrower = new Borrower();
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, name);
			prepareStatement.setString(2, address);
			prepareStatement.setString(3, phone);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminDeleteBorrower(Connection conn, int cardNumber) {
		
		PreparedStatement prepareStatement = null;
		String sqlQuery = "DELETE FROM library.tbl_borrower where cardNo=?";
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, cardNumber);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminUpdateBorrower(Connection conn, int cardNumber, String name, String address, String phone) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_borrower SET cardNo = ?,name=?, address=?, phone=? WHERE cardNo=?";
		try {

			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, cardNumber);
			prepareStatement.setString(2,name);
			prepareStatement.setString(3, address);
			prepareStatement.setString(4, phone);
			prepareStatement.setInt(5, cardNumber);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void AdminOverrideDueDate(Connection conn, LocalDate date, int bookId, int branchId, int cardNumber) {

		PreparedStatement prepareStatement = null;
		BookLoan bookLoan = new BookLoan();
		String sqlQuery = "UPDATE library.tbl_book_loans SET dueDate=? WHERE bookId=? AND branchId=? AND cardNo=? ";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setObject(1,date);
			prepareStatement.setInt(2, bookId);
			prepareStatement.setInt(3, branchId);
			prepareStatement.setInt(4, cardNumber);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


}
