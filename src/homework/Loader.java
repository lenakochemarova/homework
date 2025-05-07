package homework;

import java.io.*;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.RecursiveTask;

public class Loader {

    public static void main(String[] args) throws IOException {
        String source = "C:\\Новаяпапка\\file.txt"; //файл, из которого скопировать содержимое в новый сохраняемый файл
        String fileName = "fileX";
        String directory = "C:\\Новаяпапка\\zzz";
        Scanner scanner = new Scanner(System.in);

        System.out.println("Файл " + fileName + ".txt сохраняется в " + directory);
        saveFile(source, directory, fileName);

        while (true) {
            System.out.println("Желаете выполнить поиск? (да/нет)");
            String answer = scanner.nextLine().toLowerCase();
            if (answer.equals("нет")) {
                System.out.println("Конец программы");
                return;
            } else if (answer.equals("да")) {
                System.out.println("Введите директорию где искать:");
                String dir = scanner.nextLine();
                System.out.println("Введите имя файла с форматом (.txt):");
                String name = scanner.nextLine();
                try {
                    search(dir, name);
                } catch (Exception e) {
                    System.out.println("Были введены некорректные данные");
                }
            } else {
                System.out.println("Неверный ввод");
            }
            scanner.close();
        }
    }

    public static void saveFile(String sourcePath, String directory, String fileName) throws IOException {

        List<String> text = Files.readAllLines(new File(sourcePath).toPath());

        File file = new File(directory);
        if (!file.exists()) {
            System.out.println("Директория не существует, создаем...");
            if (file.mkdirs())
                System.out.println("Директория создана");
            else {
                System.out.println("Ошибка: не удалось создать директорию");
                return;
            }
        }
        file = new File(directory + "\\" + fileName + ".txt");

        FileWriter writer = new FileWriter(file);
        long start = System.currentTimeMillis();
        for (String str : text)
            writer.write(str + "\n");

        System.out.println("Время записи: " + (System.currentTimeMillis() - start) + " мс");
        System.out.println("Размер файла: " + Files.size(file.toPath()) + " байт");
        writer.close();
    }

    public static void search(String directory, String fileName) throws IOException {
        File dir = new File(directory);
        File res = null;
        if (dir.isDirectory()) {
            res = searchFile(dir, fileName);
        } else {
            System.out.println("Указанный путь не является существующей директорией");
        }
        if (res == null) {
            System.out.println("Файл не найден");
            return;
        }
        BufferedReader reader = new BufferedReader(new FileReader(res));
        StringBuilder text = new StringBuilder();
        while (reader.ready()) {
            text.append(reader.readLine() + "\n");
        }
        System.out.println(text);
        reader.close();

    }

    public static File searchFile(File dir, String fileName) {
        File res = null;
        for (File item : dir.listFiles()) {
            if (res != null)
                break;
            if (item.isFile()) {
                if (item.getName().equals(fileName)) {
                    res = new File(item.getAbsolutePath());
                    System.out.println("Файл найден: " + res.getAbsolutePath());
                    return res;
                }
            } else {
                res = searchFile(item, fileName);
            }
        }
        return res;
    }
}
