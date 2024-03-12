package com.cmpe202.individualproject.main;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cmpe202.individualproject.handlers.CreditCardHandler;
import com.cmpe202.individualproject.handlers.MasterCard;
import com.cmpe202.individualproject.reader.*;
import com.cmpe202.individualproject.writer.CSVWriter;
import com.cmpe202.individualproject.writer.JSONWriter;
import com.cmpe202.individualproject.writer.Writer;
import com.cmpe202.individualproject.writer.XMLWriter;


public class App {
    public static String getFileType(String inputFile) {
        int lastDotIndex = inputFile.lastIndexOf('.'); // Find the index of the last dot in the file name
        if (lastDotIndex > 0 && lastDotIndex < inputFile.length() - 1) { // Ensure the dot is not the first or last character
            return inputFile.substring(lastDotIndex + 1); // Extract the file extension after the dot
        }
        return ""; // Return an empty string if no valid file extension is found
    }

    public static void main(String[] args) {
        String outputFile, inputFile;
        String inputFileType = "";
        String outputFileType = "";
        Reader fileReader;
        Writer fileWriter = null;
        List<CreditCardEntry> creditCardEntries = new ArrayList<>();
        List<OutputEntry> finalEntries = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        // Get input file path from the user
        System.out.print("Enter the input file path: ");
        inputFile = scanner.nextLine();

        // Get output file path from the user
        System.out.print("Enter the output file path: ");
        outputFile = scanner.nextLine();

        // Extract the input and output file extensions
        inputFileType = inputFile.substring(inputFile.indexOf("."));
        outputFileType = outputFile.substring(outputFile.indexOf("."));

        if (!inputFileType.equals(outputFileType)) {
            System.out.println("Input and Output extensions are not the same");
            System.exit(0);
        } else {
            System.out.println("Input and output extensions " + inputFileType + " and " + outputFileType + " are the same");
        }

        // Get the file type (extension) of the input file
        String fileType = getFileType(inputFile);
        System.out.println("File type: " + fileType);

        // Initialize the appropriate reader and writer based on the file type
        switch (fileType.toLowerCase()) {
            case "csv":
                fileReader = new CSVReader(new File(inputFile));
                fileWriter = new CSVWriter();
                break;
            case "json":
                fileReader = new JSONReader(new File(inputFile));
                fileWriter = new JSONWriter();
                break;
            case "xml":
                System.out.println("Processing XML file");
                fileReader = new XMLReader(new File(inputFile));
                fileWriter = new XMLWriter();
                break;
            default:
                System.out.println("Unsupported file type: " + fileType);
                return;
        }

        // Read the credit card entries from the input file
        creditCardEntries = fileReader.readFile(inputFile);

        // Process each credit card entry and write the results to the output file
        for (CreditCardEntry eachCreditCardEntry : creditCardEntries) {
            CreditCardHandler ccHandler = new MasterCard();
            String creditCardType = ccHandler.checkCreditCardType(eachCreditCardEntry);
            String ccNumber = eachCreditCardEntry.getCardNumber();
            finalEntries.add(new OutputEntry(ccNumber, creditCardType));
            fileWriter.writeToFile(finalEntries, outputFile);
        }
    }



}