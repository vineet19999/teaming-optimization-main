package com.cmpe202.individualproject.writer;

import com.cmpe202.individualproject.handlers.CreditCardHandler;
import com.cmpe202.individualproject.handlers.MasterCard;
import com.cmpe202.individualproject.main.CreditCardEntry;
import com.cmpe202.individualproject.main.OutputEntry;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;

public class XMLWriter implements Writer {
    File outputFile;

    @Override
    public void writeToFile(List<OutputEntry> result, String outputFile) {
        // Create a DocumentBuilder instance
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            // Create a new Document
            Document doc = dBuilder.newDocument();

            // Create the root element
            Element rootElement = doc.createElementNS("", "CARDS");
            doc.appendChild(rootElement);

            // Iterate over the output entries and create XML elements
            for (OutputEntry each : result) {
                Element rowElement = doc.createElement("CARD");

                // Create CARD_NUMBER element
                Element nodeCardNumber = doc.createElement("CARD_NUMBER");
                if (each.getCardNumber().length() == 0) {
                    nodeCardNumber.appendChild(doc.createTextNode(""));
                    rowElement.appendChild(nodeCardNumber);
                } else {
                    nodeCardNumber.appendChild(doc.createTextNode(String.valueOf(each.getCardNumber())));
                    rowElement.appendChild(nodeCardNumber);
                }

                // Create CARD_TYPE element
                Element nodeCardType = doc.createElement("CARD_TYPE");
                nodeCardType.appendChild(doc.createTextNode(each.getType()));
                rowElement.appendChild(nodeCardType);

                // Add the row element to the root element
                rootElement.appendChild(rowElement);
            }

            // Create a Transformer and set output properties
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            // Create a DOMSource from the Document
            DOMSource source = new DOMSource(doc);

            // Create a StreamResult for console output and file output
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File(outputFile));

            // Transform the DOMSource and write the result to console and file
            transformer.transform(source, console);
            transformer.transform(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
