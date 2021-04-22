package client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BankGUIAppDB {

	private JFrame frmBankApplication;
	private JTable tableCustomers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankGUIAppDB window = new BankGUIAppDB();
					window.frmBankApplication.setVisible(true);
					window.frmBankApplication.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankGUIAppDB() {
		initialize();
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBankApplication = new JFrame();
		frmBankApplication.setResizable(false);
		frmBankApplication.setTitle("Bank Application");
		frmBankApplication.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmBankApplication.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 10, 671, 455);
		frmBankApplication.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnAdd = new JButton("Add Customer");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCustomerGUI addmenu = new AddCustomerGUI();
				addmenu.setVisible(true);
			}
		});
		btnAdd.setBounds(266, 381, 85, 21);
		panel.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.setBounds(361, 381, 85, 21);
		panel.add(btnRemove);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(456, 381, 85, 21);
		panel.add(btnUpdate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(551, 381, 85, 21);
		panel.add(btnReset);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(23, 83, 629, 257);
		panel.add(scrollPane);
		
		tableCustomers = new JTable();
		tableCustomers.setRowSelectionAllowed(false);
		tableCustomers.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scrollPane.setViewportView(tableCustomers);
		tableCustomers.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Customer Number", "Name", "Pin", "Email"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCustomers.getColumnModel().getColumn(0).setPreferredWidth(100);
		
		JLabel lblNewLabel = new JLabel("All Customers");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(244, 10, 161, 36);
		panel.add(lblNewLabel);
		frmBankApplication.setBackground(Color.GRAY);
		frmBankApplication.setBounds(100, 100, 708, 534);
		frmBankApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmBankApplication.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Help");
		mnNewMenu.setForeground(Color.GRAY);
		mnNewMenu.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(mnNewMenu);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmBankApplication.setVisible(false);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnNewMenu.add(btnExit);
	}
	
	
}
