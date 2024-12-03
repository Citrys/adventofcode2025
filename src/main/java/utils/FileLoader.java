package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class FileLoader {
    public String loadFile(String filePath) {
        StringBuilder data = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.append(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error parsing integer: " + e.getMessage());
        }
        return data.toString();
    }
}