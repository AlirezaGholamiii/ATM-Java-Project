package data;
import bus.Account;
import java.io.IOException;
import java.util.ArrayList;
import bus.Customer;
import client.main;
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
  
	public static boolean removeAccount(String key)throws ClassNotFoundException, IOException
	 {
		
    	 Account accountForRemove = new Account();
    	 
	    	 for( Account element : filelistOfAccount)
			 {
	    		
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 accountForRemove = element;
					 filelistOfAccount.remove(accountForRemove);
					 FileHandeler.writeToFileAccount(filelistOfAccount);
					 return true;
					
				 }

			 }
 	 

    	 FileHandeler.writeToFileAccount(filelistOfAccount);
    	 return false;
		
	 }	 
	
     //dsiplay all accounts
	 public static void allAccounts()throws ClassNotFoundException 	 
	 {
		
		 try { 
			 filelistOfAccount = FileHandeler.readFromFileAccount();
			 
			 for(Account element : filelistOfAccount)
			 {
				  main.showAccount(element);
			 }
			 
	 }
	 catch(IOException e)
	 {
		main.error();
	 }		 
		
	 } 	 
	  	 
	 //search for an Account by number	 
	 public static Account searchAccount(String key)throws ClassNotFoundException
	 {
	   try {
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
		 catch(IOException e)
		 {
			 main.error();
			 return null;
		 }
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
				 }
			 }		 
	   	   
	 }	 
	 
	 //search for an Account and withdraw money	 
	 public static boolean withdrawAccount(String key,double amount)throws IOException, ClassNotFoundException
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
			 for( Account element : filelistOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 if(amount >= element.getAccountBalance()) 
					 {
							return false;
					 }
					 else
					 {
						 element.withdrawl(amount);	
						 FileHandeler.writeToFileAccount(filelistOfAccount);
						 return true;
					 }	
						 
						 
				 }
			 }
			 return false; 
	 }
	 
	 //search for an Account and show details	 
	 public static Account searchAccountInfo(String key)throws IOException, ClassNotFoundException
	 {
		 filelistOfAccount = FileHandeler.readFromFileAccount();
		 
			 for( Account element : filelistOfAccount)
			 {
				    	 
				 if(((Account) element).getAccountNum().equals(key))
				 {
					 
					 return element; 			 
				 }
			 }		 
	   return null;	   
	 }
	

	 //////////////////////////////////////////////////// customer ////////////////////////////////////////////
	 private static  ArrayList<Customer>  filelistOfCustomer = new  ArrayList<Customer>();
	 
	 //public static operations
	//Add an Customer	 
     public static void addCustomer(Customer object)throws IOException, ClassNotFoundException
	 {
    	 filelistOfCustomer.add(object);
    	 FileHandeler.writeToFileCustomer(filelistOfCustomer);
	 }	 
	 
     //Remove a customer
     public static boolean removeCustomer(String key)throws ClassNotFoundException
	 {
    	 try {
	    	 filelistOfCustomer = FileHandeler.readFromFileCustomer();

    		 for( Customer element : filelistOfCustomer)
			 {
				  
				 if(((Customer) element).getCustomerNum().equals(key))
				 {

					 // remove customer.
					 filelistOfCustomer.remove(element);
		    		 //save to file
		    		 FileHandeler.writeToFileCustomer(filelistOfCustomer);
					 return true;
				 } 
			 }

     	 }
    	 catch(IOException e)
    	 {
    		 main.error();
    	 }
    	 return false;
	 }	 
	
     //dsiplay all customers
	 public static void allCustomers()throws  ClassNotFoundException	 
	 {
		 try {
				 filelistOfCustomer = FileHandeler.readFromFileCustomer();
				 for(Customer element : filelistOfCustomer)
				 {
					 main.showCustomer(element);
					 
				 }
		 }
		 catch(IOException e)
		 {
			 main.error();
		 }
		 
		
	 } 	 
	  	 
	 //search for an Customer by number	 
	 public static Customer searchCustomers(String key)throws  ClassNotFoundException
	 {
		 try {
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
		 catch(IOException e)
		 {
			 main.error();
			 return null;
		 }
	 }

	 //search for a customer to make sure does not exist before adding again into the file	 
	 public static boolean searchCustomersExist(String key)throws  ClassNotFoundException, IOException
	 {
			 filelistOfCustomer = FileHandeler.readFromFileCustomer();
			 
				 for( Customer element : filelistOfCustomer)
				 {
					    	 
					 if(((Customer) element).getCustomerNum().equals(key))
					 {
						 return true ;				 
					 }
	 
				 }
				 return false; 

	 }
	 
	 public static  ArrayList<Customer>   getCustomerList()
	 {   
		   
	      return filelistOfCustomer ;
		 
	 }
	 
	}