import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vikings {
    private int place;
    private int count;

    public void moorToIsland (int count, int island) {
        this.place =  island;
        System.out.println("Викинг"+count+" высадился на Остров" + place + " епта!!");
    }
    public void moveToIsland (int howManyIslandLeft){
        place =  (int) (Math.random()*howManyIslandLeft);
    }
    //public void battle ()
}
