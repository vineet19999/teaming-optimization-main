package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;

public class Visa implements CreditCardHandler {
    CreditCardHandler nextHandler;

    public Visa() {
        nextHandler = new Amex();
    }

    @Override
    public String checkCreditCardType(CreditCardEntry creditCardEntry) {
        // Get the credit card number from the CreditCardEntry
        String a = creditCardEntry.getCardNumber();
        String number = a.toString();
        String result = "";
        String fDigit = number.substring(0, 1);

        System.out.println(a + " ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ Visa");

        // Check various conditions to determine the credit card type
        if (a.length() > 19) {
            return "Invalid: more than 19 digits";
        } else if (a.length() == 0) {
            return "Invalid: empty/null card number";
        } else if (fDigit.equals("4") && (number.length() == 13 || number.length() == 16)) {
            // Check if the credit card number starts with '4' and has a length of either 13 or 16
            // to determine it as a Visa card
            result = "Visa";
        } else {
            // If the conditions are not met, delegate to the next credit card handler
            return nextHandler.checkCreditCardType(creditCardEntry);
        }
        return result;
    }
}
