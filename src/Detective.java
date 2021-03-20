import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Detective extends Character {
    Random random=new Random();
    Scanner in=new Scanner(System.in);
    public Detective(int HP,int id){
        super(HP,id);
    }
    @Override
    public int choose(int Mode, ArrayList<Mafia> mafias, ArrayList<Detective> detectives, ArrayList<Healer> healers, ArrayList<Commoner> commoners, ArrayList<Character> players) {
        int flag=0;
        for(int i=0;i<detectives.size();i++){
            if(detectives.get(i).inGame==true){
                flag=1;
            }
        }
        if(flag==1 && Mode==2 && players.get(0).inGame==true){
            System.out.println("Select player to test:");
            int pTd=in.nextInt();
            while(players.get(pTd-1).inGame==false || players.get(pTd-1).equals(new Detective(800,100)) || pTd>players.size() || pTd<1){//until wrong inputs
                System.out.println("Invalid input,Choose a player to test again:");
                pTd=in.nextInt();
            }
            if(players.get(pTd-1).equals(new Mafia(2500,100))){
                System.out.println("Chosen player is Mafia");
                players.get(pTd-1).setInGame(false);
                return pTd;
            }
            else if (players.get(pTd-1).equals(new Healer(800,100))){
                System.out.println("Chosen player is Healer");
            }
            else{
                System.out.println("Chosen player is Commoner");
            }
            return 0;
        }
        else if(flag==1){//when user is not detective and detectives are still in the game
            int x1=random.nextInt(3);
            int x2;
            int isMafia=0;
            if(x1==0){
                x2=random.nextInt(mafias.size());//x2 stores the index of the mafia,detectives has chosen to check
                isMafia=1;
            }
            else if(x1==1){
                x2=random.nextInt(healers.size());
            }
            else{
                x2=random.nextInt(commoners.size());
            }
            System.out.println("Detectives have chosen someone to test");
            return 0;
        }
        else {//when no detectives are left in the game
            System.out.println("Detectives have chosen someone to test");
            return 0;
        }
    }
}
