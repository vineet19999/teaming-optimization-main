package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONReaderTest {

    @Test
    void validateReadJson() {
        // Test case for validating JSON file reading
        String filePath = "src/test/java/sampleFiles/input_file.json";

        JSONReader jsonReaderObj = new JSONReader(new File(filePath));
        List<CreditCardEntry> result = jsonReaderObj.readFile(filePath);

        // Get the name and card number from the 12th entry in the result (index 11)
        String name = result.get(11).getNameOfCardholder();
        String cardNumber = result.get(11).getCardNumber();

        // Assertions to validate the name and card number
        Assert.assertEquals(name, "John Doe");
        Assert.assertEquals(cardNumber, "");
    }
}
