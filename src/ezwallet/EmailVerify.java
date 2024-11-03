package ezwallet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import java.util.Random;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmailVerify extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel statusLabel;

    private String email; 
    private String fname; 
    private String lname; 
    private String password1; 
    private String mobile; 
    private String nic; 
    private int pin; 

    private String verificationCode;  
    private JTextField codeTxt;
    private JButton verifyBtn;

    String url="jdbc:mysql://localhost:3306/ez-wallet-db";
    String username="root";
    String password="";

    public EmailVerify(String firstName, String lastName, String email, String password1, String mobile, String nic, int pin) {
        this.fname = firstName;
        this.lname = lastName;
        this.email = email; 
        this.password1 = password1;
        this.mobile = mobile;
        this.nic = nic;
        this.pin = pin;

        if (isEmailRegistered(email)) {
            JOptionPane.showMessageDialog(this, "This email is already registered. Please use a different email.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            dispose(); 
            Register registerPanel1 = new Register();
            registerPanel1.setVisible(true); 
            return; 
        }
        initialize();
        sendVerificationEmail(email); 
    }

    private boolean isEmailRegistered(String email) {
        boolean exists = false;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String checkEmailQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
            PreparedStatement checkStatement = connection.prepareStatement(checkEmailQuery);
            checkStatement.setString(1, email);
            ResultSet resultSet = checkStatement.executeQuery();

            if (resultSet.next()) {
                exists = resultSet.getInt(1) > 0; 
            }
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error happened: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
        return exists;
    }

    private void initialize() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
        setResizable(false);
        setTitle("Ez-Wallet");
        setBounds(330, 250, 718, 502);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\verify-mail-head.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_2.setBounds(160, 46, 294, 52);
        contentPane.add(lblNewLabel_2);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Sofia Pro", Font.PLAIN, 16));
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        statusLabel.setBounds(92, 274, 519, 45);
        contentPane.add(statusLabel);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(92, 113, 519, 130);
        contentPane.add(panel);

        codeTxt = new JTextField();
        codeTxt.setHorizontalAlignment(SwingConstants.CENTER);
        codeTxt.setFont(new Font("Tahoma", Font.PLAIN, 23));
        codeTxt.setColumns(10);
        codeTxt.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        codeTxt.setBounds(112, 75, 294, 45);
        panel.add(codeTxt);

        JLabel lblNewLabel_1 = new JLabel("Enter the code we've sent to your email:");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png"));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(32, 10, 487, 70);
        panel.add(lblNewLabel_1);

        verifyBtn = new JButton("");
        verifyBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\verify-btn.png"));
        verifyBtn.setToolTipText("Verify");
        verifyBtn.setOpaque(false);
        verifyBtn.setBorderPainted(false);
        verifyBtn.setBorder(null);
        verifyBtn.setBackground(new Color(255, 255, 255, 0));
        verifyBtn.setBounds(244, 329, 216, 89);
        contentPane.add(verifyBtn);

        verifyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codeEntered = codeTxt.getText();
                if (codeEntered.equals(verificationCode)) {
                    JOptionPane.showMessageDialog(EmailVerify.this, "Email Verified & Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    insertUserData();
                    Login loginForm = new Login();
                    loginForm.setVisible(true);
                    dispose(); 
                } else {
                    statusLabel.setText("Incorrect verification code. Please try again.");
                }
            }
        });
        setVisible(true);
    }

    private String generateVerificationCode() {
        Random rand = new Random();
        return String.format("%06d", rand.nextInt(1000000));
    }

    private void sendVerificationEmail(String email) {
        verificationCode = generateVerificationCode();

        String from = "ezwalletlk@gmail.com";  
        String password = "nlzw qrhg cuvv qtyv";  
        String subject = "Your Verification Code";

        String message = "<html>"
                + "<head>"
                + "<style>"
                + "body { font-family: Arial, sans-serif; background-color: #f4f4f4; padding: 20px; }"
                + ".container { background-color: #ffffff; border-radius: 8px; padding: 20px; box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1); }"
                + "h2 { color: #333; }"
                + "h4 { color: #333; }"
                + ".code { font-size: 24px; font-weight: bold; color: #ff5722; }"
                + ".footer { font-size: 12px; color: #999; margin-top: 20px; }"
                + "</style>"
                + "</head>"
                + "<body>"
                + "<div class='container'><center>"
                + "<h2>Your EZ-Wallet Verification Code</h2>"
                + "<h4>Hello " + fname + "!</h4>"
                + "<h3>Your verification code is: <span class='code'>" + verificationCode + "</span></h3>"
                + "<p>Please enter this code in the application to verify your email address.</p>"
                // + "<center><img src='https://i.ibb.co/KLrZ6PN/Blue-Geometric-Minimalist-Finance-Logo-9.png' alt='Ez-Wallet Logo' style='width: 250px; height: auto;' /></center>"
                + "<p class='footer'>Thank you for using Ez-Wallet!</p>"
                + "</center></div>"
                + "</body>"
                + "</html>";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        try {
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(from));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
            msg.setSubject(subject);
            
            msg.setContent(message, "text/html");

            Transport.send(msg);
            statusLabel.setText("Verification code sent to " + email);
        } catch (MessagingException e) {
            statusLabel.setText("Error sending email.");
            e.printStackTrace();
        }
    }

    public void insertUserData() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);
            String insertQuery = "INSERT INTO users (firstName, lastName, email, password, mobile, nic, pin, balance) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
            insertStatement.setString(1, fname);
            insertStatement.setString(2, lname);
            insertStatement.setString(3, email);
            insertStatement.setString(4, password1);
            insertStatement.setString(5, mobile);
            insertStatement.setString(6, nic);
            insertStatement.setInt(7, pin);
            insertStatement.setDouble(8, 0.00);
            insertStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error happened: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
