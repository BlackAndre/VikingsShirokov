import java.util.*;

public class tmp {
    private int size = 6;
    private int place;
    List<Integer> list=new ArrayList();
    Set<Integer> set=new LinkedHashSet(list);
    //внутри сета теперь ,"a","b"
    public void moorToIsland (int island) {
        this.place =  (int) (Math.random()*island);
        System.out.println("Мы высадились на " + place + " епта");
    }

    public static void main(String[] args) {
    //    rand();
    }

    //List<String> list=new ArrayList<>("a","a","b");
    //Set<String> set=new LinkedHashSet<>(list);

}

