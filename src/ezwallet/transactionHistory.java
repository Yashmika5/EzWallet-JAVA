package ezwallet;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;

public class transactionHistory extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	  private JList<String> transactionList;
	    private DefaultListModel<String> listModel;  
	    
    private user user1;
    
     String url = "jdbc:mysql://localhost:3306/ez-wallet-db";
     String username = "root";
     String password = "";


	
	public transactionHistory(user user1) {
		this.user1 = user1;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
		setResizable(false);
    	setTitle("Ez-Wallet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(330, 100, 1289, 779);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        ImageIcon originalIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png");
        Image img = originalIcon.getImage(); 
        Image scaledImg = img.getScaledInstance(24, 24, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(scaledImg); 

        ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png");
        Image img1 = originalIcon1.getImage(); 
        Image scaledImg1 = img1.getScaledInstance(24, 24, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Transactions.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_1.setBounds(529, 35, 217, 45);
        contentPane.add(lblNewLabel_1);
        
        JButton backBtn = new JButton("");
        backBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        backBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Back Button.png"));
        backBtn.setToolTipText("Back");
        backBtn.setOpaque(false);
        backBtn.setBorderPainted(false);
        backBtn.setBorder(null);
        backBtn.setBackground(new Color(255, 255, 255, 0));
        backBtn.setBounds(73, 59, 52, 52);
        contentPane.add(backBtn);
        
       
        
        listModel = new DefaultListModel<>(); 
        transactionList = new JList<>(listModel);  
        transactionList.setBorder(new LineBorder(new Color(64, 0, 128), 2, true));
        transactionList.setToolTipText("Transactions");
        transactionList.setFont(new Font("Tahoma", Font.PLAIN, 22));
        transactionList.setBounds(184, 108, 1000, 464);
        contentPane.add(transactionList);
        
        int userId = user1.getId();
        loadTransactions(userId);
        
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dashboard db2 = new dashboard(user1);
      	        db2.setVisible(true);
                  dispose();
            }
        });

    }
	
	private void loadTransactions(int userId) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();

            String transactionQuery = "SELECT * FROM transactions WHERE sender_id = " + userId + " ORDER BY dateTime DESC";
            ResultSet transactionResultSet = statement.executeQuery(transactionQuery);

            while (transactionResultSet.next()) {
                int transactionId = transactionResultSet.getInt("transaction_id");
                double amount = transactionResultSet.getDouble("amount");
                String notes = transactionResultSet.getString("notes");
                String dateTime = transactionResultSet.getString("dateTime");
                int TransactionRec = transactionResultSet.getInt("receiver_id");

                listModel.addElement("TID: " + transactionId + " | To: " + TransactionRec +" | Amount: " + amount + " | Date: " + dateTime + " | Notes: " + notes);
            }

            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error loading transactions: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

	}