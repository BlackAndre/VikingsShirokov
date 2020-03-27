import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

public class Islands {
    //create the map of islands
    public static Map<Integer, ArrayList<Integer>> listOfIslands = new HashMap();
    // create List to count islands
    public static ArrayList<Integer> countOfIslands = new ArrayList<Integer>();
    // start to count from 1, not from 0
    private static int key = 1;
    // create method to read the file with map of islands
    public static void fileReader() {
        try {
            System.out.println("Please enter the number of the map:");
            // input the number of the map
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            int numberOfMap = Integer.parseInt(name);

            // specify file path
            String path = new File("").getAbsolutePath();
            File file = new File(path + "/file"+numberOfMap+".txt");;
            // create class FileReader to read the file
            FileReader fileReader = new FileReader(file);
            // connect FileReader with BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // line reading
            String line;

            while ((line = bufferedReader.readLine()) != null) { // until the lines end
                String Neighbors = line.substring(7); // cutting line after 7th character
                // create the list of neighbors current island
                ArrayList<Integer> listOfNeighbors = new ArrayList<Integer>();
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
                // filling in the map of island and its neighbors
                listOfIslands.put(key, listOfNeighbors);
                // filling the array count
                countOfIslands.add(key);
                // increment the key (number of main island)
                key++;
            }
            Collections.shuffle(countOfIslands);
            // shuffle the array count to land the viking on random island for the first time
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void removeTheNeighbors(ArrayList<Integer> list, int neighbor) {
        // method to delete the neighbor when the same island`s lighthouse is damaged
        //create iterator
        Iterator<Integer> listIterator = list.iterator();
        while(listIterator.hasNext()) {
            Integer nextInt = listIterator.next();
            //remove the island that equals the one which is destroyed
            if (nextInt.equals(neighbor)) {
                listIterator.remove();
            }
        }
    }
    // getter of the island
    public static int getIsland(int i){
        return countOfIslands.get(i-1);
    }
}