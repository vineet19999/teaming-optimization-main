package com.cmpe202.individualproject.reader;

import com.cmpe202.individualproject.main.CreditCardEntry;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.rmi.registry.LocateRegistry;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class JSONReader implements Reader {
    File file;

    public JSONReader() {
    }

    public JSONReader(File file) {
        this.file = file;
    }

    @Override
    public List<CreditCardEntry> readFile(String inputFile) {
        FileReader fr;
        List<CreditCardEntry> result = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();
        List<String> cardDetails;
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");

        try {
            fr = new FileReader(file);
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(fr);
            System.out.println(jsonObject.get("cards"));

            JSONArray cards = (JSONArray) jsonObject.get("cards");

            for (int i = 0; i < cards.size(); i++) {
                System.out.println(cards.get(i));
                cardDetails = new ArrayList<>();
                String entries = cards.get(i).toString();
                String[] eachCardEntry = entries.split(",");
                for (String each : eachCardEntry) {
                    String[] split1 = each.split(":");
                    String replace1 = split1[1].replaceAll("}", "");
                    String replace2 = replace1.replaceAll("\\\\", "");
                    cardDetails.add(replace2);
                }

                for (String string : cardDetails) {
                    System.out.println(string);
                }

                String a = "";
                if (cardDetails.size() < 3) {
                    a = "";
                    String name = cardDetails.get(0).replaceAll("\"", "");
                    String b = cardDetails.get(1).replaceAll("\"", "");
                    Date eDate = sdf.parse(String.valueOf(b));
                    result.add(new CreditCardEntry(a, eDate, name));
                } else {
                    a = cardDetails.get(1).replaceAll("\"", "");
                    String b = cardDetails.get(2).replaceAll("\"", "");
                    Date eDate = sdf.parse(String.valueOf(b));
                    String name = cardDetails.get(0).replaceAll("\"", "");
                    System.out.println(name + " " + a.length() + " ------- " + a + " " + b);

                    // Long cNumber = Long.parseLong(a);
                    String cNumber = a;

                    result.add(new CreditCardEntry(cNumber, eDate, name));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
