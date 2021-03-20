import java.util.ArrayList;
import java.util.Random;

public class Commoner extends Character {
    Random random=new Random();
    public Commoner(int HP,int id){
        super(HP,id);
    }

    @Override
    public int choose(int Mode, ArrayList<Mafia> mafias, ArrayList<Detective> detectives, ArrayList<Healer> healers, ArrayList<Commoner> commoners, ArrayList<Character> players) {
        return 0;
    }
}
