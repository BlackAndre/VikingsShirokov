import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartTheGame {
    private static int countVikingsFromKeyboard = 0;
    public static Map<Integer, Vikings> listOfVikings= new HashMap<Integer, Vikings>();
    public static Map<Integer, Integer> listVikingsAndIslands = new HashMap<Integer, Integer>();
    public static void howMuchVikings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int num = Integer.parseInt(name);
        countVikingsFromKeyboard = num;
        reader.close();
    }
    private static void firstMoor() {

        for (int i = 1; i < countVikingsFromKeyboard+1; i++) {
            Vikings vikings = new Vikings();
            vikings.setName(i);
            vikings.setPlace(Islands.getIsland(i));
            listOfVikings.put(vikings.getName(),vikings);
            listVikingsAndIslands.put(vikings.getName(),vikings.getPlace());
            System.out.println("Викинг" + vikings.getName() + " высадился на остров" + vikings.getPlace());
        }
    }
    public static void battle (Map<Integer, Integer> map) {
        try {
        ArrayList<Integer> islands = new ArrayList(); // перегоняем map в list
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            islands.add(pair.getValue());
        }
        int count = 0; // счетчик для повторяющих значений

        for(Integer islandsInBattle : islands){
            count = Collections.frequency(islands, islandsInBattle);
            if (count > 1) {
                killVikings(map, islandsInBattle);
                damageMayak(islandsInBattle);
            }
        }
       } catch (Exception e){
            e.printStackTrace();
       }
    }
    public static void damageMayak (Integer island) {
        Islands.listOfIslands.remove(island);
        System.out.println("Должен быть уничтожен остров" +island);
        for (Map.Entry entry : Islands.listOfIslands.entrySet()) {
           ArrayList<Integer> neighborslist = (ArrayList<Integer>) entry.getValue();
            Islands.removeTheNeighbors(neighborslist, island);
            System.out.println("Остров: " + entry.getKey() + " Соседи: "+ entry.getValue());
        }
    }
    public static void killVikings (Map<Integer, Integer> map, Integer value) {
        Map<Integer, Integer> copy = new HashMap(map);
        for (Map.Entry<Integer, Integer> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
                killVikingsObjects(listOfVikings, pair.getKey());
                //listOfVikings.remove(pair.getKey());
            }
        }
    }
    public static void killVikingsObjects (Map<Integer, Vikings> map, Integer key) {
        Map<Integer, Vikings> copy = new HashMap(map);
        for (Map.Entry<Integer, Vikings> pair : copy.entrySet()) {
            if (pair.getKey().equals(key)) {
                map.remove(pair.getKey());
                //listOfVikings.remove(pair.getKey());
            }
        }
    }
    private static void WarIsOn () {
        firstMoor();
        int countOfDays = 1;
        while (countOfDays < 3) {
            // счет дней
            System.out.println("День " + countOfDays);
            for (Map.Entry<Integer, Vikings> pair : listOfVikings.entrySet()) { //движение викингов
                Vikings vikingToMove = pair.getValue();
                vikingToMove.moveToIsland();
            }
            System.out.println("ВСЕ СХОДИЛИ");

            battle(listVikingsAndIslands);
            countOfDays++;
            if (listVikingsAndIslands.isEmpty() || listOfVikings.isEmpty()) {
                System.out.println("ВСЕ сдохли");
                printCurrentMap();
                break;
            } else {
                printCurrentMap();
            }
        }
    }

    private static void printCurrentMap() {
        System.out.println("Теперь столько викингов:" + StartTheGame.listVikingsAndIslands.keySet());
        System.out.println("Теперь столько викингов - объектов" + listOfVikings.keySet());
        System.out.println("Теперь столько островов:" + Islands.listOfIslands.keySet());
        System.out.println("Викинг и острова "+ StartTheGame.listVikingsAndIslands);
    }

    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        howMuchVikings();
        WarIsOn();
    }
}
