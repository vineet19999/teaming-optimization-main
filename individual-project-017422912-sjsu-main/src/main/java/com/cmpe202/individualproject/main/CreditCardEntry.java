package com.cmpe202.individualproject.main;

import java.util.Date;

public class CreditCardEntry {

	private String cardNumber; // Card number
	private Date expirationDate; // Expiration date of the card
	private String nameOfCardholder; // Name of the cardholder

	// Constructor with card number, expiration date, and cardholder name
	public CreditCardEntry(String cardNumber, Date expirationDate, String nameOfCardholder) {
		this.cardNumber = cardNumber;
		this.expirationDate = expirationDate;
		this.nameOfCardholder = nameOfCardholder;
	}

	// Constructor with card number and cardholder name
	public CreditCardEntry(String cardNumber, String nameOfCardholder) {
		this.cardNumber = cardNumber;
		this.nameOfCardholder = nameOfCardholder;
	}

	// Getter for card number
	public String getCardNumber() {
		return cardNumber;
	}

	// Setter for card number
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	// Getter for expiration date
	public Date getExpirationDate() {
		return expirationDate;
	}

	// Setter for expiration date
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	// Getter for cardholder name
	public String getNameOfCardholder() {
		return nameOfCardholder;
	}

	// Setter for cardholder name
	public void setNameOfCardholder(String nameOfCardholder) {
		this.nameOfCardholder = nameOfCardholder;
	}
}
