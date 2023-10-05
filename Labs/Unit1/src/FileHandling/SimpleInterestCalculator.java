package FileHandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SimpleInterestCalculator {
    public static void main(String[] args) {
        String sourceFileName = "/home/suman/Documents/Java-labs/Labs/Unit1/src/FileHandling/source.txt";
        String destinationFileName = "/home/suman/Documents/Java-labs/Labs/Unit1/src/FileHandling/destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String name = parts[0].trim();
                    double principle = Double.parseDouble(parts[1].trim());
                    double rate = Double.parseDouble(parts[2].trim());
                    double time = Double.parseDouble(parts[3].trim());

                    double simpleInterest = (principle * rate * time) / 100.0;
                    String outputLine = name + ", " + principle + ", " + rate + ", " + time + ", " + simpleInterest;

                    writer.write(outputLine);
                    writer.newLine(); // Add a newline character to separate records
                }
            }

            System.out.println("Simple interest calculated and written to the destination file!");

        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}

