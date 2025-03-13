import java.io.*;

public class Main {
    public static void main(String[] args) {
        try {
            String fileName = "C:/Users/user/Documents/text_familiya.txt";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            int lineCount = 0;
            int javaCount = 0;
            String longestWord = "";

            String line;
            while ((line = reader.readLine()) != null) {
                lineCount++;
                String[] words = line.split(" ");
                for (String word : words) {
                    if (word.equalsIgnoreCase("Java")) {
                        javaCount++;
                    }
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
            reader.close();

            System.out.println("Всего строк: " + lineCount);
            System.out.println("Самое длинное слово: " + longestWord);
            System.out.println("Количество 'Java': " + javaCount);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла");
        }
    }
}
