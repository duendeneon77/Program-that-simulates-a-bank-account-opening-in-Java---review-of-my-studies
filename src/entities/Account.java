package entities;

public class Account {
	
	private int accountNumber;
	private String name;
	private double amount=0;
	private double tax = 5.00;
	
	public Account() {}
	
	
	
	
	public Account(int accountNumber, String name, double initialAmount) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.amount = initialAmount;
	}
	
	public Account(int accountNumber, String name) {
		this.accountNumber = accountNumber;
		this.name = name;
	}

	public int getAccountNumber() {
		return accountNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAmount() {
		return amount;
	}
	
	public void deposit(double amountToDeposit) {
		amount += amountToDeposit;
		
	}
	
	public void withdrawal(double amountToWithdrawal) {
		
		if (amount >= amountToWithdrawal + tax) {
	        amount -= (amountToWithdrawal + tax);
	    } else {
	        System.out.println("Insufficient funds for this withdrawal.");
	    }
	}




	@Override
	public String toString() {
	    if (amount != 0) {
	        return String.format("Account data: %n[Account Number = %d,%n Holder name = %s, %n Balance = $%.2f]", accountNumber, name, amount);
	    } else {
	        return String.format("Account data: %n[Account Number = %d,%n Holder name = %s,%n Balance = Your account is empty.]", accountNumber, name);
	    }

	}
	

}
