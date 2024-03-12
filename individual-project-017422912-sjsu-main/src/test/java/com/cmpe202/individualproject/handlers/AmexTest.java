package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.Date;

class AmexTest {

    @Test
    void checkValidCreditCardAmex() {
        // Test case for a valid Amex credit card
        String cardNumber = "341000000000000";
        String name = "eve";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        Amex amexObj = new Amex();
        String result = amexObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "AmericanExpress");
    }

    @Test
    void checkInvalidCreditCardAmex() {
        // Test case for an invalid Amex credit card
        String cardNumber = "6011000000000000";
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "eve";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        Amex amexObj = new Amex();
        String result = amexObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "AmericanExpress");
    }

}
