import java.util.*;

public class Viking {
    // where the viking is
    private int place;
    // name of the viking
    private int name;
    public Viking(int name, int place) {
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

    // the method that allows the viking to move
    public boolean moveToIsland() {
        // array of the islands which is available to move for current viking
        ArrayList<Integer> listOfIslandsToMove = Islands.listOfIslands.get(getPlace());
        // if there is available islands to move
        if (listOfIslandsToMove.size() != 0) {
            //System.out.println("The viking " + getName() + " can move on islands: " + listOfIslandsToMove);
            // random move on available island
            int randomNeighbor = new Random().nextInt(listOfIslandsToMove.size());
            // the viking is moving on random neighboring island
            setPlace(listOfIslandsToMove.get(randomNeighbor));
           // System.out.println("The viking" + getName() + " moved on island" + getPlace());
            // create the bound between island and vikings
            StartTheWar.listVikingsAndIslands.put(getName(), getPlace());
            return true;
        } else {
            System.out.println("АГР!!! Викинг" + getName() + " застрял на Острове" + getPlace() + " и больше не участвует в войне");
        return false;
        }
    }
}