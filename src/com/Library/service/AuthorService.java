package com.Library.service;

import com.Library.dao.AuthorDao;
import com.Library.model.Author;
import com.Library.util.ConnectDatabase;

public class AuthorService {
	
	AuthorDao authorDao =  new AuthorDao();
	
	public Author getAuthor(int authorId) {
		
		return authorDao.getAuthorById(ConnectDatabase.getConnection(), authorId);
	}
	
	public Author printAuthors() {
		
		return authorDao.PrintAllAuthors(ConnectDatabase.getConnection());
	}
	
    
}
