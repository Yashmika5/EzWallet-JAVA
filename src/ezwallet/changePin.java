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

public class changePin extends JFrame {

	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel1;
    private JTextField textField;
    private JPasswordField pwTxt;
    private JPasswordField oldpinTxt;
    private JPasswordField newPinTxt;
    private user user1;
    
    String url="jdbc:mysql://localhost:3306/ez-wallet-db";
   	String username="root";
   	String password="";

	
	public changePin(user user1) {
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

        // Smooth scaling for the image
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png");
        Image img = originalIcon.getImage(); // Get the original image
        Image scaledImg = img.getScaledInstance(24, 24, Image.SCALE_SMOOTH); // Scale it
        ImageIcon scaledIcon = new ImageIcon(scaledImg); // Set it to a new ImageIcon

        // Smooth scaling for the image
        ImageIcon originalIcon1 = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png");
        Image img1 = originalIcon1.getImage(); // Get the original image
        Image scaledImg1 = img1.getScaledInstance(24, 24, Image.SCALE_SMOOTH); // Scale it
        ImageIcon scaledIcon1 = new ImageIcon(scaledImg1); // Set it to a new ImageIcon
       

        JPanel panel = new JPanel();
        panel.setBounds(363, 183, 548, 283);
        contentPane.add(panel);
        panel.setLayout(null);
        
                lblNewLabel = new JLabel("Old Pin :");
                lblNewLabel.setBounds(71, 10, 119, 70);
                panel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\dialpad.png")); // Set the scaled icon to the JLabel
                        

                        pwTxt = new JPasswordField();
                        pwTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                        pwTxt.setBounds(199, 215, 280, 45);
                        panel.add(pwTxt);
                        pwTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                        pwTxt.setColumns(10);
                        
                        
                        lblNewLabel1 = new JLabel("Password :");
                        lblNewLabel1.setBounds(44, 203, 145, 70);
                        panel.add(lblNewLabel1);
                        lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
                        
                                lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\key-squarebig.png"));
                                
                                JToggleButton pwtoggleBtn = new JToggleButton("");
                                pwtoggleBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
                                pwtoggleBtn.setSelected(true);
                                pwtoggleBtn.setBackground(Color.WHITE);
                                pwtoggleBtn.setBounds(478, 215, 44, 45);
                                panel.add(pwtoggleBtn);
                                
                                oldpinTxt = new JPasswordField();
                                oldpinTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                                oldpinTxt.setColumns(10);
                                oldpinTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                                oldpinTxt.setBounds(207, 20, 231, 45);
                                panel.add(oldpinTxt);
                                
                                JToggleButton pwtoggleBtn_1 = new JToggleButton("");
                                pwtoggleBtn_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
                                pwtoggleBtn_1.setSelected(true);
                                pwtoggleBtn_1.setBackground(Color.WHITE);
                                pwtoggleBtn_1.setBounds(436, 20, 44, 45);
                                panel.add(pwtoggleBtn_1);
                                
                                JLabel lblNewPin = new JLabel("New Pin :");
                                lblNewPin.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\dialpad.png"));
                                lblNewPin.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblNewPin.setBounds(58, 110, 132, 70);
                                panel.add(lblNewPin);
                                
                                newPinTxt = new JPasswordField();
                                newPinTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
                                newPinTxt.setColumns(10);
                                newPinTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                                newPinTxt.setBounds(207, 120, 231, 45);
                                panel.add(newPinTxt);
                                
                                JToggleButton pwtoggleBtn_1_1 = new JToggleButton("");
                                pwtoggleBtn_1_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
                                pwtoggleBtn_1_1.setSelected(true);
                                pwtoggleBtn_1_1.setBackground(Color.WHITE);
                                pwtoggleBtn_1_1.setBounds(436, 120, 44, 45);
                                panel.add(pwtoggleBtn_1_1);

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Change Pin Number.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_1.setBounds(447, 31, 381, 52);
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
        
        JButton changePin = new JButton("");
        changePin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        changePin.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\changepin-btnn.png"));
        changePin.setToolTipText("Change Pin");
        changePin.setOpaque(false);
        changePin.setBorderPainted(false);
        changePin.setBorder(null);
        changePin.setBackground(new Color(255, 255, 255, 0));
        changePin.setBounds(529, 519, 216, 89);
        contentPane.add(changePin);
        
        pwtoggleBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pwtoggleBtn.isSelected()) {
                    // Hide 
                    pwTxt.setEchoChar('•'); 
                } else {
                    // Show 
                	pwTxt.setEchoChar((char) 0); 
                }
            }
        });
        
        pwtoggleBtn_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pwtoggleBtn_1.isSelected()) {
                    // Hide 
                    oldpinTxt.setEchoChar('•'); 
                } else {
                    // Show 
                	oldpinTxt.setEchoChar((char) 0); 
                }
            }
        });
        
        pwtoggleBtn_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (pwtoggleBtn_1_1.isSelected()) {
                    // Hide 
                    newPinTxt.setEchoChar('•'); 
                } else {
                    // Show 
                	newPinTxt.setEchoChar((char) 0); 
                }
            }
        });
        
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Settings settingss = new Settings(user1);
            	settingss.setVisible(true);
                  dispose();
            }
        });
		
				
        changePin.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	changePinF();
		    }
		});
    }
	
	
	private void changePinF() {
	   
	    String newPin = new String(newPinTxt.getPassword()).trim();
	    String oldPin = new String(oldpinTxt.getPassword()).trim();
	    String Passwordg = new String(pwTxt.getPassword()).trim();

	    if (newPin.isEmpty() || oldPin.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	   
	  
	    if(Passwordg.isEmpty())
	    {
	        JOptionPane.showMessageDialog(null, "Please Enter password to Change pin!", "Error", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);

	        String checkPasswordQuery = "SELECT password,pin FROM users WHERE id = ?";
	        PreparedStatement checkPasswordStmt = connection.prepareStatement(checkPasswordQuery);
	        checkPasswordStmt.setInt(1, user1.getId());
	        ResultSet resultSet = checkPasswordStmt.executeQuery();
	        String dbPassword;
	        String dbPin;

	        if (resultSet.next()) {
	             dbPassword = resultSet.getString("password");
	             dbPin = resultSet.getString("pin");
	             
	             if (!dbPin.equals(oldPin)) {
	            	 JOptionPane.showMessageDialog(null, "Entered pin is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
		                return;
	             }
	             
	            if (!dbPassword.equals(Passwordg)) {
	                JOptionPane.showMessageDialog(null, "Entered password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        

	        String updateCommand = "UPDATE users SET pin = ? WHERE id = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateCommand);
	        updateStatement.setString(1, newPin); 
	        updateStatement.setInt(2, user1.getId());

	        int rowsAffected = updateStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            JOptionPane.showMessageDialog(null, "Pin Number updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	           newPinTxt.setText("");
	           oldpinTxt.setText("");
	           pwTxt.setText("");

	            
	        } else {
	            JOptionPane.showMessageDialog(null, "Pin number update failed", "Error", JOptionPane.ERROR_MESSAGE);
	        }

	        resultSet.close();
	        checkPasswordStmt.close();
	        updateStatement.close();
	        connection.close();

	    } catch (Exception ex) {
	        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        ex.printStackTrace(); 
	    }
	}
	}