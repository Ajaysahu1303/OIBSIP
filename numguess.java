import java.util.*;
class numgame{
    int number,nogusses=0,inpnum;
    public int getgusses()
    {
        return nogusses;
    }
    public void setgusses(int nogusses)
    {
        this.nogusses=nogusses;

    }
    numgame()
    {
        Random rand=new Random();
        this.number=rand.nextInt(100);
    }
    void takeinp()
    {
        System.out.print("Guess the number:");
        Scanner sc=new Scanner(System.in);
        inpnum=sc.nextInt();
    }
    boolean isCorrect()
    {
        nogusses++;
        if (inpnum==number) {
            System.out.println("Correct!!.It was "+number+" and gussed in "+nogusses+" attempts.");
             return true;
        }
        else if (inpnum<number) {
            System.out.println("Too Low....");
        }
        else if (inpnum>number) {
            System.out.println("Too High....");
        }
        return false;
    }
}
public class numguess {
public static void main(String[] args) {
    numgame g=new numgame();
    
    do {
        g.takeinp();
    } while (!(g.isCorrect()));
}
}
