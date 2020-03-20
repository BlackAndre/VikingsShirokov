
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;


public class Map {
    private static void fileReader() {
        try {
            File file = new File("/home/andrew/IT/file.txt");
            FileReader fileReader = new FileReader(file); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader

            String line;
            int lineNumber = 0;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line); // выводим содержимое файла на экран построчно
                lineNumber++;
            }

            System.out.println(lineNumber);

            bufferedReader.close(); // закрываем поток
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        fileReader();
    }
}