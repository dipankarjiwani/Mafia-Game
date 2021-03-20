import java.util.*;

public class Game<T extends Character> {
    private ArrayList<Character> players;
    private int N;
    private T user;
    private int mode;
    private ArrayList<Mafia> mafias;
    private ArrayList<Detective> detectives;
    private ArrayList<Healer> healers;
    private ArrayList<Commoner> commoners;

    public ArrayList<Character> getPlayers() {
        return players;
    }

    public ArrayList<Commoner> getCommoners() {
        return commoners;
    }

    public ArrayList<Detective> getDetectives() {
        return detectives;
    }

    public ArrayList<Healer> getHealers() {
        return healers;
    }

    public ArrayList<Mafia> getMafias() {
        return mafias;
    }

    public int getMode() {
        return mode;
    }

    Scanner in=new Scanner(System.in);
    Random random=new Random();

    public Game(int N,T obj) {
        players = new ArrayList<Character>(N);
        this.N=N;
        mafias=new ArrayList<>(0);
        detectives=new ArrayList<>(0);
        healers=new ArrayList<>(0);
        commoners=new ArrayList<>(0);
        user = obj;

        if(user.equals(new Mafia(2500,1000))){
            //System.out.println("Sahi");
            int c=0;
            mode=1;
            int z=1;
            //user.playerNO=z;
            z++;
            players.add(user);
            Mafia x=(Mafia)user;
            mafias.add(x);
            for(int i=0;i<(N/5)-1;i++) {
                Mafia m=new Mafia(2500,z);
                //m.playerNO=z;
                z++;
                mafias.add(m);
                players.add(m);
                c++;
            }
            for(int i=0;i<(N/5);i++) {
                Detective d=new Detective(800,z);
                //d.playerNO=z;
                z++;
                detectives.add(d);
                players.add(d);
                c++;
            }
            for (int i=0;i<Math.max(1,N/10);i++){
                Healer h=new Healer(800,z);
                //h.playerNO=z;
                z++;
                healers.add(h);
                players.add(h);
                c++;
            }
            for (int i=0;i<N-c-1;i++){
                Commoner cm=new Commoner(1000,z);
                //cm.playerNO=z;
                z++;
                commoners.add(cm);
                players.add(cm);
            }
        }
        else if (user.equals(new Detective(800,100))){
            int c=0;
            mode=2;
            int z=1;
            //user.playerNO=z;
            z++;
            players.add(user);
            Detective x=(Detective) user;
            detectives.add(x);
            for(int i=0;i<(N/5);i++) {
                Mafia m=new Mafia(2500,z);
                //m.playerNO=z;
                z++;
                mafias.add(m);
                players.add(m);
                c++;
            }
            for(int i=0;i<(N/5)-1;i++) {
                Detective d=new Detective(800,z);
                //d.playerNO=z;
                z++;
                detectives.add(d);
                players.add(d);
                c++;
            }
            for (int i=0;i<Math.max(1,N/10);i++){
                Healer h=new Healer(800,z);
                //h.playerNO=z;
                z++;
                healers.add(h);
                players.add(h);
                c++;
            }
            for (int i=0;i<N-c-1;i++){
                Commoner cm=new Commoner(1000,z);
                //cm.playerNO=z;
                z++;
                commoners.add(cm);
                players.add(cm);
            }
        }
        else if (user.equals(new Healer(800,100))){
            int c=0;
            mode=3;
            int z=1;
            //user.playerNO=z;
            z++;
            players.add(user);
            Healer x=(Healer) user;
            healers.add(x);
            for(int i=0;i<(N/5);i++) {
                Mafia m=new Mafia(2500,z);
                //m.playerNO=z;
                z++;
                mafias.add(m);
                players.add(m);
                c++;
            }
            for(int i=0;i<(N/5);i++) {
                Detective d=new Detective(800,z);
                //d.playerNO=z;
                z++;
                detectives.add(d);
                players.add(d);
                c++;
            }
            for (int i=0;i<Math.max(1,N/10)-1;i++){
                Healer h=new Healer(800,z);
                //h.playerNO=z;
                z++;
                healers.add(h);
                players.add(h);
                c++;
            }
            for (int i=0;i<N-c-1;i++){
                Commoner cm=new Commoner(1000,z);
                //cm.playerNO=z;
                z++;
                commoners.add(cm);
                players.add(cm);
            }
        }
        else {
            int c=0;
            mode=4;
            int z=1;
            //user.playerNO=z;
            z++;
            players.add(user);
            Commoner x=(Commoner) user;
            commoners.add(x);
            for(int i=0;i<(N/5);i++) {
                Mafia m=new Mafia(2500,z);
                //m.playerNO=z;
                z++;
                mafias.add(m);
                players.add(m);
                c++;
            }
            for(int i=0;i<(N/5);i++) {
                Detective d=new Detective(800,z);
                //d.playerNO=z;
                z++;
                detectives.add(d);
                players.add(d);
                c++;
            }
            for (int i=0;i<Math.max(1,N/10);i++){
                Healer h=new Healer(800,z);
                //h.playerNO=z;
                z++;
                healers.add(h);
                players.add(h);
                c++;
            }
            for (int i=0;i<N-c-1;i++){
                Commoner cm=new Commoner(1000,z);
                //cm.playerNO=z;
                z++;
                commoners.add(cm);
                players.add(cm);
            }
        }
    }
    public boolean checker(){
        int mafi=0;
        int others=0;
        for(int i=0;i<mafias.size();i++){
            if(mafias.get(i).isInGame()==true){
                mafi++;
            }
        }
        for(int i=0;i<players.size();i++){
            if(!(players.get(i).equals(new Mafia(2500,100))) && players.get(i).isInGame()==true){
                others++;
            }
        }
        if(mafi>=others){
            return false;
        }
        else {
            return true;
        }
    }
    public boolean mafiaIsPresent(){
        for(int i=0;i<mafias.size();i++){
            if(mafias.get(i).isInGame()==true){
                return true;
            }
        }
        return false;
    }
    public void gameOver(){
        if(this.mafiaIsPresent()){
            System.out.println("Game over");
            System.out.println("Mafias have won the game");
        }
        else{
            System.out.println("Game over");
            System.out.println("Mafias have lost the game");
        }
        for (int i=0;i<mafias.size();i++){
            if(mafias.get(i).getPlayerNO()==1){
                System.out.print("Player "+mafias.get(i).getPlayerNO()+"[User], ");
            }
            else{
                System.out.print("Player "+mafias.get(i).getPlayerNO()+", ");
            }
        }
        System.out.println("are Mafias");

        for (int i=0;i<detectives.size();i++){
            if(detectives.get(i).getPlayerNO()==1){
                System.out.print("Player "+detectives.get(i).getPlayerNO()+"[User], ");
            }
            else{
                System.out.print("Player "+detectives.get(i).getPlayerNO()+", ");
            }
        }
        System.out.println("are Detectives");

        for (int i=0;i<healers.size();i++){
            if(healers.get(i).getPlayerNO()==1){
                System.out.print("Player "+healers.get(i).getPlayerNO()+"[User], ");
            }
            else{
                System.out.print("Player "+healers.get(i).getPlayerNO()+", ");
            }
        }
        System.out.println("are Healers");

        for (int i=0;i<commoners.size();i++){
            if(commoners.get(i).getPlayerNO()==1){
                System.out.print("Player "+commoners.get(i).getPlayerNO()+"[User], ");
            }
            else{
                System.out.print("Player "+commoners.get(i).getPlayerNO()+", ");
            }
        }
        System.out.println("are Commoners");
    }
    public void playgame(int x){
        System.out.println("Round: "+x+"-----");
        //System.out.println("There are "+N+" players");
        int count=0;
        for(int i=0;i<players.size();i++){
            if(players.get(i).isInGame()==true){
                System.out.print("Player "+players.get(i).getPlayerNO()+", ");
                count++;
            }
        }
        System.out.println(" are in the game");
        System.out.println(count+" players are in the game");

        int f1=mafias.get(0).choose(mode,mafias,detectives,healers,commoners,players);


        int f2=healers.get(0).choose(mode,mafias,detectives,healers,commoners,players);


        int playerDetectiveremoved=detectives.get(0).choose(mode,mafias,detectives,healers,commoners,players);


        System.out.println("--End of actions--");
        int flag=0;
        for(int i=0;i<players.size();i++){
            //System.out.println(players.get(i).playerNO+"inka hp "+players.get(i).HP);
            if(!(players.get(i).equals(new Mafia(2500,100))) && players.get(i).HP<=0 && players.get(i).isInGame()==true){//
                players.get(i).setInGame(false);
                System.out.println("Player "+(i+1)+" Was removed by mafia");
                flag=1;
            }
        }
        if(flag==0){
            System.out.println("Mafia could not remove anyone");
        }
        for(int i=0;i<players.size();i++){//setting all votes to 0 before voting round
            players.get(i).setVotes(0);
        }

        if(playerDetectiveremoved>0){
            System.out.println(playerDetectiveremoved+" was voted out");
        }
        else if (players.get(0).isInGame()==true){
            //System.out.println("Idhar aya");
            int flag1=0;
            int k=0;
            ArrayList<Character> listforvote=(ArrayList)players.clone();//creating a shallow copy,object references would be same
            while (flag1==0 && k<4){//taking votes until tie
                k++;
                System.out.println("Select player to vote out: ");
                int z=in.nextInt();//if it is already removed
                while( z>N || z<0 || players.get(z-1).isInGame()==false ){
                    System.out.println("That player has already been voted out, type again");
                    z=in.nextInt();
                }
                players.get(z-1).votes+=1;
                for(int i=0;i<players.size();i++){
                    if(players.get(i).isInGame()==true){
                        players.get(i).vote(players);//handles the case in the function itself of voting for person who is present in game
                    }
                }
                Collections.sort(listforvote,new Charecterscompare());
                if(listforvote.get(0).getVotes()==listforvote.get(1).getVotes()){
                    flag1=1;
                }
            }
            listforvote.get(0).setInGame(false);
            System.out.println("The voted out player is "+listforvote.get(0).getPlayerNO());

            /*int z1=random.nextInt(players.size());
            while(players.get(z1).inGame==false){
                //System.out.println("That player has already been voted out, type again");
                z1=random.nextInt(players.size());
            }
            players.get(z1).inGame=false;//removing the randomly choosen player
            System.out.println("The voted out player is "+players.get(z1).playerNO);*/


        }
        else {

            int z1=random.nextInt(players.size());
            while(players.get(z1).isInGame()==false){
                //System.out.println("That player has already been voted out, type again");
                z1=random.nextInt(players.size());
            }
            players.get(z1).setInGame(false);//removing the randomly choosen player
            System.out.println("The voted out player is "+players.get(z1).getPlayerNO());
        }
        System.out.println("End of Round-------");

    }


    public static void main(String[] args){

        Scanner in=new Scanner(System.in);
        Random random=new Random();

        System.out.println("Enter Number of players: ");
        int N=in.nextInt();
        while(N<6){
            System.out.println("Invalid input, enter again:");
            N=in.nextInt();
        }
        int c=1;
        do {
            if(c==1) {
                System.out.println("Choose a Character:");
                System.out.println("1) Mafia");
                System.out.println("2) Detective");
                System.out.println("3) Healer");
                System.out.println("4) Commoner");
                System.out.println("5) Assign Randomly");
                c = in.nextInt();
            }
            else{
                System.out.println("Please enter a Valid Input");
                c=in.nextInt();
            }
        }while (c<=0 || c>=6);
        int x1=1;
        if(c==1){
            //User<Mafia> user=new User<Mafia>();
            Game game=new Game<Mafia>(N,new Mafia(2500,1));
            while (game.checker() && game.mafiaIsPresent()){
                game.playgame(x1);
                x1++;
            }
            game.gameOver();
        }
        else if(c==2){
            //User<Detective> user=new User<Detective>();
            Game game=new Game<Detective>(N,new Detective(800,1));
            while (game.checker() && game.mafiaIsPresent()){
                game.playgame(x1);
                x1++;
            }
            game.gameOver();
        }
        else if(c==3){
            //User<Healer> user=new User<Healer>();
            Game game=new Game<Healer>(N,new Healer(1000,1));
            while (game.checker() && game.mafiaIsPresent()){
                game.playgame(x1);
                x1++;
            }
            game.gameOver();
        }
        else if (c==4){
            //User<Commoner> user=new User<Commoner>();
            Game game=new Game<Commoner>(N,new Commoner(1000,1));
            while (game.checker() && game.mafiaIsPresent()){
                game.playgame(x1);
                x1++;
            }
            game.gameOver();
        }
        else{
            int x=random.nextInt(4);
            if(x==0){
                //User<Mafia> user=new User<Mafia>();
                Game game=new Game<Mafia>(N,new Mafia(2500,1));
                System.out.println("You are Mafia");
                while (game.checker() && game.mafiaIsPresent()){
                    game.playgame(x1);
                    x1++;
                }
                game.gameOver();
            }
            else if(x==1){
                //User<Detective> user=new User<Detective>();
                Game game=new Game<Detective>(N,new Detective(800,1));
                System.out.println("You are Detective");
                while (game.checker() && game.mafiaIsPresent()){
                    game.playgame(x1);
                    x1++;
                }
                game.gameOver();
            }
            else if(x==2){
                //User<Healer> user=new User<Healer>();
                Game game=new Game<Healer>(N,new Healer(1000,1));
                System.out.println("You are Healer");
                while (game.checker() && game.mafiaIsPresent()){
                    game.playgame(x1);
                    x1++;
                }
                game.gameOver();
            }
            else {
                //User<Commoner> user=new User<Commoner>();
                Game game=new Game<Commoner>(N,new Commoner(1000,1));
                System.out.println("You are Commoner");
                while (game.checker() && game.mafiaIsPresent()){
                    game.playgame(x1);
                    x1++;
                }
                game.gameOver();
            }
        }




    }
}
