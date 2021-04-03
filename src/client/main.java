package client;

import java.io.IOException;
import java.util.Scanner;
import data.DataCollection;
import bus.Customer;
import bus.Account;
import bus.EnumAccount;
import bus.Validator;



public class main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
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
			String customerNum , customerName, customerPin , customerEmail , accountNum;
			EnumAccount accountType;
			double blance;
			inputKey = scanner.next();
			switch (inputKey) {
				case "1": {
					System.out.print("\t((ADD A NEW CUSTOMER))\n\n");
					
					
					//Get customer number with validation
					do {
						System.out.println("Customer Number: \n");
						customerNum = scanner.next();
						
					}while(Validator.ValiCustomerNumber(customerNum) == false);
					
					
					//Get customer name with validation
					do {
						System.out.println("Customer Name: \n");	
						customerName = scanner.next();
					
					}while(Validator.ValiCustomerName(customerName) == false);
					
					//Get Customer Pin with validation
					do {
						System.out.println("Customer Pin: \n");	
						customerPin = scanner.next();
					
					}while(Validator.ValiCustomerPin(customerPin) == false);
					
					do {
						System.out.println("Customer Email: \n");	
						customerEmail = scanner.next();
					
					}while(Validator.ValiCustomerEmail(customerEmail) == false);
					
					
					//A customer must have at least a checking account. 
					
					//create new customer with parameters
					Customer newCustomer = null;
					newCustomer = new Customer(customerNum, customerName, customerPin, customerEmail);
					
					//Create new accout type checking
					Account defaultAccount = null;
					defaultAccount = new Account(newCustomer.getOwnerID(), newCustomer.getAccountType(), newCustomer.getAccountBalance());
					
					//Save new customer and new account to data collection
					DataCollection.addCustomer(newCustomer);
					DataCollection.addAccount(defaultAccount);
					System.out.println("\n\n\n\n\n\n");
					break;
				}
				case "2": {
					System.out.print("\t((REMOVE AN EXISTING CUSTOMER))\n\n");
					
					//Get a customer number for deleting from data collection
					do {
						System.out.println("Please enter a customer number: \n");
						customerNum = scanner.next();
						
					}while(Validator.ValiCustomerNumber(customerNum) == false);
					
					//Check if customer exist then remove it from data collection
					DataCollection.removeCustomer(customerNum);
					System.out.println("\n\n\n\n\n\n");
					break;
				}
				case "3": {
					System.out.print("\t((ALL THE CUSTOMERS))\n\n");
					
					//Open the file, deserialization and show all customers
					DataCollection.allCustomers();
					System.out.println("\n\n");
					break;
				}
				case "4": {
					System.out.print("\t((OPEN A NEW ACCOUNT))\n\n");
					
					//Get customer number with validation
					do {
					System.out.print("Please enter a customer number: \n");
					customerNum = scanner.next();
					}while(Validator.ValiCustomerNumber(customerNum) == false);
					
					//check the number in data collection if exist then run the request
					if(DataCollection.searchCustomers(customerNum) != null)
					{
						//We can show the customer information here!
						String temp;
						//Get Enum type by menu and validation
						do {
							System.out.println("Please select the account type: \n");
							 accountType  = EnumAccount.Undefined;	
							System.out.println(" \t 1- Checking");
							System.out.println(" \t 2- Saving");
							System.out.println(" \t 3- Credit");
							temp = scanner.next();
							  switch(temp)
								{
								case "1" :
									accountType = EnumAccount.Checking;
									break;					
								case "2":
									accountType = EnumAccount.Saving;
									break;
								case "3":
									accountType = EnumAccount.Credit;
									break;
								default:
									accountType = EnumAccount.Undefined;
									break;
								}
							 
							}while(Validator.ValiAccountEnumType(temp) == false);
						
							//Get balence with validation
							String tempbalance;
						do {
							System.out.println("Please enter account balance: \n");
							tempbalance = scanner.next();
						   
						} while(Validator.ValiAccountBalance(tempbalance) == false);
						  
						//Create an account with all validated information and save to file
						  Account newAccount = null;
						  newAccount = new Account(customerNum, accountType, Double.valueOf(tempbalance));
						  DataCollection.addAccount(newAccount);						
						
					}
				
					System.out.println("\n\n");
					break;
				}
				case "5": {
					System.out.print("\t((REMOVE AN ACCOUNT))\n\n");
					
					//Get account number to remove it from file
					do {
					System.out.print("Enter the account number: \n");
					accountNum = scanner.next();
					
					}while(Validator.ValiAccountNumber(accountNum) == false);
					
					//Search and if exist then remove it
					DataCollection.removeAccount(accountNum);
					break;
				}
				case "6": {
					System.out.print("\t((ALL THE ACCOUNTS))\n\n");
					
					//Provide all data from serializable file
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