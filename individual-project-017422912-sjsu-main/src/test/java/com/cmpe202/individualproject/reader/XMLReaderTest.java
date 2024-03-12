package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLReaderTest {

    @Test
    void validateReadXml() {
        // Test case for validating XML file reading
        XMLReader xmlReaderObj = new XMLReader();
        String filePath = "src/test/java/sampleFiles/input_file.xml";
        List<CreditCardEntry> result = xmlReaderObj.readFile(filePath);

        // Get the name and card number from the first entry in the result (index 0)
        String name = result.get(0).getNameOfCardholder();
        String cardNumber = result.get(0).getCardNumber();

        // Assertions to validate the name, result size, and card number
        Assert.assertEquals(name, "John DoE");
        Assert.assertTrue(result.size() == 12);
        Assert.assertEquals(cardNumber, "5567894523129089");
    }
}
