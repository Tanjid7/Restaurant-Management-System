package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class HomePage extends JFrame implements ActionListener, MouseListener {

    private JPanel panel;
    private JLabel logo;
    private JButton orderNowBtn, aboutusbtn, exitbtn, staffbtn, adminbtn;

    public HomePage() {

        super("Culinary Canvas");
        setSize(800, 615);

        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 800, 615);
        add(panel);

        orderNowBtn = new JButton("Order Now");
        orderNowBtn.setFont(new Font("Segoe UI", Font.BOLD, 15));
        orderNowBtn.setBounds(60, 472, 171, 36);
        orderNowBtn.setBorder(new LineBorder(Color.BLACK, 2));
        orderNowBtn.setBackground(Color.WHITE);
        orderNowBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        orderNowBtn.setForeground(Color.BLACK);
        orderNowBtn.addMouseListener(this);
        orderNowBtn.addActionListener(this);
        panel.add(orderNowBtn);

        aboutusbtn = new JButton("About Us");
        aboutusbtn.setFont(new Font("Segoe UI", Font.BOLD, 10));
        aboutusbtn.setBounds(665, 30, 96, 36);
        aboutusbtn.setBorder(new LineBorder(Color.BLACK, 2));
        aboutusbtn.setBackground(Color.WHITE);
        aboutusbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        aboutusbtn.setForeground(Color.BLACK);
        aboutusbtn.addMouseListener(this);
        aboutusbtn.addActionListener(this);
        panel.add(aboutusbtn);

        staffbtn = new JButton("Staff Login");
        staffbtn.setFont(new Font("Segoe UI", Font.BOLD, 10));
        staffbtn.setBounds(565, 30, 96, 36);
        staffbtn.setBorder(new LineBorder(Color.BLACK, 2));
        staffbtn.setBackground(Color.WHITE);
        staffbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        staffbtn.setForeground(Color.BLACK);
        staffbtn.addMouseListener(this);
        staffbtn.addActionListener(this);
        panel.add(staffbtn);

        adminbtn = new JButton("Admin Login");
        adminbtn.setFont(new Font("Segoe UI", Font.BOLD, 10));
        adminbtn.setBounds(465, 30, 96, 36);
        adminbtn.setBorder(new LineBorder(Color.BLACK, 2));
        adminbtn.setBackground(Color.WHITE);
        adminbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        adminbtn.setForeground(Color.BLACK);
        adminbtn.addMouseListener(this);
        adminbtn.addActionListener(this);
        panel.add(adminbtn);

        ImageIcon bannerIcon = new ImageIcon("Image/Hompagebanner.png");
        ImageIcon logoIcon = new ImageIcon("Image/logo.png");
        setIconImage(logoIcon.getImage());

        logo = new JLabel(bannerIcon);
        logo.setBounds(0, 0, 800, 580);
        panel.add(logo);

        setVisible(true);
    }

    public void mouseClicked(MouseEvent me) {
    }

    public void mouseEntered(MouseEvent me) {

        if (me.getSource() == orderNowBtn) {
            orderNowBtn.setBackground(Color.decode("#C70909"));
            orderNowBtn.setForeground(Color.WHITE);
        }

        else if (me.getSource() == aboutusbtn) {
            aboutusbtn.setBackground(Color.decode("#C70909"));
            aboutusbtn.setForeground(Color.WHITE);
        }

        else if (me.getSource() == staffbtn) {
            staffbtn.setBackground(Color.decode("#C70909"));
            staffbtn.setForeground(Color.WHITE);
        }

        else if (me.getSource() == adminbtn) {
            adminbtn.setBackground(Color.decode("#C70909"));
            adminbtn.setForeground(Color.WHITE);
        }
    }

    public void mouseExited(MouseEvent me) {
        if (me.getSource() == orderNowBtn) {
            orderNowBtn.setBackground(Color.WHITE);
            orderNowBtn.setForeground(Color.BLACK);
        } else if (me.getSource() == aboutusbtn) {
            aboutusbtn.setBackground(Color.WHITE);
            aboutusbtn.setForeground(Color.BLACK);
        } else if (me.getSource() == exitbtn) {
            exitbtn.setBackground(Color.WHITE);
            exitbtn.setForeground(Color.BLACK);
        } else if (me.getSource() == staffbtn) {
            staffbtn.setBackground(Color.WHITE);
            staffbtn.setForeground(Color.BLACK);
        } else if (me.getSource() == adminbtn) {
            adminbtn.setBackground(Color.WHITE);
            adminbtn.setForeground(Color.BLACK);
        }
    }

    public void mousePressed(MouseEvent me) {
    }

    public void mouseReleased(MouseEvent me) {
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == orderNowBtn) {
            new CustomerSignIn();
            this.setVisible(false);
        } else if (e.getSource() == aboutusbtn) {
            new AboutUs();
            this.setVisible(false);
        } else if (e.getSource() == staffbtn) {
            // new Stafflogin();
            this.setVisible(false);
        } else if (e.getSource() == adminbtn) {
            new AdminSignIn();
            this.setVisible(false);
        }
    }
}
