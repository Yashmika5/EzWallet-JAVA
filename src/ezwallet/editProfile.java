package ezwallet;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
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
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class editProfile extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField fnameTxt;
	private JTextField lnameTxt;
	private JTextField emailTxt;
	private JTextField textField3;
	private JPasswordField pwTxt;
	private JTextField mobileTxt;
	private JTextField nicTxt;
	private JPasswordField confirmPwTxt;
	private JPasswordField oldpwTxt;
	
    private user user1;
    
    String url="jdbc:mysql://localhost:3306/ez-wallet-db";
   	String username="root";
   	String password="";


	
	public editProfile(user user1) {
		this.user1 = user1;
		setTitle("EZ-Wallet");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(330, 100, 1311, 897);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel.setToolTipText("Show/Hide Password");
		panel.setBounds(143, 112, 1010, 466);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//first name 
		JLabel lblNewLabel_1 = new JLabel("First Name :");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\profile.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(12, 33, 139, 24);
		panel.add(lblNewLabel_1);
		
		fnameTxt = new JTextField();
		fnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fnameTxt.setBounds(10, 67, 431, 40);
		panel.add(fnameTxt);
		fnameTxt.setColumns(10);
		
		//lastname 
		JLabel lblNewLabel_2 = new JLabel("Last Name :");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\profile.png"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(573, 33, 139, 24);
		panel.add(lblNewLabel_2);
		
		lnameTxt = new JTextField();
		lnameTxt.setBounds(574, 67, 431, 40);
		panel.add(lnameTxt);
		lnameTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lnameTxt.setColumns(10);
		//Email
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png"));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(12, 143, 119, 24);
		panel.add(lblNewLabel_3);
		
		emailTxt = new JTextField();
		emailTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailTxt.setBounds(10, 177, 431, 40);
		panel.add(emailTxt);
		emailTxt.setColumns(10);	
		//mobile no
		JLabel lblNewLabel_4 = new JLabel(" Mobile :");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\call-calling.png"));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(573, 143, 119, 24);
		panel.add(lblNewLabel_4);
		
		mobileTxt = new JTextField();
		mobileTxt.setToolTipText("Mobile Number");
		mobileTxt.setBounds(574, 177, 431, 40);
		panel.add(mobileTxt);
		mobileTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		mobileTxt.setColumns(10);
		//password
		JLabel lblNewLabel_5 = new JLabel("New Password :");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\key-square.png"));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(12, 253, 190, 24);
		panel.add(lblNewLabel_5);
		
		pwTxt = new JPasswordField();
		pwTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pwTxt.setBounds(10, 287, 397, 40);
		panel.add(pwTxt);
		pwTxt.setColumns(10);	
		//confirm password
		JLabel lblNewLabel_6 = new JLabel("Confirm New Password :");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\key-square.png"));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(573, 253, 252, 24);
		panel.add(lblNewLabel_6);
		
		confirmPwTxt = new JPasswordField();
		confirmPwTxt.setBounds(574, 287, 431, 40);
		panel.add(confirmPwTxt);
		confirmPwTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		confirmPwTxt.setColumns(10);
		//nic no
				JLabel lblNewLabel_7 = new JLabel("NIC Number :");
				lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\id.png"));
				lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
				lblNewLabel_7.setBounds(429, 363, 151, 24);
				panel.add(lblNewLabel_7);
				
				nicTxt = new JTextField();
				nicTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
				nicTxt.setBounds(289, 397, 431, 40);
				panel.add(nicTxt);
				nicTxt.setColumns(10);
				
				JToggleButton pwtoggleBtn = new JToggleButton("");
				pwtoggleBtn.setBackground(new Color(255, 255, 255));
				pwtoggleBtn.setSelected(true);
				pwtoggleBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
				pwtoggleBtn.setBounds(406, 287, 44, 40);
				panel.add(pwtoggleBtn);
				
				  pwtoggleBtn.addActionListener(new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                if (pwtoggleBtn.isSelected()) {
			                    // Hide 
			                    pwTxt.setEchoChar('•'); 
			                    confirmPwTxt.setEchoChar('•'); 
			                } else {
			                    // Show 
			                    pwTxt.setEchoChar((char) 0); 
			                    confirmPwTxt.setEchoChar((char) 0);
			                }
			            }
			        });
				  
				  JToggleButton pwtoggleBtn_1 = new JToggleButton("");
					pwtoggleBtn_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
					pwtoggleBtn_1.setSelected(true);
					pwtoggleBtn_1.setBackground(Color.WHITE);
					pwtoggleBtn_1.setBounds(827, 653, 44, 40);
					contentPane.add(pwtoggleBtn_1);
					
					pwtoggleBtn_1.addActionListener(new ActionListener() {
				            @Override
				            public void actionPerformed(ActionEvent e) {
				                if (pwtoggleBtn_1.isSelected()) {
				                    // Hide 
				                    oldpwTxt.setEchoChar('•'); 
				                } else {
				                    // Show 
				                	oldpwTxt.setEchoChar((char) 0); 
				                }
				            }
				        });
		
		
		//head logo
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Edit-Profile.png"));
		lblNewLabel.setBounds(551, 23, 194, 55);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(414, 720, 266, -33);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(834, 697, 194, -22);
		contentPane.add(panel_2);
		
		oldpwTxt = new JPasswordField();
		oldpwTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		oldpwTxt.setColumns(10);
		oldpwTxt.setBounds(452, 653, 375, 40);
		contentPane.add(oldpwTxt);
		
		JLabel lblNewLabel_7_1 = new JLabel("Enter Your Current Password to Update :");
		lblNewLabel_7_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7_1.setBounds(452, 619, 389, 24);
		contentPane.add(lblNewLabel_7_1);
		
		JButton backBtn = new JButton("");
		backBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Back Button.png"));
		backBtn.setToolTipText("Back");
		backBtn.setOpaque(false);
		backBtn.setBorderPainted(false);
		backBtn.setBorder(null);
		backBtn.setBackground(new Color(255, 255, 255, 0));
		backBtn.setBounds(51, 48, 52, 52);
		contentPane.add(backBtn);
		
		JButton deleteAccBtn = new JButton("");
		deleteAccBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\delete-acc-btn.png"));
		deleteAccBtn.setToolTipText("Back");
		deleteAccBtn.setOpaque(false);
		deleteAccBtn.setBorderPainted(false);
		deleteAccBtn.setBorder(null);
		deleteAccBtn.setBackground(new Color(255, 255, 255, 0));
		deleteAccBtn.setBounds(1054, 681, 233, 136);
		contentPane.add(deleteAccBtn);
		
		JButton updateBtn = new JButton("");
		updateBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		updateBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\update-btn.png"));
		updateBtn.setToolTipText("Update Profile");
		updateBtn.setOpaque(false);
		updateBtn.setBorderPainted(false);
		updateBtn.setBorder(null);
		updateBtn.setBackground(new Color(255, 255, 255, 0));
		updateBtn.setBounds(540, 708, 216, 89);
		contentPane.add(updateBtn);
		
		backBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Settings settingss = new Settings(user1);
            	settingss.setVisible(true);
                  dispose();
            }
        });
		
		
		
		LoadTextBoxes();
		
		updateBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        updateProfile();
		    }
		});
		
		deleteAccBtn.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	
		    	deleteAccount();
		    	Login loginPanel = new Login();
            	loginPanel.setVisible(true);
                  dispose();
		    }
		});
	}
	
	public void LoadTextBoxes() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, username, password);


            String selectCommand = "SELECT * FROM users WHERE id = ?";
            PreparedStatement selectStatement = connection.prepareStatement(selectCommand);
            selectStatement.setInt(1, user1.getId()); 

            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {

                int id = resultSet.getInt("id");                   
                String fname = resultSet.getString("firstName");  
                String lname = resultSet.getString("lastName");  
                String email = resultSet.getString("email");     
                String passwordd = resultSet.getString("password"); 
                String mobile = resultSet.getString("mobile");     
                String nic = resultSet.getString("nic");          
                int pin = resultSet.getInt("pin");                
                double balance = resultSet.getDouble("balance");  
                
                fnameTxt.setText(fname);
                lnameTxt.setText(lname);
                emailTxt.setText(email);
                mobileTxt.setText(mobile);
                nicTxt.setText(nic);
            }


            resultSet.close();
            selectStatement.close();
            connection.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
	}
	
	private void updateProfile() {
	    String fname = fnameTxt.getText().trim();
	    String lname = lnameTxt.getText().trim();
	    String email = emailTxt.getText().trim();
	    String mobile = mobileTxt.getText().trim();
	    String nic = nicTxt.getText().trim();
	    String newPassword = new String(pwTxt.getPassword()).trim();
	    String confirmPassword = new String(confirmPwTxt.getPassword()).trim();
	    String oldPassword = oldpwTxt.getText().trim(); 

	    if (fname.isEmpty() || lname.isEmpty() || email.isEmpty() || mobile.isEmpty() || nic.isEmpty()) {
	        JOptionPane.showMessageDialog(null, "Please fill all fields", "Error", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    
	   
	    if (!newPassword.equals(confirmPassword)) {
	        JOptionPane.showMessageDialog(null, "New Passwords do not match", "Warning", JOptionPane.WARNING_MESSAGE);
	        return;
	    }
	    if(oldPassword.isEmpty())
	    {
	        JOptionPane.showMessageDialog(null, "Please Enter current password to Update profile", "Error", JOptionPane.WARNING_MESSAGE);
	        return;
	    }

	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url, username, password);

	        String checkPasswordQuery = "SELECT password FROM users WHERE id = ?";
	        PreparedStatement checkPasswordStmt = connection.prepareStatement(checkPasswordQuery);
	        checkPasswordStmt.setInt(1, user1.getId());
	        ResultSet resultSet = checkPasswordStmt.executeQuery();
	        String dbPassword;
	        if (resultSet.next()) {
	             dbPassword = resultSet.getString("password");
	            if (!dbPassword.equals(oldPassword)) {
	                JOptionPane.showMessageDialog(null, "Current password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
	                return;
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        
	        if (newPassword.isEmpty()) {
	            newPassword = dbPassword;
	        }

	        String updateCommand = "UPDATE users SET firstName = ?, lastName = ?, email = ?, mobile = ?, nic = ?, password = ? WHERE id = ?";
	        PreparedStatement updateStatement = connection.prepareStatement(updateCommand);
	        updateStatement.setString(1, fname);
	        updateStatement.setString(2, lname);
	        updateStatement.setString(3, email);
	        updateStatement.setString(4, mobile);
	        updateStatement.setString(5, nic);
	        updateStatement.setString(6, newPassword); 
	        updateStatement.setInt(7, user1.getId());

	        int rowsAffected = updateStatement.executeUpdate();
	        if (rowsAffected > 0) {
	            oldpwTxt.setText("");
	            JOptionPane.showMessageDialog(null, "Profile updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Profile update failed", "Error", JOptionPane.ERROR_MESSAGE);
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
	
	private void deleteAccount() {
	    int confirmMsg = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete your account?", 
	                                                "Confirm Delete", JOptionPane.YES_NO_OPTION);
	    
	    if (confirmMsg == JOptionPane.YES_OPTION) {
	        JPasswordField passwordField = new JPasswordField();
	        int option = JOptionPane.showConfirmDialog(null, passwordField, "Enter your password to proceed",
	                                                   JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
	        
	        if (option == JOptionPane.OK_OPTION) {
	            String enteredPassword = new String(passwordField.getPassword());

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                Connection connection = DriverManager.getConnection(url, username, password);

	                String checkPasswordQuery = "SELECT password FROM users WHERE id = ?";
	                PreparedStatement checkPasswordStmt = connection.prepareStatement(checkPasswordQuery);
	                checkPasswordStmt.setInt(1, user1.getId());
	                ResultSet resultSet = checkPasswordStmt.executeQuery();

	                if (resultSet.next()) {
	                    String dbPassword = resultSet.getString("password");
	                    
	                    if (!dbPassword.equals(enteredPassword)) {
	                        JOptionPane.showMessageDialog(null, "Current password is incorrect", "Error", JOptionPane.ERROR_MESSAGE);
	                        return; 
	                    }
	                } else {
	                    JOptionPane.showMessageDialog(null, "User not found", "Error", JOptionPane.ERROR_MESSAGE);
	                    return; 
	                }

	                String deleteCommand = "DELETE FROM users WHERE id = ?";
	                PreparedStatement deleteState = connection.prepareStatement(deleteCommand);
	                deleteState.setInt(1, user1.getId());
	                deleteState.executeUpdate();

	                JOptionPane.showMessageDialog(null, "Account successfully deleted.", "Success", JOptionPane.INFORMATION_MESSAGE);

	                resultSet.close();
	                checkPasswordStmt.close();
	                deleteState.close();
	                connection.close();

	                Login loginPanel = new Login();
	                loginPanel.setVisible(true);
	                dispose();

	            } catch (Exception ex) {
	                JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	                ex.printStackTrace();
	            }
	        }
	    }
	}


}
	