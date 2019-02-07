package com.Library.model;

public class BookCopies {

	private Book book;
	private LibraryBranch libraryBranch;
	private int noOfCopies;

	public Book getBookId() {
		return book;
	}

	public void setBookId(Book book) {
		this.book = book;
	}

	public LibraryBranch getBranchId() {
		return libraryBranch;
	}

	public void setBranchId(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}

	public int getNoOfCopies() {
		return noOfCopies;
	}

	public void setNoOfCopies(int noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	@Override
	public String toString() {
		return "BookCopies [ " + book.toString() + ", branchId=" + libraryBranch.toString() + ", noOfCopies=" + noOfCopies + "]";
	}

}
