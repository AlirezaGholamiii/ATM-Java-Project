package data;
import bus.Account;
import java.util.ArrayList;
import bus.Customer;
public class DataCollection {
	
	//private static data
	 private static  ArrayList<Account>  listOfAccount = new  ArrayList<Account>();
	 
	 //public static operations
	//Add an account	 
     public static void addAccount(Account object)
	 {
    	 listOfAccount.add(object);		 
	 }	 
	 
     //Remove an account
     public static void removeAccount(String key)
	 {
		 	
    	 for( Account element : listOfAccount)
		 {
			  
			 if(((Account) element).getAccountNum().equals(key))
			 {
				 listOfAccount.remove(element);	
				 System.out.println("Account with the Number of " + key + " removed!");
			 }
		 }	
	 }	 
	
     //dsiplay all accounts
	 public static void allAccounts()	 
	 {
		 for(Account element : listOfAccount)
		 {
			  System.out.println(element);
			 
			 
		 }
		
	 } 	 
	  	 
	 //search for an Account by number	 
	 public static Account searchAccount(String key)
	 {
			 for( Account element : listOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 public static  ArrayList<Account>   getAccountList()
	 {   
		   
	      return listOfAccount ;
		 
	 }
	 
	 
	 //search for an Account and deposit money	 
	 public static void depositAccount(String key, double amount)
	 {
			 for( Account element : listOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 	element.deposit(amount);	
					 	System.out.println(amount + "$ Amount added to account.");
				 }
			 }		 
	   	   
	 }	 
	 
	 //search for an Account and withdraw money	 
	 public static void withdrawAccount(String key,double amount)
	 {
			 for( Account element : listOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 	element.withdrawl(amount);	
					 	System.out.println(amount + "$ Amount withdrawn from account.");
				 }
			 }		 
	   	   
	 }
	 
	 //search for an Account and show details	 
	 public static Account searchAccountInfo(String key)
	 {
			 for( Account element : listOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 System.out.println(element); 			 
				 }
			 }		 
	   return null;	   
	 }
	

	 //////////////////////////////////////////////////// customer
	 private static  ArrayList<Customer>  listOfCustomer = new  ArrayList<Customer>();
	 
	 //public static operations
	//Add an account	 
     public static void addCustomer(Customer object)
	 {
    	 listOfCustomer.add(object);		 
	 }	 
	 
     //Remove an account
     public static void removeCustomer(String key)
	 {
		 	
    	 for( Customer element : listOfCustomer)
		 {
			  
			 if(((Customer) element).getCustomerNum().equals(key))
			 {
				 listOfCustomer.remove(element);	
				 System.out.println("Account with the Number of " + key + " removed!");
			 }
		 }	
	 }	 
	
     //dsiplay all customers
	 public static void allCustomers()	 
	 {
		 for(Customer element : listOfCustomer)
		 {
			 System.out.println(element);
			 
		 } 		 
	 } 	 
	  	 
	 //search for an Account by number	 
	 public static Customer searchCustomers(String key)
	 {
			 for( Customer element : listOfCustomer)
			 {
				    	 
				 if(((Customer) element).getCustomerNum().equals(key))
				 {
					 return element ;				 
				 }
			 }		 
	   return null;	   
	 }
	 
	 public static  ArrayList<Customer>   getCustomerList()
	 {   
		   
	      return listOfCustomer ;
		 
	 }
	 
	}