package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Library.model.Author;
import com.Library.model.Book;
import com.Library.model.Borrower;

public class BorrowerDao {

	public Borrower getBorrowerByCardNumber(Connection conn, int cardNo) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Borrower borrower = null;
		String sqlQuery = "SELECT * FROM library.tbl_borrower where cardNo=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, cardNo);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				borrower = new Borrower();
				borrower.setCardNumber(resultSet.getInt("cardNo"));
				borrower.setBorrowerName(resultSet.getString("name"));
				borrower.setBorrowerAddress(resultSet.getString("address"));
				borrower.setBorrowerPhoneNumber(resultSet.getString("phone"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrower;
	}
	
	public Borrower getAllBorrower(Connection conn) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Borrower borrower = null;
		String sqlQuery = "SELECT * FROM library.tbl_borrower";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				borrower = new Borrower();
				borrower.setCardNumber(resultSet.getInt("cardNo"));
				borrower.setBorrowerName(resultSet.getString("name"));
				borrower.setBorrowerAddress(resultSet.getString("address"));
				borrower.setBorrowerPhoneNumber(resultSet.getString("phone"));
				System.out.println(borrower);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return borrower;
	}

	public int getCardNumber(Connection conn, int cardNumber) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Borrower borrower = null;
		int cardNumberReceived = 0;
		String sqlQuery = "SELECT cardNo FROM library.tbl_borrower WHERE cardNo = ?";

		try {
            
			borrower = new Borrower();
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, cardNumber);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
                
				borrower.setCardNumber(resultSet.getInt("cardNo"));
				cardNumberReceived = resultSet.getInt("cardNo");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cardNumberReceived;
	}
	
	public int showCardNumber(Connection conn) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int cardNumber = 0;
		String sqlQuery = "SELECT cardNo FROM library.tbl_borrower";

		try {

			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {

				cardNumber = resultSet.getInt("cardNo");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cardNumber;
	}

	public int getBookIdByCardNumber(Connection conn, int cardNo) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String sqlQuery = "SELECT bookId FROM library.tbl_book_loans as BL INNER JOIN library.tbl_borrower as B ON BL.cardNo = B.cardNo WHERE B.cardNo = ?";
		int bookId = 0;
		try {

			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, cardNo);
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {

				bookId = resultSet.getInt("bookId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookId;
	}

	public void showBooksToCheckOut(Connection conn) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Book book = null;
	    Author author = null;
	    String sqlQuery = "SELECT title, authorName, BC.bookId FROM library.tbl_book_copies AS BC INNER JOIN library.tbl_book AS B ON BC.bookId=B.bookId INNER JOIN library.tbl_author AS A ON B.authId = A.authorId WHERE noOfCopies >=?";

		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, 1);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {
				book = new Book();
				author = new Author();
				book.setTitle(resultSet.getString("title"));
				author.setAuthorName(resultSet.getString("authorName"));
				book.setBookId(resultSet.getInt("bookId"));
				System.out.println(book.getTitle() + ", " + author.getAuthorName() + ", " + "book id "+ book.getBookId());
				

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Book getBookLoansByBookId(Connection conn, int bookId) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Book book = null;
		String sqlQuery = "SELECT bookId FROM library.tbl_book_loans where bookId=?";
		try {
		    
			book = new Book();
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				
			    bookId = resultSet.getInt("bookId");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

}
