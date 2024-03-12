package com.cmpe202.individualproject.main;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void checkforValidFileType() {
        // Test case for checking a valid file type
        String inputFile = "src/test/java/sampleFiles/inputxmlcopy.xml";
        App appObj = new App();
        String result = appObj.getFileType(inputFile);
        Assert.assertEquals(result, "xml");
    }

    @Test
    void checkforInvalidFileType() {
        // Test case for checking an invalid file type
        String inputFile = "src/test/java/sampleFiles/inputxmlcopy.xml";
        App appObj = new App();
        String result = appObj.getFileType(inputFile);
        Assert.assertNotEquals(result, "json");
    }

}
