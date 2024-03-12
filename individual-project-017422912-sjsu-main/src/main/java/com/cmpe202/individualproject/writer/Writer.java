package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.main.CreditCardEntry;
import com.cmpe202.individualproject.main.OutputEntry;

import java.util.List;

public interface Writer {

    /**
     * Writes the list of output entries to a specified output file.
     *
     * @param result     The list of output entries to write.
     * @param outputFile The path of the output file.
     */
    public void writeToFile(List<OutputEntry> result, String outputFile);
}
