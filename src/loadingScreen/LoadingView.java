package loadingScreen;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class LoadingView extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JLabel lblLoading;

    public LoadingView() {
        setTitle("Welcome to EzWallet");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-logo.png"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(330, 100, 1289, 779);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        progressBar = new JProgressBar();
        progressBar.setBounds(178, 524, 918, 32);
        contentPane.add(progressBar);

        lblLoading = new JLabel("Loading... 0%"); // Initialize with 0%
        lblLoading.setHorizontalAlignment(SwingConstants.CENTER);
        lblLoading.setForeground(Color.BLACK);
        lblLoading.setFont(new Font("Sofia Pro", Font.PLAIN, 29));
        lblLoading.setBounds(562, 474, 150, 28);
        contentPane.add(lblLoading);

        JLabel lblLogo = new JLabel("");
        lblLogo.setIcon(new ImageIcon("C:\\Users\\yashm\\Documents\\ezwallet-assets\\ezwallet-big-logo.png"));
        lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogo.setForeground(Color.BLACK);
        lblLogo.setFont(new Font("Sofia Pro", Font.PLAIN, 29));
        lblLogo.setBounds(409, 158, 456, 157);
        contentPane.add(lblLogo);
    }

    public void setProgress(int progress) {
        SwingUtilities.invokeLater(() -> {
            lblLoading.setText("Loading... " + progress + "%"); // Update the label text
            progressBar.setValue(progress); // Update the progress bar value
        });
    }
}
