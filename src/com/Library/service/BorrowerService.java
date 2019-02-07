package com.Library.service;

import com.Library.dao.BorrowerDao;
import com.Library.dao.LibraryBranchDao;
import com.Library.model.Borrower;
import com.Library.util.ConnectDatabase;

public class BorrowerService {
	
	BorrowerDao borrowerDao = new BorrowerDao();
	LibraryBranchDao libraryBranchDao = new LibraryBranchDao();
	
	public Borrower getOneBorrowerByCardNumber(int cardNo) {
	
		return borrowerDao.getBorrowerByCardNumber(ConnectDatabase.getConnection(), cardNo);
	}
	
   public int getNumber(int cardNumber) {
	   
	   return borrowerDao.getCardNumber(ConnectDatabase.getConnection(), cardNumber);
	   
   }
   
   public int getBookIdByNumber(int cardNo) {
	   
	   return borrowerDao.getBookIdByCardNumber(ConnectDatabase.getConnection(), cardNo);
   }
   
   public void printBooks() {
	   
	   borrowerDao.showBooksToCheckOut(ConnectDatabase.getConnection());
   }
   
   public int CardNumber() {
	   
	   return borrowerDao.showCardNumber(ConnectDatabase.getConnection());
   }
   
   public Borrower getAllBorrowers() {
	   
	   return borrowerDao.getAllBorrower(ConnectDatabase.getConnection());
   }
 
}
