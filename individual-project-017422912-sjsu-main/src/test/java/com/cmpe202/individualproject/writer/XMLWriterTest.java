package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.OutputEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class XMLWriterTest {

    @Test
    void validateXMLWrite() {
        // Test case for validating XML file writing
        String cardNumber = "5410000000000000";
        String cardType = "Master Card";
        XMLWriter xmlWriterObj = new XMLWriter();
        List<OutputEntry> result = new ArrayList<>();
        result.add(new OutputEntry(cardNumber, cardType));

        // Specify the path where the output file will be written
        String path = "src/test/java/sampleFiles/json_output.json";

        // Invoke the XML writer to write the result to the file
        xmlWriterObj.writeToFile(result, path);

        // Create a File object for the output file
        File file = new File(path);

        // Assertions to validate the existence of the output file and the correctness of card number and card type
        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals(cardNumber, "5410000000000000");
        Assert.assertEquals(cardType, "Master Card");
    }

    @Test
    void validateXMLWriteFailure() {
        // Test case for validating XML file writing failure
        String cardNumber = "5410060000000000";
        String cardType = "Master Card";
        XMLWriter xmlWriterObj = new XMLWriter();
        List<OutputEntry> result = new ArrayList<>();
        result.add(new OutputEntry(cardNumber, cardType));

        // Specify the path where the output file will be written
        String path = "src/test/java/sampleFiles/json_output.json";

        // Invoke the XML writer to write the result to the file
        xmlWriterObj.writeToFile(result, path);

        // Create a File object for the output file
        File file = new File(path);

        // Assertions to validate the existence of the output file and the correctness of card number and card type
        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals(cardNumber, "5410060000000000");
        Assert.assertEquals(cardType, "Master Card");
    }


    @Test
    void validateXMLWriteFailure_1() {
        // Test case for validating XML file writing failure
        String cardNumber = "6410060000000000";
        String cardType = "Master Card";
        XMLWriter xmlWriterObj = new XMLWriter();
        List<OutputEntry> result = new ArrayList<>();
        result.add(new OutputEntry(cardNumber, cardType));

        // Specify the path where the output file will be written
        String path = "src/test/java/sampleFiles/json_output.json";

        // Invoke the XML writer to write the result to the file
        xmlWriterObj.writeToFile(result, path);

        // Create a File object for the output file
        File file = new File(path);

        // Assertions to validate the existence of the output file and the correctness of card number and card type
        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals(cardNumber, "6410060000000000");
        Assert.assertEquals(cardType, "Master Card");
    }

}
