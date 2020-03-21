import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class StartTheGame {
    private static int count = 0;
    private static ArrayList<Vikings> listOfVikings= new ArrayList();
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
            vikings.moorToIsland(i,Islands.getIsland(i));
            listOfVikings.add(vikings);
        }
    }
    private static void WarIsOn (){
        War vikingsWar = new War();
        firstMoor();
        for (int i = 0; i < 10000; i++) { // счет дней
            System.out.println(listOfVikings.size());
            for (int j = 0; j < listOfVikings.size(); j++) { // все ли викинги сходили
                listOfVikings.get(j).moveToIsland(Islands.getCount().size());
                System.out.println(555555);
               // vikingsWar.battle();
            }
            //vikingsWar.battle();
        }
    }

    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        howMuchVikings();
        WarIsOn();
    }
}
