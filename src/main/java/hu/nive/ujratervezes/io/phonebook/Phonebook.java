package hu.nive.ujratervezes.io.phonebook;

import java.io.*;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        if ("null".equals(contacts) || "null".equals(String.valueOf(output))) {
            throw new IllegalArgumentException("Invalid input");
        }
        File file = new File(output);
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String line = entry.getKey() + ": " + entry.getValue() + "\n";
                bw.write(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}