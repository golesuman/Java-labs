package FileHandling;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFileName = "/home/suman/Documents/Java-labs/Labs/Unit1/src/FileHandling/source.txt";
        String destinationFileName = "/home/suman/Documents/Java-labs/Labs/Unit1/src/FileHandling/destination.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                // Read a line from the source file
                // Write the same line to the destination file
                writer.write(line);
                writer.newLine(); // Add a newline character to separate lines
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
