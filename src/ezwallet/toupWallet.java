package ezwallet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class toupWallet extends JFrame {


	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel1;
    private JTextField textField;
    private JTextField pinTxt;
    private JTextField amountTxt;
    private JTextArea notesTxt;
    
    private String url = "jdbc:mysql://localhost:3306/ez-wallet-db";
    private String username = "root"; 
    private String password = ""; 

    
    private user user1;


	public toupWallet(user user1) {
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
       

        JPanel panel = new JPanel();
        panel.setBounds(329, 220, 617, 283);
        contentPane.add(panel);
        panel.setLayout(null);
        

        amountTxt = new JTextField();
        amountTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        amountTxt.setBounds(200, 21, 294, 45);
        panel.add(amountTxt);
        amountTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
        amountTxt.setColumns(10);
        
                lblNewLabel = new JLabel("Amount :");
                lblNewLabel.setBounds(10, 10, 132, 70);
                panel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\dollar-sign.png")); // Set the scaled icon to the JLabel
                        

                        pinTxt = new JTextField();
                        pinTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                        pinTxt.setBounds(200, 202, 231, 45);
                        panel.add(pinTxt);
                        pinTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                        pinTxt.setColumns(10);
                        
                        
                        lblNewLabel1 = new JLabel("Pin Number :");
                        lblNewLabel1.setBounds(10, 191, 180, 70);
                        panel.add(lblNewLabel1);
                        lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
                        
                                lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\dialpad.png"));
                                
                                JLabel lblNotes = new JLabel("Notes :");
                                lblNotes.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pen.png"));
                                lblNotes.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblNotes.setBounds(10, 90, 118, 70);
                                panel.add(lblNotes);
                                
                                JToggleButton pwtoggleBtn = new JToggleButton("");
                                pwtoggleBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
                                pwtoggleBtn.setSelected(true);
                                pwtoggleBtn.setBackground(Color.WHITE);
                                pwtoggleBtn.setBounds(430, 202, 44, 45);
                                panel.add(pwtoggleBtn);
                                
                                notesTxt = new JTextArea();
                                notesTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                                notesTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                                notesTxt.setBounds(202, 90, 397, 91);
                                panel.add(notesTxt);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\toup-logo.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_1.setBounds(484, 10, 306, 185);
        contentPane.add(lblNewLabel_1);
        
        JButton backbtn = new JButton("");
        backbtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Back Button.png"));
        backbtn.setToolTipText("Back");
        backbtn.setOpaque(false);
        backbtn.setBorderPainted(false);
        backbtn.setBorder(null);
        backbtn.setBackground(new Color(255, 255, 255, 0));
        backbtn.setBounds(73, 59, 52, 52);
        contentPane.add(backbtn);
        
        JButton topupbtn = new JButton("");
        topupbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        topupbtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\topupbtn.png"));
        topupbtn.setToolTipText("topup");
        topupbtn.setOpaque(false);
        topupbtn.setBorderPainted(false);
        topupbtn.setBorder(null);
        topupbtn.setBackground(new Color(255, 255, 255, 0));
        topupbtn.setBounds(529, 534, 216, 89);
        contentPane.add(topupbtn);
        
        topupbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	topupWalletF(); 
            }
        });
        
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dashboard db2 = new dashboard(user1);
      	        db2.setVisible(true);
                  dispose();
            }
        });
        
        pwtoggleBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (pwtoggleBtn.isSelected()) {
                    // Hide 
                    ((JPasswordField) pinTxt).setEchoChar('•'); 
                } else {
                    // Show 
                	((JPasswordField) pinTxt).setEchoChar((char) 0); 
                }
            }
        });
        
    }
	public void topupWalletF() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);
	        
	        if (amountTxt.getText().isEmpty() || notesTxt.getText().isEmpty() || pinTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
	        
	        String payid = String.valueOf(user1.getId());
	        String enteredPin = pinTxt.getText();
	        String notes = notesTxt.getText();

	        if (!enteredPin.equals(String.valueOf(user1.getPin()))) {
	            JOptionPane.showMessageDialog(null, "Incorrect PIN. Please enter correct pin.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        String checkPayid = "SELECT id FROM users WHERE id = ?";
	        PreparedStatement checkPayidStatement = connection.prepareStatement(checkPayid);
	        checkPayidStatement.setString(1, payid);
	        ResultSet payidResult = checkPayidStatement.executeQuery();

	        if (!payidResult.next()) {
	            JOptionPane.showMessageDialog(null, "Invalid Pay ID. Please check and try again.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        //double recipientBalance = payidResult.getDouble("balance");


	        double toupupAmount;
	        try {
	        	toupupAmount = Double.parseDouble(amountTxt.getText()); 
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	       
	        // Confirm the transfer
	        int confirm = JOptionPane.showConfirmDialog(
	            null,
	            "Are you sure you want to topup LKR "+toupupAmount+" to your account?",
	            "Confirm Topup",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE
	        );

	        if (confirm != JOptionPane.YES_OPTION) {
	            return;
	        }

	        //  balance updating
	        String updateSenderBal = "UPDATE users SET balance = balance + ? WHERE id = ?";
	        PreparedStatement updateSenderStatement = connection.prepareStatement(updateSenderBal);
	        updateSenderStatement.setDouble(1, toupupAmount);
	        updateSenderStatement.setInt(2, user1.getId());
	        updateSenderStatement.executeUpdate();
	        
	        double NewBal = user1.getBalance() + toupupAmount;
	        
	        user1.setBalance(NewBal);

	        LocalDateTime currentDateTime = LocalDateTime.now();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
	        
	        // transactions table inserting
	        String TransactionLog = "INSERT INTO topup_history (userId, amount, notes, dateTime) VALUES (?, ?, ?, ?)";
	        PreparedStatement insertLogStatement = connection.prepareStatement(TransactionLog);
	        insertLogStatement.setInt(1, user1.getId());
	        insertLogStatement.setDouble(2, toupupAmount);
	        insertLogStatement.setString(3, notes);
	        insertLogStatement.setString(4, formattedDateTime);


	   
	        insertLogStatement.executeUpdate();

	        connection.close();
	        
	        
	        dashboard db1 = new dashboard(user1);
	        db1.setVisible(true);
            dispose();
	        
	        
	        // sucess
	        JOptionPane.showMessageDialog(null, "Wallet Top-up succesful!", "Success", JOptionPane.INFORMATION_MESSAGE);

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "An error hapnned: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}
	}
