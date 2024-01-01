package classes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AdminAdd extends JFrame implements ActionListener {

    private JFrame frame;
    private JLabel back1;
    private JLabel back2;
    private JLabel label1;
    private JLabel userName;
    private JLabel userPass;
    private JLabel email;
    private JTextField tfUName;
    private JPasswordField pfUPass;
    private JTextField tfemail;
    private JButton addUser, back;

    private User x;

    public AdminAdd(User a) {
        x = a;

        frame = new JFrame("Admin Add");

        ImageIcon framelogo = new ImageIcon("Image/logo.png");
        setIconImage(framelogo.getImage());

        label1 = new JLabel("Admin Add");
        label1.setForeground(Color.decode("#C70909"));
        label1.setFont(new Font("Forte", Font.PLAIN, 40));
        label1.setBounds(150, 50, 250, 60);
        frame.add(label1);

        userName = new JLabel("Username: ");
        userName.setBounds(130, 180, 100, 30);
        userName.setFont(new Font("Calibri", Font.BOLD, 16));
        userName.setForeground(Color.black);
        frame.add(userName);

        userPass = new JLabel("Password: ");
        userPass.setBounds(130, 220, 100, 30);
        userPass.setFont(new Font("Calibri", Font.BOLD, 16));
        userPass.setForeground(Color.black);
        frame.add(userPass);

        tfUName = new JTextField();
        tfUName.setBounds(210, 180, 140, 23);
        tfUName.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 1));
        tfUName.setToolTipText("Enter your name here");
        frame.add(tfUName);

        pfUPass = new JPasswordField();
        pfUPass.setBounds(210, 220, 140, 23);
        pfUPass.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 1));
        pfUPass.setEchoChar('*');
        pfUPass.setToolTipText("Enter your password here");
        frame.add(pfUPass);

        email = new JLabel("Email: ");
        email.setBounds(150, 260, 100, 30);
        email.setFont(new Font("Calibri", Font.BOLD, 16));
        email.setForeground(Color.black);
        frame.add(email);

        tfemail = new JTextField();
        tfemail.setBounds(210, 260, 140, 23);
        tfemail.setBorder(BorderFactory.createLineBorder(Color.decode("#000000"), 1));
        tfemail.setToolTipText("Your Email Address?");
        frame.add(tfemail);

        addUser = new JButton("Add User");
        addUser.setBounds(180, 340, 100, 30);
        addUser.setFocusable(false);
        addUser.setBackground(Color.decode("#C70909"));
        addUser.setForeground(Color.decode("#FFFFFF"));
        addUser.setBorder(BorderFactory.createEtchedBorder());
        addUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addUser.addActionListener(this);
        // addUser.addMouseListener(this);
        frame.add(addUser);

        back = new JButton("Back");
        back.setBounds(200, 390, 100, 30);
        back.addActionListener(this);
        frame.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == addUser) {
            String textField1 = tfUName.getText();
            String textField2 = pfUPass.getText();
            String textField3 = tfemail.getText();

            if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            } else {

                try {
                    File file = new File("data\\.user_data.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                    String timeAndDate = myDateObj.format(myFormatObj);

                    pw.println("             ## Added by Admin ##");
                    pw.println("User Name : " + textField1);
                    pw.println("Password : " + textField2);
                    pw.println("Email : " + textField3);
                    pw.println("Time & Date : " + timeAndDate);
                    pw.println("===============================================");
                    pw.close();

                } catch (Exception ex) {
                    System.out.print(ex);
                }

                JOptionPane.showMessageDialog(null, "User has been added.", "User Added",
                        JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
                new UserData(x);
            }

        } else if (e.getSource() == back) {
            new UserData(x);
            frame.setVisible(false);
        }

    }
}
