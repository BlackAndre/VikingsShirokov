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

    public void moveToIsland() {
        int listOfIslandsToMove = Islands.listOfIslands.get(this.getPlace()).size();
        //System.out.println("На сколько островов Викинг" + this.name + " может сходить: " + listOfIslandsToMove);
        this.place = 1 + (int) (Math.random() * (listOfIslandsToMove + 1));
        System.out.println("Викинг" + this.name + " переехали на остров" + this.place);
    }

    public void battle() {
        for (Map.Entry<Vikings, Integer> otherVikings : StartTheGame.listOfVikings.entrySet()) { // битва викингов
            Vikings anotherViking = otherVikings.getKey();
            if (this.getName() != anotherViking.getName()) {
                System.out.println("Викинг"+ this.getName() + " против Викинг" + anotherViking.getName());

                if (this.getPlace() == anotherViking.getPlace()) {
                    System.out.println("НАЧАЛАСЬ БИТВА!!!!!");
                    Islands.listOfIslands.remove(this.getPlace());
                    StartTheGame.listOfVikings.remove(this.getName());
                   // StartTheGame.listOfVikings.remove(anotherViking.getName());
                }
            } else {
                //System.out.println("Битвы не было");
            }
        }
    }
}