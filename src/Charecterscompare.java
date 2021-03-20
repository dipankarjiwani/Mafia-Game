import java.util.Comparator;

public class Charecterscompare implements Comparator<Character> {
    @Override
    public int compare(Character o1, Character o2) {
        return o2.getVotes()-o1.getVotes();
    }
}
