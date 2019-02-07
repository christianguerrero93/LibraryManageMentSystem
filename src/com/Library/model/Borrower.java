package com.Library.model;

public class Borrower {

	private int cardNumber;
	private String BorrowerName;
	private String BorrowerAddress;
	private String BorrowerPhoneNumber;

	public int getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getBorrowerName() {
		return BorrowerName;
	}

	public void setBorrowerName(String borrowerName) {
		BorrowerName = borrowerName;
	}

	public String getBorrowerAddress() {
		return BorrowerAddress;
	}

	public void setBorrowerAddress(String borrowerAddress) {
		BorrowerAddress = borrowerAddress;
	}

	public String getBorrowerPhoneNumber() {
		return BorrowerPhoneNumber;
	}

	public void setBorrowerPhoneNumber(String borrowerPhoneNumber) {
		BorrowerPhoneNumber = borrowerPhoneNumber;
	}

	@Override
	public String toString() {
		return "Borrower [cardNumber=" + cardNumber + ", BorrowerName=" + BorrowerName + ", BorrowerAddress="
				+ BorrowerAddress + ", BorrowerPhoneNumber=" + BorrowerPhoneNumber + "]";
	}
	
}
