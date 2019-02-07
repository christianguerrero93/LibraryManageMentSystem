package com.Library.model;

import java.time.LocalDate;

public class BookLoan {

	private Book book;
	private LibraryBranch libraryBranch;
	private Borrower borrower;
	private LocalDate dateOut;
	private LocalDate dueDate;

	public Book getBookId() {
		return book;
	}

	public void setBookId(Book bookid) {
		this.book = bookid;
	}

	public LibraryBranch getBranchId() {
		return libraryBranch;
	}

	public void setBranchId(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}

	public Borrower getCardNumber() {
		return borrower;
	}

	public void setCardNumber(Borrower borrower) {
		this.borrower = borrower;
	}

	public LocalDate getDateOut() {
		return dateOut;
	}

	public void setDateOut(LocalDate dateOut) {
		this.dateOut = dateOut;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate newDueDate) {
		this.dueDate = newDueDate;
	}

	@Override
	public String toString() {
		return "BookLoan [ " + book.toString() + ", branchId=" + libraryBranch.getBranchId() + ", cardNumber=" + borrower.getCardNumber() + ", dateOut="
				+ dateOut + ", dueDate=" + dueDate + "]";
	}

}
