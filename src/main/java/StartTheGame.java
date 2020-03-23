import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StartTheGame {
    private static int count = 0;
    public static Map<Integer, Vikings> listOfVikings= new HashMap<Integer, Vikings>();
    public static Map<Integer, Integer> listVikingsAndIslands = new HashMap<Integer, Integer>();
    public static void howMuchVikings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int num = Integer.parseInt(name);
        count = num;
        reader.close();
    }
    private static void firstMoor() {

        for (int i = 1; i < count+1; i++) {
            Vikings vikings = new Vikings();
            vikings.setName(i);
            vikings.setPlace(Islands.getIsland(i));
            listOfVikings.put(vikings.getName(),vikings);
            listVikingsAndIslands.put(vikings.getName(),vikings.getPlace());
            System.out.println("Викинг" + vikings.getName() + " высадился на остров" + vikings.getPlace());
        }
    }
    public static void battle (Map<Integer, Integer> map) {
        List<Integer> islands = new ArrayList(); // перегоняем map в list
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            islands.add(pair.getValue()); //в list записываем только острова(value из map)
        }
        Collections.sort(islands); // выравниваем местоположение викингов по возрастанию
        for (int i = 1; i < islands.size(); i++) {
            if (islands.get(i).equals(islands.get(i - 1))) {
                System.out.println("Повтор найден, началась битва!!");//проверяем есть ли подряд повторы
                killVikings(map, islands.get(i)); // если на острове есть несколько викингов - убиваем их и
                damageMayak(islands.get(i));      // разрушаем  маяк
            }
        }

    }
    public static void damageMayak (Integer island) {
        Islands.listOfIslands.remove(island);
        System.out.println("Должен быть уничтожен остров" +island);
    }
    public static void killVikings (Map<Integer, Integer> map, Integer value) {
        Map<Integer, Integer> copy = new HashMap(map);
        for (Map.Entry<Integer, Integer> pair : copy.entrySet()) {
            if (pair.getValue().equals(value)) {
                map.remove(pair.getKey());
                listOfVikings.remove(pair.getKey());
            }
        }
    }
    private static void WarIsOn () {
        firstMoor();
        for (int i = 0; i < 3; i++) { // счет дней
            System.out.println("День " + i);
            for (Map.Entry<Integer, Vikings> pair : listOfVikings.entrySet()) { //движение викингов
                Vikings vikingToMove = pair.getValue();
                vikingToMove.moveToIsland();
            }

            for (Map.Entry<Integer, Vikings> battleOfVikings : listOfVikings.entrySet()) { // битва викингов
                Vikings vikingToBattle = battleOfVikings.getValue();
                battle(listVikingsAndIslands);
            }
        }
        if (listVikingsAndIslands.isEmpty()) {
            System.out.println("ВСЕ сдохли");
        } else {
            printCurrentMap();
        }
    }

    private static void printCurrentMap() {
        System.out.println("Теперь столько викингов:" + StartTheGame.listVikingsAndIslands.keySet());
        System.out.println("Теперь столько островов:" + StartTheGame.listVikingsAndIslands.values());
        System.out.println("Викинг и острова "+ StartTheGame.listVikingsAndIslands);
    }


    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        howMuchVikings();
        WarIsOn();
    }
}
