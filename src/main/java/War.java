public class War {
    public void battle (Vikings one, Vikings two) {
        if(one.getPlace() == two.getPlace()){
            Islands.listOfIslands.remove(one.getPlace());
            StartTheGame.listOfVikings.remove(one.getName());
            StartTheGame.listOfVikings.remove(two.getName());
        }
    }
}
