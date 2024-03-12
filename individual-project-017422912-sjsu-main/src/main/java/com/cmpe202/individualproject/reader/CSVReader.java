package com.cmpe202.individualproject.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.cmpe202.individualproject.main.CreditCardEntry;

public class CSVReader implements Reader {

    File file;

    public CSVReader() {
    }

    public CSVReader(File file) {
        this.file = file;
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {

        BufferedReader br;
        List<CreditCardEntry> result = new ArrayList<>();

        // Date format for parsing the expiration date
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");

        try {
            br = new BufferedReader(new FileReader(file));
            String line;
            line = br.readLine();

            // Throw an exception if the file is empty
            if (line == null)
                throw new IllegalArgumentException("File is empty");

            while ((line = br.readLine()) != null) {
                String[] entries = line.split(",");

                // Throw an exception if the CSV line has more than 4 entries
                if (entries.length > 4)
                    throw new ArrayIndexOutOfBoundsException();

                // Extract the credit card number
                String cardNumber = entries[0];

                // Extract the date entry for the expiration date
                String dateEntry = entries[1];

                // Parse the expiration date using the specified format
                Date edate = sdf.parse(String.valueOf(dateEntry));

                // Extract the name of the cardholder
                String nameOfCardHolder = entries[2];

                // Create a CreditCardEntry object and add it to the result list
                CreditCardEntry ccEntry = new CreditCardEntry(cardNumber, edate, nameOfCardHolder);
                result.add(ccEntry);
            }
            br.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
