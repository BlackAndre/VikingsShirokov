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

}
