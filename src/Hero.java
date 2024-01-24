import java.util.Random;

public class Hero {
    private String name;
    private int hitPoints = 100;
    public Hero(String name){
        this.name = name;
        this.hitPoints = 100;
    }
    public String getName(){
        return this.name;
    }
    public int getHitPoints(){
        return this.hitPoints;
    }
    public String toString(){
        return("Hero{name='" + this.name + "', hitPoints=" + this.hitPoints + "}");
    }
    public void attack(Hero opponent){
    Random random = new Random();
    double randomCheck = random.nextDouble(1.00);
    if(randomCheck<0.5){
        opponent.hitPoints-=10;
    }
    else if(randomCheck>=0.5){
        this.hitPoints-=10;
    }
    }
    public void senzuBean(){
        this.hitPoints=100;
    }
    private void fightUntilTheDeathHelper(Hero opponent){
        while(this.hitPoints>0 && opponent.getHitPoints()>0){
            attack(opponent);
        }
    }
    public String fightUntilTheDeath(Hero opponent){
        senzuBean();
        opponent.senzuBean();
        fightUntilTheDeathHelper(opponent);
        return(this.name + ": " + this.hitPoints + "        " + opponent.getName() + ": " + opponent.getHitPoints());
    }
    private int[] nFightsToTheDeathHelper(Hero opponent, int n){
        int[] winCount = {0, 0};
        for(int i = 0; i<n; i++){
            fightUntilTheDeathHelper(opponent);
            if(this.hitPoints==0){
                winCount[1] = winCount[1] + 1;
            }
            else if(opponent.getHitPoints()==0){
                winCount[0] = winCount[0] + 1;
            }
            senzuBean();
            opponent.senzuBean();
        }
        return winCount;
    }
    public String nFightsToTheDeath(Hero opponent, int n){
        int winCount[] = nFightsToTheDeathHelper(opponent, n);
        if(winCount[0]==winCount[1]){
            return(this.name + ": " + winCount[0] + " wins" + "\n" + opponent.getName() + ": " + winCount[1] + " wins" + "\nOMG! It was actually a draw!");
        }
        else if(winCount[0]>winCount[1]){
            return(this.name + ": " + winCount[0] + " wins" + "\n" + opponent.getName() + ": " + winCount[1] + " wins" + "\n" + this.name + " wins!");
        }
        else {
            return(this.name + ": " + winCount[0] + " wins" + "\n" + opponent.getName() + ": " + winCount[1] + " wins" + "\n" + opponent.getName() + " wins!");
        }
    }
    public void dramaticFightToTheDeath(Hero opponent) throws InterruptedException {
        while(this.hitPoints>0 && opponent.getHitPoints()>0){
            attack(opponent);
            Thread.sleep(1000);
            System.out.println(this.name + ": " + this.hitPoints + "        " + opponent.getName() + ": " + opponent.getHitPoints() + "\n");
        }
        if(this.hitPoints==0){
            System.out.println(opponent.getName() + " wins!");
        }
        else if(opponent.getHitPoints()==0){
            System.out.println(this.name + " wins!");
        }
    }
}
