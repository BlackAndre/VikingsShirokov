import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

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

    public void moorToIsland (int countOfViking, int island) {
        this.place =  island + 1;
        System.out.println("Викинг"+countOfViking+" высадился на Остров" + place + " епта!!");
    }
    public void moveToIsland (){
        int listOfIslandsToMove= Islands.listOfIslands.get(getPlace()).size();
        System.out.println("На сколько островов я магу ссходить: " + listOfIslandsToMove);
        this.place = (int) (Math.random()*listOfIslandsToMove);
        System.out.println("Викинг переехали на остров" + this.place);
    }

}
