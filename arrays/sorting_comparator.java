import java.util.Comparator;

public class sorting_comparator implements Comparator<Player> {

    public int compare(Player a, Player b) {
        if(a.score == b.score) {
            return a.name.compareTo(b.name);
        }
        if(a.score > b.score) return -1;
        return 1;
    }
}

class Player {
    String name;
    int score;
}
