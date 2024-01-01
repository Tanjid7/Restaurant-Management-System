package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class AboutUs extends JFrame implements ActionListener {

    private JLabel logo;
    private JButton gobackbtn;

    public AboutUs() {

        super("Culinary Canvas");
        setSize(800, 630);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gobackbtn = new JButton("Back");
        gobackbtn.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gobackbtn.setBounds(30, 540, 100, 30);
        gobackbtn.setBorder(new LineBorder(Color.BLACK, 2));
        gobackbtn.setBackground(Color.WHITE);
        gobackbtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        gobackbtn.setForeground(Color.BLACK);
        gobackbtn.addActionListener(this);
        gobackbtn.setFocusable(false);
        add(gobackbtn);

        ImageIcon bannerIcon = new ImageIcon("Image/abouus.png");
        ImageIcon logoIcon = new ImageIcon("Image/logo.png");
        setIconImage(logoIcon.getImage());

        logo = new JLabel(bannerIcon);
        logo.setBounds(0, 0, 800, 600);
        add(logo);

        setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gobackbtn) {
            new HomePage();
            this.setVisible(false);
            this.dispose();
        }
    }
}
