package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.handlers.CreditCardHandler;
import com.cmpe202.individualproject.handlers.MasterCard;
import com.cmpe202.individualproject.main.CreditCardEntry;
import com.cmpe202.individualproject.main.OutputEntry;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JSONWriter implements Writer {
    File outputFile;

    public JSONWriter() {
    }

    @Override
    public void writeToFile(List<OutputEntry> result, String outputFile) {
        FileWriter fileWriter;
        int resultSize = result.size();
        int counter = 0;
        try {
            fileWriter = new FileWriter(outputFile);

            // Start writing the JSON object
            fileWriter.write("{\n");
            fileWriter.write('"');
            fileWriter.write("cards");
            fileWriter.write('"');
            fileWriter.write(":[");

            // Iterate over the list of OutputEntry objects
            for (OutputEntry each : result) {
                fileWriter.write("\n");
                fileWriter.write("{");
                fileWriter.write('\n');

                // Write the "Card Number" field
                if (each.getCardNumber().equalsIgnoreCase("null")) {
                    fileWriter.write("\"Card Number\": " + null + ",");
                } else if (each.getCardNumber().length() != 0) {
                    fileWriter.write("\"Card Number\": " + "\"" + each.getCardNumber() + "\"" + ",");
                } else {
                    fileWriter.write("\"Card Number\": " + null + ",");
                }
                fileWriter.write('\n');

                // Write the "Card Type" field
                fileWriter.write("\"Card Type\": " + "\"" + each.getType() + "\"");
                fileWriter.write('\n');

                // Close the JSON object
                fileWriter.write("}");

                // Add a comma if there are more elements to write
                if (counter < resultSize - 1) {
                    fileWriter.write(",");
                }
                counter++;
            }

            fileWriter.write("\n");
            fileWriter.write("]\n");
            fileWriter.write("}");

            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
