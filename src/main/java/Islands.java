import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Islands {
    private static int lineNumber = 0;
    public static void fileReader() {
        try {

            File file = new File("/home/andrew/IT/file.txt");
            FileReader fileReader = new FileReader(file); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
            String line; // подсчет островов
            ArrayList<Integer> listOfIslands = new ArrayList<Integer>(); // массив островов
            int coced = 0; // сосед текущего острова
            int[][] array = new int[6][6]; // типо матрица смежности
            while ((line = bufferedReader.readLine()) != null) {
                // выводим содержимое файла на экран построчно
                if (line.contains("Остров1")) {
                    coced = 0;
                    array[lineNumber][coced] = 1;
                }
                if (line.contains("Остров2")) {
                    coced = 1;
                    array[lineNumber][coced] = 1;
                }
                if (line.contains("Остров3")) {
                    coced = 2;
                    array[lineNumber][coced] = 1;
                }
                if (line.contains("Остров4")) {
                    coced = 3;
                    array[lineNumber][coced] = 1;
                }
                if (line.contains("Остров5")) {
                    coced = 4;
                    array[lineNumber][coced] = 1;
                }
                if (line.contains("Остров6")) {
                    coced = 5;
                    array[lineNumber][coced] = 1;
                }
                lineNumber++;
                listOfIslands.add(lineNumber);

            }
            Collections.shuffle(listOfIslands); // для случайного неповторяющегося списка, чтобы посадить викингов
            for (Integer list: listOfIslands) {
                System.out.println(list);
            }
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }
            System.out.println(lineNumber);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int getCount(){
            return lineNumber;
    }
}