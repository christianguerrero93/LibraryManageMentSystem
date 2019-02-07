package com.Library.service;

import com.Library.dao.BookCopiesDao;
import com.Library.dao.BookDao;
import com.Library.model.BookCopies;
import com.Library.util.ConnectDatabase;

public class BookCopiesService {

	BookCopiesDao bookCopiesDao = new BookCopiesDao();
	BookCopies bookCopies = new BookCopies();
    BookDao bookDao = new BookDao();
    
	public int getBranchId(int bookId) {

		return bookCopiesDao.getBranchIdByBookId(ConnectDatabase.getConnection(), bookId);

	}

	public int getNumberOfCopies(int bookId) {

		return bookCopiesDao.numberOfCopiesByBookId(ConnectDatabase.getConnection(), bookId);
	}

	public void UpdateBranchByNewNumberOfCopies(int noOfCopies, int branchId) {
		
		bookCopiesDao.UpdateNumberOfCopiesOnBranch(ConnectDatabase.getConnection(), noOfCopies, branchId);
	}

}
