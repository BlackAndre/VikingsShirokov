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
    public boolean moveToIsland() {
        ArrayList<Integer> listOfIslandsToMove = Islands.listOfIslands.get(getPlace());
        if (listOfIslandsToMove.size() != 0) {
            System.out.println("Викинг " + getName() + " может сходить на острова: " + listOfIslandsToMove);
            int randomNeighbor = new Random().nextInt(listOfIslandsToMove.size());
            setPlace(listOfIslandsToMove.get(randomNeighbor));
            System.out.println("Викинг" + getName() + " переехал на остров" + getPlace());
            StartTheWar.listVikingsAndIslands.put(getName(), getPlace());
            return true;
        } else {
            System.out.println("АГР!!! Викинг" + getName() + " застрял на Острове" + getPlace() + " и больше не участвует в войне");
        return false;
        }
    }
}