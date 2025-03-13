import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFile = "C://Users//user//documents//data.txt";
        String outputFile = "C://Users//user//documents//modified_data.txt";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try (var reader = new BufferedReader(new FileReader(inputFile));
             var writer = new BufferedWriter(new FileWriter(outputFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line + " " + LocalDateTime.now().format(formatter));
                writer.newLine();
            }
            System.out.println("Файл обработан: " + outputFile);
        }
    }
}
