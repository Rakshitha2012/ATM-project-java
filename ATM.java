package ATMproject;

import java.util.Scanner;
import java.util.ArrayList;

public class ATM 
{
	double balance=10000;
	int pin=1234;
	ArrayList<String>statement=new ArrayList<String>();
	
	public void pin()
	{
		System.out.println("Enter your Pin ::");
		Scanner sc = new Scanner(System.in);
		int enteredPin=sc.nextInt();
		if(enteredPin==pin)
		{
			System.out.println("Welcome..!");
			menu();
		}
		else
			System.out.println("You Entered Wrong Pin");
		pin();
	}
	private void menu()
	{
		System.out.println("Choose Option");
		System.out.println("1. Check Balance");
		System.out.println("2. Deposite Money");
		System.out.println("3. Withdraw Money");
		System.out.println("4. Mini Ststement");
		System.out.println("5.Exit");
		Scanner sc = new Scanner(System.in);
		int option=sc.nextInt();
		
		switch(option)
		{
		case 1:
			CheckBalance();
			menu();
			break;
			
		case 2:
			DepositeMoney();
			menu();
			break;
			
		case 3:
		     WithdrawMoney();
			menu();
			break;
			
		case 4:
			MiniStatement();
			menu();
			break;
			
		case 5:
		     Exit();
			menu(); 
			break;
			default :
				System.out.println("Choose Option");
			 
			 
		}
		
	}
	
	private void MiniStatement() {
		System.out.println("-----MiniStatement-----");
		int start=Math.max(0, statement.size()-5);
		for(int i=start; i< statement.size(); i++)
		{
			System.out.println(statement.get(i));
		}
		System.out.println("-------------");
		}
	
	private void WithdrawMoney() {
		System.out.println("Enter Amount to Withdraw Money");
		Scanner sc = new Scanner(System.in);
		double WithdrawAmount=sc.nextDouble();
		if(WithdrawAmount>balance)
		{
		System.out.println("You have a Insufficient Amount!");	
		}
		else
		{
			balance-=WithdrawAmount;
			statement.add("Withdrawn: Rs."+WithdrawAmount);
			System.out.println("Successfully Withdrawn");
		}
		
	}
	private void DepositeMoney() {
		System.out.println("Enter Amount to Deposite Money:");
		Scanner sc=new Scanner(System.in);
		double amount=sc.nextDouble();
		balance+=amount;
		
		statement.add("Deposited: Rs."+amount);
		System.out.println("Rs."+amount+"Deposited successfully.");
	}
	private void CheckBalance() {
		 System.out.println("Your Current Balance is::" +balance);
		
	}
private void Exit() {
		System.out.println("Are you sure to exit(yes/no)");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
				if(str.equalsIgnoreCase("yes"))
		{
			System.out.println("Thank You for Visiting..!");
		}
				else
				{
					menu();
				}
	}
}

