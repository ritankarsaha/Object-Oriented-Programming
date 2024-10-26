package Bank;

abstract class Account {
	private String accountNumber;
	private double balance;
	public Account(String accountNumber, double initialBalance) {
		this.accountNumber=accountNumber;
		this.balance=initialBalance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		if(amount <= 0) {
			System.out.println("Enter a valid amount");
		}
		else {
			balance+=amount;
		}
	}

	public void withdraw(double amount) {
		if(amount <= 0 || amount<0) {
			System.out.println("Enter a valid amount");
		}
		else {
			balance-=amount;
		}
	}
	public abstract void displayDetails();
}
