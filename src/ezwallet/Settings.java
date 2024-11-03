package ezwallet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class Settings extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    
    private user user1;


    
	public Settings(user user1) {
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

        // Smooth scaling for the image
        ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png");
        Image img1 = originalIcon1.getImage(); 
        Image scaledImg1 = img1.getScaledInstance(24, 24, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1); 
       

        JPanel panel = new JPanel();
        panel.setBounds(448, 228, 379, 206);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JButton btnNewButton_2_2 = new JButton("");
        btnNewButton_2_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_2_2.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\profile-edit-btn.png"));
        btnNewButton_2_2.setToolTipText("Edit your profile");
        btnNewButton_2_2.setOpaque(false);
        btnNewButton_2_2.setBorderPainted(false);
        btnNewButton_2_2.setBorder(null);
        btnNewButton_2_2.setBackground(new Color(255, 255, 255, 0));
        btnNewButton_2_2.setBounds(12, 29, 354, 72);
        panel.add(btnNewButton_2_2);
        
        JButton btnNewButton_2_2_1 = new JButton("");
        btnNewButton_2_2_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNewButton_2_2_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\changepin-btn.png"));
        btnNewButton_2_2_1.setToolTipText("Change your pin Number");
        btnNewButton_2_2_1.setOpaque(false);
        btnNewButton_2_2_1.setBorderPainted(false);
        btnNewButton_2_2_1.setBorder(null);
        btnNewButton_2_2_1.setBackground(new Color(255, 255, 255, 0));
        btnNewButton_2_2_1.setBounds(12, 119, 354, 72);
        panel.add(btnNewButton_2_2_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Settings-header.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_1.setBounds(560, 83, 154, 45);
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
        
        JButton logoutBtn = new JButton("");
        logoutBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        logoutBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Logout2.png"));
        logoutBtn.setToolTipText("Logout from accounnt");
        logoutBtn.setOpaque(false);
        logoutBtn.setBorderPainted(false);
        logoutBtn.setBorder(null);
        logoutBtn.setBackground(new Color(255, 255, 255, 0));
        logoutBtn.setBounds(1104, 548, 111, 131);
    
        contentPane.add(logoutBtn);
        
        backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dashboard db2 = new dashboard(user1);
      	        db2.setVisible(true);
                  dispose();
            }
        });
        
        btnNewButton_2_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	editProfile pofileEdit = new editProfile(user1);
            	pofileEdit.setVisible(true);
                  dispose();
            }
        });
        
        btnNewButton_2_2_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	changePin changePinNo = new changePin(user1);
            	changePinNo.setVisible(true);
                  dispose();
            }
        });
        
        logoutBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Login loginPanel = new Login();
            	loginPanel.setVisible(true);
                  dispose();
                  JOptionPane.showMessageDialog(null, "Logged out from the account!", "Succes", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        
    }
	}
