import sun.java2d.SurfaceDataProxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import static java.util.Collections.shuffle;

public class Islands {
    // массив островов
    public static Map<Integer, ArrayList<Integer>> listOfIslands = new HashMap();
    public static ArrayList<Integer> countOfIslands = new ArrayList<Integer>();
    // нужно создать map c ключом - это остров в начале строчки
    //со значением - его соседи
    private static int key = 1;
    public static void fileReader() {
        try {

            File file = new File("/home/andrew/IT/file.txt");
            FileReader fileReader = new FileReader(file); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
            String line; // подсчет островов

            while ((line = bufferedReader.readLine()) != null) {
                // выводим содержимое файла на экран построчно
                String Vertex = line.substring(0,7); // соседи // остров хозяин
                String Neighbors = line.substring(7,line.length());
                ArrayList<Integer> listOfNeighbors = new ArrayList<Integer>();

                if (Neighbors.contains("Остров1")) {
                    listOfNeighbors.add(1);
                }
                if (Neighbors.contains("Остров2")) {
                    listOfNeighbors.add(2);
                }
                if (Neighbors.contains("Остров3")) {
                    listOfNeighbors.add(3);
                }
                if (Neighbors.contains("Остров4")) {
                    listOfNeighbors.add(4);
                }
                if (Neighbors.contains("Остров5")) {
                    listOfNeighbors.add(5);
                }
                if (Neighbors.contains("Остров6")) {
                    listOfNeighbors.add(6);
                }

                listOfIslands.put(key, listOfNeighbors);
                countOfIslands.add(key);
                key++;

            }
            Collections.shuffle(countOfIslands); // для случайного неповторяющегося списка, чтобы посадить викингов
            /*for (Integer list: countOfIslands) { // вывод перемешанной коллекции на экран, удалить при отладке
                System.out.println(list);
            }*/
            for (Map.Entry entry : listOfIslands.entrySet()) { // вывод островов с соседями
                System.out.println("Остров: " + entry.getKey() + " Соседи: "+ entry.getValue());
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void removeTheNeighbors (ArrayList<Integer>  list, int neighbor) {
        Iterator<Integer> listIterator = list.iterator();//создаем итератор
        while(listIterator.hasNext()) {//до тех пор, пока в списке есть элементы
            Integer nextInt = listIterator.next();//получаем следующий элемент
            if (nextInt.equals(neighbor)) {
                listIterator.remove();//удаляем кота с нужным именем
            }
        }

        System.out.println("Проверить удалились ли соседи" + list);

        /*int indexOfNeighbor = list.indexOf(neighbor);
        System.out.println("Индекс у острова соседа который нужно удалить" + indexOfNeighbor);
        list.remove(indexOfNeighbor);
        //System.out.println("Теперь можно сходить так: " + list);
*/
    }
    public static Set<Integer> getCount(){// общее количество островов
        return listOfIslands.keySet();
    }
    public static int getIsland(int i){ // конкретный остров
        return countOfIslands.get(i);
    }
    public static void danageOfLighthouse (int island) { // разрушение маяка после битвы
        countOfIslands.remove(island);
    }
}