package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.Library.model.Book;
import com.Library.model.BookLoan;
import com.Library.service.BookService;
import com.Library.util.ConnectDatabase;

public class BookLoanDao {

	BookDao bookDao = new BookDao();
	LibraryBranchDao libraryBranchDao = new LibraryBranchDao();
	BorrowerDao borrowerDao = new BorrowerDao();

	public void returnBook(Connection conn, int bookId) {
		PreparedStatement prepareStatement = null;
		String sqlQuery = "DELETE FROM library.tbl_book_loans WHERE bookId =?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			prepareStatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void insertIntoBookLoans(Connection conn, int bookId, int branchId, int cardNo) {

		PreparedStatement prepareStatement = null;
		LocalDate dateOut;
		LocalDate dueDate;
		dateOut = LocalDate.now();
		dueDate = dateOut.plusDays(7);

		String sqlQuery = "INSERT INTO library.tbl_book_loans (bookId, branchId, cardNo, dateOut, dueDate) VALUES (?,?,?,?,?)";

		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			prepareStatement.setInt(2, branchId);
			prepareStatement.setInt(3, cardNo);
			prepareStatement.setObject(4, dateOut);
			prepareStatement.setObject(5, dueDate);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void UpdateNumberOfCopiesWhenReturned(Connection conn, int bookId) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_book_copies SET noOfCopies = noOfCopies + ? WHERE bookId=? AND noOfCopies >= 1";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, 1);
			prepareStatement.setInt(2, bookId);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void UpdateNumberOfCopiesWhenCheckOut(Connection conn, int bookId) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_book_copies SET noOfCopies = noOfCopies - ? WHERE bookId=? AND noOfCopies >= 1";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, 1);
			prepareStatement.setInt(2, bookId);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
