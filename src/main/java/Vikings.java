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
        if (listOfIslandsToMove.size() != 0) {
            System.out.println("Викинг " + getName() + " может сходить на острова: " + listOfIslandsToMove);
            int randomNeighbor = new Random().nextInt(listOfIslandsToMove.size());
            this.place = listOfIslandsToMove.get(randomNeighbor);
            System.out.println("Викинг" + this.name + " переехал на остров" + this.place);
            StartTheGame.listVikingsAndIslands.put(name, place);
        } else {
            System.out.println("АГР!!! Викинг" + getName() + " застрял на Острове" + getPlace() + " и больше не участвует в войне");
        }
    }
}