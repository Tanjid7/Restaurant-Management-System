package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class Staffdashboard extends JFrame implements ActionListener {

    private JButton lgout;

    public Staffdashboard(String user) {
        super("Staff Dashboard");
        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        setTitle("APNA RESTAURANT");
        setBounds(0, 0, 900, 600);
        setLayout(null);
		setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        lgout = new JButton("Go Back");
        lgout.setBounds(440, 380, 120, 30);
        lgout.setFocusable(false);
        lgout.setBackground(Color.decode("#BF1A1A"));
        lgout.setForeground(Color.decode("#FFFFFF"));
        lgout.setFont(new Font("Segoe UI", 1, 18));
        lgout.setBorder(new LineBorder(Color.decode("#000000"), 2));
        lgout.addActionListener(this);
        lgout.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(lgout); 
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == lgout) {
            new Stafflogin();
            setVisible(false);
        }
    }
}

