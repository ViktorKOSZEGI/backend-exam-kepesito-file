package hu.nive.ujratervezes.io.phonebook;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Map;

public class Phonebook {
    public void exportPhonebook(Map<String, String> contacts, String output) {
        if ("null".equals(contacts) || "null".equals(String.valueOf(output))) {
            throw new IllegalArgumentException("Invalid input");
        }
        Path filePath = Path.of(output);
        try (BufferedWriter bw = Files.newBufferedWriter(filePath, StandardOpenOption.APPEND)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String line = entry.getKey() + ": " + entry.getValue() + "\n";
                bw.write(line);
            }
        } catch (Exception throwables) {
            throw new IllegalArgumentException("Exception occured");
        }
    }
}