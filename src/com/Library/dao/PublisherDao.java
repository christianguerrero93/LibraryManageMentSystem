package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Library.model.Publisher;

public class PublisherDao {

	public Publisher getPublisherById(Connection conn,int publisherId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Publisher publisher= null;
		String sqlQuery = "SELECT * FROM library.tbl_publisher where publisherId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, publisherId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				publisher = new Publisher();
				publisher.setPublisherId(resultSet.getInt("publisherId"));
				publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
				publisher.setPublisherPhone(resultSet.getString("publisherPhone"));
				publisher.setPublisherName(resultSet.getString("publisherName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publisher;
	}
	
	public Publisher getAllPublishers(Connection conn) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Publisher publisher= null;
		String sqlQuery = "SELECT * FROM library.tbl_publisher";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				publisher = new Publisher();
				publisher.setPublisherId(resultSet.getInt("publisherId"));
				publisher.setPublisherAddress(resultSet.getString("publisherAddress"));
				publisher.setPublisherPhone(resultSet.getString("publisherPhone"));
				publisher.setPublisherName(resultSet.getString("publisherName"));
				System.out.println(publisher);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return publisher;
	}

}
