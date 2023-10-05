package FileHandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DuplicateCharacters {
    public static void main(String[] args) {
        String sourceFileName = "/home/suman/Documents/Java-labs/Labs/Unit1/src/FileHandling/destination.txt";
        String destinationFileName = "/home/suman/Documents/Java-labs/Labs/Unit1/src/FileHandling/source.txt";

        try (FileReader reader = new FileReader(sourceFileName);
             FileWriter writer = new FileWriter(destinationFileName)) {

            int charRead;
            while ((charRead = reader.read()) != -1) {
                writer.write(charRead);
//                writer.write(charRead);
            }

            System.out.println("Characters duplicated successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
