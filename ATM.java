import java.util.*;
class Account
{
    long acno;

    String name;
    double bal;
    long mob; 

    void open(long m,String n)
    {
        mob=m;
        name=n;
        acno=(mob/4)+1303;
        System.out.print("Your account No is:"+acno);
        Scanner sc=new Scanner(System.in);
        System.out.println("\nDo you want to deposite money?1.For'Yes'\n2.For'No'");
        int opt=sc.nextInt();
        if (opt==1) {
            System.out.print("Enter amount:");
            double am=sc.nextDouble();
            bal=bal+am;
            System.out.println("Balance:"+bal+"INR");
        }
        else if(opt==2){
            return;
        }
        else{
            System.out.println("\nEnter a valid option");
        }

    }
}
class Bank {
    long m;
    String n;
    int pass;
    
    Account a=new Account();
    void createAc()
    {
        
        System.out.print("Enter your name:");
        Scanner sc=new Scanner(System.in);
        n=sc.nextLine();
        System.out.print("Enter your DOB no:");
        m=sc.nextInt();
        a.open(m,n);
    }
    void delAc()
    {
        a.name="";
        a.mob=0;
        a.bal=0;
        a.acno=0;
        System.out.println("Deleted sucessfully");
        
    }
    void deposite()
    {
        double amt;
        Scanner sc=new Scanner(System.in);

        if (pass!=7895) {
            System.out.println("Wrong PIN!!!!"); 
            return;
        }
        else if (a.name=="" ||a.acno==0) {
            System.out.println("There is no Account..");
            return;
        } 
        else{
            
        System.out.print("Enter your amount:");
        amt=sc.nextFloat();
         a.bal+=amt;
        
        System.out.println(amt+"Rs credited");
        this.pass=0;
        }


    }

    void detail()
    {
      if (pass!=7895) {
       System.out.println("Wrong PIN!!!!"); 
       return;
      }
      else if (a.name=="" ||a.acno==0) {
        System.out.println("There is no Account..");
        return;
      }
        System.out.println("Balance Details");
        System.out.println("\nAC NO        Accuont Holder Name   Balance");
        System.out.print("\n"+a.acno+"        "+a.name+"           "+a.bal);
        this.pass=0;

    }

    void Withdraw()
    {
        double amt;
        Scanner sc=new Scanner(System.in);
        if (a.name=="" ||a.acno==0) {
            System.out.println("There is no Account..");
            return;
          }
        else if (pass!=7895) {
            System.out.println("Wrong PIN!!!!"); 
            return;
        }
        else {
            System.out.println("Enter amount(Enter in multiple of 100):");
            amt=sc.nextDouble();
            if(a.bal<amt)
            {
                System.out.println("Insufficient Balance....");
            }
            else{
                a.bal=a.bal-(float)amt;
            System.out.println("Transaction sucessful"); 
            this.pass=0;   
        }
        
        }

    }

}
public class ATM {
    public static void main(String[] args) {
        Bank Ac=new Bank();
        Scanner sc=new Scanner(System.in);
        int ch;
        while (true) {
            System.out.println("\n\n    ATM INTERFACE\n1.For Open Account\n2.For Deposite\n3.For Withdraw\n4.For Balance\n5.Exit\n6.For Delete\n");
            ch=sc.nextInt();
            switch (ch) {
                case 1:
                Ac.createAc();
                break;

                case 2:
                System.out.print("Enter Your 4 digit PIN:");
                Ac.pass=sc.nextInt();
                Ac.deposite();
                break;

                case 3:
                System.out.print("Enter Your 4 digit PIN:");
                Ac.pass=sc.nextInt();
                Ac.Withdraw();
                break;

                case 4:
                System.out.print("Enter Your 4 digit PIN:");
                Ac.pass=sc.nextInt();
                Ac.detail();
                break;

                case 5:
                System.out.print("Enter Your 4 digit PIN:");
                Ac.pass=sc.nextInt();
                Ac.delAc();
                break;

                case 6:
                return;
                
            
                default:
                    break;
            }
        }
    }
}