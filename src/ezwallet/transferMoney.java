package ezwallet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;

import javax.swing.JToggleButton;
import javax.swing.JTextArea;
import java.awt.Toolkit;

public class transferMoney extends JFrame {

	
	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel1;
    private JTextField textField;
    private JTextField pinTxt;
    private JTextField payidTxt;
    private JTextField amountbox;
    private JTextArea notesTxt; 
    
    private String url = "jdbc:mysql://localhost:3306/ez-wallet-db";
    private String username = "root"; 
    private String password = ""; 

    
    private user user1;

	
	public transferMoney(user user1) {
		this.user1 = user1;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
		setResizable(false);
    	setTitle("Ez-Wallet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(330, 100, 1289, 810);
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
        panel.setBounds(329, 265, 617, 350);
        contentPane.add(panel);
        panel.setLayout(null);
        

        payidTxt = new JTextField();
        payidTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        payidTxt.setBounds(200, 21, 399, 45);
        panel.add(payidTxt);
        payidTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
        payidTxt.setColumns(10);
        
                lblNewLabel = new JLabel("Pay ID :");
                lblNewLabel.setBounds(10, 10, 118, 70);
                panel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\fingerprint.png")); // Set the scaled icon to the JLabel
                        

                        pinTxt = new JPasswordField();
                        pinTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                        pinTxt.setBounds(200, 281, 231, 45);
                        panel.add(pinTxt);
                        pinTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                        pinTxt.setColumns(10);
                        
                        
                        lblNewLabel1 = new JLabel("Pin Number :");
                        lblNewLabel1.setBounds(10, 270, 180, 70);
                        panel.add(lblNewLabel1);
                        lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
                        
                                lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\dialpad.png"));
                                
                                JLabel lblNotes = new JLabel("Notes :");
                                lblNotes.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pen.png"));
                                lblNotes.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblNotes.setBounds(10, 169, 118, 70);
                                panel.add(lblNotes);
                                
                                JToggleButton pwtoggleBtn = new JToggleButton("");
                                pwtoggleBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
                                pwtoggleBtn.setSelected(true);
                                pwtoggleBtn.setBackground(Color.WHITE);
                                pwtoggleBtn.setBounds(430, 281, 44, 45);
                                panel.add(pwtoggleBtn);
                                
                                notesTxt = new JTextArea();
                                notesTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                                notesTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                                notesTxt.setBounds(202, 169, 397, 91);
                                panel.add(notesTxt);
                                
                                amountbox = new JTextField();
                                amountbox.setFont(new Font("Tahoma", Font.PLAIN, 23));
                                amountbox.setColumns(10);
                                amountbox.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                                amountbox.setBounds(200, 100, 330, 45);
                                panel.add(amountbox);
                                
                                JLabel lblAmount = new JLabel("Amount :");
                                lblAmount.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\dollar-sign.png"));
                                lblAmount.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblAmount.setBounds(10, 89, 141, 70);
                                panel.add(lblAmount);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\transfer-logo.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_1.setBounds(469, 10, 337, 185);
        contentPane.add(lblNewLabel_1);
        
        JButton backBtn = new JButton("");
        backBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Back Button.png"));
        backBtn.setToolTipText("Transfer Money");
        backBtn.setOpaque(false);
        backBtn.setBorderPainted(false);
        backBtn.setBorder(null);
        backBtn.setBackground(new Color(255, 255, 255, 0));
        backBtn.setBounds(73, 59, 52, 52);
        contentPane.add(backBtn);
        
        JButton transfeBtn = new JButton("");
        transfeBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\transferbtn.png"));
        transfeBtn.setToolTipText("Transfer Money");
        transfeBtn.setOpaque(false);
        transfeBtn.setBorderPainted(false);
        transfeBtn.setBorder(null);
        transfeBtn.setBackground(new Color(255, 255, 255, 0));
        transfeBtn.setBounds(529, 643, 216, 89);
        contentPane.add(transfeBtn);
        
        transfeBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                transferMoneyf(); 
            }
        });
        
        backBtn.addActionListener(new ActionListener() {
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
	
	public void transferMoneyf() {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);
	        
	        if (payidTxt.getText().isEmpty() || pinTxt.getText().isEmpty() || notesTxt.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                return; 
            }
	        
	        String payid = payidTxt.getText();
	        String enteredPin = pinTxt.getText();
	        String notes = notesTxt.getText();

	        if (!enteredPin.equals(String.valueOf(user1.getPin()))) {
	            JOptionPane.showMessageDialog(null, "Incorrect PIN. Please enter correct pin.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        	if(Integer.parseInt(payid)==user1.getId())
	        		{
	        	 	JOptionPane.showMessageDialog(null, "You can't transfer money to your own account!", "Transfer Error", JOptionPane.ERROR_MESSAGE);
		            return;
	        		}

	        String checkPayid = "SELECT id, firstName,lastName,email, balance FROM users WHERE id = ?";
	        PreparedStatement checkPayidStatement = connection.prepareStatement(checkPayid);
	        checkPayidStatement.setString(1, payid);
	        ResultSet payidResult = checkPayidStatement.executeQuery();

	        if (!payidResult.next()) {
	            JOptionPane.showMessageDialog(null, "Invalid Pay ID. Please check and try again.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        int recipientId = payidResult.getInt("id");
	        String rFirstName = payidResult.getString("firstName");
	        String rLastname = payidResult.getString("lastName");
	        String receiverEmail = payidResult.getString("email");
	        double recipientBalance = payidResult.getDouble("balance");


	        double transferAmount;
	        try {
	            transferAmount = Double.parseDouble(amountbox.getText()); 
	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Please enter a valid amount.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        if (user1.getBalance() < transferAmount) {
	            JOptionPane.showMessageDialog(null, "Insufficient balance.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }

	        // Confirm the transfer
	        int confirm = JOptionPane.showConfirmDialog(
	            null,
	            "Are you sure you want to transfer " + transferAmount + " to " + rFirstName +" "+ rLastname + " (Pay ID: " + payid + ")?",
	            "Confirm Transfer",
	            JOptionPane.YES_NO_OPTION,
	            JOptionPane.QUESTION_MESSAGE
	        );

	        if (confirm != JOptionPane.YES_OPTION) {
	            return;
	        }

	        // sender balance updating
	        String updateSenderBal = "UPDATE users SET balance = balance - ? WHERE id = ?";
	        PreparedStatement updateSenderStatement = connection.prepareStatement(updateSenderBal);
	        updateSenderStatement.setDouble(1, transferAmount);
	        updateSenderStatement.setInt(2, user1.getId());
	        updateSenderStatement.executeUpdate();
	        
	        double senderNewBal = user1.getBalance() - transferAmount;
	        
	        user1.setBalance(senderNewBal);

	        // receiver balance updating
	        String updateReceiverbal = "UPDATE users SET balance = balance + ? WHERE id = ?";
	        PreparedStatement updateRecipientStatement = connection.prepareStatement(updateReceiverbal);
	        updateRecipientStatement.setDouble(1, transferAmount);
	        updateRecipientStatement.setInt(2, recipientId);
	        updateRecipientStatement.executeUpdate();

	        LocalDateTime currentDateTime = LocalDateTime.now();

	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);
	        
	        // transactions table inserting
	        String TransactionLog = "INSERT INTO transactions (sender_id, receiver_id, amount, notes, dateTime) VALUES (?, ?, ?, ?, ?)";
	        PreparedStatement insertLogStatement = connection.prepareStatement(TransactionLog);
	        insertLogStatement.setInt(1, user1.getId());
	        insertLogStatement.setInt(2, recipientId);
	        insertLogStatement.setDouble(3, transferAmount);
	        insertLogStatement.setString(4, notes);
	        insertLogStatement.setString(5, formattedDateTime); 
	        insertLogStatement.executeUpdate();

	        
	        connection.close();
	        
            user1.setTotalOutcome(user1.getOutcome()+ transferAmount); 

	        
	       // sendTransferEmailToReceiver(receiverEmail, rFirstName ,user1.getFirstName() ,transferAmount,notes  	);
	        
	        
	        dashboard db1 = new dashboard(user1);
	        db1.setVisible(true);
            dispose();
	        
	        
	        // sucess
	        JOptionPane.showMessageDialog(null, "Transfer successful!", "Success", JOptionPane.INFORMATION_MESSAGE);

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, "An error hapned: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        e.printStackTrace();
	    }
	}
	
	  /* 
	    	String message = "<html>"
		            + "<head>"
		            + "<style>"
		            + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; }"
		            + ".container { background-color: #ffffff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }"
		            + "h2 { color: #333; }"
		            + ".details { margin-top: 20px; font-size: 16px; }"
		            + ".details span { font-weight: bold; }"
		            + ".footer { font-size: 12px; color: #999; margin-top: 20px; }"
		            + "</style>"
		            + "</head>"
		            + "<body>"
		            + "<div class='container'><center>"
		            + "<h2>You Received Money!</h2>"
		            + "<h4>Hello " + receiverName + "!</h4>"
		            + "<p>You have received a transfer of <span class='details'>" + amount + " LKR</span> from <span class='details'>" + senderName + "</span>.</p>"
		            + "<p><strong>Notes: </strong>" + transferNotes + "</p>"
		            + "<p>Login to your Ez-Wallet account to view your updated balance.</p>"
		            + "<p class='footer'>Thank you for using Ez-Wallet!</p>"
		            + "</center></div>"
		            + "</body>"
		            + "</html>";
*/

	}


