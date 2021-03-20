import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Mafia extends Character {

    Random random=new Random();
    public Mafia(int HP,int id){
        super(HP,id);
    }


    @Override
    public int choose(int Mode, ArrayList<Mafia> mafias, ArrayList<Detective> detectives, ArrayList<Healer> healers, ArrayList<Commoner> commoners, ArrayList<Character> players) {
        Scanner in=new Scanner(System.in);
        int flag=0;
        for(int i=0;i<mafias.size();i++){//to check if any mafias are present in game
            if(mafias.get(i).inGame==true){
                flag=1;
            }
        }
        if(Mode==1 && flag==1 && players.get(0).inGame==true){
            System.out.println("Choose a target:");
            int pTd=in.nextInt();
            while(players.get(pTd-1).inGame==false || players.get(pTd-1).equals(new Mafia(2500,100)) || pTd>players.size() || pTd<=0){//asking again and again for valid input
                System.out.println("Invalid input, Choose a target again:");
                pTd=in.nextInt();
            }
            Character target=players.get(pTd-1);
            int totalHP=0;
            int alivemafia=0;
            for(int i=0;i<mafias.size();i++){
                if(mafias.get(i).inGame==true){
                    totalHP+=mafias.get(i).HP;
                    alivemafia++;
                }
            }
            if(totalHP>=players.get(pTd-1).HP){
                int share=players.get(pTd-1).HP/alivemafia;
                int rem=0;

                while(target.HP>0){
                    int assetmafia=0;
                    for(int i=0;i<mafias.size();i++){
                        if(mafias.get(i).HP>share && mafias.get(i).inGame==true ){
                            mafias.get(i).HP-=share;
                            target.HP-=share;
                            assetmafia++;
                        }
                        else if (mafias.get(i).HP==share && mafias.get(i).inGame==true){
                            mafias.get(i).HP-=share;
                            target.HP-=share;
                        }
                        else if (mafias.get(i).inGame==true && mafias.get(i).HP>0){
                            //rem=rem+(share-mafias.get(i).HP);
                            target.HP-=mafias.get(i).HP;
                            mafias.get(i).HP=0;
                        }
                    }
                    //int remshare=target.HP/assetmafia;
                    share=target.HP/assetmafia;
                    /*for(int i=0;i<mafias.size();i++){
                        if(mafias.get(i).HP!=0){
                            mafias.get(i).HP-=remshare;
                        }
                    }*/
                }

               // players.get(pTd-1).HP=0;
            }
            else{
                //the combined HPs of mafias is less than target
                target.HP-=totalHP;
                for (int i=0;i<mafias.size();i++){//all the mafias get their HP used
                    mafias.get(i).HP=0;
                }
            }
        }
        else if(flag==1){//when user has been removed or user is not mafia
            int pTd=random.nextInt(players.size());
            while(players.get(pTd).inGame==false || players.get(pTd).equals(new Mafia(2500,100))){
                //System.out.println("That player has already been voted out, type again");
                pTd=random.nextInt(players.size());
            }
            Character target=players.get(pTd);
            int totalHP=0;
            int alivemafia=0;
            for(int i=0;i<mafias.size();i++){
                if(mafias.get(i).inGame==true){
                    totalHP+=mafias.get(i).HP;
                    alivemafia++;
                }
            }
            if(totalHP>=players.get(pTd).HP){
                int share=players.get(pTd).HP/alivemafia;
                int rem=0;

                while(target.HP>0){
                    int assetmafia=0;
                    for(int i=0;i<mafias.size();i++){
                        if(mafias.get(i).HP>share && mafias.get(i).inGame==true ){
                            mafias.get(i).HP-=share;
                            target.HP-=share;
                            assetmafia++;
                        }
                        else if (mafias.get(i).HP==share && mafias.get(i).inGame==true){
                            mafias.get(i).HP-=share;
                            target.HP-=share;
                        }
                        else if (mafias.get(i).inGame==true && mafias.get(i).HP>0){
                            //rem=rem+(share-mafias.get(i).HP);
                            target.HP-=mafias.get(i).HP;
                            mafias.get(i).HP=0;
                        }
                    }
                    //int remshare=target.HP/assetmafia;
                    share=target.HP/assetmafia;
                    /*for(int i=0;i<mafias.size();i++){
                        if(mafias.get(i).HP!=0){
                            mafias.get(i).HP-=remshare;
                        }
                    }*/
                }

                // players.get(pTd-1).HP=0;
            }
            else{
                //the mafias have total HP less than target
                target.HP-=totalHP;
                for (int i=0;i<mafias.size();i++){//all the mafias get their HP used
                    mafias.get(i).HP=0;
                }
            }
            System.out.println("Mafias have chosen someone to kill");
        }
        else{//when no mafias are left in the game
            System.out.println("Mafias have chosen someone to kill");
        }
        return 0;
    }
}
