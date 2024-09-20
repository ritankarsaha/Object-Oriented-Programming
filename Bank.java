import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Account {
    private String accountNumber;
    private double balance;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Invalid withdraw amount or insufficient balance");
        }
    }

    public abstract void displayAccountDetails();
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Savings Account Number: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

class DepositAccount extends Account {
    private double fixedDepositAmount;

    public DepositAccount(String accountNumber, double initialBalance, double fixedDepositAmount) {
        super(accountNumber, initialBalance);
        this.fixedDepositAmount = fixedDepositAmount;
    }

    public void addFixedDeposit() {
        deposit(fixedDepositAmount);
        System.out.println("Fixed Deposit added: " + fixedDepositAmount);
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Deposit Account Number: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Fixed Deposit Amount: " + fixedDepositAmount);
    }
}

class Bank {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
        displayTotalBalance();
    }

    public void displayAllAccounts() {
        for (Account account : accounts) {
            account.displayAccountDetails();
            System.out.println();
        }
    }

    public void displayTotalBalance() {
        double totalBalance = 0;
        for (Account account : accounts) {
            totalBalance += account.getBalance();
        }
        System.out.println("Total Balance in Bank: " + totalBalance);
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose account type to add (1: Savings, 2: Deposit, 0: Exit): ");
            int choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            System.out.println("Enter account number: ");
            String accountNumber = scanner.next();

            System.out.println("Enter initial balance: ");
            double initialBalance = scanner.nextDouble();

            switch (choice) {
                case 1:
                    System.out.println("Enter interest rate: ");
                    double interestRate = scanner.nextDouble();
                    SavingsAccount savings = new SavingsAccount(accountNumber, initialBalance, interestRate);
                    bank.addAccount(savings);
                    savings.addInterest();
                    break;
                case 2:
                    System.out.println("Enter fixed deposit amount: ");
                    double fixedDepositAmount = scanner.nextDouble();
                    DepositAccount deposit = new DepositAccount(accountNumber, initialBalance, fixedDepositAmount);
                    bank.addAccount(deposit);
                    deposit.addFixedDeposit();
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }

        bank.displayAllAccounts();
        scanner.close();
    }
}