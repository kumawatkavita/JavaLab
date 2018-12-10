package Assignment7;


import java.util.Scanner;
public class ATM {

    String accountNumber;
    int pin;
    double balance;
    int ibt;
	private static Scanner input = new Scanner(System.in);
	
	  // constructor to allocate values to data fields
	  public ATM(String accNum, int pin, double balance, int ibt) { 
	 	this.accountNumber = accNum;
		this.pin = pin;
		this.balance = balance;
		this.ibt = ibt;
	  }
	  
	  public void withdraw() {     //function to withdraw money
			double amount;              //variable for amount to be withdrawn.
			System.out.println("Enter the amount:");
			input = new Scanner(System.in);
			amount=input.nextDouble();
			try{
				//check for the amount entered if not valid throw exception
				if(amount < 0||amount %100!=0)
					throw new ArithmeticException("Invalid Input\n Enter in multiple of 100, 500 and 2000 only");
				if(amount > (balance-100))
					throw new Exception("Insufficient Balance");
			}
			catch( ArithmeticException e) {
				System.out.println("ERROR: " + e.getMessage());
				amount=input.nextDouble();
			}
			catch(Exception e)
			{
				System.out.println("ERROR: " + e.getMessage());
				amount=input.nextDouble();
			}
			balance=balance-amount;
			System.out.println("Your new Balance is "+ balance);
		}
	  
	  public void Deposit() {      //function to deposit money
			double amount;              //variable amount to be deposited
			System.out.println("Enter the amount:");
			input = new Scanner(System.in);
			amount=input.nextDouble();
			balance=balance+amount;
			System.out.println("Your new Balance is Rs "+ balance);
		}
	  
	  public void checkBalance() {   //function to check current balance
			System.out.println("Your Current Balance is:Rs "+balance);
		}  
}






