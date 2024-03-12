package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;

public class Amex implements CreditCardHandler {
    CreditCardHandler nextHandler;

    /**
     * Default constructor for the Amex class.
     * It sets the next handler in the chain to Discover.
     */
    public Amex() {
        nextHandler = new Discover();
    }

    /**
     * Checks the credit card type for an American Express card.
     * If the card number matches the pattern, it returns "AmericanExpress".
     * Otherwise, it delegates the request to the next handler in the chain.
     *
     * @param creditCardEntry The credit card entry to check.
     * @return The credit card type, or delegates to the next handler.
     */
    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {
        String number = creditCardEntry.getCardNumber();
        String result = "";
        String fDigit = number.substring(0, 1);
        int sDigit = Integer.parseInt(number.substring(1, 2));

        System.out.println(number + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Amex");

        if (fDigit.equals("3") && number.length() == 15 && (sDigit == 4 || sDigit == 7)) {
            result = "AmericanExpress";
        } else {
            return nextHandler.checkCreditCardType(creditCardEntry);
        }

        return result;
    }
}
