import sun.java2d.SurfaceDataProxy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import static java.util.Collections.shuffle;

public class Islands {
    public static Map<Integer, ArrayList<Integer>> listOfIslands = new HashMap(); //create the map of islands
    public static ArrayList<Integer> countOfIslands = new ArrayList<Integer>(); // create List to count islands
    private static int key = 1; // start to count from 1, not from 0
    public static void fileReader() { // create method to read the file with map of islands
        try {

            File file = new File("/home/andrew/IT/file.txt"); // specify file path
            FileReader fileReader = new FileReader(file); // create class FileReader to read the file
            BufferedReader bufferedReader = new BufferedReader(fileReader); // connect FileReader with BufferedReader
            String line; // line reading

            while ((line = bufferedReader.readLine()) != null) { // until the lines end
                String Neighbors = line.substring(7); // cutting line after 7th character
                ArrayList<Integer> listOfNeighbors = new ArrayList<Integer>(); // create the list of neighbors current island
                // filling the array of neighbors
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

                listOfIslands.put(key, listOfNeighbors); // filling in the map of island and its neighbors
                countOfIslands.add(key); // filling the array count
                key++; // increment the key (number of main island)
            }
            Collections.shuffle(countOfIslands); // shuffle the array count to land the viking on random island for the first time

            /*for (Map.Entry entry : listOfIslands.entrySet()) {  out put the islands with neighbors
                System.out.println("Остров: " + entry.getKey() + " Соседи: "+ entry.getValue());

            }*/
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void removeTheNeighbors (ArrayList<Integer>  list, int neighbor) { // method to delete the neighbor
                                                                                // when the same island`s lighthouse is damaged
        Iterator<Integer> listIterator = list.iterator();//create iterator
        while(listIterator.hasNext()) {
            Integer nextInt = listIterator.next();
            if (nextInt.equals(neighbor)) {
                listIterator.remove();//remove the island that equals the one which is destroyed
            }
        }
    }
    public static int getIsland(int i){ // getter of the island
        return countOfIslands.get(i-1);
    }
}