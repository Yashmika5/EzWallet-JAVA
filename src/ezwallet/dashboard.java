package ezwallet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class dashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
    private user user;


	public dashboard(user user1) {
		this.user = user1;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
		setTitle("EZ-Wallet");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 100, 1289, 868);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(69, 25, 125));
		panel.setBounds(0, 0, 313, 865);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\logo-white2.png"));
		lblNewLabel.setBounds(10, 38, 283, 82);
		panel.add(lblNewLabel);
		
		JButton walletBtn = new JButton("");
		walletBtn.setToolTipText("Go to Wallet");
		walletBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		walletBtn.setBorderPainted(false);
		walletBtn.setBorder(null);
		walletBtn.setBackground(new Color(69, 25, 125));
		walletBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\wallet-button.png"));
		walletBtn.setFont(new Font("Sofia Pro", Font.BOLD, 26));
		walletBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		walletBtn.setBounds(10, 187, 293, 82);
		panel.add(walletBtn);
		
		JButton trBtn = new JButton("");
		trBtn.setToolTipText("Transaction History");
		trBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		trBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\transactions-button.png"));
		trBtn.setFont(new Font("Sofia Pro", Font.BOLD, 26));
		trBtn.setBorderPainted(false);
		trBtn.setBorder(null);
		trBtn.setBackground(new Color(69, 25, 125));
		trBtn.setBounds(10, 301, 293, 82);
		panel.add(trBtn);
		
		JButton settingBtn = new JButton("");
		settingBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\settingss.png"));
		settingBtn.setToolTipText("Go to settings");
		settingBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		settingBtn.setFont(new Font("Sofia Pro", Font.BOLD, 26));
		settingBtn.setBorderPainted(false);
		settingBtn.setBorder(null);
		settingBtn.setBackground(new Color(69, 25, 125));
		settingBtn.setBounds(10, 409, 293, 82);
		panel.add(settingBtn);
		

		JLabel lblNewLabel_2_1 = new JLabel("Welcome, "+user.getFirstName()+"!");
		lblNewLabel_2_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_1.setFont(new Font("Sofia Pro", Font.PLAIN, 29));
		lblNewLabel_2_1.setBounds(514, 60, 398, 28);
		contentPane.add(lblNewLabel_2_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(514, 115, 537, 165);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_2 = new JLabel("Pay ID");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Sofia Pro", Font.PLAIN, 24));
		lblNewLabel_2_2.setBounds(364, 50, 97, 28);
		panel_1.add(lblNewLabel_2_2);
		
		int userId = user.getId();
		JLabel payIdLabel = new JLabel(String.valueOf(userId));
		payIdLabel.setToolTipText("Your Pay ID");
		payIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		payIdLabel.setForeground(Color.WHITE);
		payIdLabel.setFont(new Font("Sofia Pro", Font.BOLD, 30));
		payIdLabel.setBounds(299, 79, 210, 36);
		panel_1.add(payIdLabel);
		
		JLabel balanceLabel = new JLabel("LKR " + String.format("%,.2f", user.getBalance()));
		balanceLabel.setToolTipText("Your Balance");
		balanceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		balanceLabel.setForeground(Color.WHITE);
		balanceLabel.setFont(new Font("Sofia Pro", Font.BOLD, 30));
		balanceLabel.setBounds(30, 79, 250, 36);
		panel_1.add(balanceLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Balance ");
		lblNewLabel_2.setBounds(84, 50, 97, 28);
		panel_1.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Sofia Pro", Font.PLAIN, 24));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(10, 10, 524, 149);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Info Section.png"));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(565, 335, 455, 165);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton transferBtn = new JButton("");
		
		transferBtn.setBounds(10, 10, 126, 142);
		panel_2.add(transferBtn);
		transferBtn.setToolTipText("Transfer Money");
		transferBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		transferBtn.setBorderPainted(false);
		transferBtn.setBorder(null);
		transferBtn.setBackground(new Color(255, 255, 255,0));
		transferBtn.setOpaque(false); 
		transferBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Frame 67.png"));
		
		JButton TopupBtn = new JButton("");
		TopupBtn.setBounds(317, 10, 126, 142);
		panel_2.add(TopupBtn);
		TopupBtn.setToolTipText("Topup your wallet");
		TopupBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TopupBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Frame68.png"));
		TopupBtn.setOpaque(false);
		TopupBtn.setBorderPainted(false);
		TopupBtn.setBorder(null);
		TopupBtn.setBackground(new Color(255, 255, 255, 0));
		
		JButton profileBtn = new JButton("");
		profileBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\avatar2.png"));
		profileBtn.setToolTipText("View your profile");
		profileBtn.setOpaque(false);
		profileBtn.setBorderPainted(false);
		profileBtn.setBorder(null);
		profileBtn.setBackground(new Color(255, 255, 255, 0));
		profileBtn.setBounds(1146, 39, 76, 76);
		contentPane.add(profileBtn);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(456, 525, 680, 258);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(26, 166, 33), 3, true));
		panel_4.setBounds(10, 10, 241, 238);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(85, 6, 70, 70);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Arrow - Top1.png"));
		panel_4.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("");
		lblNewLabel_3_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\INCOME5.png"));
		lblNewLabel_3_1.setBounds(68, 75, 116, 39);
		panel_4.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_4 = new JLabel("+LKR "+String.format("%,.2f", user.getIncome()));
		lblNewLabel_4.setFont(new Font("Sofia Pro", Font.PLAIN, 24));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 131, 221, 47);
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_4_1 = new JPanel();
		panel_4_1.setLayout(null);
		panel_4_1.setBorder(new LineBorder(new Color(183, 0, 32), 3, true));
		panel_4_1.setBounds(429, 10, 241, 238);
		panel_3.add(panel_4_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Arrow - Bottom.png"));
		lblNewLabel_3_2.setBounds(85, 6, 70, 70);
		panel_4_1.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\OUTCOME.png"));
		lblNewLabel_3_1_1.setBounds(50, 75, 141, 39);
		panel_4_1.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("-LKR "+String.format("%,.2f", user.getOutcome()));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setFont(new Font("Sofia Pro", Font.PLAIN, 24));
		lblNewLabel_4_1.setBounds(10, 131, 221, 47);
		panel_4_1.add(lblNewLabel_4_1);
		
		// btns
		trBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	transactionHistory trHistory = new transactionHistory(user);
	        	trHistory.setVisible(true);
           	 dispose();

	        }
		});
		walletBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	dashboard dashb = new dashboard(user);
	        	dashb.setVisible(true);
           	 dispose();

	        }
		});
		
		transferBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	transferMoney transferForm = new transferMoney(user);
           	 transferForm.setVisible(true);
           	 dispose();

	        }
		});
		
		TopupBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	toupWallet topupForm = new toupWallet(user);
	        	topupForm.setVisible(true);
           	 dispose();

	        }
		});
		
		settingBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	Settings settingspage = new Settings(user);
	        	settingspage.setVisible(true);
           	 	dispose();

	        }
		});
		
		profileBtn.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	        	profile ProfilePage = new profile(user);
	        	ProfilePage.setVisible(true);
           	 	dispose();

	        }
		});
		
		
	}
}
