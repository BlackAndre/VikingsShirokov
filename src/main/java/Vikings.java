import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Vikings {
    private int place;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public void moorToIsland (int count, int island) {
        this.place =  island + 1;
        System.out.println("Викинг"+count+" высадился на Остров" + place + " епта!!");
    }
    public void moveToIsland (int place){
        int listOfIslandsToMove= Islands.listOfIslands.get(getPlace()).size();
        this.place = (int) (Math.random()*listOfIslandsToMove);
        System.out.println("Мы переехали на остров" + place);
    }

}
