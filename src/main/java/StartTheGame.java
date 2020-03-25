import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartTheGame {
    private static int countVikingsFromKeyboard = 0;
    public static Map<Integer, Vikings> listOfVikings= new HashMap<Integer, Vikings>();
    public static Map<Integer, Integer> listVikingsAndIslands = new HashMap<Integer, Integer>();
    private static Set<Integer> setOfDamagedIslands = new HashSet<Integer>();
    public static void howMuchVikings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();


        int num = Integer.parseInt(name);
        if(num > 6) {
            System.out.println("Викингов больше чем островов");

        } else
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
    public static void battle (Map<Integer, Integer> map) { // массив передается listVikingAndIslands
        try {
        ArrayList<Integer> islands = new ArrayList(); // перегоняем listVikingAndIslands в list
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            islands.add(pair.getValue());
        }
        int count = 0; // счетчик для повторяющих значений

        for(Integer islandsInBattle : islands){
            count = Collections.frequency(islands, islandsInBattle); // если кто то есть на одном острове, то
            if (count > 1) {
                removeVikingIslandBound(map, islandsInBattle); // разрыв связи викинг - островов и убийство викингов
                damageMayak(islandsInBattle);// уничтожение маяка
               //printWhoDamagedIsland(listVikingsAndIslands, islandsInBattle); // распечатка кто уничтожил маяк
            }
        }
       } catch (Exception e){
            e.printStackTrace();
       }
    }
    public static void damageMayak (Integer island) {
        Islands.listOfIslands.remove(island); // уничтожается остров на котором была битва
        setOfDamagedIslands.add(island);
        //System.out.println("Должен быть уничтожен остров" +island);
        for (Map.Entry entry : Islands.listOfIslands.entrySet()) {
           ArrayList<Integer> neighborslist = (ArrayList<Integer>) entry.getValue();
            Islands.removeTheNeighbors(neighborslist, island);
            System.out.println("Остров: " + entry.getKey() + " Соседи: "+ entry.getValue());
        }
    }
    public static void printWhoDamagedIsland (Map<Integer, Integer> listVikingsAndIslands, Integer island) {
        ArrayList<Integer> listOfVikingInBattle = new ArrayList<Integer>();
        System.out.println("Кто там че разрушает блять" + island);
        for (Map.Entry<Integer, Integer> pair : listVikingsAndIslands.entrySet()) {
           Integer islandInBattle = pair.getValue();
            Integer VikingInBattle = pair.getKey();
           if(islandInBattle.equals(island)) {
               listOfVikingInBattle.add(VikingInBattle);

           }
           System.out.println("АГР!!! На Остров" + islandInBattle + " уничтожен маяк, благодаря Викинг" +
                   listOfVikingInBattle.get(0)+ " и Викинг"+listOfVikingInBattle.get(1));
        }
    }
    public static void removeVikingIslandBound(Map<Integer, Integer> map, Integer value) {
        Map<Integer, Integer> copy = new HashMap(map);
        for (Map.Entry<Integer, Integer> pair : copy.entrySet()) {

            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
               // System.out.println("АГР!!! На Остров" + islandInBattle + " уничтожен маяк, благодаря Викинг" +
               //         listOfVikingInBattle.get(0)+ " и Викинг"+listOfVikingInBattle.get(1));
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
        boolean isAnybodyMove =true;
        while (isAnybodyMove) {
            // счет дней
            if (countOfDays < 10000) {
                System.out.println("День " + countOfDays);
                for (Map.Entry<Integer, Vikings> pair : listOfVikings.entrySet()) { //движение викингов
                    Vikings vikingToMove = pair.getValue();
                    isAnybodyMove = vikingToMove.moveToIsland();
                }
                //System.out.println("ВСЕ СХОДИЛИ");
                battle(listVikingsAndIslands);
                if (listVikingsAndIslands.isEmpty() || listOfVikings.isEmpty()) {
                    System.out.println("ВСЕ сдохли");
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
       // System.out.println("Теперь столько викингов:" + StartTheGame.listVikingsAndIslands.keySet());
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
