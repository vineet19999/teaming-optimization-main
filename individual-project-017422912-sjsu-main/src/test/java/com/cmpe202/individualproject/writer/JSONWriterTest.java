package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.OutputEntry;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JSONWriterTest {

    @Test
    void validateJSONWrite() {
        // Test case for validating JSON file writing
        String cardNumber = "5410000000000000";
        String cardType = "Master Card";
        JSONWriter jsonWriterObj = new JSONWriter();
        List<OutputEntry> result = new ArrayList<>();
        result.add(new OutputEntry(cardNumber, cardType));

        // Specify the path where the output file will be written
        String path = "src/test/java/sampleFiles/json_output.json";

        // Invoke the JSON writer to write the result to the file
        jsonWriterObj.writeToFile(result, path);

        // Create a File object for the output file
        File file = new File(path);

        // Assertions to validate the existence of the output file and the correctness of card number and card type
        Assert.assertEquals(file.exists(), true);
        Assert.assertEquals(cardNumber, "5410000000000000");
        Assert.assertEquals(cardType, "Master Card");
    }
}
