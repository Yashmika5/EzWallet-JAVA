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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Cursor;

public class profile extends JFrame {
	


	private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private JTextField textField;
    private JLabel NameTxt;
    private JLabel EmailTxt;
    private JLabel MbileTxt;
    private JLabel NicTxt;
    private JLabel PayIdTxt;
    
    private user user1;
    
    String url="jdbc:mysql://localhost:3306/ez-wallet-db";
   	String username="root";
   	String password="";

	
	public profile(user user1) {
		this.user1 = user1;
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
		setResizable(false);
    	setTitle("Ez-Wallet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(330, 100, 1269, 808);
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
        panel.setBounds(364, 150, 527, 471);
        contentPane.add(panel);
        panel.setLayout(null);
        
                lblNewLabel = new JLabel("Name :");
                lblNewLabel.setBounds(10, 10, 118, 70);
                panel.add(lblNewLabel);
                lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
                
                        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\profile.png"));
                                
                                JLabel lblNotes = new JLabel("Email :");
                                lblNotes.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\email.png"));
                                lblNotes.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblNotes.setBounds(10, 105, 118, 70);
                                panel.add(lblNotes);
                                
                                JLabel lblMobile = new JLabel("Mobile :");
                                lblMobile.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\call-calling.png"));
                                lblMobile.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblMobile.setBounds(10, 200, 118, 70);
                                panel.add(lblMobile);
                                
                                JLabel lblNic = new JLabel("NIC :");
                                lblNic.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\id.png"));
                                lblNic.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblNic.setBounds(10, 295, 118, 70);
                                panel.add(lblNic);
                                
                                JLabel lblPayId = new JLabel("Pay ID :");
                                lblPayId.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\fingerprint.png"));
                                lblPayId.setFont(new Font("Tahoma", Font.BOLD, 20));
                                lblPayId.setBounds(10, 390, 118, 70);
                                panel.add(lblPayId);
                                
                                 NameTxt = new JLabel("nameTxt");
                                NameTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
                                NameTxt.setBounds(152, 10, 366, 70);
                                panel.add(NameTxt);
                                
                                 EmailTxt = new JLabel("emailTxt");
                                EmailTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
                                EmailTxt.setBounds(152, 105, 366, 70);
                                panel.add(EmailTxt);
                                
                                 MbileTxt = new JLabel("mobileTxt");
                                MbileTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
                                MbileTxt.setBounds(152, 200, 366, 70);
                                panel.add(MbileTxt);
                                
                                 NicTxt = new JLabel("nicTxt");
                                NicTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
                                NicTxt.setBounds(152, 295, 366, 70);
                                panel.add(NicTxt);
                                
                                 PayIdTxt = new JLabel("payidTxt");
                                PayIdTxt.setFont(new Font("Tahoma", Font.BOLD, 20));
                                PayIdTxt.setBounds(152, 390, 366, 70);
                                panel.add(PayIdTxt);
        ImageIcon logoIcon = new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Blue Geometric Minimalist Finance Logo (2).png");
        Image logoImg = logoIcon.getImage();
        Image scaledLogoImg = logoImg.getScaledInstance(261, 90, Image.SCALE_SMOOTH);
        
        JButton backbtn = new JButton("");
        backbtn.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Back Button.png"));
        backbtn.setToolTipText("Back");
        backbtn.setOpaque(false);
        backbtn.setBorderPainted(false);
        backbtn.setBorder(null);
        backbtn.setBackground(new Color(255, 255, 255, 0));
        backbtn.setBounds(73, 59, 52, 52);
        contentPane.add(backbtn);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\Profile-head.png"));
        lblNewLabel_1.setBounds(569, 41, 117, 45);
        contentPane.add(lblNewLabel_1);
        
        backbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dashboard db2 = new dashboard(user1);
      	        db2.setVisible(true);
                  dispose();
            }
        });
        
        LoadLabelss();
    }
	
	public void LoadLabelss() {
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
                int payId = resultSet.getInt("id");  

                
                NameTxt.setText(fname + " " + lname);  
                EmailTxt.setText(email);
                MbileTxt.setText(mobile);
                NicTxt.setText(nic);
                PayIdTxt.setText(String.valueOf(payId));  
            }


            resultSet.close();
            selectStatement.close();
            connection.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace(); 
        }
	}
	
	}
