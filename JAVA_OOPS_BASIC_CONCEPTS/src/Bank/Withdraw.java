package Bank;

class DepositAccount extends Account {
    private double fixedWithdrawAmount;

    public DepositAccount(String accountNumber, double initialBalance, double fixedWithdrawAmount) {
        super(accountNumber, initialBalance);
        this.fixedWithdrawAmount = fixedWithdrawAmount;
    }

    public void addFixedDeposit() {
        withdraw(fixedWithdrawAmount);
        System.out.println("Fixed Deposit added: " + fixedWithdrawAmount);
    }

    @Override
    public void displayDetails() {
        System.out.println("Deposit Account Number: " + getAccountNumber());
        System.out.println("Balance: " + getBalance());
        System.out.println("Fixed Deposit Withdrawl: " + fixedWithdrawAmount);
    }
}