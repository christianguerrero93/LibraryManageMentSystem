package com.Library.service;



import com.Library.dao.BookLoanDao;
import com.Library.util.ConnectDatabase;

public class BookLoanService {

	BookLoanDao bookLoanDao = new BookLoanDao();
	
	
	public void returnBook(int bookId) {
		
		bookLoanDao.returnBook(ConnectDatabase.getConnection(), bookId);
	}
	
	public void updateBookLoanOnReturn(int bookId) {
		
		bookLoanDao.UpdateNumberOfCopiesWhenReturned(ConnectDatabase.getConnection(), bookId);
	}
	
	public void updateBookLoanedOnCheckOut(int bookId) {
		
		bookLoanDao.UpdateNumberOfCopiesWhenCheckOut(ConnectDatabase.getConnection(), bookId);
	}
	
	public void insertIntoBookLoan(int bookId, int branchId, int cardNo) {
		
		bookLoanDao.insertIntoBookLoans(ConnectDatabase.getConnection(), bookId, branchId, cardNo);
	}
	
	public void updateCopiesWhenReturn(int bookId) {
		
		bookLoanDao.UpdateNumberOfCopiesWhenReturned(ConnectDatabase.getConnection(), bookId);
	}
	
	public void updateCopiesWhenCheckingOut(int bookId) {
		
		bookLoanDao.UpdateNumberOfCopiesWhenCheckOut(ConnectDatabase.getConnection(), bookId);
	}

}
