package client;

import java.util.Scanner;

import data.DataCollection;
import bus.Customer;
import bus.Account;
import bus.EnumAccount;



public class main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String inputKey;
		
		do {
			System.out.println("1 - Add a new customer.");
			System.out.println("2 - Remove a customer.");
			System.out.println("3 - Display all the customers.");
			System.out.println("4 - Open a new account.");
			System.out.println("5 - Remove an account.");
			System.out.println("6 - Display all the accounts.");
			System.out.println("7 - Enter to an account for more servises.");
			System.out.println("8 - Exit");
			System.out.print("\t Please enter your option: ");
			
			
			inputKey = scanner.next();
			switch (inputKey) {
				case "1": {
					System.out.print("\t((ADD A NEW CUSTOMER))\n\n");
					
					System.out.println("Customer Number: \n");	
					String customerNum = scanner.next();
					
					System.out.println("Customer Name: \n");	
					String customerName = scanner.next();
					
					System.out.println("Customer Pin: \n");	
					String customerPin = scanner.next();
					
					System.out.println("Customer Email: \n");	
					String customerEmail = scanner.next();
					  
					//A customer must have at least a checking account. 
						
					Customer newCustomer = null;
					newCustomer = new Customer(customerNum, customerName, customerPin, customerEmail);
					
					Account defaultAccount = null;
					defaultAccount = new Account(newCustomer.getOwnerID(), newCustomer.getAccountType(), newCustomer.getAccountBalance());
					
					DataCollection.addCustomer(newCustomer);
					DataCollection.addAccount(defaultAccount);
					System.out.println("\n\n\n\n\n\n");
					break;
				}
				case "2": {
					System.out.print("\t((REMOVE AN EXISTING CUSTOMER))\n\n");
				
					System.out.println("Please enter a customer number: \n");
					String customerNum = scanner.next();
					
					DataCollection.removeCustomer(customerNum);
					System.out.println("\n\n\n\n\n\n");
					break;
				}
				case "3": {
					System.out.print("\t((ALL THE CUSTOMERS))\n\n");
					
					DataCollection.allCustomers();
					System.out.println("\n\n");
					break;
				}
				case "4": {
					System.out.print("\t((OPEN A NEW ACCOUNT))\n\n");
					
					System.out.print("Please enter a customer number: \n");
					String customernum = scanner.next();
					if(DataCollection.searchCustomers(customernum) == null)
					{
						System.out.println("This customer does not exist!");
						
					}
					else
					{
						//We can show the customer information here!
						
						System.out.println("Please select the account type: \n");
						EnumAccount accountType  = EnumAccount.Undefined;	
						System.out.println(" \t 1- Checking");
						System.out.println(" \t 2- Saving");
						System.out.println(" \t 3- Credit");
						
						  switch(scanner.nextInt())
							{
							case 1 :
								accountType = EnumAccount.Checking;
								break;					
							case 2:
								accountType = EnumAccount.Saving;
								break;
							case 3:
								accountType = EnumAccount.Credit;
								break;
							default:
								accountType = EnumAccount.Undefined;
								break;
							}
						  
						  
						  System.out.println("Please enter account balance: \n");
						  double blance = scanner.nextDouble();
							
						  
						  Account newAccount = null;
						  newAccount = new Account(customernum, accountType, blance);
						  DataCollection.addAccount(newAccount);
					}
					
					System.out.println("\n\n");
					break;
				}
				case "5": {
					System.out.print("\t((REMOVE AN ACCOUNT))\n\n");
					System.out.print("Enter the account number: \n");
					String accountNumber = scanner.next();
					DataCollection.removeAccount(accountNumber);
					break;
				}
				case "6": {
					System.out.print("\t((ALL THE ACCOUNTS))\n\n");
					DataCollection.allAccounts();
					System.out.println("\n\n");
					break;
				}
				case "7": {
					System.out.print("\t((MORE SERVISES))\n\n");
					
					System.out.println("Please enter your account number: \n");
					String accountNumber = scanner.next();
					
					if(DataCollection.searchAccount(accountNumber) == null)
					{
						System.out.println("This account does not exist!");
						
					}
					else
					{
						System.out.println("\t((WELCOME))\n\n");
						System.out.println("Please select your servise: \n");
						System.out.println(" \t 1- Deposit");
						System.out.println(" \t 2- Withdraw");
						System.out.println(" \t 3- Account Information");
						switch(scanner.nextInt())
						{
						case 1 :
							System.out.println("\t((DEPOSIT))\n\n");
							System.out.println("Please enter the amount: \n");
							double depositAamount = scanner.nextDouble();
								DataCollection.depositAccount(accountNumber, depositAamount);
							break;					
						case 2:
							System.out.println("\t((WITHDRAW))\n\n");
							System.out.println("Please enter the amount: \n");
							double withdrawAmount = scanner.nextDouble();
								DataCollection.withdrawAccount(accountNumber, withdrawAmount);
							break;
						case 3:
								DataCollection.searchAccountInfo(accountNumber);
							break;
						default:
							System.out.println("Your option is not valid.");
						}
					}
					
					
					System.out.println("\n\n");
					break;
				}
		
				case "8": {
					System.out.println("Option 8 is entered...");
					break;
				}
				
				
				default:
					System.out.println("No Valid Input Entered!!\n\n");
					continue;
				}
		} while (!inputKey.equals("8"));
		
		System.out.println("Application is closed successfuly!");
		
		
		
		scanner.close();
	}

}