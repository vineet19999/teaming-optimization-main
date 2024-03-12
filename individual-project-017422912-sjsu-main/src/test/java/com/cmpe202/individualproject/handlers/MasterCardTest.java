package com.cmpe202.individualproject.handlers;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class MasterCardTest {

    @Test
    void checkValidcreditCardMasterCard() {
        // Test case for a valid MasterCard credit card
        String cardNumber = "5410000000000000";
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "Alice";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        MasterCard masterCardObj = new MasterCard();
        String result = masterCardObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "MasterCard");
    }

    @Test
    void checkValidcreditCardMasterCardWithNull() {
        // Test case for a MasterCard credit card with an empty/null card number
        String cardNumber = "";
        String name = "eve";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        MasterCard masterCardObj = new MasterCard();
        String result = masterCardObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "Invalid: empty/null card number");
    }

    @Test
    void checkInValidcreditCardMasterCardLength() {
        // Test case for a MasterCard credit card with more than 19 digits
        String cardNumber = "59012345678901234567890";
        String name = "eve";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        MasterCard masterCardObj = new MasterCard();
        String result = masterCardObj.checkCreditCardType(creditCardEntry);
        Assertions.assertEquals(result, "Invalid: more than 19 digits");
    }

    @Test
    void checkInvalidcreditCardMasterCard() {
        // Test case for an invalid MasterCard credit card
        String cardNumber = "6011000000000000";
        LocalDate expDate = LocalDate.of(2030, 3, 20);
        String name = "Alice";
        CreditCardEntry creditCardEntry = new CreditCardEntry(cardNumber, name);
        MasterCard masterCardObj = new MasterCard();
        String result = masterCardObj.checkCreditCardType(creditCardEntry);
        Assertions.assertNotEquals(result, "MasterCard");
    }

}
