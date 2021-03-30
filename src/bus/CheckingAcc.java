package bus;

public class CheckingAcc extends Account {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int limitNumberTransaction;

	public CheckingAcc(int accountBalance, String ownerID, int limitNumberTransaction) {
		super(accountBalance, ownerID);
		this.limitNumberTransaction = limitNumberTransaction;
	}
	
	public CheckingAcc() {
		super();
		this.limitNumberTransaction = 0;
	}

	public int getLimitNumberTransaction() {
		return limitNumberTransaction;
	}

	public void setLimitNumberTransaction(int limitNumberTransaction) {
		this.limitNumberTransaction = limitNumberTransaction;
	}

	@Override
	public String toString() {
		return super.toString()+"CheckingAcc [limitNumberTransaction=" + limitNumberTransaction + "]";
	}

	



}
