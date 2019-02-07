package com.Library.service;

import com.Library.dao.BookDao;
import com.Library.model.Book;
import com.Library.util.ConnectDatabase;

public class BookService {

	BookDao bdao = new BookDao();
	
	public Book getAllBooks() {
		
		return bdao.getAllBooks(ConnectDatabase.getConnection());
	}
	
	public int getBook(int bookId) {
		
		return bdao.RetrieveBookId(ConnectDatabase.getConnection(), bookId);
	}
	
	public void showBooksToAddCopies() {
		
		bdao.showBooks(ConnectDatabase.getConnection());
	}
	

}
