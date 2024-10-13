package org.salesianos.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileHelper {

    public static ArrayList<Integer> getAllNumbers(String inputFile) throws IOException {

        ArrayList<Integer> numbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile, StandardCharsets.UTF_8))) {
            String line = reader.readLine();

            while (line != null) {
                String[] numbersString = line.split(",");

                for (String numberString : numbersString) {
                    int number = Integer.parseInt(numberString);
                    numbers.add(number);
                }

            }

        } catch (Exception e) {
            System.out.println(" Can´t read file " + inputFile);
        }
        return numbers;
    }

}
