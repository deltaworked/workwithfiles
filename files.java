import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ваше ФИО:");
        String fullName = scanner.nextLine();
        System.out.println("Введите вашу группу:");
        String group = scanner.nextLine();

        String directoryPath = "C:/Users/user/desktop";

        String fileName = "student_" + fullName.replace(" ", "_") + ".txt";
        Path filePath = Path.of(directoryPath + fileName);

        if (Files.exists(filePath)) {
            System.out.println("Файл уже существует");
        } else {
            String content = String.format("Привет, %s!\nТы учишься в группе %s.\nДата создания файла: %s",
                    fullName, group, LocalDate.now());
            try {
                Files.writeString(filePath, content);
                System.out.println("Файл успешно создан!");
            } catch (IOException e) {
                System.out.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
