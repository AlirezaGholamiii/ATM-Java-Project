package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import bus.Customer;
import bus.ValidatorGUI;
import data.CustomerDB;
import net.proteanit.sql.DbUtils;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class UptadeCustomerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNum;
	private JTextField txtName;
	private JTextField txtPin;
	private JTextField txtEmail;
	public static String number;
	JButton btnUpdate = new JButton("Update");
	JButton okButton = new JButton("Search");
	JButton btnReset = new JButton("Reset");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UptadeCustomerGUI dialog = new UptadeCustomerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setLocationRelativeTo(dialog);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */


	public UptadeCustomerGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("..\\BankFortisApplication\\icon\\business-and-finance-glyph-13-512.png"));
		setResizable(false);
		setTitle("Update Customer");
		setBounds(100, 100, 441, 259);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Customer Number :");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 26, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("Customer Name:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 64, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("Customer Pin:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 99, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel = new JLabel("Customer Email:");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblNewLabel.setBounds(26, 138, 141, 13);
			contentPanel.add(lblNewLabel);
		}
		
		txtNum = new JTextField();
		txtNum.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtNum.setBounds(164, 26, 123, 28);
		contentPanel.add(txtNum);
		txtNum.setColumns(10);
		{
			txtName = new JTextField();
			txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtName.setColumns(10);
			txtName.setBounds(164, 64, 206, 28);
			contentPanel.add(txtName);
		}
		{
			txtPin = new JTextField();
			txtPin.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtPin.setColumns(10);
			txtPin.setBounds(164, 99, 206, 28);
			contentPanel.add(txtPin);
		}
		{
			txtEmail = new JTextField();
			txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
			txtEmail.setColumns(10);
			txtEmail.setBounds(164, 138, 206, 28);
			contentPanel.add(txtEmail);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				{
					
					btnReset.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							
							
							
							txtName.setText(null);
							txtPin.setText(null);
							txtEmail.setText(null);

							txtName.requestFocus();
						}
					});
					{
						
						btnUpdate.setEnabled(false);
						btnReset.setEnabled(false);
						btnUpdate.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								
								String num, name, pin, email;
								
								
								
								num = txtNum.getText().trim();
								name = txtName.getText().trim();
								pin = txtPin.getText().trim();
								email = txtEmail.getText().trim();
								
								if(name.isEmpty() || pin.isEmpty() || email.isEmpty())
								{
									JOptionPane.showMessageDialog(null, "Please Enter A Valid Input For Each Feild!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
								}
								else
								{
									StringBuilder warnning = new StringBuilder();
									
									
									if(ValidatorGUI.ValiCustomerName(name)== false)
									{warnning.append("Please Enter A Valid Name With 2 to 10 Characters!\n");}
									
									if(ValidatorGUI.ValiCustomerPin(pin)== false)
									{warnning.append("Please Enter A Valid Pin With 4 Digits!\n");}
									
									if(ValidatorGUI.ValiCustomerEmail(email)== false)
									{warnning.append("Please Enter A Valid Email Address!\n");}
									
								
									if(warnning.length() > 0)
									{
										JOptionPane.showMessageDialog(null, warnning.toString(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
										
										
									}
									else
									{
										
										
								        try {
								        	
											if (  Customer.Update(num, name, pin, email)  > 0 )
											 {
												
												   JOptionPane.showMessageDialog(null, " The Information Updated Successfully" , "Success Operation",JOptionPane.INFORMATION_MESSAGE);
												   setVisible(false);
												   BankGUIAppDB.loadTable();
												   BankGUIAppDB.setDateTime();
											 }
											else
											 {
												JOptionPane.showMessageDialog(null, "This Customer Number Does Not Exist! Try Again.", "Incomplete operation", JOptionPane.ERROR_MESSAGE);
												txtNum.setText("");
												txtNum.requestFocus();
											}
										} catch (HeadlessException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (SQLException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									}
								}
							}
						});
						btnUpdate.setActionCommand("OK");
						buttonPane.add(btnUpdate);
					}
					buttonPane.add(btnReset);
				}
				   txtName.setEnabled(false);
				   txtPin.setEnabled(false);
				   txtEmail.setEnabled(false);
				   {
				   	okButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
				   	okButton.setBounds(297, 26, 73, 28);
				   	contentPanel.add(okButton);
				   	
				   	okButton.addActionListener(new ActionListener() {
				   		public void actionPerformed(ActionEvent e) {

				   			String num;
				   			num = txtNum.getText();
				   		
				   			
				   			if(num.isEmpty())
				   			{
				   				JOptionPane.showMessageDialog(null, "Please Enter A Valid Customer Number!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				   			}
				   			else
				   			{
				   				StringBuilder warnning = new StringBuilder();
				   				
				   				if(ValidatorGUI.ValiCustomerUpdateNumber(num) == false)
				   				{warnning.append("Please Enter A Valid Customer Number With 5 Digits!\n");}
				   				
				   			
				   				if(warnning.length() > 0)
				   				{
				   					JOptionPane.showMessageDialog(null, warnning.toString(), "Invalid Input", JOptionPane.ERROR_MESSAGE);
				   					
				   					
				   				}
				   				else
				   				{
				   			        try {
				   						if (! Customer.Search(num).next() == false)
				   						 {
				   							
				   						
				   							   JOptionPane.showMessageDialog(null, " The Customer Successfully Found." , "successful Operation",JOptionPane.INFORMATION_MESSAGE);
				   							   
				   							 
				   							   try
				   								{
				   								 
				   								   txtName.setEnabled(true);
				   								   txtPin.setEnabled(true);
				   								   txtEmail.setEnabled(true);
				   								   btnUpdate.setEnabled(true);
				   								   btnReset.setEnabled(true);
				   								   okButton.setEnabled(false);
				   								   txtNum.setEditable(false);
				   								
				   										 
				   										   try
				   											{
				   											Customer cus = new Customer();
				   											cus = CustomerDB.SearchGetter(txtNum.getText());
				   											
				   											txtPin.setEnabled(true);
				   											txtEmail.setEnabled(true);
				   											txtName.setText(cus.getCustomerName());
							   								txtPin.setText(cus.getCustomerPIN());
							   								txtEmail.setText(cus.getCustomerEmail());
  
				   											}
				   											catch(Exception e1)
				   											{
				   												e1.printStackTrace();
				   												
				   											}
  
				   								}
				   								catch(Exception e1)
				   								{
				   									e1.printStackTrace();
				   									
				   								}
				   							   
				   						 }
				   						else
				   						 {
				   							JOptionPane.showMessageDialog(null, " This Customer Does Not Exist! Try Again.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
				   							txtNum.setText("");
				   							txtNum.requestFocus();
				   						}
				   					} catch (HeadlessException e1) {
				   						// TODO Auto-generated catch block
				   						e1.printStackTrace();
				   					} catch (SQLException e1) {
				   						// TODO Auto-generated catch block
				   						e1.printStackTrace();
				   					}
				   					
				   				}
				   			}
				   		}
				   	});
				   	okButton.setActionCommand("OK");
				   	getRootPane().setDefaultButton(okButton);
				   }
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
