package Bank;
import java.util.*;
public class BankingSystem {
	
	private List<Account>accounts = new ArrayList<>();
	public void addAccount(Account account) {
		accounts.add(account);
		System.out.println(account.getBalance());
		
	}
	public void displayAllAccounts() {
		for(Account account:accounts) {
			account.displayDetails();
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		BankingSystem bank = new BankingSystem();
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Choose account type to add (1: Savings, 2: Deposit, 0: Exit): ");
			int choice = sc.nextInt();
            if (choice == 0) {
                break;
            }

            System.out.println("Enter account number: ");
            String accountNumber = sc.next();

            System.out.println("Enter initial balance: ");
            double initialBalance = sc.nextDouble();
            
            switch(choice) {
            case 1:
            	System.out.println("Enter interest rate: ");
                double interestRate = sc.nextDouble();
                Savings savings = new Savings(accountNumber, initialBalance, interestRate);
                bank.addAccount(savings);
                savings.addInterest();
                break;
            case 2:
            	System.out.println("Enter the amount to be withdrawn");
            	double amount = sc.nextDouble();
            	DepositAccount w = new DepositAccount(accountNumber, initialBalance, amount);   
            	bank.addAccount(w);
                w.addFixedDeposit();
                break;
               default:
            	  System.out.println("Wrong choice!");
            
            }
		}
		bank.displayAllAccounts();
		sc.close();
		
	}

}