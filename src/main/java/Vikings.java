import java.util.*;

public class Vikings {
    // where the viking is
    private int place;
    // name of the viking
    private int name;
    public Vikings (int name, int place) {
        this.name = name;
        this.place = place;
    }
    public int getPlace() {
        return place;
    } // getter of the place
    public void setPlace(int place) {
        this.place = place;
    } // setter of the place
    public int getName() {
        return name;
    } // getter of the name
    public void setName(int name) {
        this.name = name;
    } // setter of the name
    public boolean moveToIsland() { // the method that allows the viking to move
        ArrayList<Integer> listOfIslandsToMove = Islands.listOfIslands.get(getPlace()); // array of the islands which is
                                                                                        // available to move for current viking
        if (listOfIslandsToMove.size() != 0) { // if there is available islands to move
            // System.out.println("Викинг " + getName() + " может сходить на острова: " + listOfIslandsToMove);
            int randomNeighbor = new Random().nextInt(listOfIslandsToMove.size()); // random move on available island
            setPlace(listOfIslandsToMove.get(randomNeighbor)); // use setter
            //System.out.println("Викинг" + getName() + " переехал на остров" + getPlace());
            StartTheWar.listVikingsAndIslands.put(getName(), getPlace()); // create the bound between island and vikings
            return true;
        } else {
            System.out.println("АГР!!! Викинг" + getName() + " застрял на Острове" + getPlace() + " и больше не участвует в войне");
        return false;
        }
    }
}