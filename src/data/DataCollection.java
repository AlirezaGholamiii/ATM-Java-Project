package data;
import bus.Account;

import java.io.IOException;
import java.util.ArrayList;
import bus.Customer;
public class DataCollection {
	
	//private static data
	 private static  ArrayList<Account>  filelistOfAccount = new  ArrayList<Account>();
	 
	 
	 
	 //public static operations
	//Add an account	 
     public static void addAccount(Account object) throws IOException, ClassNotFoundException
	 {
    	 filelistOfAccount.add(object);
    	 FileHandeler.writeToFileAccount(filelistOfAccount);
	 }	 
	 
     //Remove an account
     public static void removeAccount(String key)throws IOException, ClassNotFoundException
	 {
		 	
    	 for( Account element : filelistOfAccount)
		 {
			  
			 if(((Account) element).getAccountNum().equals(key))
			 {
				 filelistOfAccount.remove(element);
				 FileHandeler.writeToFileAccount(filelistOfAccount);
				 System.out.println("Account with the Number of " + key + " removed!");
			 }
		 }	
	 }	 
	
     //dsiplay all accounts
	 public static void allAccounts()throws IOException, ClassNotFoundException	 
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
		// for(Account element : filelistOfAccount)
		 //{
			  System.out.println(filelistOfAccount);
			 
			 
		 //}
		
	 } 	 
	  	 
	 //search for an Account by number	 
	 public static Account searchAccount(String key)throws IOException, ClassNotFoundException
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
			 for( Account element : filelistOfAccount)
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
		   
	      return filelistOfAccount ;
		 
	 }
	 
	 
	 //search for an Account and deposit money	 
	 public static void depositAccount(String key, double amount)throws IOException, ClassNotFoundException
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
			 for( Account element : filelistOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 	element.deposit(amount);
					 	FileHandeler.writeToFileAccount(filelistOfAccount);
					 	System.out.println(amount + "$ Amount added to account.");
				 }
			 }		 
	   	   
	 }	 
	 
	 //search for an Account and withdraw money	 
	 public static void withdrawAccount(String key,double amount)throws IOException, ClassNotFoundException
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
			 for( Account element : filelistOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 	element.withdrawl(amount);	
					 	FileHandeler.writeToFileAccount(filelistOfAccount);
					 	System.out.println(amount + "$ Amount withdrawn from account.");
				 }
			 }		 
	   	   
	 }
	 
	 //search for an Account and show details	 
	 public static Account searchAccountInfo(String key)throws IOException, ClassNotFoundException
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
			 for( Account element : filelistOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 System.out.println(element); 			 
				 }
			 }		 
	   return null;	   
	 }
	

	 //////////////////////////////////////////////////// customer
	 private static  ArrayList<Customer>  filelistOfCustomer = new  ArrayList<Customer>();
	 
	 //public static operations
	//Add an account	 
     public static void addCustomer(Customer object)throws IOException, ClassNotFoundException
	 {
    	 filelistOfCustomer.add(object);
    	 FileHandeler.writeToFileCustomer(filelistOfCustomer);
	 }	 
	 
     //Remove an account
     public static void removeCustomer(String key)throws IOException, ClassNotFoundException
	 {
    	 filelistOfCustomer = FileHandeler.readFromFileCustomer();
    	 
    	 for( Customer element : filelistOfCustomer)
		 {
			  
			 if(((Customer) element).getCustomerNum().equals(key))
			 {
				 //search for the all accounts of this costumer and remove all of them
				 filelistOfAccount = FileHandeler.readFromFileAccount();
				 for(Account allAccount : filelistOfAccount)
				 {
					 if(((Account) allAccount).getOwnerID().equals(key))
					 {
						 filelistOfAccount.remove(allAccount);
						 
					 }
				 }
				 FileHandeler.writeToFileAccount(filelistOfAccount);
				 
				 //After removing all accounts relate to this customer then remove customer.
				 filelistOfCustomer.remove(element);
				 FileHandeler.writeToFileCustomer(filelistOfCustomer);
				 System.out.println("Account with the Number of " + key + " removed!");
			 }
		 }	
	 }	 
	
     //dsiplay all customers
	 public static void allCustomers()throws IOException, ClassNotFoundException	 
	 {
			 filelistOfCustomer = FileHandeler.readFromFileCustomer();
			 for(Customer element : filelistOfCustomer)
			 {
				 System.out.println(element);
				 
			 } 
		 
		
	 } 	 
	  	 
	 //search for an Account by number	 
	 public static Customer searchCustomers(String key)throws IOException, ClassNotFoundException
	 {
		 filelistOfCustomer = FileHandeler.readFromFileCustomer();
		 
			 for( Customer element : filelistOfCustomer)
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
		   
	      return filelistOfCustomer ;
		 
	 }
	 
	}