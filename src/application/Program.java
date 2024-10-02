package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Please, enter your account number: ");
		int accountNumber = sc.nextInt();
		System.out.println("Please, enter your name: ");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Would you like to initialize " + "your account with a certain "
				+ "amount of money? Type 'Y' for " + "Yes or 'N' for No");

		char answer = sc.next().toUpperCase().charAt(0);
		char answer2;
		Account account = new Account();
		double initialAmount = 0.00;

		if (answer == 'Y') {
			System.out.println("pleae, enter the amount: ");
			initialAmount = sc.nextDouble();

			account = new Account(accountNumber, name, initialAmount);
			System.out.println("You have an account now.");
		} else {
			account = new Account(accountNumber, name);
			System.out.println("You have an account now.");
			System.out.println(" but your account is empty.");
		}

			do {

				System.out.println(
						"Would you like to deposit any amount of money or make a withdrawal? Type Y for Yes or N for No ");
				answer2 = sc.next().toUpperCase().charAt(0);

				if (answer2 == 'Y') {
					System.out.println("Type W for withdrawal or D for deposit");
					char answer3 = sc.next().toUpperCase().charAt(0);

					if (answer3 == 'W') {
						System.out.println("Please, enter the amount to Withdrawal: ");
						double amountToWithdrawal = sc.nextDouble();
						System.out.printf("You have $ %.2f %n", account.getAmount());
						account.withdrawal(amountToWithdrawal);
						System.out.printf("Withdrawal successful. Current balance: %.2f\n" ,  account.getAmount());

					} else if (answer3 == 'D') {
						System.out.println("Please, enter the amount to deposit");

						double amountToDeposit = sc.nextDouble();
						System.out.printf("You have $ %.2f %n", account.getAmount());
						account.deposit(amountToDeposit);

						System.out.printf("Deposit successful. Current balance: %.2f \n", account.getAmount());
					}

				} else if (answer2 == 'N') {
					System.out.println("Thank you. Have a nice day.");
				} else {
					System.out.println("Invalid Option!");
				}
			} while (answer2 == 'Y');
		
		System.out.printf(account.toString());

		sc.close();

	}

}
