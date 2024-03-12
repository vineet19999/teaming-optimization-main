package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class DiscoverTest {

    @Test
    void checkInvalidCreditCardDiscover() {
        // Test case for an invalid Discover credit card
        String cardNumber = "341004000000000";
        LocalDate expDate = LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        Discover discoverObj = new Discover();
        String result = discoverObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "Discover");
    }

    @Test
    void testCaseDiscover() {
        // Test case for a Discover credit card
        String cardNumber = "6011134000070000";
        LocalDate expDate = LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        Discover discoverObj = new Discover();
        String result = discoverObj.checkCreditCardType(creditCardEntry);
        Assert.assertEquals(result, "Discover");
    }

    @Test
    void validateInvalidCreditCardDiscover_testCase() {
        // Test case for an invalid Discover credit card
        String cardNumber = "741014000000000";
        LocalDate expDate = LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        Discover discoverObj = new Discover();
        String result = discoverObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "Discover");
    }

    @Test
    void checkValidCreditCardDiscover() {
        // Test case for a valid Discover credit card
        String cardNumber = "6011007000000000";
        LocalDate expDate = LocalDate.of(2030, 6, 20);
        String name = "Richard";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        Discover discoverObj = new Discover();
        String result = discoverObj.checkCreditCardType(creditCardEntry);
        Assert.assertEquals(result, "Discover");
    }
}
