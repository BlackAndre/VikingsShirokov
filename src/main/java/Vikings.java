import java.util.Map;

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

    public void moveToIsland (){
        int listOfIslandsToMove= Islands.listOfIslands.get(getPlace()).size();
        System.out.println("На сколько островов Викинг" + this.name + " может сходить: " + listOfIslandsToMove);
        this.place = 1+ (int) (Math.random()*listOfIslandsToMove);
        System.out.println("Викинг" + this.name + " переехали на остров" + this.place);
    }
    public void battle (Vikings anotherVikings) {
        for (Map.Entry<Vikings, Integer> currentViking : StartTheGame.listOfVikings.entrySet()) {
            if(this.getName() != anotherVikings.getName()){
                Islands.listOfIslands.remove(one.getPlace());
                StartTheGame.listOfVikings.remove(one.getName());
                StartTheGame.listOfVikings.remove(two.getName());
        }

        }
    }
}
