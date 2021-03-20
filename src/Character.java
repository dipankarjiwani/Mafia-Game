import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public abstract class Character {
    Random random=new Random();
    protected int HP;
    protected final int playerNO;
    protected boolean inGame;
    protected int votes;
    public void vote(ArrayList<Character> players) {
        int z=random.nextInt(players.size());
        while(players.get(z).inGame==false){
            z=random.nextInt(players.size());
        }
        players.get(z).votes+=1;
    }
    public abstract int choose(int Mode, ArrayList<Mafia> mafias,ArrayList<Detective> detectives,ArrayList<Healer> healers,ArrayList<Commoner> commoners, ArrayList<Character> players);
    public Character(int HP,int playerNO){
        this.HP=HP;
        inGame=true;
        this.playerNO=playerNO;
        votes=0;
    }

    public int getHP() {
        return HP;
    }

    public boolean isInGame() {
        return inGame;
    }

    public int getPlayerNO() {
        return playerNO;
    }

    public int getVotes() {
        return votes;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }



    public void setVotes(int votes) {
        this.votes = votes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Character character = (Character) o;
        return this.getClass()==o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(HP, playerNO, inGame, votes);
    }
}
