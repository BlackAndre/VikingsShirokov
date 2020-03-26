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
    public static void battle (Map<Integer, Integer> map) { // method that is called to check duplicate places of
                                                            // vikings and to damage the island and kill vikings
        try {
        ArrayList<Integer> islands = new ArrayList(); // create the array to check the duplicate values
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            islands.add(pair.getValue());
        }
        int count = 0; // duplicate value counter

        for(Integer islandsInBattle : islands){
            count = Collections.frequency(islands, islandsInBattle); // if array islands has duplicate,
            if (count > 1) {
                removeVikingIslandBound(map, islandsInBattle); //and kill the vikings
                damageLightHouse(islandsInBattle);// // when damage island
            }
        }
       } catch (Exception e){
            e.printStackTrace();
       }
    }
    public static void damageLightHouse(Integer island) {
        Islands.listOfIslands.remove(island); // remove the island where was the battle
        setOfDamagedIslands.add(island); // filled the Set of damaged islands
        //System.out.println("Should be damaged" +island);
        for (Map.Entry entry : Islands.listOfIslands.entrySet()) {
           ArrayList<Integer> neighbors = (ArrayList<Integer>) entry.getValue(); // remove the damaged neighbor of every island
            Islands.removeTheNeighbors(neighbors, island);
            //System.out.println("Остров: " + entry.getKey() + " Соседи: "+ entry.getValue());
        }
    }
    public static void removeVikingIslandBound(Map<Integer, Integer> map, Integer value) { // remove the bound viking-island
        Map<Integer, Integer> copy = new HashMap(map);
        for (Map.Entry<Integer, Integer> pair : copy.entrySet()) {
            Integer islandInBattle = pair.getValue();
            Integer vikingInBattle = pair.getKey();
            if (islandInBattle.equals(value)) {
                map.remove(vikingInBattle);
                System.out.println("АГР!!! На Острове" + islandInBattle + " уничтожен маяк, благодаря Викинг" +
                      vikingInBattle); // print what happened
                killVikingsObjects(listOfVikings, pair.getKey());
            }
        }
    }
    public static void killVikingsObjects (Map<Integer, Vikings> map, Integer key) { // kill the vikings in battle
        Map<Integer, Vikings> copy = new HashMap(map);
        for (Map.Entry<Integer, Vikings> pair : copy.entrySet()) {
            if (pair.getKey().equals(key)) {
                map.remove(pair.getKey());
            }
        }
    }
    private static void WarIsOn () { // main action of War
        firstMoor(); // landing the vikings
        int countOfDays = 1;
        boolean isAnybodyMove = true; // if anybody move on the map, keep going
        while (isAnybodyMove) {
            if (countOfDays < 10000) {
               // System.out.println("Day " + countOfDays);
                for (Map.Entry<Integer, Vikings> pair : listOfVikings.entrySet()) { //move of vikings
                    Vikings vikingToMove = pair.getValue();
                    isAnybodyMove = vikingToMove.moveToIsland();
                }

                battle(listVikingsAndIslands); // vikings in battle
                if (listVikingsAndIslands.isEmpty() || listOfVikings.isEmpty()) { //if there is nowhere of nobody to go
                    printCurrentMap(); // print the map
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
