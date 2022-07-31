
import java.util.Scanner;

class BalanceNotSufficient extends Exception{
	static int balance;
	
	
	public boolean transaction(int withdraw_amt) throws BalanceNotSufficient {
		if(balance > withdraw_amt) {
			balance -=  withdraw_amt;
			return true;
		}
		else
			throw new BalanceNotSufficient();
			
	}
}

public class BankBalanceMain {
	
	int withdraw_amt = 0;

	public static void main(String[] args) {
		
		BalanceNotSufficient.balance = 10000;
		
		BalanceNotSufficient acc = new BalanceNotSufficient();
		
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Balance: "+ BalanceNotSufficient.balance);
			System.out.print("Enter the withdrawal amount: ");
			int withdraw_amt = sc.nextInt();
			
			if(acc.transaction(withdraw_amt)) {
				System.out.println("Transaction Completed...");
				System.out.println("The available balance is: "+ BalanceNotSufficient.balance);
			}
		}catch(BalanceNotSufficient e) {
			e.printStackTrace();
		}
	}

}