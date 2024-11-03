package ezwallet;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.Cursor;

public class Register extends JFrame {

    private static JTextField fnameTxt;
    private static JTextField lnameTxt;
    private static JTextField emailTxt;
    private static JPasswordField pwTxt;
    private static JTextField mobileTxt;
    private static JTextField nicTxt;
    private static JPasswordField confirmPwTxt;
    private static JTextField pinNoTxt;

    public Register() {
        setTitle("EZ-Wallet");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(330, 100, 1305, 835);
        
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel panel = new JPanel();
        panel.setToolTipText("Show/Hide Password");
        panel.setBounds(140, 128, 1010, 466);
        contentPane.add(panel);
        panel.setLayout(null);
        
        // First Name
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
        
        // Last Name
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
        
        // Email
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
        
        // Mobile Number
        JLabel lblNewLabel_4 = new JLabel("Mobile :");
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
        
        // Password
        JLabel lblNewLabel_5 = new JLabel("Password :");
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\key-square.png"));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(12, 253, 139, 24);
        panel.add(lblNewLabel_5);
        
        pwTxt = new JPasswordField();
        pwTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pwTxt.setBounds(10, 287, 397, 40);
        panel.add(pwTxt);
        pwTxt.setColumns(10);
        
        // Confirm Password
        JLabel lblNewLabel_6 = new JLabel("Confirm Password :");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\key-square.png"));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_6.setBounds(573, 253, 221, 24);
        panel.add(lblNewLabel_6);
        
        confirmPwTxt = new JPasswordField();
        confirmPwTxt.setBounds(574, 287, 431, 40);
        panel.add(confirmPwTxt);
        confirmPwTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        confirmPwTxt.setColumns(10);
        
        // NIC Number
        JLabel lblNewLabel_7 = new JLabel("NIC Number :");
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\id.png"));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_7.setBounds(12, 363, 151, 24);
        panel.add(lblNewLabel_7);
        
        nicTxt = new JTextField();
        nicTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        nicTxt.setBounds(10, 397, 431, 40);
        panel.add(nicTxt);
        nicTxt.setColumns(10);
        
        // Pin Number
        JLabel lblNewLabel_8 = new JLabel("Pin Number :");
        lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pin.png"));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_8.setBounds(573, 363, 190, 24);
        panel.add(lblNewLabel_8);
        
        pinNoTxt = new JTextField();
        pinNoTxt.setBounds(574, 397, 431, 40);
        panel.add(pinNoTxt);
        pinNoTxt.setFont(new Font("Tahoma", Font.PLAIN, 20));
        pinNoTxt.setColumns(10);
        
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
        
        // Register logo
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Register.png"));
        lblNewLabel.setBounds(529, 0, 232, 131);
        contentPane.add(lblNewLabel);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(481, 719, 329, 24);
        contentPane.add(panel_3);
        panel_3.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Login");
        btnNewButton_1.setForeground(Color.BLUE);
        btnNewButton_1.setOpaque(false);  
        btnNewButton_1.setContentAreaFilled(false);  
        btnNewButton_1.setBorderPainted(false);  
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnNewButton_1.setBounds(220, 0, 85, 24);
        panel_3.add(btnNewButton_1);

        
        JLabel lblNewLabel_9 = new JLabel("Already have an Account?");
        lblNewLabel_9.setBounds(20, 0, 225, 22);
        panel_3.add(lblNewLabel_9);
        lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JButton registerbtn = new JButton("");
        registerbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        registerbtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\register-btn.png"));
        registerbtn.setToolTipText("Register now");
        registerbtn.setOpaque(false);
        registerbtn.setBorderPainted(false);
        registerbtn.setBorder(null);
        registerbtn.setBackground(new Color(255, 255, 255, 0));
        registerbtn.setBounds(537, 611, 216, 89);
        contentPane.add(registerbtn);
        
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Login loginForm = new Login();
            	 loginForm.setVisible(true);
                 
                 dispose(); 
            }
        });
            
        
        registerbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = fnameTxt.getText();
                String lastName = lnameTxt.getText();
                String email = emailTxt.getText();
                String password = new String(pwTxt.getPassword());
                String confirmPassword = new String(confirmPwTxt.getPassword());
                String mobile = mobileTxt.getText();
                String nic = nicTxt.getText();
                String pinStr = pinNoTxt.getText();
                
                if (firstName.isEmpty() || lastName.isEmpty() || email.isEmpty() || 
                        password.isEmpty() || confirmPassword.isEmpty() || mobile.isEmpty() || 
                        nic.isEmpty() || pinStr.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill all the fields.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }

                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(null, "Passwords not matching.", "Password Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
                
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(null, "Invalid email address.", "Email Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
                
                int pin;
                try {
                    pin = Integer.parseInt(pinStr); 
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid PIN number. Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; 
                }
        
                EmailVerify verifyframe = new EmailVerify(firstName, lastName, email, password, mobile, nic, pin);
                verifyframe.setVisible(true);
                
                dispose(); // Close the registration window
            }

            private boolean isValidEmail(String email) {
                String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
                Pattern pattern = Pattern.compile(emailRegex);
                return pattern.matcher(email).matches();
            }
        });
        
        setVisible(true);
    }

   
}
