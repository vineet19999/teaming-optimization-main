package com.cmpe202.individualproject.main;
public class OutputEntry {
    String cardNumber;
    String type;

    /**
     * Default constructor for OutputEntry class.
     */
    public OutputEntry() {
    }

    /**
     * Constructor for creating an OutputEntry object with card number and type.
     *
     * @param cardNumber The card number.
     * @param type       The type of the card.
     */
    public OutputEntry(String cardNumber, String type) {
        this.cardNumber = cardNumber;
        this.type = type;
    }

    /**
     * Retrieves the card number.
     *
     * @return The card number.
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the card number.
     *
     * @param cardNumber The card number to set.
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    /**
     * Retrieves the card type.
     *
     * @return The card type.
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the card type.
     *
     * @param type The card type to set.
     */
    public void setType(String type) {
        this.type = type;
    }
}
