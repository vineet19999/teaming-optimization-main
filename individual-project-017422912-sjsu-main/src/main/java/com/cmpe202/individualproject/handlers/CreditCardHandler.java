package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;

/**
 * The CreditCardHandler interface defines the contract for classes that handle credit card type identification.
 */
public interface CreditCardHandler {
    /**
     * Checks the credit card type for the given CreditCardEntry.
     *
     * @param creditCardEntry The credit card entry to check.
     * @return The credit card type as a string.
     */
    String checkCreditCardType(CreditCardEntry creditCardEntry);
}

