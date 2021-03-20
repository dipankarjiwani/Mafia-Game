import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Healer extends Character {
    Random random=new Random();
    Scanner in=new Scanner(System.in);
    public Healer(int HP,int id){
        super(HP,id);
    }

    @Override
    public int choose(int Mode, ArrayList<Mafia> mafias, ArrayList<Detective> detectives, ArrayList<Healer> healers, ArrayList<Commoner> commoners, ArrayList<Character> players) {
        int flag=0;
        for (int i=0;i<healers.size();i++){
            if(healers.get(i).inGame==true){
                flag=1;
            }
        }

        if(Mode==3 && flag==1 && players.get(0).inGame==true) {
            System.out.println("Choose a player to heal:");
            int pTd=in.nextInt();
            while(players.get(pTd-1).inGame==false || pTd>players.size() || pTd<1){
                System.out.println("Invalid input,Choose a healer to heal:");
                pTd=in.nextInt();
            }
            players.get(pTd-1).HP+=500;
            //System.out.println("Healers have healed someone");
        }
        else if (flag==1){
            int y1=random.nextInt(players.size());
            while(players.get(y1).inGame==false){
                y1=random.nextInt(players.size());
            }
            players.get(y1).HP+=500;
            //System.out.println("Chosen healer"+players.get(y1).playerNO);

            /*int y2;
            if(y1==0){
                y2=random.nextInt(mafias.size());//x2 stores the index of the mafia,detectives has chosen to check
                mafias.get(y2).HP+=500;
            }
            else if(y1==1){
                y2=random.nextInt(detectives.size());
                detectives.get(y2).HP+=500;
            }
            else if(y1==2){
                y2=random.nextInt(healers.size());
                healers.get(y2).HP+=500;
            }
            else{
                y2=random.nextInt(commoners.size());
                commoners.get(y2).HP+=500;
            }*/
            System.out.println("Healers have healed someone");
        }
        else{
            System.out.println("Healers have healed someone");
        }
        return 0;

    }
}
