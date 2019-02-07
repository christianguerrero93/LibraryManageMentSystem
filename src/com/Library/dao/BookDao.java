package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Library.model.Author;
import com.Library.model.Book;


public class BookDao {

	AuthorDao ado = new AuthorDao();
	PublisherDao pubDao = new PublisherDao();

	public Book getAllBooks(Connection conn) {
 		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Book book = null;
		Author author = new Author();
		String sqlQuery = "SELECT * FROM library.tbl_book";
		try {
			book = new Book();
			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				book = new Book();
				book.setBookId(resultSet.getInt("bookId"));
				book.setTitle(resultSet.getString("title"));
				book.setPublisher(pubDao.getPublisherById(conn, resultSet.getInt("pubId")));
				book.setAuthor(ado.getAuthorById(conn, resultSet.getInt("authId")));
				System.out.println(book);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}
	
	
	public int RetrieveBookId(Connection conn, int bookId) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int bookIdReceived = 0;
		String sqlQuery = "SELECT bookId FROM library.tbl_book_copies WHERE bookId=?";

		try {

			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			resultSet = prepareStatement.executeQuery();

			while (resultSet.next()) {

				bookIdReceived = resultSet.getInt("bookId");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return bookIdReceived;
	}

	
	public void showBooks(Connection conn) {
		
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Book book = null;
	    Author author = null;
		String sqlQuery = "SELECT title, authorName, BC.bookId FROM library.tbl_book_copies AS BC INNER JOIN library.tbl_book AS B ON BC.bookId=B.bookId INNER JOIN library.tbl_author AS A ON B.authId = A.authorId INNER JOIN library.tbl_library_branch AS LB ON LB.branchId = BC.branchId WHERE noOfCopies>=?";

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

}
