package Assignment7;



import java.util.Scanner;
public class ATMTest {
	
	private static Scanner in= new Scanner(System.in);
	static double startTime;//for checking the start time of operation
	static double finishTime;//for checking the end time of operation
	 public static void main(String[] args) {
	  	  ATM obj[]=new ATM[5];
	  	  String h="12345678901";
	  	  
	  	  //create objects of ATM
	  	  for(int i=0;i<5;i++) 
	  		  obj[i]=new ATM(h+i ,(7546+i),(1000.00),2);
	  	  
	  	   int c;
	  	  
	  	   startTime = System.currentTimeMillis();
	  	   System.out.println("Enter the Account Number:");
		   String accNum=in.next();
		   System.out.println("Enter the PIN:");
		   int Pin=in.nextInt();
		   finishTime = System.currentTimeMillis();
		   
		   //if operation time is more than 20sec then exit
		   if(finishTime-startTime > 20000)
		   {
			   System.out.println("TimeOut! Login again to continue");
			   System.exit(0);
		   }
		   if(AccountNumber(obj, accNum, Pin)>=0)
		   {
			   Menu();
			   startTime = System.currentTimeMillis();
	  	  		c=in.nextInt();
	  	  		finishTime = System.currentTimeMillis();
	  	  	//if operation time is more than 50sec then exit
	  	  		if(finishTime-startTime > 5000)
	  	  		{
	  	  			System.out.println("TimeOut! Login again to continue");
	  	  			System.exit(0);
	  	  		}
	  	  		Choice(c, obj, AccountNumber(obj, accNum, Pin));
		   }
		   else
		   {
			   System.out.println("INVALID PIN Or Account Does Not Exist ");
			   System.exit(1);
		   }
	 }
	 
	 //method to provide option based on user choice
	 public static void Choice(int choice, ATM[] obj, int index){
		 
		 startTime = System.currentTimeMillis();
		 switch(choice){
	  	  case 1:                                     //for withdrawing money
	  		  obj[index].withdraw();
	  		  break;
	  	  case 2:	                                //for depositing money
	  		  obj[index].Deposit();
	 		  break;
	  	 case 3:                                    //for checking balance.
	  		  obj[index].checkBalance();
	  		  break;
	  	 case 4:
	  		 System.exit(0);
	  		 break;
		default:
				 System.out.println("Invalid Input");
	  	  }
		 finishTime = System.currentTimeMillis();
		 if(finishTime-startTime > 20000)
		   {
			   System.out.println("TimeOut! Login again to continue");
			   System.exit(0);
		   }
		 System.out.println("Thank You! for Banking with us.");
	 }

	 //method to show menu to user
	public static void Menu()
	 {
		 System.out.println("Choose your Operation");
		 System.out.println("1.Withdraw Money");
		 System.out.println("2.Deposit Money");
		 System.out.println("3.Check Balance");
		 System.out.println("4.Log Out");
	 }
	
	//method to check the account number
	public static int AccountNumber(ATM[] obj, String accNum, int Pin)
	{
		for(int i=0;i<5;i++) 
			   if(obj[i].accountNumber.compareTo(accNum)==0 && Pin==obj[i].pin) 
				   return i;
		return -1;
	}
}

