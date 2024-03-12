package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    @Test
    void validateReadCsv() {
        // Test case for validating CSV file reading
        String filePath = "src/test/java/sampleFiles/input_file.csv";

        CSVReader csvReaderObj = new CSVReader(new File(filePath));
        List<CreditCardEntry> result = csvReaderObj.readFile(filePath);

        // Get the card number and name from the first entry in the result
        String cardNumber = result.get(0).getCardNumber();
        String name = result.get(0).getNameOfCardholder();

        // Assertions to validate the card number, name, and size of the result list
        Assert.assertEquals(cardNumber, "5567894523129089");
        Assert.assertEquals(name, "John Doe");
        Assert.assertTrue(result.size() == 12);
    }
}
