package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BookCopiesDao {

	BookDao bookDao = new BookDao();
	LibraryBranchDao libraryBranchDao = new LibraryBranchDao();

	public int getBranchIdByBookId(Connection conn, int bookId) {
		
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int branchId = 0;
		String sqlQuery = "SELECT branchId FROM library.tbl_book_copies where bookId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				
				branchId = resultSet.getInt("branchId");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return branchId;
	}
	
	public int numberOfCopiesByBookId(Connection conn,int bookId) {
		
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int noOfCopies = 0;
		String sqlQuery = "SELECT noOfCopies FROM library.tbl_book_copies where bookId=?";
		
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, bookId);
			resultSet = prepareStatement.executeQuery();
			
			if(resultSet.next()) {
			    
				noOfCopies = resultSet.getInt("noOfCopies");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return noOfCopies;
	}
	
	public void UpdateNumberOfCopiesOnBranch(Connection conn, int noOfCopies, int bookId) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_book_copies SET noOfCopies = noOfCopies + ? WHERE bookId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, noOfCopies);
			prepareStatement.setInt(2, bookId);
			prepareStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void UpdateNumberOfCopiesWhenReturned(Connection conn, int bookId) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_book_copies SET noOfCopies = noOfCopies + ? WHERE bookId=?";
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
		String sqlQuery = "UPDATE library.tbl_book_copies SET noOfCopies = noOfCopies - ? WHERE bookId=?";
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
