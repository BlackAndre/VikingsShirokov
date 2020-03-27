import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartTheWar {
    private static int countVikingsFromKeyboard = 0; // initialize the count of viking
    public static Map<Integer, Vikings> listOfVikings= new HashMap<Integer, Vikings>(); // create the map of number and
                                                                                        // viking`s object
    public static Map<Integer, Integer> listVikingsAndIslands = new HashMap<Integer, Integer>(); //create the map of bound vikings- islands
    private static Set<Integer> setOfDamagedIslands = new HashSet<Integer>(); // create the Set of damaged islands

    public static void howMuchVikings() throws IOException { //receiving number of vikings from the keyboard
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int num = Integer.parseInt(name);
        if(num > Islands.countOfIslands.size()) { // number of viking should be less than the islands
            System.out.println("Викингов больше чем островов");
        } else
        countVikingsFromKeyboard = num;
        reader.close();
    }

    private static void firstMoor() { // random land viking on the islands
        for (int i = 1; i < countVikingsFromKeyboard+1; i++) {
            Vikings vikings = new Vikings();
            vikings.setName(i); // set the name by order
            vikings.setPlace(Islands.getIsland(i)); // set the random place from shuffled array of islands
            listOfVikings.put(vikings.getName(),vikings); // filled the Map of vikings number and object
            listVikingsAndIslands.put(vikings.getName(),vikings.getPlace()); // filled the bound vikings-islands
            //System.out.println("Викинг" + vikings.getName() + " высадился на остров" + vikings.getPlace());
        }
    }

    public static void battle (Map<Integer, Integer> map) {
        /* method that is called to check duplicate places of
        vikings and to damage the island and kill vikings */
        try {
            // create the array to check the duplicate values
        ArrayList<Integer> islands = new ArrayList();
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            islands.add(pair.getValue());
        }
        // duplicate value counter
        int count = 0;

        for(Integer islandsInBattle : islands){
            // if array islands has duplicate, then kill the vikings and destroy the island
            count = Collections.frequency(islands, islandsInBattle);
            if (count > 1) {
                removeVikingIslandBound(map, islandsInBattle);
                damageLightHouse(islandsInBattle);
            }
        }
       } catch (Exception e){
            e.printStackTrace();
       }
    }

    public static void damageLightHouse(Integer island) {
        // remove the island where was the battle
        Islands.listOfIslands.remove(island);
        // filled the Set of damaged islands
        setOfDamagedIslands.add(island);
        //System.out.println("Should be damaged" +island);
        for (Map.Entry entry : Islands.listOfIslands.entrySet()) {
            // remove the damaged neighbor of every island
           ArrayList<Integer> neighbors = (ArrayList<Integer>) entry.getValue();
            Islands.removeTheNeighbors(neighbors, island);
            //System.out.println("Остров: " + entry.getKey() + " Соседи: "+ entry.getValue());
        }
    }
    // remove the bound viking-island
    public static void removeVikingIslandBound(Map<Integer, Integer> map, Integer value) {
        Map<Integer, Integer> copy = new HashMap(map);
        for (Map.Entry<Integer, Integer> pair : copy.entrySet()) {
            Integer islandInBattle = pair.getValue();
            Integer vikingInBattle = pair.getKey();
            if (islandInBattle.equals(value)) {
                map.remove(vikingInBattle);
                System.out.println("АГР!!! На Острове" + islandInBattle + " уничтожен маяк, благодаря Викинг" +
                        // print what happened
                        vikingInBattle);
                killVikingsObjects(listOfVikings, pair.getKey());
            }
        }
    }
    // kill the vikings in battle
    public static void killVikingsObjects (Map<Integer, Vikings> map, Integer key) {
        Map<Integer, Vikings> copy = new HashMap(map);
        for (Map.Entry<Integer, Vikings> pair : copy.entrySet()) {
            if (pair.getKey().equals(key)) {
                map.remove(pair.getKey());
            }
        }
    }
    // main action of War
    private static void WarIsOn () {
        // landing the vikings
        firstMoor();
        int countOfDays = 1;
        // if anybody move on the map, keep going
        boolean isAnybodyMove = true;
        while (isAnybodyMove) {
            if (countOfDays < 10000) {
               // System.out.println("Day " + countOfDays);
                //viking`s movement
                for (Map.Entry<Integer, Vikings> pair : listOfVikings.entrySet()) {
                    Vikings vikingToMove = pair.getValue();
                    isAnybodyMove = vikingToMove.moveToIsland();
                }
                // start the battles between vikings
                battle(listVikingsAndIslands);
                //if there is nowhere of nobody to go then print the current map
                if (listVikingsAndIslands.isEmpty() || listOfVikings.isEmpty()) {
                    printCurrentMap();
                    break;
                } else {
                    printCurrentMap();
                }
                countOfDays++;
            } else {
                isAnybodyMove = false;
            }
        }
    }

    private static void printCurrentMap() {
        for (Map.Entry<Integer, ArrayList<Integer>> pair : Islands.listOfIslands.entrySet()) {
            System.out.println("Остров" + pair.getKey());
        }
    }

    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        howMuchVikings();
        WarIsOn();
    }
}
