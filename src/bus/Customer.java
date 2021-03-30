package bus;

import bus.Account;

public class Customer extends Account {
	
	private String customerNum;
	private String customerName;
	private String customerPIN;
	private String customerEmail;
	
	//Getters and setters for all the fields
	public String getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerPIN() {
		return customerPIN;
	}
	public void setCustomerPIN(String customerPIN) {
		this.customerPIN = customerPIN;
	}
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	
	//Constructors
	
	public Customer() {
		super();
		this.customerNum = "Undefined";
		this.customerName = "Undefined";
		this.customerPIN = "Undefined";
		this.customerEmail = "Undefined";
	}
	
	public Customer(String customerNum, String customerName, String customerPIN, String customerEmail) {
		super(customerNum, EnumAccount.Checking , 0.0);
		this.customerNum = customerNum;
		this.customerName = customerName;
		this.customerPIN = customerPIN;
		this.customerEmail = customerEmail;
		
	}
	
	
	//ToString
	@Override
	public String toString() {
		return "Customer [Customer number: " + customerNum + ", Full name:" + customerName + ", PIN:"
				+ customerPIN + ", Email:" + customerEmail + "]";
	}

}
