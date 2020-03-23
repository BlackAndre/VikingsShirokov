import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.*;

public class Vikings {
    private int place;
    private int name;

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void moveToIsland() {
        ArrayList<Integer> listOfIslandsToMove = Islands.listOfIslands.get(this.getPlace());
        System.out.println("Викинг " + getName() +" может сходить на острова: " + listOfIslandsToMove);
        int countOfNeighbors = new Random().nextInt(listOfIslandsToMove.size());
        this.place = listOfIslandsToMove.get(countOfNeighbors);
        System.out.println("Викинг" + this.name + " переехал на остров" + this.place);
        StartTheGame.listVikingsAndIslands.put(name, place);
    }
}