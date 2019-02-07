package com.Library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.Library.model.Author;

public class AuthorDao {
	
	public Author getAuthorById(Connection conn, int authorId) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Author author = null;
		String sqlQuery = "SELECT * FROM library.tbl_author where authorId=?";
		try {
			prepareStatement = conn.prepareStatement(sqlQuery);
			prepareStatement.setInt(1, authorId);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				author = new Author();
				author.setAuthorId(resultSet.getInt("authorId"));
				author.setAuthorName(resultSet.getString("authorName"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

	public Author PrintAllAuthors(Connection conn) {
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		Author author = null;
		String sqlQuery = "SELECT * FROM library.tbl_author";
		try {
			author = new Author();
			prepareStatement = conn.prepareStatement(sqlQuery);
			resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				author = new Author();
				author.setAuthorId(resultSet.getInt("authorId"));
				author.setAuthorName(resultSet.getString("authorName"));
				System.out.println(author);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

}
