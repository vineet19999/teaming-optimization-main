package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class XMLReader implements Reader {
    File file;

    public XMLReader(File file) {
        this.file = file;
    }

    public XMLReader() {
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {
        List<CreditCardEntry> result = new ArrayList<>();
        File fileReader;

        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            // Set the feature for secure processing
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            fileReader = new File(inputFile);

            // Parse the XML file
            Document doc = db.parse(fileReader);

            // Get the list of CARD elements
            NodeList list = doc.getElementsByTagName("CARD");

            for (int temp = 0; temp < list.getLength(); temp++) {
                Node node = list.item(temp);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Retrieve the CARD_NUMBER from the XML element
                    String cardNumber = element.getElementsByTagName("CARD_NUMBER").item(0).getTextContent();

                    // Retrieve the EXPIRATION_DATE from the XML element
                    String a = element.getElementsByTagName("EXPIRATION_DATE").item(0).getTextContent();
                    Date eDate = sdf.parse(String.valueOf(a));

                    // Retrieve the CARD_HOLDER_NAME from the XML element
                    String nameCardHolder = element.getElementsByTagName("CARD_HOLDER_NAME").item(0).getTextContent();

                    // Create a CreditCardEntry object and add it to the result list
                    CreditCardEntry ccEntry = new CreditCardEntry(cardNumber, eDate, nameCardHolder);
                    result.add(ccEntry);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
