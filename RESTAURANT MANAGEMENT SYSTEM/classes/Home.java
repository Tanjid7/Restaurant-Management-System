package classes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Home extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel labelSystemPanel, labelDashboard, labelImg, headline;
    private JButton buttonCategories, buttonStaffReport, buttonProducts, buttonReports, buttonLogout;
    private ImageIcon img, iconCategories, iconStaffReport, iconProducts, iconReports, iconLogout;
    private Font ff, fff;
    private User x;

    public Home(User a) {

        x = a;

        setTitle("Dashboard: Restaurant Management System");
        setSize(1050, 700);
        setLocationRelativeTo(null);
        setResizable(false);

        ImageIcon frameIcon = new ImageIcon("Image/logo.png");
        setIconImage(frameIcon.getImage());

        ff = new Font("Arial", Font.BOLD, 18);
        fff = new Font("Arial", Font.BOLD, 28);

        panel = new JPanel(null);
        panel.setBackground(new Color(173, 216, 230));

        ImageIcon bannerIcon = new ImageIcon("Image/rsz_adminhome.png");
        // Image scaledImage = bannerIcon.getImage().getScaledInstance(830, 600,
        // Image.SCALE_SMOOTH);
        // ImageIcon img = new ImageIcon(scaledImage);

        labelImg = new JLabel(bannerIcon);
        labelImg.setBounds(205, 60, 830,600);
        panel.add(labelImg);

        labelSystemPanel = new JLabel("SYSTEM PANEL");
        labelSystemPanel.setBounds(35, -15, 230, 90);
        labelSystemPanel.setFont(ff);
        labelSystemPanel.setForeground(Color.darkGray);
        panel.add(labelSystemPanel);

        labelDashboard = new JLabel("_____________________________________________");
        labelDashboard.setBounds(380, 0, 800, 90);
        labelDashboard.setFont(ff);
        labelDashboard.setForeground(Color.darkGray);
        panel.add(labelDashboard);

        headline = new JLabel("Restaurant Management System");
        headline.setBounds(400, -55, 650, 160);
        headline.setFont(fff);
        headline.setForeground(Color.black);
        panel.add(headline);

        buttonCategories = new JButton("Categories", iconCategories);
        buttonCategories.setBounds(50, 60, 150, 30);
        buttonCategories.setFont(ff);
        panel.add(buttonCategories);

        buttonStaffReport = new JButton("Staff", iconStaffReport);
        buttonStaffReport.setBounds(50, 120, 150, 30);
        buttonStaffReport.setFont(ff);
        panel.add(buttonStaffReport);

        buttonProducts = new JButton("Products", iconProducts);
        buttonProducts.setBounds(50, 180, 150, 30);
        buttonProducts.setFont(ff);
        panel.add(buttonProducts);

        buttonReports = new JButton("Reports", iconReports);
        buttonReports.setBounds(50, 240, 150, 30);
        buttonReports.setFont(ff);
        panel.add(buttonReports);

        buttonLogout = new JButton("Logout", iconLogout);
        buttonLogout.setBounds(50, 600, 150, 30);
        buttonLogout.setFont(ff);
        panel.add(buttonLogout);

        add(panel);

        // Add action listeners
        buttonLogout.addActionListener(this);
        buttonStaffReport.addActionListener(this);
        buttonReports.addActionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonLogout) {
            new HomePage();
            dispose();
        }
        if (e.getSource() == buttonStaffReport) {
            new UserData(x);
            dispose();
        } else if (e.getSource() == buttonReports) {
            new Accounts(x);
            setVisible(false);
        }
    }

}
