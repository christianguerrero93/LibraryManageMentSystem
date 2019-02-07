package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Library.model.LibraryBranch;


public class LibraryBranchDao {
	
	public String getLibraryBranchNameById(Connection conn, int branchId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		LibraryBranch libraryBranch = null;
		String branchName = "";
		String sqlQuery = "SELECT branchName FROM library.tbl_library_branch where branchId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, branchId);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				libraryBranch = new LibraryBranch();
				libraryBranch.setBranchName(resultSet.getString("branchName"));
				branchName = resultSet.getString("branchName");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branchName;
	}
	
	public String getLibraryBranchAddressById(Connection conn, int branchId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		LibraryBranch libraryBranch = null;
		String branchAddress = "";
		String sqlQuery = "SELECT branchAddress FROM library.tbl_library_branch where branchId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, branchId);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				libraryBranch = new LibraryBranch();
				libraryBranch.setBranchName(resultSet.getString("branchAddress"));
				branchAddress = resultSet.getString("branchAddress");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branchAddress;
	}
	
	public LibraryBranch getLibraryBranchById(Connection conn, int branchId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		LibraryBranch libraryBranch = null;
		String sqlQuery = "SELECT * FROM library.tbl_library_branch where branchId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, branchId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				libraryBranch = new LibraryBranch();
				libraryBranch.setBranchId(resultSet.getInt("branchId"));
				libraryBranch.setBranchName(resultSet.getString("branchName"));
				libraryBranch.setBranchAddress(resultSet.getString("branchAddress"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libraryBranch;
	}
	
	public int getLibraryBranchId(Connection conn, int branchId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		LibraryBranch libraryBranch = null;
		int libraryBranchReceived = 0;
		String sqlQuery = "SELECT branchId FROM library.tbl_library_branch WHERE branchId=?";
		try {
			libraryBranch = new LibraryBranch();
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, branchId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				
				libraryBranch = new LibraryBranch();
				libraryBranch.setBranchId(resultSet.getInt("branchId"));
				libraryBranchReceived = resultSet.getInt("branchId");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return libraryBranchReceived;
	}
	
	public void getAllBranches(Connection conn) {
		
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		LibraryBranch libraryBranch = null;
		String sqlQuery = "SELECT * FROM library.tbl_library_branch";

		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();
			
			while (resultSet.next()) {
				
				libraryBranch = new LibraryBranch();
				libraryBranch.setBranchId(resultSet.getInt("branchId"));
				libraryBranch.setBranchName(resultSet.getString("branchName"));
				libraryBranch.setBranchAddress(resultSet.getString("branchAddress"));
				System.out.println("Branch id " + libraryBranch.getBranchId() + ", " + libraryBranch.getBranchName() + ", " + libraryBranch.getBranchAddress());
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void updateLibraryBranchNameByBranchId(Connection conn, int branchId, String branchName) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_library_branch SET branchName=? WHERE branchId=?";
		
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, branchName);
			prepareStatement.setInt(2, branchId);
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {

				System.out.println("Successfully updated");
				
			} else {

				System.out.println("Error has occured");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}
	
	public void updateLibraryBranchAddressByBranchId(Connection conn, int branchId, String branchAddress) {

		PreparedStatement prepareStatement = null;
		String sqlQuery = "UPDATE library.tbl_library_branch SET branchAddress=? WHERE branchId=?";
		
		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setString(1, branchAddress);
			prepareStatement.setInt(2, branchId);
			int result = prepareStatement.executeUpdate();
			
			if (result == 1) {

				System.out.println("Successfully updated");
				
			} else {

				System.out.println("Error has occured");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getBranchId(Connection conn) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		int branchId = 0;
		String sqlQuery = "SELECT branchId FROM library.tbl_book_copies";

		try {

			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {

				branchId = resultSet.getInt("branchId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return branchId;
	}
	
	public int getBranchByBookId(Connection conn, int branchId) {

		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		String sqlQuery = "SELECT bookId FROM library.tbl_book_copies WHERE branchId=?";

		try {
			
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, branchId);
			resultSet = prepareStatement.executeQuery();

			if (resultSet.next()) {

				branchId = resultSet.getInt("branchId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return branchId;
	}
	


}
