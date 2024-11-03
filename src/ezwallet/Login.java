package ezwallet;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;


public class Login extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel1;
    private JTextField textField;
    private JTextField passwordfield;
    private JTextField emailfield;
    
    private String url = "jdbc:mysql://localhost:3306/ez-wallet-db";
    private String username = "root"; 
    private String password = "";  


    public Login() {
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
        panel.setBounds(304, 191, 666, 280);
        contentPane.add(panel);
        panel.setLayout(null);
        

        emailfield = new JTextField();
        emailfield.setToolTipText("Enter your email");
        emailfield.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
        emailfield.setBounds(164, 69, 431, 45);
        panel.add(emailfield);
        emailfield.setFont(new Font("Tahoma", Font.PLAIN, 21));
        emailfield.setColumns(10);
        
                lblNewLabel = new JLabel(" Email :");
                lblNewLabel.setBounds(10, 58, 134, 70);
                panel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                        lblNewLabel.setIcon(scaledIcon); // Set the scaled icon to the JLabel
                        

                        passwordfield = new JPasswordField();
                        passwordfield.setToolTipText("Enter the password");
                        passwordfield.setBorder(new LineBorder(new Color(171, 173, 179), 1, true));
                        passwordfield.setBounds(164, 168, 388, 45);
                        panel.add(passwordfield);
                        passwordfield.setFont(new Font("Tahoma", Font.PLAIN, 21));
                        passwordfield.setColumns(10);
                        
                        
                        lblNewLabel1 = new JLabel("Password :");
                        lblNewLabel1.setBounds(10, 157, 144, 70);
                        panel.add(lblNewLabel1);
                        lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 20));
                        
                                lblNewLabel1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\key-square.png"));
                                
                                JToggleButton pwtoggleBtn = new JToggleButton("");
                                pwtoggleBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\pw-toggle.png"));
                                pwtoggleBtn.setSelected(true);
                                pwtoggleBtn.setBackground(Color.WHITE);
                                pwtoggleBtn.setBounds(551, 168, 44, 45);
                                panel.add(pwtoggleBtn);
                                
                                pwtoggleBtn.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent e) {
                                        if (pwtoggleBtn.isSelected()) {
                                            ((JPasswordField) passwordfield).setEchoChar('•');
                                        } else {
                                            ((JPasswordField) passwordfield).setEchoChar((char) 0); 
                                        }
                                    }
                                });

        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Login.png"));
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        lblNewLabel_1.setBounds(521, 10, 233, 151);
        contentPane.add(lblNewLabel_1);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(465, 588, 355, 48);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Don't have a account yet? ");
        lblNewLabel_2.setBounds(21, 13, 217, 22);
        panel_1.add(lblNewLabel_2);
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JButton registerBtn = new JButton("Register");
        registerBtn.setToolTipText("Register now");
        registerBtn.setForeground(Color.BLUE);
        registerBtn.setOpaque(false);  // Makes the background transparent
        registerBtn.setContentAreaFilled(false);  // Removes the background fill
        registerBtn.setBorderPainted(false);  // Removes the border
        registerBtn.setBounds(215, 10, 107, 28);
        panel_1.add(registerBtn);
        registerBtn.setFont(new Font("Tahoma", Font.PLAIN, 17));
        
        JButton LoginBtn = new JButton("");
        LoginBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        LoginBtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\login-btn.png"));
        LoginBtn.setToolTipText("Login");
        LoginBtn.setOpaque(false);
        LoginBtn.setBorderPainted(false);
        LoginBtn.setBorder(null);
        LoginBtn.setBackground(new Color(255, 255, 255, 0));
        LoginBtn.setBounds(529, 481, 216, 89);
        contentPane.add(LoginBtn);
        
        registerBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 Register registerForm = new Register();
            	 registerForm.setVisible(true);
                 
                 dispose(); 
            }
        });
        
        LoginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailfield.getText();
                String password1 = passwordfield.getText();

                if (email.isEmpty() || password1.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please fill email and password.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");

                    Connection connection = DriverManager.getConnection(url, username, password);

                    String query = "SELECT * FROM users WHERE email = ? AND password = ?";
                    PreparedStatement statement = connection.prepareStatement(query);
                    statement.setString(1, email);
                    statement.setString(2, password1);

                    ResultSet resultSet = statement.executeQuery();

                    if (resultSet.next()) {
                        int uid = resultSet.getInt("id");
                        String fname = resultSet.getString("firstName");
                        String lname = resultSet.getString("lastName");
                        String mobile = resultSet.getString("mobile");
                        String nic = resultSet.getString("nic");
                        int pin = resultSet.getInt("pin");
                        double balance = resultSet.getDouble("balance");

                       user user1 = new user(uid,fname, lname, email, mobile, nic, pin, balance);
                       
                       //total outcomes
                       String totalAmountQuery = "SELECT SUM(amount) FROM transactions WHERE sender_id = ?";
                       PreparedStatement totalAmountStatement = connection.prepareStatement(totalAmountQuery);
                       totalAmountStatement.setInt(1, uid);

                       ResultSet totalAmountResult = totalAmountStatement.executeQuery();
                       if (totalAmountResult.next()) {
                           double totalOutcome = totalAmountResult.getDouble(1);
                           user1.setTotalOutcome(totalOutcome); 
                       }
                       
                       //total incomes
                       String totalIncomeQuery = "SELECT SUM(amount) FROM transactions WHERE receiver_id = ?";
                       PreparedStatement totalIncomeStatement = connection.prepareStatement(totalIncomeQuery);
                       totalIncomeStatement.setInt(1, uid); 

                       ResultSet totalIncomeResult = totalIncomeStatement.executeQuery(); 
                       if (totalIncomeResult.next()) {
                           double totalIncome = totalIncomeResult.getDouble(1);
                           user1.setTotalIncome(totalIncome); 
                       }


                       dashboard dashboard = new dashboard(user1);
                       dashboard.setVisible(true);
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid email or password.", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                    connection.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
   /* public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame1 = new Login();
                    frame1.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/
    }
    
    

