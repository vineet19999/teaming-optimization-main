package com.cmpe202.individualproject.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.cmpe202.individualproject.main.CreditCardEntry;

public interface Reader {

    // Read the file and return a list of CreditCardEntry objects
    List<CreditCardEntry> readFile(String inputFile);
    // TODO Auto-generated method stub

}
