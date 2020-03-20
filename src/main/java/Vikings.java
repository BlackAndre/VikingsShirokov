import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vikings {
    private int place;
    private int count;

    public void moorToIsland (int island) {
        this.place =  (int) (Math.random()*island);
        System.out.println("Мы высадились на " + place + " епта");
    }
    public void moveToIsland (int howManyIslandLeft){
        place =  (int) (Math.random()*howManyIslandLeft);

    }

}
