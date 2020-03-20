import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StartTheGame {
    private static int count = 0;
    public static void howMuchVikings() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String name = reader.readLine();
            int num = Integer.parseInt(name);
            count = num;
    }
    private static void firstMoor() {
        for (int i = 0; i < count; i++) {
            Vikings vikings = new Vikings();
            vikings.moorToIsland(Islands.getCount());
        }
    }
    public static void main (String[]args) throws IOException {
        Islands.fileReader();
        howMuchVikings();
        firstMoor();
    }
}
