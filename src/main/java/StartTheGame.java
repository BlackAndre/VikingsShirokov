import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StartTheGame {
    private static int count = 0;
    private static Map<Vikings, Integer> listOfVikings= new HashMap<Vikings, Integer>();
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
            listOfVikings.put(vikings,vikings.getPlace());
            System.out.println("Викинг" + vikings.getName() + " высадился на остров" + vikings.getPlace());
        }
    }
    private static void WarIsOn (){
        War vikingsWar = new War();
        firstMoor();
        System.out.println("Столько у нас викингов: " + listOfVikings.size());
        for (int i = 0; i < 1; i++) { // счет дней
            for(Map.Entry<Vikings, Integer> pair : listOfVikings.entrySet()) {
                Vikings viking = pair.getKey();
                viking.moveToIsland();
            }
        }

    }


    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        howMuchVikings();
        WarIsOn();
    }
}
