import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartTheWar {
    // initialize the count of viking
    private static int countVikingsFromKeyboard = 0;
    // create the map of number and viking`s object
    public static Map<Integer, Viking> listOfVikings= new HashMap<Integer, Viking>();
    //create the map of bound vikings- islands
    public static Map<Integer, Integer> listVikingsAndIslands = new HashMap<Integer, Integer>();
    // create the Set of islands that left afters all the battles
    private static Set<Integer> setOfIslandsLeft = new HashSet<Integer>();

    //receiving number of vikings from the keyboard
    public static void getCountVikingsFromKeyboard() throws IOException {
        System.out.println("Please enter the count of Vikings:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int num = Integer.parseInt(name);
        // number of viking should be less than the islands
        if(num > Islands.countOfIslands.size()) {
            System.out.println("There are more Viking than islands");
        } else
        countVikingsFromKeyboard = num;
        reader.close();
    }
    // random land viking on the islands
    private static void firstLanding() {
        for (int i = 1; i < countVikingsFromKeyboard+1; i++) {
            // set the name by order and set the random place from shuffled array of islands
            Viking viking = new Viking(i, Islands.getIsland(i));
            // filled the Map of viking number and object
            listOfVikings.put(viking.getName(), viking);
            // filled the bound viking-islands
            listVikingsAndIslands.put(viking.getName(), viking.getPlace());
            //System.out.println("The viking" + viking.getName() + " landed on the island" + viking.getPlace());
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
        for (Map.Entry entry : Islands.listOfIslands.entrySet()) {
            // remove the damaged neighbor of every island
           ArrayList<Integer> neighbors = (ArrayList<Integer>) entry.getValue();
            Islands.removeTheNeighbors(neighbors, island);
            //System.out.println("Island: " + entry.getKey() + " Neighbors: "+ entry.getValue());
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
                // print what happened
                System.out.println("АГР!!! На Острове" + islandInBattle + " уничтожен маяк, благодаря Викинг" +
                        vikingInBattle);
                killVikingsObjects(listOfVikings, pair.getKey());
            }
        }
    }
    // kill the vikings in battle
    public static void killVikingsObjects (Map<Integer, Viking> map, Integer key) {
        Map<Integer, Viking> copy = new HashMap(map);
        for (Map.Entry<Integer, Viking> pair : copy.entrySet()) {
            if (pair.getKey().equals(key)) {
                map.remove(pair.getKey());
            }
        }
    }
        // main action of War
    private static void WarIsOn () {
        firstLanding(); // landing the vikings
        int countOfDays = 1;
        boolean isAnybodyMove = true; // if anybody move on the map, keep going
        while (isAnybodyMove) {
            if (countOfDays < 10000) {
                // System.out.println("Day " + countOfDays);
                //viking`s movement
                for (Map.Entry<Integer, Viking> pair : listOfVikings.entrySet()) {
                    Viking vikingToMove = pair.getValue();
                    isAnybodyMove = vikingToMove.moveToIsland();
                }
                // viking`s battle
                battle(listVikingsAndIslands);
                //if there is nowhere of nobody to go
                if (listVikingsAndIslands.isEmpty() || listOfVikings.isEmpty()) {
                    // print the map
                    break;
                }
                countOfDays++;
            } else {
                isAnybodyMove = false;
            }
        } printCurrentMap();
    }
    // print the current map of islands
    private static void printCurrentMap() {
        for (Map.Entry<Integer, ArrayList<Integer>> pair : Islands.listOfIslands.entrySet()) {
            ArrayList<Integer> arrayOfLeftIslands = pair.getValue();
            setOfIslandsLeft.addAll(arrayOfLeftIslands);
        }
        for (Integer integer : setOfIslandsLeft) {
            System.out.println("Остров" + integer);
        }
    }

    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        getCountVikingsFromKeyboard();
        WarIsOn();
    }
}
