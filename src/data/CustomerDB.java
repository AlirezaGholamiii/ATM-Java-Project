package data;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import bus.Customer;


public class CustomerDB {

	public static int insert(Customer record) throws SQLException
	{
		int success = -1;
		
		Connection currentConnection = null; 
		Statement currentStatement = null; 
		String request;
		
		currentConnection = ConnectionDB.getConnection();
		
		currentStatement = currentConnection.createStatement() ;
		
		request = "insert into customers  values (' "
				+ record.getAccountNum() + "', '" + record.getCustomerName() 
				+ "' , '" + record.getCustomerPIN() + "' , '" + record.getCustomerEmail() + "')";
		
        success = currentStatement.executeUpdate(request);		
		
		
		return success;
		
	}
}
