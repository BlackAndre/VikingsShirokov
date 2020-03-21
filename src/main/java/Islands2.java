import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Islands2 {
    private static int lineNumber = 0;
    public static ArrayList<Integer> listOfIslands = new ArrayList<Integer>(); // массив островов
    public static void fileReader() {
        try {

            File file = new File("/home/andrew/IT/file.txt");
            FileReader fileReader = new FileReader(file); // поток, который подключается к текстовому файлу
            BufferedReader bufferedReader = new BufferedReader(fileReader); // соединяем FileReader с BufferedReader
            String line; // подсчет островов
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            HashMap<Integer, List<Integer>> listOfIslands = new HashMap(); // нужно создать map c ключом - это остров в начале строчки
                                                                            //со значением - его соседи
            ArrayList<Integer> listOfNeighbors = new ArrayList<Integer>()


                public boolean contains(Object o) {
                    return false;
                }

                public Iterator<Integer> iterator() {
                    return null;
                }

                public Object[] toArray() {
                    return new Object[0];
                }

                public <T> T[] toArray(T[] ts) {
                    return null;
                }

                public boolean add(Integer integer) {
                    return false;
                }

                public boolean remove(Object o) {
                    return false;
                }

                public boolean containsAll(Collection<?> collection) {
                    return false;
                }

                public boolean addAll(Collection<? extends Integer> collection) {
                    return false;
                }

                public boolean addAll(int i, Collection<? extends Integer> collection) {
                    return false;
                }

                public boolean removeAll(Collection<?> collection) {
                    return false;
                }

                public boolean retainAll(Collection<?> collection) {
                    return false;
                }

                public void clear() {

                }

                public Integer get(int i) {
                    return null;
                }

                public Integer set(int i, Integer integer) {
                    return null;
                }

                public void add(int i, Integer integer) {

                }

                public Integer remove(int i) {
                    return null;
                }

                public int indexOf(Object o) {
                    return 0;
                }

                public int lastIndexOf(Object o) {
                    return 0;
                }

                public ListIterator<Integer> listIterator() {
                    return null;
                }

                public ListIterator<Integer> listIterator(int i) {
                    return null;
                }

                public List<Integer> subList(int i, int i1) {
                    return null;
                }
            }
            int key;


            while ((line = bufferedReader.readLine()) != null) {
                // выводим содержимое файла на экран построчно
                String Vertex = line.substring(7,line.length()); // остров хозяин
                String Neighbors = line.substring(0,7); // соседи


                if (Vertex.equals("Остров1")){
                    key = 0;
                    listOfIslands.put(key,);

                lineNumber++;
                listOfIslands.add(lineNumber);

            }
            Collections.shuffle(listOfIslands); // для случайного неповторяющегося списка, чтобы посадить викингов
            for (Integer list: listOfIslands) { // вывод перемешанной коллекции на экран, удалить при отладке
                System.out.println(list);
            }
            for (int i = 0; i < array.length; i++) { // вывод матрицы смежности на экран, удалить при отладке
                for (int j = 0; j < array[i].length; j++) {
                    System.out.print(array[i][j] + "\t");
                }
                System.out.println();
            }
            }
            System.out.println(lineNumber);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int getCount(){// общее количество островов
            return lineNumber;
    }
    public static int getIsland(int i){ // конкретный остров
        return listOfIslands.get(i);
    }
}